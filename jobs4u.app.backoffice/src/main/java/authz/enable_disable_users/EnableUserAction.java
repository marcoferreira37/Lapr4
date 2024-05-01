package authz.enable_disable_users;

import eapli.framework.actions.Action;

public class EnableUserAction implements Action {
    @Override
    public boolean execute() {
        return new EnableUserUI().show();
    }
}
