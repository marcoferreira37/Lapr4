package authz;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.ColorCode;
import eapli.base.customer.RankApplicationController;
import eapli.base.domain.JobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.usermanagement.application.ListAllApplicationsForJobOpeningController;

import java.util.List;

public class RankApplicationUI extends AbstractUI {


    private final RankApplicationController theController = new RankApplicationController();
    private ListAllApplicationsForJobOpeningController controllerApplication = new ListAllApplicationsForJobOpeningController();


    @Override
    protected boolean doShow() {


        System.out.println("=====================================================");
        System.out.println("List of Job Openings");
        List<JobOpening> openingList = (List<JobOpening>) controllerApplication.allJobOpenings();
        printNumeratedList("Choose a job opening", openingList);
        int option = Integer.parseInt(eapli.base.app.common.console.ui.components.Console.readLine("Select a job opening: "));
        JobOpening jobOpening = openingList.get(option - 1);
        List<JobOpeningApplication> applications = controllerApplication.allApplicationsForJobOpening(jobOpening);
        if (applications.isEmpty()) {
            System.out.println("There are no applications for this job opening.");
            return false;
        }
        printApplications(applications);


        return false;
    }

    private void printNumeratedList(String message, List<JobOpening> openingList) {
        System.out.printf("%s\n\n", message);

        int index = 1;
        for (JobOpening item : openingList) {
            System.out.println(ColorCode.BLUE.getValue() + index + ColorCode.RESET.getValue() + " - " + "Job Reference: " + item.identity().fullReference());
            index++;
        }
        System.out.println();
    }


    @Override
    public String headline() {
        return "Rank Application";
    }

    public void printApplications(List<JobOpeningApplication> applications){
        for (JobOpeningApplication application : applications) {
            System.out.println("///////////Application///////////");
            System.out.println("Application ID: " + application.identity());
            System.out.println("Candidate: " + application.candidate().identity());
            System.out.println("Job Opening Reference: " + application.jobOpening().identity().fullReference());
            System.out.println("/////////////////////////////////");
        }
    }


}
