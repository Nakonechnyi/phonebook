package org.nakonechnyi.controller;

import org.nakonechnyi.domain.User;
import org.nakonechnyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user/registration")
    public HttpEntity<?> registration(@ModelAttribute("user") @Validated User user){
        return ResponseEntity.ok(userService.register(user));
    }

}
