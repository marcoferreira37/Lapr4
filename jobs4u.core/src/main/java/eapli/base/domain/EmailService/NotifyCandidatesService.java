package eapli.base.domain.EmailService;

import eapli.base.domain.candidate.Candidate;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.CandidateRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class NotifyCandidatesService {

    CandidateRepository candidateRepository = PersistenceContext.repositories().candidate();


    public void sendEmail(String destination, String subject, String message) {
        EmailService.sendEmail(destination, subject, message);
    }

//    public Iterable<Candidate> findCandidates() {
//        Iterable<Candidate> candidates = candidateRepository.findAllCandidates();
//        List<Candidate> isepCandidates;
//        isepCandidates = null;
//
//        // Convert Iterable to Stream and filter emails
//
//        for (Candidate candidate : candidates) {
//            String email = String.valueOf(candidate.getEmail());
//            String[] emailParts = email.split("@");
//            if (emailParts.length == 2 && "isep.ipp.pt".equals(emailParts[1])) {
//                isepCandidates.add(candidate);
//            }
//        }
//    }
}
