package detailingProject.body.mMenu;

import detailingProject.body.cservices.Services;

import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {


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

                System.out.println("------------- Detailing Service --------------");
                printMenuSelection();

                System.out.print("Select from Menu: ");
                selection = scanner.next().charAt(0);

                switch (selection) {
                    case 'A':
                        SubMenu.subMenuDatabase();
                        break;
                    case 'B':
                        SubMenu.subMenuFindData();
                        break;
                    case 'C':
                        SubMenu.subMenuUpdateData();
                        break;
                    case 'D':
                        break;
                    case 'E':
                        break;
                    case 'F':
                        Services.deleteCustomer();
                        break;
                }
            }
            while (selection != 'X');
        } else {
            System.out.println("Wrong password");
        }
    }

    static void printMenuSelection() {
        System.out.println("__________________________________________________________________________________");
        System.out.println("A. Database actions        C. Update data");
        System.out.println("B. Find data               D. Create data");
        System.out.println();
        System.out.println("E. Create order            F.Delete");

        System.out.println("G. Issue invoice");

        System.out.println("X. Save and close");
        System.out.println("__________________________________________________________________________________");

//        System.out.println("A. Show All Vehicles In System");
//        System.out.println("B. List of all customers");
//
//        System.out.println("Find");
//        // list of all cars // list of parts in stock
//        System.out.println("C. List of serviced vehicles");
//
//        System.out.println("Update");
//        System.out.println("D. Update customer name by ID");
//        // update customer Type // update customer phoneNumber //
//        // update brand // update regNr // change vehicle to another customerId/name
//
//        System.out.println("Delete");
//        System.out.println("K. Delete customer by ID");

//        System.out.println("Order");
//        //create order - add/create vehicle to order,
//        // add/create customer to order,
//
//        System.out.println("Output data");
//        System.out.println("F. Write contacts data to CSW file              I. Write to PDF file ");
        //issue invoice for order, needed vehicle data, customer data, parts data -> invoice
        //Count orders in period of time x-x / Earned / ...
    }
}

