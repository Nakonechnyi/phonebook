package org.nakonechnyi.service;

import org.nakonechnyi.domain.User;
import org.nakonechnyi.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    public User register(User registration) {
        registration.setPassword(bCryptPasswordEncoder().encode(registration.getPassword()));
        return userRepository.save(registration);
    }

    public User findByLogin(String s) {
        return userRepository.findByLogin(s);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
