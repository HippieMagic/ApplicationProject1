package wvu.nrmoore;
/**
 * CD.java
 *
 * CD class extends Audio
 * class includes setters, getters, playMedia() and a toString() method
 *
 * Nicholas Moore
 * SENG 505
 * 11/21/2021
 */
public class CD extends Audio {

    // Declare the private variables
    private String[] songTitles;
    private int numberOfTitles;

    //getters
    public String[] getSongTitles() {
        return songTitles;
    }

    public int getNumberOfTitles() {
        return numberOfTitles;
    }

    //setters
    public void setSongTitles(String[] songTitles) {
        this.songTitles = songTitles;
    }

    public void setNumberOfTitles(int numberOfTitles) {
        this.numberOfTitles = numberOfTitles;
    }

    //constructors
    public CD(String[] songTitles, int numberOfTitles){
        super();
        this.songTitles = songTitles;
        this.numberOfTitles = numberOfTitles;
    }

    public CD(){
        super();
    }

    /**Function to convert CD values to a string value<br>
     * pre-conditions: none<br>
     * post-conditions: CD remains unchanged
     * @return string contents of the CD class*/
    public String toString()
    {
        String cdString = "Title: " + getTitle() + "\n";
        cdString = cdString + "Tracks: \n";
        for (int i = 0; i < songTitles.length; i++){
            if (songTitles[i] != null){
                cdString = cdString + songTitles[i] + "\n";
            }
        }
        cdString = cdString + "Number of Tracks: " + getNumberOfTitles();
        return cdString;
    }

    // call the play media function from Media
    public void playMedia() {
        super.playMedia();
    }


}