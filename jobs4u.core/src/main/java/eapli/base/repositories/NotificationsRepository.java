package eapli.base.repositories;

import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.base.protocol.Notifications;
import eapli.framework.domain.repositories.DomainRepository;

public interface NotificationsRepository extends DomainRepository<Long, Notifications> {

    Iterable<Notifications> findByActive(boolean active);

}