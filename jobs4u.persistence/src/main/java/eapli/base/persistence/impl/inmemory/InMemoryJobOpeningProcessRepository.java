package eapli.base.persistence.impl.inmemory;

import eapli.base.domain.jobOpeningProcess.JobOpeningProcess;
import eapli.base.repositories.JobOpeningProcessRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryJobOpeningProcessRepository extends InMemoryDomainRepository<JobOpeningProcess, Long> implements JobOpeningProcessRepository {


    @Override
    public JobOpeningProcess findById(long id) {
        return matchOne(e -> e.identity().equals(id)).orElseThrow(IllegalArgumentException::new);
    }
}
