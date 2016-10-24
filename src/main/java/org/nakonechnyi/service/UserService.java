package org.nakonechnyi.service;

import org.nakonechnyi.domain.Contact;
import org.nakonechnyi.domain.User;
import org.nakonechnyi.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */
@Service
public class UserService {


    @Autowired
    private IUserRepository userRepository;

    public User register(User registration) {
        System.err.println("userService");
        return userRepository.save(registration);
    }

}
