package users.register;

import eapli.base.app.common.console.ui.menu.Menu;
import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.menu.MenuRenderer;
import eapli.base.clientusermanagement.application.RegisterUserController;
import eapli.framework.infrastructure.authz.domain.model.Role;
import users.register.CostumerManager.RegisterCostumerManagerAction;
import users.register.LanguageEngineer.RegisterLanguageEngineerAction;
import users.register.Operator.RegisterOperatorAction;



public class RegisterUserUI extends AbstractUI {

    private final RegisterUserController controller;

    {
        controller = new RegisterUserController();
    }

    protected boolean doShow() {
            final Menu menu = buildRolesSelectionMenu();
            final var renderer = new MenuRenderer(menu);
            return renderer.render(MenuRenderer.PullOutActions.BACK.message());
        }

    private Menu buildRolesSelectionMenu() {
        final Menu rolesSelectionMenu = new Menu();
        // Get the roles
        Role[] roles = controller.existingRoles();
        // Add the roles to the menu
        rolesSelectionMenu.addItem(1, "Register " + getPrintableRole(roles[0]), new RegisterOperatorAction());
        rolesSelectionMenu.addItem(2, "Register " + getPrintableRole(roles[1]), new RegisterCostumerManagerAction());
        rolesSelectionMenu.addItem(3, "Register " + getPrintableRole(roles[2]), new RegisterLanguageEngineerAction());


        // add the back option

        return rolesSelectionMenu;
    }

    private String getPrintableRole(Role role) {
        return role.toString().substring(0, 1).toUpperCase() + role.toString().substring(1).toLowerCase();
    }

    @Override
    public String headline() {
        return "Register User";
    }

}