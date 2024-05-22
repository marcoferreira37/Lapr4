package authz;

import eapli.base.app.common.console.ui.components.ColorCode;
import eapli.base.customer.RankApplicationController;
import eapli.base.domain.JobApplication.JobOpeningApplication;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.JobReference;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankApplicationUITest {
    @Test
    public void testReadValidInteger_ValidInput() {
        String input = "5";
        RankApplicationUI rankApplicationUI = new RankApplicationUI();
        int result = rankApplicationUI.validInteger(input);
        assertEquals(5, result);
    }

    @Test
    public void testReadValidInteger_InvalidInput() {
        String input = "abc\n5";
        RankApplicationUI rankApplicationUI = new RankApplicationUI();

        int result = rankApplicationUI.validInteger(input);

        assertEquals(-1, result);
    }

    @Test
    public void testReadValidInteger_EmptyInput() {
        String input = "\n5";
        RankApplicationUI rankApplicationUI = new RankApplicationUI();

        int result = rankApplicationUI.validInteger(input);

        assertEquals(5, result);
    }

    @Test
    public void testReadValidInteger_NegativeInput() {
        String input = "-5";
        RankApplicationUI rankApplicationUI = new RankApplicationUI();

        int result = rankApplicationUI.validInteger(input);

        assertEquals(-1, result);
    }

    @Test
    public void testReadValidInteger_ZeroInput() {
        String input = "0";
        RankApplicationUI rankApplicationUI = new RankApplicationUI();
        int result = rankApplicationUI.validInteger(input);
        assertEquals(0, result);
    }

    @Test
    public void testReadValidInteger_ValidInputAfterInvalid() {
        String input = "abc\n5";
        RankApplicationUI rankApplicationUI = new RankApplicationUI();
        int result = rankApplicationUI.validInteger(input);
        assertEquals(-1, result);
    }

    @Test
    public void testReadValidInteger_EmptyInput2() {
        String input = "5\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        RankApplicationUI rankApplicationUI = new RankApplicationUI();
        int result = rankApplicationUI.validInteger(input);

        assertEquals(5, result);
    }

    @Test
    public void testPrintNumeratedList_CorrectOutput() {
        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<JobOpening> openingList = new ArrayList<>();
        JobReference jobReference1 = new JobReference(111L, "FIS");
        JobReference jobReference2 = new JobReference(222L, "FIS");
        JobReference jobReference3 = new JobReference(333L, "FIS");

        openingList.add(new JobOpening(jobReference1));
        openingList.add(new JobOpening(jobReference2));
        openingList.add(new JobOpening(jobReference3));

        RankApplicationUI rankApplicationUI = new RankApplicationUI();

        // Act
        rankApplicationUI.printNumeratedList(openingList);

        // Assert
        String expectedOutput = "Choose a job opening: \n\n" +
                                ColorCode.BLUE.getValue() + "1" + ColorCode.RESET.getValue() + " - Job Reference: FIS-111\n" +
                                ColorCode.BLUE.getValue() + "2" + ColorCode.RESET.getValue() + " - Job Reference: FIS-222\n" +
                                ColorCode.BLUE.getValue() + "3" + ColorCode.RESET.getValue() + " - Job Reference: FIS-333\n";

        String actualOutput = outputStream.toString();
        String[] actualLines = actualOutput.split("\\r?\\n");

        StringBuilder relevantOutput = new StringBuilder();
        boolean startCopying = false;
        for (String line : actualLines) {
            if (line.equals("Choose a job opening: ")) {
                startCopying = true;
            }
            if (startCopying) {
                relevantOutput.append(line).append("\n");
            }
        }

        assertThat(relevantOutput.toString(), equalTo(expectedOutput));
    }

    @Test
    public void testIsRankUnique_EmptyApplicationList() {
        List<JobOpeningApplication> emptyList = new ArrayList<>();
        RankApplicationUI rankApplicationUI = new RankApplicationUI();

        boolean result = rankApplicationUI.isRankUnique(5, emptyList);

        assertTrue(result);
    }



}