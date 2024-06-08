package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.company.Company;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.server.MessageCodes;
import eapli.base.usermanagement.application.EmailManagement.EmailMessageGenerator;
import eapli.base.usermanagement.application.services.ApplicationService;
import eapli.base.usermanagement.application.services.JobOpeningService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class PublishResultsController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobOpeningService jobOpeningService = new JobOpeningService();
    private final ApplicationService applicationService = new ApplicationService();

    private Session session;
    private Transport transport;

    public SystemUser getLoggedInUser() {
        return authz.session().get().authenticatedUser();
    }

    public List<Candidate> getRankedApplications(JobOpening selectedJobOpening) {
        return applicationService.getRankedApplications(selectedJobOpening);
    }

    public void sendEmailToCandidate(SystemUser fromUser, Candidate toUser, Company customer) {
        Thread emailThread = new Thread(() -> {
            try {
                Message message = new MimeMessage(this.session);
                message.setFrom(new InternetAddress("grupoxlapr@outlook.pt"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(toUser.user().email().toString())
                );

                String candidateName = toUser.user().name().toString();
                String managerName = fromUser.name().toString();
                String companyName;
                companyName=customer.getCompanyName().companyName();
                EmailMessageGenerator emailMessageGenerator = new EmailMessageGenerator();
                String text = emailMessageGenerator.generateFinalResultMessage(candidateName, managerName, companyName);

                message.setSubject(emailMessageGenerator.getACCEPTED_APPLICATION_SUBJECT());
                message.setText(text);

                this.transport.sendMessage(message, message.getAllRecipients());

            } catch (MessagingException e) {
                System.err.println("Failed to send email: " + e.getMessage());
            }
        });

        emailThread.start();
    }

    public void sendEmailToClient(SystemUser fromUser, Candidate toUser, List<Candidate> acceptedCandidates, JobOpening jobOpening) {
        Thread emailThread = new Thread(() -> {
            try {
                Message message = new MimeMessage(this.session);
                message.setFrom(new InternetAddress("grupoxlapr@outlook.pt"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(toUser.user().email().toString())
                );

                String managerName = fromUser.name().toString();

                EmailMessageGenerator emailMessageGenerator = new EmailMessageGenerator();
                String text = emailMessageGenerator.generateCandidatesListMessage(jobOpening.getJobReference().fullReference(), managerName, acceptedCandidates);

                message.setSubject(emailMessageGenerator.getJOB_CANDIDATES_LIST_SUBJECT());
                message.setText(text);

                this.transport.sendMessage(message, message.getAllRecipients());

            } catch (MessagingException e) {
                System.err.println("Failed to send email: " + e.getMessage());
            }
        });

        emailThread.start();
    }

    public void publishResults(SystemUser fromUser, List<Candidate> candidates,  JobOpening jobOpening) {
        try {
            Socket socket = new Socket("127.0.0.1", 10792);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            Candidate toUser = applicationService.getCandidateOfJobOpening(jobOpening);
            for (Candidate candidate : candidates) {
                sendEmailToCandidate(fromUser, candidate, jobOpening.getCompany());
            }

            sendEmailToClient(fromUser, toUser, candidates, jobOpening);

            dis.readByte();
            byte b = dis.readByte();
            if(b== MessageCodes.ACK_RESPONSE){
                System.out.println("Email sent successfully");
            }else if(b==MessageCodes.ERR_RESPONSE){
                System.out.println("Failed to send email");
            }
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            // Close the Transport after all emails have been sent
            closeTransport();
        }

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
