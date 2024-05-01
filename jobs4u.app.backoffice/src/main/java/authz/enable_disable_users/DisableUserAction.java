package authz.enable_disable_users;

import eapli.framework.actions.Action;

public class DisableUserAction implements Action {
    @Override
    public boolean execute() {
        return new DisableUserUI().show();
    }
}
