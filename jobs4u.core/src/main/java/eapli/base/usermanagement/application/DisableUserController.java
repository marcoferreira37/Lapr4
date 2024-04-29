package eapli.base.usermanagement.application;

import eapli.base.domain.Jobs4UUser;
import eapli.base.clientusermanagement.repositories.Ijobs4UUserRepository;


public class DisableUserController {

    private final Ijobs4UUserRepository userRepository;

    /**
     * Instantiates a controller for disabling a user.
     * Receives the user repository as parameter. (DI)
     *
     * @param userRepository the user repository
     */
    public DisableUserController(Ijobs4UUserRepository userRepository) {
        if (userRepository == null) {
            throw new IllegalArgumentException("User repository must be provided.");
        }
        this.userRepository = userRepository;
    }

    /**
     * Disable user
     *
     * @param email the email of the user to disable
     * @throws IllegalArgumentException if the user is not found
     */
    public void disableUser(String email) {
        Jobs4UUser userToDisable = userRepository.findByEmail(email).orElseThrow(() ->
                new IllegalArgumentException("User not found!"));
        userToDisable.disable();
        userRepository.save(userToDisable);
    }
}
