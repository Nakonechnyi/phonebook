package org.nakonechnyi.service;

import org.nakonechnyi.domain.Contact;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

import java.util.List;

/**
 * @autor A_Nakonechnyi
 * @date 30.10.2016.
 */
public interface IContactService {
    
    List<Contact> getByOwner();
    
    List<Contact> getMy();

    Resource create(Contact contact, PersistentEntityResourceAssembler assembler);

    Resources<PersistentEntityResource> findByName(String name, PersistentEntityResourceAssembler assembler);

    Resources<PersistentEntityResource> findByLastName(String lastName, PersistentEntityResourceAssembler assembler);

    Resources<PersistentEntityResource> findByPhone(String phone, PersistentEntityResourceAssembler assembler);

    Resources<PersistentEntityResource> listEntities(PersistentEntityResourceAssembler assembler);
}
