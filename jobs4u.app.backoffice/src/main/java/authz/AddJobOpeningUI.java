package authz;

import eapli.base.app.common.console.ui.components.Console;
import eapli.base.domain.company.Company;
import eapli.base.domain.jobOpening.Mode;
import eapli.base.jobOpeningApp.AddJobOpeningController;

public class AddJobOpeningUI {

    private AddJobOpeningController controller = new AddJobOpeningController();


    public void show() {
        System.out.printf("===========Add a Job Opening===========\n\n");
        String companyName = System.console().readLine("Company Name: ");
        String address = System.console().readLine("Address: ");
        String title = System.console().readLine("Title: ");
        String description = System.console().readLine("Description: ");
        Mode mode = showModes();
        int vacancies = Console.readInteger("Vacancies: ");
        String jobReferenceIndex = jobReferenceCalculation(companyName);
        controller.addJobOpening(companyName, address, title, description, mode, vacancies, jobReferenceIndex);
    }

    private String jobReferenceCalculation(String companyName) {
        String jobReference;
        if (companyName.length() < 3) {
            jobReference= companyName.toUpperCase();
            for (int i = companyName.length(); i < 3; i++) {
                jobReference += "X";
            }
        }
        else {
            jobReference = companyName.substring(0, 3).toUpperCase();
        }
        return jobReference;
    }

    public Mode showModes(){
        System.out.printf("===========Modes===========\n\n");
        System.out.printf("1. ONSITE\n");
        System.out.printf("2. REMOTE\n");
        System.out.printf("3. HYBRID\n");
        int mode = Console.readInteger("Choose a mode: ");
        switch (mode) {
            case 1:
                return Mode.ONSITE;
            case 2:
                return Mode.REMOTE;
            case 3:
                return Mode.HYBRID;
            default:
                System.out.println("Invalid option");
                return showModes();
        }
    }
}
