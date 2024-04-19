package LogIn;

import javax.management.relation.Role;

public interface CredentialHandler {
    boolean authenticated(String username, String password, Role onlyWithThis);

}
