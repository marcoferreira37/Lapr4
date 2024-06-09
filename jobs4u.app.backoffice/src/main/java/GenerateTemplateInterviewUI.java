import authz.SystemJobOpeningPrinter;
import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.clientusermanagement.application.GenerateTemplateController;
import eapli.base.domain.jobOpeningInterview.JobInterview;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GenerateTemplateInterviewUI extends AbstractUI {

    GenerateTemplateController controller = new GenerateTemplateController();


    protected boolean doShow() {
        Iterable<JobInterview> interview = controller.findJobInterviews();
        List<JobInterview> listJobInterview = new ArrayList<>();

        if (!interview.iterator().hasNext()) {
            System.out.println("No job interviews available");
        } else {
            System.out.println("Job interviews available");
//            System.out.println(listHeader());
            int count = 1;
            SystemJobOpeningPrinter printer = new SystemJobOpeningPrinter();
            for (JobInterview interviews : interview) {
                listJobInterview.add(interviews);
                System.out.print(count + " ");
                printer.visitInterview(interviews);
                System.out.println();
                count++;
            }


                final int option = Console.readInteger("Select a job interview (Enter 0 to exit): ");
                if (option == 0) {
                    System.out.println("No Job Interview selected");
                } else if (option > 0 && option <= listJobInterview.size()) {
                    JobInterview jobInterview = listJobInterview.get(option - 1);
//                    String requirements = jobInterview.getInterviewAnswers();
//
//                    if (requirements == null || requirements.trim().isEmpty()) {
//                        System.out.println("Requirements for the selected job interview are not available. Please select another job interview.");
//                    } else {
                    Path sourcePath = Paths.get("jobs4u.core/src/main/resources/PlugIns/templateInterview" + interview.iterator().next());
                    controller.templateInterview(sourcePath, jobInterview);

                } else {
                    System.out.println("Invalid option. Please try again.");
                }

        }

        return false;
    }

    @Override
    public String headline() {
        return "Export Interview Template File";
    }

    private String listHeader() {
        return String.format("#%-15s %-15s %-15s %-10s %-10s %-10s %-10s", "CUSTOMER_ID", "JOB_REFERENCE", "CONTRACT_TYPE", "TITLE", "DESCRIPTION ", "MODE", "ADDRESS");
    }
}
