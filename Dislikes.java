import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
 
// https://www.techiedelight.com/send-http-get-request-java/

public class Dislikes{
  public static int numOfVideos = 0;

  public static ArrayList<Video> getRatio(ArrayList<Video> rawVideo) throws Exception {
    String videoIDs[] = new String[rawVideo.size()];
    for (int i = 0; i < rawVideo.size(); i++){
      videoIDs[i] = rawVideo.get(i).getVideoID();
    }
    String id = null;
    int likes = 0;
    int dislikes = 0;
    int views = 0;
    ArrayList<Video> videoInfo = new ArrayList<Video>();
    for (int temp = 0; temp < videoIDs.length; temp++){
      URL url = new URL("https://returnyoutubedislikeapi.com/votes?videoId=" + videoIDs[temp]);
      URLConnection connection = url.openConnection();
      try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
        String line;
        while ((line = in.readLine()) != null) {
          String[] information = line.split(",");
          for (int i = 0; i < information.length; i++){
            if (information[i].contains("id")){
              String tempid = information[i].replace("{\"id\":\"","");
              String result = tempid.substring(0, tempid.length() - 1);
              id = result;
            }
            if (information[i].contains("\"likes\":")){
              String templikes = information[i].replace("\"likes\":","");
              likes = Integer.parseInt(templikes);
            }
            if (information[i].contains("dislikes")){
              String tempdislikes = information[i].replace("\"dislikes\":","");
              dislikes = Integer.parseInt(tempdislikes);
            }
            if (information[i].contains("\"viewCount\":")){
              String tempviews = information[i].replace("\"viewCount\":","");
              views = Integer.parseInt(tempviews);
            }
            // System.out.println(information[i]);
          }
          
          videoInfo.add(new Video(id, likes, dislikes, views));
        }
        // System.out.println(id);
        // System.out.println(likes);
        // System.out.println(dislikes);
        // System.out.println(views);
      }
  }
    return videoInfo;
  }
}