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

public class Customer extends SystemUser implements AggregateRoot<Username>, DTOable<GeneralDTO>, Visitable<GeneralDTO>, Serializable {
    @OneToOne
    @JoinColumn(name = "Email")
    private SystemUser systemUser;

    private static final long serialVersionUID = 1L;

    @Version
    private Long version;

    @EmbeddedId
    private Username username;

    private Password password;

    private Name name;

    private EmailAddress email;

    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    private BaseRoles role;

    @Temporal(TemporalType.DATE)
    private Calendar createdOn;

    private boolean active;

    @Temporal(TemporalType.DATE)
    private Calendar deactivatedOn;

    // the password reset token
    private String resetToken;

    /**
     * Convenience constructor for today's date of creation
     *
     * @param username
     * @param password
     * @param name
     * @param email
     * @param role
     */
    /* package */ Customer(final Username username, final Password password, final Name name,
                             final EmailAddress email, final BaseRoles role) {
        this(username, password, name, email, role , CurrentTimeCalendars.now());
    }

    /**
     * @param username
     * @param password
     * @param name
     * @param email
     * @param roles
     * @param createdOn
     */
//    /* package */ Customer(final Username username, final Password password, final Name name,
//                           final EmailAddress email, final Set<Role> roles, final Calendar createdOn) {
//        Preconditions.nonNull(roles, "roles cannot be null");
//
//        final BaseRoles roleset = new BaseRoles();
//        roleset.addAll(roles.stream().map(rt -> new RoleAssignment(rt)).collect(Collectors.toList()));
//        init(username, password, name, email, roleset, createdOn);
//    }

    public Customer(Username username, Password password, Name name, EmailAddress email, BaseRoles roles, Calendar createdOn)
    {
        Preconditions.nonNull(roles, "roles cannot be null");

        final BaseRoles roleset = new BaseRoles();
        roleset.addAll(roles.stream().map(rt -> new RoleAssignment(rt.type())).collect(Collectors.toList()));
        init(username, password, name, email, roleset, createdOn);
    }

//    /**
//     * @param username
//     * @param password
//     * @param name
//     * @param email
//     * @param role
//     */
//    /* package */ Customer(final Username username, final Password password, final Name name,
//                             final EmailAddress email, final BaseRoles role) {
//        this(username, password, name, email, role, CurrentTimeCalendars.now());
//    }

    /**
     * @param username
     * @param password
     * @param name
     * @param email
     * @param role
     * @param createdOn
     */
//    /* package */ Customer(final Username username, final Password password, final Name name,
//                             final EmailAddress email, final RoleSet roles, final Calendar createdOn) {
//        init(username, password, name, email, roles, createdOn);
//    }

    private void init(final Username username, final Password password, final Name name, final EmailAddress email,
                      final BaseRoles role, final Calendar createdOn) {
        Preconditions.noneNull(role, username, password, name, email, createdOn);

        this.createdOn = createdOn;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;

        // accounts are already active upon creation
        active = true;

        // the user has not requested to reset the password of a new accounts
        invalidateResetToken();
    }

    protected Customer() {
        // for ORM
    }

    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof Customer)) {
            return false;
        }
        //FIXME Cannot cast to Customer due to being System User. Customer does not extend system user. Find by id
        final Customer that = (Customer) other;
        if (this == that) {
            return true;
        }
        if (!username.equals(that.username) || !password.equals(that.password) || !name.equals(that.name)
                || !email.equals(that.email) || role.equals(that.role)) {
            return false;
        }
        return resetToken == null ? that.resetToken == null : resetToken.equals(that.resetToken);
    }

//    @Override
//    public int compareTo(Username other) {
//        return AggregateRoot.super.compareTo(other);
//    }

    @Override
    public Username identity() {
        return username;
    }

//    @Override
//    public boolean hasIdentity(Username id) {
//        return AggregateRoot.super.hasIdentity(id);
//    }

    /**
     * @return the user's email address
     */
    public EmailAddress email() {
        return email;
    }

    /**
     * Add role to user.
     *
     * @param role
     *            Role to assign to Customer.
     */
//    public void assignToRole(final RoleAssignment role) {
//        roles.add(role);
//    }

    /**
     * Add role to user.
     *
     * @param role
     *            Role to assign to Customer.
     */
//    public void assignToRole(final Role role) {
//        Preconditions.nonNull(role);
//        roles.add(new RoleAssignment(role));
//    }

    /**
     * Unassigns a role from user, marking the assignment as expired. The role
     * assignment is kept in the roles of the user. if the user is not assigned to
     * the role, this method does nothing.
     *
     * @param role
     *            Role to remove from Customer.
     *
     * @return true if the user had the role and it was unassigned. false otherwise.
     */
