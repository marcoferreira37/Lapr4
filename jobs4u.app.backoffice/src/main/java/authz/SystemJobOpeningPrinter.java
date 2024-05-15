package authz;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.framework.visitor.Visitor;

public class SystemJobOpeningPrinter implements Visitor<JobOpening> {


    @Override
    public void visit(JobOpening visitee) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s", visitee.getJobReference().fullReference() , visitee.getDescription(), visitee.getAddress(), visitee.getMode(), visitee.getContractType(), visitee.getTitleOrFunction().titleOrFunction(), visitee.getVacanciesNumber().getNumber(), visitee.getCompany().getCompanyName().companyName());
    }
}
