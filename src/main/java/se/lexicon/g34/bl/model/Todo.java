package se.lexicon.g34.bl.model;

import java.time.LocalDate;
import java.util.Objects;

public class Todo {
    private int todoId;
    private String title;
    private String description;
    private LocalDate deadline;
    private boolean done;
    private int assigneeId;

    //Constructors
    public Todo(int todoId, String description) {
        this.todoId = todoId;
        this.description = description;
        this.done=false;
    }
    //Setters and Getters

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(int assigneeId) {
        this.assigneeId = assigneeId;
    }
    //overrides

    @Override
    public String toString() {
        return "Todo{" +
                "todoId=" + todoId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                ", assigneeId=" + assigneeId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo)) return false;
        Todo todo = (Todo) o;
        return isDone() == todo.isDone() && getAssigneeId() == todo.getAssigneeId() && getTitle().equals(todo.getTitle()) && getDescription().equals(todo.getDescription()) && getDeadline().equals(todo.getDeadline());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDescription(), getDeadline(), isDone(), getAssigneeId());
    }
}

