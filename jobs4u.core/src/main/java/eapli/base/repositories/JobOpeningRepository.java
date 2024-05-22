package eapli.base.repositories;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.JobReference;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;
import java.util.function.Predicate;

public interface JobOpeningRepository extends DomainRepository<JobReference, JobOpening> {

    Long getLastIdFromCompany(Long companyId);

   JobOpening findJobOpeningByFullReference(String jobReference);
}
