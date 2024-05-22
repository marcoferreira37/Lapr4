package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobOpeningRepository;

import java.util.ArrayList;
import java.util.List;

import static eapli.base.domain.jobOpeningProcess.PhaseType.ANALYSIS;

public class ListAllApplicationsForJobOpeningController {
//    private final AuthorizationService authz = AuthzRegistry.authorizationService();
//    public ListAllApplicationsForJobOpeningController(){
//        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWER_USER);
//    }


    private final JobOpeningRepository repository = PersistenceContext.repositories().jobOpeningRepository();

    public Iterable<JobOpening> allJobOpenings() {
        final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpeningRepository();
        return jobOpeningRepository.findAll();
    }

    public List<JobOpeningApplication> allApplicationsForJobOpening(JobOpening jobOpening) {
        return(List<JobOpeningApplication>) PersistenceContext.repositories().jobApplications().findAllApplicationsForJobOpening(jobOpening);

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

