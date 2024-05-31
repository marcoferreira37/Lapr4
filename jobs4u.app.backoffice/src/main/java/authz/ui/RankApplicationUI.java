package authz.ui;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.ColorCode;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.usermanagement.application.controllers.RankApplicationController;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.usermanagement.application.controllers.ListAllApplicationsForJobOpeningController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RankApplicationUI extends AbstractUI {

    /**
     * The controller for ranking an application
     */
    private final RankApplicationController theController = new RankApplicationController();
    /**
     * The controller for listing all applications for a job opening
     */
    private final ListAllApplicationsForJobOpeningController controllerApplication = new ListAllApplicationsForJobOpeningController();

    /**
     * Show the UI
     *
     * @return true if the UI should keep running, false otherwise
     */
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

        Set<Integer> usedRanks = new HashSet<>();
        for (JobOpeningApplication application : applications) {
            rankApplication(application, applications.size(), usedRanks);
        }
        printApplications(applications);

        return false;
    }

    /**
     * Rank an application for a job opening
     *
     * @param application the application to rank
     * @param maxRank     the maximum rank value
     * @param usedRanks   the set of ranks that have already been used
     */
    private void rankApplication(JobOpeningApplication application, int maxRank, Set<Integer> usedRanks) {
        System.out.println("Application ID: " + application.identity());
        System.out.println("Candidate: " + application.candidate().identity());
        System.out.println("Job Opening Reference: " + application.jobOpening().identity().fullReference());
        System.out.println();

        // Ask for a new rank until it's unique among all applications for the job opening and within the valid range
        int newRank;
        boolean isValidRange;
        do {
            String input = Console.readLine("Rank the application (1 to " + maxRank + "): ");
            newRank = validInteger(input);
            isValidRange = newRank >= 1 && newRank <= maxRank;
            if (!isValidRange) {
                System.out.println("Error: The rank must be between 1 and " + maxRank + ". Please enter a valid rank.");
                continue;
            }
            if (usedRanks.contains(newRank)) {
                System.out.println("Error: The rank must be unique among all applications for this job opening. Please enter a different rank.");
                isValidRange = false;
            }
        } while (!isValidRange);

        // Mark the rank as used
        usedRanks.add(newRank);

        // Update the rank in the database with the new rank
        theController.rankApplication(application, newRank);
    }

    /**
     * Print a list of job openings with a number for each one
     *
     * @param openingList the list of job openings
     */
    public void printNumeratedList(List<JobOpening> openingList) {
        System.out.printf("%s\n\n", "\nChoose a job opening: ");

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

    /**
     * Print a list of applications
     *
     * @param applications the list of applications to print
     */
    public void printApplications(List<JobOpeningApplication> applications) {
        for (JobOpeningApplication application : applications) {
            System.out.println("\n///////////Application///////////");
            System.out.println();
            System.out.println("Application ID: " + application.identity());
            System.out.println("Candidate: " + application.candidate().identity());
            System.out.println("Job Opening Reference: " + application.jobOpening().identity().fullReference());
            System.out.println("Rank: " + application.showRanking());
            System.out.println();
            System.out.println("/////////////////////////////////\n");
        }
    }

    /**
     * Validate an integer input
     *
     * @param input the input to validate
     * @return the integer value if it's valid, -1 otherwise
     */
    public int validInteger(String input) {
        int result;
        try {
            String trimmedInput = input.trim();
            if (trimmedInput.isEmpty() || trimmedInput.equals("-")) {
                throw new NumberFormatException();
            }
            result = Integer.parseInt(trimmedInput);
            if (result < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            result = -1;
        }
        return result;
    }

    /**
     * Get the user's option
     *
     * @param size the size of the list of options
     * @return the user's option
     */
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