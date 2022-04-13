package projectTask.body.mMenu;

import projectTask.body.adataImport.FromCsvFile;
import projectTask.body.adataImport.RawData;
import projectTask.body.cservices.HibernateUtil;

import java.sql.SQLException;
import java.util.Scanner;

public class SubMenu {

    private static Scanner scanner = new Scanner(System.in);

    public static void additionalMenuForDatabase() throws SQLException {

        System.out.println("__________________________________________________________________________________");
        System.out.println("1. Customer data import from CSW.          4. Test data loading.                  ");
        System.out.println("2. Parts data import from CSW.             5. Delete all data & reCreate Database.");
        System.out.println("3. Vehicles data import from CSW.          6. Exit to Main menu                   ");
        System.out.println("__________________________________________________________________________________");

        System.out.print("Select action: ");
        int selectionFromA = scanner.nextInt();

        if (selectionFromA == 1) {
            FromCsvFile.customersImportFromCSV();
        } else if (selectionFromA == 2) {
            FromCsvFile.partsImportFromCSV();
        } else if (selectionFromA == 3) {
            FromCsvFile.vehiclesImportFromCSV();
        } else if (selectionFromA == 4) {
            RawData.addRawData();
        } else if (selectionFromA == 5) {
            HibernateUtil.getSessionFactoryCreate("create");
        } else if (selectionFromA == 6) {
            return;
        } else {
            SubMenu.additionalMenuForDatabase();
            System.out.println("Wrong input, choose input from 1-5");

            //                        HibernateUtil.getSessionFactoryCreate(null);
            //                        Services.showCommonData();
            //                        Services.allVehiclesInDatabase();
            //                        Services.customerNameUpdate();
            //                        Services.deleteCustomer();
            //                        ToCsv.createCswFileAllContacts();
        }
    }
}