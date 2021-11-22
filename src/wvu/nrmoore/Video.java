package wvu.nrmoore;

/**
 * Video.java
 *
 * Video class extends Media
 * class includes setters, getters, and a toString() method
 *
 * Payton Kennedy
 * SENG 505
 * 11/21/2021
 */

public class Video extends Media {

    private Artist[] supportingActors; // supporting actors for a video
    private int numActors; // supporting actors for a video
    private Artist director; // director for a video
    private String rating; // rating for a video

    // Video constructor
    public Video(String title, Artist majorArtist, int playTime, int numPlays, Artist[] sA, int nA, Artist d,
                 String r) {
        super(title, majorArtist, playTime, numPlays);
        supportingActors = sA;
        numActors = nA;
        director = d;
        rating = r;
    }

    // supporting actors setter
    public void setSupportingActors(Artist[] sA) {
        supportingActors = sA;
    }

    // supporting actors getter
    public Artist[] getSupportingActors() {
        return supportingActors;
    }

    // number of actors setter
    public void setNumActors(int nA) {
        numActors = nA;
    }

    // number of actors getter
    public int getNumActors() {
        return numActors;
    }

    // director setter
    public void setDirector(Artist d) {
        director = d;
    }

    // director getter
    public Artist getDirector() {
        return director;
    }

    // rating setter
    public void setRating(String r) {
        rating = r;
    }

    // rating getter
    public String getRating() {
        return rating;
    }

    // returns a string for the Video class that includes the supporting actors, the
    // number of actors, the director, the rating, and then the media's toString() method
    public String toString() {
        return "\nSupporting Actors: " + printArtists(supportingActors) + "\nNumber of Actors: " + numActors
                + "\nDirector: " + director + "\nRating: " + rating + super.toString();
    }

    // function returns a string of artists given an array of artists
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

    // play media method from the Media class
    public void playMedia() {
        super.playMedia();

    }

    public Video() {
        super();
    }
}
