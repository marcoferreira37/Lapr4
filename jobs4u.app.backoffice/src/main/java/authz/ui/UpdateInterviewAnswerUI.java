package authz.ui;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.ColorCode;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.candidate.CandidateManagementService;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.usermanagement.application.controllers.EditJobOpeningController;
import eapli.base.usermanagement.application.controllers.ListAllDataOfCandidateController;
import eapli.base.usermanagement.application.controllers.ListCandidatesController;
import eapli.base.usermanagement.application.controllers.UpdateInterviewAnswerController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class UpdateInterviewAnswerUI extends AbstractUI {

    private final UpdateInterviewAnswerController controller = new UpdateInterviewAnswerController();

    private final CandidateManagementService service = new CandidateManagementService();

    @Override
    protected boolean doShow() {

        List<Candidate> candidates = (List<Candidate>) service.allCandidate();

        if (candidates.isEmpty()) {
            System.out.println("There are no candidates in the system.");
            return false;
        }
        printCandidateNumeratedList("Candidate List:", candidates);
        int option = Console.readInteger("Select a candidate: ");

        List<JobOpeningApplication> applications =  controller.allApplicationsByIdWithInterview(candidates.get(option - 1));
        if (applications.isEmpty()) {
            System.out.println("There are no applications for this candidate.");
            return false;
        }
        printApplicationNumeratedList("Applications List:", applications);
        int option2 = Console.readInteger("Select a application to be updated: ");
        JobOpeningApplication app = applications.get(option2 - 1);

        try{
            String file = Console.readLine("Please insert the path to the desired file: ");

            Path source = Paths.get(file);
            if (!Files.exists(source)) {
                System.out.println("The file path you entered does not exist. Please try again.");
                return false;
            }
            Path dest = Paths.get("jobs4u.core/src/main/resources/PlugIns/interviewModel/UploadedFiles");
            String applicationId = String.valueOf(app.identity());
            Path destPath = dest.resolve("answers" + applicationId + ".txt");
            String fileName = "answers" + applicationId + ".txt";
            controller.uploadFiles(app, fileName,source.toString());
            Files.copy(source,destPath, StandardCopyOption.REPLACE_EXISTING);



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return false;
    }

    public void printCandidateNumeratedList(String message, List<Candidate> collection) {
        System.out.printf("%s\n\n", message);

        int index = 1;
        for (Candidate item : collection) {
            System.out.println(ColorCode.BLUE.getValue() + index + ColorCode.RESET.getValue() + " - " + "Candidate Id: " + item.identity() );
            index++;
        }
        System.out.println();
    }

    public void printApplicationNumeratedList(String message, List<JobOpeningApplication> collection) {
        System.out.printf("%s\n\n", message);

        int index = 1;
        for (JobOpeningApplication item : collection) {
            System.out.println(ColorCode.BLUE.getValue() + index + ColorCode.RESET.getValue() + " - " + "Application:" + item.toString());
            index++;
        }
        System.out.println();
    }

    @Override
    public String headline() {
        return "Update interview text file";
    }
}
