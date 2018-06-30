package ifi.jee.CuiCui.contoller;

import ifi.jee.CuiCui.metier.IUserMetier;
import ifi.jee.CuiCui.model.Message;
import ifi.jee.CuiCui.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

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
            User user= userMetier.consulterUser(id);
            model.addAttribute("user",user);
            model.addAttribute("listAmis",user.getAmis());
            model.addAttribute("listHahtag",user.getAbonnements());
        }catch (Exception e){
            model.addAttribute("exception",e);
        }
        return "cui-cui";
    }
    @RequestMapping(value = "/ajouterMessage",method = RequestMethod.POST)
    public String ajouterMessage(Model model, Date date, String body, User user){
        try {
            userMetier.ajouterMessage(date,body,user);
        }catch (Exception e){
            model.addAttribute("exception",e);
        }
        return "cui-cui";
    }

    @RequestMapping(value = "/ListMessage/{id}",method = RequestMethod.GET)
    public String listMessages(Model model,@PathVariable(value = "id") int idUser, int page, int size){
        model.addAttribute("idUser",idUser);
        try {
            Page<Message> pageMessage = userMetier.listMessages(idUser, page, size);
            model.addAttribute("listMessage",pageMessage.getContent());
        }catch (Exception e){
            model.addAttribute("exception",e);
        }
        return "cui-cui";
    }

}
