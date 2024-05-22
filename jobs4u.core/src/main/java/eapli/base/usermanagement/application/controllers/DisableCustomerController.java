package eapli.base.usermanagement.application.controllers;

import eapli.base.repositories.CustomerRepository;


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
