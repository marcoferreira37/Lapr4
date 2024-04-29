/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.customer;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

/**
 * User Management Service. Provides the typical application use cases for
 * managing {@link SystemUser}, e.g., adding, deactivating, listing, searching.
 *
 * @author Paulo Gandra de Sousa
 */
@Component
public class CustomerManagementService {
    private final CustomerRepository customerRepository ;
    private final PasswordEncoder encoder  ;
    private final PasswordPolicy policy ;

    private final SystemCustomerBuilder builder = new SystemCustomerBuilder();


    @Autowired
    public CustomerManagementService(CustomerRepository customerRepo, final PasswordPolicy policy, PasswordEncoder encoder) {
        this.customerRepository = customerRepo;
        this.encoder = encoder;
        this.policy = policy;
    }





    /**
     * Registers a new user in the system allowing to specify when the user account
     * was created.
     *
     * @param username
     * @param rawPassword
     * @param firstName
     * @param lastName
     * @param email
     * @param createdOn
     *
     * @return the new user
     */
    @Transactional
    public Customer registerNewCustomer(final String username,
                                          final String rawPassword,
                                          final String firstName,
                                          final String lastName,
                                          final String email,
                                          final Calendar createdOn) {
        final Customer newCustomer = builder.build();
                /*
                new SystemCustomerBuilder(policy, encoder)
                .with(username, rawPassword, firstName, lastName, email)
                .createdOn(createdOn)
                .withRoles(BaseRoles.CUSTOMER)
                .build();
                */



        return customerRepository.save(newCustomer);
    }


}
