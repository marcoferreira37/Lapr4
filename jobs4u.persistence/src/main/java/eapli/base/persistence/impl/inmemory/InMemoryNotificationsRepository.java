package eapli.base.persistence.impl.inmemory;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.protocol.Notifications;
import eapli.base.repositories.NotificationsRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryNotificationsRepository extends InMemoryDomainRepository<Notifications, Long> implements NotificationsRepository {

    static {
        InMemoryInitializer.init(); // Assuming this is some initialization method
    }


    @Override
    public Iterable<Notifications> findByActive(boolean active) {
        return null;
    }

    @Override
    public <S extends Notifications> S save(S entity) {
        return super.save(entity);
    }

    @Override
    public Iterable<Notifications> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Notifications> ofIdentity(Long id) {
        return matchOne(Notifications -> Notifications.identity().equals(id));

    }

    @Override
    public void delete(Notifications entity) {

    }

    @Override
    public void deleteOfIdentity(Long entityId) {
        final Optional<Notifications> notifications = ofIdentity(entityId);
        notifications.ifPresent(this::delete); // Delete if the JobOpening exists

    }

    @Override
    public long count() {
        return 0;
    }

}
