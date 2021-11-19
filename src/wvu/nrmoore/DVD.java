package wvu.nrmoore;

public class DVD extends Video {

    private boolean wideScreenFormat;
    private boolean TVFormat;
    private String soundOptions;

    public DVD(String title, Artist majorArtist, int playTime, int numPlays, Artist[] sA, int nA, Artist d, String r,
            boolean wSF, boolean TVF, String sO) {
        super(title, majorArtist, playTime, numPlays, sA, nA, d, r);
        wideScreenFormat = wSF;
        TVFormat = TVF;
        soundOptions = sO;
    }

    public void setWideScreenFormat(boolean wSF) {
        wideScreenFormat = wSF;
    }

    public boolean getWideScreenFormat() {
        return wideScreenFormat;
    }

    public void setTVFormat(boolean TVF) {
        TVFormat = TVF;
    }

    public boolean getTVFormat() {
        return TVFormat;
    }

    public void setSoundOptions(String sO) {
        soundOptions = sO;
    }

    public String getSoundOptions() {
        return soundOptions;
    }

    public String toString() {
        return "/nWide Screen Format: " + wideScreenFormat + "/nTV Format: " + TVFormat + "/nSound Options: "
                + soundOptions + super.toString();
    }
}
