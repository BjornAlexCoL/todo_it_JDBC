package se.lexicon.g34.bl.model;

public class Todo {
    private final int todoId;
    private String description;
    private boolean done;
    private Person assignee;

    //Constructors
    public Todo(int todoId, String description) {
        this.todoId = todoId;
        this.description = description;
        this.done=false;
    }
    //methods
    public void printIsDone() {
        if (isDone()) {
            System.out.print("is done");
        }
        else{
            System.out.print("is not done");
        }
    }
    //Setters and Getters

    public int getTodoId() {
        return todoId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone() {
        this.done = true;
    }
    public void setNotDone(){
        this.done=false;
    }
    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }
}

