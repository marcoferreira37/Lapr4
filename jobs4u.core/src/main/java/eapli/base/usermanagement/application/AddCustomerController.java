package eapli.base.usermanagement.application;

import eapli.base.customer.Customer;
import eapli.base.customer.CustomerManagementService;
import eapli.base.domain.Password;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Add customer controller.
 */
@UseCaseController
public class AddCustomerController {

    private final UserManagementService userSvc = AuthzRegistry.userService();

    private final CustomerManagementService customerSvc = new CustomerManagementService(PersistenceContext.repositories().customer(), new BasePasswordPolicy(), new PlainTextEncoder());

    /**
     * Add customer.
     *
     * @param username  the username
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     * @param createdOn the created on
     * @param password  the password
     * @return the customer
     */
    public Customer addCustomer(final String username,
                                final String firstName,
                                final String lastName,
                                final String email,
                                final Calendar createdOn,
                                final Password password) {

        Set<Role> role = new HashSet<>();
        role.add(BaseRoles.CUSTOMER);

        final SystemUser newUser = createSystemUser(username,firstName, lastName, email, role, createdOn, password);

        return customerSvc.registerNewCustomer(newUser, EmailAddress.valueOf(email));
    }

    private SystemUser createSystemUser(final String username,
                                        final String firstName,
                                        final String lastName,
                                        final String email,
                                        final Set<Role> roles,
                                        final Calendar createdOn,
                                        final Password password) {

        Preconditions.nonNull(username);
        Preconditions.nonNull(firstName);
        Preconditions.nonNull(lastName);
        Preconditions.nonNull(email);
//        Password.encodedAndValid(String.valueOf(password),
//                                 new BasePasswordPolicy(),
//                                 new PlainTextEncoder()).orElseThrow(IllegalArgumentException::new);


        roles.add(BaseRoles.CUSTOMER);
//        String password = "Password1";
        return userSvc.registerNewUser(username, String.valueOf(password), firstName, lastName, email, roles, createdOn);
    }
}
