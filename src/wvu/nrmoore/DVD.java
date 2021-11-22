package wvu.nrmoore;

/**
 * DVD.java
 *
 * DVD class extends Video
 * class includes setters, getters, and a toString() method
 *
 * Payton Kennedy
 * SENG 505
 * 11/21/2021
 */

public class DVD extends Video {

    private boolean wideScreenFormat; // wide screen format for a DVD
    private boolean tvFormat; // tv format for a DVD
    private String soundOptions; // sound options for a DVD

    // DVD Constuctor
    public DVD(String title, Artist majorArtist, int playTime, int numPlays, Artist[] sA, int nA, Artist d, String r,
               boolean wSF, boolean tvF, String sO) {
        super(title, majorArtist, playTime, numPlays, sA, nA, d, r);
        wideScreenFormat = wSF;
        tvFormat = tvF;
        soundOptions = sO;
    }

    // wide screen format setter
    public void setWideScreenFormat(boolean wSF) {
        wideScreenFormat = wSF;
    }

    // wide screen format getter
    public boolean getWideScreenFormat() {
        return wideScreenFormat;
    }

    // tv format setter
    public void setTVFormat(boolean tvF) {
        tvFormat = tvF;
    }

    // tv format getter
    public boolean getTVFormat() {
        return tvFormat;
    }

    // sound options setter
    public void setSoundOptions(String sO) {
        soundOptions = sO;
    }

    // sound options getter
    public String getSoundOptions() {
        return soundOptions;
    }

    // returns a string for the DVD class that includes the Media's toString()
    // method, the wide screen format, tv format, and the sound options
    @Override
    public String toString() {
        return super.toString() + " DVD [wideScreenFormat = " + wideScreenFormat + ", tVFormat = " + tvFormat
                + ", soundOptions = " + soundOptions + "]";
    }

    public DVD() {
        super();
    }
}