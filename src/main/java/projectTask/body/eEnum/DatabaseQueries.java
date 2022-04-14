package projectTask.body.eEnum;

import projectTask.body.cservices.Services;

public class DatabaseQueries {

    //FOR CSV FILE
    public static final String CUSTOMERS_IMPORT_FROM_CSW =
            "INSERT INTO CUSTOMER (customerType, name, phoneNumber) VALUES (?,?,?);";
    public static final String PARTS_IMPORT_FROM_CSW =
            "insert into parts (partName,partNumber,price,quantity,customerId) values (?,?,?,?,?);";
    public static final String VEHICLES_IMPORT_FROM_CSW =
            "INSERT INTO VEHICLE (brand,carType,regNr) values (?,?,?);";
    //FOR SERVICES / FIND DATA
    public static final String ALL_PARTS_IN_DATABASE =
            "SELECT * FROM parts";
    public static final String ALL_VEHICLES_IN_DATABASE =
            "SELECT * FROM vehicles";
    public static final String ALL_ORDERS_IN_DATABASE =
            "SELECT * FROM orders";
    public static final String ALL_OFFERS_IN_DATABASE =
            "SELECT * FROM offers";
    //FOR SERVICES / DELETE DATA
    public static final String DELETE_CUSTOMER_BY_ID =
            "delete from customer where customerId ='";
    public static final String DELETE_PART_BY_ID =
            "delete from customer where partId ='";
    public static final String DELETE_VEHICLE_BY_ID =
            "delete from customer where vehicleId ='";
    public static final String DELETE_ORDER_BY_ID =
            "delete from customer where orderId ='";
    public static final String DELETE_OFFER_BY_ID =
            "delete from customer where serviceId ='";
    //FOR SERVICES / UPDATE DATA
    public static final String CUSTOMER_NAME_TO_UPDATE_BY_ID =
            "UPDATE customer SET name = '" + Services.newCustomerName + "' where customerId = '" + Services.customerIdIdentifier + "';";
    public static final String CUSTOMER_TYPE_TO_UPDATE_BY_ID =
            "UPDATE customer SET customerType = '" + Services.newCustomerType + "' where customerId = '" + Services.customerIdIdentifier + "';";
    public static final String CUSTOMER_PHONE_NUMBER_TO_UPDATE_BY_ID =
            "UPDATE customer SET phoneNumber = '" + Services.newCustomerPhoneNumber + "' where customerId = '" + Services.customerIdIdentifier + "';";
    public static final String CUSTOMER_UPDATE_ALL_DATA =
            "UPDATE customer SET NAME = '" + Services.newCustomerName + "' where customerId = '" + Services.customerIdIdentifier + "';";
    //FOR SERVICE / NEW CUSTOMER / PART / VEHICLE / ORDER / OFFER
    public static final String NEW_DATA_INPUT =
            "INSERT INTO customer  (customerType, name, phoneNumber) '" + Services.newCustomerName + "' VALUES = '" + Services.customerIdIdentifier + "';";
    // VALUES ('Client', 'Simpson', '+37065656565');
}

