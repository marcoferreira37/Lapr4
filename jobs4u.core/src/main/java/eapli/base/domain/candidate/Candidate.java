package eapli.base.domain.candidate;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;

@Entity
@Table  (name = "CANDIDATE")
public class Candidate implements AggregateRoot<EmailAddress> {
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private SystemUser systemUser;
    @EmbeddedId
    private EmailAddress emailAddress;
    private TelephoneNumber telephoneNumber;


    public Candidate(final SystemUser systemUser, final EmailAddress emailAddress, final TelephoneNumber telephoneNumber){
        Preconditions.nonNull(systemUser, "systemUser cannot be null");
        Preconditions.nonNull(telephoneNumber, "telephoneNumber cannot be null");

        this.systemUser = systemUser;
        this.emailAddress = emailAddress;
        this.telephoneNumber = telephoneNumber;
    }

    protected Candidate() {
        // for ORM
    }
    public SystemUser user() {
        return this.systemUser;
    }
    public TelephoneNumber telephoneNumber() {
        return this.telephoneNumber;
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