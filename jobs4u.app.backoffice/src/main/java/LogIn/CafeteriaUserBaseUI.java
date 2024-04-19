//package LogIn;
//
//
//import eapli.framework.infrastructure.authz.application.AuthorizationService;
//import eapli.framework.infrastructure.authz.application.AuthzRegistry;
//import eapli.framework.presentation.console.AbstractUI;
//
//public abstract class CafeteriaUserBaseUI extends AbstractUI {
//
//    private final AuthorizationService authz = AuthzRegistry.authorizationService();
//
//    protected MyCafeteriaUserService svc = new MyCafeteriaUserService();
//
//    public String showBalance() {
//        return "CURRENT BALANCE OF YOUR USERCARD: " + svc.myBalance().toString();
//    }
//
//    @Override
//    public String headline() {
//
//        return authz.session().map(
//                        s -> "eCAFETERIA [ @" + s.authenticatedUser().identity() + " ] " + showBalance())
//                .orElse("eCAFETERIA [ ==Anonymous== ]");
//    }
//
//    @Override
//    protected void drawFormTitle(final String title) {
//        final String titleBorder = BORDER.substring(0, 2) + " " + title;
//        System.out.println(titleBorder);
//        drawFormBorder();
//    }
//}
