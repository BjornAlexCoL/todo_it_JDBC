package se.lexicon.g34.bl.data;

import se.lexicon.g34.bl.model.Person;
import se.lexicon.g34.bl.model.Todo;

import java.util.Collection;

public interface TodoItems {
    Todo create(Todo todo);
    Collection<Todo> findAll();
    Todo findById(int id);
    Collection<Todo> findByDoneStatus(boolean done);
    Collection<Todo> findByAssignee(int assigneeId);
    Collection<Todo> findByAssignee(Person assignee);
    Collection<Todo> findByUnassignedTodoItems();
    Todo update(Todo todoToUpdate);
    boolean deleteById(int id);
}
