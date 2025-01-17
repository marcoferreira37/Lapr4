package eapli.base.domain.candidate;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.util.Objects;

@Entity
@Table  (name = "CANDIDATE")
@Builder
@Getter
public class Candidate implements AggregateRoot<EmailAddress> {
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private SystemUser systemUser;
    @EmbeddedId
    private EmailAddress emailAddress;
    private TelephoneNumber telephoneNumber;

    @Column (name = "Curriculum")
    private String curriculum;

    public Candidate(final SystemUser systemUser, final EmailAddress emailAddress, final TelephoneNumber telephoneNumber, final String curriculum){
        Preconditions.nonNull(systemUser, "systemUser cannot be null");
        Preconditions.nonNull(telephoneNumber, "telephoneNumber cannot be null");

        this.systemUser = systemUser;
        this.emailAddress = emailAddress;
        this.telephoneNumber = telephoneNumber;
        this.curriculum=curriculum;
    }

    public Candidate() {
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
    public EmailAddress emailAddress() {
        return emailAddress;
    }

    public String curriculum() {
        return curriculum;
    }

    @Override
    public String toString() {
        return "Candidate" +
                "\n Name: " + systemUser.name() +
                "\n Email Address: " + emailAddress +
                "\n Telephone Number: " + telephoneNumber.getTelephoneNumber();
    }

    public EmailAddress getEmail() {
        return emailAddress;
    }


}