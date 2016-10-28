package org.nakonechnyi.service;

import org.nakonechnyi.domain.Contact;
import org.nakonechnyi.domain.User;
import org.nakonechnyi.repository.IContactRepository;
import org.nakonechnyi.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */

@Service
@Transactional
public class ContactService {

    @Autowired
    private IContactRepository contactRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ISecurityService securityService;

    public List<Contact> getByOwner() {
        System.err.println("getByOwner");
        String login = securityService.findLoggedInUsername();
        System.err.println("login " + login);
        User user = userRepository.findByLogin(login);
        return contactRepository.findByOwner(user);
    }
}
