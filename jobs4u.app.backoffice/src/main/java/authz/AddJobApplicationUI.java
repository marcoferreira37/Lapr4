package authz;

import eapli.base.app.common.console.ui.components.Console;
import eapli.base.domain.JobApplication.AddJobApplicationController;
import eapli.base.domain.JobApplication.ApplicationID;
import eapli.base.domain.JobApplication.JobOpeningApplication;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class AddJobApplicationUI extends AbstractUI {
    private final AddJobApplicationController theController = new AddJobApplicationController();



    @Override
    protected boolean doShow() {

        JobOpening selectedJob = null;
        List<JobOpening> jobs = theController.listJobOpenings();

        for (int i = 0; i < jobs.size(); i++) {
            System.out.println((i + 1) + ". " + jobs.get(i));
        }

        int selectedOption = Console.readInteger("Escolha uma Job Opening: ");



        if (selectedOption >= 1 && selectedOption <= jobs.size()) {
            selectedJob = jobs.get(selectedOption - 1);
            System.out.println("Job Opening selecionada: " + selectedJob);
        } else {
            System.out.println("Opção inválida. Por favor, selecione um número válido.");
        }

        String file = Console.readLine("Insira o nome do arquivo: ");
        theController.readFile(file, selectedJob);

        return true;

    }
    @Override
    public String headline() {
        return "Register an Application";
    }



}
