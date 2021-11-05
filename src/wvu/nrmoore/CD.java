package wvu.nrmoore;

public class CD {
    /*
    * songTitles[]:string
numberOfTitles:int
toString()
playMedia()
    * */

    private String[] songTitles;
    private int numberOfTitles;

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
        return "";
    }

    public void playMedia(){
        // not sure what this does yet.
    }
}
