package eapli.base.usermanagement.application.controllers;

import eapli.base.customer.Customer;
import eapli.base.customer.CustomerManagementService;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type List customer controller.
 *
 * @author losa
 */
@UseCaseController
public class ListCustomerController {


    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CustomerManagementService customerSvc = new CustomerManagementService(PersistenceContext.repositories().customer(), new BasePasswordPolicy(), new PlainTextEncoder());

    /**
     * All customer iterable.
     *
     * @return the iterable
     */
    public Iterable<Customer> allCustomer() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);

        return customerSvc.allCustomer();
    }

    /**
     * Find optional.
     *
     * @param u the u
     * @return the optional
     */
    public Optional<Customer> find(final EmailAddress u) {
        return customerSvc.userOfIdentity(u);
    }

    /**
     * Enabled users iterable.
     *
     * @return the iterable
     */
    public Iterable<Customer> enabledUsers() {
        List<Customer> enabledUsers = new ArrayList<>();
        for (Customer user : allCustomer()) {
            if (user.isActive()) {
                enabledUsers.add(user);
            }
        }
        return enabledUsers;
    }

    /**
     * Disabled users iterable.
     *
     * @return the iterable
     */
    public Iterable<Customer> disabledUsers() {
        List<Customer> disabledUsers = new ArrayList<>();
        for (Customer user : allCustomer()) {
            if (!user.isActive()) {
                disabledUsers.add(user);
            }
        }
        return disabledUsers;
    }

}
