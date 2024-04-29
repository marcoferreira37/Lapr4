package eapli.base.domain;

import eapli.framework.infrastructure.authz.domain.model.Role;

public class Jobs4URoles {

    public static final Role SUPERUSER = Role.valueOf("SUPER_USER");
    public static final Role OPERATOR = Role.valueOf("OPERATOR");
    public static final Role COSTUMER_MANAGER = Role.valueOf("COSTUMER_MANAGER");
    public static final Role LANGUAGE_ENGINEER = Role.valueOf("LANGUAGE_ENGINEER");


    /**
     * Method that returns the existing roles (only domain roles)
     *
     * @return the role array
     */
    public static Role[] existingRoles() {
        return new Role[]{OPERATOR, COSTUMER_MANAGER, LANGUAGE_ENGINEER};
    }

}
