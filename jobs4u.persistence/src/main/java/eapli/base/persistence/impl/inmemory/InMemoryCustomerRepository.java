package eapli.base.persistence.impl.inmemory;

import eapli.base.customer.Customer;
import eapli.base.customer.CustomerRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCustomerRepository extends InMemoryDomainRepository<Customer, Username> implements CustomerRepository {

    @Override
    public Iterable<Customer> findByActive(boolean active) {
        return match(e -> e.isActive() == active);
    }
}
