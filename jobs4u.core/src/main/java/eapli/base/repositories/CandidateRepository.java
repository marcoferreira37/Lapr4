package eapli.base.repositories;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.candidate.CandidateId;
import eapli.framework.domain.repositories.DomainRepository;

public interface CandidateRepository extends DomainRepository <Long, Candidate> {

    Candidate findByName(String name);

    Iterable<Candidate> findAllCandidates();
        
}
