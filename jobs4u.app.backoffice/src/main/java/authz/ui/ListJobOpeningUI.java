package authz.ui;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.customer.Criteria;
import eapli.base.filter.jobOpening.JobOpeningFilteringStrategy;
import eapli.base.usermanagement.application.controllers.ListJobOpeningController;
import eapli.base.domain.jobOpening.JobOpening;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class ListJobOpeningUI extends AbstractUI {

    private final ListJobOpeningController theController = new ListJobOpeningController();
    private final String FORMAT = "dd/MM/yyyy";

    @Override
    protected boolean doShow() {
        try {
            System.out.println("=====================================================");
            System.out.println("List Job Openings");

            List<JobOpeningFilteringStrategy> strategies = theController.filteringStrategies();
            if (strategies.isEmpty()) {
                System.out.println("No filtering strategies available.");
                return true;
            }

            int index = 0;
            for (JobOpeningFilteringStrategy strategy : strategies) {
                System.out.println(index + " - " + strategy.description());
                index++;
            }

            int strategyIndex;
            do {
                strategyIndex = Console.readInteger("Select strategy:");
            } while (strategyIndex < 0 || strategyIndex >= strategies.size());

            final JobOpeningFilteringStrategy strategy = strategies.get(strategyIndex);

            List<Criteria<?>> strategyCriteria = theController.newCriteria(strategy);

            for (Criteria<?> criteria : strategyCriteria) {
                String value;
                do {
                    value = Console.readLine("Insert " + criteria.description().toLowerCase() + ": ");
                } while (!isValidInput(criteria, value));

                Class<?> type = criteria.getGenericType();
                if (type == String.class) {
                    ((Criteria<String>) criteria).value(value);
                } else if (type == LocalDateTime.class) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT);
                    LocalDate date = LocalDate.parse(value, formatter);
                    ((Criteria<LocalDateTime>) criteria).value(date.atStartOfDay());
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
            System.out.println("Error displaying the list of Job Openings");
            e.printStackTrace();
            return true;
        }
        return false;  // Wants to exit
    }

    @Override
    public String headline() {
        return "List Job Openings";
    }

    /**
     * Verifies if the input is valid
     *
     * @param criteria criteria
     * @param value    value
     * @return true if the input is valid, false otherwise
     */
    private boolean isValidInput(Criteria<?> criteria, String value) {
        if (criteria.getGenericType() == LocalDateTime.class) {
            return isValidDateFormat(value, FORMAT);
        } else if (criteria.getGenericType() == Integer.class) {
            try {
                int intValue = Integer.parseInt(value);
                return intValue >= 0;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifies if the date is in the correct format
     *
     * @param date   date
     * @param format format
     * @return true if the date is in the correct format, false otherwise
     */
    private boolean isValidDateFormat(String date, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.setLenient(false);
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}



