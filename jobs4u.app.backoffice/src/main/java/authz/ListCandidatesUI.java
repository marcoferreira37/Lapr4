package authz;


import eapli.base.app.common.console.ui.components.Sleeper;
import eapli.base.domain.candidate.Candidate;
import eapli.base.usermanagement.application.ListCandidatesController;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.visitor.Visitor;

import java.util.List;

public class ListCandidatesUI extends AbstractUI {
    private ListCandidatesController theController = new ListCandidatesController();

    @Override
    protected boolean doShow() {
        Iterable<Candidate> candidates = theController.allCandidates();
        int ct=0;
        for (Candidate candidate: candidates) {
            ct++;
            System.out.print(ct + ": ");
            System.out.println(candidate.identity());
        }
        System.out.println("\n");
        return true;
    }

    @Override
    public String headline() {
        return "List Candidates";
    }

    public boolean listDisabledCandidates() {
        List<Candidate> candidates = (List<Candidate>) theController.disabledCandidates();
        if (candidates.isEmpty()) {
            System.out.println("There are no disabled candidates in the system.");
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

    public boolean listEnabledCandidates() {
        List<Candidate> candidates = (List<Candidate>) theController.enabledCandidates();
        if (candidates.isEmpty()) {
            System.out.println("There are no enabled users in the system.");
            Sleeper.sleep(1000);
            return false;
        }
        printCandidates(candidates);
        return true;
    }
}

