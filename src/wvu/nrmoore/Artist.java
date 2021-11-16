package wvu.nrmoore;

import java.util.Date;
import java.util.Objects;

public class Artist {

    private String last;
    private String first;
    private Date birthDate;
    private String twitterHandle;
    private String url;

    public void setLast(String last) {
        this.last = last;
    }

    public String getLast() {
        return last;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getFirst() {
        return first;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public boolean isArtistInArray(Artist[] artistsArray){
        for (int i = 0; i < artistsArray.length; i++){
            if(equals(artistsArray[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(last, artist.last) && Objects.equals(first, artist.first) && Objects.equals(birthDate, artist.birthDate) && Objects.equals(twitterHandle, artist.twitterHandle) && Objects.equals(url, artist.url);
    }

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
        return getFirst() + " " + getLast();
    }

    public Artist(){
        super();
    }

}
