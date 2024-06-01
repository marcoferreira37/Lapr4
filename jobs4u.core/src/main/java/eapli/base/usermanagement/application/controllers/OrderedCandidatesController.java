package eapli.base.usermanagement.application.controllers;

import eapli.base.candidate.CandidateManagementService;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpeningInterview.JobInterview;
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
    private final JobOpeningService service;

    private final AuthorizationService autzService;

    private final CandidateManagementService candidateSvc;


    public OrderedCandidatesController() {
        autzService = AuthzRegistry.authorizationService();
        service = new JobOpeningService();
        candidateSvc = new CandidateManagementService();
    }

    //For testing purpose
    public OrderedCandidatesController(JobOpeningService service, AuthorizationService autzService, CandidateManagementService candidateSvc) {
        this.service = service;
        this.autzService = autzService;
        this.candidateSvc = candidateSvc;
    }


    /**
     * Get ordered candidates for a job opening.
     *
     * @param jobOpening the job opening to get candidates for
     * @return a list of candidates ordered by job interview grade in descending order
     */
    public List<Candidate> orderedCandidatesOfJobOpening(final JobOpening jobOpening) {
        // Fetch candidates associated with the job opening
        Iterable<Candidate> candidatesIterable = candidateSvc.candidatesOfJobOpening(jobOpening);

        // Convert iterable to list and sort by job interview grade in descending order

        return StreamSupport.stream(candidatesIterable.spliterator(), false)
                .sorted((c1, c2) -> {
                    // Get the grades for comparison
                    double grade1 = getHighestInterviewGrade(c1);
                    double grade2 = getHighestInterviewGrade(c2);
                    return Double.compare(grade2, grade1); // Sorting by grade in descending order
                })
                .collect(Collectors.toList());
    }

    /**
     * Get the highest job interview grade for a candidate.
     *
     * @param candidate the candidate to get the grade for
     * @return the highest grade of the candidate's job interviews
     */
    private double getHighestInterviewGrade(Candidate candidate) {
        return Double.parseDouble(null);
    }
}
