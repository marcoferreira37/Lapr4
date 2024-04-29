package eapli.base.usermanagement.application.register;

import eapli.base.clientusermanagement.domain.Jobs4URoles;
import eapli.base.clientusermanagement.domain.Jobs4UUser;
import eapli.base.clientusermanagement.domain.jobs4uuserbuilders.OperatorBuilder;
import eapli.base.clientusermanagement.repositories.Ijobs4UUserRepository;
import eapli.base.usermanagement.application.CreateSystemUserController;

import eapli.base.clientusermanagement.domain.jobs4uuserbuilders.Ijobs4UUserBuilderFactory;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Set;

public class RegisterOperatorController {

    private final CreateSystemUserController createSystemUserController = new CreateSystemUserController();
    private final Ijobs4UUserBuilderFactory userRepository;
    private final Ijobs4UUserBuilderFactory userBuilderFactory;

    public RegisterOperatorController(Ijobs4UUserRepository userRepository,
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
     * @return the operator
     */
    public Jobs4UUser registerOperator(String username, String pwd, String firstName, String lastName, String email) {
        // Create a system user
        Set<Role> roles = Set.of(Jobs4URoles.OPERATOR);
        SystemUser systemUser;
        try {
            systemUser = createSystemUserController.addUser(username, pwd, firstName, lastName, email, roles);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        // Create a builder for the operator
        OperatorBuilder builder = userBuilderFactory.createOperatorBuilder();

        // Build the operator
        builder.withSystemUser(systemUser);
        Jobs4UUser operator = builder.build();

        // Save the operator
        return (Jobs4UUser) userRepository;
    }


}
