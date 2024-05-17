package eapli.base.domain.JobApplication;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.JobOpeningApplicationRepository;
import eapli.base.repositories.JobOpeningRepository;

import java.util.List;

public class AddJobApplicationController {
    private final JobOpeningApplicationRepository repo = PersistenceContext.repositories().jobApplications();
    private final JobOpeningRepository repositoryJobOpening = PersistenceContext.repositories().jobOpeningRepository();


    public JobOpeningApplication addJobOpeningApplication(JobOpening j, Candidate c) {
        JobOpeningApplication jobOpeningApplication = new JobOpeningApplication(j, c);
        repo.save(jobOpeningApplication);
        return jobOpeningApplication;
    }

    public List<JobOpening> listJobOpenings() {
        return (List<JobOpening>) repositoryJobOpening.findAll();
    }


    public void readFile(String file, JobOpening selectedJob) {
        JobOpeningApplication jobOpeningApplication = JobOpeningApplication.readFile(file, selectedJob);
        repo.save(jobOpeningApplication);
    }
}
