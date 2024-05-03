package authz;


import eapli.base.domain.candidate.Candidate;
import eapli.base.usermanagement.application.ListCandidatesController;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.visitor.Visitor;

public class ListCandidatesUI extends AbstractUI {
    private ListCandidatesController theController = new ListCandidatesController();

    @Override
    protected boolean doShow() {
        Iterable<Candidate> candidates = theController.allCandidates();

        for (Candidate candidate: candidates) {
            System.out.println(candidate.toString());
        }
        System.out.println("\n");
        return true;
    }

    @Override
    public String headline() {
        return "List Candidates";
    }

}

