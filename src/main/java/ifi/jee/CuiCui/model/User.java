package ifi.jee.CuiCui.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @Column(unique=true)
    private String username;
    private String password;
    @ManyToMany
    private List<User> amis;
    @OneToMany
    private List<Message> messages;
    @ManyToMany
    private List<Hashtag> abonnements;

    public User() {
    }

    public User(String nom, String username, String password) {
        this.nom = nom;
        this.username = username;
        this.password = password;
    }

    public User(String nom, String username, String password, List<User> amis, List<Hashtag> abonnements) {
        this.nom = nom;
        this.username = username;
        this.password = password;
        this.amis = amis;
        this.abonnements = abonnements;
    }

    public User(String nom, String username, String password, List<User> amis, List<Message> messages, List<Hashtag> abonnements) {
        this.nom = nom;
        this.username = username;
        this.password = password;
        this.amis = amis;
        this.messages = messages;
        this.abonnements = abonnements;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getAmis() {
        return amis;
    }

    public void setAmis(List<User> amis) {
        this.amis = amis;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Hashtag> getAbonnements() {
        return abonnements;
    }

    public void setAbonnements(List<Hashtag> abonnements) {
        this.abonnements = abonnements;
    }
}
