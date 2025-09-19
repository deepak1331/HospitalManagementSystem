package com.learn.jpa.HospitalManagementSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;

@Configuration
public class SecurityConfig {



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


    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //Following code will make override the default (all endpoints as authenticated,
        // to all as public api now, although default password are still getting generated)
        return httpSecurity.formLogin(Customizer.withDefaults()).build();
    }*/
}
