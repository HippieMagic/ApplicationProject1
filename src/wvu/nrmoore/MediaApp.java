package wvu.nrmoore;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class MediaApp {

    private static Media[] theMedia = new Media[100];
    private static int numMedia = 0;

    private enum displayType {
        ALL, CD, DVD
    }

    static Scanner sc = new Scanner(System.in);
    private static Artist[] theArtists = new Artist[100];
    private static int numArtists = 0;

    public static void main(String[] args) {
        MediaApp mediaApp = new MediaApp();

        int mediaSelection = mediaApp.menuSelection();

        while (mediaSelection != 8)

        {
            switch (mediaSelection) {
                case 1:
                    // Create CD
                    System.out.println("Enter your CD information:");
                    CD cd = cdEntry();
                    theMedia[numMedia] = cd;
                    numMedia++;
                    // return CD object
                    break;
                case 2:
                    // Create DVD
                    System.out.println("Enter your DVD information:");
                    Video dvd = dvdEntry();
                    theMedia[numMedia] = dvd;
                    numMedia++;
                    // return DVD object
                    break;
                case 3:
                    // List all media
                    System.out.println("Media List");
                    for (int i = 0; i < numMedia; i++)
                        System.out.println(theMedia[i].toString());
                    // return CD object
                    break;
                case 4:
                    // List major Artist
                    System.out.println("Artist List");
                    for (int i = 0; i < numArtists; i++)
                        System.out.println(theMedia[i].getMajorArtist());

                    // return DVD object
                    break;
                case 5:
                    // Play CD
                    int searchResultCD = searchCD(titleEntry(MediaApp.displayType.CD));
                    if (searchResultCD == -1) {
                        System.out.println("Enter your CD is not in the database:");
                    } else {
                        theMedia[searchResultCD].playMedia();
                    }

                    break;
                case 6:
                    // Play DVD
                    int searchResultDVD = searchDVD(titleEntry(MediaApp.displayType.DVD));
                    if (searchResultDVD == -1) {
                        System.out.println("Enter your DVD is not in the database:");
                    } else {
                        theMedia[searchResultDVD].playMedia();
                    }
                    break;
                case 7:
                    // Display number of plays

                    System.out.println(numberMediaPlays());
                    break;

            }
            mediaSelection = mediaApp.menuSelection();
        }

    }

    private static CD cdEntry() {
        CD cd = new CD();
        String title = titleEntry(null);
        cd.setTitle(title);
        cd.setMediaType("CD");

        Artist tempArtist = artistKey("Major Artist");
        int artistIndex = searchArtist(tempArtist);

        if (artistIndex != -1) {

            cd.setMajorArtist(theArtists[artistIndex]);

        } else {

            Artist artist = artistEntry("Major Artist", tempArtist.getFirst(), tempArtist.getLast());
            cd.setMajorArtist(artist);
            theArtists[numArtists] = artist;
            numArtists++;
        }

        Artist tempProducer = artistKey("Producer");
        artistIndex = searchArtist(tempProducer);

        if (artistIndex != -1) {

            cd.setProducer(theArtists[artistIndex]);

        } else {

            Artist producer = artistEntry("Producer", tempProducer.getFirst(), tempProducer.getLast());
            cd.setProducer(producer);
            theArtists[numArtists] = producer;
            numArtists++;
        }

        Artist[] theGroupMembers = addArtistMembers(" group member ");
        cd.setGroupMembers(theGroupMembers);

        String[] theSongs = addSongs();
        cd.setSongTitles(theSongs);
        return cd;
    }

    private static String[] addSongs() {
        int songIndex;
        String[] theCdSongs = new String[10];
        int numSongs = 0;

        boolean done = false;
        while (!done) {
            System.out.println();
            System.out.println("(1) Enter song title");
            System.out.println("(2) Exit");

            int menuEntry = 0;
            while (menuEntry < 1 || menuEntry > 2) {
                try {

                    System.out.println("Enter your menu selection:");
                    menuEntry = sc.nextInt();
                    sc.nextLine();
                    if (menuEntry < 1 || menuEntry > 2) {
                        errorStatement();

                    } else {
                        switch (menuEntry) {
                            case 1:

                                String theSong = titleEntry(MediaApp.displayType.CD);

                                theCdSongs[numSongs] = theSong;
                                numSongs++;

                                break;

                            case 2:
                                done = true;
                                break;
                        }

                    }
                } catch (InputMismatchException e) {
                    errorStatement();
                    sc.nextLine();
                }

            }
        }
        return theCdSongs;
    }

    private static DVD dvdEntry() {
        DVD dvd = new DVD();
        String title = titleEntry(null);
        dvd.setTitle(title);
        dvd.setMediaType("DVD");

        Artist tempArtist = artistKey("Major Artist");
        int artistIndex = searchArtist(tempArtist);

        if (artistIndex != -1) {

            dvd.setMajorArtist(theArtists[artistIndex]);

        } else {

            Artist artist = artistEntry("Major Artist", tempArtist.getFirst(), tempArtist.getLast());
            dvd.setMajorArtist(artist);
            theArtists[numArtists] = artist;
            numArtists++;
        }

        Artist tempDirector = artistKey("Director");
        artistIndex = searchArtist(tempDirector);

        if (artistIndex != -1) {

            dvd.setDirector(theArtists[artistIndex]);

        } else {

            Artist director = artistEntry("Director", tempDirector.getFirst(), tempDirector.getLast());
            dvd.setDirector(director);
            theArtists[numArtists] = director;
            numArtists++;
        }

        Artist[] theGroupMembers = addArtistMembers(" supporting actor ");
        dvd.setSupportingActors(theGroupMembers);
        String soundOptions = enterSoundOptions();
        dvd.setSoundOptions(soundOptions);

        boolean wideScreenFormat = false;
        boolean tvFormat = false;

        int dvdFormat = videoFormat();
        if (dvdFormat == 1) {
            wideScreenFormat = true;
        }
        if (dvdFormat == 2) {
            tvFormat = true;
        }
        dvd.setWideScreenFormat(wideScreenFormat);
        dvd.setTVFormat(tvFormat);
        return dvd;
    }

    private static Artist[] addArtistMembers(String artistType) {
        int artistIndex;
        Artist[] theGroupMembers = new Artist[10];
        int numGroupMembers = 0;

        boolean done = false;
        while (!done) {
            System.out.println();
            System.out.println("(1) Enter " + artistType + " member");
            System.out.println("(2) Exit");

            int menuEntry = 0;
            while (menuEntry < 1 || menuEntry > 2) {
                try {

                    System.out.println("Enter your menu selection:");
                    menuEntry = sc.nextInt();
                    sc.nextLine();
                    if (menuEntry < 1 || menuEntry > 2) {
                        errorStatement();

                    } else {
                        switch (menuEntry) {
                            case 1:

                                Artist tempGroupMember = artistKey(artistType);
                                artistIndex = searchArtist(tempGroupMember);

                                if (artistIndex != -1) {

                                    theGroupMembers[numGroupMembers] = theArtists[artistIndex];
                                    numGroupMembers++;
                                } else {

                                    Artist groupMember = artistEntry(artistType, tempGroupMember.getFirst(),
                                            tempGroupMember.getLast());
                                    theArtists[numArtists] = groupMember;
                                    numArtists++;
                                    theGroupMembers[numGroupMembers] = groupMember;
                                    numGroupMembers++;
                                }

                                break;

                            case 2:
                                done = true;
                                break;
                        }

                    }
                } catch (InputMismatchException e) {
                    errorStatement();
                    sc.nextLine();
                }

            }
        }
        return theGroupMembers;
    }

    private static String titleEntry(MediaApp.displayType displayType) {
        System.out.println("Enter your Title:");
        String title = sc.nextLine();
        return title;
    }

    private static String enterSoundOptions() {
        System.out.println("Enter your sound option:");
        // String twitrName = sc.nextLine();
        // artist.setTwitterHandle(twitrName);

        String soundOptions = sc.nextLine();

        return soundOptions;
    }

    private static int videoFormat() {

        System.out.println("Enter your video format:");
        System.out.println("Select (1) for Wide Screen Format.");
        System.out.println("Select (2) for TV Format.");
        int dvdFormat = 0;
        while (dvdFormat < 1 || dvdFormat > 2) {
            try {
                System.out.println("Enter your menu selection:");
                dvdFormat = sc.nextInt();
                sc.nextLine();
                if (dvdFormat < 1 || dvdFormat > 2) {
                    errorStatement();

                }

            } catch (InputMismatchException e) {
                errorStatement();
            }

        }
        return dvdFormat;
    }

    private static Artist artistEntry(String artistType, String firstName, String lastName) {
        Artist artist = new Artist();
        artist.setFirst(firstName);
        artist.setLast(lastName);
        artistBirthdate(artistType, artist);

        System.out.println("Enter the " + artistType + " twitter name:");
        String twitrName = sc.nextLine();
        artist.setTwitterHandle(twitrName);
        System.out.println("Enter the " + artistType + " URL - web address:");
        String webLink = sc.nextLine();
        artist.setUrl(webLink);
        return artist;
    }

    private static void artistBirthdate(String artistType, Artist artist) {
        System.out.println("Enter the " + artistType + " birthdate in the form of: mm/dd/yyyy");
        String birthDate = sc.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        try {
            Date date = formatter.parse(birthDate);
            artist.setBirthDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static Artist artistKey(String artistType) {
        Artist artist = new Artist();
        System.out.println("Enter the " + artistType + " first name:");
        String firstName = sc.nextLine();
        artist.setFirst(firstName);

        System.out.println("Enter the " + artistType + " last name:");
        String lastName = sc.nextLine();
        artist.setLast(lastName);

        return artist;
    }

    public static int menuSelection() {
        System.out.println();
        System.out.println("(1) Create CD");
        System.out.println("(2) Create DVD");
        System.out.println("(3) List all Media");
        System.out.println("(4) List major Artist");
        System.out.println("(5) Play CD");
        System.out.println("(6) Play DVD");
        System.out.println("(7) Display number of plays");
        System.out.println("(8) Exit");
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

    public static int searchCD(String title) {
        int i;
        boolean found = false;
        for (i = 0; !found && i < numMedia; i++)
            if (title.equals(theMedia[i].getTitle()) && (theMedia[i].getMediaType().equals("CD")))
                found = true;
        if (!found)
            i = -1;
        else
            i--;
        return i;
    }

    public static int searchDVD(String title) {
        int i;
        boolean found = false;
        for (i = 0; !found && i < numMedia; i++)
            if (title.equals(theMedia[i].getTitle()) && (theMedia[i].getMediaType().equals("DVD")))
                found = true;
        if (!found)
            i = -1;
        else
            i--;
        return i;
    }

    public static int searchArtist(Artist artist) {
        int i;
        boolean found = false;
        for (i = 0; !found && i < numArtists; i++)
            if (artist.getFirst().equals(theArtists[i].getFirst()) && artist.getLast().equals(theArtists[i].getLast()))
                found = true;
        if (!found)
            i = -1;
        else
            i--;
        return i;
    }

    public static String numberMediaPlays() {
        System.out.println();
        System.out.println("(1) Enter a CD title");
        System.out.println("(2) Enter a DVD title");
        int menuEntry = 0;
        int numPlays = 0;
        String title = "";
        String numMediaPlays = "";
        while (menuEntry < 1 || menuEntry > 2) {
            try {
                System.out.println("Enter your menu selection:");
                menuEntry = sc.nextInt();
                sc.nextLine();
                if (menuEntry < 1 || menuEntry > 2) {
                    errorStatement();
                } else {
                    switch (menuEntry) {
                        case 1:
                            title = titleEntry(MediaApp.displayType.CD);
                            int searchResultCD = searchCD(title);
                            if (searchResultCD == -1) {
                                System.out.println("Enter your CD is not in the database:");
                            } else {
                                numPlays = theMedia[searchResultCD].getNumPlays();
                            }

                            break;

                        case 2:
                            title = titleEntry(MediaApp.displayType.DVD);
                            int searchResultDVD = searchDVD(title);
                            if (searchResultDVD == -1) {
                                System.out.println("Enter your DVD is not in the database:");
                            } else {
                                numPlays = theMedia[searchResultDVD].getNumPlays();
                            }
                            break;
                    }

                }
            } catch (InputMismatchException e) {
                errorStatement();
                sc.nextLine();
            }

        }
        numMediaPlays = title + ": has played " + numPlays + " times.";
        return numMediaPlays;
    }

    private static void errorStatement() {
        System.out.println("That is an incorrect entry, please re-enter your selection. ");
    }
}
