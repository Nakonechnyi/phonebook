package org.nakonechnyi.service;

import org.nakonechnyi.controller.ContactController;
import org.nakonechnyi.domain.my_sql.Contact;
import org.nakonechnyi.domain.my_sql.User;
import org.nakonechnyi.repository.MySqlContactRepository;
import org.nakonechnyi.repository.MySqlUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */

@Service
@Transactional
public class MySqlContactService implements IContactService {

    @Autowired
    private MySqlContactRepository contactRepository;
    @Autowired
    private MySqlUserRepository userRepository;
    @Autowired
    private ISecurityService securityService;

    public List<Contact> getByOwner() {
        String login = securityService.findLoggedInUsername();
        User user = userRepository.findByLogin(login);
        return contactRepository.findByOwner(user);
    }

    @Override
    public List<Contact> getMy() {
        String login = securityService.findLoggedInUsername();
        User user = userRepository.findByLogin(login);
        return contactRepository.findByOwner(user);
    }

    @Override
    public Resource create(Contact contact, PersistentEntityResourceAssembler assembler) {
        contact.setOwner(userRepository.findByLogin(securityService.findLoggedInUsername()));
        return assembler.toFullResource(contactRepository.save(contact));
    }

    @Override
    public Resources<PersistentEntityResource> findByName(String name, PersistentEntityResourceAssembler assembler) {
        List<Contact> resultList = contactRepository.findByFirstName(name);
        return collectToResources(resultList, assembler);
    }

    @Override
    public Resources<PersistentEntityResource> findByLastName(String lastName, PersistentEntityResourceAssembler assembler) {
        List<Contact> resultList = contactRepository.findByLastName(lastName);
        return collectToResources(resultList, assembler);
    }

    @Override
    public Resources<PersistentEntityResource> findByPhone(String phone, PersistentEntityResourceAssembler assembler) {
        List<Contact> resultList = contactRepository.findByPhone(phone);
        return collectToResources(resultList, assembler);
    }

    @Override
    public Resources<PersistentEntityResource> listEntities(PersistentEntityResourceAssembler assembler) {
        List<Contact> resultList = getMy();
        return collectToResources(resultList, assembler);
    }


    private Resources<PersistentEntityResource> collectToResources(List<Contact> resultList, PersistentEntityResourceAssembler assembler) {
        Link contactsLink = linkTo(ContactController.class).slash("/contacts").withSelfRel();
        List<PersistentEntityResource> contactsResources = new ArrayList<>();
        for (Contact contact : resultList) {
            contactsResources.add(assembler.toFullResource(contactRepository.getById(contact.getId())));
        }
        return new Resources<>(contactsResources, contactsLink);
    }
}
