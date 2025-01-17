package authz.ui;

import eapli.base.app.common.console.ui.components.Console;
import eapli.base.usermanagement.application.controllers.AddJobApplicationController;
import eapli.base.domain.jobApplication.JobOpeningApplication;
import eapli.framework.presentation.console.AbstractUI;

public class AddJobApplicationUI extends AbstractUI {
    private final AddJobApplicationController theController = new AddJobApplicationController();



    @Override
    protected boolean doShow() {


        String file = Console.readLine("Insira o nome do arquivo: ");
        JobOpeningApplication ja = theController.readFile(file);
        System.out.println("Job Application adicionada com sucesso: " + ja);
        return true;

    }
    @Override
    public String headline() {
        return "Register an Application";
    }



}
