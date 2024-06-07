package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.candidate.Candidate;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.CandidateRepository;
import eapli.base.repositories.JobInterviewRepository;
import eapli.base.repositories.JobOpeningApplicationRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

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

    public Iterable<JobOpeningApplication> allApplicationsById(Candidate candidate) {
        final JobOpeningApplicationRepository applications = PersistenceContext.repositories().jobApplications();
        return applications.allApplicationsByCandidate(candidate);
    }

    public List<JobOpeningApplication> allApplicationsByIdWithInterview(Candidate candidate) {
        List<JobOpeningApplication> applications = (List<JobOpeningApplication>) allApplicationsById(candidate);
      final JobInterviewRepository interviewRepo = PersistenceContext.repositories().jobInterviews();
        applications.removeIf(app -> interviewRepo.findByJobApp(app) == null);
        return applications;
    }
}

