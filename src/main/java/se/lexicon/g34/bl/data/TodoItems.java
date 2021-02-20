package se.lexicon.g34.bl.data;

import se.lexicon.g34.bl.model.Person;
import se.lexicon.g34.bl.model.Todo;


import java.util.Arrays;

public class TodoItems {
    private Todo[] todoList = new Todo[0];
    private TodoSequencer counter = new TodoSequencer();

    //Constructor
    public TodoItems() {
    }

    //methods
    public int size() {
        return todoList.length;
    }

    public Todo[] findAll() {
        return todoList;
    }

    public Todo findById(int findTodo) {
        if (findTodo >= 0) {
            for (Todo checkTodo : todoList) {
                if (findTodo == checkTodo.getTodoId()) {
                    return checkTodo;
                }
            }
        }
        return new Todo(-1, "Invalid");//With person set to -1 the caller can take care of not existing
    }

    public Todo addTodo(String description) {
        int newId = counter.nextTodoId();
        Todo newTodo = new Todo(newId, description);
        return addTodo(newTodo);
    }

    public Todo addTodo(String description, Person assignee) {
        int newId = counter.nextTodoId();
        Todo newTodo = new Todo(newId, description); //By default done is set to false.
        newTodo.setAssignee(assignee);
        return addTodo(newTodo);
    }

    private Todo addTodo(Todo newTodo) { //Don't want everyone to add whole objects to list and get passed the counterID.
        todoList = Arrays.copyOf(todoList, size() + 1);
        todoList[size() - 1] = newTodo;
        return newTodo;
    }


    public void clear() { //Leaving room to make control before deleting whole list.
        clearTodoList();
    }

    private void clearTodoList() { //Don't want everyone to be able to delete the list.
        todoList = new Todo[0];
    }


    public Todo[] findByDoneStatus(boolean doneStatus) {
        TodoItems resultList = new TodoItems();
        System.out.println(resultList.size() + "Element in List.");

        for (Todo checkTodo : todoList) {
            if (checkTodo.isDone() == doneStatus) {
                resultList.addTodo(checkTodo);
            }
        }
        System.out.println(resultList.size() + "Element in List.");
        return resultList.findAll();
    }

    public Todo[] findByAssignee(Person assignee) {
        int personId = assignee.getPersonId();
        return findByAssignee(personId);
    }

    public Todo[] findByAssignee(int personId) {
        TodoItems resultList = new TodoItems();
        for (Todo checkTodo : todoList) {
            if (checkTodo.getAssignee() != null) {
                if (checkTodo.getAssignee().getPersonId() == personId) {
                    resultList.addTodo(checkTodo);
                }
            }
        }
        return resultList.findAll();
    }

    public Todo[] findUnassignedTodoItems() {
        TodoItems resultList = new TodoItems();
        for (Todo checkTodo : todoList) {
            if (checkTodo.getAssignee() == null) {
                resultList.addTodo(checkTodo);
            }
        }
        return resultList.findAll();
    }

    public void removeTodo(Todo removeTodo){// Remove by using todoobject
        int findIndex=getTodoListIndex(removeTodo);
        removeTodo(findIndex);
    }
    public void removeTodo(int index){
        if (index>=0 && index<todoList.length ) {
            Todo[] firstPart;
            firstPart = Arrays.copyOfRange(todoList, 0, index);
            Todo[] secondPart;
            secondPart = Arrays.copyOfRange(todoList, index + 1, todoList.length);
            todoListConcat(firstPart, secondPart);
        }
    }

    private void todoListConcat(Todo[] arrayToAddTo,Todo[] arrayToAdd){
        todoList=arrayToAddTo;
        for (Todo todoToAdd:arrayToAdd){
            addTodo(todoToAdd);
        }
    }
    private int getTodoListIndex(Todo findTodo) {
        int findTodoId = findTodo.getTodoId();
        return getTodolistIndex(findTodoId);
    }

    private int getTodolistIndex(int findTodoId) {
        int index = 0;
        for (Todo checkTodo : todoList) {
            if (findTodoId == checkTodo.getTodoId()) {
                return index;
            }
            index++;
        }
        return -1;

    }

    //Setters and getters
    public int setIsDone(Todo todoId) { //Return -1 if not todoitem was found otherwise the index in list.
        int index = getTodoListIndex(todoId);
        if (index != -1) {
            todoList[index].setDone();
        }
        return index;
    }

    public int clearIsDone(Todo todoId) {//Return -1 if not todoitem was found otherwise the index in list.
        int index = getTodoListIndex(todoId);
        if (index != -1) {
            todoList[index].setNotDone();
        }
        return index;
    }

    public int setTodoAssignee(Todo todoId, Person assigned) {//Return -1 if not todoitem was found otherwise the index in list.
        int index = getTodoListIndex(todoId);
        if (index != -1) {
            todoList[index].setAssignee(assigned);
        }
        return index;
    }


}