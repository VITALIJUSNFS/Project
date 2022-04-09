package example2;

import java.sql.*;

public class Main {
    private static final String DATABASE_USER = "root"; //mano db user
    private static final String DATABASE_PASSWORD = "admin"; // mano db psw
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jdbcfun?serverTimezone=UTC";


    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet employeesAndDepartments = statement.executeQuery(DatabaseQueries.SELECT_ALL_EMPLOYEES_AND_DEPARTMENTS);

        while (employeesAndDepartments.next()) {
            int employeeId = employeesAndDepartments.getInt("employeeId");
            String employeeName = employeesAndDepartments.getString("fullName");

            int departmentId = employeesAndDepartments.getInt("employees.departmentId");
            String departmentName = employeesAndDepartments.getString("name");
            System.out.println("Em ID: " + employeeId + ", Name:" + employeeName + ", Dep Id:" + departmentId +
                    ". (" + departmentName + ")");
        }

    }
}
