package org.nakonechnyi.config;

import org.nakonechnyi.domain.DbQualifier;
import org.nakonechnyi.service.MongoDbUserDetailsService;
import org.nakonechnyi.service.MySqlUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @autor A_Nakonechnyi
 * @date 23.10.2016.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${db_type}")
    DbQualifier.DbSource dbType;
    @Autowired
    MongoDbUserDetailsService mongoUserDetailsService;
    @Autowired
    MySqlUserDetailsService mySqlUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/user/registration", "/index.html", "/js/**", "/css/**", "/login").permitAll()
//                .antMatchers("/api/**").authenticated()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/index.html")
                .loginProcessingUrl("/login")
//                .usernameParameter("user")
//                .passwordParameter("pass")
//                .defaultSuccessUrl("/api",true)
                .failureUrl("/login.html?error=true")
                .and()
            .csrf().disable() //for registration by POST method
            .logout().logoutUrl("/logout");
;
    }

/*
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");

//        auth.userDetailsService(userDetailsService);
                //.authenticationProvider(authenticationProvider())
            auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select login, password from users where login=?")
                .authoritiesByUsernameQuery("select login, 'USER' from users where login=?");
    }
*/

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(
                dbType== DbQualifier.DbSource.MY_SQL ? mySqlUserDetailsService : mongoUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

}
