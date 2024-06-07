package eapli.base.persistence.impl.jpa;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.protocol.Notifications;
import eapli.base.repositories.NotificationsRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jakarta.persistence.TypedQuery;

public class JpaNotificationsRepository extends JpaAutoTxRepository<Notifications, Long, Long> implements NotificationsRepository {


    public JpaNotificationsRepository(String persistenceUnitName, String identityFieldName) {
        super(persistenceUnitName, identityFieldName);
    }

    @Override
    public Iterable<Notifications> findByActive(boolean active) {

        return match("e.active = :active", "active", active);

    }

    @Override
    public Iterable<Notifications> findAllNotifications() {
        TypedQuery<Notifications> query = createQuery("SELECT c FROM Notifications c", Notifications.class);
        return query.getResultList();
    }

    @Override
    public Iterable<Notifications> getNotifications(JobOpeningApplication jobOpeningApplication) {
        return match("e.jobOpeningApplication = :jobOpeningApplication", "jobOpeningApplication", jobOpeningApplication);
    }
}
