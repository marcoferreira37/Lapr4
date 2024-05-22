package clientuser;

import authz.ui.ListCustomersUI;
import eapli.framework.actions.Action;

public class ListCustomerManagerActions implements Action {



    @Override
    public boolean execute() {
        return new ListCustomersUI().show();
    }


}
