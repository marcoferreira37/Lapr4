package eapli.base.repositories;

import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.protocol.Notifications;

public interface NotificationsRepository {

    Iterable<Notifications> findByActive(boolean active);

    Iterable<Notifications> findAllNotifications();

    Iterable<Notifications> getNotifications(JobOpeningApplication jobOpeningApplication);
}
