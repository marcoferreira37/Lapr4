package eapli.base.usermanagement.application.services;

import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobOpeningApplicationRepository;

public class ApplicationService {
    private final JobOpeningApplicationRepository jobOpeningApplicationRepository = PersistenceContext.repositories().jobApplications();

    public void rankApplication(JobOpeningApplication application, int rank) {
        application.rankApplication(rank);
        jobOpeningApplicationRepository.save(application);
    }
}
