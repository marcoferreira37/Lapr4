package eapli.base.persistence.impl.inmemory;

import eapli.base.customer.Customer;
import eapli.base.domain.candidate.Candidate;
import eapli.base.repositories.CandidateRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCandidateRepository extends InMemoryDomainRepository<Candidate, EmailAddress> implements CandidateRepository{

        static {
            InMemoryInitializer.init(); // Assuming this is some initialization method
        }

        @Override
        public Iterable<Candidate> findAllCandidates() {
            return findAll();
        }

    @Override
    public Iterable<Candidate> findByActive(boolean active) {
        return null;
    }
}
