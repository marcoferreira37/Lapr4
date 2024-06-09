package server.server.server;

import eapli.base.domain.EmailService.SendEmails;

public class EmailsToSendThread extends Thread {


    SendEmails sendEmails = new SendEmails();


    @Override
    public  void run(){
        try {
            sendEmails.sendEmail();
        }catch (Exception e){
            System.err.println("Error sending email" + e.getMessage());
        }
    }


}
