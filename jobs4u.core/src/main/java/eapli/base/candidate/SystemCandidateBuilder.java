package eapli.base.candidate;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.candidate.TelephoneNumber;
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
    private EmailAddress email;
    private TelephoneNumber telephoneNumber;
    private SystemUser systemUser;

    public SystemCandidateBuilder withTelephoneNumber(final TelephoneNumber telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
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
        return new Candidate(this.systemUser, this.email, this.telephoneNumber);
    }

}
