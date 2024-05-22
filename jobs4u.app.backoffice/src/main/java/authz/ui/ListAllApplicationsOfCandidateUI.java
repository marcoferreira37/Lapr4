package authz.ui;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.ColorCode;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.candidate.Candidate;
import eapli.base.usermanagement.application.controllers.ListAllDataOfCandidateController;

import java.util.List;

public class ListAllApplicationsOfCandidateUI extends AbstractUI {

    private final ListAllDataOfCandidateController controller = new ListAllDataOfCandidateController();

    @Override
    protected boolean doShow() {

        List<Candidate> candidates = (List<Candidate>) controller.allCandidates();

        if (candidates.isEmpty()) {
            System.out.println("There are no candidates in the system.");
            return false;
        }
        printCandidateNumeratedList("Candidate List:", candidates);
        int option = Console.readInteger("Select a candidate: ");

        List<JobOpeningApplication> applications = (List<JobOpeningApplication>) controller.allApplicationsById(candidates.get(option - 1));
        if (applications.isEmpty()) {
            System.out.println("There are no applications for this candidate.");
            return false;
        }
        printApplicationNumeratedList("Applications List:", applications);


        return false;
    }

    public void printCandidateNumeratedList(String message, List<Candidate> collection) {
        System.out.printf("%s\n\n", message);

        int index = 1;
        for (Candidate item : collection) {
            System.out.println(ColorCode.BLUE.getValue() + index + ColorCode.RESET.getValue() + " - " + "Candidate Id: " + item.identity() );
            index++;
        }
        System.out.println();
    }

    public void printApplicationNumeratedList(String message, List<JobOpeningApplication> collection) {
        System.out.printf("%s\n\n", message);

        int index = 1;
        for (JobOpeningApplication item : collection) {
            System.out.println(ColorCode.BLUE.getValue() + index + ColorCode.RESET.getValue() + " - " + "Application:" + item.toString());
            index++;
        }
        System.out.println();
    }
    @Override
    public String headline() {
        return "List All Applications Of Candidate";
    }
}
