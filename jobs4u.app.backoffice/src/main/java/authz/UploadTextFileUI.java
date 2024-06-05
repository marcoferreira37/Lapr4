package authz;

import eapli.base.app.common.console.ui.components.ColorCode;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.usermanagement.application.controllers.UploadTextFileController;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;
import java.util.jar.JarEntry;

public class UploadTextFileUI extends AbstractUI {

    private final UploadTextFileController theController = new UploadTextFileController();

    @Override
    protected boolean doShow() {
        List<Candidate> candidates = (List<Candidate>) theController.allCandidates();

        if (candidates.isEmpty()) {
            System.out.println("There are no candidates in the system.");
            return false;
        }
        printNumeratedList("Candidate List:", candidates);
        int option = Console.readInteger("Select a candidate: ");

        Candidate c = candidates.get(option - 1);

        List<JobOpeningApplication> applications = theController.getApplicationsByCandidate(c);

        if (applications.isEmpty()) {
            System.out.println("This candidate has no applications.");
            return false;
        }

        printNumeratedListApp("Job Opening Application List:", applications);
        int optionApp = Console.readInteger("Select a job opening application: ");

        JobOpeningApplication app = applications.get(optionApp - 1);

        String path = Console.readLine("Enter the path of the file: ");

        theController.uploadFile(app, path);

        return false;
    }

    @Override
    public String headline() {
        return "Upload a text file";
    }

    public void printNumeratedList(String message, List<Candidate> collection) {
        System.out.printf("%s\n\n", message);

        int index = 1;
        for (Candidate item : collection) {
            System.out.println(ColorCode.BLUE.getValue() + index + ColorCode.RESET.getValue() + " - " + "Candidate Id: " + item.identity());
            index++;
        }
        System.out.println();
    }

    public void printNumeratedListApp(String message, List<JobOpeningApplication> collection) {
        System.out.printf("%s\n\n", message);

        int index = 1;
        for (JobOpeningApplication item : collection) {
            System.out.println(ColorCode.BLUE.getValue() + index + ColorCode.RESET.getValue() + " - " + "JobOpeningApplication Id: " + item.identity());
            index++;
        }
        System.out.println();
    }
}


