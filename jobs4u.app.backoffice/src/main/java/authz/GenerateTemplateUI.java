package authz;

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
                System.out.print(count);
                printer.visit(jobOpening);
                System.out.println();
                count++;
            }
            final int option = Console.readInteger("Select a job opening ");
            if (option == 0) {
                System.out.println("No Job Opening selected");
            } else {
                String interview = listJobOpenings.get(option - 1).getInterviewModel();
                Path sourcePath = Paths.get("src/main/resources/PlugIns/RequirementsSpecification" + interview);
                Path destinationPath = Paths.get("src/main/java/authz/GenerateTemplateUI.java"+ interview);

                try{
                    Files.copy(sourcePath,destinationPath, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Template exported successfully");
                }catch (IOException e) {
                    System.out.println(e);
                    System.out.println("Error exporting template");
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
        return String.format("# %-15s%-15s%-15s%-10s%-10s%-10s%-10s", "COSTUMERID", "JOBREFERENCE", "CONTRACTTYPE", "TITLE","DESCIPTION", "MODE", "ADDRESS");
    }
}
