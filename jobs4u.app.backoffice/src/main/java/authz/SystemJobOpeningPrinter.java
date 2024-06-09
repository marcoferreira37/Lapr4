package authz;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpeningInterview.JobInterview;
import eapli.framework.visitor.Visitor;

public class SystemJobOpeningPrinter implements Visitor<JobOpening> {


    @Override
    public void visit(JobOpening visitee) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s", visitee.getJobReference().fullReference() , visitee.getDescription(), visitee.getAddress(), visitee.getMode(), visitee.getContractType(), visitee.getTitleOrFunction().titleOrFunction(), visitee.getVacanciesNumber().getNumber(), visitee.getCompany().getCompanyName().companyName());

    }


    public void visitInterview(JobInterview visitee) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s", visitee.getJobOpeningApplication(), visitee.getInterviewDate(), visitee.getInterviewTime(), visitee.getGrade(), visitee.getJobOpeningApplication().getJobOpening().getJobReference().fullReference(), visitee.getInterviewTime(), visitee.getJobOpeningApplication().getJobOpening().getAddress(), visitee.getInterviewTime(), visitee.getGrade(), visitee.interviewAnswers(), visitee.getJobOpeningApplication().getJobOpening().getVacanciesNumber().getNumber(), visitee.getJobOpeningApplication().getJobOpening().getCompany().getCompanyName().companyName());
    }
}
