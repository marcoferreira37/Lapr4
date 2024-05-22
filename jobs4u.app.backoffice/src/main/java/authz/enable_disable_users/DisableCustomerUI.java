package authz.enable_disable_users;


import authz.ListCustomersUI;
import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.app.common.console.ui.components.Sleeper;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.controllers.DisableCustomerController;

public class DisableCustomerUI extends AbstractUI {

    private final DisableCustomerController controller = new DisableCustomerController(PersistenceContext.repositories().customer());

    @Override
    protected boolean doShow() {
        var ui = new ListCustomersUI();
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
