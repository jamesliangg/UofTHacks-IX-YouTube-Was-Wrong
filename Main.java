import java.util.ArrayList;
import java.util.Arrays;

class Main{
    public static void main(String[] args) throws Exception{
        ArrayList<Video> videoInfo = new ArrayList<Video>();
        String searchOption = UserInterface.searchOption();
        String searchTemp = searchOption.replace(" ", "%20");
        String key = UserInterface.getAPIKey();
        // System.out.println(key);
        System.out.println(searchTemp);
        ArrayList<Video> rawVideo = new ArrayList<Video>();
        rawVideo = YouTube.getUrl(searchTemp, key);
        System.out.println(Video.getNumRawVideo());
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        // System.out.println(rawVideo.get(0).getVideoID());
        videoInfo = Dislikes.getRatio(rawVideo);
        int[] ratios = new int[5]; 
        for (int i = 0; i < rawVideo.size(); i++){
            ratios[i] = videoInfo.get(i).getLikes()/(videoInfo.get(i).getDislikes() + 1);
        }
        Arrays.sort(ratios);
        for (int temp = 4; temp >= 0; temp--){
            for (int i = 0; i < ratios.length; i++){
                if (ratios[temp] == videoInfo.get(i).getLikes()/(videoInfo.get(i).getDislikes() + 1)){
                    System.out.println(rawVideo.get(i).getTitle());
                    System.out.println("URL:      " + "https://www.youtube.com/watch?v=" + videoInfo.get(i).getID());
                    System.out.println("Views:    " + videoInfo.get(i).getViewCount());
                    System.out.println("Likes:    " + videoInfo.get(i).getLikes());
                    System.out.println("Dislikes: " + videoInfo.get(i).getDislikes());
                    System.out.println("Ratio:    " + videoInfo.get(i).getLikes()/(videoInfo.get(i).getDislikes() + 1));
                    System.out.println();
                }
            }
        }
    }
}