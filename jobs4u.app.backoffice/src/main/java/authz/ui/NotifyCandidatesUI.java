package authz.ui;

import eapli.base.domain.candidate.Candidate;
import eapli.base.usermanagement.application.controllers.NotifyCandidatesController;
import eapli.framework.presentation.console.AbstractUI;

public class NotifyCandidatesUI extends AbstractUI{

    public NotifyCandidatesController controller = new NotifyCandidatesController();

    @Override
    protected boolean doShow() {

//        Iterable<Candidate> isepCandidates =controller.findCandidates();
//        isepCandidates.forEach(candidate -> System.out.println(candidate.getEmail()));
//
//
//
//
//
        String destination = "1220813@isep.ipp.pt";
        String subject = "Verification";
        String message = "A tua aplicacion está correta";

//destination = 1220813@isep.ipp.pt
        // subject = verification
        // message = "A tua aplicacion está correta"


            controller.sendEmail(destination, subject, message);




        return false;
    }

    @Override
    public String headline() {
        return "Notify Candidates";
    }


}
