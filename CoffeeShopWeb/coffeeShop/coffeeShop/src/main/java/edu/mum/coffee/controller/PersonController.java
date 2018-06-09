package edu.mum.coffee.controller;

import edu.mum.coffee.domain.User;
import edu.mum.coffee.domain.UserRole;
import edu.mum.coffee.service.UserRoleService;
import edu.mum.coffee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PersonController {

    @Autowired
    UserService userService;

    @Autowired
    UserRoleService userRoleService;

    @GetMapping("/signup")
    public String signUp(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute("user") User user, BindingResult result){
        user.setEnabled(1);
        User userRes = userService.saveUser(user);
        UserRole userRole = new UserRole();
        userRole.setRole("USER");
        userRole.setUser(userRes);
        userRoleService.saveUser(userRole);
        return "signup";
    }

    @GetMapping("/displayLogin")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request){
        return "login";
    }
}
