package com.example.finalprj.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    public AppSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers(
                        "/login",
                        "/registration**")
                .permitAll();

        http
                .authorizeRequests().antMatchers("/login")
                .hasAnyRole().and().formLogin().and().userDetailsService(userDetailsService);

        http
                .authorizeRequests().anyRequest().authenticated();
    }
}
