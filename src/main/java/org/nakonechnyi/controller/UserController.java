package org.nakonechnyi.controller;

import org.nakonechnyi.config.CustomPropertySourcesPlaceholderConfigurer;
import org.nakonechnyi.domain.BaseUser;
import org.nakonechnyi.service.AbstractUserService;
import org.nakonechnyi.service.ISecurityService;
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

import java.security.InvalidParameterException;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */
@Controller
public class UserController {

    @Autowired
    private AbstractUserService userService;

    @Autowired
    private ISecurityService securityService;

    @PostMapping(value = "/user/registration")
    public HttpEntity<?> registration(@ModelAttribute("user") @Validated BaseUser user){
        try {
            userService.register(user);
        } catch (InvalidParameterException e) {
            return ResponseEntity.badRequest().body("<a href='/index'>Login already exists</a> ");
        }
//        securityService.autologin(user.getLogin(), user.getPassword());
        return ResponseEntity.ok("<a href='/api'>Successful registration! To API...</a>");
    }

    @GetMapping(value= "/login")
    public String login(
            @RequestParam(value = "j_username") String login,
            @RequestParam(value = "j_password") String password) {

        System.err.println("/login");
        securityService.autologin(login, password);
        new CustomPropertySourcesPlaceholderConfigurer().afterPropertiesSet();
        return "redirect:/api";
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
