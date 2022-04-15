package detailingProject.body.export;

import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ToCsv {

    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "admin";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/projDarbas?serverTimezone=UTC";

    @SneakyThrows
    public static void createCswFileAllContacts() {

        String csvFilePath = "Contacts.csv";

        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select * from customer;");

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));

        while (result.next()) {
            int customerId = result.getInt("customerId");
            String name = result.getString("name");
            String phoneNumber = result.getString("phoneNumber");
            String customerType = result.getString("customerType");

            if (customerType == null) {
                customerType = "n/a";   // write n/a if null
            } else {
                customerType = "\"" + customerType + "\""; // escape double quotes
            }

            String line = String.format("\"%s\",%s,%s,%s",
                    customerId, name, phoneNumber, customerType);

            fileWriter.newLine();
            fileWriter.write(line);
        }

        statement.close();
        fileWriter.close();
        System.out.println("Your CSW file is successfully created");

    }
}
