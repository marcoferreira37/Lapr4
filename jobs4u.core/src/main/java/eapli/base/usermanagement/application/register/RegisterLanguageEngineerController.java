package eapli.base.usermanagement.application.register;

import eapli.base.domain.Jobs4URoles;
import eapli.base.domain.Jobs4UUser;
import eapli.base.domain.jobs4uuserbuilders.Ijobs4UUserBuilderFactory;
import eapli.base.domain.jobs4uuserbuilders.LanguageEngineerBuilder;
import eapli.base.clientusermanagement.repositories.Ijobs4UUserRepository;
import eapli.base.usermanagement.application.CreateSystemUserController;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Set;

public class RegisterLanguageEngineerController {


    private final CreateSystemUserController createSystemUserController = new CreateSystemUserController();
    private final Ijobs4UUserBuilderFactory userRepository;
    private final Ijobs4UUserBuilderFactory userBuilderFactory;

    public RegisterLanguageEngineerController(Ijobs4UUserRepository userRepository,
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
    public Jobs4UUser registerLanguageEngineer(String username, String pwd, String firstName, String lastName, String email) {
        // Create a system user
        Set<Role> roles = Set.of(Jobs4URoles.LANGUAGE_ENGINEER);
        SystemUser systemUser;
        try {
            systemUser = createSystemUserController.addUser(username, pwd, firstName, lastName, email, roles);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        // Create a builder for the LanguageEngineer
        LanguageEngineerBuilder builder = userBuilderFactory.createLanguageEngineerBuilder();

        // Build the LanguageEngineer
        builder.withSystemUser(systemUser);
        Jobs4UUser engineer = builder.build();

        // Save the LanguageEngineer
        return (Jobs4UUser) userRepository;
    }



}
