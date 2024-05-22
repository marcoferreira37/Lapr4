package authz;

import eapli.base.app.common.console.ui.components.Console;
import eapli.base.domain.JobApplication.AddJobApplicationController;
import eapli.base.domain.JobApplication.ApplicationID;
import eapli.base.domain.JobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;

import java.util.List;

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
