package eapli.base.domain.jobOpening;

import eapli.base.domain.company.Company;
import eapli.base.domain.company.CompanyName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class JobOpeningTest {


    private JobOpening jobOpening1;
    private JobOpening jobOpening2;
    private JobOpening jobOpening3;
    private JobReference jobReference1;

    @BeforeEach
    void setUp() {
        CompanyName companyName1 = new CompanyName("Tech Corp");
        CompanyName companyName2 = new CompanyName("Mart Corp");
        jobReference1 = new JobReference(123L,"REF");
        JobReference jobReference2 = new JobReference(43L, "REF");
        Description description1 = new Description("Developer");
        Description description2 = new Description("Manager");
        Address address1 = new Address("123 Main St");
        Address address2 = new Address("456 Elm St");
        TitleOrFunction titleOrFunction1 = new TitleOrFunction("Software Engineer");
        TitleOrFunction titleOrFunction2 = new TitleOrFunction("Project Manager");
        VacanciesNumber vacanciesNumber1 = new VacanciesNumber(3);
        VacanciesNumber vacanciesNumber2 = new VacanciesNumber(5);
        Company company1 = new Company(companyName1);
        Company company2 = new Company(companyName2);
        Calendar creationDate1 = new GregorianCalendar(2022, Calendar.JANUARY, 1);
        Calendar creationDate2 = new GregorianCalendar(2023, Calendar.FEBRUARY, 1);

        jobOpening1 = JobOpening.builder()
                .jobReference(jobReference1)
                .description(description1)
                .address(address1)
                .mode(Mode.ONSITE)
                .contractType(ContractType.FULL_TIME)
                .titleOrFunction(titleOrFunction1)
                .vacanciesNumber(vacanciesNumber1)
                .company(company1)
                .creationDate(creationDate1)
                .interviewModel("Model1")
                .requirements("Requirements1")
                .build();

        jobOpening2 = JobOpening.builder()
                .jobReference(jobReference1)
                .description(description1)
                .address(address1)
                .mode(Mode.ONSITE)
                .contractType(ContractType.FULL_TIME)
                .titleOrFunction(titleOrFunction1)
                .vacanciesNumber(vacanciesNumber1)
                .company(company1)
                .creationDate(creationDate1)
                .interviewModel("Model1")
                .requirements("Requirements1")
                .build();

        jobOpening3 = JobOpening.builder()
                .jobReference(jobReference2)
                .description(description2)
                .address(address2)
                .mode(Mode.ONSITE)
                .contractType(ContractType.PART_TIME)
                .titleOrFunction(titleOrFunction2)
                .vacanciesNumber(vacanciesNumber2)
                .company(company2)
                .creationDate(creationDate2)
                .interviewModel("Model2")
                .requirements("Requirements2")
                .build();
    }

    @Test
    void testSameAs() {
        assertTrue(jobOpening1.sameAs(jobOpening2));
        assertFalse(jobOpening1.sameAs(jobOpening3));
    }

    @Test
    void testIdentity() {
        assertEquals(jobReference1, jobOpening1.identity());
    }

    @Test
    void testHasNameOrReference() {
        assertTrue(jobOpening1.hasNameOrReference("Developer"));
    }

    @Test
    void testHasReference() {
        assertTrue(jobOpening1.hasReference("REF-123"));
        assertFalse(jobOpening1.hasReference("REF999"));
    }

    @Test
    void testHasDescription() {
        assertTrue(jobOpening1.hasDescription("Developer"));
        assertFalse(jobOpening1.hasDescription("Nonexistent"));
    }

    @Test
    void testEquals() {
        assertEquals(jobOpening2, jobOpening2);
        assertNotEquals(jobOpening1, jobOpening3);
    }

    @Test
    void testHashCode() {
        assertNotEquals(jobOpening1.hashCode(), jobOpening2.hashCode());
        assertNotEquals(jobOpening1.hashCode(), jobOpening3.hashCode());
    }

    @Test
    void testToString() {
        String expected = "\n-----------------------------------------------------" +
                          "\n////// Job Opening //////" +
                          "\n" +
                          "\nJob Reference = REF-123" +
                          "\nDescription = Developer" +
                          "\nAddress = 123 Main St" +
                          "\nMode = ONSITE" +
                          "\nContractType = FULL_TIME" +
                          "\nTitle Or Function = Software Engineer" +
                          "\nVacancies Number = 3" +
                          "\nCompany Name: Tech Corp" +
                          "\nCreation Date = Sat Jan 01 00:00:00 WET 2022" +
                          "\nRequirements File = Requirements1" +
                          "\nInterview Model = Model1";

        assertEquals(expected, jobOpening1.toString());
    }

}