package eapli.base.usermanagement.application.controllers;

import eapli.base.candidate.CandidateManagementService;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.candidate.Candidate;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobOpeningApplicationRepository;
import eapli.base.service.JobOpeningApplicationService;

import java.util.List;

public class RecordInterviewController {


    private final JobOpeningApplicationRepository repo = PersistenceContext.repositories().jobApplications();

    private final JobOpeningApplicationService service = new JobOpeningApplicationService(repo);

    private final CandidateManagementService candidateManagementService = new CandidateManagementService();

//    public List<JobOpeningApplication> getJobOpeningApplication() {
//        return (List<JobOpeningApplication>) repo.findAll();
//    }

    public Iterable<JobOpeningApplication> getJobOpeningApplication(){
    return service.allJobOpeningApplication();
    }

//    public Candidate getCandidate(JobOpeningApplication jobOpeningApplication) {
//        return jobOpeningApplication.candidate();
//    }

    public Iterable<Candidate> getCandidate(JobOpeningApplication jobOpeningApplication) {
        return candidateManagementService.getCandidate(jobOpeningApplication);
    }
}
