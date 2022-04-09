package example4bestPractices.utils;

public class DatabaseQueries {

    // final - nekeiciama
    public static final String FIND_ALL_PROJECTS = "SELECT * FROM PROJECTS";
    public static final String FIND_PROJECTS_BY_BUDGET = "SELECT * FROM PROJECTS WHERE budget >= %d";
    public static final String FIND_PROJECTS_BY_NAME = "SELECT * FROM PROJECTS WHERE projectName = '%s'";
    public static final String ADD_PROJECT = "INSERT INTO PROJECTS (projectName, budget) VALUES ('%s', %d)";

}
