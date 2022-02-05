import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// https://reqbin.com/curl
// https://reqbin.com/req/c-1n4ljxb9/curl-get-request-example
// https://blog.cpming.top/p/httpurlconnection-post-raw

class YouTube{
    public static void getUrl(String searchRequest) throws IOException{
        URL url = new URL("https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=5&q=" + searchRequest + "&key=AIzaSyBNoxsjxorQfXNDwHa9a2fvlXUObZGtINM");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestProperty("Accept", "application/json");

        System.out.println(http.getResponseCode() + " " + http.getResponseMessage() + " ");
        String response = "";
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = http.getInputStream().read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        response = result.toString();
        System.out.println(response);
        http.disconnect();
    }
}