package eapli.base.repositories;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.EmailAddress;

public interface CandidateRepository extends DomainRepository <EmailAddress, Candidate> {

    Iterable<Candidate> findByActive(boolean active);

    Iterable<Candidate> findAllCandidates();

    Iterable<Candidate> getCandidate(JobOpeningApplication jobOpeningApplication);

}
