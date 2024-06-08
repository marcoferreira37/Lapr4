package eapli.base.usermanagement.application.services;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.notifications.NotificationBuilder;
import eapli.base.protocol.Notifications;
import eapli.base.repositories.NotificationsRepository;
import jakarta.transaction.Transactional;

import java.util.Set;

public class NotificationAppService {
    private final NotificationsRepository notificationsRepository = PersistenceContext.repositories().notificationsRepository();

    public NotificationAppService() {
    }

    @Transactional
    public Notifications notify(String userName, String content) {
        final var notificationBuilder = new NotificationBuilder();
        final var notification = notificationBuilder.withUserName(userName).withContent(content).build();
        return notificationsRepository.save(notification);
    }

    public Iterable<Notifications> findBySend(boolean b) {
        return notificationsRepository.findBySend(b);
    }

    public void setSendTrue(Notifications notification) {
        notification.setSend(true);
        notificationsRepository.save(notification);
    }
}
