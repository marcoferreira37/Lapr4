package authz.ui;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.ColorCode;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.usermanagement.application.controllers.OrderedCandidatesController;
import eapli.base.usermanagement.application.controllers.ListAllApplicationsForJobOpeningController;

import java.util.List;

public class OrderedCandidatesUI extends AbstractUI {

    private final OrderedCandidatesController orderedCandidatesController = new OrderedCandidatesController();

    @Override
    protected boolean doShow() {
        System.out.println("=====================================================");
        System.out.println("|| List of Job Openings ||");
        List<JobOpening> openingList = orderedCandidatesController.findAllJobOpeningInResult();
        if (openingList.isEmpty()) {
            System.out.println("No job openings available!");
            return false;
        }

        printNumeratedList(openingList);
        int option = getUserOption(openingList.size());


        JobOpening jobOpening = openingList.get(option - 1);
        List<JobInterview> candidatesInterviews = orderedCandidatesController.orderedCandidatesOfJobOpening(jobOpening);
        if (candidatesInterviews.isEmpty()) {
            System.out.println("There are no candidates for this job opening!");
            return false;
        }

        for (JobInterview interview : candidatesInterviews) {
            System.out.println();
            System.out.println("=====================================================");
            System.out.println("Job Opening: " + interview.jobOpeningApplication().jobOpening().identity().fullReference());
            System.out.println("Candidate: " + interview.jobOpeningApplication().candidate().identity());
            System.out.println("Grade: " + interview.grade());
            System.out.println("=====================================================");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Ordered Candidates";
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