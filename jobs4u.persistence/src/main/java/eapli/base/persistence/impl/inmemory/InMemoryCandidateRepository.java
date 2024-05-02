package eapli.base.persistence.impl.inmemory;

import eapli.base.domain.candidate.Candidate;
import eapli.base.repositories.CandidateRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCandidateRepository extends InMemoryDomainRepository<Candidate, Long> implements CandidateRepository{

        static {
            InMemoryInitializer.init(); // Assuming this is some initialization method
        }

        @Override
        public Candidate findByName(String name) {
            return matchOne(candidate -> candidate.name().equals(name)).orElse(null);
        }

        @Override
        public Iterable<Candidate> findAllCandidates() {
            return findAll();
        }
}
