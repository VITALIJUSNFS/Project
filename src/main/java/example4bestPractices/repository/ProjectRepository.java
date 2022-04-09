package example4bestPractices.repository;

import example4bestPractices.utils.DatabaseQueries;
import example4bestPractices.utils.DatabaseUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * servise responsible for interakting with database table projects.
 * provides CRUD (create/read/update/delete) method implementatio, like
 * findAll, findById,Update,etc ...
 */

public class ProjectRepository {

    //galima grazinti List<Projects> jei resulta sumapint
    public ResultSet findAll() {
        ResultSet projectResultSet = null;

        try {
            Statement statement = DatabaseUtils.databaseConnection.createStatement();
            projectResultSet = statement.executeQuery(DatabaseQueries.FIND_ALL_PROJECTS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectResultSet;
    }

    /**
     * Find projects which budgets are more than given margin
     *
     * @param budget given budget margin
     * @return all projects which are more expensive than given
     */
    public ResultSet findProjectsByBudget(int budget) {
        ResultSet projectResultSet = null;
        try {
            Statement statement = DatabaseUtils.databaseConnection.createStatement();
            String sql = String.format(DatabaseQueries.FIND_PROJECTS_BY_BUDGET, budget);
            projectResultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectResultSet;
    }

    public ResultSet findByName(String projectName) {
        ResultSet projectResultSet = null;

        try {
            Statement statement = DatabaseUtils.databaseConnection.createStatement();
            String sql = String.format(DatabaseQueries.FIND_PROJECTS_BY_NAME, projectName);
            projectResultSet = statement.executeQuery(sql);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return projectResultSet;

    }

    public void addProject(String projectName, int budget) {
        int affectedRows = 0;

        try {
            Statement statement = DatabaseUtils.databaseConnection.createStatement();
            String sql = String.format(DatabaseQueries.ADD_PROJECT, projectName, budget);
            affectedRows = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (affectedRows == 1) {
            System.out.println("Project added");
        }

    }



}
