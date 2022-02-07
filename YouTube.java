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
        URL url = new URL("https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=3&q=" + searchRequest + "&key=" + key);
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
        ArrayList<Video> rawVideo = new ArrayList<Video>();
        Reader inputString = new StringReader(response);
        BufferedReader reader = new BufferedReader(inputString);
        String line;
        String id = "";
        String title = "";
        String thumbnail = "";
        String channel = "";
        String pub = "";
        while ((line = reader.readLine()) != null) {
            if (line.contains("videoId")){
                id = line.replace("\"videoId\": \"","");
                id = id.substring(0, id.length() - 1).trim();
            }
            if (line.contains("title")){
                title = line.replace("\"title\": \"","");
                title = title.substring(0, title.length() - 2).trim();
            }  
            if (line.contains("/default.jpg")){
                thumbnail = line.replace("\"title\": \"","");
                thumbnail = line.replace("\"url\": \"","");
                thumbnail = thumbnail.substring(0, thumbnail.length() - 2).trim();
            }  
            if (line.contains("channelTitle")){
                channel = line.replace("\"channelTitle\": \"","");
                channel = channel.substring(0, channel.length() - 2).trim();
            }  
            if (line.contains("publishTime")){
                pub = line.replace("\"publishTime\": \"","");
                pub = pub.substring(0, pub.length() - 1).trim();
                rawVideo.add(new Video(id, title, thumbnail, channel, pub));
            }  
        }
        http.disconnect();
        return rawVideo;
    }
}