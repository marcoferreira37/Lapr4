package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.company.Company;
import eapli.base.domain.jobOpeningProcess.JobOpeningProcess;
import eapli.base.domain.jobOpeningProcess.PhaseType;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpeningProcess.Phase;
import eapli.base.usermanagement.application.services.JobOpeningService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;

import java.io.File;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class UpdateJobOpeningController {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";


    private JobOpeningService service = new JobOpeningService();
    private AuthorizationService autzService = AuthzRegistry.authorizationService();
    private JobOpening jobOpening;
    private JobOpeningProcess jobProcess;

    public void updateDates(JobOpening jobOpening, Phase phase) {
        autzService.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.ADMIN, BaseRoles.POWER_USER);
        JobOpeningProcess jobOpeningProcess = service.jobProcessFromJobOpening(jobOpening);
        jobOpeningProcess.updatePhaseDate(phase);
        jobOpeningProcess = service.saveJobProcess(jobOpeningProcess);

        System.out.println("Dates updated successfully!");
        System.out.println("New Dates: " + jobOpeningProcess.phaseDate());
    }

    public Date verifyDate (Date date, String dateName){
        boolean verify = false;
        do {
            if (date.before(Date.from(Instant.now()))){
                System.out.println(ANSI_RED + "Invalid Date!" + ANSI_RESET);
                date = requestDate(dateName);
            }else {
                verify = true;
            }
        }while (!verify);
        return date;
    }

    private Date requestDate(String dateName) {
        return Console.readDate( dateName + "'s end date: ");
    }

    public List<JobOpening> allJobs() {
        autzService.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.ADMIN);
        jobProcess = service.jobProcessFromJobOpening(jobOpening);
        int index = 1;
        for(JobOpening job : service.allJobs()){
          System.out.println(index + ". " + job.getJobReference().fullReference() + "\nCurrent Phase: " + jobProcess.currentPhase() + "\nStatus: " + jobProcess.status() +"\nPhase Dates: " + jobProcess.phaseDate() + "\n");
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

    /*
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
*/
        public boolean checkForInterviewPhase(int choice, JobOpening jobOpening) {
            JobOpeningProcess jobProcess = service.jobProcessFromJobOpening(jobOpening);
            if (choice == 1 && jobProcess.currentPhase() == PhaseType.SCREENING)
                return true;
            return choice == 2 && jobProcess.currentPhase() == PhaseType.ANALYSIS;
        }

        public JobOpeningProcess updatePhase(JobOpening jobOp, int choice, boolean interviewPhase){
            if(choice == 1){
                jobProcess = service.advanceToNextPhase(jobProcess,interviewPhase);
            }
            else{
                jobProcess = service.goBackToPreviousPhase(jobProcess,interviewPhase);
            }
            return jobProcess;
        }

    public Phase buildPhase(Date application, Date screening, Date interview, Date analysis, Date results) {
        return Phase.from(application, screening,interview,analysis,results);
    }

    public JobOpening editJobOpening(JobOpening jobOpening) {
        jobOpening = service.saveJobOpening(jobOpening);
        return jobOpening;
    }

    public JobOpening updateCompany(JobOpening jobOpening) {
        List<Company> companies = service.companyList();
        int index = 1;
        for(Company company : companies){
            System.out.println(index + ". " + company.toString());
            index++;
        }
        int companyIndex = Console.readInteger("Choose a company: ");
        jobOpening.setCompany(companies.get(companyIndex-1));
        return jobOpening;
    }



}
