package authz.ui;

import eapli.base.usermanagement.application.controllers.AddCandidateController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Calendar;

public class AddCandidateUI extends AbstractUI {
    private final AddCandidateController theController = new AddCandidateController();

    @Override
    protected boolean doShow() {
        final String firstName = Console.readLine("First Name");
        final String lastName = Console.readLine("Last Name");
        final String email = Console.readLine("E-Mail");
        final long telephoneNumber = Console.readLong("Telephone Number");


        try {
            this.theController.addCandidate(firstName, lastName, email, Calendar.getInstance(), telephoneNumber);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("That email is already in use.");
        }

        return false;
    }


    @Override
    public String headline() {
        return "Add Candidate";
    }
}
