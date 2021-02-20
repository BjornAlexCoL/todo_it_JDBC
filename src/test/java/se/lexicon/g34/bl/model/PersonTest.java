package se.lexicon.g34.bl.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {


    private static Person testPerson;

    @Before
    public void setup() {
        testPerson = new Person(1, "Björn", "Larsson");
        System.out.println("----------------------------\n");
        printChanges();
    }

    @Test
    public void test_firstName() {
        System.out.println("Change First Name");
        String testFirstName = "Test";
        testPerson.setFirstName(testFirstName);
    }

    @Test
    public void test_lastName() {
        System.out.println("Change Last Name");
        String testLastName = "Test";
        testPerson.setLastName(testLastName);
    }

    @After
    public void printChanges() {
        System.out.print("Name with ID " + testPerson.getPersonId() + " is ");
        testPerson.printFullName();
        System.out.println("\n");

    }
}