import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

// https://reqbin.com/curl
// https://reqbin.com/req/c-1n4ljxb9/curl-get-request-example
// https://blog.cpming.top/p/httpurlconnection-post-raw

class YouTube{
    public static ArrayList<Video> getUrl(String searchRequest, String key) throws IOException{
        URL url = new URL("https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=5&q=" + searchRequest + "&key=" + key);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestProperty("Accept", "application/json");

        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
        String response = "";
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = http.getInputStream().read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        response = result.toString();
        // System.out.println(response);

        ArrayList<Video> rawVideo = new ArrayList<Video>();
        Reader inputString = new StringReader(response);
        BufferedReader reader = new BufferedReader(inputString);
        String line;
        String tempID = "";
        String tempTitle = "";
        String id = "";
        String title = "";
        while ((line = reader.readLine()) != null) {
            if (line.contains("videoId")){
                tempID = line.replace("\"videoId\": \"","");
                id = tempID.substring(0, tempID.length() - 1).trim();
            }
            if (line.contains("title")){
                tempTitle = line.replace("\"title\": \"","");
                title = tempTitle.substring(0, tempTitle.length() - 2).trim();
                rawVideo.add(new Video(id, title));
            }  
        }
        http.disconnect();
        return rawVideo;
    }
}