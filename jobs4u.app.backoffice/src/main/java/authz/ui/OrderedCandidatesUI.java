package authz.ui;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.ColorCode;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.candidate.Candidate;
import eapli.base.usermanagement.application.controllers.OrderedCandidatesController;
import eapli.base.usermanagement.application.controllers.ListAllApplicationsForJobOpeningController;

import java.util.List;

public class OrderedCandidatesUI extends AbstractUI {

    private final ListAllApplicationsForJobOpeningController controllerApplication = new ListAllApplicationsForJobOpeningController();
    private final OrderedCandidatesController orderedCandidatesController = new OrderedCandidatesController();

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
        List<Candidate> candidates = orderedCandidatesController.orderedCandidatesOfJobOpening(jobOpening);
        if (candidates.isEmpty()) {
            System.out.println("There are no candidates for this job opening!");
            return false;
        }

        printCandidates(candidates);

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

    public void printCandidates(List<Candidate> candidates) {
        System.out.println("=====================================================");
        System.out.println("|| Ordered List of Candidates ||");
        int index = 1;
        for (Candidate candidate : candidates) {
            System.out.printf("%d. Candidate: %s, Highest Grade: %.2f%n",
                    index++, candidate.identity(), getHighestInterviewGrade(candidate));
        }
    }

    private double getHighestInterviewGrade(Candidate candidate) {
        return 12;
    }
}