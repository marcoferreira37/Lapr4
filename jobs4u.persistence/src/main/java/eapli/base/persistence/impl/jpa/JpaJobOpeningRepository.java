package eapli.base.persistence.impl.jpa;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.JobReference;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import eapli.base.repositories.JobOpeningRepository;
import jakarta.persistence.EntityManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaJobOpeningRepository extends JpaAutoTxRepository<JobOpening, Long, Long> implements JobOpeningRepository{
    public JpaJobOpeningRepository(String persistenceUnitName, String identityFieldName) {
        super(persistenceUnitName, identityFieldName);
    }

    @Override
    public Optional<JobOpening> ofIdentity(JobReference id) {
        final Map<String, Object> params = new HashMap<>();
        params.put("jobReference", id);
        return matchOne("e.jobReference=:id", params);
    }

    @Override
    public void deleteOfIdentity(JobReference entityId) {
        EntityManager entityManager = entityManager(); // Retrieve EntityManager from JpaAutoTxRepository
        JobOpening jobOpening = entityManager.find(JobOpening.class, entityId);
        if (jobOpening != null) {
            entityManager.remove(jobOpening);
        }
    }

}