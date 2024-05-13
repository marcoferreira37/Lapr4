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
 * The type System customer builder.
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

    /**
     * Instantiates a new System customer builder.
     */
    public SystemCustomerBuilder() {
        policy = null;
        encoder = null;
        roles = new BaseRoles();
    }



    /**
     * With system customer builder.
     *
     * @param userName  the user name
     * @param password  the password
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     * @return the system customer builder
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
     * With system customer builder.
     *
     * @param username the username
     * @param password the password
     * @param name     the name
     * @param email    the email
     * @return the system customer builder
     */
    public SystemCustomerBuilder with(final Username username, final Password password, final Name name,
                                  final EmailAddress email) {
        withUsername(username);
        withPassword(password);
        withName(name);
        withEmail(email);
        return this;
    }

    /**
     * With username system customer builder.
     *
     * @param username the username
     * @return the system customer builder
     */
    public SystemCustomerBuilder withUsername(final String username) {
        this.username = Username.valueOf(username);
        return this;
    }

    /**
     * With username system customer builder.
     *
     * @param username the username
     * @return the system customer builder
     */
    public SystemCustomerBuilder withUsername(final Username username) {
        this.username = username;
        return this;
    }


    /**
     * With password system customer builder.
     *
     * @param rawPassword the raw password
     * @return the system customer builder
     */
    public SystemCustomerBuilder withPassword(final String rawPassword) {
        password = Password.encodedAndValid(rawPassword, policy, encoder)
                .orElseThrow(IllegalArgumentException::new);
        return this;
    }

    /**
     * With password system customer builder.
     *
     * @param password the password
     * @return the system customer builder
     */
    public SystemCustomerBuilder withPassword(final Password password) {
        Preconditions.nonNull(password);
        this.password = password;
        return this;
    }

    /**
     * With name system customer builder.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @return the system customer builder
     */
    public SystemCustomerBuilder withName(final String firstName, final String lastName) {
        name = Name.valueOf(firstName, lastName);
        return this;
}

    /**
     * With name system customer builder.
     *
     * @param name the name
     * @return the system customer builder
     */
    public SystemCustomerBuilder withName(final Name name) {
        this.name = name;
        return this;
    }

    /**
     * With email system customer builder.
     *
     * @param email the email
     * @return the system customer builder
     */
    public SystemCustomerBuilder withEmail(final String email) {
        this.email = EmailAddress.valueOf(email);
        return this;
    }

    /**
     * With email system customer builder.
     *
     * @param email the email
     * @return the system customer builder
     */
    public SystemCustomerBuilder withEmail(final EmailAddress email) {
        this.email = email;
        return this;
    }

    /**
     * With roles system customer builder.
     *
     * @param role the role
     * @return the system customer builder
     */
    public SystemCustomerBuilder withRoles(Role role) {
            roles.add(new RoleAssignment(role));
        return this;
    }

    /**
     * With role system customer builder.
     *
     * @param role the role
     * @return the system customer builder
     */
    public SystemCustomerBuilder withRole(final RoleAssignment role) {
        roles.add(role);
        return this;
    }

    /**
     * Created on system customer builder.
     *
     * @param createdOn the created on
     * @return the system customer builder
     */
    public SystemCustomerBuilder createdOn(final Calendar createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    /**
     * With roles system customer builder.
     *
     * @param someRoles the some roles
     * @return the system customer builder
     */
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

    /**
     * With roles system customer builder.
     *
     * @param roles the roles
     * @return the system customer builder
     */
    public SystemCustomerBuilder withRoles(final BaseRoles roles) {
        this.roles.addAll(roles);
        return this;
    }

    /**
     * With user system customer builder.
     *
     * @param systemUser the system user
     * @return the system customer builder
     */
    public SystemCustomerBuilder withUser(final SystemUser systemUser){
        this.systemUser = systemUser;
        return this;
    }

    @Override
    public Customer build() {
        return new Customer(this.systemUser, this.email);
    }

}
