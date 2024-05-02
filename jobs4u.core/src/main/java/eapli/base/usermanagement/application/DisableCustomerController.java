package eapli.base.usermanagement.application;

import eapli.base.customer.CustomerRepository;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;


public class DisableCustomerController {

    private final CustomerRepository customerRepository;



    public DisableCustomerController( CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Disable user
     *
     * @param email the email of the user to disable
     * @throws IllegalArgumentException if the user is not found
     */
    public void disableUser(String email) {

    }
}
