package eapli.base.domain.EmailService;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailService {

    public static void sendEmail(String destination, String subject, String message){
        //destination = 1220813@isep.ipp.pt
        // subject = verification
        // message = "A tua aplicacion está correta"

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
}
