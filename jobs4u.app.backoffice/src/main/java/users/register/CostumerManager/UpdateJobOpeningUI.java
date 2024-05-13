package users.register.CostumerManager;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.customer.UpdateJobOpeningController;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.Phase;
import eapli.framework.io.util.Console;

import java.io.File;
import java.util.Date;
import java.util.List;

public class UpdateJobOpeningUI extends AbstractUI {

    private final UpdateJobOpeningController controller = new UpdateJobOpeningController();
    @Override
    protected boolean doShow() {
        List<JobOpening> jobs  = controller.allJobs();
        int jobIndex = Console.readInteger("Choose a job: ");
        JobOpening jobOpening = jobs.get(jobIndex-1);



        System.out.println("What do you wish to update?");
        System.out.println("1. Phase Dates");
        System.out.println("2. Requirements");
        System.out.println("3. Interview Model");
        String option = Console.readLine("Choose an option: ");

        switch (option) {
            case "1":
                Date application = Console.readDate("Application's end date: ");
                Date screening = Console.readDate("Screening's end date: ");
                Date interview = Console.readDate("Interview's end date: ");
                Date analysis = Console.readDate("Analysis's end date: ");
                Date results = Console.readDate("Results date: ");
                Phase phase = Phase.from(application,screening,interview,analysis,results);

                jobOpening = controller.updateDates(jobOpening,phase);
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
        }
        if (jobOpening == null) return false;
        System.out.println("Job Opening updated successfully");
        return true;


    }

    @Override
    public String headline() {
        return "update job opening";
    }
}
