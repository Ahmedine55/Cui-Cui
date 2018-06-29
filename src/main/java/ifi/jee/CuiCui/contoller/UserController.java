package ifi.jee.CuiCui.contoller;

import ifi.jee.CuiCui.metier.IUserMetier;
import ifi.jee.CuiCui.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private IUserMetier userMetier;

    @RequestMapping("/cui-cui")
    public String index(){
        return "cui-cui";
    }

    @RequestMapping(value = "/consulterProfil/{id}",method = RequestMethod.GET)
    public String ConsulterProfil(Model model, @PathVariable(value = "id") int id){
        model.addAttribute("idUser",id);
        try {
            User user= userMetier.consulterUser(id);
            model.addAttribute("user",user);
        }catch (Exception e){
            model.addAttribute("exception",e);
        }
        return "cui-cui";
    }
}
