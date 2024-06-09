package server.server.server;

import eapli.base.domain.EmailNotification.EmailToSend;
import eapli.base.domain.EmailService.EmailService;
import eapli.base.domain.EmailService.SendEmails;

public class EmailsToSendThread extends Thread {


    SendEmails sendEmails = new SendEmails();

    EmailService emailService = new EmailService();


    @Override
    public  void run(){
        try {
            sendEmails.sendEmail();
        }catch (Exception e){
            System.err.println("Error sending email" + e.getMessage());
        }
    }


}
