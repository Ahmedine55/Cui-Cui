package ifi.jee.CuiCui.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class users_roles implements Serializable {
    @Id
    String username;
    @Id
    String roles;

    public users_roles() {
    }

    public users_roles(String username, String roles) {
        this.username = username;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
