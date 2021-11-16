package wvu.nrmoore;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MediaApp {

    private static Media[] theMedia = new Media[100];
    private static int numMedia = 0;

    private enum displayType {ALL, CDS, DVD}

    static Scanner sc = new Scanner(System.in);
    private static Artist[] theArtists = new Artist[100];
    private static int numArtists = 0;

    public static void main(String[] args) {
        MediaApp mediaApp = new MediaApp();

        int mediaSelection = mediaApp.mediaEntry();

        while (mediaSelection == 1 || mediaSelection == 2) {
            switch (mediaSelection) {
                case 1:
// todo add CD entry method
                    System.out.println("Enter your CD information:");
                    CD cd = cdEntry();
                    theMedia[numMedia] = cd;
                    numMedia++;
// return CD object
                    break;
                case 2:
// todo add DVD entry method
                    System.out.println("Enter your DVD information:");
                    //Dvd dvd = new Dvd();
                    //theMedia[numMedia] = dvd;
                    numMedia++;
// return DVD object
                    break;


            }
        }
    }

    private static CD cdEntry() {
        CD cd = new CD();
        System.out.println("Enter your CD Title:");
        String title = sc.nextLine();
        cd.setTitle(title);
        // TODO code Artist array

        Artist artist = artistEntry();

        for (int i = 0; i < numArtists; i++)
            if (theArtists[numArtists].equals(artist))
                System.out.println("This artist is already in the database.");

            else
                theArtists[numArtists] = artist;
        numArtists++;


        //String birthDate = sc.nextLine();
        //artist.setBirthDate(null);


        cd.setMajorArtist(artist);

        // TODO code that adds artist and cd information
        return cd;
    }

    private static Artist artistEntry() {
        Artist artist = new Artist();
        System.out.println("Enter the Artist first name:");
        String firstName = sc.nextLine();
        artist.setFirst(firstName);

        System.out.println("Enter the Artist last name:");
        String lastName = sc.nextLine();
        artist.setLast(lastName);
        System.out.println("Enter the Artist twitter name:");
        String twitrName = sc.nextLine();
        artist.setTwitterHandle(twitrName);
        System.out.println("Enter the Artist URL - web address:");
        String webLink = sc.nextLine();
        artist.setUrl(webLink);
        return artist;
    }

    public static int mediaEntry() {
        System.out.println();
        System.out.println("(1) Create CD");
        System.out.println("(2) Create DVD");
        System.out.println("(3) List all Media");
        System.out.println("(4) List major Artist");
        System.out.println("(5) Play Title");
        System.out.println("(6) Display number of plays");
        System.out.println("(7) Exit");
        int menuEntry = 0;
        while (menuEntry < 1 || menuEntry > 7) {
            try {
                System.out.println("Enter your menu selection:");
                menuEntry = sc.nextInt();
                sc.nextLine();
                if (menuEntry < 1 || menuEntry > 7) {
                    errorStatement();

                }

            } catch (InputMismatchException e) {
                errorStatement();
                sc.nextLine();
            }

        }
        return menuEntry;
    }

    private static void errorStatement() {
        System.out.println("That is an incorrect entry, please re-enter your selection. ");
    }
}
