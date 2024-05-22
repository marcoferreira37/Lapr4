package authz;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.ColorCode;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.customer.RankApplicationController;
import eapli.base.domain.JobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.usermanagement.application.ListAllApplicationsForJobOpeningController;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RankApplicationUI extends AbstractUI {


    private final RankApplicationController theController = new RankApplicationController();
    private final ListAllApplicationsForJobOpeningController controllerApplication = new ListAllApplicationsForJobOpeningController();


    @Override
    protected boolean doShow() {


        System.out.println("=====================================================");
        System.out.println("|| List of Job Openings ||");
        List<JobOpening> openingList = (List<JobOpening>) controllerApplication.allJobOpenings();
        printNumeratedList("\nChoose a job opening: ", openingList);
        int option = Integer.parseInt(eapli.base.app.common.console.ui.components.Console.readLine("Select a job opening: "));
        JobOpening jobOpening = openingList.get(option - 1);
        List<JobOpeningApplication> applications = controllerApplication.allApplicationsForJobOpening(jobOpening);
        if (applications.isEmpty()) {
            System.out.println("There are no applications for this job opening.");
            return false;
        }
        for (JobOpeningApplication application : applications) {
            rankApplication(application);
        }
        printApplications(getSortedApplicationsByRank(applications));


        return false;
    }

    /**
     * Rank an application for a job opening
     * @param application the application to rank
     */
    private void rankApplication(JobOpeningApplication application) {
        System.out.println("Application ID: " + application.identity());
        System.out.println("Candidate: " + application.candidate().identity());
        System.out.println("Job Opening Reference: " + application.jobOpening().identity().fullReference());
        System.out.println();

        // Ask for a new rank until it's unique among all applications for the job opening
        int newRank;
        boolean isUnique;
        do {
            newRank = Console.readInteger("Rank the application: ");
            isUnique = isRankUnique(newRank, controllerApplication.allApplicationsForJobOpening(application.jobOpening()));
            if (!isUnique) {
                System.out.println("Error: The rank must be unique among all applications for this job opening. Please enter a different rank.");
            }
        } while (!isUnique);

        // Update the rank in the database with the new rank
        theController.rankApplication(application, newRank);
    }

    /**
     * Check if a rank is unique among all applications for a job opening
     * @param rank the rank to check
     * @param allApplications all applications for the job opening
     * @return true if the rank is unique, false otherwise
     */
    private boolean isRankUnique(int rank, List<JobOpeningApplication> allApplications) {
        for (JobOpeningApplication app : allApplications) {
            if (app.showRanking() == rank) {
                return false;
            }
        }
        return true;
    }

    /**
     * Print a list of job openings with a number for each one
     * @param message the message to print before the list
     * @param openingList the list of job openings
     */
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

    /**
     * Print a list of applications
     * @param applications the list of applications to print
     */
    public void printApplications(List<JobOpeningApplication> applications) {
        for (JobOpeningApplication application : applications) {
            System.out.println("\n///////////Application///////////");
            System.out.println();
            System.out.println("Application ID: " + application.identity());
            System.out.println("Candidate: " + application.candidate().identity());
            System.out.println("Job Opening Reference: " + application.jobOpening().identity().fullReference());
            System.out.println("Rank: " + application.showRank());
            System.out.println();
            System.out.println("/////////////////////////////////\n");
        }
    }

    /**
     * Get applications sorted by rank
     * @param applications the list of applications
     * @return the list of applications sorted by rank
     */
    private List<JobOpeningApplication> getSortedApplicationsByRank(List<JobOpeningApplication> applications) {
        applications.sort(Comparator.comparingInt(JobOpeningApplication::showRanking)); // Descending order
        return applications;
    }
}
