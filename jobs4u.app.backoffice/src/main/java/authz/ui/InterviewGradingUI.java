package authz.ui;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.ColorCode;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.usermanagement.application.controllers.ListAllApplicationsForJobOpeningController;

import java.util.List;

public class InterviewGradingUI extends AbstractUI {


    private final ListAllApplicationsForJobOpeningController controllerApplication = new ListAllApplicationsForJobOpeningController();

    @Override
    protected boolean doShow() {

        System.out.println("=====================================================");
        System.out.println("|| List of Job Openings ||");
        List<JobOpening> openingList = (List<JobOpening>) controllerApplication.allJobOpenings();
        if (openingList.isEmpty()) {
            System.out.println("No job openings available!");
            return false;
        }
        printNumeratedList(openingList);
        int option = getUserOption(openingList.size());
        JobOpening jobOpening = openingList.get(option - 1);
        List<JobOpeningApplication> applications = controllerApplication.allApplicationsForJobOpening(jobOpening);
        if (applications.isEmpty()) {
            System.out.println("There are no applications for this job opening!");
            return false;
        }
        return true;
    }

    @Override
    public String headline() {
        return "Interview Grading";
    }

    public void printNumeratedList(List<JobOpening> openingList) {
        System.out.printf("%s\n\n", "\nChoose a job opening: ");

        int index = 1;
        for (JobOpening item : openingList) {
            System.out.println(ColorCode.BLUE.getValue() + index + ColorCode.RESET.getValue() + " - " + "Job Reference: " + item.identity().fullReference());
            index++;
        }
        System.out.println();
    }

    private int getUserOption(int size) {
        int option;
        while (true) {
            try {
                option = Integer.parseInt(Console.readLine("Select a job opening: "));
                if (option > 0 && option <= size) {
                    break;
                } else {
                    System.out.println("Invalid option. Please choose a number between 1 and " + size + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return option;
    }
}
