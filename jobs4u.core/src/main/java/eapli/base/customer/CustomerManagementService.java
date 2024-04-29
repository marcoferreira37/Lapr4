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

import java.util.Calendar;
import java.util.Optional;
import java.util.Set;

import eapli.base.customer.CustomerRepository;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Name;
import eapli.framework.infrastructure.authz.domain.model.Password;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.time.util.CurrentTimeCalendars;

/**
 * User Management Service. Provides the typical application use cases for
 * managing {@link SystemUser}, e.g., adding, deactivating, listing, searching.
 *
 * @author Paulo Gandra de Sousa
 */
@Component
public class CustomerManagementService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder encoder;
    private final PasswordPolicy policy;

    /**
     * @param customerRepo
     * @param encoder
     * @param policy
     */
    @Autowired
    public CustomerManagementService(final CustomerRepository customerRepo, final PasswordPolicy policy,
                                 final PasswordEncoder encoder) {
        customerRepository = customerRepo;
        this.policy = policy;
        this.encoder = encoder;
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
     * @param roles
     * @param createdOn
     *
     * @return the new user
     */
    @Transactional
    public SystemUser registerNewUser(final String username, final String rawPassword, final String firstName,
                                      final String lastName, final String email, final Set<Role> roles, final Calendar createdOn) {
        final var userBuilder = new SystemUserBuilder(policy, encoder);
        userBuilder.with(username, rawPassword, firstName, lastName, email).createdOn(createdOn).withRoles(roles);
        final var newUser = userBuilder.build();
        return customerRepository.save(newUser);
    }

    /**
     * Registers a new user in the system.
     *
     * @param username
     * @param rawPassword
     * @param firstName
     * @param lastName
     * @param email
     * @param roles
     *
     * @return the new user
     */
    @Transactional
    public SystemUser registerNewUser(final String username, final String rawPassword, final String firstName,
                                      final String lastName, final String email, final Set<Role> roles) {
        return registerNewUser(username, rawPassword, firstName, lastName, email, roles, CurrentTimeCalendars.now());
    }

    /**
     * Registers a new user in the system. Mostly useful for two-step
     * signup/registration process where the domain objects were already created by
     * another process, e.g., signup.
     *
     * @param username
     * @param password
     * @param name
     * @param email
     * @param roles
     *
     * @return the enw user
     */
    @Transactional
    public SystemUser registerUser(final Username username, final Password password, final Name name,
                                   final EmailAddress email, final Set<Role> roles) {
        final var userBuilder = new SystemUserBuilder(policy, encoder);
        userBuilder.with(username, password, name, email).withRoles(roles);
        final var newUser = userBuilder.build();
        return customerRepository.save(newUser);
    }

    /**
     * @return all active users
     */
    public Iterable<SystemUser> activeUsers() {
        return customerRepository.findByActive(true);
    }

    /**
     * @return all deactivated users
     */
    public Iterable<SystemUser> deactivatedUsers() {
        return customerRepository.findByActive(false);
    }

    /**
     * @return all users no matter their status
     */
    public Iterable<SystemUser> allCustomers() {
        return customerRepository.findAll();
    }

    /**
     * Looks up a user by its username.
     *
     * @param id
     *
     * @return an Optional which value is the user with the desired identify. an
     *         empty Optional if there is no user with that username
     */
    public Optional<SystemUser> userOfIdentity(final Username id) {
        return customerRepository.ofIdentity(id);
    }

    /**
     * Deactivates a user. Client code must not reference the input parameter after
     * calling this method and must use the returned object instead.
     * <p>
     * If the user is currently deactivated, an {@link IllegalStateException} exception is thrown.
     *
     * @param user
     *
     * @return the updated user.
     *
     * @throws IllegalStateException
     */
    @Transactional
    public SystemUser deactivateUser(final SystemUser user) {
        user.deactivate(CurrentTimeCalendars.now());
        return customerRepository.save(user);
    }

    /**
     * Activates a user. Client code must not reference the input parameter after
     * calling this method and must use the returned object instead.
     * <p>
     * If the user is currently activate, nothing happens.
     *
     * @param user
     *
     * @return the updated user.
     */
    @Transactional
    public SystemUser activateUser(final SystemUser user) {
        user.activate();
        return customerRepository.save(user);
    }
}
