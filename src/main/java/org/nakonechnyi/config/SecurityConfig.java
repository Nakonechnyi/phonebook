package org.nakonechnyi.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
        /*auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select pib, password from contacts where pib=?")
                .authoritiesByUsernameQuery(
                        "SELECT pib, id"
                                + "  FROM roles where id in "
                                + "(SELECT role_id FROM jt_roles where user_id in "
                                + "(SELECT id FROM users where name = ?) )")
                .passwordEncoder(new BCryptPasswordEncoder());*/
    }

}
