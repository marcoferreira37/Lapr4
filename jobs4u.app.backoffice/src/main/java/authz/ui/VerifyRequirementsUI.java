package authz.ui;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.usermanagement.application.controllers.VerifyRequirementsController;
import eapli.framework.io.util.Console;

import java.util.List;
import java.util.jar.JarOutputStream;

public class VerifyRequirementsUI extends AbstractUI {
    private final VerifyRequirementsController controller = new VerifyRequirementsController();
    @Override
    protected boolean doShow() {
       List<JobOpening>  jobs = controller.allJobs();
       int i = 1;
        for (JobOpening job : jobs) {
            System.out.println(i + ". " + job.getJobReference().fullReference());
        }
        int option = Console.readInteger("Choose a job opening: ");
        while (option < 0 || option > jobs.size()) {
            option = Console.readInteger("Invalid option. Please try again: ");
        }
        JobOpening job = jobs.get(option - 1);
         for(JobOpeningApplication application :    controller.verifyRequirements(job) ) {
                System.out.println(application.toString());
         }

        return false;
    }

    @Override
    public String headline() {
        return "Verify Requirements for a Job Opening";
    }
}
