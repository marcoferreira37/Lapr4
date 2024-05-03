
package users.list;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.ColorCode;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.app.common.console.ui.components.ListSelector;
import eapli.base.domain.candidate.Candidate;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.ListAllDataOfCandidateController;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;


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
        

        System.out.println();
        System.out.println("Candidate Id: " + candidates.get(option - 1).identity());
        //FIXME Urgent!
//        System.out.println("Full Name: " + candidates.get(option - 1).name());
//        System.out.println("Email: " + candidates.get(option - 1).getUser().email());
//        System.out.println("Username:" + candidates.get(option - 1).getUser().identity() );

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
