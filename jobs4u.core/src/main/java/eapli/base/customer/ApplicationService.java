package eapli.base.customer;

import eapli.base.domain.JobApplication.JobOpeningApplication;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobOpeningApplicationRepository;
import eapli.base.repositories.JobOpeningRepository;

public class ApplicationService {
    private final JobOpeningApplicationRepository jobOpeningApplicationRepository = PersistenceContext.repositories().jobApplications();

    public void rankApplication(JobOpeningApplication application, int rank) {
        application.rankApplication(rank);
        jobOpeningApplicationRepository.save(application);
    }
}
