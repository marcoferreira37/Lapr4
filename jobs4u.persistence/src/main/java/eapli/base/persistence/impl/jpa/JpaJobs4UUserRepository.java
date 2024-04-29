package eapli.base.persistence.impl.jpa;

import eapli.base.domain.Jobs4UUser;
import eapli.base.domain.UserState;
import eapli.base.clientusermanagement.repositories.Ijobs4UUserRepository;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

public class JpaJobs4UUserRepository extends BasepaRepositoryBase<Jobs4UUser, Long, Long>
        implements Ijobs4UUserRepository {

    public JpaJobs4UUserRepository() {
        super("id");
    }

    @Override
    public Optional<Jobs4UUser> findByEmail(String email) {
        // TypedQuery in JPQL that returns the user with the given username
        final TypedQuery<Jobs4UUser> query = entityManager().createQuery(
                "SELECT u FROM Jobs4UUser u WHERE u.email = :email AND u.userState = :userState",
                Jobs4UUser.class);
        query.setParameter("email", email);
        query.setParameter("userState", UserState.ENABLED);
        try {
            return Optional.ofNullable(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }


    @Override
    public Iterable<Jobs4UUser> findAllEnabledUsers() {
        // TypedQuery in JPQL that returns all enabled users
        final TypedQuery<Jobs4UUser> query = entityManager().createQuery(
                "SELECT u FROM Jobs4UUser u WHERE u.userState = :userState",
                Jobs4UUser.class);
        query.setParameter("userState", UserState.ENABLED);

        return query.getResultList();
    }

    @Override
    public Iterable<Jobs4UUser> findAllDisabledUsers() {
        // TypedQuery in JPQL that returns all disabled users
        final TypedQuery<Jobs4UUser> query = entityManager().createQuery(
                "SELECT u FROM Jobs4UUser u WHERE u.userState = :userState",
                Jobs4UUser.class);
        query.setParameter("userState", UserState.DISABLED);

        return query.getResultList();
    }


}
