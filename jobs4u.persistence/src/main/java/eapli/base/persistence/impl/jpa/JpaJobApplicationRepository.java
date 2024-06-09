package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.repositories.JobOpeningApplicationRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class JpaJobApplicationRepository extends JpaAutoTxRepository<JobOpeningApplication, Long, Long> implements JobOpeningApplicationRepository {
    public JpaJobApplicationRepository(String persistenceUnitName, String identityFieldName) {
        super(persistenceUnitName, identityFieldName);
    }

    public JpaJobApplicationRepository(TransactionalContext autoTx) {
        super(autoTx,"APPLICATIONID");
    }
    public JpaJobApplicationRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "APPLICATIONID");
    }

    @Override
    public JobOpening findJobOpeningByApplicationId(Long id) {

        EntityManager em = entityManager();
        TypedQuery<JobOpeningApplication> query = em.createQuery(
                "SELECT a FROM JobOpeningApplication a WHERE a.id = :id",
                JobOpeningApplication.class
        );
        query.setParameter("id", id);
        JobOpeningApplication jobOpeningApplication = query.getSingleResult();
        return jobOpeningApplication.jobOpening;
    }

    @Override
    public Iterable<JobOpeningApplication> findAllApplicationsForJobOpening(JobOpening jobOpening) {
        EntityManager em = entityManager();
        TypedQuery<JobOpeningApplication> query = em.createQuery(
                "SELECT a FROM JobOpeningApplication a WHERE a.jobOpening = :jobOpening",
                JobOpeningApplication.class
        );
        query.setParameter("jobOpening", jobOpening);
        return query.getResultList();
    }

    @Override
    public Iterable<JobOpeningApplication> allApplicationsByCandidate(Candidate candidate) {
        EntityManager em = entityManager();
        TypedQuery<JobOpeningApplication> query = em.createQuery(
                "SELECT a FROM JobOpeningApplication a WHERE a.candidate = :candidate",
                JobOpeningApplication.class
        );
        query.setParameter("candidate", candidate.emailAddress());
        return query.getResultList();
    }

//    @Override
//    public Iterable<JobOpeningApplication> findAll(){return repo.findAll();}

}
