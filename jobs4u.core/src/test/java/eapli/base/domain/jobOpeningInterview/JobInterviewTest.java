package eapli.base.domain.jobOpeningInterview;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;


class JobInterviewTest {

    private JobInterview interview;
    private JobInterview interview2;
    private JobInterview interview3;

    @BeforeEach
    void setUp() {
        Calendar interviewDate = Calendar.getInstance();
        interviewDate.set(2024, Calendar.JUNE, 1);
        Candidate candidate = new Candidate();
        JobOpeningApplication jobApp = new JobOpeningApplication();

        interview = JobInterview.builder()
                .interviewTime("1")
                .interviewDate(interviewDate)
                .jobOpeningApplication(jobApp)
                .grade(10)
                .build();
        interview2 = JobInterview.builder()
                .interviewTime("1")
                .interviewDate(interviewDate)
                .jobOpeningApplication(jobApp)
                .grade(10)
                .build();

        interview3 = JobInterview.builder()
                .interviewTime("2")
                .interviewDate(interviewDate)
                .jobOpeningApplication(jobApp)
                .grade(10)
                .build();
    }

    @Test
    public void validateInterviewTimeNotNullTest() {
        Calendar futureDate = Calendar.getInstance();
        futureDate.add(Calendar.DAY_OF_MONTH, 1); // Definindo a data para o futuro
        JobOpeningApplication jobOpeningApplication = new JobOpeningApplication(); // Objeto válido

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new JobInterview(null, futureDate, jobOpeningApplication);
        });

        assertEquals("Interview Time must not be null", exception.getMessage());
    }


    @Test
    public void validateInterviewDateTest() {
        Calendar pastDate = Calendar.getInstance();
        pastDate.add(Calendar.DAY_OF_MONTH, -1); // Definindo a data para o passado
        JobOpeningApplication jobOpeningApplication = new JobOpeningApplication(); // Objeto válido

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new JobInterview("10:00 AM", pastDate, jobOpeningApplication);
        });

        assertEquals("Interview Date must not be in the past", exception.getMessage());
    }

    @Test
    public void validateJobOpeningApplicationTest() {
        Calendar futureDate = Calendar.getInstance();
        futureDate.add(Calendar.DAY_OF_MONTH, 1); // Definindo a data para o futuro

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new JobInterview("10:00 AM", futureDate, null);
        });

        assertEquals("Job Opening Application must not be null", exception.getMessage());
    }

    @Test
    public void validateJobOpeningApplication_NullJobOpeningApplication_ThrowsException() {
        JobInterview jobInterview = new JobInterview();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            jobInterview.validateJobOpeningApplication(null);
        });
        assertEquals("Job Opening Application must not be null", exception.getMessage());
    }

    @Test
    public void validateInterviewDate_PastDate_ThrowsException() {
        JobInterview jobInterview = new JobInterview();
        Calendar pastDate = Calendar.getInstance();
        pastDate.add(Calendar.DAY_OF_MONTH, -1); // Define a data para o passado
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            jobInterview.validateInterviewDate(pastDate);
        });
        assertEquals("Interview Date must not be in the past", exception.getMessage());
    }

    @Test
    public void validateInterviewTimeNotNull_NullInterviewTime_ThrowsException() {
        JobInterview jobInterview = new JobInterview();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            jobInterview.validateInterviewTimeNotNull(null);
        });
        assertEquals("Interview Time must not be null", exception.getMessage());
    }

    @Test
    public void validateInterviewTimeTest() {
        JobInterview jobInterview = new JobInterview();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            jobInterview.validateInterviewTime("");
        });
        assertEquals("Interview Time must not be null", exception.getMessage());
    }

    @Test
    void testValidGrade() {
        JobInterview interview = new JobInterview();
        interview.gradeInterview(85);
        assertEquals(85, interview.getGrade());
    }

    @Test
    void testGradeBelowMinimum() {
        JobInterview interview = new JobInterview();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            interview.gradeInterview(-1);
        });
        assertEquals("Grade must be between 0 and 100", exception.getMessage());
    }

    @Test
    void testGradeAboveMaximum() {
        JobInterview interview = new JobInterview();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            interview.gradeInterview(101);
        });
        assertEquals("Grade must be between 0 and 100", exception.getMessage());
    }

    @Test
    void testGradeAtLowerBoundary() {
        JobInterview interview = new JobInterview();
        interview.gradeInterview(0);
        assertEquals(0, interview.getGrade());
    }

    @Test
    void testGradeAtUpperBoundary() {
        JobInterview interview = new JobInterview();
        interview.gradeInterview(100);
        assertEquals(100, interview.getGrade());
    }

    @Test
    void testSameAsWithSameObject() {
        assertTrue(interview.sameAs(interview));
    }

    @Test
    void testSameAsWithNull() {
        assertFalse(interview3.sameAs(null));
    }

    @Test
    void testSameAsWithDifferentClass() {
        assertFalse(interview.sameAs("some string"));
    }

    @Test
    void testSameAsWithEqualObject() {
        assertTrue(interview.sameAs(interview2));
    }

    @Test
    void testSameAsWithDifferentId() {
        assertFalse(interview3.sameAs(interview2));
    }

    @Test
    void testSameAsWithDifferentJobOpeningApplication() {
        assertFalse(interview.sameAs(interview3));
    }

    @Test
    void testSameAsWithDifferentInterviewTime() {
        assertFalse(interview.sameAs(interview3));
    }

    @Test
    void testSameAsWithDifferentInterviewDate() {
        assertFalse(interview3.sameAs(interview2));
    }
    @Test
    void testToStringWithoutGrade() {

        String expectedOutput = "----- JobInterview -----" +
                "\nid= 1" +
                "\njobOpeningApplication= app1" +
                "\ninterviewTime= 10" +
                "\ninterviewDate= " + interview.getInterviewDate();

        assertEquals(expectedOutput, interview.toStringWithoutGrade());
    }

    @Test
    void testToStringWithoutGradeWithDifferentValues() {


        String expectedOutput = "----- JobInterview -----" +
                "\nid= 2" +
                "\njobOpeningApplication= app2" +
                "\ninterviewTime= 11" +
                "\ninterviewDate= " + interview.getInterviewDate();

        assertEquals(expectedOutput, interview.toStringWithoutGrade());
    }
}



