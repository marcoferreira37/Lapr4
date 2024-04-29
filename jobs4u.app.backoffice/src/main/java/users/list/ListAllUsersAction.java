package users.list;

import eapli.framework.actions.Action;

public class ListAllUsersAction implements Action {
    @Override
    public boolean execute() {
        return new ListAllUsersUI().show();
    }
}
