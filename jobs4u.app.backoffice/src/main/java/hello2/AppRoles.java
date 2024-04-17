package hello2;

import eapli.framework.infrastructure.authz.domain.model.Role;

public class AppRoles {



   public static final Role JOBS4U_USER = Role.valueOf("JOBS4U_USER");
    public static final Role ADMIN = Role.valueOf("ADMIN");

    public static final Role OPERATOR = Role.valueOf("OPERATOR");

    public static final Role LANGUAGEENGINEER = Role.valueOf("LANGUAGEENGINEER");

    public static final Role CUSTOMERMANAGER = Role.valueOf("CUSTOMERMANAGER");

    public static final Role CANDIDATE = Role.valueOf("CANDIDATE");

    public static final Role CUSTOMER = Role.valueOf("CUSTOMER");

    /**
     * Get available role types for cafeteria employees.
     *
     * @return employee roles
     */
    public static Role[] nonUserValues() {
        return new Role[]{ADMIN, OPERATOR, LANGUAGEENGINEER, CUSTOMERMANAGER, CANDIDATE, CUSTOMER};
    }
    /**
     * Checks if a role is one of the employee roles.
     *
     * @param role
     * @return {@code true} if a role is one of the employee roles
     */
    public boolean isCollaborator(final Role role) {
        return role != JOBS4U_USER;
    }
}
