package authz;


import eapli.base.usermanagement.application.ListCustomersController;
import eapli.base.usermanagement.application.ListUsersController;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListCustomersUI extends AbstractListUI<SystemUser> {
    private ListCustomersController theController = new ListCustomersController();

    @Override
    public String headline() {
        return "List Customers";
    }

    @Override
    protected String emptyMessage() {
        return "No data.";
    }

    @Override
    protected Iterable<SystemUser> elements() {
        return theController.allCustomers();
    }

    @Override
    protected Visitor<SystemUser> elementPrinter() {
        return new SystemUserPrinter();
    }

    @Override
    protected String elementName() {
        return "User";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-10s%-30s%-30s", "USERNAME", "F. NAME", "L. NAME");
    }
}

