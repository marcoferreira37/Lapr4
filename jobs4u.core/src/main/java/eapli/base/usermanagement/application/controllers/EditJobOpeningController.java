package eapli.base.usermanagement.application.controllers;

import eapli.base.domain.Editable;
import eapli.base.domain.jobOpening.ContractType;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.domain.jobOpening.Mode;
import eapli.base.usermanagement.application.services.JobOpeningService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;

import java.util.ArrayList;
import java.util.List;

public class EditJobOpeningController {
    private AuthorizationService autzService = AuthzRegistry.authorizationService();
    private JobOpeningService service = new JobOpeningService();
    private JobOpening jobOpening;

    List<Editable> edits = new ArrayList<>();
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public EditJobOpeningController() {
        autzService.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER, BaseRoles.POWER_USER);
    }

    public boolean validateJobReference(String inputJobReference) {
         return service.existsJobReference(inputJobReference);
    }

    public void transformJobReferenceToJobOpening(String inputJobReference){
       jobOpening = service.jobReferenceToJobOpening(inputJobReference);
    }

    public String editString(Editable edit) {
        do {
            String s = Console.readLine("New " + edit + " :");
            if (Console.readBoolean("Do you confirm this input? (y/n)")){
            if (!s.isEmpty() && s.length() <= 255) {
                return s;
            } else {
                System.out.println(ANSI_RED + "Invalid input!" + ANSI_RESET);
            }
         }
        } while (true);

    }

    public int editNumber(Editable atribute) {
        return Console.readInteger("New " + atribute + " : ");
    }

    public void editDescripion() {
        String newDescription = editString(Editable.Description);
        jobOpening = service.editDescription(jobOpening, newDescription);
    }

    public void editAddress() {
        jobOpening = service.editAddress(jobOpening, editString(Editable.Address));
    }

    public void editMode() {
        Mode mode = (Mode) editEnum(Editable.Mode, Mode.ONSITE);
        jobOpening = service.editMode(jobOpening, mode);
    }

    private Enum editEnum(Editable editable, Enum e) {
        int option;
        int index = 1;
        List<Enum> modes = List.of(e.getClass().getEnumConstants());
        for (Enum m : modes) {
            System.out.println(index + " - " + m);
            index++;
        }
        option = Console.readInteger("Choose a " + editable.toString() + ": ");
        return modes.get(option - 1);
    }

    public void editContractType() {
        ContractType c = (ContractType) editEnum(Editable.Contract_Type, ContractType.FULL_TIME);
        jobOpening = service.editContractType(jobOpening, c);
    }

    public void editTitle() {
        String t = editString(Editable.Title_Or_Function);
        jobOpening = service.editTitle(jobOpening, t);
    }

    public void editVacanciesNumber() {
        int n = editNumber(Editable.Vacancies_Number);
        jobOpening = service.editNumber(jobOpening, n);
    }

    public String viewJobOpening() {
        return jobOpening.toString();
    }
    public boolean addEdits() {
        for (Editable edit : Editable.values()) {
            if (Console.readBoolean("Do you want to update " + edit.toString() + "? (y/n)")) {
                edits.add(edit);
            }
        }
        return !edits.isEmpty();
    }

    public void cycleEdits() {
        if (edits.isEmpty()) {
            return;
        }
        for (Editable edit : edits) {
            switch (edit) {
                case Description:
                    editDescripion();
                    break;
                case Address:
                    editAddress();
                case Mode:
                    editMode();
                case Contract_Type:
                    editContractType();
                case Title_Or_Function:
                    editTitle();
                case Vacancies_Number:
                    editVacanciesNumber();
            }
        }
    }
}
