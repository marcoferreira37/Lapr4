package eapli.base.clientusermanagement.application;

import eapli.base.clientusermanagement.domain.Jobs4URoles;
import eapli.framework.infrastructure.authz.domain.model.Role;


public class RegisterUserController
{

    /**
     * Instantiates the common controller for all the use cases related to the registration of users
     *
     */
    public RegisterUserController()
    {
    }

    /**
     * Method that returns the existing roles (only domain roles)
     *
     * @return the role array
     */
    public Role[] existingRoles()
    {
        return Jobs4URoles.existingRoles();
    }
}
