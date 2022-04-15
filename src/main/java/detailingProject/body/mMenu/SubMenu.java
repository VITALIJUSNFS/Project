package detailingProject.body.mMenu;

import detailingProject.body.adataImport.FromCsvFile;
import detailingProject.body.adataImport.RawData;
import detailingProject.body.cservices.HibernateUtil;
import detailingProject.body.cservices.Services;

import java.sql.SQLException;
import java.util.Scanner;

import static detailingProject.body.mMenu.MainMenu.printMenuSelection;

public class SubMenu {

    private static Scanner scanner = new Scanner(System.in);

    public static void subMenuDatabase() throws SQLException {

        System.out.println("__________________________________________________________________________________");
        System.out.println("DATABASE ACTIONS                                                                  ");
        System.out.println("1. Customer data import from CSW.          4. Test data loading.                  ");
        System.out.println("2. Parts data import from CSW.             5. Delete all data & reCreate Database.");
        System.out.println("3. Vehicles data import from CSW.          6. Exit to Main menu                   ");
        System.out.println("__________________________________________________________________________________");

        System.out.print("Select action: ");
        int selectionFromA = scanner.nextInt();

        if (selectionFromA == 1) {
            FromCsvFile.customersImportFromCSV();
            SubMenu.subMenuDatabase();
        } else if (selectionFromA == 2) {
            FromCsvFile.partsImportFromCSV();
            SubMenu.subMenuDatabase();
        } else if (selectionFromA == 3) {
            FromCsvFile.vehiclesImportFromCSV();
            SubMenu.subMenuDatabase();
        } else if (selectionFromA == 4) {
            RawData.addRawData();
            SubMenu.subMenuDatabase();
        } else if (selectionFromA == 5) {
            HibernateUtil.getSessionFactoryCreate("create");
            SubMenu.subMenuDatabase();
        } else if (selectionFromA == 6) {
            return;
        } else {
            SubMenu.subMenuDatabase();
            System.out.println("Wrong input, choose input from 1-5");
        }
    }

    public static void subMenuFindData() throws SQLException {

        System.out.println("__________________________________________________________________________________");
        System.out.println("FIND DATA:                                                                        ");
        System.out.println("1. ALL CUSTOMERS IN DATABASE");
        System.out.println("2. ALL VEHICLES IN DATABASE");
        System.out.println("3. ALL PARTS IN DATABASE");
        System.out.println("4. ALL COMMON DATA IN DATABASE");
        System.out.println("5. TO MAIN MENU");
        System.out.println("__________________________________________________________________________________");

        System.out.print("Select action: ");
        int selectionFromA = scanner.nextInt();

        if (selectionFromA == 1) {
            Services.allCustomersInDatabase();
            SubMenu.subMenuFindData();
        } else if (selectionFromA == 2) {
            Services.allVehiclesInDatabase();
            SubMenu.subMenuFindData();
        } else if (selectionFromA == 3) {
            Services.allPartsInDatabase();
            SubMenu.subMenuFindData();
        } else if (selectionFromA == 4) {
            Services.showCommonData();
            SubMenu.subMenuFindData();
        } else if (selectionFromA == 5) {
            printMenuSelection();
        } else {
            SubMenu.subMenuDatabase();
            System.out.println("Wrong input, choose input from 1-5");
        }
    }

    public static void subMenuUpdateData() throws SQLException {
        System.out.println("__________________________________________________________________________________");
        System.out.println("UPDATE SELECTION:                                                                        ");
        System.out.println("1.CUSTOMER NAME UPDATE");
        System.out.println("2.CUSTOMER TYPE UPDATE");
        System.out.println("3.CUSTOMER PHONE NUMBER");
        System.out.println("4.CUSTOMER ALL FIELDS UPDATE");
        System.out.println("__________________________________________________________________________________");

        System.out.print("Select action: ");
        int selectionFromA = scanner.nextInt();

        if (selectionFromA == 1) {
            Services.customerNameUpdate();
            subMenuUpdateData();
        } else if (selectionFromA == 2) {
            Services.customerTypeToUpdate();
            subMenuUpdateData();
        } else if (selectionFromA == 3) {
            Services.customerPhoneNumberToUpdate();
            subMenuUpdateData();
        } else if (selectionFromA == 4) {

        } else if (selectionFromA == 5) {

        } else if (selectionFromA == 6) {
            return;
        } else {
            SubMenu.subMenuDatabase();
            System.out.println("Wrong input, choose input from 1-5");
        }


        //                        HibernateUtil.getSessionFactoryCreate(null);
        //
        //                        Services.customerNameUpdate();
        //                        Services.deleteCustomer();
        //                        ToCsv.createCswFileAllContacts();
    }
}