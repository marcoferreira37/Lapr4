package eapli.base.domain.jobOpeningInterview;

import eapli.base.domain.jobApplication.JobOpeningApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class JobInterviewTest {

    private JobInterview interview;
    private JobInterview interview2;
    private JobInterview interview3;


    @BeforeEach
    void setUp() {
        Calendar interviewDate = Calendar.getInstance();
        interviewDate.set(2024, Calendar.JUNE, 1);
        JobOpeningApplication jobApp = new JobOpeningApplication();

        interview = JobInterview.builder()
                .interviewTime("12:21")
                .interviewDate(interviewDate)
                .jobOpeningApplication(jobApp)
                .grade(10)
                .build();
        interview2 = JobInterview.builder()
                .interviewTime("12:12")
                .interviewDate(interviewDate)
                .jobOpeningApplication(jobApp)
                .grade(10)
                .build();

        interview3 = JobInterview.builder()
                .interviewTime("20:20")
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
        assertTrue(interview.sameAs(interview));
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
    void testSetGradeValid() {
        // Test with a valid grade
        interview3.setGrade(85);
        assertEquals(85, interview3.getGrade());
    }

    @Test
    void testSetGradeBoundaryLow() {
        // Test with the lowest boundary value
        interview.setGrade(0);
        assertEquals(0, interview.getGrade());
    }

    @Test
    void testSetGradeBoundaryHigh() {
        // Test with the highest boundary value
        interview2.setGrade(100);
        assertEquals(100, interview2.getGrade());
    }
    @Test
    void testInvalidateImpossibleGradeValid() {
        // Test with a valid grade
        assertDoesNotThrow(() -> {
            interview.InvalidateImpossibleGrade(85);
        });
    }

    @Test
    void testInvalidateImpossibleGradeBoundaryLow() {
        // Test with the lowest boundary value
        assertDoesNotThrow(() -> {
            interview2.InvalidateImpossibleGrade(-1);
        });
    }

    @Test
    void testInvalidateImpossibleGradeBoundaryHigh() {
        // Test with the highest boundary value
        assertDoesNotThrow(() -> {
            interview2.InvalidateImpossibleGrade(100);
        });
    }

    @Test
    void testInvalidateImpossibleGradeBelowMinimum() {
        // Test with a grade below the minimum (assuming we want to handle it as invalid)
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> interview3.InvalidateImpossibleGrade(-2));
        assertEquals("Grade must be between -1 and 100", thrown.getMessage());
    }

    @Test
    void testInvalidateImpossibleGradeAboveMaximum() {
        // Test with a grade above the maximum (assuming we want to handle it as invalid)
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            interview.InvalidateImpossibleGrade(101);
        });
        assertEquals("Grade must be between -1 and 100", thrown.getMessage());
    }
    @Test
    void testHasAnswersWhenEmpty() {
        // Test when interviewAnswers is an empty list
        List<JobInterview> answers = new ArrayList<>();
        answers.add(new JobInterview());
        assertFalse(interview3.hasAnswers(), "Expected hasAnswers to be false when interviewAnswers is an empty list");
    }

    @Test
    void testHasAnswersWhenNotEmpty() {
        // Test when interviewAnswers contains elements
        List<JobInterview> answers = new ArrayList<>();
        answers.add(new JobInterview()); // Add a mock answer
        interview3.setInterviewAnswers("answer");
        assertTrue(interview3.hasAnswers(), "Expected hasAnswers to be true when interviewAnswers is not empty");
    }
    @Test
    void testInterviewAnswersWhenNull() {
        // Test when interviewAnswers is null
        interview3.setInterviewAnswers(null);
        assertEquals(null, interview3.interviewAnswers(), "Expected 'No answers' when interviewAnswers is null");
    }
    @Test
    void testSetGrade() {
        // Test setting a valid grade
        interview.setGrade(85);
        assertEquals(85, interview.grade(), "Expected grade to be 85");
        assertNotEquals(50, interview.grade(), "Expected grade to not be 50");

    }
    @Test
    void testInterviewTime() {
        // Check if the interviewTime method returns the correct value
        assertEquals("12:21", interview.interviewTime(), "Expected interview time to be 12:21");
    }

    @Test
    void testSetInterviewTime() {
        // Test setting a new interview time
        interview2.setInterviewTime("14:00");
        assertEquals("14:00", interview2.interviewTime(), "Expected interview time to be 14:00");

    }

    @Test
    void testSetInterviewDate() {
        // Testa a definição de uma nova data de entrevista
        Calendar newInterviewDate = Calendar.getInstance();
        newInterviewDate.set(2024, Calendar.JULY, 10);
        interview.setInterviewDate(newInterviewDate);
        assertEquals(newInterviewDate, interview.interviewDate(), "Esperava-se que a data da entrevista fosse 10 de Julho de 2024");
    }
    @Test
    void testIdentityNotNull() {
        // Arrange
        JobInterview interview = new JobInterview();

        // Act
        Long identity = interview.identity();

        // Assert
        assertEquals(null, identity, "Expected identity to be null");
    }
    @Test
    void testValidatePossibleGradeBelowMinimum() {
        // Test with a grade below the minimum
        JobInterview interview = new JobInterview();
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> interview.validatePossibleGrade(-1));
        assertEquals("Grade must be between 0 and 100", thrown.getMessage());
    }

    @Test
    void testValidInterviewTimeFormat() {
        assertDoesNotThrow(() -> interview.validateInterviewTimeInput(interview.getInterviewTime()), "Valid time format should not throw an exception");
    }

    @Test
    void testInvalidInterviewTimeFormat() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            interview.validateInterviewTimeInput("10:00 AM");
        });
        assertEquals("Invalid time format. Please use HH:mm", exception.getMessage(), "Exception message should match");
    }
    @Test
    void testInvalidHourInTimeFormat() {
        JobInterview obj = new JobInterview();
        String invalidTime = "27:27";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            obj.validateInterviewTimeInput(invalidTime);
        });
        assertEquals("Invalid time format. Please use HH:mm", exception.getMessage(), "Exception message should match");
    }












}



