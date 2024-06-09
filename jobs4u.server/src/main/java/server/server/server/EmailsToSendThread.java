package server.server.server;

import eapli.base.domain.EmailNotification.EmailToSend;
import eapli.base.domain.EmailService.EmailService;
import eapli.base.domain.EmailService.SendEmails;

public class EmailsToSendThread extends Thread {


    SendEmails sendEmails = new SendEmails();

    EmailService emailService = new EmailService();


    @Override
    public  void run(){
        Iterable<EmailToSend>  list;
        boolean flage = true;
        while (flage){
            try {
                list = emailService.findToSends();
                EmailToSend email = list.iterator().next();
                sendEmails.sendEmail(email.email(),email.content());
                emailService.setEmailAsSent(email);
                flage=true;
                sleep(2000);
            }catch (Exception e){
                flage=false;
            }
        }

    }


}
