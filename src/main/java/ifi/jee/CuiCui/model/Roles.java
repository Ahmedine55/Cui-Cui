package ifi.jee.CuiCui.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Roles {
    @Id
    String role;

    public Roles() {
    }

    public Roles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

