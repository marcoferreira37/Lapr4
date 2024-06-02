package eapli.base.persistence.impl.inmemory;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpeningProcess.JobOpeningProcess;
import eapli.base.repositories.JobOpeningProcessRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryJobOpeningProcessRepository extends InMemoryDomainRepository<JobOpeningProcess, Long> implements JobOpeningProcessRepository {


    @Override
    public JobOpeningProcess findById(long id) {
        return matchOne(e -> e.identity().equals(id)).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public JobOpeningProcess findJobProcessByJobOpening(JobOpening job) {
        return matchOne(e -> e.jobOpening().sameAs(job)).orElseThrow(IllegalArgumentException::new);
    }
}
