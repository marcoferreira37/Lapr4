package authz;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.domain.JobApplication.JobOpeningApplication;
import eapli.base.domain.candidate.Candidate;
import eapli.base.usermanagement.application.RecordInterviewController;
import eapli.framework.io.util.Console;

import java.util.List;

public class RecordInterviewUI extends AbstractUI {

    public RecordInterviewController recordController = new RecordInterviewController();

    @Override
    protected boolean doShow() {

        List<JobOpeningApplication> jobOpeningApplicationsList = recordController.getJobOpeningApplication();

        for (int i = 0; i < jobOpeningApplicationsList.size(); i++) {
            System.out.println((i+1) + ". " + jobOpeningApplicationsList.get(i).toString());
        }
        int jobIndex = Console.readInteger("Choose a Job Opening Application: ");
        JobOpeningApplication jobOpeningApplication = jobOpeningApplicationsList.get(jobIndex-1);

        System.out.println("Job Opening Application choosen: " + jobOpeningApplication.toString());


        Candidate candidate = recordController.getCandidate(jobOpeningApplication);

        System.out.println("Candidate associado: " + candidate.toString());





        return true;
    }

    @Override
    public String headline() {
        return "Record Interview";
    }

}
