package projectTask.body.cservices;

import lombok.Data;
import projectTask.body.eEnum.DatabaseQueries;

import java.sql.*;
import java.util.Scanner;

@Data

public class Services {

    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "admin";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/projDarbas?serverTimezone=UTC";
    public static String newCustomerName;
    public static String newCustomerType;
    public static String newCustomerPhoneNumber;
    public static int customerIdIdentifier;

    public static void main(String[] args) throws SQLException {
        allPartsInDatabase();
    }

    //FOR B FIND DATA
    public static void allCustomersInDatabase() throws SQLException {

        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        Statement statement = connection.createStatement();
        System.out.println("Serviced customers in Database:");
        System.out.println("_______________________________________________");
        //ResultSet getAllCustomers = statement.executeQuery("SELECT * FROM customer;");
        ResultSet getAllCustomers = statement.executeQuery("SELECT * FROM customer;");


        while (getAllCustomers.next()) {
            String name = getAllCustomers.getString("name");
            String phoneNumber = getAllCustomers.getString("phoneNumber");
            String customerType = getAllCustomers.getString("customerType");

            System.out.println("Customer Name: " + name + ", contact number: " + phoneNumber + ", Type: " + customerType);

        }
    }

    //FOR B FIND DATA
    public static void allVehiclesInDatabase() throws SQLException {

        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        Statement statement = connection.createStatement();

        System.out.println("List of serviced vehicles in Database: ");
        ResultSet getAllCustomers = statement.executeQuery("select * from Vehicle;");

        while (getAllCustomers.next()) {
            String regNr = getAllCustomers.getString("regNr");
            String vehicleBrand = getAllCustomers.getString("brand");
            System.out.println("Registration: " + regNr + " ,Brand: " + vehicleBrand);
        }
    }

    //FOR B FIND DATA
    public static void allPartsInDatabase() throws SQLException {

        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        Statement statement = connection.createStatement();

        System.out.println("Used parts: ");
        ResultSet getAllCustomers = statement.executeQuery("select * from parts;");

        while (getAllCustomers.next()) {
            String partName = getAllCustomers.getString("partName");
            String partNumber = getAllCustomers.getString("partNumber");
            String price = getAllCustomers.getString("price");
            String quantity = getAllCustomers.getString("quantity");

            System.out.println("Part Name= " + partName + ", Part Number=" + partNumber + ", Price=" + price + ", Quantity=" + quantity);
        }
    }

    //FOR B FIND DATA
    public static void showCommonData() throws SQLException {

        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        Statement statement = connection.createStatement();

        System.out.println("List of registered vehicles in system");
        System.out.println("_______________________________________________");
        ResultSet getAllCustomers = statement.executeQuery("select name,phoneNumber,brand,regNr,partNumber,partName,quantity from customer inner join vehicle on customer.customerId = vehicle.customerId\n" +
                "join parts on customer.customerId = parts.customerId;");

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

    //FOR D FIND DELETE BY CUSTOMER ID
    public static void deleteCustomer() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter customer Id to delete");
        int customerIdToDelete = scanner.nextInt();

        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();

        int result = statement.executeUpdate(DatabaseQueries.DELETE_CUSTOMER_BY_ID + customerIdToDelete + "';");
        connection.commit();
        if (result == 0) {
            System.out.println("record not found");
        } else {
            System.out.println(result + " no. of record deleted, customer deleted Id =" + customerIdToDelete);
        }
        statement.close();
        connection.close();

    }

    //FOR C UPDATE CUSTOMER
    public static void customerNameUpdate() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer Id to Update");
        customerIdIdentifier = scanner.nextInt();
        System.out.println("Enter customer name:");
        newCustomerName = scanner.next();

        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();

        int result = statement.executeUpdate(DatabaseQueries.CUSTOMER_NAME_TO_UPDATE_BY_ID);
        connection.commit();
        if (result == 0) {
            System.out.print("RECORD NOT FOUND");
        } else {
            System.out.print("Record updated, new customer name set = " + newCustomerName);
        }
        statement.close();
        connection.close();
    }

    public static void customerTypeToUpdate() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer Id to Update");
        customerIdIdentifier = scanner.nextInt();
        System.out.println("Enter customer type update:");
        newCustomerType = scanner.next();

        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();

        int result = statement.executeUpdate(DatabaseQueries.CUSTOMER_TYPE_TO_UPDATE_BY_ID);
        connection.commit();
        if (result == 0) {
            System.out.print("RECORD NOT FOUND");
        } else {
            System.out.print("Record updated, Customer with ID " + customerIdIdentifier + " type changed to " + newCustomerType);
        }
        statement.close();
        connection.close();
    }

    public static void customerPhoneNumberToUpdate() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer Id to Update");
        customerIdIdentifier = scanner.nextInt();
        System.out.println("Enter customer phone Number:");
        newCustomerPhoneNumber = scanner.next();

        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();

        int result = statement.executeUpdate(DatabaseQueries.CUSTOMER_PHONE_NUMBER_TO_UPDATE_BY_ID);
        connection.commit();
        if (result == 0) {
            System.out.print("RECORD NOT FOUND");
        } else {
            System.out.print("Customer with ID " + customerIdIdentifier + " number changed to " + newCustomerPhoneNumber);
        }
        statement.close();
        connection.close();
    }
}
