package eapli.base.persistence.impl.jpa;


import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.candidate.CandidateId;
import eapli.base.repositories.CandidateRepository;
import jakarta.persistence.TypedQuery;

import java.util.Optional;


public class JpaCandidateRepository extends BasepaRepositoryBase<Candidate, Long, Long> implements CandidateRepository {
    public JpaCandidateRepository() {
        super("id");
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
        TypedQuery<Candidate> query = entityManager().createQuery(
                "SELECT DISTINCT c FROM Candidate c " +
                        "JOIN c.user u " +
                        "WHERE u.email = :email", Candidate.class);

        return query.getResultList();
    }

    @Override
    public Optional<Candidate> ofIdentity(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteOfIdentity(Long entityId) {

    }
}