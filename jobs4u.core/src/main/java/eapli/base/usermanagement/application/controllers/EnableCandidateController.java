package eapli.base.usermanagement.application.controllers;

import eapli.base.candidate.CandidateManagementService;
import eapli.base.domain.Jobs4UUser;
import eapli.base.clientusermanagement.repositories.Ijobs4UUserRepository;
import eapli.base.domain.candidate.Candidate;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.CandidateRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class EnableCandidateController {

    private final CandidateRepository candidateRepository;

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CandidateManagementService candidateSvc = new CandidateManagementService();

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


    public void enableCandidate(String email) {
       candidateSvc.enableCandidate(email);
   }

    public Iterable<Candidate> disabledCandidates() {
        List<Candidate> disabledCandidates = new ArrayList<>();
        for (Candidate user : candidateSvc.allCandidate()) {
            if (!user.user().isActive()) {
                disabledCandidates.add(user);
            }
        }
        return disabledCandidates;
    }
}
