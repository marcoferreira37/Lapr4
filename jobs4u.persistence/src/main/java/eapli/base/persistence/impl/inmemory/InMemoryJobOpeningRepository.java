package eapli.base.persistence.impl.inmemory;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.JobReference;
import eapli.base.persistence.impl.inmemory.InMemoryInitializer;
import eapli.base.repositories.JobOpeningRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryJobOpeningRepository
        extends InMemoryDomainRepository<JobOpening, JobReference>
        implements JobOpeningRepository {

    static {
        InMemoryInitializer.init(); // Assuming this is some initialization method
    }

    @Override
    public Optional<JobOpening> ofIdentity(JobReference jobReference) {
        return matchOne(jobOpening -> jobOpening.identity().equals(jobReference));
    }

    @Override
    public void deleteOfIdentity(JobReference jobReference) {
        final Optional<JobOpening> jobOpeningOptional = ofIdentity(jobReference);
        jobOpeningOptional.ifPresent(this::delete); // Delete if the JobOpening exists
    }

    @Override
    public Long getLastIdFromCompany(Long companyId) {

        LinkedList<JobOpening> l = new LinkedList<>((Collection<JobOpening>) findAll());
        l.sort((o1, o2) -> Long.compare(o2.getJobReference().iD(), o1.getJobReference().iD()));
        return l.getFirst().getJobReference().iD();
    }
}
