package users.register.Operator;

import eapli.framework.actions.Action;

public class RegisterOperatorAction implements Action {

    @Override
    public boolean execute() {
        return new RegisterOperatorUI().show();
    }


}
