package eapli.base.domain.JobApplication;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobOpeningApplicationRepository;

public class AddJobApplicationController {
    private final JobOpeningApplicationRepository repo = PersistenceContext.repositories().jobApplications();

    public JobOpeningApplication addJobOpeningApplication(JobOpening j, Candidate c) {
        JobOpeningApplication jobOpeningApplication = new JobOpeningApplication(j, c);
        repo.save(jobOpeningApplication);
        return jobOpeningApplication;
    }
}
