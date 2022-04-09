package example2;

public class DatabaseQueries {

    public static final String SELECT_ALL_EMPLOYEES_AND_DEPARTMENTS =
            "SELECT * FROM EMPLOYEES, DEPARTMENTS WHERE EMPLOYEES.departmentId = DEPARTMENTS.departmentId;";
}


