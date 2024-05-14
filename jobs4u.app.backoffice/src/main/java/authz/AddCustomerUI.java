package authz;


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
        final String username = Console.readLine("Username");
        final String firstName = Console.readLine("First Name");
        final String lastName = Console.readLine("Last Name");
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

