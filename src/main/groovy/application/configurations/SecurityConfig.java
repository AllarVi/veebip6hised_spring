package main.groovy.application.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

/**
 * Created by User on 2.06.2016.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("qwerty").password("1234").roles("USER");
    }*/

    @Autowired
    DataSource dataSource;
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username,password, 1 from user_account where username=?")
                .authoritiesByUsernameQuery(
                        "select username, 'ROLE_USER' from user_account where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/s/**").access("hasRole('ROLE_USER')")
                .and()
                .formLogin().loginPage("/login").failureUrl("/login?error")
                .usernameParameter("username").passwordParameter("password")
                .loginProcessingUrl("/j_spring_security_check")
                .and()
                .logout().logoutSuccessUrl("/login?logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/j_spring_security_logout"))
                .and()
                .csrf();
    }
}
