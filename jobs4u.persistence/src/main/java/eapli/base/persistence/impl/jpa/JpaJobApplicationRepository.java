package eapli.base.persistence.impl.jpa;

import eapli.base.domain.JobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.repositories.JobOpeningApplicationRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.Optional;

public class JpaJobApplicationRepository extends JpaAutoTxRepository<JobOpeningApplication, Long, Long> implements JobOpeningApplicationRepository {
    public JpaJobApplicationRepository(String persistenceUnitName, String identityFieldName) {
        super(persistenceUnitName, identityFieldName);
    }

    @Override
    public <S extends JobOpeningApplication> S save(S entity) {
        return null;
    }

    @Override
    public Iterable<JobOpeningApplication> findAll() {
        return null;
    }

    @Override
    public Optional<JobOpeningApplication> ofIdentity(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(JobOpeningApplication entity) {

    }

    @Override
    public void deleteOfIdentity(Long entityId) {

    }
    @Override
    public long count() {
        return 0;
    }

    @Override
    public JobOpening findJobOpeningByApplicationId(Long id) {
      return null;
    }
}
