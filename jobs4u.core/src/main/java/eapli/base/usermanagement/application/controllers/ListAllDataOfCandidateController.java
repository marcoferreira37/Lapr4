package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.candidate.Candidate;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.CandidateRepository;
import eapli.base.repositories.JobOpeningApplicationRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class ListAllDataOfCandidateController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public ListAllDataOfCandidateController() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWER_USER, BaseRoles.ADMIN);
    }

    public Iterable<Candidate> allCandidates() {
        final CandidateRepository candidateRepository = PersistenceContext.repositories().candidateRepository();
        return candidateRepository.findAllCandidates();
    }

    public Iterable<JobOpeningApplication> allApplicationsById(Candidate candidate) {
        final JobOpeningApplicationRepository applications = PersistenceContext.repositories().jobApplications();
        return applications.allApplicationsByCandidate(candidate);
    }

}

