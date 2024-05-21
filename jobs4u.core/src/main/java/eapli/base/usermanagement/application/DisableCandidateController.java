package eapli.base.usermanagement.application;

import eapli.base.domain.Jobs4UUser;
import eapli.base.clientusermanagement.repositories.Ijobs4UUserRepository;
import eapli.base.domain.candidate.Candidate;
import eapli.base.repositories.CandidateRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;


public class DisableCandidateController {

    private final CandidateRepository candidateRepository;

    /**
     * Instantiates a controller for disabling a user.
     * Receives the user repository as parameter. (DI)
     *
     * @param candidateRepository the candidate repository
     */
    public DisableCandidateController(CandidateRepository candidateRepository) {
        if (candidateRepository == null) {
            throw new IllegalArgumentException("Candidate repository must be provided.");
        }
        this.candidateRepository =candidateRepository;
    }

    /**
     * Disable candidate
     *
     * @param email the email of the candidate to disable
     * @throws IllegalArgumentException if the candidate is not found
     */
//    @Transactional
//    public boolean disableCandidate(String email) {
//        for (Candidate user : candidateRepository.findAll()){
//            if (user.emailAddress().toString().equals(email)) {
//                user.user().deactivate(Calendar.getInstance());
//                candidateRepository.save(user);
//                return true;
//            }
//        }
//        return false;
//    }
}
