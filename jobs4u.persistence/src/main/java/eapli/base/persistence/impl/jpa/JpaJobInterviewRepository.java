package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.repositories.JobInterviewRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaJobInterviewRepository extends JpaAutoTxRepository<JobInterview, Long, Long> implements JobInterviewRepository {

    public JpaJobInterviewRepository(String persistenceUnitName, String identityFieldName) {
        super(persistenceUnitName, identityFieldName);
    }

    public JpaJobInterviewRepository(TransactionalContext autoTx) {
        super(autoTx,"INTERVIEWID");
    }
    public JpaJobInterviewRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "INTERVIEWID");
    }

    @Override
    public JobInterview findJobInterviewById(Long id) {

        EntityManager em = entityManager();
        TypedQuery<JobInterview> query = em.createQuery(
                "SELECT a FROM JobInterview a WHERE a.id = :id",
                JobInterview.class
        );
        query.setParameter("id", id);
        JobInterview jobInterview = query.getSingleResult();
        return jobInterview;
    }




    @Override
    public Iterable<JobInterview> allJobInterviewsById(JobOpeningApplication jobOpeningApplication) {
        EntityManager em = entityManager();
        TypedQuery<JobInterview> query = em.createQuery(
                "SELECT a FROM JobInterview a WHERE a.jobOpeningApplication = :jobOpeningApplication",
                JobInterview.class
        );
        query.setParameter("jobOpeningApplication", jobOpeningApplication);
        return query.getResultList();
    }

    @Override
    public Optional<JobInterview> findByJobApplication(JobOpeningApplication app) {
        final Map<String, Object> params = new HashMap<>();
        params.put("app", app);
        return matchOne("e.jobOpeningApplication = :app", params);
    }


}
