/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.usermanagement.application;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import eapli.base.customer.Customer;
import eapli.base.customer.CustomerManagementService;
import eapli.base.customer.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.CurrentTimeCalendars;
import eapli.framework.validations.Preconditions;

/**
 * Created by nuno on 21/03/16.
 */
@UseCaseController
public class AddCustomerController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UserManagementService userSvc = AuthzRegistry.userService();

    private final CustomerManagementService customerSvc = new CustomerManagementService(PersistenceContext.repositories().customer(), new BasePasswordPolicy(), new PlainTextEncoder());

    /**
     * Get existing RoleTypes available to the user.
     *
     * @return a list of RoleTypes
     */
    public Role[] getRoleTypes() {
        return BaseRoles.nonUserValues();
    }

    public Customer addCustomer(final String username,
                                final String firstName,
                                final String lastName,
                                final String email
            , final Calendar createdOn) {

        Set<Role> role = new HashSet<>();
        role.add(BaseRoles.CUSTOMER);
        final SystemUser newUser = createSystemUser(firstName, lastName, email, role, createdOn);

        return customerSvc.registerNewCustomer(newUser, EmailAddress.valueOf(email));
    }

    private SystemUser createSystemUser(final String firstName, final String lastName, final String email, final Set<Role> roles, final Calendar createdOn) {
        Preconditions.nonNull(firstName);
        Preconditions.nonNull(lastName);
        Preconditions.nonNull(email);


        roles.add(BaseRoles.CUSTOMER);
        String password = "Password1";

        return userSvc.registerNewUser(email, password, firstName, lastName, email, roles, createdOn);
    }
}
