package authz.enable_disable_users;


import authz.listusers.ListUsersUI;
import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.app.common.console.ui.components.Sleeper;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.EnableUserController;

public class EnableUserUI extends AbstractUI {

    private final EnableUserController controller = new EnableUserController(PersistenceContext.repositories().users());

    @Override
    protected boolean doShow() {
        var ui = new ListUsersUI();
        var wereUsersPrinted = ui.listDisabledUsers();
        if (!wereUsersPrinted) {
            return false;
        }
        var email = Console.readNonEmptyLine("Provide the email of the user to enable: ", "Email cannot be empty.");

        try {
            controller.enableUser(email);
            successMessage("User with email: " + email + " enabled successfully.");
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
        return "Enable User";
    }
}
