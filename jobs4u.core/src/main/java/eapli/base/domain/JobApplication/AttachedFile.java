package eapli.base.domain.JobApplication;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class AttachedFile {


    private final String attachedEmail;
    private final Calendar applicationData;
    private final String applicationStatus;
    private final int applicationID;

    public AttachedFile(String attachedEmail, Calendar applicationData, String applicationStatus, int applicationID) {
        this.attachedEmail = attachedEmail;
        this.applicationData = applicationData;
        this.applicationStatus = applicationStatus;
        this.applicationID = applicationID;
        
    }


}
