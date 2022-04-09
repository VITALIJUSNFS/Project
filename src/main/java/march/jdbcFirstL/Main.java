package march.jdbcFirstL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PSW = "admin";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jdbcfun";


    public static void main(String[] args) {

        List<RedCars> redCars = new ArrayList<>();

        try {
            Connection databaseConnectionCars = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PSW);
            Statement statement = databaseConnectionCars.createStatement();
            ResultSet userRedCars = statement.executeQuery("select * from cars where color = 'red'");

            while (userRedCars.next()) {
                int carId = userRedCars.getInt("carId");
                String brand = userRedCars.getString("brand");
                String buildYear = userRedCars.getString("buildYear");

//                System.out.println(carId + " " + brand + " " + buildYear);
                redCars.add(new RedCars(carId, brand, buildYear));
            }

        } catch (SQLException exception) {
            System.out.println("Error, contact administrator");
        }
        System.out.println("Red Cars on parking are: ");
        redCars.forEach(System.out::println);

    }
}
