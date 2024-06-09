package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.company.Company;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.protocol.Packet;
import eapli.base.protocol.dto.LoginDTO;
import eapli.base.server.MessageCodes;
import eapli.base.usermanagement.application.EmailManagement.EmailMessageGenerator;
import eapli.base.usermanagement.application.services.ApplicationService;
import eapli.base.usermanagement.application.services.JobOpeningService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Properties;

public class PublishResultsController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobOpeningService jobOpeningService = new JobOpeningService();
    private final ApplicationService applicationService = new ApplicationService();

    private static final byte VERSION = 0;

    private Session session;
    private Transport transport;
    public PublishResultsController(){
        final String username = "grupoxlapr@outlook.pt";
        final String password = "Contaparalapr4";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.office365.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        this.session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            this.transport = this.session.getTransport("smtp");
            this.transport.connect();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public SystemUser getLoggedInUser() {
        return authz.session().get().authenticatedUser();
    }

    public List<Candidate> getRankedApplications(JobOpening selectedJobOpening) {
        return applicationService.getRankedApplications(selectedJobOpening);
    }




    public void closeTransport() {
        try {
            if (this.transport != null) {
                this.transport.close();
            }
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<JobOpening> getJobOpenings() {
        return jobOpeningService.allJobs();
    }
}
