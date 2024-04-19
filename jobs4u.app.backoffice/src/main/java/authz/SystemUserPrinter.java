package authz;


import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.visitor.Visitor;

public class SystemUserPrinter implements Visitor<SystemUser> {

    @Override
    public void visit(final SystemUser visitee) {
        System.out.printf("%-10s%-30s%-30s", visitee.username(), visitee.name().firstName(), visitee.name().lastName());
    }
}

