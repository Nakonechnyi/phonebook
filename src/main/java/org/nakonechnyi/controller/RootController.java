package org.nakonechnyi.controller;

import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.*;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor A_Nakonechnyi
 * @date 27.10.2016.
 */
@Controller
public class RootController implements
        ResourceProcessor<RepositoryLinksResource> {

    private static final List<TemplateVariable> NEW_CONTACT_PARAMETERS = new ArrayList<>();
    static {
        NEW_CONTACT_PARAMETERS.add(new TemplateVariable("lastName", TemplateVariable.VariableType.REQUEST_PARAM));
        NEW_CONTACT_PARAMETERS.add(new TemplateVariable("firstName", TemplateVariable.VariableType.REQUEST_PARAM));
        NEW_CONTACT_PARAMETERS.add(new TemplateVariable("surname", TemplateVariable.VariableType.REQUEST_PARAM));
        NEW_CONTACT_PARAMETERS.add(new TemplateVariable("phone", TemplateVariable.VariableType.REQUEST_PARAM));
        NEW_CONTACT_PARAMETERS.add(new TemplateVariable("homePhone", TemplateVariable.VariableType.REQUEST_PARAM));
        NEW_CONTACT_PARAMETERS.add(new TemplateVariable("address", TemplateVariable.VariableType.REQUEST_PARAM));
        NEW_CONTACT_PARAMETERS.add(new TemplateVariable("email", TemplateVariable.VariableType.REQUEST_PARAM));
    }

    @Override
    public RepositoryLinksResource process(RepositoryLinksResource repositoryLinksResource) {
//        repositoryLinksResource.add(linkTo(/*RootController*/ContactController.class).withRel("others"));
        repositoryLinksResource.add(new Link("http://localhost:8080/contacts/my", "my-contacts"));

        repositoryLinksResource.add(
                new Link(
                        new UriTemplate("http://localhost:8080/contacts/create", new TemplateVariables(NEW_CONTACT_PARAMETERS)
                        ), "create-my-contact")
        );

        repositoryLinksResource.add(new Link("http://localhost:8080/contacts/my/by-name/{name}", "find-my-contact-by-name"));
        repositoryLinksResource.add(new Link("http://localhost:8080/contacts/my/by-last-name/{lname}", "find-my-contact-by-last_name"));
        repositoryLinksResource.add(new Link("http://localhost:8080/contacts/my/by-phone/{phone}", "find-my-contact-by-phone"));
        repositoryLinksResource.add(new Link("http://localhost:8080/logout", "logout"));
//        repositoryLinksResource.add(linkTo(methodOn(ContactController.class).getMy()).withRel("my-contacts2"));
//        repositoryLinksResource.removeLinks();
        return repositoryLinksResource;
    }
}
