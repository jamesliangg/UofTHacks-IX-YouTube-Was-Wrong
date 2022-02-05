import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
 
public class Dislikes{
  public static void getRatio(String ytURL) throws Exception {
    URL url = new URL(ytURL);
    URLConnection connection = url.openConnection();
    try (BufferedReader in = new BufferedReader(
      new InputStreamReader(connection.getInputStream())))
    {
      String line;
      while ((line = in.readLine()) != null) {
        System.out.println(line);
      }
    }
  }
}