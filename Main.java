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
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        // System.out.println(rawVideo.get(0).getVideoID());
        videoInfo = Dislikes.getRatio(rawVideo);
        for (int i = 0; i < rawVideo.size(); i++){
            System.out.println(rawVideo.get(i).getTitle());
            System.out.println("Likes:    " + videoInfo.get(i).getLikes());
            System.out.println("Dislikes: " + videoInfo.get(i).getDislikes());
            System.out.println("Views:    "+ videoInfo.get(i).getViewCount());
        }
    }
}