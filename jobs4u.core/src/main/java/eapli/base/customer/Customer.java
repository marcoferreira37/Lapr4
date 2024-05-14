package eapli.base.customer;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;

@Entity
@Table  (name = "CUSTOMER")
public class Customer  implements AggregateRoot<EmailAddress> {
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private SystemUser systemUser;
    @Id
    private EmailAddress emailAddress;

    private boolean active;


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

    public boolean isActive() {
        return active;
    }
}