package se.lexicon.g34.bl.data;

public class TodoSequencer {
    private static int todoId;

    //Constructors
    public TodoSequencer() {
    }

    //Methods
    public int nextTodoId() {
        setTodoId(todoId);//Starts at 0. ++personId starts at 1.
        return todoId++;
    }

    public void reset() {
        setTodoId(0);
    }

    //Getters and Setters.
    private void setTodoId(int newValue) {
        todoId = newValue;
    }
}