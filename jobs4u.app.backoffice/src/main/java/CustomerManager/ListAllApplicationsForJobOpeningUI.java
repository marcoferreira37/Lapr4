package CustomerManager;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.ColorCode;
import eapli.base.domain.JobApplication.JobOpeningApplication;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.usermanagement.application.ListAllApplicationsForJobOpeningController;
import eapli.base.usermanagement.application.ListPrinter;

import java.util.List;

public class ListAllApplicationsForJobOpeningUI extends AbstractUI {
    private ListAllApplicationsForJobOpeningController controller = new ListAllApplicationsForJobOpeningController();

    @Override
    protected boolean doShow() {
        List<JobOpening> openingList = (List<JobOpening>) controller.AllJobOpenings();
        printNumeratedList("Choose a job opening", openingList);
        int option = Integer.parseInt(eapli.base.app.common.console.ui.components.Console.readLine("Select a job opening: "));
        JobOpening jobOpening = openingList.get(option - 1);
        List<JobOpeningApplication> applications = controller.AllApplicationsForJobOpening(jobOpening);
        if (applications.isEmpty()) {
            System.out.println("There are no applications for this job opening.");
            return false;
        }
        ListPrinter lp = new ListPrinter<>("Applications for job opening " + jobOpening.identity().fullReference(), applications);
        lp.printNumeratedList();
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


    @Override
    public String headline() {
        return "List All Applications For Job Opening";
    }
}
