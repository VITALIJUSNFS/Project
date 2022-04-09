package example4bestPractices;

import example4bestPractices.Service.ResultSetPrintingService;
import example4bestPractices.repository.ProjectRepository;
import example4bestPractices.utils.DatabaseUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {


        ProjectRepository projectRepository = new ProjectRepository();
        ResultSet allProjects = projectRepository.findAll();

        ResultSetPrintingService printingService = new ResultSetPrintingService();
        printingService.printAllProjects(allProjects);

        ResultSet projectByBudget = projectRepository.findProjectsByBudget(25000);
        printingService.printAllProjects(projectByBudget);

        ResultSet projectByName = projectRepository.findByName("Pokemon");
        printingService.printAllProjects(projectByName);

        projectRepository.addProject("e-sveikata",5555);
        ResultSet newAdded = projectRepository.findByName("e-sveikata");
        printingService.printAllProjects(newAdded);

    }

}
