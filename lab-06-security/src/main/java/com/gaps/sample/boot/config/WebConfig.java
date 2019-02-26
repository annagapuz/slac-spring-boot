package com.gaps.sample.boot.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("foo").password("foopass").roles("FOO").build());
        manager.createUser(users.username("bar").password("barpass").roles("BAR", "ADMIN").build());
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers(EndpointRequest.to("health", "info")).permitAll()
                .requestMatchers(EndpointRequest.to("actuator")).hasRole("VIEW_ACTUATOR")
                //.antMatchers("/actuator/health", "/actuator/info").permitAll()
                //.antMatchers("/actuator/**").hasRole("VIEW_ACTUATOR")
                .anyRequest().authenticated()
                .and()
                .httpBasic();

    }
}
