import java.util.ArrayList;

class Main{
    public static void main(String[] args) throws Exception{
        ArrayList<Video> videoInfo = new ArrayList<Video>();
        String searchOption = UserInterface.searchOption();
        String searchTemp = searchOption.replace(" ", "%20");
        String key = UserInterface.getAPIKey();
        System.out.println(searchTemp);
        ArrayList<Video> rawVideo = new ArrayList<Video>();
        rawVideo = YouTube.getUrl(searchTemp, key);
        System.out.println(Video.getNumRawVideo());
        System.out.println(rawVideo.get(0).getVideoID());
        System.out.println(rawVideo.get(0).getTitle());
        videoInfo = Dislikes.getRatio(rawVideo);
        System.out.println(videoInfo.get(0).getLikes());
        System.out.println(videoInfo.get(0).getDislikes());
        System.out.println(videoInfo.get(0).getViewCount());
    }
}