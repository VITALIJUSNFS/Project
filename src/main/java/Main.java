import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String DATABASE_USER = "root"; //mano db user
    private static final String DATABASE_PASSWORD = "admin"; // mano db psw
    //private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jdbcfun?serverTimezone=UTC";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jdbcfun";

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        try {
            Connection databaseConnection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            Statement statement = databaseConnection.createStatement();
            ResultSet userResultSet = statement.executeQuery("SELECT * FROM users");

            while (userResultSet.next()) {
                int userId = userResultSet.getInt("id");
                String firstName = userResultSet.getString("firstName");
                String lastName = userResultSet.getString("lastName");
                System.out.println(" { User id: " + userId + ", First Name: " + firstName + ", Last Name: " + lastName+ "}");
                users.add(new User(userId,firstName,lastName));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        users.forEach(System.out::println);

    }
}
