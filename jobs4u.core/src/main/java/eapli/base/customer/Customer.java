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

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.domain.model.*;
import jakarta.persistence.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.identities.impl.UUIDGenerator;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.representations.dto.GeneralDTO;
import eapli.framework.time.util.CurrentTimeCalendars;
import eapli.framework.validations.Invariants;
import eapli.framework.validations.Preconditions;
import eapli.framework.visitor.Visitable;
import eapli.framework.visitor.Visitor;

import javax.management.relation.Role;

///**
// * An application user. Objects are constructed thru {@link CustomerBuilder}
// * to enforce password policy and encoding.
// * <p>
// * This class follows a DDD approach where User is the root entity of the User
// * Aggregate and all of its properties are instances of value objects. This
// * approach may seem a little more complex than just having String or native
// * type attributes but provides for real semantic of the domain and follows the
// * Single Responsibility Pattern (SRP).
// *
// * @author Paulo Gandra Sousa
// */
@Entity
@Table  (name = "CUSTOMER")
public class Customer  implements AggregateRoot<EmailAddress> {
    @OneToOne
    @JoinColumn(name = "EMAIL")
    private SystemUser systemUser;
    @Id
    private EmailAddress emailAddress;



    public Customer(final SystemUser systemUser, final EmailAddress emailAddress){
        Preconditions.nonNull(systemUser, "systemUser cannot be null");
        Preconditions.nonNull(emailAddress, "emailAddress cannot be null");
        this.systemUser = systemUser;
        this.emailAddress = emailAddress;
    }

    protected Customer() {
        // for ORM
    }
    public SystemUser user() {
        return this.systemUser;
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }
    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }
    @Override
    public EmailAddress identity() {
        return this.emailAddress;
    }
}