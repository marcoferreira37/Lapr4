package users.register.CostumerManager;

import eapli.base.app.common.console.ui.components.Console;
import eapli.base.app.common.console.ui.components.ListSelector;
import eapli.base.customer.AddJobOpeningController;
import eapli.base.domain.jobOpening.ContractType;
import eapli.base.domain.jobOpening.Mode;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.CompanyRepository;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class AddJobOpeningUI extends AbstractUI {

    private final AddJobOpeningController addjobOpeningController = new AddJobOpeningController();

    @Override
    protected boolean doShow() {

        String description = Console.readLine("Description:");
        while (addjobOpeningController.checkDescription(description) ){
            description = Console.readLine("Invalid Description!! Try again!\n \nDescription:");
        }

        String vacanciesNumberStr = Console.readLine("Vacancies Number:");
        while (addjobOpeningController.checkVacanciesNumber(vacanciesNumberStr)){
            vacanciesNumberStr = Console.readLine("Invalid Vacancies Number!! Try again!\n( Numbers Only )\n \nVacancies Number:");
        }

        String address = Console.readLine("Address:");
        while (addjobOpeningController.checkAddress(address) ){
            address = Console.readLine("Invalid Address!! Try again!\n \nAddress:");
        }


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

        String titleOrFunction = Console.readLine("Title or Function:");
        while (addjobOpeningController.checkTittleOrFunction(titleOrFunction) ){
            titleOrFunction = Console.readLine("Invalid Title or Function!! Try again!\n \nTitle or Function:");
        }

        listComapnies();

        String companyIdStr = Console.readLine("Company ID: ");
        while (addjobOpeningController.checkCompanyID(companyIdStr)) {
            companyIdStr = Console.readLine("Invalid Company ID!! Try again!\n( Numbers Only )\n \nCompany ID:");
        }



        System.out.println("=====================================================");
        boolean confirmation = false;
        while (!confirmation) {
            System.out.println("Description: " + description);
            System.out.println("Address: " + address);
            System.out.println("Mode: " + mode);
            System.out.println("Contract Type: " + ct);
            System.out.println("Title or Function: " + titleOrFunction);
            System.out.println("Vacancies Number: " + vacanciesNumberStr);
            System.out.println("Company ID: " + companyIdStr);

            confirmation = Console.readBoolean("Are you sure you want to add this job opening? (True/False): ");
        }

        int vacanciesNumber = Integer.parseInt(vacanciesNumberStr);
        int companyId = Integer.parseInt(companyIdStr);
        addjobOpeningController.addJobopening(description, address, mode, ct, titleOrFunction, vacanciesNumber, companyId);
        return true;
    }

    private void listComapnies() {
        System.out.println("Companies:");
        CompanyRepository companyRepository = PersistenceContext.repositories().companyRepository();
        companyRepository.findAll().forEach(company -> System.out.println(company.toString()));
    }


    @Override
    public String headline() {
        return "Add a Job Opening";
    }
}
