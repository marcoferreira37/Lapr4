package authz.ui;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.candidate.Candidate;
import eapli.base.usermanagement.application.controllers.RecordInterviewController;
import eapli.framework.io.util.Console;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RecordInterviewUI extends AbstractUI {

    public RecordInterviewController recordController = new RecordInterviewController();

    @Override
    protected boolean doShow() {

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
        JobOpeningApplication selectedApplication = jobOpeningApplicationsList.get(jobIndex);
        System.out.println("Job Opening Application chosen: " + selectedApplication.toString());



        // Obtenha o candidato correspondente

        Candidate candidate1 = selectedApplication.candidate();
        System.out.println("Candidate: " + candidate1.toString());

//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        Calendar interviewDate = Console.readCalendar("Interview Date (dd-MM-yyyy): ");
//        String newDate =sdf.format(interviewDate.getTime());
        String interviewTime = Console.readLine("Interview Time (HH:mm): ");


        recordController.recordInterview(interviewDate, interviewTime, selectedApplication);


        return true;
    }

    @Override
    public String headline() {
        return "Record Interview";
    }

}
