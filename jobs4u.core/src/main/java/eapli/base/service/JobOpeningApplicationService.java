package eapli.base.service;


import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.repositories.JobOpeningApplicationRepository;
import org.springframework.stereotype.Component;

@Component
public class JobOpeningApplicationService {

    private final JobOpeningApplicationRepository repository;

    public JobOpeningApplicationService(JobOpeningApplicationRepository repository) {
        this.repository = repository;
    }
    public Iterable<JobOpeningApplication> getJobOpeningApplication() {
        return repository.findAll();
    }



}
