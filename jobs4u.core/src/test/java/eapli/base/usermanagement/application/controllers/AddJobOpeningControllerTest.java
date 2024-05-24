package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.jobOpening.*;
import eapli.base.usermanagement.application.services.JobOpeningService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

class AddJobOpeningControllerTest {

    public static final String INVALID_DESCRIPTION_BLANK = " \t ";

    public static final String INVALID_DESCRIPTION_NUMBERS = "123";

    private final String VALID_ADDRESS = "Aveiro";

    private final String INVALID_ADDRESS = "123";

    private static final String INVALID_ADDRESS_BLANK = " \t ";

    private static final String INVALID_ADDRESS_NUMBERS = "100";


    private final String VALID_TITLEORFUNCTION = "Pedreiro";

    private final String INVALID_TITLEORFUNCTION = "834";

    private static final String INVALID_TITLEORFUNCTION_BLANK = " \t ";

    private static final String INVALID_TITLEORFUNCTION_NUMBERS = "100";


    private AddJobOpeningController testingTarget;
    private JobOpeningService mockService;

    private AuthorizationService autzService;

    private final String VALID_DESCRIPTION = "O balão do João,\n Sobe sobe sem parar! \uD83C\uDFB5";

    private final String INVALID_DESCRIPTION = "123";

    private final Mode VALID_MODE = Mode.REMOTE;

    private final ContractType VALID_CONTRACTTYPE = ContractType.FULL_TIME;

    private final String VALID_EPITAPH = "Pedreiro";


    private final Role[] VALID_ROLES = new Role[]{BaseRoles.CUSTOMER_MANAGER, BaseRoles.ADMIN, BaseRoles.POWER_USER};

    //TODO Get all invalid Roles
    private final Role[] INVALID_ROLES = new Role[]{BaseRoles.CANDIDATE, BaseRoles.OPERATOR};

    private final JobOpening DUMMY_VALID_JOB_OPENING = new JobOpening(new JobReference(10L, "dummy"));
    private final JobOpening DUMMY_INVALID_JOB_OPENING = new JobOpening(new JobReference(11L, "dummy"));


    @BeforeEach
    void setUp() {
        mockService = Mockito.mock(JobOpeningService.class);
        autzService = Mockito.mock(AuthorizationService.class);
        testingTarget = new AddJobOpeningController(mockService, autzService);
    }


    @AfterEach
    void tearDown() {
        mockService = null;
        autzService = null;
        testingTarget = null;
    }


    @Test
    void checkDescriptionValid() {
        assertFalse(testingTarget.checkDescription(VALID_DESCRIPTION), "Valid description should produce false: " + VALID_DESCRIPTION);
    }

    @Test
    void checkDescriptionInvalidNull() {
        assertTrue(testingTarget.checkDescription(null), "Invalid description should produce true: null");
    }

    @Test
    void checkDescriptionInvalidIsBlank() {
        assertTrue(testingTarget.checkDescription(INVALID_DESCRIPTION_BLANK),
                "Invalid description should produce true: " + INVALID_DESCRIPTION_BLANK);
    }

    @Test
    void checkDescriptionInvalidNumbers() {
        assertTrue(testingTarget.checkDescription(INVALID_DESCRIPTION_NUMBERS),
                "Invalid description should produce true: " + INVALID_DESCRIPTION_NUMBERS);
    }


    @Test
    void checkAddressValid() {
        assertFalse(testingTarget.checkAddress(VALID_ADDRESS), "Valid address should produce false: " + VALID_ADDRESS);
    }

    @Test
    void checkAddressInvalidNull() {
        assertTrue(testingTarget.checkAddress(null), "Invalid address should produce true: null");
    }

    @Test
    void checkAddressInvalidIsBlank() {
        assertTrue(testingTarget.checkAddress(INVALID_ADDRESS_BLANK),
                "Invalid address should produce true: " + INVALID_ADDRESS_BLANK);
    }

    @Test
    void checkAddressInvalidNumbers() {
        assertTrue(testingTarget.checkAddress(INVALID_ADDRESS_NUMBERS),
                "Invalid address should produce true: " + INVALID_ADDRESS_NUMBERS);
    }


    @Test
    void checkTitleOrFunctionValid() {
        assertFalse(testingTarget.checkTittleOrFunction(VALID_TITLEORFUNCTION), "Valid title or function should produce false: " + VALID_TITLEORFUNCTION);
    }

    @Test
    void checkTitleOrFunctionInvalidNull() {
        assertTrue(testingTarget.checkTittleOrFunction(null), "Invalid title or function should produce true: null");
    }

    @Test
    void checkTitleOrFunctionInvalidIsBlank() {
        assertTrue(testingTarget.checkTittleOrFunction(INVALID_TITLEORFUNCTION),
                "Invalid title or function should produce true: " + INVALID_TITLEORFUNCTION);
    }

    @Test
    void checkTitleOrFunctionInvalidNumbers() {
        assertTrue(testingTarget.checkTittleOrFunction(INVALID_TITLEORFUNCTION),
                "Invalid title or function should produce true: " + INVALID_TITLEORFUNCTION);
    }


    @Test
    void addValidJobOpeningTest() {
        Mockito.doNothing().when(autzService).ensureAuthenticatedUserHasAnyOf(VALID_ROLES);
        Mockito.when(mockService.create(VALID_DESCRIPTION, VALID_ADDRESS, VALID_MODE, VALID_CONTRACTTYPE, VALID_EPITAPH, 13, 2)).thenReturn(DUMMY_VALID_JOB_OPENING);


        assertEquals(DUMMY_VALID_JOB_OPENING,
                testingTarget.addJobOpening(VALID_DESCRIPTION, VALID_ADDRESS, VALID_MODE, VALID_CONTRACTTYPE, VALID_EPITAPH, 13, 2),
                "AddJobOpeningController.addJobOpening should not fail when passed with valid parameters");
    }


    @Test
    void addInValidJobOpeningTest() {
        Mockito.doNothing().when(autzService).ensureAuthenticatedUserHasAnyOf(VALID_ROLES);
        Mockito.when(mockService.create(INVALID_DESCRIPTION, INVALID_ADDRESS, VALID_MODE, VALID_CONTRACTTYPE, VALID_EPITAPH, 13, 2)).thenReturn(DUMMY_VALID_JOB_OPENING);
        assertNotEquals(DUMMY_VALID_JOB_OPENING,
                testingTarget.addJobOpening(VALID_DESCRIPTION, VALID_ADDRESS, VALID_MODE, VALID_CONTRACTTYPE, VALID_EPITAPH, 13, 2),
                "AddJobOpeningController.addJobOpening should fail when passed with invalid parameters");
    }

}