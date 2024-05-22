package eapli.base.usermanagement.application.registry;

import eapli.base.usermanagement.application.services.CustomerManagementService;
import eapli.base.repositories.CustomerRepository;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomerRegistry {

    private static CustomerManagementService customerManagementService;

    private CustomerRepository customerRepo;
    private PasswordEncoder encoder;


    public static void configure(final CustomerRepository customerRepo,
                                 final PasswordPolicy policy,
                                 final PasswordEncoder encoder) {
        customerManagementService = new CustomerManagementService(customerRepo, policy, encoder);
    }

    public static CustomerManagementService customerManagementService() {
        return customerManagementService;
    }

}
