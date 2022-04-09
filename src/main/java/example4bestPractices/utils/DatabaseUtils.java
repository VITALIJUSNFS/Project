package example4bestPractices.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {

    private static final String DATABASE_USER = "root"; //mano db user
    private static final String DATABASE_PASSWORD = "admin"; // mano db psw
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jdbcfun2?serverTimezone=UTC";

    public static Connection databaseConnection = createDatabaseConnection();

    private static Connection createDatabaseConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return connection;
    }
}
