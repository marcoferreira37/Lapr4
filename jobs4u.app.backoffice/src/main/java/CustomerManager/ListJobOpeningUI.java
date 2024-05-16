package CustomerManager;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.customer.Criteria;
import eapli.base.customer.JobOpeningFilteringStrategy;
import eapli.base.customer.ListJobOpeningController;
import eapli.base.domain.jobOpening.JobOpening;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class ListJobOpeningUI extends AbstractUI {

    private ListJobOpeningController theController = new ListJobOpeningController();
    private final String FORMAT = "dd/MM/yyyy";

    @Override
    protected boolean doShow() {

        try {
            System.out.println("=====================================================");
            System.out.println("List Job Openings");

            int index = 0;
            for (JobOpeningFilteringStrategy strategy : theController.filteringStrategies()) {
                System.out.println(index + " - " + strategy.description());
                index++;
            }

            final int strategyIndex = Console.readInteger("Select strategy:");

            final JobOpeningFilteringStrategy strategy = theController.filteringStrategy(strategyIndex);

            List<Criteria<?>> strategyCriteria = strategy.criteria();

            for (Criteria<?> criteria : strategyCriteria) {
                String value = Console.readLine("Insert " + criteria.description().toLowerCase() + ": ");

                Class<?> type = criteria.getGenericType();
                if (type == String.class) {
                    ((Criteria<String>) criteria).value(value);
                } else if (type == LocalDateTime.class) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate date = LocalDate.parse(value, formatter);
                    ((Criteria<LocalDateTime>) criteria).value(date.atStartOfDay()); // ver o parse
                } else {
                    throw new RuntimeException("Unknown criteria type");
                }
            }

            List<JobOpening> jobOpenings = theController.listFilteredJobOpenings(strategy, strategyCriteria);

            for (JobOpening job : jobOpenings) {
                System.out.println(job);
            }

            System.out.println("=====================================================");
        } catch (Exception e) {
            System.out.println("Erro a mostrar a lista de Job Openings");
            e.printStackTrace();


            final String nameOrCode = Console.readLine("Name/Code of the Job Opening:");
            final Date startDate;
            final Date endDate;
            try {
                startDate = new SimpleDateFormat(FORMAT).parse(Console.readLine("(Input in this format dd/mm/yyyy)\nStart Date: "));
                endDate = new SimpleDateFormat(FORMAT).parse(Console.readLine("(Input in this format dd/mm/yyyy)\nEnd Date:"));
                System.out.println("=====================================================");
//            System.out.println(theController.listJobOpenings(startDate, endDate, nameOrCode));
            } catch (Exception exception) {
                System.out.println("Pelo menos tenta acertar nas datas?");
                e.printStackTrace();
            }

            return true;
        }
        return this.doShow();  // Wants to exit
    }

    @Override
    public String headline() {
        return "List Job Openings";
    }
}



