package wvu.nrmoore;

public class CD extends Audio {


    private String[] songTitles;
    private int numberOfTitles;

    public CD(String[] songTitles, int numberOfTitles){
        super();
        this.songTitles = songTitles;
        this.numberOfTitles = numberOfTitles;
    }

    public void setSongTitles(String[] songTitles) {
        this.songTitles = songTitles;
    }

    public String[] getSongTitles() {
        return songTitles;
    }

    public void setNumberOfTitles(int numberOfTitles) {
        this.numberOfTitles = numberOfTitles;
    }

    public int getNumberOfTitles() {
        return numberOfTitles;
    }

    /**Function to convert CD values to a string value<br>
     * pre-conditions: none<br>
     * post-conditions: CD remains unchanged
     * @return string contents of the CD class*/
    public String toString()
    {
        String cdString = "Tracks: \n";
        for (int i = 0; i < songTitles.length; i++){
            if (songTitles[i] != null){
                cdString = cdString + songTitles[i] + "\n";
            }
        }
        cdString = cdString + "Number of Tracks: " + getNumberOfTitles();
        return cdString;
    }

    @Override
    public String playMedia(String mediaName) {
        return super.playMedia(mediaName);
    }

    public CD(){
        super();
    }
}
