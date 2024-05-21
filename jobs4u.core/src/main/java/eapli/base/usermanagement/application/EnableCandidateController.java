package eapli.base.usermanagement.application;

import eapli.base.domain.Jobs4UUser;
import eapli.base.clientusermanagement.repositories.Ijobs4UUserRepository;
import eapli.base.domain.candidate.Candidate;
import eapli.base.repositories.CandidateRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import org.springframework.transaction.annotation.Transactional;

public class EnableCandidateController {

    private final CandidateRepository candidateRepository;

    /**
     * Instantiates a controller for enabling a user.
     * Receives the user repository as parameter. (DI)
     *
     * @param candidateRepository the user repository
     */
    public EnableCandidateController(CandidateRepository candidateRepository) {
        if (candidateRepository== null) {
            throw new IllegalArgumentException("User repository must be provided.");
        }
        this.candidateRepository = candidateRepository;
    }

    /**
     * Enable user
     *
     * @param email the email of the user to enable
     * @throws IllegalArgumentException if the user is not found
     */

//    @Transactional
//    public void enableCandidate(String email) {
//        for (Candidate candidate : candidateRepository.findAll()){
//            if (candidate.emailAddress().toString().equals(email)) {
//                candidate.user().activate(); //atenção aqui, pode não dar enable ao candidato mas sim ao system user, ver depois
//                candidateRepository.save(candidate);
//                return;
//            }
//        }
//        throw new IllegalArgumentException("Candidate not found.");
//    }
}
