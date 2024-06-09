package eapli.base.domain.EmailService;

import eapli.base.domain.EmailNotification.EmailToSend;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.EmailToSendRepository;
import eapli.framework.general.domain.model.EmailAddress;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailService {

    EmailToSendRepository emailToSendRepository = PersistenceContext.repositories().emailToSendRepository();


    public static void sendEmail(String destination, String subject, String message){


        try {
            Email email = new SimpleEmail();
            email.setHostName("frodo.dei.isep.ipp.pt");
            email.setSmtpPort(25);
            email.setSSLOnConnect(false);
            email.setFrom("emailRcomp@jobs4u.org", "Rcomp Customer Manager");
            email.setSubject(subject);
            email.setMsg(message);
            email.addTo(destination);
            email.send();
        } catch (EmailException e) {
            throw new RuntimeException(e);
        }

    }

    public EmailToSend addToEmailsToSend(EmailAddress email, String content){
        EmailToSend emailToSend = new EmailToSend(email, content);
        emailToSendRepository.save(emailToSend);
        return emailToSend;
    }

    public Iterable<EmailToSend> findToSends() {
        return emailToSendRepository.findToSends(false);
    }

    public void sendEmails(EmailAddress email, String content) {


        
    }

    public void setEmailAsSent(EmailToSend email) {
        email.markAsSent();
        emailToSendRepository.save(email);
    }
}
