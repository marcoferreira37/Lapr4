package CustomerManager;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.customer.ListJobOpeningController;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class ListJobOpeningUI extends AbstractUI {

    private ListJobOpeningController theController = new ListJobOpeningController();
    private final String FORMAT = "dd/MM/yyyy";

    @Override
    protected boolean doShow() {

        final String nameOrCode = Console.readLine("Name/Code of the Job Opening:");
        final Date startDate;
        final Date endDate;
        try {
            startDate = new SimpleDateFormat(FORMAT).parse(Console.readLine("Start Date:"));
            endDate = new SimpleDateFormat(FORMAT).parse(Console.readLine("End Date:"));
            System.out.println("=====================================================");
            System.out.println(theController.listJobOpenings(startDate, endDate, nameOrCode));
        } catch (Exception e) {
            System.out.println("Pelo menos tenta acertar nas datas?");
            e.printStackTrace();
        }

        return true;
    }


    @Override
    public String headline() {
        return "List Job Openings";
    }
}


