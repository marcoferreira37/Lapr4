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

    public static boolean checkUsername(String username) {
        return !username.isEmpty();
    }

    public static boolean checkName(String firstName) {
        if (firstName.isEmpty()) {
            return false;
        }

        // Verifica se o primeiro caractere é maiúsculo
        if (!Character.isUpperCase(firstName.charAt(0))) {
            return false;
        }

        // Verifica se todos os caracteres após o primeiro são minúsculos
        for (int i = 1; i < firstName.length(); i++) {
            if (!Character.isLowerCase(firstName.charAt(i))) {
                return false;
            }
        }

        // Se chegou até aqui, o username está válido
        return true;
    }

    public static boolean checkEmail(String email) {
        if (!(email.contains("@") || email.contains(".")) || email.isEmpty())  {
            return false;
        }
        return true;
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