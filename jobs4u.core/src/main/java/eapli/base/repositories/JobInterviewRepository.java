package eapli.base.repositories;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.framework.domain.repositories.DomainRepository;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.util.Optional;

public interface JobInterviewRepository extends DomainRepository<Long, JobInterview> {
    Optional<JobInterview> ofIdentity(Long id);

    JobInterview findJobInterviewById(Long id);


    Iterable<JobInterview> allJobInterviewsById(JobOpeningApplication jobOpeningApplication);

















}