package se.lexicon.g34.bl.data;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.g34.bl.model.Person;


public class PeopleTest {
    People personList = new People();


    @Before
    public void testPeople() { //test size(), addPerson() and findAll()
        personList.addPerson("Björn", "Larsson");
        personList.addPerson("Sven", "Ohlsson");
        personList.addPerson("Ida", "Ohlsson");
        personList.addPerson("Harriet", "Larsson");
        personList.addPerson("Gösta", "Larsson");
        printPersonList(personList.findAll());
    }
    @Test
    public void testSearchPerson() {
        Person searchPerson;
        for (int i = -1; i < personList.size() + 1; i++) {//If Persons is removed and new is added this test will not find them.
            System.out.println("Search for person with Id=" + i);
            searchPerson = personList.findById(i);
            if (searchPerson.getPersonId() == -1) {
                System.out.println("Person with Id " + i + " can't be found");
                continue;
            }
            printPerson(searchPerson);
        }
    }
    @Test
    public void testClearList(){
        System.out.println("Clear the list");
        personList.clear();
        printPersonList(personList.findAll());
    }
    @Test
    public void TestRemovePerson() {
        System.out.println("Removo post with id 3"); //Common remove by ID
        personList.removePerson(3);
        printPersonList(personList.findAll());
        System.out.println("\nTry to Removo post with nonexisting id 45"); //Try to removing post with nonexisting ID
        personList.removePerson(45);
        printPersonList(personList.findAll());
        System.out.print("\nRemovo post with Todo "); //Get Todoobject from index and remove it by todoobject
        printPerson(personList.findById(2));
        personList.removePerson(personList.findById(2));
        printPersonList(personList.findAll());


    }

    public void printPersonList(Person[] list) {
        for (Person listPerson : list) {
            printPerson(listPerson);
        }
        System.out.println(personList.size() + " persons in the list");
        System.out.println("------------------------------------------"); //Testing findById by searching for all numbers if many

    }

    public void printPerson(Person personToPrint) {
        System.out.print(personToPrint.getPersonId() + ". ");
        personToPrint.printFullName();
        System.out.print("\n");
    }

}