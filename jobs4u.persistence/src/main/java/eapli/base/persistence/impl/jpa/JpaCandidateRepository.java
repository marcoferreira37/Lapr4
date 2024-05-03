package eapli.base.persistence.impl.jpa;


import eapli.base.Application;
import eapli.base.domain.candidate.Candidate;
import eapli.base.repositories.CandidateRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.Optional;

import eapli.framework.general.domain.model.EmailAddress;
import jakarta.persistence.TypedQuery;

public class JpaCandidateRepository extends JpaAutoTxRepository<Candidate, EmailAddress, EmailAddress> implements CandidateRepository {

        public JpaCandidateRepository(final String puname) {
            super(puname, Application.settings().getExtendedPersistenceProperties(),
                    "mecanographicNumber");
        }
        public JpaCandidateRepository(final TransactionalContext autoTx) {
            super(autoTx, "mecanographicNumber");
        }

        @Override
        public Iterable<Candidate> findByActive(boolean active) {
            return match("e.active = :active", "active", active);
        }

        @Override
        public Iterable<Candidate> findAllCandidates() {
            TypedQuery<Candidate> query = createQuery("SELECT c FROM Candidate c", Candidate.class);
            return query.getResultList();
        }

    }