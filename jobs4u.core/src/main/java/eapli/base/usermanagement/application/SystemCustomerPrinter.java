package eapli.base.usermanagement.application;


import eapli.base.customer.Customer;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.visitor.Visitor;

public class SystemCustomerPrinter implements Visitor<Customer> {

    @Override
    public void visit(final Customer visitee) {
        System.out.printf("%-10s%-30s%-30s", visitee.user().email());
    }
}