package authz.listusers;


import authz.SystemUserPrinter;
import eapli.base.app.common.console.ui.components.ListPrinter;
import eapli.base.app.common.console.ui.components.Sleeper;
import eapli.base.usermanagement.application.ListUsersController;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

import java.util.List;

public class ListUsersUI extends AbstractListUI<SystemUser> {
    private ListUsersController theController = new ListUsersController();

    @Override
    public String headline() {
        return "List Users";
    }

    @Override
    protected String emptyMessage() {
        return "No data.";
    }

    @Override
    protected Iterable<SystemUser> elements() {
        return theController.allUsers();
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

    public boolean listEnabledUsers() {
        List<SystemUser> users = (List<SystemUser>) theController.enabledUsers();
        if (users.isEmpty()) {
            System.out.println("There are no enabled users in the system.");
            Sleeper.sleep(1000);
            return false;
        }
        printUsers(users);
        return true;
    }

    public boolean listDisabledUsers() {
        List<SystemUser> users = (List<SystemUser>) theController.disabledUsers();
        if (users.isEmpty()) {
            System.out.println("There are no disabled users in the system.");
            Sleeper.sleep(1000);
            return false;
        }
        printUsers(users);
        return true;
    }

    private void printUsers(List<SystemUser> users) {
        ListPrinter<SystemUser> printer = new ListPrinter<>("Users:", users);
        printer.showList();
        Sleeper.sleep(1000);
    }

}

