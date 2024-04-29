package users.list;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.ListPrinter;
import eapli.base.app.common.console.ui.components.ListSelector;
import eapli.base.app.common.console.ui.components.Sleeper;
import eapli.base.clientusermanagement.domain.Jobs4UUser;
import eapli.base.clientusermanagement.repositories.Ijobs4UUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.ListAllUsersController;
import eapli.base.usermanagement.application.UserSessionService;

import java.util.List;

public class ListAllUsersUI extends AbstractUI {

    private final ListAllUsersController controller = new ListAllUsersController(PersistenceContext.repositories().jobs4UUsers());

    @Override
    protected boolean doShow() {

        ListSelector<String> selector = new ListSelector<>("Select an option:", List.of("All", "Enabled", "Disabled"));
        selector.showAndSelectWithExit();
        switch (selector.getSelectedOption()) {
            case 1:
                System.out.println();
                listAllUsers();
                break;
            case 2:
                System.out.println();
                listEnabledUsers();
                break;
            case 3:
                System.out.println();
                listDisabledUsers();
                break;
            default:
                break;
        }

        return false;
    }


    /**
     * Lists all users.
     */
    public void listAllUsers() {
        List<Jobs4UUser> users = (List<Jobs4UUser>) controller.allUsers();
        if (users.isEmpty()) {
            System.out.println("There are no users in the system.");
            Sleeper.sleep(1000);
            return;
        }
        printUsers(users);
    }

    /**
     * Lists enabled users.
     *
     * @return true if there are enabled users, false otherwise
     */
    public boolean listEnabledUsers() {
        List<Jobs4UUser> users = (List<Jobs4UUser>) controller.enabledUsers();
        if (users.isEmpty()) {
            System.out.println("There are no enabled users in the system.");
            Sleeper.sleep(1000);
            return false;
        }
        printUsers(users);
        return true;
    }

    /**
     * Lists disabled users.
     *
     * @return true if there are disabled users, false otherwise
     */
    public boolean listDisabledUsers() {
        List<Jobs4UUser> users = (List<Jobs4UUser>) controller.disabledUsers();
        if (users.isEmpty()) {
            System.out.println("There are no disabled users in the system.");
            Sleeper.sleep(1000);
            return false;
        }
        printUsers(users);
        return true;
    }

    private void printUsers(List<Jobs4UUser> users) {
        ListPrinter<Jobs4UUser> printer = new ListPrinter<>("Users:", users);
        printer.showList();
        Sleeper.sleep(1000);
    }

    @Override
    public String headline() {
        return "List Users";
    }
}
