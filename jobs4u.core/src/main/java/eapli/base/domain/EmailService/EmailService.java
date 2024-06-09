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

    public Iterable<EmailToSend> findToSends() {
        return emailToSendRepository.findToSends(false);
    }

    public void sendEmails(EmailAddress email, String content) {



//todo cruch salva-me + o ahhhhh quer saber se as alterações no servidor foderam-lhe a us? supostamente nao
        // TODO o tualipa tbm quer saber ainda n dei commit de nada tho
//todo to teu methodo q manda emails

        
    }

    public void setEmailAsSent(EmailToSend email) {
        email.markAsSent();
        emailToSendRepository.save(email);
    }
}
