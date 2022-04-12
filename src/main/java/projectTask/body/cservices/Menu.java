package projectTask.body.cservices;

import projectTask.body.adataImport.RawData;
import projectTask.body.export.ToCsv;
import projectTask.body.export.ToPdf;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    public static void display_menu() throws SQLException {

        String setUserName = "admin";
        String setUserPassword = "admin";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user Account: ");
        String userAccount = scanner.next();
        System.out.print("Enter user password: ");
        String userPass = scanner.next();

        if (userAccount.equals(setUserName) && userPass.equals(setUserPassword)) {
            System.out.println("Welcome");
            char selection;

            do {
                System.out.println("------------------LOADING :)------------------");
                System.out.println("------------- Detailing Service --------------");
                System.out.println("--------------Select from Menu----------------");

                printMenuSelection();

                selection = scanner.next().charAt(0);

                switch (selection) {
                    case 'A':
                        Services.allVehiclesInDatabase();
                        break;
                    case 'B':
                        HibernateUtil.getSessionFactoryCreate(null);
                        break;
                    case 'C':
                        Services.showCommonData();
                        break;
                    case 'D':
                        Services.customerNameUpdate();
                        break;
                    case 'E':
                        Services.deleteCustomer();
                        break;
                    case 'H':
                        RawData.addRawData();
                        System.out.println("Test data uploaded");
                        break;
                    case 'F':
                        ToCsv.createCswFileAllContacts();
                        break;
                    case 'I':
                        ToPdf.convertingToPdf();
                        break;
                    case 'J':
                        HibernateUtil.getSessionFactoryCreate("create");
                        break;
                }
            }
            while (selection != 'X');
            System.out.println("List of registered vehicles in system");
        } else {
            System.out.println("Wrong password");
        }
    }

    private static void printMenuSelection() {
        System.out.println("Database actions ");
        System.out.println("D1. Customer data import from CSW.          D2. Test data (/).");
        System.out.println("Dx. Parts data import from CSW.             D2. Test data (/).");
        System.out.println("Dx. Vehicles data import from CSW.          D2. Test data (H).");
        System.out.println("D3. Delete all data & reCreate Database.(J)");
        //System.out.println("J. Clean all data & Create Database");
        //System.out.println("H. Add test data");
        System.out.println("Create");
        System.out.println("A. Show All Vehicles In System");
        System.out.println("B. List of all customers");

        System.out.println("Find");
        // list of all cars // list of parts in stock
        System.out.println("C. List of serviced vehicles");

        System.out.println("Update");
        System.out.println("D. Update customer name by ID");
        // update customer Type // update customer phoneNumber //
        // update brand // update regNr // change vehicle to another customerId/name

        System.out.println("Delete");
        System.out.println("K. Delete customer by ID");

        System.out.println("Parts stock");
        //show current stock and stock value

        System.out.println(" Order");
        //create order - add/create vehicle to order,
        // add/create customer to order,
        // add part from stock

        System.out.println("Output data");
        System.out.println("F. Write contacts data to CSW file              I. Write to PDF file ");
        //issue invoice for order, needed vehicle data, customer data, parts data -> invoice

        System.out.println("X. EXIT");
    }
}

