package eapli.base.usermanagement.application.controllers;

import eapli.base.candidate.CandidateManagementService;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.usermanagement.application.services.ApplicationService;
import eapli.base.usermanagement.application.services.JobOpeningService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class OrderedCandidatesController {

    //cria este método
    private final ApplicationService applicationService;


    public OrderedCandidatesController() {

        applicationService = new ApplicationService();
    }

    //For testing purpose
    public OrderedCandidatesController(JobOpeningService service, AuthorizationService autzService, CandidateManagementService candidateSvc, ApplicationService applicationService) {

        this.applicationService = applicationService;
    }


    /**
     * Get ordered candidates for a job opening.
     *
     * @param jobOpening the job opening to get candidates for
     * @return a list of candidates ordered by job interview grade in descending order
     */
    public List<JobInterview> orderedCandidatesOfJobOpening(final JobOpening jobOpening) {
        // Fetch candidates associated with the job opening
        List<JobOpeningApplication> candidates = applicationService.getApplicationsByJobOpening(jobOpening);
        List<JobInterview> interviews = applicationService.getAllJobInterviewsOfApplications(candidates);

        // Convert iterable to list and sort by job interview grade in descending order
        interviews.sort((app1, app2) -> {
            int grade1 = app1.grade();
            int grade2 = app2.grade();
            return Integer.compare(grade2, grade1);
        });
        return interviews;
    }

    public List<JobOpening> findAllJobOpeningInResult() {

        return applicationService.findAllJobOpeningInResult();

    }
}
