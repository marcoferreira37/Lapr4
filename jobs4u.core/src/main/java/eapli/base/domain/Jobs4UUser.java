package eapli.base.domain;


import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jakarta.persistence.*;

import java.util.Objects;

/**
 * The type E course user.
 */
@Entity
public class Jobs4UUser implements AggregateRoot<Long> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Just because SystemUser's email has protected access
    @Column(unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private SystemUser systemUser;
    @Embedded
    UserBirthdate userBirthDate;
    @Enumerated(EnumType.STRING)
    private UserState userState;
    // Field only used by student



    /**
     * Instantiates a new Student
     *
     * @param user                     the user
     * @throws IllegalArgumentException if the user is null
     * @throws IllegalArgumentException if the user doesn't have the role of student
     * @throws IllegalArgumentException if the userTaxNumber is null
     * @throws IllegalArgumentException if the userBirthDate is null
     * @throws IllegalArgumentException if the userMechanographicNumber is null
     */
    public Jobs4UUser(final SystemUser user) {
        // Check if the systemUser is not null
        if (user == null) {
            throw new IllegalArgumentException("SystemUser can't be null");
        }
        this.systemUser = user;
        this.email = systemUser.email().toString();

        if (!user.hasAny(Jobs4URoles.OPERATOR)) {
            throw new IllegalArgumentException("SystemUser must have the role of operator");
        }

        this.userState = UserState.ENABLED;
    }

    /**
     * Returns the user's name.
     *
     * @return the username
     */
    public String name() {
        return this.systemUser.name().toString();
    }

    /**
     * Returns the user's username.
     *
     * @return the username
     */
    public String username() {
        return this.systemUser.username().toString();
    }

    /**
     * Disable user.
     *
     * @throws IllegalStateException if the user is already disabled
     */
    public void disable() {
        if (this.userState == UserState.DISABLED) {
            throw new IllegalStateException("User is already disabled");
        }
        this.userState = UserState.DISABLED;
    }

    /**
     * Enable user.
     *
     * @throws IllegalStateException if the user is already enabled
     */
    public void enable() {
        if (this.userState == UserState.ENABLED) {
            throw new IllegalStateException("User is already enabled");
        }
        this.userState = UserState.ENABLED;
    }

    /**
     * Checks if the user is enabled.
     *
     * @return true, if is enabled
     */
    public boolean isEnabled() {
        return this.userState == UserState.ENABLED;
    }

    /**
     * Tells if the user is a OPERATOR.
     *
     * @return true if the user is a OPERATOR
     */
    public boolean isOperator() {
        return this.systemUser.hasAny(Jobs4URoles.OPERATOR);
    }

    /**
     * Tells if the user is a COSTUMER_MANAGER.
     *
     * @return the true if the user is a COSTUMER_MANAGER
     */
    public boolean isCostumerManager() {
        return this.systemUser.hasAny(Jobs4URoles.COSTUMER_MANAGER);
    }

    /**
     * Returns the user's email.
     *
     * @return the email
     */
    public String email() {
        return this.email;
    }

    @Override
    public String toString() {
        if (this.systemUser.hasAny(Jobs4URoles.OPERATOR)) {
            return String.format("Student: %s | %s | %s | %s| %s | %s | %s", this.systemUser.username(),
                    this.systemUser.name(), this.userBirthDate,
                    this.systemUser.email(), this.userState);
        } else if (this.systemUser.hasAny(Jobs4URoles.COSTUMER_MANAGER)) {
            return String.format("Teacher: %s | %s | %s | %s | %s | %s | %s", this.systemUser.username(),
                    this.systemUser.name(), this.userBirthDate,
                    this.systemUser.email(), this.userState);
        } else if (this.systemUser.hasAny(Jobs4URoles.LANGUAGE_ENGINEER)) {
            return String.format("Manager: %s | %s | %s | %s", this.systemUser.username(),
                    this.systemUser.name(), this.systemUser.email(), this.userState);
        }
        return "";
    }

    protected Jobs4UUser() {
        // for ORM purposes only
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jobs4UUser user = (Jobs4UUser) o;
        return Objects.equals(email, user.email);
    }
}
