package wvu.nrmoore;

public class Media {

    private String title;
    private Artist majorArtist;
    private int playTime;
    private int numPlays;
    private String mediaType;



    public String getMediaType() {
        return mediaType;
    }
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Artist getMajorArtist() {
        return majorArtist;
    }
    public void setMajorArtist(Artist majorArtist) {
        this.majorArtist = majorArtist;
    }
    public int getPlayTime() {
        return playTime;
    }
    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }
    public int getNumPlays() {
        return numPlays;
    }
    public void setNumPlays(int numPlays) {
        this.numPlays = numPlays;
    }
    public Media(String title, Artist majorArtist, int playTime, int numPlays) {
        super();
        this.title = title;
        this.majorArtist = majorArtist;
        this.playTime = playTime;
        this.numPlays = numPlays;
    }
    public void playMedia() {
        System.out.println("Playing your media " + this.toString());
        numPlays++;
    }




    @Override
    public String toString() {
        return "Media [title=" + title + ", majorArtist=" + majorArtist + ", playTime=" + playTime + ", numPlays="
                + numPlays + ", mediaType=" + mediaType + "]";
    }

    public Media() {
        super();
    }


}
