package eapli.base.domain.EmailService;

import eapli.base.domain.EmailNotification.EmailToSend;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.usermanagement.application.EmailManagement.EmailMessageGenerator;
import eapli.base.usermanagement.application.services.ApplicationService;
import eapli.base.usermanagement.application.services.JobOpeningService;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class SendEmails {

    private Session session;



    public void sendEmail(EmailAddress toUser, char[] content) {


        final String username = "grupoxlapr@outlook.pt";
        final String password = "Contaparalapr4";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.office365.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        email(toUser,content);

    }

    public void email(EmailAddress toUser, char[] content){

        Thread emailThread = new Thread(() -> {
            try {
                System.out.println("Sending email to " + toUser.toString());
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("grupoxlapr@outlook.pt"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(toUser.toString())
                );

                message.setSubject("Jobs4U applications:");
                String s = clean(content);
                message.setText(s);

                Transport.send(message);
                System.out.println("Email Sent to: " + toUser.toString());

            } catch (MessagingException e) {
                System.err.println("Failed to send email: " + e.getMessage());
            }
        });

        emailThread.start();

    }

    private String clean(char[] content) {
        StringBuilder result = new StringBuilder();
        for (char c : content) {
            result.append(c);
        }
        return result.toString();
    }

}