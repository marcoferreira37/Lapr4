package clientuser;


import authz.ui.DeactivateUserUI;
import eapli.framework.actions.Action;

public class DeactivateUserAction implements Action {

    @Override
    public boolean execute() {
        return new DeactivateUserUI().show();
    }
}

