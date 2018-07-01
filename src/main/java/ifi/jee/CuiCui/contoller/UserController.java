package ifi.jee.CuiCui.contoller;

import ifi.jee.CuiCui.metier.IUserMetier;
import ifi.jee.CuiCui.model.Message;
import ifi.jee.CuiCui.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@Controller
public class UserController {

    @Autowired
    private IUserMetier userMetier;
    @Autowired

    @RequestMapping("/cui-cui")
    public String index(){
        return "cui-cui";
    }

    @RequestMapping(value = "/home/{id}",method = RequestMethod.GET)
    public String ConsulterProfil(Model model, @PathVariable(value = "id") int id){
        model.addAttribute("idUser",id);
        try {
            User user= userMetier.getUserById(id);
            model.addAttribute("user",user);
            model.addAttribute("listAmis",user.getAmis());
            model.addAttribute("listHahtag",user.getAbonnements());
            List<Message> listMessage = user.getMessages();
            Comparator<Message> messageComparator=(m1,m2)->m1.getDate().compareTo(m2.getDate());
            listMessage.sort(messageComparator.reversed());
            model.addAttribute("listMessage",listMessage);
        }catch (Exception e){
            model.addAttribute("exception",e);
        }
        return "cui-cui";
    }
    @RequestMapping(value = "/ajouterMessage",method = RequestMethod.POST)
    public String ajouterMessage(Model model,String body, int idUser){
        try {
            User user=userMetier.getUserById(idUser);
            userMetier.ajouterMessage(body,user);
        }catch (Exception e){
            model.addAttribute("exception",e);
        }
        return "redirect:/home/"+idUser;
    }

}
