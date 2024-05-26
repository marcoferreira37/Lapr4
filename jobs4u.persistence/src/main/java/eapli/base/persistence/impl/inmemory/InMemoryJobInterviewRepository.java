package eapli.base.persistence.impl.inmemory;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.repositories.JobInterviewRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class InMemoryJobInterviewRepository extends InMemoryDomainRepository<JobInterview, Long> implements JobInterviewRepository {


    @Override
    public JobInterview findJobInterviewById(Long id) {
       return findById(id).get().jobInterview();
    }

//    @Override
//    public Iterable<JobInterview> findAllInterview(JobInterview jobInterview) {
//        // Convert Iterable to Stream
//        Stream<JobInterview> applicationStream = StreamSupport.stream(findAll().spliterator(), false);
//
//        // Filter and collect results
//        return applicationStream
//                .filter(application -> application.jobInterview().equals(jobInterview)).collect(Collectors.toList());
//    }


    @Override
    public Iterable<JobInterview> allJobInterviewsById(Candidate candidate) {
        // Convert Iterable to Stream
        Stream<JobInterview> applicationStream = StreamSupport.stream(findAll().spliterator(), false);

        // Filter and collect results
        return applicationStream
                .filter(application -> application.candidate().equals(candidate))
                .collect(Collectors.toList());
    }




}
