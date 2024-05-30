package eapli.base.domain;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.candidate.TelephoneNumber;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JobInterviewTest {


    private JobInterview jobInterview;
    private Candidate candidate;
    private Calendar interviewDate;

    public static SystemUser dummyUser(final String username, final Role... roles) {

        final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }

    private SystemUser getNewDummyUser() {
        return dummyUser("dummy", BaseRoles.CANDIDATE);
    }

    @BeforeEach
    void setUp() {
        final SystemUser systemUser = getNewDummyUser();
        EmailAddress emailAddress = EmailAddress.valueOf("a@b.ro");
        TelephoneNumber telephoneNumber = new TelephoneNumber(987654321);
        Candidate candidate = new Candidate(systemUser, emailAddress, telephoneNumber, "cv");
        Calendar interviewDate = Calendar.getInstance();
       // jobInterview = new JobInterview("15:30", interviewDate, candidate);
    }

    @Test
    public void testJobInterviewCreation() {
        assertNotNull(jobInterview);
        assertEquals("15:30", jobInterview.interviewTime());
        assertEquals(interviewDate, jobInterview.interviewDate());
      //  assertEquals(candidate, jobInterview.candidate());
    }

}
