package se.lexicon.g34.bl.data;

import se.lexicon.g34.bl.model.Person;

import java.util.Collection;

public interface People {

    Person create(Person person);
    Collection<Person> findAll();
    Person findById(int id);
    Collection<Person> findByName(String name);
    Person update(Person pToUpdate);
    boolean deleteById(int id);
}
