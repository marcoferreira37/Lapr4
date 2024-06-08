package eapli.base.usermanagement.application.EmailManagement;

import eapli.base.domain.candidate.Candidate;

import java.util.List;

public class EmailMessageGenerator {
    private final String UPDATE_APPLICATION_SUBJECT = "Update on Your Application";
    private final String ACCEPTED_APPLICATION_SUBJECT = "Application result";

    public String getJOB_CANDIDATES_LIST_SUBJECT() {
        return JOB_CANDIDATES_LIST_SUBJECT;
    }

    private final String JOB_CANDIDATES_LIST_SUBJECT = "Job Opening Candidates List";

    public String getUPDATE_APPLICATION_SUBJECT() {
        return UPDATE_APPLICATION_SUBJECT;
    }

    public String getACCEPTED_APPLICATION_SUBJECT() {
        return ACCEPTED_APPLICATION_SUBJECT;
    }

    public String generateEmailMessage(String candidateName, String managerName, String companyName, String applicationStatus) {
        String message = "";
        if (applicationStatus.equals("ACCEPTED")) {
            message = generateAcceptedMessage(candidateName, managerName, companyName);
        } else if (applicationStatus.equals("REJECTED")) {
            message = generateRejectedMessage(candidateName, managerName, companyName);
        }
        // Você pode adicionar mais condições aqui para outros status de aplicação
        return message;
    }

    private String generateAcceptedMessage(String candidateName, String managerName, String companyName) {
        return "Dear " + candidateName + ",\n\n" +
                "I hope this email finds you well. As the Customer Manager, I wanted to inform you about the outcome of the verification process for the position you applied for. After careful consideration of your application and qualifications, I'm pleased to inform you that you have successfully passed the verification process. Congratulations!\n\n" +
                "Your application has met our initial criteria, and we are impressed with your qualifications and experience. We will be proceeding to the next phase of the selection process, which may include interviews or additional assessments. We will reach out to you soon with further details regarding the next steps.\n\n" +
                "Thank you for your interest in our company and for taking the time to apply for the position. We appreciate your patience throughout the process. If you have any questions or need further assistance, please don't hesitate to contact us.\n\n" +
                "Best regards,\n" +
                managerName + "\n" +
                "Customer Manager\n" +
                companyName;
    }

    private String generateRejectedMessage(String candidateName, String managerName, String companyName) {
        return "Subject: Update on Your Application\n\n" +
                "Dear " + candidateName + ",\n\n" +
                "I hope this email finds you well. As the Customer Manager, I wanted to inform you about the outcome of the verification process for the position you applied for.\n\n" +
                "After careful consideration of your application and qualifications, we regret to inform you that we will not be moving forward with your application at this time. While we were impressed with your experience and skills, we had to make some difficult decisions due to the high number of highly qualified candidates.\n\n" +
                "We sincerely appreciate your interest in our company and the time you invested in the application process. We encourage you to keep an eye on future opportunities with us, as we would be pleased to consider your application for other positions that may align with your profile.\n\n" +
                "If you have any questions or need further information, please do not hesitate to contact us.\n\n" +
                "Thank you for your understanding, and we wish you the best of luck in your future endeavors.\n\n" +
                "Best regards,\n" +
                managerName + "\n" +
                "Customer Manager\n" +
                companyName;
    }

    public String generateFinalResultMessage(String candidateName, String managerName, String companyName) {
        return "Subject: Application result\n\n" +
                "Dear " + candidateName + ",\n\n" +
                "I hope this email finds you well. As the Customer Manager, I wanted to inform you about the final outcome of the selection process for the position you applied for.\n\n" +
                "After careful consideration of your application, qualifications, and performance in the selection process, I'm pleased to inform you that you have been selected for the position. Congratulations!\n\n" +
                "We were impressed with your skills, experience, and performance throughout the selection process. We believe that you are a great fit for the position and that you will make a valuable contribution to our team.\n\n" +
                "We will be reaching out to you soon with further details regarding the job offer, including the terms of employment, start date, and other relevant information. If you have any questions or need further clarification, please don't hesitate to contact us.\n\n" +
                "Thank you for your interest in our company and for our commitment to the selection process. We look forward to welcoming you to our team and working together to achieve our goals.\n\n" +
                "Best regards,\n" +
                managerName + "\n" +
                companyName;
    }


    public String generateCandidatesListMessage(String JobReference, String managerName, List<Candidate> candidates) {
        String message = "Dear client,\n\n" +
                "Here is the list of candidates that were selected for the job opening with reference " + JobReference + ":\n\n";
        int index = 1;
        for (Candidate candidate : candidates) {
            message += index + ". " + candidate.toString() + "\n";
            index++;
        }
        message += "\n\n" +
                "Please review the list and let us know if you have any questions or need further information.\n\n" +
                "Best regards,\n" +
                managerName;
        return message;
    }

}
