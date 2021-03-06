package org.nakonechnyi.service;

import org.nakonechnyi.domain.my_sql.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @autor A_Nakonechnyi
 * @date 24.10.2016.
 */
@Service
@Primary
public class MySqlUserDetailsService implements UserDetailsService {

    @Autowired
    private MySqlUserService userService; //TODO interface layer

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findByLogin(s);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), grantedAuthorities);
    }

}
