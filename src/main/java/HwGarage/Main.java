package HwGarage;

import java.sql.*;

public class Main {

    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "admin";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/namudarbas";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        Statement statement = connection.createStatement();

//        getAllCars
        ResultSet getAllCars = statement.executeQuery("SELECT * FROM car;");
        System.out.println("List of all cars:");
        while (getAllCars.next()) {
            String carMake = getAllCars.getString("car_make");
            String carModel = getAllCars.getString("car_model");
            String carYear = getAllCars.getString("car_model_year");
            String carVin = getAllCars.getString("car_vin");
            System.out.println("Owner car data: " + carMake + "," + carModel + "," + carYear + carVin);
           }
        //getAllCarsAndOwners
//            ResultSet allCars = statement.executeQuery("SELECT * FROM car, person WHERE car.id = person.id;");
//            while (allCars.next()) {
//            String carMake = allCars.getString("car_make");
//            String carModel = allCars.getString("car_model");
//            String carYear = allCars.getString("car_model_year");
//            String carVin = allCars.getString("car_vin");
//
//            String ownerName = allCars.getString("first_name");
//            String ownerSurname = allCars.getString("last_name");
//            String ownerPhone = allCars.getString("phone");
//
//            System.out.println("Owner car data: " + carMake + "," + carModel + "," + carYear + carVin);
//            System.out.println("Owner data: "+ownerName+","+ownerSurname+","+ownerPhone);
//            System.out.println("----------------------------------------------------------------------");
//        }
        //getAllOwners
//        ResultSet getAllOwners = statement.executeQuery("SELECT * FROM person;");
//        System.out.println("List of all owners:");
//        while (getAllOwners.next()) {
//            String ownerName = getAllOwners.getString("first_name");
//            String ownerSurname = getAllOwners.getString("last_name");
//            String ownerPhone = getAllOwners.getString("phone");
//            System.out.println(ownerName + "," + ownerSurname + "," + ownerPhone);
//        }
        //UpdateCars

        //UpdateOwner
        //DeleteOwner


    }
}
