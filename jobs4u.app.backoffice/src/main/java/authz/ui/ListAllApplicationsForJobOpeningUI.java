package authz.ui;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.ColorCode;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.usermanagement.application.controllers.ListAllApplicationsForJobOpeningController;

import java.util.List;

public class ListAllApplicationsForJobOpeningUI extends AbstractUI {
    private final ListAllApplicationsForJobOpeningController controller = new ListAllApplicationsForJobOpeningController();

    @Override
    protected boolean doShow() {
        List<JobOpening> openingList = (List<JobOpening>) controller.allJobOpenings();
        printNumeratedList("Choose a job opening", openingList);
        int option = Integer.parseInt(eapli.base.app.common.console.ui.components.Console.readLine("Select a job opening: "));
        JobOpening jobOpening = openingList.get(option - 1);
        List<JobOpeningApplication> applications = controller.allApplicationsForJobOpening(jobOpening);
        if (applications.isEmpty()) {
            System.out.println("There are no applications for this job opening.");
            return false;
        }
        printApplicationsId(applications);

        showApplicationData("You want to display all the data of an application?", applications);

        return false;
    }
    public void printNumeratedList(String message, List<JobOpening> collection) {
        System.out.printf("%s\n\n", message);

        int index = 1;
        for (JobOpening item : collection) {
            System.out.println(ColorCode.BLUE.getValue() + index + ColorCode.RESET.getValue() + " - " + "Job Reference: " + item.identity().fullReference() );
            index++;
        }
        System.out.println();
    }

    public void printApplicationsId(List<JobOpeningApplication> applications) {
        int index = 1;
        for (JobOpeningApplication application : applications) {
            System.out.println(ColorCode.BLUE.getValue() + index + ColorCode.RESET.getValue() + " - " + "Application ID: " + application.identity());
            System.out.println("/////////////////////////////////");
            index++;
        }
    }


    public void showApplicationData(String message, List<JobOpeningApplication> applications) {
        System.out.println(message + " (yes/no)");
        String response = eapli.base.app.common.console.ui.components.Console.readLine("Your choice: ");
        if (response.equalsIgnoreCase("yes")) {
            int applicationIndex = Integer.parseInt(eapli.base.app.common.console.ui.components.Console.readLine("Enter the index of the application: "));
            if (applicationIndex > 0 && applicationIndex <= applications.size()) {
                JobOpeningApplication application = applications.get(applicationIndex - 1);
                System.out.println("///////////Full Application Data///////////");
                System.out.println("Application ID: " + application.identity());
                System.out.println("Candidate: " + application.candidate().identity());
                System.out.println("Job Opening Reference: " + application.jobOpening().identity().fullReference());
                System.out.println("Rank: " + application.showRanking());
                System.out.println("/////////////////////////////////");
            } else {
                System.out.println("Invalid application number.");
            }
        } else {
            System.out.println("Returning to customer manager menu.");
        }
    }

    @Override
    public String headline() {
        return "List All Ranked Applications For Job Opening";
    }
}
