package projectTask.body.eEnum;

public class DatabaseQueries {

    public static final String CUSTOMERS_IMPORT_FROM_CSW =
            "INSERT INTO CUSTOMER (customerType, name, phoneNumber) VALUES (?,?,?);";
    //
    public static final String PARTS_IMPORT_FROM_CSW =
            "insert into parts (partName,partNumber,price,quantity,customerId) values (?,?,?,?,?);";
    //
    public static final String VEHICLES_IMPORT_FROM_CSW =
            "INSERT INTO VEHICLE (brand,carType,regNr) values (?,?,?);";
}

