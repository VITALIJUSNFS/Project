package projectTask.body;

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
                System.out.println("_____________");
                System.out.println("Choose operation");
                printMenuSelection();

                selection = scanner.next().charAt(0);

                switch (selection) {
                    case 'A':
                        Services.showAllVehiclesInSystem();
                        break;
                    case 'B':
                        Services.createCleanDatabaseTables();
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
                    case 'G':
                        HibernateUtilCreate.getSessionFactoryCreate();
                        break;
                    case 'H':
                        RawData.addRawData();
                        break;
                    case 'F':
                        ToCsv.createCswFileAllContacts();
                        break;
                    case 'I':
                        ToPdf.convertingToPdf();
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
        System.out.println("A. Show All Vehicles In System");
        System.out.println("B. List of all customers");
        // list of all cars // list of parts in stock
        System.out.println("C. List of serviced vehicles");
        System.out.println("D. Update customer name by ID");
        // update customer Type // update customer phoneNumber //

        // update brand // update regNr // change vehicle to another customerId/name
        System.out.println("E. Delete customer");
        System.out.println("F. Write contacts data to CSW file");
        System.out.println("G. Clean&CreateDatabase");
        System.out.println("H. Add raw data");
        System.out.println("I. Write to PDF file");
        //create order -
        //issue invoice use one customer, vehicle data, customer data, parts data -> add all to xls invoice
        System.out.println("X. EXIT");
    }
}

