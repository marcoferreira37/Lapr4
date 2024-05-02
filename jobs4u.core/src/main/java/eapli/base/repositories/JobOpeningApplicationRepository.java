package eapli.base.repositories;



import eapli.base.domain.JobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface JobOpeningApplicationRepository extends DomainRepository<Long, JobOpeningApplication>{
    Optional<JobOpeningApplication> ofIdentity(Long id);

    public JobOpening findJobOpeningByApplicationId(Long id);
}
