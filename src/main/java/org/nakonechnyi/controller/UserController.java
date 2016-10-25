package org.nakonechnyi.controller;

import org.nakonechnyi.domain.User;
import org.nakonechnyi.service.ISecurityService;
import org.nakonechnyi.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */
@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ISecurityService securityService;

    @PostMapping(value = "/user/registration")
    public HttpEntity<?> registration(@ModelAttribute("user") @Validated User user){
        userService.register(user);
        return ResponseEntity.ok("Successful registration!");
    }
  /*  @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(ModelMap model) {

        return "login";

    }

    @RequestMapping(value="/loginError", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
        model.addAttribute("error", "true");
        return "login";

    }*/

    @GetMapping(value= "/login")
    public String login(
            @RequestParam(value = "j_username") String login,
            @RequestParam(value = "j_password") String password) {

        System.err.println("/login");
        securityService.autologin(login, password/*bCryptPasswordEncoder().encode(password)*/);
        return "redirect:/api";

//        return model;

    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
