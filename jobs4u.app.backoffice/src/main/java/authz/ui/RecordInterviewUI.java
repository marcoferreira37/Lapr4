package authz.ui;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.candidate.Candidate;
import eapli.base.usermanagement.application.controllers.RecordInterviewController;
import eapli.framework.io.util.Console;

import java.util.ArrayList;
import java.util.List;

public class RecordInterviewUI extends AbstractUI {

    public RecordInterviewController recordController = new RecordInterviewController();

    @Override
    protected boolean doShow() {

//        Iterable<JobOpeningApplication> jobOpeningApplicationsList = recordController.getJobOpeningApplication();
//
//        System.out.println("Job Opening Applications:");
//        int i = 1;
//        for (JobOpeningApplication jobOpeningApplication : jobOpeningApplicationsList) {
//            System.out.println(i + ". " + jobOpeningApplication.toString());
//            i++;
//        }
//
//        int jobIndex = Console.readInteger("Choose a Job Opening Application: ");
//
//        System.out.println("Job Opening Application choosen: " + jobOpeningApplicationsList.iterator().next().toString());
//
//        Candidate candidate = recordController.getCandidate(recordController.getCandidate(jobIndex));
//
//        System.out.println("Candidate associado: " + candidate.toString());
//        Candidate candidate = recordController.getCandidate(jobOpeningApplication);

//        System.out.println("Candidate associado: " + candidate.toString());

        Iterable<JobOpeningApplication> jobOpeningApplicationsIterable = recordController.getJobOpeningApplication();
        List<JobOpeningApplication> jobOpeningApplicationsList = new ArrayList<>();
        for (JobOpeningApplication application : jobOpeningApplicationsIterable) {
            jobOpeningApplicationsList.add(application);
        }

// Exiba as aplicações
        System.out.println("Job Opening Applications:");
        int i = 1;
        for (JobOpeningApplication jobOpeningApplication : jobOpeningApplicationsList) {
            System.out.println(i + ". " + jobOpeningApplication.toString());
            i++;
        }

// Leia o índice selecionado pelo usuário
        int jobIndex = Console.readInteger("Choose a Job Opening Application: ") - 1;

// Verifique se o índice é válido
        if (jobIndex >= 0 && jobIndex < jobOpeningApplicationsList.size()) {
            JobOpeningApplication selectedApplication = jobOpeningApplicationsList.get(jobIndex);
            System.out.println("Job Opening Application chosen: " + selectedApplication.toString());

            System.out.println("qlwfbAªfbAd");

            // Obtenha o candidato correspondente
            Candidate candidate = selectedApplication.candidate();
            System.out.println("Candidate: " + candidate.toString());
        } else {
            System.out.println("Invalid selection. Please try again.");
        }



        return true;
    }

    @Override
    public String headline() {
        return "Record Interview";
    }

}
