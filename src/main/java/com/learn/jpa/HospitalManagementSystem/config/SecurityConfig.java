package com.learn.jpa.HospitalManagementSystem.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll()
                        .requestMatchers("/admin/**").authenticated()
                        .requestMatchers("/doctors/**").authenticated())
                .formLogin(Customizer.withDefaults());

        return httpSecurity.build();
    }


    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user1 = User.withUsername("admin").password(passwordEncoder.encode("password"))
                            .roles("ADMIN").build();

        UserDetails user2 = User.withUsername("patient").password(passwordEncoder.encode("password"))
                .roles("ADMIN").build();

        UserDetails user3 = User.withUsername("doctor").password(passwordEncoder.encode("password"))
                .roles("ADMIN").build();

        return new InMemoryUserDetailsManager(user1, user2, user3);
    }
}