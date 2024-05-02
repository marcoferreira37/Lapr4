package eapli.base.persistence.impl.inmemory;

import eapli.base.domain.JobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.repositories.JobOpeningApplicationRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.nio.file.Files.find;

public class InMemoryJobApplicationRepository extends InMemoryDomainRepository<JobOpeningApplication, Long> implements JobOpeningApplicationRepository {
    @Override
    public JobOpening findJobOpeningByApplicationId(Long id) {
        // Assuming you have a method to get a JobOpening by its id
        return findById(id).get().jobOpening();
    }

    @Override
    public Iterable<JobOpeningApplication> findAllApplicationsForJobOpening(JobOpening jobOpening) {
        // Convert Iterable to Stream
        Stream<JobOpeningApplication> applicationStream = StreamSupport.stream(findAll().spliterator(), false);

        // Filter and collect results
        return applicationStream
                .filter(application -> application.jobOpening().equals(jobOpening))
                .collect(Collectors.toList());
    }
}