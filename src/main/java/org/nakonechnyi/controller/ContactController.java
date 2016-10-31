package org.nakonechnyi.controller;

import org.nakonechnyi.domain.BaseContact;
import org.nakonechnyi.service.AbstractContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */

@RepositoryRestController
@RequestMapping(value = "/contacts")
public class ContactController {

    @Autowired
    private AbstractContactService contactService;

    @Autowired
    private RepositoryEntityLinks entityLinks;

    @ResponseBody
    @RequestMapping(value = "/my", method = RequestMethod.GET)
    public Resources<PersistentEntityResource> listEntities(PersistentEntityResourceAssembler assembler){
        return contactService.listEntities(assembler);
    }

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.GET) //TODO POST in RepositoryLinksResource
    public Resource create(PersistentEntityResourceAssembler assembler,
                           @ModelAttribute("contact") @Validated BaseContact contact){
        return contactService.create(contact, assembler);
    }

    @RequestMapping(value = "/my/by-name/{name}", method = RequestMethod.GET, produces = "application/hal+json")
    @ResponseBody
    public Resources<PersistentEntityResource> findByName(@PathVariable("name") String name,
                                                          PersistentEntityResourceAssembler assembler) {
        return contactService.findByName(name, assembler);

    }

    @RequestMapping(value = "/my/by-last-name/{lname}", method = RequestMethod.GET, produces = "application/hal+json")
    @ResponseBody
    public Resources<PersistentEntityResource> findByLastName(@PathVariable("lname") String lastName,
                                                              PersistentEntityResourceAssembler assembler) {
        return contactService.findByLastName(lastName, assembler);
    }

    @RequestMapping(value = "/my/by-phone/{phone}", method = RequestMethod.GET, produces = "application/hal+json")
    @ResponseBody
    public Resources<PersistentEntityResource> findByPhone(@PathVariable("phone") String phone,
                                                           PersistentEntityResourceAssembler assembler) {
        return contactService.findByPhone(phone, assembler);

    }
}
