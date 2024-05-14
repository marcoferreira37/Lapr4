package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.customer.Customer;
import eapli.base.customer.CustomerRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Password;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaCustomerRepository
        extends JpaAutoTxRepository<Customer, EmailAddress, EmailAddress>
        implements CustomerRepository {

    public JpaCustomerRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "mecanographicNumber");
    }
    public JpaCustomerRepository(final TransactionalContext autoTx) {
        super(autoTx, "mecanographicNumber");
    }

    @Override
    public Iterable<Customer> findByActive(boolean active) {
        return match("e.active = :active", "active", active);
    }
}
