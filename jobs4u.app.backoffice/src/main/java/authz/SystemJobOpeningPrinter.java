package authz;

import eapli.base.domain.jobOpening.JobOpening;
import eapli.framework.visitor.Visitor;

public class SystemJobOpeningPrinter implements Visitor<JobOpening> {


    @Override
    public void visit(JobOpening visitee) {
        System.out.printf("%-10s%-30s%-30s%-30s%-30s%-30s%-30s%-30s", visitee.getJobReference(), visitee.getDescription(), visitee.getAddress(), visitee.getMode(), visitee.getContractType(), visitee.getTitleOrFunction(), visitee.getVacanciesNumber(), visitee.getCompany());
    }
}
