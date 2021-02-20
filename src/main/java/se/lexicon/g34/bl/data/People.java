package se.lexicon.g34.bl.data;


import se.lexicon.g34.bl.model.Person;

import java.util.Arrays;

public class People {
    private static Person[] personList = new Person[0];
    private static PersonSequencer counter=new PersonSequencer();
    //Constructor
    public People() {
    }

    //methods
    public int size() {
        return personList.length;
    }

    public Person[] findAll() {
        return personList;

    }

    public Person findById(int findPerson) {
        if (findPerson>=0 ) {
            for (Person checkPerson : personList) {
                if (findPerson == checkPerson.getPersonId()) {
                    return checkPerson;
                }
            }
        }
        return new Person(-1,"Invalid","PersonID");//With person set to -1 the caller can take care of not existing

    }

    public Person addPerson(String firstName,String lastName) {
        int newId=counter.nextPersonId();
        Person newPerson=new Person(newId,firstName,lastName);
        return addPerson(newPerson);
    }
    private Person addPerson(Person newPerson) { //Don't want everyone to add whole objects to list and get passed the counterID.
        personList=Arrays.copyOf(personList,size()+1);
        personList[size()-1]=newPerson;
        return newPerson;
    }

    public void clear() {
        clearPersonList();
    }

    public void removePerson(Person removePerson){// Remove by using Personobject
        int findIndex=getPersonListIndex(removePerson);
        removePerson(findIndex);
    }
    public void removePerson(int index){
        if (index>=0 && index<personList.length ) {
            Person[] firstPart ;
            firstPart = Arrays.copyOfRange(personList, 0, index);
            Person[] secondPart;
            secondPart = Arrays.copyOfRange(personList, index + 1, personList.length);
            personListConcat(firstPart, secondPart);
        }
    }

    private void personListConcat(Person[] arrayToAddTo,Person[] arrayToAdd){
        personList=arrayToAddTo;
        for (Person personToAdd:arrayToAdd){
            addPerson(personToAdd);
        }
    }
    private int getPersonListIndex(Person findPerson) {
        int findPersonId = findPerson.getPersonId();
        return getPersonlistIndex(findPersonId);
    }

    private int getPersonlistIndex(int findPersonId) {
        int index = 0;
        for (Person checkPerson : personList) {
            if (findPersonId == checkPerson.getPersonId()) {
                return index;
            }
            index++;
        }
        return -1;

    }
    private void clearPersonList() {
        personList = new Person[0];
    }
}