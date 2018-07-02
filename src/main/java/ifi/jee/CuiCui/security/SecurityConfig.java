package ifi.jee.CuiCui.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN","USER");
        auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin();
        http.authorizeRequests().antMatchers("/home/{idUser}",
                "/consulterUser").hasRole("USER");
        http.authorizeRequests().antMatchers("/allUsers",
                "/  ").hasRole("ADMIN");

        http.formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout");
/*
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(" == "+auth.getPrincipal().toString());

        http.authorizeRequests().antMatchers("/login")
                .access ( "@webSecurity.checkUserId (authentication)" ).anyRequest().authenticated().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();*/
    }

}
