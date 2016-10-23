package org.nakonechnyi.controller;

import org.nakonechnyi.domain.Contact;
import org.nakonechnyi.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
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

@RepositoryRestController
public class ContactController {

    @Autowired
    private static ContactService contactService;


    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public HttpEntity<?> registration(@RequestBody @Validated Contact registration){
        return ResponseEntity.ok(contactService.register(registration));
    }
}
