package org.nakonechnyi.aspect;

import org.nakonechnyi.domain.DbQualifier;
import org.nakonechnyi.domain.my_sql.Contact;
import org.nakonechnyi.domain.my_sql.User;
import org.nakonechnyi.repository.IUserRepository;
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
public class ContactEventHandlerMySql {

    @Autowired
    @DbQualifier(DbQualifier.DbSource.MY_SQL)
    private IUserRepository userRepository;
    @Autowired
    private ISecurityService securityService;

    @HandleBeforeCreate
    public void setOwner(Contact contact){
        String login = securityService.findLoggedInUsername();
        User user = userRepository.findByLogin(login);
        contact.setOwner(user);
    }

}
