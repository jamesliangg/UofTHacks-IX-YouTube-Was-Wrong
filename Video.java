public class Video {
    public String id;
    public int likes;
    public int dislikes;
    public int viewCount;

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
    public String toString(){
        return id + " " + likes + " " + dislikes + " " + viewCount;
    }
}
