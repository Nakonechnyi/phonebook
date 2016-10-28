package org.nakonechnyi.controller;

import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @autor A_Nakonechnyi
 * @date 27.10.2016.
 */
@Controller
public class RootController implements
        ResourceProcessor<RepositoryLinksResource> {

    @Override
    public RepositoryLinksResource process(RepositoryLinksResource repositoryLinksResource) {
//        repositoryLinksResource.add(linkTo(/*RootController*/ContactController.class).withRel("others"));
        repositoryLinksResource.add(new Link("http://localhost:8080/contacts/my", "my-contacts"));
        repositoryLinksResource.add(linkTo(methodOn(ContactController.class).getMy()).withRel("my-contacts2"));
        return repositoryLinksResource;
    }
}
