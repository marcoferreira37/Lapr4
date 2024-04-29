package eapli.base.clientusermanagement.repositories;

import eapli.base.clientusermanagement.domain.Jobs4UUser;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface Ijobs4UUserRepository extends DomainRepository<Long, Jobs4UUser> {

    /**
     * Find user by email.
     *
     * @param email the email
     * @return the optional
     */
    Optional<Jobs4UUser> findByEmail(String email);


    /**
     * Returns all users that are enabled.
     *
     * @return the iterable of users
     */
    Iterable<Jobs4UUser> findAllEnabledUsers();

    /**
     * Returns all users that are disabled.
     *
     * @return the iterable of users
     */
    Iterable<Jobs4UUser> findAllDisabledUsers();

    /**
     * Returns all the teachers in the system.
     *
     * @return the iterable
     */
}