//    public boolean unassignRole(final Role role) {
//        Preconditions.nonNull(role);
//        return roles.getAssignment(role).map(RoleAssignment::unassign).orElse(false);
//    }

    /**
     * @return the user's roles
     */
//    public Collection<Role> roleTypes() {
//        return roles.roleTypes();
//    }

//    @Override
//    public GeneralDTO toDTO() {
//        final GeneralDTO ret = new GeneralDTO("user");
//        ret.put("username", username.toString());
//        // the password should not leave this object...
//        // so we never have something like ret.put("password", password.toString())
//        ret.put("name", name.toString());
//        ret.put("email", email.toString());
//        ret.put("roles", roles.roleTypes().toString());
//
//        return ret;
//    }

    /**
     * Checks if this user's password matches a password. We don't want the password
     * to move outside of the object, so instead of returning it we pass the
     * responsibility of performing the validation to inside the object.
     *
     * @param rawPassword
     * @param encoder
     *
     * @return true if the password matches
     */
//    public boolean passwordMatches(final String rawPassword, final PasswordEncoder encoder) {
//        // FIXME since we are receiving the encoder and passing to that encoder the password, we are
//        // in fact exposing it!!!!
//        return encoder.matches(rawPassword, password.value());
//    }

    /**
     * For supporting Spring Security UserDetails.
     *
     * @return the password
     */
//    /* package */String encodedPassword() {
//        return password.value();
//    }

    @Override
    public void accept(final Visitor<GeneralDTO> visitor) {
        visitor.visit(toDTO());
    }

    /**
     * @return the username
     */
    public Username username() {
        return username;
    }

    /**
     * @return the name
     */
    public Name name() {
        return name;
    }

    /**
     * @return <code>true> if the user is active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param deactivatedOn
     */
    public void deactivate(final Calendar deactivatedOn) {
        // cannot deactivate a user before it was registered in the system
        if (deactivatedOn == null || deactivatedOn.before(createdOn)) {
            throw new IllegalArgumentException();
        }
        // cannot deactivate an inactive user
        if (!active) {
            // we could simply do nothing instead of taking a harsh approach of
            // throwing an exception
            throw new IllegalStateException("Cannot deactivate an inactive user");
        }
        active = false;
        this.deactivatedOn = deactivatedOn;
        invalidateResetToken();
    }

    /**
     */
    public void activate() {
        if (isActive()) {
            return;
        }

        active = true;
        deactivatedOn = null;
        invalidateResetToken();
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean equals(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    /**
     * Sets a new password for this user.
     *
     * @param newPassword
     */
    public void changePassword(final Password newPassword) {
        password = newPassword;
        invalidateResetToken();
    }

    private void invalidateResetToken() {
        resetToken = null;
    }

    /**
     * initiates the process to reset a password by generating a validation token.
     *
     * @return the validation token to use to complete the password reset
     */
    public String resetPassword() {
        resetToken = new UUIDGenerator().newId().toString();
        return resetToken;
    }

    /**
     * resets the password of the user.
     *
     * @param token
     * @param newPass
     *
     * @return <code>true</code> if the token was valid and the password was reset.
     *         <code>false</code> otherwise
     */
    public boolean confirmResetPassword(final String token, final Password newPass) {
        Invariants.nonNull(resetToken);
        Preconditions.nonEmpty(token);
        Preconditions.nonNull(newPass);

        invalidateResetToken();
        if (token.equals(resetToken)) {
            password = newPass;
            return true;
        }
        return false;
    }

    /**
     * Checks if this user has any of a set of roles.
     *
     * @param roles
     *
     * @return true if the user has at least one of the roles
     */
//    public boolean hasAny(final Role... roles) {
//        for (final Role r : roles) {
//            if (this.roles.hasAssignment(r)) {
//                return true;
//            }
//        }
//
//        return false;
//    }

    /**
     * Checks if this user's non-expired roles comply with all of a set of roles.
     *
     * @param roles
     *
     * @return true if the user has all the roles
     */
//    public boolean hasAll(final Role... roles) {
//        for (final Role r : roles) {
//            if (!(this.roles.hasAssignment(r))) {
//                return false;
//            }
//        }
//
//        return true;
//    }

    /**
     * Returns the date this user account was created.
     *
     * @return the date this user account was created
     */
    public Calendar createdOn() {
        // returning a copy as the Calendar class is mutable and we don't want
        // to allow external access to chnage this value without us knowing it
        return (Calendar) createdOn.clone();
    }


    @Override
    public GeneralDTO toDTO() {
        return null;
    }
}
