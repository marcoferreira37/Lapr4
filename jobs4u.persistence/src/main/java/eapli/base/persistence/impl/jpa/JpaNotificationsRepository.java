package eapli.base.persistence.impl.jpa;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.protocol.Notifications;
import eapli.base.repositories.NotificationsRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jakarta.persistence.TypedQuery;

import java.util.HashMap;
import java.util.Map;

public class JpaNotificationsRepository extends JpaAutoTxRepository<Notifications, Long, Long> implements NotificationsRepository {


    public JpaNotificationsRepository(String persistenceUnitName, String identityFieldName) {
        super(persistenceUnitName, identityFieldName);
    }

    public JpaNotificationsRepository(String persistenceUnitName) {
        super(persistenceUnitName, "id");
    }

    public JpaNotificationsRepository(TransactionalContext autoTx) {

        super(autoTx, "id");
    }

    @Override
    public Iterable<Notifications> findByActive(boolean active) {

        return match("e.active = :active", "active", active);

    }

    @Override
    public Iterable<Notifications> findBySend(boolean b) {
        final Map<String, Object> map = new HashMap<>();
        map.put("b", b);
        return match("e.isSend = :b", map);
    }
}
