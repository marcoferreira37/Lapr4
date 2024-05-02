package authz;


import eapli.base.app.common.console.ui.components.ListPrinter;
import eapli.base.app.common.console.ui.components.Sleeper;
import eapli.base.customer.Customer;
import eapli.base.usermanagement.application.ListCustomerController;
import eapli.framework.actions.Action;

import java.util.List;

public class ListCustomerManagerActions implements Action {



    @Override
    public boolean execute() {
        return new ListCustomersUI().show();
    }


}
