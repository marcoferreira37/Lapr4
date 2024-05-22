package eapli.base.customer;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.controllers.AddJobOpeningController;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class AddJobOpeningControllerTest {

    static AddJobOpeningController controller;
    @BeforeAll
    public static void beforeAll() {
        AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(), new PlainTextEncoder());
        controller = new AddJobOpeningController();

    }
    @Test
    public void testCheckDescription_NullDescription() {
        System.out.println(controller);
    }
}