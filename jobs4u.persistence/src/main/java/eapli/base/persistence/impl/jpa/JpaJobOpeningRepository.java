package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.JobReference;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import eapli.base.repositories.JobOpeningRepository;
import jakarta.persistence.EntityManager;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;

public class JpaJobOpeningRepository
        extends JpaAutoTxRepository<JobOpening, Long, Long>
        implements JobOpeningRepository {
    public JpaJobOpeningRepository(String persistenceUnitName, String identityFieldName) {
        super(persistenceUnitName, identityFieldName);
    }

    public JpaJobOpeningRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "JOB_REFERENCE");
    }

    public JpaJobOpeningRepository(final TransactionalContext autoTx) {
        super(autoTx, "JOB_REFERENCE");
    }

    @Override
    public Optional<JobOpening> ofIdentity(JobReference jobReference) {
        final Map<String, Object> params = new HashMap<>();
        params.put("jobReference", jobReference);
        return matchOne("e.jobReference = :jobReference", params);
    }


    @Override
    public void deleteOfIdentity(JobReference jobReference) {
        final Optional<JobOpening> jobOpeningOptional = ofIdentity(jobReference);
        jobOpeningOptional.ifPresent(this::delete); // Delete if the JobOpening exists
    }

    @Override
    public Long getLastIdFromCompany(Long companyId) {
        long max = -1L;

        for (JobOpening jobOpening : findAll()) {
            if (jobOpening.getJobReference().iD() > max && Objects.equals(jobOpening.getCompany().getId(), companyId)) {
                max = jobOpening.getJobReference().iD();
            }
        }
        return max;
    }


    @Override
    public JobOpening findJobOpeningByFullReference(String jobReference) {
        return createQuery("SELECT opening FROM JobOpening opening", JobOpening.class)
                .getResultList()
                .stream()
                .filter(jobOpening -> jobOpening.getJobReference().fullReference().equals(jobReference))
                .findFirst()
                .orElse(null);
    }

}
