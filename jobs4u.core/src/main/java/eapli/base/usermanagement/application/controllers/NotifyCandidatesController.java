package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.EmailService.NotifyCandidatesService;
import eapli.base.domain.candidate.Candidate;

public class NotifyCandidatesController {

    NotifyCandidatesService service = new NotifyCandidatesService();



    public void sendEmail(String destination, String subject, String message) {
        service.sendEmail(destination, subject, message);
    }

//    public Iterable<Candidate> findCandidates() {
//        return service.findCandidates();
//    }
}
