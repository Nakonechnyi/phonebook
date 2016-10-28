package org.nakonechnyi.controller;

import org.nakonechnyi.domain.Contact;
import org.nakonechnyi.domain.User;
import org.nakonechnyi.repository.IContactRepository;
import org.nakonechnyi.repository.IUserRepository;
import org.nakonechnyi.service.ISecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */

@RepositoryRestController
@RequestMapping(value = "/contacts")
public class ContactController {

//    @Autowired
//TODO    private ContactService contactService;

    @Autowired
    private IContactRepository contactRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ISecurityService securityService;

    @GetMapping(value = "/my", produces = "application/hal+json")
//    @RestResource( path = "/my", rel = "my-contacts3")
    public List<Contact> getMy() {
        System.err.println("my-contacts3");
        String login = securityService.findLoggedInUsername();
        User user = userRepository.findByLogin(login);
        return contactRepository.findByOwner(user);
    }

    @ResponseBody
    @RequestMapping(value = "/contacts4", method = RequestMethod.GET)
    public Resources<PersistentEntityResource> listEntities(PersistentEntityResourceAssembler assembler){
        Link contactsLink = linkTo(ContactController.class).slash("/contacts4").withSelfRel();

        List<PersistentEntityResource> contactsResources = new ArrayList<>();
        List<Contact> resultList = getMy();
        for (Contact contact : resultList) {
            contactsResources.add(assembler.toFullResource(contactRepository.getById(contact.getId())));
        }
        return new Resources<PersistentEntityResource>(contactsResources, contactsLink);
    }
}
