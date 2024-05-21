package authz;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.customer.RankApplicationController;
import eapli.base.domain.jobOpening.JobOpening;

import java.util.List;

public class RankApplicationUI extends AbstractUI {


    private final RankApplicationController theController = new RankApplicationController();

    @Override
    protected boolean doShow() {
        return false;
    }

    @Override
    public String headline() {
        return "Rank Application";
    }

    public List<JobOpening> listAllJobOpenings() {
        return theController.allRankableOpenings();
    }
}
