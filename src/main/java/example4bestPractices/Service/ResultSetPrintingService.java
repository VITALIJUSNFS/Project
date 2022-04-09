package example4bestPractices.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetPrintingService {

    public void printAllProjects(ResultSet projectResultSet) throws SQLException {
        while (projectResultSet.next()) {
            int projectId = projectResultSet.getInt("projectId");
            String projectName = projectResultSet.getString("projectName");
            int budget = projectResultSet.getInt("budget");
            System.out.println("Project ID: " + projectId + " Name: " + projectName + " Budget is: " + budget);
        }
        System.out.println();
    }
}
