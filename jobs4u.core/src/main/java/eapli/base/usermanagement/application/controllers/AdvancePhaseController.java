package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpeningProcess.JobOpeningProcess;
import eapli.base.domain.jobOpeningProcess.PhaseType;
import eapli.base.domain.jobOpeningProcess.Status;
import eapli.base.usermanagement.application.services.JobOpeningService;

public class AdvancePhaseController {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    private JobOpening jobOpening;
    private JobOpeningProcess jobProcess;
    private JobOpeningService service = new JobOpeningService();


    public boolean checkForInterviewPhase(int choice, JobOpening job) {
        jobOpening = job;
        JobOpeningProcess jobProcess = service.jobProcessFromJobOpening(jobOpening);

        if (choice == 1 && jobProcess.currentPhase() == PhaseType.SCREENING)
            return true;
        return choice == 2 && jobProcess.currentPhase() == PhaseType.ANALYSIS;
    }

    public JobOpeningProcess updatePhase(JobOpening job, int choice, boolean interviewPhase){
        jobOpening = job;
        jobProcess = service.jobProcessFromJobOpening(job);
        if (jobProcess.checkIfDatesWerentSetup()) {
            return null;
        }
        System.out.println("Old phase: " + jobProcess.currentPhase() + " Status: " + jobProcess.status());
        if(choice == 1){
            jobProcess = service.advanceToNextPhase(jobProcess,interviewPhase);
        }
        else if (choice == 2){
            jobProcess = service.goBackToPreviousPhase(jobProcess,interviewPhase);
        } else {
            jobProcess.activateProcess();
        }
        if (jobProcess != null) {
            jobProcess = service.saveJobProcess(jobProcess);
            System.out.println("New phase: " + jobProcess.currentPhase() + " Status: " + jobProcess.status() );
        }
        return jobProcess;
    }

}
