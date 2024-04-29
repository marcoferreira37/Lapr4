package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.JobReference;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import eapli.base.repositories.JobOpeningRepository;
import jakarta.persistence.EntityManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaJobOpeningRepository extends JpaAutoTxRepository<JobOpening, Long, Long> implements JobOpeningRepository {
    public JpaJobOpeningRepository(String persistenceUnitName, String identityFieldName) {
        super(persistenceUnitName, identityFieldName);
    }

    public JpaJobOpeningRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "iD");
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
        JobOpening jo = match("jo.id=MAX(jo.id)").get(0);


        return jo == null ? 1 : jo.getJobReference().iD();
    }
}