package wvu.nrmoore;
import java.util.Objects;

/**
 * Artist.java
 *
 * Artist
 * class includes setters, getters, date validation and a toString() method
 *
 * Nicholas Moore
 * SENG 505
 * 11/21/2021
 */
public class Artist {

    // Declare the private variables
    private String last = "";
    private String first = "";
    private Date birthDate;
    private String twitterHandle = "";
    private String url = "";
    private String artistType = "";

    // getters
    public String getLast() {
        return last;
    }

    public String getFirst() {
        return first;
    }

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public String getUrl() {
        return url;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getArtistType() {
        return artistType;
    }


    // setters
    public void setLast(String last) {
        this.last = last;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setArtistType(String artistType) {
        this.artistType = artistType;
    }


    // Constructors
    public Artist(String firstName, String lastName, Date birthDate, String twitterHandle, String url){
        super();
        this.first = firstName;
        this.last = lastName;
        this.birthDate = birthDate;
        this.twitterHandle = twitterHandle;
        this.url = url;
    }

    public Artist(){
        super();
    }

    // helper functions

    // This lets you set the artist's birthdate with validation. This function uses the Date.java file from previous classes.
    public void setArtistBirthdate(){
        try {
            boolean validBirthDate = false;
            Date birthDate = new Date();

            while (!validBirthDate){
                System.out.println("Please enter the " + getArtistType() + " birthdate in the form of mm/dd/yyyy.");
                birthDate = new Date();
                birthDate.getDate();
                validBirthDate = validDate(birthDate);
            }

            setBirthDate(birthDate);
        } catch (Exception ex){
            setArtistBirthdate();
        }
    }

    // This lets you pass an array into it and returns a boolean value based on whether or not they are already in it.
    // It uses the equals method based on First, Last, and Birthdate.
    public boolean isArtistInArray(Artist[] artistsArray){
        for (int i = 0; i < artistsArray.length; i++){
            if(equals(artistsArray[i])){
                return true;
            }
        }
        return false;
    }

    // override's the equals function and checks First, Last, and Birthdate
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(last, artist.last) && Objects.equals(first, artist.first) && Objects.equals(birthDate, artist.birthDate);
    }

    // hash
    @Override
    public int hashCode() {
        return Objects.hash(last, first, birthDate, twitterHandle, url);
    }

    /**Function to convert artist values to a string value<br>
     * pre-conditions: none<br>
     * post-conditions: artist remains unchanged
     * @return string contents of the Artist class*/
    public String toString()
    {
        String dateString = "";
        if (getBirthDate() != null){
            dateString = getBirthDate().toString();
        }
        return "Full Name: " + getFirst() + " " + getLast() + "\nBirthdate: " + dateString + "\nTwitter Handle: " + getTwitterHandle() + " \nURL: " + getUrl() + "\n";
    }



    // Takes a date from Date.java and determines if it is a valid date.
    private boolean validDate(Date userDate) {
        // make sure the month is between 1 and 12
        if(userDate.getMonth() < 1 || userDate.getMonth() > 12){
            invalidDateMessage();
            return false;
        }

        // if the month is february check to see if it is within a leap year.
        if(userDate.getMonth() == 2){
            if(userDate.getDay() >= 1){
                if(isLeapYear(userDate.getYear())){
                    if(userDate.getDay() > 29){
                        invalidDateMessage();
                        return false;
                    }
                } else {
                    if(userDate.getDay() > 28){
                        invalidDateMessage();
                        return false;
                    }
                }
            } else {
                invalidDateMessage();
                return false;
            }
        }

        // there are only 30 days in these months.
        if(userDate.getMonth() == 4 || userDate.getMonth() == 6 || userDate.getMonth() == 9 || userDate.getMonth() == 11){
            if(userDate.getDay() <= 1 || userDate.getDay() >= 30){
                invalidDateMessage();
                return false;
            }
        }

        // if all else fails make sure the month has less than 31 days
        if(userDate.getDay() < 1 || userDate.getDay() > 31){
            invalidDateMessage();
            return false;
        }

        // if we made it this far the user needs to be told the date is valid.
        return true;
    }

    private void invalidDateMessage(){
        System.out.println("The date given is invalid. Please enter a new date.");
    }

    private boolean isLeapYear(int year){
        if(year % 4 == 0) {
            if(year % 100 == 0) {
                if(year % 400 == 0){
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

}

