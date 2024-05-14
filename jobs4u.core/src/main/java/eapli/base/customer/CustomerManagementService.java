package eapli.base.customer;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * The type Customer management service.
 */
@Component
public class CustomerManagementService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder encoder;
    private final PasswordPolicy policy;


    /**
     * Instantiates a new Customer management service.
     *
     * @param customerRepo the customer repo
     * @param policy       the policy
     * @param encoder      the encoder
     */
    @Autowired
    public CustomerManagementService(CustomerRepository customerRepo, final PasswordPolicy policy, PasswordEncoder encoder) {
        this.customerRepository = customerRepo;
        this.encoder = encoder;
        this.policy = policy;
    }


    /**
     * Register new customer customer.
     *
     * @param newUser      the new user
     * @param emailAddress the email address
     * @return the customer
     */
    @Transactional
    public Customer registerNewCustomer(final SystemUser newUser,
                                        final EmailAddress emailAddress) {

        SystemCustomerBuilder builder = new SystemCustomerBuilder();
        builder.withUser(newUser).withEmail(emailAddress);
        Customer newCustomer = builder.build();

        return customerRepository.save(newCustomer);
    }

    /**
     * All customer iterable.
     *
     * @return the iterable
     */
    public Iterable<Customer> allCustomer() {
        return customerRepository.findAll();
    }

    /**
     * User of identity optional.
     *
     * @param id the id
     * @return the optional
     */
    public Optional<Customer> userOfIdentity(final EmailAddress id) {
        return customerRepository.ofIdentity(id);
    }


}
