package eapli.base.candidate;

import eapli.base.domain.candidate.Candidate;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.validations.Preconditions;
import org.apache.logging.log4j.LogManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SystemCandidateBuilder implements DomainFactory<Candidate> {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(SystemCandidateBuilder.class);

    private Username username;
    private Password password;
    private Name name;
    private EmailAddress email;
    private Calendar createdOn;
    private final BaseRoles roles;

    private SystemUser systemUser;


    private final PasswordPolicy policy;
    private final PasswordEncoder encoder;

    public SystemCandidateBuilder() {
        policy = null;
        encoder = null;
        roles = new BaseRoles();
    }


    public SystemCandidateBuilder(final PasswordPolicy policy, final PasswordEncoder encoder) {
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
    public SystemCandidateBuilder with(final String userName, final String password,
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
    public SystemCandidateBuilder with(final Username username, final Password password, final Name name,
                                      final EmailAddress email) {
        withUsername(username);
        withPassword(password);
        withName(name);
        withEmail(email);
        return this;
    }

    public SystemCandidateBuilder withUsername(final String username) {
        this.username = Username.valueOf(username);
        return this;
    }

    public SystemCandidateBuilder withUsername(final Username username) {
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
    public SystemCandidateBuilder withPassword(final String rawPassword) {
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
    public SystemCandidateBuilder withPassword(final Password password) {
        Preconditions.nonNull(password);
        this.password = password;
        return this;
    }

    public SystemCandidateBuilder withName(final String firstName, final String lastName) {
        name = Name.valueOf(firstName, lastName);
        return this;
    }

    public SystemCandidateBuilder withName(final Name name) {
        this.name = name;
        return this;
    }

    public SystemCandidateBuilder withEmail(final String email) {
        this.email = EmailAddress.valueOf(email);
        return this;
    }

    public SystemCandidateBuilder withEmail(final EmailAddress email) {
        this.email = email;
        return this;
    }

    public SystemCandidateBuilder withRoles(Role role) {
        roles.add(new RoleAssignment(role));
        return this;
    }

    public SystemCandidateBuilder withRole(final RoleAssignment role) {
        roles.add(role);
        return this;
    }

    public SystemCandidateBuilder createdOn(final Calendar createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public SystemCandidateBuilder withRoles(final Set<Role> someRoles) {
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

    public SystemCandidateBuilder withRoles(final BaseRoles roles) {
        this.roles.addAll(roles);
        return this;
    }
    public SystemCandidateBuilder withUser(final SystemUser systemUser){
        this.systemUser = systemUser;
        return this;
    }

    @Override
    public Candidate build() {
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
        return new Candidate(this.systemUser, this.email);
    }

}
