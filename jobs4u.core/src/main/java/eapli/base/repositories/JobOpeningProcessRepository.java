package eapli.base.repositories;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.JobReference;
import eapli.base.domain.jobOpeningProcess.JobOpeningProcess;
import eapli.framework.domain.repositories.DomainRepository;

public interface JobOpeningProcessRepository extends DomainRepository<Long, JobOpeningProcess> {
    JobOpeningProcess findById(long id);
}
