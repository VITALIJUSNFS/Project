package example3.frame;

import example3.frame.Department;

public class User {

    private int userId;
    private String fullName;
    private Department department; // kompozicija

    public User(int userId, String fullName, Department department) {
        this.userId = userId;
        this.fullName = fullName;
        this.department = department;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                '}';
    }
}
