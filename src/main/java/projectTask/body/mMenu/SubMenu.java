package projectTask.body.mMenu;

import projectTask.body.adataImport.FromCsvFile;
import projectTask.body.adataImport.RawData;
import projectTask.body.cservices.HibernateUtil;
import projectTask.body.cservices.Services;

import java.sql.SQLException;
import java.util.Scanner;

public class SubMenu {

    private static Scanner scanner = new Scanner(System.in);

    public static void additionalMenuForDatabase() throws SQLException {

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
            SubMenu.additionalMenuForDatabase();
        } else if (selectionFromA == 2) {
            FromCsvFile.partsImportFromCSV();
            SubMenu.additionalMenuForDatabase();
        } else if (selectionFromA == 3) {
            FromCsvFile.vehiclesImportFromCSV();
            SubMenu.additionalMenuForDatabase();
        } else if (selectionFromA == 4) {
            RawData.addRawData();
            SubMenu.additionalMenuForDatabase();
        } else if (selectionFromA == 5) {
            HibernateUtil.getSessionFactoryCreate("create");
            SubMenu.additionalMenuForDatabase();
        } else if (selectionFromA == 6) {
            return;
        } else {
            SubMenu.additionalMenuForDatabase();
            System.out.println("Wrong input, choose input from 1-5");
        }
    }

    public static void subMenuFindData() throws SQLException {

        System.out.println("__________________________________________________________________________________");
        System.out.println("FIND DATA:                                                                        ");
        System.out.println("1.           4.                   ");
        System.out.println("2. Show all vehicles in database.          5. ");
        System.out.println("3.           6. Exit to Main menu                   ");
        System.out.println("__________________________________________________________________________________");

        System.out.print("Select action: ");
        int selectionFromA = scanner.nextInt();

        if (selectionFromA == 1) {
            Services.allVehiclesInDatabase();
            SubMenu.subMenuFindData();
        } else if (selectionFromA == 2) {

            SubMenu.subMenuFindData();
        } else if (selectionFromA == 3) {
            Services.showCommonData();

        } else if (selectionFromA == 4) {
            Services.allVehiclesInDatabase();
        } else if (selectionFromA == 5) {

        } else if (selectionFromA == 6) {
            return;
        } else {
            SubMenu.additionalMenuForDatabase();
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
            SubMenu.additionalMenuForDatabase();
            System.out.println("Wrong input, choose input from 1-5");
        }


        //                        HibernateUtil.getSessionFactoryCreate(null);
        //
        //                        Services.customerNameUpdate();
        //                        Services.deleteCustomer();
        //                        ToCsv.createCswFileAllContacts();
    }
}