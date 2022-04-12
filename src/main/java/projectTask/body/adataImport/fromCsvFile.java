package projectTask.body.adataImport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class fromCsvFile {
    public static void main(String[] args) {
        //customersImportFromCSV();
        partsImportFromCSV();
    }

    private static String DATABASE_USER = "root";
    private static String DATABASE_PASSWORD = "admin";
    private static String DATABASE_URL = "jdbc:mysql://localhost:3306/projDarbas?serverTimezone=UTC";

    public static void customersImportFromCSV() {

        final String DATABASE_USER = "root";
        final String DATABASE_PASSWORD = "admin";
        final String DATABASE_URL = "jdbc:mysql://localhost:3306/projDarbas?serverTimezone=UTC";

        String csvFilePath = "src/main/resources/CustomerCSV.csv";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            connection.setAutoCommit(false);

            String sql = "insert into customer (customerType, name, phoneNumber) values (?,?,?); ";
            PreparedStatement statement = connection.prepareStatement(sql);

            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));

            int count = -1;
            String lineText = null; // to skip header

            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String customerType = data[0];
                String name = data[1];
                String phoneNumber = data[2];

                statement.setString(1, customerType);
                statement.setString(2, name);
                statement.setString(3, phoneNumber);
                count++;

                statement.addBatch();
                statement.executeBatch();
                connection.commit();
            }
            lineReader.close();
            connection.close();
            System.out.println("Import completed, added new " + count + " customers");
        } catch (SQLException | IOException exception) {
            exception.printStackTrace();
        }
    }


    public static void partsImportFromCSV() {

        String csvFilePath = "src/main/resources/PartsCSV.csv";
        Connection connection = null;

        String lineText = null; // to skip header

        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            connection.setAutoCommit(false);

            String sql = "insert into parts (partName,partNumber,price,quantity,customerId) values (?,?,?,?,?); ";

            PreparedStatement statement = connection.prepareStatement(sql);
            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));

            int count = 0;


            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");

                statement.setString(1, data[0]);
                statement.setString(2, data[1]);

                statement.setInt(3, Integer.parseInt((data[2])));
                statement.setInt(4, Integer.parseInt((data[3])));
                statement.setInt(5, Integer.parseInt((data[4])));

                count++;

                statement.addBatch();
                statement.executeBatch();
                connection.commit();

            }
            lineReader.close();
            connection.close();
            System.out.println("Import completed, added new " + count + " parts");
        } catch (SQLException |
                IOException exception) {
            exception.printStackTrace();
        }
    }
}
