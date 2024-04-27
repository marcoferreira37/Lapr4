import eapli.base.infrastructure.authz.AuthenticationCredentialHandler;
import eapli.base.app.common.console.presentation.authz.LoginUI;
import eapli.base.app.common.console.BaseApplication;
import eapli.base.clientusermanagement.application.eventhandlers.NewUserRegisteredFromSignupWatchDog;
import eapli.base.clientusermanagement.domain.events.NewUserRegisteredFromSignupEvent;
import eapli.base.clientusermanagement.domain.events.SignupAcceptedEvent;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.eventhandlers.SignupAcceptedWatchDog;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.pubsub.EventDispatcher;


/**
 *
 *
 */
@SuppressWarnings("squid:S106")
public final class BaseBackoffice extends BaseApplication {

    /**
     * avoid instantiation of this class.
     */
    private BaseBackoffice() {
    }

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(final String[] args) {

        AuthzRegistry.configure(PersistenceContext.repositories().users(),
                new BasePasswordPolicy(), new PlainTextEncoder());

        new BaseBackoffice().run(args);
    }

    @Override
    protected void doMain(final String[] args) {
        LoginUI loginUI = new LoginUI(new AuthenticationCredentialHandler(), BaseRoles.OPERATOR, BaseRoles.ADMIN,BaseRoles.POWER_USER, BaseRoles.CUSTOMER_MANAGER);
        if (loginUI.show()) {
            final MainMenu menu = new MainMenu();
            menu.mainLoop();
        }
    }

    @Override
    protected String appTitle() {
        return "Base Back Office";
    }

    @Override
    protected String appGoodbye() {
        return "Base Back Office";
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void doSetupEventHandlers(final EventDispatcher dispatcher) {
        dispatcher.subscribe(new NewUserRegisteredFromSignupWatchDog(),
                NewUserRegisteredFromSignupEvent.class);
        dispatcher.subscribe(new SignupAcceptedWatchDog(), SignupAcceptedEvent.class);
    }
}

