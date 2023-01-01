package com.example.swagger.global.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .csrf().disable()
                .formLogin().disable()
                .cors()

                .and()
                .authorizeRequests()
//                .antMatchers("/swagger-ui/**").permitAll()
//                .antMatchers("/v3/api-docs/**").permitAll()
//                .antMatchers("/api-docs").permitAll()

                .anyRequest().permitAll()

                .and().build();
    }

}
