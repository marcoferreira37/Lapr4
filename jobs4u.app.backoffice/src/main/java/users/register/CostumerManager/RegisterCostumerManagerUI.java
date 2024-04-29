package users.register.CostumerManager;

import eapli.base.app.common.console.ui.components.AbstractUI;
import eapli.base.app.common.console.ui.components.Console;
import eapli.base.app.common.console.ui.components.Sleeper;
import eapli.base.clientusermanagement.domain.jobs4uuserbuilders.Jobs4UUserBuilderFactory;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.register.RegisterCostumerManagerController;
import eapli.base.usermanagement.application.register.RegisterOperatorController;

public class RegisterCostumerManagerUI extends AbstractUI {

    private final RegisterCostumerManagerController controller = new RegisterCostumerManagerController(PersistenceContext.repositories().
            jobs4UUsers(), new Jobs4UUserBuilderFactory());


    @Override
    protected boolean doShow() {
        System.out.println("Please provide the Costumer Manager details\n");
        try {
            final String username = Console.readNonEmptyLine("Username: ",
                    "Please provide a username");
            System.out.println("_________________________________________");
            final String password = Console.readPassword("Password: ", "Please provide a password");
            System.out.println("_________________________________________");
            final String name = Console.readNonEmptyLine("Name: ", "Please provide a name");
            System.out.println("_________________________________________");
            final String lastName = Console.readLine("Last Name: ");
            System.out.println("_________________________________________");
            final String email = Console.readLine("Email: ");


            controller.registerCostumerManager(username, password, name, lastName, email);
            System.out.println();
        } catch (IllegalArgumentException e) {
            if (e.getMessage() == null) {
                errorMessage("Error creating the user. Please make  that you properly respect the password policy: "
                        + "6 characters minimum, at least one Capital letter, one number.");
            } else {
                errorMessage(e.getMessage());
            }
            Sleeper.sleep(1700);
            return false;
        } catch (Exception e) {
            errorMessage("Error registering manager! Common cause: Email already exists!");
            Sleeper.sleep(1700);
            return false;
        }
        successMessage("Costumer Manager registered successfully");
        Sleeper.sleep(1700);
        return false;
    }

    @Override
    public String headline() {
        return "Register Costumer Manager";
    }
}