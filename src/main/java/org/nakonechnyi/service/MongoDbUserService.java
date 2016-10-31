package org.nakonechnyi.service;

import org.nakonechnyi.domain.mongo_db.User;
import org.nakonechnyi.repository.MongoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

/**
 * @autor A_Nakonechnyi
 * @date 31.10.2016.
 */
@Service
public class MongoDbUserService{

    @Autowired
    private MongoUserRepository userRepository; //TODO interface layer

    public User register(User registration) {
        try {
            if (userRepository.findByLogin(registration.getLogin()) != null) {
                throw new InvalidParameterException();
            }
        } catch (NullPointerException e) {}
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
