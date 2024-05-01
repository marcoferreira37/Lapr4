package authz;

import eapli.base.customer.AddJobOpeningController;
import eapli.framework.presentation.console.AbstractUI;

public class AddJobOpeningUI extends AbstractUI {


    @Override
    protected boolean doShow() {
        return false;
        //
    }

    @Override
    public String headline() {
        return "Add Job Opening";
    }
}
