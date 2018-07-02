package ifi.jee.CuiCui.security;

import ifi.jee.CuiCui.metier.IUserMetier;
import ifi.jee.CuiCui.model.User;
import ifi.jee.CuiCui.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class WebSecurity {

  IUserMetier iUserMetier;

    public boolean checkUserId(Authentication auth) {
        System.out.println(" == "+auth.getPrincipal().toString());
        //String username = ((User) auth.getPrincipal()).toString();
        //User result = iUserMetier.findUserByUsername(username);
        //System.out.println(result.getId()+" == "+username);

        //return result != null && result.getId() == id;
        return true;
    }
}
