package org.nakonechnyi.controller;

import org.nakonechnyi.domain.User;
import org.nakonechnyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */
public class UserController {


    @Autowired
    private static UserService userService;

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public HttpEntity<?> registration(@RequestBody @Validated User registration){
        return ResponseEntity.ok(userService.register(registration));
    }
}
