/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.customer;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.validations.Preconditions;
import eapli.framework.infrastructure.authz.domain.model.Role;
/**
 * A factory for User entities. It helps construct the object and enforces the
 * password policies and encoding.
 *
 * <p>
 * This class demonstrates the use of the factory (DDD) pattern using a fluent
 * interface; it acts as a Builder (GoF). For a class such as {@link SystemUser} there is not really
 * a need for a builder
 * and a simple factory or even the constructor would suffice.
 */
public class SystemCustomerBuilder implements DomainFactory<Customer> {

    private static final Logger LOGGER = LogManager.getLogger(SystemCustomerBuilder.class);

    private Username username;
    private Password password;
    private Name name;
    private EmailAddress email;
    private Calendar createdOn;
    private final BaseRoles roles;

    private SystemUser systemUser;


    private final PasswordPolicy policy;
    private final PasswordEncoder encoder;

    public SystemCustomerBuilder() {
        policy = null;
        encoder = null;
        roles = new BaseRoles();
    }


    public SystemCustomerBuilder(final PasswordPolicy policy, final PasswordEncoder encoder) {
        this.policy = policy;
        this.encoder = encoder;
        roles = new BaseRoles();
    }

    /**
     * Helper for the most common and mandatory properties of a SystemUser
     *
     * @param userName
     * @param password
     * @param firstName
     * @param lastName
     * @param email
     * @return this builder
     */
    public SystemCustomerBuilder with(final String userName, final String password,
                                  final String firstName,
                                  final String lastName, final String email) {
        withUsername(userName);
        withPassword(password);
        withName(firstName, lastName);
        withEmail(email);
        return this;
    }

    /**
     * Helper for the most common and mandatory properties of a SystemUser. Note
     * that {@code password} is assumed to be already validated and encoded.
     *
     * @param username
     * @param password
     * @param name
     * @param email
     * @return this builder
     */
    public SystemCustomerBuilder with(final Username username, final Password password, final Name name,
                                  final EmailAddress email) {
        withUsername(username);
        withPassword(password);
        withName(name);
        withEmail(email);
        return this;
    }

    public SystemCustomerBuilder withUsername(final String username) {
        this.username = Username.valueOf(username);
        return this;
    }

    public SystemCustomerBuilder withUsername(final Username username) {
        this.username = username;
        return this;
    }

    /**
     * Sets the password of the user <strong>performing</strong> policy
     * enforcement and encoding. If the password does not meet the requirements
     * of the policy, an {@code IllegalArgumentException} is thrown.
     *
     * @param rawPassword
     * @throws IllegalArgumentException
     * @return this builder
     */
    public SystemCustomerBuilder withPassword(final String rawPassword) {
        password = Password.encodedAndValid(rawPassword, policy, encoder)
                .orElseThrow(IllegalArgumentException::new);
        return this;
    }

    /**
     * Sets the password of the user. This method is mostly to be used to
     * support the registration process where a password has already been
     * validated and encoded.
     *
     * @param password
     * @return this builder
     */
    public SystemCustomerBuilder withPassword(final Password password) {
        Preconditions.nonNull(password);
        this.password = password;
        return this;
    }

   public SystemCustomerBuilder withName(final String firstName, final String lastName) {
        name = Name.valueOf(firstName, lastName);
        return this;
}

    public SystemCustomerBuilder withName(final Name name) {
        this.name = name;
        return this;
    }

    public SystemCustomerBuilder withEmail(final String email) {
        this.email = EmailAddress.valueOf(email);
        return this;
    }

    public SystemCustomerBuilder withEmail(final EmailAddress email) {
        this.email = email;
        return this;
    }

    public SystemCustomerBuilder withRoles(Role role) {
            roles.add(new RoleAssignment(role));
        return this;
    }

    public SystemCustomerBuilder withRole(final RoleAssignment role) {
        roles.add(role);
        return this;
    }

    public SystemCustomerBuilder createdOn(final Calendar createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public SystemCustomerBuilder withRoles(final Set<Role> someRoles) {
        List<RoleAssignment> theRoles;
        if (createdOn == null) {
            theRoles = someRoles.stream().map(RoleAssignment::new).collect(Collectors.toList());
        } else {
            theRoles = someRoles.stream().map(rt -> new RoleAssignment(rt, createdOn))
                    .collect(Collectors.toList());
        }
        roles.addAll(theRoles);
        return this;
    }

    public SystemCustomerBuilder withRoles(final BaseRoles roles) {
        this.roles.addAll(roles);
        return this;
    }
    public SystemCustomerBuilder withUser(final SystemUser systemUser){
        this.systemUser = systemUser;
        return this;
    }

    @Override
    public Customer build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructorustomer;
//        if (createdOn != null) {
//            customer = new Customer(username, password, name, email,  roles, createdOn);
//        } else {
//            customer = new Customer(username, password, name, email, roles);
//        }
//        if (LOGGER.isDebugEnabled()) {
//            final String roleLog = roles.roleTypes().toString();
//            LOGGER.debug("Creating new user [{}] {} ({} {}) with roles {}", customer, username, name,
//                    email, roleLog);
//        }
        return new Customer(this.systemUser, this.email);
    }

}
