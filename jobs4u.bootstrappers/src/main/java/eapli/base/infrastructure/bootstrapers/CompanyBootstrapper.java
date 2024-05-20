package eapli.base.infrastructure.bootstrapers;

import eapli.base.Domain.Company.AddCompanyController;
import eapli.base.domain.company.Company;
import eapli.framework.actions.Action;

public class CompanyBootstrapper implements Action {
    final AddCompanyController controller = new AddCompanyController();
    @Override
    public boolean execute() {
        System.out.println("Bootstrapping Company");
        System.out.println(registerCompany("FISQUINHO LDA").toString());
        System.out.println("Bootstrapping Company");
        System.out.println(registerCompany("ISEP").toString() );
        System.out.println("Bootstrapping Company");
        System.out.println(registerCompany("FEUP").toString() );
        System.out.println("Bootstrapping Company");
        System.out.println(registerCompany("IPCA").toString() );
        System.out.println("Bootstrapping Company");
        System.out.println(registerCompany("ISCAP").toString());


        return true;
    }
    private Company registerCompany(final String name){
        return controller.addCompany(name);
    }
}
