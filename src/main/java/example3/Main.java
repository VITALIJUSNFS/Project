package example3;

import example3.frame.Department;
import example3.frame.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String DATABASE_USER = "root"; //mano db user
    private static final String DATABASE_PASSWORD = "admin"; // mano db psw
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jdbcfun2?serverTimezone=UTC";

    public static void main(String[] args) {

        List<User> users = new ArrayList<>(); // tuscias userio sarasas

        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users inner join departments " +
                    "on USERS.departmentId=DEPARTMENTS.departmentId;");

            while (resultSet.next()) {
                //issitraukiam domenis is result seto ir patalpinam i kintamuosius
                int userId = resultSet.getInt("users.userId");
                String fullName = resultSet.getString("users.full_name");
                int departmentId = resultSet.getInt("departments.departmentId");
                String departmentName = resultSet.getString("departments.name");
                //mapinam reiksmes su objekto fildais
                Department department = new Department();
                department.setDepartmentId(departmentId);
                department.setName(departmentName);

                User user = new User();
                user.setUserId(userId);
                user.setFullName(fullName);
                user.setDepartment(department); // cia sarysis tarp userio ir departamento

                users.add(user);

            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        for (User user : users) {
            System.out.println("User name: "+ user.getFullName()+", works in: " + user.getDepartment().getName());
            // System.out.println(user.getDepartment().getName());
            //System.out.println(user);


        }
    }
}
