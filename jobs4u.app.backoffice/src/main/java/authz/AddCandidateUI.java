package authz;

import eapli.base.usermanagement.application.AddCandidateController;
import eapli.base.usermanagement.application.AddUserController;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AddCandidateUI extends AbstractUI {
    private final AddCandidateController theController = new AddCandidateController();

    @Override
    protected boolean doShow() {

        final String username = Console.readLine("Username");
        final String firstName = Console.readLine("First Name");
        final String lastName = Console.readLine("Last Name");
        final String email = Console.readLine("E-Mail");


        try {
            this.theController.addCandidate(username, firstName, lastName, email, Calendar.getInstance());
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("That username is already in use.");
        }

        return false;
    }


    @Override
    public String headline() {
        return "Add Candidate";
    }
}


//    public static String generatePassword(int length) {
//        Random random = new Random();
//        StringBuilder password = new StringBuilder(length);
//
//        for (int i = 0; i < length; i++) {
//            int type = random.nextInt(3); // 0 for uppercase letter, 1 for special character
//            switch (type) {
//                case 0:
//                    password.append((char) (random.nextInt(26) + 'A')); // Uppercase letters
//                    break;
//                case 1:
//                    password.append((char) (random.nextInt(15) + 33)); // Special characters
//                    break;
//            }
//        }
//
//        return password.toString();
//    }
//}
