package authz.ui;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.usermanagement.application.controllers.RecordInterviewController;
import eapli.framework.io.util.Console;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecordInterviewUI extends AbstractUI {

    public RecordInterviewController recordController = new RecordInterviewController();
    boolean validInput = false;


    @Override
    protected boolean doShow() {

        Iterable<JobOpeningApplication> jobOpeningApplicationsIterable = recordController.getJobOpeningApplication();
        List<JobOpeningApplication> jobOpeningApplicationsList = new ArrayList<>();
        for (JobOpeningApplication application : jobOpeningApplicationsIterable) {
            jobOpeningApplicationsList.add(application);
        }

// Show the list of job opening applications
        System.out.println("Job Opening Applications:");
        int i = 1;
        for (JobOpeningApplication jobOpeningApplication : jobOpeningApplicationsList) {
            System.out.println(i + ". " + jobOpeningApplication.toString());
            i++;
        }
        int jobIndex = Console.readInteger("Choose a Job Opening Application: ") - 1;

// Verify if the index is valid
        JobOpeningApplication selectedApplication = jobOpeningApplicationsList.get(jobIndex);
        System.out.println("Job Opening Application chosen: " + selectedApplication.toString());

        while (!validInput) {
            try {
                Calendar interviewDate = Console.readCalendar("Interview Date (dd-MM-yyyy): ");
                interviewDate.add(Calendar.DAY_OF_MONTH, 1); // Definindo a data para amanhã

                String time = Console.readLine("Interview Time (HH:mm): ");
                String[] parts = time.split(":");
                String hours = parts[0];
                String minutes = parts[1];
                String interviewTime = String.format("%02d:%02d", Integer.parseInt(hours), Integer.parseInt(minutes));


                System.out.println(recordController.recordInterview(interviewDate, interviewTime, selectedApplication).toStringWithoutGrade());
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "Record Interview";
    }
}

