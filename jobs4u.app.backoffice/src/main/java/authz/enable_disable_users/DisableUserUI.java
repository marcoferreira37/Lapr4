package authz.enable_disable_users;


import authz.listusers.ListUsersUI;
import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.app.common.console.ui.components.Sleeper;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.DisableUserController;

public class DisableUserUI extends AbstractUI {

    private final DisableUserController controller = new DisableUserController(PersistenceContext.repositories().users());

    @Override
    protected boolean doShow() {
        var ui = new ListUsersUI();
        var wereUsersPrinted = ui.listEnabledUsers();
        if (!wereUsersPrinted) {
            return false;
        }
        var email = Console.readNonEmptyLine("Provide the email of the user to disable: ", "Email cannot be empty.");

        try {
            controller.disableUser(email);
            successMessage("User with email: " + email + " disabled successfully.");
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
        return "Disable User";
    }
}
