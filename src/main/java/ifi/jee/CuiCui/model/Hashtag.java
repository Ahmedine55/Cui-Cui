package ifi.jee.CuiCui.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @ManyToMany
    private List<User> users;

    public Hashtag() {
    }

    public Hashtag(String nom) {
        this.nom = nom;
    }

    public Hashtag(String nom, List<User> users) {
        this.nom = nom;
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
