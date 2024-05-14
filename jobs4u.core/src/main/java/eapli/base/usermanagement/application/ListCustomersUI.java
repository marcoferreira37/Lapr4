package eapli.base.usermanagement.application;




import eapli.base.customer.Customer;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;





import java.util.List;

public class ListCustomersUI extends AbstractListUI<Customer> {
    private ListCustomerController theController = new ListCustomerController();

    @Override
    public String headline() {
        return "List Users";
    }

    @Override
    protected String emptyMessage() {
        return "No data.";
    }

    @Override
    protected Iterable<Customer> elements() {
        return theController.allCustomer();
    }

    @Override
    protected Visitor<Customer> elementPrinter() {
        return new SystemCustomerPrinter();
    }

    @Override
    protected String elementName() {
        return "User";
    }

    @Override
    protected String listHeader() {
        return String.format("#  %-10s", "EMAIL");
    }

    public boolean listEnabledUsers() {
        List<Customer> users = (List<Customer>) theController.enabledUsers();
        if (users.isEmpty()) {
            System.out.println("There are no enabled users in the system.");
//            Sleeper.sleep(1000);
            return false;
        }
        printUsers(users);
        return true;
    }

    public boolean listDisabledUsers() {
        List<Customer> users = (List<Customer>) theController.disabledUsers();
        if (users.isEmpty()) {
            System.out.println("There are no disabled users in the system.");
//            Sleeper.sleep(1000);
            return false;
        }
        printUsers(users);
        return true;
    }

    private void printUsers(List<Customer> users) {
        ListPrinter<Customer> printer = new ListPrinter<>("Users:", users);
        printer.showList();
//        Sleeper.sleep(1000);
    }

}

