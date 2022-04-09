package projectTask.body;

import java.sql.*;
import java.util.Scanner;

public class Services {

    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "admin";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/projDarbas?serverTimezone=UTC";


    public static void createCleanDatabaseTables() throws SQLException {

        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        Statement statement = connection.createStatement();
//        getAllData
        System.out.println("List of all customers:");
        System.out.println("_______________________________________________");
        ResultSet getAllCustomers = statement.executeQuery("SELECT * FROM customer;");


        while (getAllCustomers.next()) {
            String name = getAllCustomers.getString("name");
            String phoneNumber = getAllCustomers.getString("phoneNumber");
            String customerType = getAllCustomers.getString("customerType");

            System.out.println("Customer Name: " + name + ", contact number: " + phoneNumber + ", Type: " + customerType);

        }
    }

    public static void showAllVehiclesInSystem() throws SQLException {

        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        Statement statement = connection.createStatement();

//        getAllData
        System.out.println("List of registered vehicles in system");
        System.out.println("_______________________________________________");
        ResultSet getAllCustomers = statement.executeQuery("select * from Vehicle;");


        while (getAllCustomers.next()) {

            String regNr = getAllCustomers.getString("regNr");
            String vehicleBrand = getAllCustomers.getString("brand");
            System.out.println(regNr + " " + vehicleBrand);

        }
    }


    public static void showCommonData() throws SQLException {

        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        Statement statement = connection.createStatement();

//        getAllData
        System.out.println("List of registered vehicles in system");
        System.out.println("_______________________________________________");
        ResultSet getAllCustomers = statement.executeQuery("select name,phoneNumber,brand,regNr,partNumber,partName,quantity from customer inner join vehicle on customer.customerId = vehicle.customerId\n" +
                "join parts on customer.customerId = parts.partId;");


        while (getAllCustomers.next()) {
            String name = getAllCustomers.getString("name");
            String phoneNumber = getAllCustomers.getString("phoneNumber");
            String brand = getAllCustomers.getString("brand");
            String regNr = getAllCustomers.getString("regNr");
            String partNumber = getAllCustomers.getString("partNumber");
            String partName = getAllCustomers.getString("partName");
            String quantity = getAllCustomers.getString("quantity");

            System.out.println(name + "/" + phoneNumber + "/" + brand + "/" + regNr + "/" + partNumber + "/" + partName + "/" + quantity);
        }

    }

    public static void deleteCustomer() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter customer Id to delete");
        int customerIdToDelete = scanner.nextInt();

        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();

        String query = " delete from customer where customerId ='" + customerIdToDelete + "';";
        int result = statement.executeUpdate(query);
        connection.commit();
        if (result == 0) {
            System.out.println("record not found");
        } else {
            System.out.println(result + " no. of record deleted, customer deleted Id =" + customerIdToDelete);
        }
        statement.close();
        connection.close();

    }

    public static void customerNameUpdate() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer Id to Update");
        int customerIdToUpdate = scanner.nextInt();
        System.out.println("Enter customer name to update to:");
        String customerNameToUpdate = scanner.next();


        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();

        String query = " update customer set name = '" + customerNameToUpdate + "' where customerId = '" + customerIdToUpdate + "';";
        int result = statement.executeUpdate(query);
        connection.commit();
        if (result == 0) {
            System.out.print(" RECORD NOT FOUND");
        } else {
            System.out.print(" Record updated, new customer name set = " + customerNameToUpdate);
        }
        statement.close();
        connection.close();
    }

}
