package org.nakonechnyi.aspect;

import org.nakonechnyi.domain.mongo_db.Contact;
import org.nakonechnyi.domain.mongo_db.User;
import org.nakonechnyi.repository.MongoUserRepository;
import org.nakonechnyi.service.ISecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

/**
 * @autor A_Nakonechnyi
 * @date 26.10.2016.
 */
@Component
@RepositoryEventHandler
public class ContactEventHandlerMongoDb {

    @Autowired
    private MongoUserRepository userRepository;
    @Autowired
    private ISecurityService securityService;

    @HandleBeforeCreate
    public void setOwner(Contact contact){
        String login = securityService.findLoggedInUsername();
        User user = userRepository.findByLogin(login);
        contact.setOwner(user);
    }

}
