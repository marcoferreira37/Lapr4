package users.register.CostumerManager;

import eapli.framework.actions.Action;

public class RegisterCostumerManagerAction implements Action {

    @Override
    public boolean execute() {
        return new RegisterCostumerManagerUI().show();
    }

}
