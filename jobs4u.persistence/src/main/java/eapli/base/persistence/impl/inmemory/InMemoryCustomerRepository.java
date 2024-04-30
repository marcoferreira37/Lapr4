package eapli.base.persistence.impl.inmemory;

import eapli.base.customer.Customer;
import eapli.base.customer.CustomerRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCustomerRepository extends InMemoryDomainRepository<Customer, EmailAddress> implements CustomerRepository {

//    @Override
//    public Iterable<Customer> findByActive(boolean active) {
//        return match(e -> e.isActive() == active);
//    }
    @Override
    public Iterable<Customer> findByActive(boolean active) {
        return null;
    }
}
