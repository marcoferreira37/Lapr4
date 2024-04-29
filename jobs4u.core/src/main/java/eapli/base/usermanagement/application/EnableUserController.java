package eapli.base.usermanagement.application;

import eapli.base.domain.Jobs4UUser;
import eapli.base.clientusermanagement.repositories.Ijobs4UUserRepository;


public class EnableUserController {

    private final Ijobs4UUserRepository userRepository;

    /**
     * Instantiates a controller for enabling a user.
     * Receives the user repository as parameter. (DI)
     *
     * @param userRepository the user repository
     */
    public EnableUserController(Ijobs4UUserRepository userRepository) {
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
    public void enableUser(String email) {
        Jobs4UUser userToEnable = userRepository.findByEmail(email).orElseThrow(() ->
                new IllegalArgumentException("User not found!"));
        userToEnable.enable();
        userRepository.save(userToEnable);
    }
}
