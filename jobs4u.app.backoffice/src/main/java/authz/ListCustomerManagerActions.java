package authz;


import eapli.framework.actions.Action;

public class ListCustomerManagerActions implements Action {

    @Override
    public boolean execute() {
        return new AddCustomerUI().show();
    }
}
