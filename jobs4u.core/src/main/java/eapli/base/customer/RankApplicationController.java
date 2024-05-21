package eapli.base.customer;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobOpeningRepository;
import eapli.base.usermanagement.application.JobOpeningService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;

public class RankApplicationController {

    private JobOpeningService service = new JobOpeningService();

    private AuthorizationService autzService = AuthzRegistry.authorizationService();

    public Iterable<JobOpening> allJobOpenings() {
        return service.allJobs();
    }
}
