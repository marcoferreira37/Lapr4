package users.register;

import eapli.framework.actions.Action;
import users.register.Operator.RegisterOperatorUI;

public class RegisterUserAction implements Action {
    @Override
    public boolean execute() {
        return new RegisterUserUI().show();
    }
}
