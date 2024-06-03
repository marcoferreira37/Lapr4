package authz.ui;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.domain.jobOpening.*;
import eapli.base.domain.jobOpeningProcess.Phase;
import eapli.base.usermanagement.application.controllers.AdvancePhaseController;
import eapli.base.usermanagement.application.controllers.UpdateJobOpeningController;
import eapli.framework.io.util.Console;

import java.io.File;
import java.util.Date;
import java.util.List;

public class UpdateJobOpeningUI extends AbstractUI {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";


    private final UpdateJobOpeningController controller = new UpdateJobOpeningController();
    private final AdvancePhaseController advancePhaseController = new AdvancePhaseController();
    @Override
    protected boolean doShow() {
        List<JobOpening> jobs  = controller.allJobs();
        int jobIndex = Console.readInteger("Choose a job: ");
        JobOpening jobOpening = jobs.get(jobIndex-1);



        System.out.println("What do you wish to update?");
        System.out.println("1. Phase Dates");
        System.out.println("2. Requirements");
        System.out.println("3. Interview Model");
        System.out.println("4. Current job phase");
        System.out.println("5. Edit a job opening details");
        System.out.println("6. Exit");
        String option = Console.readLine("Choose an option: ");

        switch (option) {
            case "1":
                System.out.println("Input all dates in this format: yyyy/MM/dd\n");
                Date application = Console.readDate("Application's end date: ");
                application = controller.verifyDate(application, "Aplication");
                Date screening = Console.readDate("Screening's end date: ");
                screening = controller.verifyDate(screening, "Screening");
                Date interview = Console.readDate("Interview's end date: ");
                interview = controller.verifyDate(interview, "Interview");
                Date analysis = Console.readDate("Analysis's end date: ");
                analysis = controller.verifyDate(analysis, "Analysis");
                Date results = Console.readDate("Results date: ");

                Phase phase = controller.buildPhase(application, screening, interview, analysis, results);

                controller.updateDates(jobOpening, phase);
                break;
            case "2":
                File[] requirements = controller.showRequirements();
                int requirementIndex = Console.readInteger("Choose a requirement: ");
                controller.updateRequirements(jobOpening,requirements[requirementIndex-1].getName());
                break;
            case "3":
                File[] interviews = controller.showInterviews();
                int interviewsIndex = Console.readInteger("Choose an interview: ");
                controller.updateInterview(jobOpening,interviews[interviewsIndex-1].getName());
                break;
            case "4":


                System.out.println("1. Advance to next phase");
                System.out.println("2. Go back to previous phase");
                int change = Console.readInteger("What do you wish to do?\n");
                while(change != 1 && change != 2){
                    System.out.println("Invalid option");
                    System.out.println("1. Advance to next phase");
                    System.out.println("2. Go back to previous phase");
                    change = Console.readInteger("What do you wish to do?\n");
                }
                boolean interviewPhase = false;
                if(controller.checkForInterviewPhase(change,jobOpening)){
                    String confirm = Console.readLine("Do you wish to jump interview phase [y/n]?");
                    if(confirm.toLowerCase().matches("y(es)?")){
                        interviewPhase = false;
                    }
                    if(confirm.toLowerCase().matches("no?")){
                        interviewPhase = true;
                    }
                }


                controller.updatePhase(jobOpening,change,interviewPhase);

                break;
            case "5":
                EditJobOpeningUI ui = new EditJobOpeningUI();
                ui.doShow();
                break;
        }
        if (jobOpening == null) return false;
        System.out.println("\n\nJob Opening updated successfully");
        return true;


    }

    @Override
    public String headline() {
        return "Update Job Opening";
    }
}
