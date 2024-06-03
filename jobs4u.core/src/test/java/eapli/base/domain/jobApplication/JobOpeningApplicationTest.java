package eapli.base.domain.jobApplication;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobOpening.JobOpening;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

public class JobOpeningApplicationTest {

    private JobOpening jobOpening;
    private Candidate candidate;
    private JobOpeningApplication jobOpeningApplication;

    @BeforeEach
    public void setUp() {
        jobOpening = new JobOpening(); // Assuming a default constructor is available
        candidate = new Candidate(); // Assuming a default constructor is available
        jobOpeningApplication = new JobOpeningApplication(jobOpening, candidate);
    }

    @Test
    public void testConstructor() {
        assertNotNull(jobOpeningApplication, "JobOpeningApplication instance should not be null");
        assertEquals(jobOpening, jobOpeningApplication.jobOpening(), "JobOpening should be initialized correctly");
        assertEquals(candidate, jobOpeningApplication.candidate(), "Candidate should be initialized correctly");
        assertEquals("N/A", jobOpeningApplication.candidateRequirements(), "Candidate requirements should be initialized to 'N/A'");
        assertEquals(-1, jobOpeningApplication.showRanking(), "Rank should be initialized to -1");
    }

    @Test
    public void testRankApplication() {
        int expectedRank = 5;
        jobOpeningApplication.rankApplication(expectedRank);
        assertEquals(expectedRank, jobOpeningApplication.showRanking(), "Rank should be set correctly");
    }

    @Test
    public void testShowRank() {
        int rank = 7;
        jobOpeningApplication.rankApplication(rank);
        assertEquals(String.valueOf(rank), jobOpeningApplication.showRank(), "showRank should return the correct rank as a string");
    }

    @Test
    public void testShowRanking() {
        int rank = 3;
        jobOpeningApplication.rankApplication(rank);
        assertEquals(rank, jobOpeningApplication.showRanking(), "showRanking should return the correct rank as an integer");
    }

    @Test
    public void testSetCandidateRequirements() {
        String requirements = "Bachelor's degree in Computer Science";
        jobOpeningApplication.setCandidateRequirements(requirements);
        assertEquals(requirements, jobOpeningApplication.candidateRequirements(), "Candidate requirements should be set correctly");
    }
}
