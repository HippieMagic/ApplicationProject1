package wvu.nrmoore;

public class Audio {

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

    /**Function to convert Audio values to a string value<br>
     * pre-conditions: none<br>
     * post-conditions: Audio remains unchanged
     * @return string contents of the Audio class*/
    public String toString()
    {
        return "Super Cool Artist String So You Know It's Working.";
    }

}
