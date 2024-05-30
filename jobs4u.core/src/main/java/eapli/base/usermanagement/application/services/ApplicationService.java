package eapli.base.usermanagement.application.services;

import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobOpeningApplicationRepository;

public class ApplicationService {
    private final JobOpeningApplicationRepository jobOpeningApplicationRepository = PersistenceContext.repositories().jobApplications();

    public void rankApplication(JobOpeningApplication application, int rank) {
        application.rankApplication(rank);
        jobOpeningApplicationRepository.save(application);
    }

    public JobInterview getJobInterview(JobOpeningApplication jobOpeningApplication) {
        return jobOpeningApplication.getInterviews().get(0);
    }
}
