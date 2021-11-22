package wvu.nrmoore;
/**
 * Audio.java
 *
 * Audio class extends Media
 * class includes setters, getters, and a toString() method
 *
 * Nicholas Moore
 * SENG 505
 * 11/21/2021
 */

public class Audio extends Media {

    // declare private variables
    private Artist[] groupMembers;
    private int numberOfMembers;
    private Artist producer;


    // getters
    public Artist[] getGroupMembers() {
        return groupMembers;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public Artist getProducer() {
        return producer;
    }


    // setters
    public void setGroupMembers(Artist[] groupMembers) {
        this.groupMembers = groupMembers;
    }

    public void setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public void setProducer(Artist producer) {
        this.producer = producer;
    }


    // constructors
    public Audio(Artist[] groupMembers, int numberOfMembers, Artist producer){
        super();
        this.groupMembers = groupMembers;
        this.numberOfMembers = numberOfMembers;
        this.producer = producer;
    }

    public Audio(){
        super();
    }

    /**Function to convert Audio values to a string value<br>
     * pre-conditions: none<br>
     * post-conditions: Audio remains unchanged
     * @return string contents of the Audio class*/
    public String toString()
    {
        String returnString = "Group Members: ";
        for (int i = 0; i < groupMembers.length; i++){
            if(groupMembers[i] != null){
                returnString = returnString + groupMembers[i].toString();
            }
        }

        returnString = returnString + numberOfMembers + "\n";

        returnString = returnString + "Producer: ";
        returnString = returnString + producer.toString();

        return returnString;
    }
}
