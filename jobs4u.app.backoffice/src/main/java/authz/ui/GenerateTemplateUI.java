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

        if (!openings.iterator().hasNext()) {
            System.out.println("No job openings available");
        } else {
            System.out.println("Job Openings available");
            System.out.println(listHeader());
            int count = 1;
            SystemJobOpeningPrinter printer = new SystemJobOpeningPrinter();
            for (JobOpening jobOpening : openings) {
                listJobOpenings.add(jobOpening);
                System.out.print(count + " ");
                printer.visit(jobOpening);
                System.out.println();
                count++;
            }

            while (true) {
                final int option = Console.readInteger("Select a job opening (Enter 0 to exit): ");
                if (option == 0) {
                    System.out.println("No Job Opening selected");
                    break;
                } else if (option > 0 && option <= listJobOpenings.size()) {
                    JobOpening jobOpening = listJobOpenings.get(option - 1);
                    String requirements = jobOpening.getRequirements();

                    if (requirements == null || requirements.trim().isEmpty()) {
                        System.out.println("Requirements for the selected job opening are not available. Please select another job opening.");
                    } else {
                        Path sourcePath = Paths.get("jobs4u.core/src/main/resources/PlugIns/RequirementsSpecifications/backEndDeveloperRequirements/" + requirements);
                        controller.template(sourcePath, jobOpening);
                        break; // Exit the loop after successful processing
                    }
                } else {
                    System.out.println("Invalid option. Please try again.");
                }
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
