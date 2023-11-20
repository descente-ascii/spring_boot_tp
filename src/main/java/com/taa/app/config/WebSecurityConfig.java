package com.taa.app.config;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author : Olivier Barais
 * @created : 20-10-2023
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(registry -> {
            try {
                registry.requestMatchers(new AntPathRequestMatcher("/api/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/students/update/{id}")).hasRole("user")
                        .requestMatchers(new AntPathRequestMatcher("/api/teachers/update/{id}")).hasRole("admin")
                        .anyRequest().authenticated();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).oauth2ResourceServer(oauth2Configurer -> oauth2Configurer
                .jwt(jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(jwt -> {
                    Map<String, Collection<String>> realmAccess = jwt.getClaim("realm_access");
                    Collection<String> roles = realmAccess.get("roles");
                    List<SimpleGrantedAuthority> grantedAuthorities = roles.stream()
                            .map(role -> new SimpleGrantedAuthority("ROLE_" + role)).toList();
                    grantedAuthorities.forEach(e -> {
                        System.err.println(e.getAuthority());

                    });
                    return new JwtAuthenticationToken(jwt, grantedAuthorities);
                })));
        return httpSecurity.build();
    }
}