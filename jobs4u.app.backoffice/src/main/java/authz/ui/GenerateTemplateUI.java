package authz.ui;

import authz.SystemJobOpeningPrinter;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.clientusermanagement.application.GenerateTemplateController;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class GenerateTemplateUI extends AbstractUI {

    GenerateTemplateController controller = new GenerateTemplateController();

    protected boolean doShow() {
        Iterable<JobOpening> openings = controller.getJobOpenings();
        List<JobOpening> listJobOpenings = new ArrayList<>();

        if(!openings.iterator().hasNext()){
            System.out.println("No job openings available");
        } else{
            System.out.println("Job Openings available");
            System.out.println(listHeader());
            int count = 1;
            SystemJobOpeningPrinter printer = new SystemJobOpeningPrinter();
            for(JobOpening jobOpening : openings){
                listJobOpenings.add(jobOpening);
                System.out.print(count + " ");

                printer.visit(jobOpening);
                System.out.println();
                count++;
            }
            final int option = Console.readInteger("Select a job opening ");
            if (option == 0) {
                System.out.println("No Job Opening selected");
            } else {
                JobOpening jobOpening = listJobOpenings.get(option - 1);
                String requirements = jobOpening.getRequirements();
                Path sourcePath = Paths.get("jobs4u.core/src/main/resources/PlugIns/RequirementsSpecifications/backEndDeveloperRequirements/" + requirements);

               controller.template(sourcePath, jobOpening );
            }
        }

        return false;
    }

    @Override
    public String headline() {
        return "Export Interview Template File";
    }

    private String listHeader() {
        return String.format("#%-15s %-15s %-15s %-10s %-10s %-10s %-10s", "CUSTOMER_ID", "JOB_REFERENCE", "CONTRACT_TYPE", "TITLE","DESCRIPTION ", "MODE", "ADDRESS");
    }
}
