package authz.enable_disable_users;


import authz.ListCandidatesUI;
import authz.listusers.ListUsersUI;
import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.app.common.console.ui.components.Sleeper;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.EnableCandidateController;
import eapli.base.usermanagement.application.EnableUserController;

public class EnableCandidateUI extends AbstractUI {

    private final EnableCandidateController controller = new EnableCandidateController(PersistenceContext.repositories().candidate());

    @Override
    protected boolean doShow() {
        var ui = new ListCandidatesUI();
        var wereUsersPrinted = ui.listDisabledCandidates();
        if (!wereUsersPrinted) {
            return false;
        }
        var email = Console.readNonEmptyLine("Provide the email of the candidate to enable: ", "Email cannot be empty.");

        try {
            controller.enableCandidate(email);
            successMessage("Candidate with email: " + email + " enabled successfully.");
            Sleeper.sleep(1000);
        } catch (IllegalArgumentException e) {
            errorMessage(e.getMessage());
            Sleeper.sleep(1000);
            return false;
        }
        return false;
    }

    @Override
    public String headline() {
        return "Enable Candidate";
    }
}
