package ifi.jee.CuiCui.metier;

import ifi.jee.CuiCui.model.Message;
import ifi.jee.CuiCui.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserMetier {
    public void creerUser(String nom,String username,String password);
    public User consulterUser(int id);
    public Page<User> listUsers(int page, int size);
    public void modifierUser();

    public Message consulterMessage(int id);
    public Page<Message> listMessages(int page, int size);
}
