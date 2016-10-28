package org.nakonechnyi.config;

import org.nakonechnyi.controller.ContactController;
import org.nakonechnyi.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @autor A_Nakonechnyi
 * @date 26.10.2016.
 */
@Component
public class ContactResourceProcessor implements ResourceProcessor<Resource<Contact>> {

    @Autowired
    private RepositoryEntityLinks entityLinks;

    @Override
    public Resource<Contact> process(Resource<Contact> contactResource) {
        final Contact contact = contactResource.getContent();
//        contactResource.add(linkTo(methodOn(ContactController.class).getMy()).withRel("my"));
//        contactResource.add(entityLinks.linkToSearchResource(Contact.class, "my").withRel("my"));
        contactResource.add(entityLinks.linkToSingleResource(Contact.class, contact.getId())
                .withRel("update"));
        contactResource.add(entityLinks.linkToSingleResource(Contact.class, contact.getId())
                .withRel("delete"));




        return contactResource;
    }
}
