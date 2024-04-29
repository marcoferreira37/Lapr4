package users.register.LanguageEngineer;

import eapli.framework.actions.Action;

public class RegisterLanguageEngineerAction implements Action {
        @Override
        public boolean execute() {
            return new RegisterLanguageEngineerUI().show();
        }

}
