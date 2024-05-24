package eapli.base.usermanagement.application.controllers;

import eapli.base.customer.Customer;
import eapli.base.domain.Password;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.services.CustomerManagementService;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AddCustomerControllerTest {

    @InjectMocks
    private AddCustomerController addCustomerController;

    @Mock
    private UserManagementService userSvc;

    @Mock
    private CustomerManagementService customerSvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customerSvc = new CustomerManagementService(PersistenceContext.repositories().customer(), new BasePasswordPolicy(), new PlainTextEncoder());
        addCustomerController = new AddCustomerController();
    }

    @Test
    void testAddCustomer() {
        String username = "testuser";
        String firstName = "John";
        String lastName = "Doe";
        String email = "john.doe@example.com";
        Calendar createdOn = Calendar.getInstance();
        Password password = new Password("Password123!");

        Set<Role> role = new HashSet<>();
        role.add(BaseRoles.CUSTOMER);


        Customer result = addCustomerController.addCustomer(username, firstName, lastName, email, createdOn, password);
        assertNotNull(result);
    }

    @Test
    void testCheckUsername() {
        String validUsername = "validUsername";
        String invalidUsername = "";

        assertTrue(addCustomerController.checkUsername(validUsername));
        assertFalse(addCustomerController.checkUsername(invalidUsername));
    }

    @Test
    void testCheckName() {
        String validName = "John";
        String invalidName = "";

        assertTrue(addCustomerController.checkName(validName));
        assertFalse(addCustomerController.checkName(invalidName));
    }

    @Test
    void testCheckEmail() {
        String validEmail = "john.doe@example.com";
        String invalidEmail = "john.doe@example";

        assertTrue(addCustomerController.checkEmail(validEmail));
        assertFalse(addCustomerController.checkEmail(invalidEmail));
    }
}

