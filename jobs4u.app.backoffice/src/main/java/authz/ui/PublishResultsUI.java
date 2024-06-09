package authz.ui;

import eapli.base.domain.candidate.Candidate;
import eapli.base.domain.jobOpening.JobOpening;
import eapli.base.usermanagement.application.controllers.PublishResultsController;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.List;

public class PublishResultsUI extends AbstractUI{
    //todo esta ui deixa de existir
    private PublishResultsController controller = new PublishResultsController();
    @Override
    protected boolean doShow() {
        // 1. Get the list of JobOpenings
        List<JobOpening> jobOpenings = controller.getJobOpenings();

        // 2. Display the list to the user and ask them to select a JobOpening
        SelectWidget<JobOpening> selector = new SelectWidget<>("Job Openings:", jobOpenings);
        selector.show();
        JobOpening selectedJobOpening = selector.selectedElement();

        if (selectedJobOpening != null) {
            // 3. Publish the results
            SystemUser fromUser = controller.getLoggedInUser();
            List<Candidate> candidates = controller.getRankedApplications(selectedJobOpening);
//            controller.publishResults(fromUser, candidates, selectedJobOpening);

            // 4. Inform the user about the success of the operation
            System.out.println("Job Opening results published successfully.");
        } else {
            System.out.println("No Job Opening selected.");
        }

        return false;
    }
    @Override
    public String headline() {
        return "Publish Job Opening Results";
    }
}
