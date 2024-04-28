package eapli.base.Domain.repositories;

import eapli.base.Domain.jobOpening.JobOpening;
import eapli.base.Domain.jobOpening.JobReference;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface JobOpeningRepository extends DomainRepository<JobReference,JobOpening> {
    Optional<JobOpening> ofIdentity(JobReference jobReference);

    void deleteOfIdentity(JobReference jobReference);

}
