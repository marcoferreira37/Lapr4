package eapli.base.customer;

import eapli.base.domain.JobOpeningProcess.PhaseType;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.Phase;
import eapli.base.usermanagement.application.JobOpeningService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UpdateJobOpeningController {

    private JobOpeningService service = new JobOpeningService();
    private AuthorizationService autzService = AuthzRegistry.authorizationService();

    public JobOpening updateDates(JobOpening jobOpening, Phase phase) {
        autzService.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.ADMIN, BaseRoles.POWER_USER);
        jobOpening.setPhaseDates(phase);
        JobOpening jo = service.saveJobOpening(jobOpening);
        return jo;
    }

    public List<JobOpening> allJobs() {
        autzService.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.ADMIN);
        int index = 1;
        for(JobOpening job : service.allJobs()){
            System.out.println(index + ". " + job.toString());
            index++;
        }

        return service.allJobs();
    }

    public File[] showInterviews(){
        System.out.println("Interview Models:");
        File dir = new File("jobs4u.core/src/main/resources/PlugIns/interviewModel");
        File[] files = dir.listFiles();
        int index = 1;
        if(files != null){
            for(File file : files){
                if(file.getName().endsWith(".txt")){
                    System.out.println(index + ". " + file.getName());
                    index++;
                }
            }
        }
        else{
            System.out.println("No files found");
        }
        return files;
    }

    public JobOpening updateInterview(JobOpening jobOpening, String interview){
        jobOpening.setInterviewModel(interview);
        jobOpening = service.saveJobOpening(jobOpening);
        return jobOpening;
    }

    public File[] showRequirements(){
        System.out.println("Requirements:");
        File dir = new File("jobs4u.core/src/main/resources/PlugIns/RequirementsSpecifications/backEndDeveloperRequirements");
        File[] files = dir.listFiles();
        int index = 1;
        if(files != null){
            for(File file : files){
                if(file.getName().endsWith(".txt")){
                    System.out.println(index + ". " + file.getName());
                    index++;
                }
            }
        }
        else{
            System.out.println("No files found");
        }
        return files;
    }

    public JobOpening updateRequirements(JobOpening jobOpening, String requirements){
        jobOpening.setRequirements(requirements);
        jobOpening = service.saveJobOpening(jobOpening);
        return jobOpening;
    }


    public void showJobPhases(JobOpening jobOpening) {
        System.out.println("Job Phase Process:");

        for (PhaseType phase : PhaseType.values()) {
            if (phase == jobOpening.getCurrentJobPhase()) {
                System.out.println(phase + ": Open");
            } else {
                System.out.println(phase + ": Closed");
            }
        }
    }

    public boolean checkForInterviewPhase(int choice, JobOpening jobOpening) {
        if (choice == 1 && jobOpening.getCurrentJobPhase() == PhaseType.SCREENING)
            return true;
        return choice == 2 && jobOpening.getCurrentJobPhase() == PhaseType.ANALYSIS;
    }

    public JobOpening updatePhase(JobOpening jobOpening, int choice, boolean interviewPhase){
        if(choice == 1){
            jobOpening = service.advanceToNextPhase(jobOpening,interviewPhase);
        }
        else{
            jobOpening = service.goBackToPreviousPhase(jobOpening,interviewPhase);
        }
        return jobOpening;
    }





}
