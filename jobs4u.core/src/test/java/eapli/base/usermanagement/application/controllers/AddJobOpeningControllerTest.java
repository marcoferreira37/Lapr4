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
    private static final String INVALID_VACANCIESNUMBER = "SSSS";
    private static final String INVALID_VACANCIESNUMBER_BLANK = " \t ";
    private static final String VALID_VACANCIESNUMBER = "12";
    private static final String VALID_COMPANYID = "8712";
    private static final String INVALID_COMPANYID_BLANK = " \t ";

    private final String VALID_ADDRESS = "Aveiro";

    private static final String INVALID_ADDRESS_BLANK = " \t ";

    private static final String INVALID_ADDRESS_NUMBERS = "100";


    private final String VALID_TITLEORFUNCTION = "Pedreiro";

    private final String INVALID_TITLEORFUNCTION = "834";

    private AddJobOpeningController testingTarget;
    private JobOpeningService mockService;

    private AuthorizationService autzService;

    private final String VALID_DESCRIPTION = "O balão do João,\n Sobe sobe sem parar! \uD83C\uDFB5";

    private final Mode VALID_MODE = Mode.REMOTE;

    private final ContractType VALID_CONTRACTTYPE = ContractType.FULL_TIME;

    private final String VALID_EPITAPH = "Pedreiro";


    private final Role[] VALID_ROLES = new Role[]{BaseRoles.CUSTOMER_MANAGER, BaseRoles.ADMIN, BaseRoles.POWER_USER};
    private final JobOpening DUMMY_VALID_JOB_OPENING = new JobOpening(new JobReference(10L, "dummy"));

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
    void checkVacanciesNumberValid() {
        assertFalse(testingTarget.checkVacanciesNumber(VALID_VACANCIESNUMBER), "Valid title or function should produce false: " + VALID_TITLEORFUNCTION);
    }

    @Test
    void checkVacanciesNumberInvalidNull() {
        assertTrue(testingTarget.checkVacanciesNumber(null), "Invalid title or function should produce true: null");
    }

    @Test
    void checkVacanciesNumberInvalidIsBlank() {
        assertTrue(testingTarget.checkVacanciesNumber(INVALID_VACANCIESNUMBER_BLANK),
                "Invalid title or function should produce true: " + INVALID_VACANCIESNUMBER_BLANK);
    }

    @Test
    void checkVacanciesNumberInvalidString() {
        assertTrue(testingTarget.checkVacanciesNumber(INVALID_VACANCIESNUMBER),
                "Invalid title or function should produce true: " + INVALID_VACANCIESNUMBER);
    }

    @Test
    void checkVacanciesNumberInvalidNegative() {
        assertTrue(testingTarget.checkVacanciesNumber("-1"),
                "Invalid title or function should produce true: " + "-1");
    }


    @Test
    void checkCompanyIDValid() {
        assertFalse(testingTarget.checkCompanyID(VALID_COMPANYID), "Valid companyID should produce false: " + VALID_COMPANYID);
    }

    @Test
    void checkCompanyIDInvalidNull() {
        assertTrue(testingTarget.checkCompanyID(null), "Invalid companyID should produce true: null");
    }


    @Test
    void checkCompanyIDInvalidIsBlank() {
        assertTrue(testingTarget.checkCompanyID(INVALID_COMPANYID_BLANK),
                "Invalid companyID should produce true: " + INVALID_COMPANYID_BLANK);
    }

    @Test
    void checkCompanyIDInvalidString() {
        assertTrue(testingTarget.checkCompanyID("SSSS"),
                "Invalid companyID should produce true: " + "SSSS");
    }
}

