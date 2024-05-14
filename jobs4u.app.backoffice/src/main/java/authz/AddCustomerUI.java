package authz;


import eapli.base.app.common.console.ui.components.Utils;
import eapli.base.usermanagement.application.AddCustomerController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.base.domain.Password;

import java.util.Calendar;

/**
 * The type Add customer ui.
 */
public class AddCustomerUI extends AbstractUI {

    private final AddCustomerController theController = new AddCustomerController();

    @Override
    protected boolean doShow() {
        // FIXME avoid duplication with SignUpUI. reuse UserDataWidget from
        // UtenteApp
        String username = Console.readLine("Username");
        while (!theController.checkUsername(username)) {
            username = Utils.readLineFromConsole("Please Provide a valid username, it cannot be empty\nUsername:");
        }

        String firstName = Console.readLine("First Name");
        while (!theController.checkName(firstName)) {
            firstName = Utils.readLineFromConsole("Please Provide a valid First Name, it cannot be empty, the first letter musb be in upper case and can't contain numbers and special caractheres \nFirst Name:");
        }

        String lastName = Console.readLine("Last Name");
        while (!theController.checkName(lastName)) {
            lastName = Utils.readLineFromConsole("Please Provide a valid Last Name, it cannot be empty, the first letter musb be in upper case and can't contain numbers and special caractheres \nLast Name:");
        }

        final String email = Console.readLine("E-Mail");
        new Password();
        final Password password = Password.generatePassword();

        try {
            this.theController.addCustomer(username, firstName, lastName, email, Calendar.getInstance(), password);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("That username is already in use.");
        }
        System.out.println("##########Customer created successfully!########## \nPassword: " + password);
        return false;
    }

    @Override
    public String headline() {
        return "Add Customer";
    }
}

