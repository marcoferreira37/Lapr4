package eapli.base.protocol.dto;

import eapli.framework.infrastructure.authz.domain.model.Role;

import java.io.Serializable;

public class LoginDTO implements Serializable {

    public String username;

    public String password;

    public Role[] roles;

    public LoginDTO(String username, String password, Role... roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public LoginDTO() {
    }

    public String findUsername() {
        return username;
    }

    public String findPassword() {
        return password;
    }


    public Role[] findRoles() {
        return roles;
    }
}
