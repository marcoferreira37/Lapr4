package authz.enable_disable_users;

import authz.ui.ListCandidatesUI;
import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.app.common.console.ui.components.Sleeper;
import eapli.base.domain.candidate.Candidate;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.controllers.DisableCandidateController;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DisableCandidateUI extends AbstractUI {

    private final DisableCandidateController controller = new DisableCandidateController(PersistenceContext.repositories().candidate());

    @Override
    protected boolean doShow() {
        var wereUsersPrinted = listEnabledCandidates();
        if (!wereUsersPrinted) {
            return false;
        }
        String email;
        boolean validEmail;
        do {
            email = Console.readNonEmptyLine("Provide the email of the candidate to disable: ", "Email cannot be empty.");
            validEmail = isValidEmail(email);
            if (!validEmail) {
                errorMessage("Invalid email format.");
                Sleeper.sleep(1000);
            }
        } while (!validEmail);
       
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

    public boolean listEnabledCandidates() {
        List<Candidate> candidates = (List<Candidate>) controller.enabledCandidates();
        if (candidates.isEmpty()) {
            System.out.println("There are no enabled users in the system.");
            Sleeper.sleep(1000);
            return false;
        }
        printCandidates(candidates);
        return true;
    }

    private void printCandidates(List<Candidate> candidate) {
        int index = 1;
        for (Candidate c : candidate){
            System.out.println(index + " - " + c.emailAddress());
            index++;
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
