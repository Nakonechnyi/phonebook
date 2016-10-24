package org.nakonechnyi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
/*
    @Autowired
    DataSource dataSource;*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/user/registration", "/index.html", "/webapp/**").permitAll()
                .antMatchers("/api/**").authenticated()
                .and()
            .formLogin()
                .loginPage("/index.html")
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/api",true)
                .failureUrl("/login.html?error=true")
                .and()
            .csrf().disable() //for registration by POST method
            .logout().logoutUrl("/logout");

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    /*    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
*//*
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");*//*
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select pib, password from contacts where pib=?")
                .authoritiesByUsernameQuery(
                        "SELECT pib, id"
                                + "  FROM roles where id in "
                                + "(SELECT role_id FROM jt_roles where user_id in "
                                + "(SELECT id FROM users where name = ?) )")
                .passwordEncoder(new BCryptPasswordEncoder());
    }*/

}
