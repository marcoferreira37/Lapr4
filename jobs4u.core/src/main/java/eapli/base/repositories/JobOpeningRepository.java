package eapli.base.repositories;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.JobReference;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface JobOpeningRepository extends DomainRepository<JobReference,JobOpening> {
    Optional<JobOpening> ofIdentity(JobReference jobReference);

    void deleteOfIdentity(JobReference jobReference);

}
