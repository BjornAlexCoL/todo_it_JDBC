package se.lexicon.g34.bl.model;

public class Person {
    private final int personId;
    private String firstName;
    private String lastName;


    //constructor
    public Person(int personID, String firstName, String lastName) {
        this.personId = personID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Methods
    public void printFullName() {
        System.out.print(getFirstName() + " " + getLastName());
    }

    //getters and setters
    public int getPersonId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
