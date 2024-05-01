package users.register.CostumerManager;

import eapli.base.app.common.console.ui.components.Console;
import eapli.base.app.common.console.ui.components.ListSelector;
import eapli.base.customer.AddJobOpeningController;
import eapli.base.domain.jobOpening.ContractType;
import eapli.base.domain.jobOpening.Mode;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class AddJobOpeningUI extends AbstractUI {

    private final AddJobOpeningController addjobOpeningController = new AddJobOpeningController();




    @Override
    protected boolean doShow() {
        final String description = Console.readLine("Description:");
        final int vacanciesNumber = Console.readInteger("Vacancies Number:");
        final String address = Console.readLine("Address:");

        System.out.println("Select the mode of the job opening");
        List<Mode> modes = List.of(Mode.values());
        ListSelector<Mode> list = new ListSelector<>("", modes);
        list.showAndSelectWithExit();
        Mode mode = list.getSelectedElement();

        System.out.println("Select the contract type of the job opening");
        List<ContractType> types = List.of(ContractType.values());
        ListSelector<ContractType> listContracType = new ListSelector<>("", types);
        listContracType.showAndSelectWithExit();
        ContractType ct = listContracType.getSelectedElement();

        final String titleOrFunction = Console.readLine("Title or Function:");

        final int companyId = Console.readInteger("Company ID: ");
        System.out.println("=====================================================");
        boolean confirmation = false;
        while (!confirmation) {
            System.out.println("Description: " + description);
            System.out.println("Address: " + address);
            System.out.println("Mode: " + mode);
            System.out.println("Contract Type: " + ct);
            System.out.println("Title or Function: " + titleOrFunction);
            System.out.println("Vacancies Number: " + vacanciesNumber);
            System.out.println("Company ID: " + companyId);

            confirmation = Console.readBoolean("Are you sure you want to add this job opening? (True/False): ");
        }

        addjobOpeningController.addJobopening(description, address, mode, ct, titleOrFunction, vacanciesNumber, companyId);
        return true;
    }





    @Override
    public String headline() {
        return "Add a Job Opening";
    }
}
