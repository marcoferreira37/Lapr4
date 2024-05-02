package authz;

import eapli.framework.actions.Action;

import java.util.List;

public class ListCustomerManagerActions implements Action {



    @Override
    public boolean execute() {
        return new ListCustomersUI().show();
    }


}
