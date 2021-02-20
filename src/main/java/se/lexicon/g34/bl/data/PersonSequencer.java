package se.lexicon.g34.bl.data;

public class PersonSequencer {
    private static int personId;

    //Constructors
    public PersonSequencer() {
    }

    //Methods
    public int nextPersonId() {
        setPersonId(personId);//Starts at 0. ++personId starts at 1.
        return personId++;
    }

    public void reset() {
        setPersonId(0);
    }

    //Getters and Setters.
    private void setPersonId(int newValue) {
        personId = newValue;
    }
}