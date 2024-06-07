package authz.ui;

import eapli.base.domain.candidate.Candidate;
import eapli.base.usermanagement.application.controllers.NotifyCandidatesController;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;
import java.util.Scanner;

public class NotifyCandidatesUI extends AbstractUI {

    String subject = "Verification";
    String message = "A tua aplicação está correta";

    public NotifyCandidatesController controller = new NotifyCandidatesController();

    @Override
    protected boolean doShow() {


        List<Candidate> isepCandidates = controller.findCandidates();

        if (isepCandidates.isEmpty()) {
            System.out.println("No candidates with email ending in @isep.ipp.pt found.");
            return false;
        }

        System.out.println("ISEP Candidates:");
        for (int i = 0; i < isepCandidates.size(); i++) {
            System.out.println(i + ": " + isepCandidates.get(i).getEmail());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a candidate by index: ");
        int index = scanner.nextInt();

        String destination = null;
        if (index >= 0 && index < isepCandidates.size()) {
            Candidate selectedCandidate = isepCandidates.get(index);
            System.out.println("You selected: " + selectedCandidate);
            destination = String.valueOf(selectedCandidate.getEmail());
            System.out.println("Sending email to " + destination);
            controller.sendEmail(destination, subject, message);
        } else {
            System.out.println("Invalid index selected.");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Notify Candidates";
    }
}
