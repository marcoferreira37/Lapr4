package eapli.base.domain.EmailService;

import eapli.base.domain.EmailNotification.EmailToSend;
import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.usermanagement.application.EmailManagement.EmailMessageGenerator;
import eapli.base.usermanagement.application.services.ApplicationService;
import eapli.base.usermanagement.application.services.JobOpeningService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class SendEmails {

    private Session session;
    private final JobOpeningService jobOpeningService = new JobOpeningService();
    private final ApplicationService applicationService = new ApplicationService();
    private final EmailService emailService = new EmailService();



    public void sendEmail() {


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


        Iterable<EmailToSend> emailToSends = emailService.findToSends();
        List<JobOpening> jobOpenings = getJobOpenings();
        JobOpening selectedJobOpening;
        for(JobOpening job : jobOpenings){
            for (EmailToSend emails : emailToSends){
                if(emails.email().equals(job.getCompany().getCustomer().user().email())){
                    selectedJobOpening = job;
                    List<Candidate> candidates = getRankedApplications(selectedJobOpening);
                    publishResults(candidates, selectedJobOpening, emailToSends);
                }

            }
            //n pode mas ja sei
            // n é so meteres o codigo dentro do if e tirares o break? pois
            // lesgo dupla de marcos que maquinas
        }
    }


    public List<Candidate> getRankedApplications(JobOpening selectedJobOpening) {
        return applicationService.getRankedApplications(selectedJobOpening);
    }
    public List<JobOpening> getJobOpenings() {
        return jobOpeningService.allJobs();
    }


    public void sendEmailToCandidate(Candidate toUser, String content) {

        Thread emailThread = new Thread(() -> {
            try {
                System.out.println("Sending email to " + toUser.user().email().toString());
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("grupoxlapr@outlook.pt"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(toUser.user().email().toString())
                );

                EmailMessageGenerator emailMessageGenerator = new EmailMessageGenerator();

                message.setSubject(emailMessageGenerator.getACCEPTED_APPLICATION_SUBJECT());
                message.setText(content);

                Transport.send(message);
                System.out.println("Email Sent to Candidate: " + toUser.getEmail().toString());

            } catch (MessagingException e) {
                System.err.println("Failed to send email: " + e.getMessage());
            }finally {
                System.out.println("Email thread finished");
            }
        });

        emailThread.start();
    }

    public void sendEmailToClient(SystemUser toUser, String content) {
        Thread emailThread = new Thread(() -> {
            try {
                System.out.println("Sending email to: " + toUser.email().toString());
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("grupoxlapr@outlook.pt"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(toUser.email().toString())
                );

                EmailMessageGenerator emailMessageGenerator = new EmailMessageGenerator();

                message.setSubject(emailMessageGenerator.getJOB_CANDIDATES_LIST_SUBJECT());
                message.setText(content);

                Transport.send(message);
                System.out.println("Email Sent to Client: " + toUser.email().toString());

            } catch (MessagingException e) {
                System.err.println("Failed to send email: " + e.getMessage());
            }
        });

        emailThread.start();
    }

    public void publishResults(List<Candidate> candidates, JobOpening jobOpening, Iterable<EmailToSend> emails) {
        try {
            for(EmailToSend email : emails){
            for (Candidate candidate : candidates) {
                if(email.email().equals(candidate.getEmail())){
                    String content = email.content().replace("[", "").replace("]","").replace(",","");
                    System.out.println(content);
                    sendEmailToCandidate(candidate,content);
                    emailService.setEmailAsSent(email);
                }
            }
            SystemUser systemUser = jobOpening.getCompany().findCustomer().user();
            if(email.email().equals(systemUser.email())) {
                String content = email.content().replace("[", "").replace("]","").replace(",","");
                sendEmailToClient(systemUser,content);
                emailService.setEmailAsSent(email);
            }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
