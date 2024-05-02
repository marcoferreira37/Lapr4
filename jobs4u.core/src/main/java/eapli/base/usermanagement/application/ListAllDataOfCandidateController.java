package eapli.base.usermanagement.application;

import eapli.base.clientusermanagement.repositories.Ijobs4UUserRepository;
import eapli.base.domain.candidate.Candidate;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.CandidateRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

import java.lang.ref.PhantomReference;
import java.util.List;

public class ListAllDataOfCandidateController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public ListAllDataOfCandidateController() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWER_USER, BaseRoles.ADMIN);
    }

    public Iterable<Candidate> allCandidates() {
        final CandidateRepository candidateRepository = PersistenceContext.repositories().candidateRepository();
        return candidateRepository.findAllCandidates();
    }

}

