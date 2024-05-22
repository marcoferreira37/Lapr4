
package users.list;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.ColorCode;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.domain.candidate.Candidate;
import eapli.base.usermanagement.application.controllers.ListAllDataOfCandidateController;


import java.util.List;

public class ListAllDataOfCandidateUI extends AbstractUI {
    private final ListAllDataOfCandidateController controller = new ListAllDataOfCandidateController();

    @Override
    public boolean doShow() {
        List<Candidate> candidates = (List<Candidate>) controller.allCandidates();

        if (candidates.isEmpty()) {
            System.out.println("There are no candidates in the system.");
            return false;
        }
        printNumeratedList("Candidate List:", candidates);
        int option = Console.readInteger("Select a candidate: ");

        System.out.println( candidates.get(option - 1).toString() );

        return false;
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

    @Override
    public String headline() {
        return "List All Data of Candidate";
    }
}

