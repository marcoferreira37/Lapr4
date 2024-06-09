package eapli.base.persistence.impl.inmemory;

import eapli.base.domain.EmailNotification.EmailToSend;
import eapli.base.repositories.EmailToSendRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.ArrayList;

public class InMemoryEmailToSendRespository extends InMemoryDomainRepository<EmailToSend, Long> implements EmailToSendRepository{
    @Override
    public Iterable<EmailToSend> findToSends(boolean b) {
        ArrayList<EmailToSend> result = new ArrayList<>();
            for (EmailToSend email : findAll()) {
                if (email.sent() == b) {
                    result.add(email);
                }
            }
        return result;
    }
}
