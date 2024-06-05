package authz.ui;

import eapli.base.usermanagement.application.controllers.EvaluateInterviewController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class EvaluateInterviewUI extends AbstractUI {
private final EvaluateInterviewController controller = new EvaluateInterviewController();

    @Override
    protected boolean doShow() {

        String file = Console.readLine("Insert the file path: ");

        try {
            controller.evaluateInterview(file);
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
