package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.domain.EmailNotification.EmailToSend;
import eapli.base.repositories.EmailToSendRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaEmailToSendRepository extends JpaAutoTxRepository<EmailToSend,Long,Long> implements EmailToSendRepository{

    public JpaEmailToSendRepository(String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "ID");
    }

    public JpaEmailToSendRepository(final TransactionalContext autoTx) {
        super(autoTx, "ID");
    }


    @Override
    public Iterable<EmailToSend> findToSends(boolean b) {
        return createQuery("SELECT e FROM EmailToSend e WHERE e.sent = :sent", EmailToSend.class)
                .setParameter("sent", b)
                .getResultList();
    }

}
