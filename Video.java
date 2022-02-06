public class Video {
    public String id;
    public int likes;
    public int dislikes;
    public int viewCount;
    public String videoID;
    public String title;
    public static int numRawVideos;
    public String thumbnailUrl;
    public String channel;
    public String pub;

    public Video(String videoID, String title, String thumbnailUrl, String channel, String pub){
        setVideoID(videoID);
        setTitle(title);
        setThumbnailUrl(thumbnailUrl);
        setChannel(channel);
        setPub(pub);
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
    public String getThumbnailUrl(){
        return thumbnailUrl;
    }
    public String getChannel(){
        return channel;
    }
    public String getPub(){
        return pub;
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
    public void setThumbnailUrl(String thumbnailUrl){
        this.thumbnailUrl = thumbnailUrl;
    }
    public void setChannel(String channel){
        this.channel = channel;
    }
    public void setPub(String pub){
        this.pub = pub;
    }
    public String toString(){
        return id + " " + likes + " " + dislikes + " " + viewCount;
    }
}
