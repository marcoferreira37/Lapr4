package authz;

import eapli.base.clientusermanagement.application.GenerateTemplateController;
import eapli.framework.presentation.console.AbstractUI;

public class GenerateTemplateUI extends AbstractUI {

    GenerateTemplateController controller = new GenerateTemplateController();

    @Override
    protected boolean doShow() {
        return false;
    }

    @Override
    public String headline() {
        return "Generate Template";
    }
}
