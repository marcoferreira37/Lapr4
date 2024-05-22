package authz.enable_disable_users;

import authz.ListCandidatesUI;
import authz.listusers.ListUsersUI;
import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.app.common.console.ui.components.Sleeper;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.DisableCandidateController;
import eapli.base.usermanagement.application.DisableUserController;

public class DisableCandidateUI extends AbstractUI {

    private final DisableCandidateController controller = new DisableCandidateController(PersistenceContext.repositories().candidate());

    @Override
    protected boolean doShow() {
        var ui = new ListCandidatesUI();
        var wereUsersPrinted = ui.listEnabledCandidates();
        if (!wereUsersPrinted) {
            return false;
        }
        String email = Console.readNonEmptyLine("Provide the email of the candidate to disable: ", "Email cannot be empty.");

        try {
            controller.disableCandidate(email);
            successMessage("Candidate with email: " + email + " disabled successfully.");
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
        return "Disable Candidate";    }
}
