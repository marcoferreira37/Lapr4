package authz.ui;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.ColorCode;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.usermanagement.application.controllers.InterviewGradingController;
import eapli.base.usermanagement.application.controllers.ListAllApplicationsForJobOpeningController;

import java.util.List;

public class InterviewGradingUI extends AbstractUI {


    private final ListAllApplicationsForJobOpeningController controllerApplication = new ListAllApplicationsForJobOpeningController();

    private final InterviewGradingController controllerInterview = new InterviewGradingController();

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

        System.out.println("=====================================================");
        System.out.println("|| List of Applications ||");
        printNumeratedListApplications(applications);
        int applicationOption = getUserOption(applications.size());
        JobOpeningApplication selectedApplication = applications.get(applicationOption - 1);

        List<JobInterview> interviews = selectedApplication.getInterviews();
        if (interviews.isEmpty()) {
            System.out.println("There are no interviews for this application!");
            return false;
        }

        System.out.println("=====================================================");
        System.out.println("|| List of Interviews ||");
        printNumeratedListInterviews(interviews);
        int interviewOption = getUserOption(interviews.size());
        JobInterview selectedInterview = interviews.get(interviewOption - 1);

        System.out.println("Enter the grade for the interview (0-100):");
        int grade = Console.readInteger("Grade: ");

        controllerInterview.gradeInterview(selectedInterview.jobOpeningApplication(), grade);

        System.out.println("Interview graded successfully!");

        return true;
    }

    private void printNumeratedListInterviews(List<JobInterview> interviews) {
        System.out.printf("%s\n\n", "\nChoose an interview: ");
        int index = 1;
        for (JobInterview item : interviews) {
            System.out.println(ColorCode.BLUE.getValue() + index + ColorCode.RESET.getValue() + " - " + "Interview Date: " + item.interviewDate() + " Interview Time: " + item.interviewTime());
            index++;
        }
        System.out.println();
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


    public void printNumeratedListApplications(List<JobOpeningApplication> openingListApplication) {
        System.out.printf("%s\n\n", "\nChoose a job opening application: ");
        int index = 1;
        for (JobOpeningApplication item : openingListApplication) {
            System.out.println(ColorCode.BLUE.getValue() + index + ColorCode.RESET.getValue() + " - " + "Job Reference: " + item.identity().toString());
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
