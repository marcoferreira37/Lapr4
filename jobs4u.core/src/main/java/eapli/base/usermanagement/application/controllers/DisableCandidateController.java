package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.Jobs4UUser;
import eapli.base.clientusermanagement.repositories.Ijobs4UUserRepository;
import eapli.base.domain.candidate.Candidate;
import eapli.base.repositories.CandidateRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;


public class DisableCandidateController {

    private final CandidateRepository candidateRepository;

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

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
    @Transactional
    public Candidate disableCandidate(String email) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.OPERATOR, BaseRoles.ADMIN);
        for (Candidate user : candidateRepository.findAll()){
            if (user.emailAddress().toString().equals(email)) {
                user.user().deactivate(Calendar.getInstance());
                return candidateRepository.save(user);
            }
        }
        return null;
    }
}
