package org.nakonechnyi.service;

import org.nakonechnyi.domain.my_sql.User;
import org.nakonechnyi.repository.MySqlUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */
@Service
public class MySqlUserService /*implements IUserService*/{

    @Autowired
    private MySqlUserRepository userRepository; //TODO interface layer

    public User register(User registration) {
        if (userRepository.findByLogin(registration.getLogin())!=null) {
            throw new InvalidParameterException();
        }
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
