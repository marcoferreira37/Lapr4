package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.Jobs4UUser;
import eapli.base.clientusermanagement.repositories.Ijobs4UUserRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;


public class DisableUserController {

    private final UserRepository userRepository;

    /**
     * Instantiates a controller for disabling a user.
     * Receives the user repository as parameter. (DI)
     *
     * @param userRepository the user repository
     */
    public DisableUserController(UserRepository userRepository) {
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
    @Transactional
    public boolean disableUser(String email) {
      for (SystemUser user : userRepository.findAll()){
          if (user.email().toString().equals(email)) {
              user.deactivate(Calendar.getInstance());
              userRepository.save(user);
              return true;
          }
      }
      return false;
    }
}
