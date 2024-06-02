package authz.ui;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.framework.io.util.Console;
import eapli.base.domain.Editable;
import eapli.base.usermanagement.application.controllers.EditJobOpeningController;

import java.util.ArrayList;
import java.util.List;

public class EditJobOpeningUI extends AbstractUI {
        private final EditJobOpeningController controller = new EditJobOpeningController();

    @Override
    protected boolean doShow() {
        String inputJobReference = grabJobReference();
        controller.transformJobReferenceToJobOpening(inputJobReference);
        controller.addEdits();
        controller.cycleEdits();

        System.out.println("Updated Job Opening: \n" + controller.viewJobOpening());
        return false;
    }
    @Override
    public String headline() {
        return "Edit Job Opening";
    }

    private String grabJobReference() {
        String inputJobReference;
        do {
            inputJobReference = Console.readLine("Job Reference: ");
        } while (!controller.validateJobReference(inputJobReference));
        return inputJobReference;
    }

}
