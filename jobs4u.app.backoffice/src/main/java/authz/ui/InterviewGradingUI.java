package authz.ui;

import eapli.base.app.common.console.ui.components.AbstractUI;

public class InterviewGradingUI extends AbstractUI {
    @Override
    protected boolean doShow() {

        return true;
    }

    @Override
    public String headline() {
        return "Interview Grading";
    }
}
