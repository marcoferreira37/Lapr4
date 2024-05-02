package CustomerManager;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.customer.ListJobOpeningController;


import java.time.LocalDateTime;

public class ListJobOpeningUI extends AbstractUI {

    private ListJobOpeningController theController = new ListJobOpeningController();

    @Override
    protected boolean doShow() {

        final String nameOrCode = Console.readLine("Name/Code of the Job Opening:");
        final LocalDateTime startDate = LocalDateTime.from(Console.readDate("Start Date:"));
        final LocalDateTime endDate = LocalDateTime.from(Console.readDate("End Date:"));

        System.out.println("=====================================================");
        System.out.println(theController.listJobOpenings(startDate, endDate, nameOrCode));
        return true;
    }


    @Override
    public String headline() {
        return "List Job Openings";
    }
}


