package wvu.nrmoore;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
	// write your code here
        Date newDate = new Date();
        Artist artist = new Artist("Nicholas", "Moore", newDate, "Twitter", "www.test.com");

        //artist.setLast("Moore");
        //artist.setFirst("Nick");

        Artist artist2 = new Artist();

        artist2.setLast("Ganoe");
        artist2.setFirst("Bill");

        Artist[] artArray = new Artist[100];
        artArray[0] = artist;

        if(artist2.isArtistInArray(artArray)){
            System.out.println("Artist is in array.");
        } else {
            System.out.println("Artist is not in array.");
        }


        System.out.println(artist);
        System.out.println(artist2);

    }
}
