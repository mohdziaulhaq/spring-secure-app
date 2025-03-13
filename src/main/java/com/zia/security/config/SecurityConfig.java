package com.zia.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {

        // creating users
        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("zia")
                .password("zia")
                .roles("ADMIN","GUEST")
                .build();
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("john")
                .password("john")
                .roles("ADMIN")
                .build();
        // creating in-memory user detailmanager that is user detail service implementation
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1, user2);
        return inMemoryUserDetailsManager;
    }
}
