
import authz.UploadTextFileUI;
import authz.ui.ListAllApplicationsForJobOpeningUI;
import authz.ui.ListJobOpeningUI;
import authz.enable_disable_users.DisableCandidateUI;
import authz.enable_disable_users.EnableCandidateUI;
import authz.registerusers.AddUserAction;
import authz.ui.*;
import clientuser.AcceptRefuseSignupRequestAction;
import clientuser.ListCustomerManagerActions;
import eapli.base.Application;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ShowMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;
import authz.listusers.ListUsersAction;
import authz.enable_disable_users.DisableUserAction;
import authz.enable_disable_users.EnableUserAction;
import authz.ui.ListAllApplicationsOfCandidateUI;
import authz.ui.ListAllDataOfCandidateUI;
import authz.ui.AddJobOpeningUI;
import authz.ui.UpdateJobOpeningUI;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;

    private static final int DEACTIVATE_USER_OPTION = 3;

    private static final int ACTIVATE_USER_OPTION = 4;
    private static final int ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION = 5;

    // SETTINGS
    private static final int SET_KITCHEN_ALERT_LIMIT_OPTION = 1;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int SETTINGS_OPTION = 4;

    private static final String SEPARATOR_LABEL = "--------------";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.ADMIN)) {
            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            final Menu customerManagerMenu = buildCustomerManagerMenu();
            mainMenu.addSubMenu(3, customerManagerMenu);
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);

        }
        if(authz.isAuthenticatedUserAuthorizedTo(BaseRoles.OPERATOR)){
            final Menu operatorMenu = buildOperatorMenu();
            mainMenu.addSubMenu(USERS_OPTION, operatorMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
        }
        if(authz.isAuthenticatedUserAuthorizedTo(BaseRoles.CUSTOMER_MANAGER)){
            final Menu CustomerManagerMenu = buildCustomerManagerMenu();
            mainMenu.addSubMenu(USERS_OPTION, CustomerManagerMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildOperatorMenu() {
        final Menu menu = new Menu("Operator:");

        menu.addItem(1, "Regist a candidate", new AddCandidateUI()::show);
        menu.addItem(2, "List all candidates", new ListCandidatesUI()::show);
        menu.addItem(3, "Export template for Requirements Specification", new GenerateTemplateUI()::show);
        menu.addItem(4, "Register an application", new AddJobApplicationUI()::show);
        menu.addItem(5, "Enable a candidate", new EnableCandidateUI()::show);
        menu.addItem(6, "Disable a candidate", new DisableCandidateUI()::show);
        menu.addItem(7, "Update text file", new UploadTextFileUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }
    private Menu buildCustomerManagerMenu() {
        final Menu menu = new Menu("Customer Manager >");

        menu.addItem(1, "Register a customer", new AddCustomerUI()::show);
        menu.addItem(2, "List all customers", new ListCustomerManagerActions());
        menu.addItem(3, "Add a job opening", new AddJobOpeningUI()::show);
        menu.addItem(4, "List all info of a candidate", new ListAllDataOfCandidateUI()::show);
        menu.addItem(5, "List All Applications of a candidate", new ListAllApplicationsOfCandidateUI()::show);
        menu.addItem(6, "List All Applications for a Job Opening", new ListAllApplicationsForJobOpeningUI()::show);
        menu.addItem(7, "List Job Openings", new ListJobOpeningUI()::show);
        menu.addItem(8, "Update a Job Opening", new UpdateJobOpeningUI()::show);
        menu.addItem(9, "Rank Applications ", new RankApplicationUI()::show);
        menu.addItem(10,"Record the time and the date for an interview", new RecordInterviewUI()::show);
        menu.addItem(11,"Execute interview grading", new InterviewGradingUI()::show);
        menu.addItem(12, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }


    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(SET_KITCHEN_ALERT_LIMIT_OPTION, "Set kitchen alert limit",
                new ShowMessageAction("Not implemented yet"));
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildUsersMenu() {
        final Menu menu = new Menu("Admin");

        menu.addItem(ADD_USER_OPTION, "Register a User", new AddUserAction());
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Disable a User", new DisableUserAction());
        menu.addItem(ACTIVATE_USER_OPTION, "Enable a User", new EnableUserAction());
        menu.addItem(ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION, "Accept/Refuse Signup Request", new AcceptRefuseSignupRequestAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

}
