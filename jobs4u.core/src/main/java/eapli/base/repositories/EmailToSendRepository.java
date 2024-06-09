package eapli.base.repositories;

import eapli.base.domain.EmailNotification.EmailToSend;
import eapli.framework.domain.repositories.DomainRepository;

public interface EmailToSendRepository extends DomainRepository<Long, EmailToSend> {
    Iterable<EmailToSend> findToSends(boolean b);
}
