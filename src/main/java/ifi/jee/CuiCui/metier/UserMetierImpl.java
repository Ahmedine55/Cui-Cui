package ifi.jee.CuiCui.metier;

import ifi.jee.CuiCui.model.Message;
import ifi.jee.CuiCui.model.User;
import ifi.jee.CuiCui.repository.MessageRepository;
import ifi.jee.CuiCui.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserMetierImpl implements IUserMetier {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void creerUser(String nom,String username, String password) {
        userRepository.save(new User(nom,username,password));
    }

    @Override
    public User consulterUser(int id) {
        User user=userRepository.findOne(id);
        if(user==null) throw new RuntimeException("User introuvable");
        return user;
    }

    @Override
    public Page<User> listUsers(int page, int size) {
        return userRepository.listUser(new PageRequest(page,size));
    }

    @Override
    public void modifierUser() {

    }

    @Override
    public void ajouterMessage(Date date, String body, User user) {
        messageRepository.save(new Message(date,body,user));
    }

    @Override
    public Message consulterMessage(int id) {
        Message message=messageRepository.findOne(id);
        if(message==null) throw new RuntimeException("Message non trouvé");
        return message;
    }

    @Override
    public Page<Message> listMessages(int idUser,int page, int size) {
        return messageRepository.listMessages(idUser,new PageRequest(page,size)) ;
    }
}
