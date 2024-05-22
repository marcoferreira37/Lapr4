package eapli.base.repositories;



import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.framework.domain.repositories.DomainRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobOpeningApplicationRepository extends DomainRepository<Long, JobOpeningApplication>{
    Optional<JobOpeningApplication> ofIdentity(Long id);

    JobOpening findJobOpeningByApplicationId(Long id);

    Iterable<JobOpeningApplication> findAllApplicationsForJobOpening(JobOpening jobOpening);

    Iterable<JobOpeningApplication> allApplicationsById(Candidate candidate);

}
