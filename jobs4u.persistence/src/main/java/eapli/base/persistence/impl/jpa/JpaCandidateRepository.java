package eapli.base.persistence.impl.jpa;


import eapli.base.Application;
import eapli.base.domain.candidate.Candidate;
import eapli.base.repositories.CandidateRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jakarta.persistence.TypedQuery;

import java.util.Optional;


public class JpaCandidateRepository extends JpaAutoTxRepository<Candidate, Long, Long> implements CandidateRepository {
    public JpaCandidateRepository(String persistenceUnitName) {

        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    public JpaCandidateRepository(TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    @Override
    public Candidate findByName(String name) {
        // Query that returns the board with the specified title and not archived
        final TypedQuery<Candidate> query = entityManager().createQuery("SELECT c FROM Candidate c" +
                " WHERE c.name= :name", Candidate.class);
        query.setParameter("name", name);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Iterable<Candidate> findAllCandidates() {
      return this.findAll();
    }

    @Override
    public Optional<Candidate> ofIdentity(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteOfIdentity(Long entityId) {

    }

    public Candidate findCandidateBySystemUser(SystemUser user){

        final TypedQuery<Candidate> query = entityManager().createQuery("SELECT c FROM Candidate c" +
                " WHERE c.user= :user", Candidate.class);
        query.setParameter("user", user);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }
}