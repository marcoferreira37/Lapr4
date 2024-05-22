package eapli.base.usermanagement.application;

import eapli.base.domain.JobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.infrastructure.authz.AuthenticationCredentialHandler;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobOpeningRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

import static eapli.base.domain.JobOpeningProcess.PhaseType.ANALYSIS;

public class ListAllApplicationsForJobOpeningController {
//    private final AuthorizationService authz = AuthzRegistry.authorizationService();
//    public ListAllApplicationsForJobOpeningController(){
//        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWER_USER);
//    }


    private JobOpeningRepository repository = PersistenceContext.repositories().jobOpeningRepository();

    public Iterable<JobOpening> allJobOpenings() {
        final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpeningRepository();
        return jobOpeningRepository.findAll();
    }

    public List<JobOpeningApplication> allApplicationsForJobOpening(JobOpening jobOpening) {
        return (List<JobOpeningApplication>) PersistenceContext.repositories().jobApplications().findAllApplicationsForJobOpening(jobOpening);

    }

    public Object findAllByAnalysisPhase() {
        List<JobOpening> listToReturn = (List<JobOpening>) repository.findAll();
        List<JobOpening> listToReturnFiltered = new ArrayList<>();

        for (JobOpening job : listToReturn) {
            if (job.getCurrentJobPhase() == ANALYSIS) {
                listToReturnFiltered.add(job);
            }
        }
        return listToReturnFiltered;
    }

}

