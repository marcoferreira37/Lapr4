package eapli.base.usermanagement.application.register;

import eapli.base.clientusermanagement.domain.Jobs4URoles;
import eapli.base.clientusermanagement.domain.Jobs4UUser;
import eapli.base.clientusermanagement.domain.jobs4uuserbuilders.CostumerManagerBuilder;
import eapli.base.clientusermanagement.domain.jobs4uuserbuilders.Ijobs4UUserBuilderFactory;
import eapli.base.clientusermanagement.repositories.Ijobs4UUserRepository;
import eapli.base.usermanagement.application.CreateSystemUserController;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Set;

public class RegisterCostumerManagerController {


    private final CreateSystemUserController createSystemUserController = new CreateSystemUserController();
    private final Ijobs4UUserBuilderFactory userRepository;
    private final Ijobs4UUserBuilderFactory userBuilderFactory;

    public RegisterCostumerManagerController(Ijobs4UUserRepository userRepository,
                                      Ijobs4UUserBuilderFactory userBuilderFactory) {
        if ( userRepository == null ) {
            throw new IllegalArgumentException("User repository must be provided.");
        }
        this.userRepository = (Ijobs4UUserBuilderFactory) userRepository;//erro
        if ( userBuilderFactory == null ) {
            throw new IllegalArgumentException("User builder factory must be provided.");
        }
        this.userBuilderFactory = userBuilderFactory;
    }

    /**
     * Registers a manager.
     *
     * @param username  the username
     * @param pwd       the pwd
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     * @return the CostumerManager
     */
    public Jobs4UUser registerCostumerManager(String username, String pwd, String firstName, String lastName, String email) {
        // Create a system user
        Set<Role> roles = Set.of(Jobs4URoles.COSTUMER_MANAGER);
        SystemUser systemUser;
        try {
            systemUser = createSystemUserController.addUser(username, pwd, firstName, lastName, email, roles);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        // Create a builder for the CostumerManager
        CostumerManagerBuilder builder = userBuilderFactory.createCostumerManagerBuilder();

        // Build the manager
        builder.withSystemUser(systemUser);
        Jobs4UUser manager = builder.build();

        // Save the manager
        return (Jobs4UUser) userRepository;//erro
    }



}
