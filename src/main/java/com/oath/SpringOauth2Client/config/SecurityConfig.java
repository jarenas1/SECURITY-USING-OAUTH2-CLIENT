package com.oath.SpringOauth2Client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(request ->{
                    request.requestMatchers(HttpMethod.GET, "/", "hello").permitAll();
                    request.anyRequest().authenticated(); //cualquier otra peticion debe estgar autenticado
                })
                .formLogin(Customizer.withDefaults()) //habilitamos formulario de login por defecto
                .oauth2Login(Customizer.withDefaults()) //Añade propiedades de oauth al formulario
                .build();
    }
}
