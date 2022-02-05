import java.util.ArrayList;

class Main{
    public static void main(String[] args) throws Exception{
        // ArrayList<Video> videoInfo = new ArrayList<Video>();
        // System.out.println("Hello World");
        // videoInfo = Dislikes.getRatio("https://returnyoutubedislikeapi.com/votes?videoId=kxOuG8jMIgI");
        // System.out.println(videoInfo.get(0).getLikes());
        String searchOption = UserInterface.searchOption();
        String searchTemp = searchOption.replace(" ", "%20");
        String key = UserInterface.getAPIKey();
        // System.out.println(searchTemp);
        YouTube.getUrl(searchTemp, key);
    }
}