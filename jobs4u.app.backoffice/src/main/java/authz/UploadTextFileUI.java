package authz;

import eapli.base.app.common.console.ui.components.ColorCode;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.domain.candidate.Candidate;
import eapli.base.usermanagement.application.controllers.UploadTextFileController;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

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

        theController.uploadFile(c.curriculum());

        theController.verifyRequirementsGrammar(c.curriculum());
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
            System.out.println(ColorCode.BLUE.getValue() + index + ColorCode.RESET.getValue() + " - " + "Candidate Id: " + item.identity() );
            index++;
        }
        System.out.println();
    }

}


