public class Video {
    public String id;
    public int likes;
    public int dislikes;
    public int viewCount;
    public String videoID;
    public String title;
    public static int numRawVideos;

    public Video(String videoID, String title){
        setVideoID(videoID);
        setTitle(title);
        numRawVideos++;
    }
    public Video(String id, int likes, int dislikes, int viewCount){
        setID(id);
        setLikes(likes);
        setDislikes(dislikes);
        setViewCount(viewCount);
    }
    public String getID(){
        return id;
    }
    public int getLikes(){
        return likes;
    }
    public int getDislikes(){
        return dislikes;
    }
    public int getViewCount(){
        return viewCount;
    }
    public String getVideoID(){
        return videoID;
    }
    public String getTitle(){
        return title;
    }
    public static int getNumRawVideo(){
        return numRawVideos;
    }
    public void setID(String id){
        this.id = id;
    }
    public void setLikes(int likes){
        this.likes = likes;
    }
    public void setDislikes(int dislikes){
        this.dislikes = dislikes;
    }
    public void setViewCount(int viewCount){
        this.viewCount = viewCount;
    }
    public void setVideoID(String videoID){
        this.videoID = videoID;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String toString(){
        return id + " " + likes + " " + dislikes + " " + viewCount;
    }
}
