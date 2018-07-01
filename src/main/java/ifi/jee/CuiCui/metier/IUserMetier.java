package ifi.jee.CuiCui.metier;

import ifi.jee.CuiCui.model.Message;
import ifi.jee.CuiCui.model.User;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface IUserMetier {
    public void creerUser(String nom,String username,String password);
    public User getUserById(int id);
    public Page<User> listUsers(int page, int size);
    public void modifierUser();

    public void ajouterMessage(String body, User user);
    public Message consulterMessage(int id);

}
