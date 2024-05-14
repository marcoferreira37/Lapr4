package eapli.base.usermanagement.application;

import eapli.base.domain.Jobs4UUser;
import eapli.base.clientusermanagement.repositories.Ijobs4UUserRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import org.springframework.transaction.annotation.Transactional;

public class EnableUserController {

    private final UserRepository userRepository;

    /**
     * Instantiates a controller for enabling a user.
     * Receives the user repository as parameter. (DI)
     *
     * @param userRepository the user repository
     */
    public EnableUserController(UserRepository userRepository) {
        if (userRepository == null) {
            throw new IllegalArgumentException("User repository must be provided.");
        }
        this.userRepository = userRepository;
    }

    /**
     * Enable user
     *
     * @param email the email of the user to enable
     * @throws IllegalArgumentException if the user is not found
     */

    @Transactional
    public void enableUser(String email) {
        for (SystemUser user : userRepository.findAll()){
            if (user.email().toString().equals(email)) {
                user.activate();
                userRepository.save(user);
                return;
            }
        }
        throw new IllegalArgumentException("User not found.");
    }
}
