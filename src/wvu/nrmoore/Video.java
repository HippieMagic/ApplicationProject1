package wvu.nrmoore;

public class Video extends Media {

    private Artist[] supportingActors;
    private int numActors;
    private Artist director;
    private String rating;

    public Video(String title, Artist majorArtist, int playTime, int numPlays, Artist[] sA, int nA, Artist d,
            String r) {
        super(title, majorArtist, playTime, numPlays);
        supportingActors = sA;
        numActors = nA;
        director = d;
        rating = r;
    }

    public void setSupportingActors(Artist[] sA) {
        supportingActors = sA;
    }

    public Artist[] getSupportingActors() {
        return supportingActors;
    }

    public void setNumActors(int nA) {
        numActors = nA;
    }

    public int getNumActors() {
        return numActors;
    }

    public void setDirector(Artist d) {
        director = d;
    }

    public Artist getDirector() {
        return director;
    }

    public void setRating(String r) {
        rating = r;
    }

    public String getRating() {
        return rating;
    }

    public String toString() {
        return "/nSupporting Actors: " + printArtists(supportingActors) + "/nNumber of Actors: " + numActors
                + "/nDirector: " + director + "/nRating: " + rating + super.toString();
    }

    private String printArtists(Artist[] artists) {
        String artistsString = "";

        for (int i = 0; i < artists.length; i++) {
            if (i == artists.length - 1) {
                artistsString += artists[i];
            } else {
                artistsString += artists[i] + ", ";
            }
        }

        return artistsString;
    }

    public String playMedia() {
        // super.playMedia(); -> need to implement play media in Media
        return "/nRating: " + rating;
    }
}
