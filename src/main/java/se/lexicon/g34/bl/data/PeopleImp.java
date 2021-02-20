package se.lexicon.g34.bl.data;


import se.lexicon.g34.bl.data.db.MySqlConnection;
import se.lexicon.g34.bl.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class PeopleImp implements People{

    @Override
    public Person create(Person person) {
        String query = "INSERT INTO people VALUE (0,?,?);";
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query, RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.executeUpdate();
            ResultSet genKeys = preparedStatement.getGeneratedKeys();
            if (genKeys.next()) {
                person.setPersonId(genKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Collection<Person> findAll() {
        String query = "Select * from people;";
        Collection<Person> personList = new ArrayList<>();
        try {
            Statement statement = MySqlConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) personList.add(new Person(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3)));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    @Override
    public Person findById(int id) {
        String query = "SELECT * from people where person_id = ?;";
        Person person = null;
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                person = new Person(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Collection<Person> findByName(String name) {
        String query = "SELECT * FROM person WHERE ((([first_name] + ' ' + [last_name]) Like '%?%'));";
        Collection<Person> personList = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                personList.add(new Person(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    @Override
    public Person update(Person pToUpdate) {
        String query = "UPDATE city SET first_name=?,last_name=? WHERE person_id=?;";
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setString(1, pToUpdate.getFirstName());
            preparedStatement.setString(2, pToUpdate.getLastName());
            preparedStatement.setInt(3, pToUpdate.getPersonId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pToUpdate;
    }

    @Override
    public boolean deleteById(int id) {
        String query = "DELETE FROM people WHERE person_id=?";
        boolean result=false;
        if (findById(id) != null) {
            try (
                    PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query)
            ) {
                preparedStatement.setInt(1, id);
                result=preparedStatement.executeUpdate()==0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}