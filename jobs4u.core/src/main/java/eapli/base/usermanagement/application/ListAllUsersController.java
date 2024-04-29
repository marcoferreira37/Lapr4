package eapli.base.usermanagement.application;

import eapli.base.clientusermanagement.domain.Jobs4URoles;
import eapli.base.clientusermanagement.domain.Jobs4UUser;
import eapli.base.clientusermanagement.repositories.Ijobs4UUserRepository;

import java.util.List;

public class ListAllUsersController {


    private final Ijobs4UUserRepository userRepository;

    private final UserSessionService userSessionService;

    /**
     * Instantiates a controller for the listing users functionality.
     * Receives the user repository as parameter. (DI)
     *
     * @param userRepository the user repository
     */
    public ListAllUsersController(Ijobs4UUserRepository userRepository) {
        if ( userRepository == null ) {
            throw new IllegalArgumentException("User repository must be provided.");
        }
        this.userRepository = userRepository;
        this.userSessionService = new UserSessionService(userRepository);
    }

    /**
     * Returns all users.
     *
     * @return the iterable
     */
    public Iterable<Jobs4UUser> allUsers() {
        return userRepository.findAll();
    }

    /**
     * Returns all users that are enabled.
     *
     * @return the iterable
     */
    public Iterable<Jobs4UUser> enabledUsers() {
        List<Jobs4UUser> users = (List<Jobs4UUser>) userRepository.findAllEnabledUsers();
        // Remove the logged user from the list
        users.remove(userSessionService.getLoggedUser());

        return users;
    }

    /**
     * Returns all users that are disabled.
     *
     * @return the iterable
     */
    public Iterable<Jobs4UUser> disabledUsers() {
        return userRepository.findAllDisabledUsers();
    }


}
