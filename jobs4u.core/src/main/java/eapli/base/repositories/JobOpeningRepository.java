package eapli.base.repositories;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.JobReference;
import eapli.framework.domain.repositories.DomainRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface JobOpeningRepository extends DomainRepository<JobReference, JobOpening> {

    Long getLastIdFromCompany(Long companyId);

    List<JobOpening> listJobOpenings(Predicate<JobOpening> filter);

   JobOpening findJobOpeningByFullReference(String jobReference);
}
