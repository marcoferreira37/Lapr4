package eapli.base.usermanagement.application;

import eapli.base.domain.JobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.infrastructure.authz.AuthenticationCredentialHandler;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobOpeningRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;

public class ListAllApplicationsForJobOpeningController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    public ListAllApplicationsForJobOpeningController(){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWER_USER);
    }


    public Iterable<JobOpening> AllJobOpenings() {
        final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpeningRepository();
        return jobOpeningRepository.findAll();
    }

    public List<JobOpeningApplication> AllApplicationsForJobOpening(JobOpening jobOpening) {
        return(List<JobOpeningApplication>) PersistenceContext.repositories().jobApplications().findAllApplicationsForJobOpening(jobOpening);
    }
}
