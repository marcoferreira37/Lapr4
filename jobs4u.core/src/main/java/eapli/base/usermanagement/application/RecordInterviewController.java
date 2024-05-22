package eapli.base.usermanagement.application;

import eapli.base.domain.JobApplication.JobOpeningApplication;
import eapli.base.domain.candidate.Candidate;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobOpeningApplicationRepository;

import java.util.List;

public class RecordInterviewController {


    private final JobOpeningApplicationRepository repo = PersistenceContext.repositories().jobApplications();

    public List<JobOpeningApplication> getJobOpeningApplication() {
        return (List<JobOpeningApplication>) repo.findAll();
    }

    public Candidate getCandidate(JobOpeningApplication jobOpeningApplication) {
        return jobOpeningApplication.candidate();
    }
}
