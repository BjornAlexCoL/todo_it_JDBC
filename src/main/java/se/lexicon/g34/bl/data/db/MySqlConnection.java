package se.lexicon.g34.bl.data.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/todoit";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "LindyHop";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("mySQL connection Etablished");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
