package se.lexicon.g34.bl.model;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TodoTest {
    private static Todo testTodo;

    @Before
    public void setup() {
        testTodo = new Todo(1,"Test of Todo" );
        testTodo.setAssignee(new Person(1,"Björn","Larsson"));
        System.out.println("----------------------------\n");
        printChanges();
    }

    @Test
    public void test_description() {
        System.out.println("Change description");
        String testDescription = "This is a new description";
        testTodo.setDescription(testDescription);
    }
    @Test
    public void test_setdone(){
        System.out.println("TodoIt is set to done");
        testTodo.setDone();
    }
    @Test
    public void test_setnotdone(){
        System.out.println("TodoIt is set to not done");
        testTodo.setNotDone();
    }
    @Test
    public void test_changeAssignee(){
        String changeToFirstName="Nisse";
        String changeToLastName="Hult";
        Person personToChange=testTodo.getAssignee();
        personToChange.setFirstName(changeToFirstName);
        personToChange.setLastName(changeToLastName);
    }

    @After
    public void printChanges() {
        System.out.print("Todo with ID " + testTodo.getTodoId() + " " + testTodo.getDescription()+" assigned to ");
        testTodo.getAssignee().printFullName();
        System.out.print(" ");
        testTodo.printIsDone();
        System.out.println("\n");

    }
}
