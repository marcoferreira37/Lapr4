package authz.ui;

import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.usermanagement.application.controllers.EvaluateInterviewController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class EvaluateInterviewUI extends AbstractUI {
    private final EvaluateInterviewController controller = new EvaluateInterviewController();

    @Override
    protected boolean doShow() {
        List<JobInterview> interviews = (List<JobInterview>) controller.findJobInterview();

        // Print interviews with an associated index
        for (int i = 0; i < interviews.size(); i++) {
            System.out.println((i + 1) + ". " + interviews.get(i));
        }

        // Ask the user to choose an interview
        int index = Console.readInteger("Choose an interview to work on (enter the number): ") - 1;

        // Validate the index
        if (index < 0 || index >= interviews.size()) {
            System.out.println("Invalid choice. Please try again.");
            return false;
        }
        JobInterview chosenInterview = interviews.get(index);


        Path filePath = controller.findPath(chosenInterview);
        // Get the chosen interview




        // Check if the file exists
        if (!Files.exists(filePath)) {
            System.out.println("The file does not exist at the specified path: " + filePath);
            return false;
        }

        try {
            // Evaluate the interview and get the score
            int score = controller.evaluateInterview(filePath.toString());

            // Set the score to the chosen interview
            controller.setGrade(score, chosenInterview);
            controller.save(chosenInterview);

            // Print the score
            System.out.println(chosenInterview);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    @Override
    public String headline() {
        return "Record Interview";
    }
}