package wvu.nrmoore;

public class Audio extends Media {

    private Artist[] groupMembers;
    private int numberOfMembers;
    private Artist producer;

    public void setGroupMembers(Artist[] groupMembers) {
        this.groupMembers = groupMembers;
    }

    public Artist[] getGroupMembers() {
        return groupMembers;
    }

    public void setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setProducer(Artist producer) {
        this.producer = producer;
    }

    public Artist getProducer() {
        return producer;
    }

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
