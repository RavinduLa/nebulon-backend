package com.example.nebulonbackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws  Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/error/**").permitAll() //When errors are thrown, this path is given. Therefore, it must be permitted for all.
                .requestMatchers("/api/articles/open").permitAll()
                .requestMatchers("/api/articles/getAll").permitAll()
                //.requestMatchers("/api/articles/create").hasAnyAuthority("SCOPE_write:articles")
                .requestMatchers("/api/articles/create").permitAll()
                .requestMatchers("/api/articles/getById/*").permitAll()
                .requestMatchers("/api/articles/getByAuthorId/*").permitAll()
                .requestMatchers("/api/articles/updateArticle").permitAll()
                .requestMatchers("/api/articles/publish/*").permitAll()
                .requestMatchers("/api/articles/unpublish/*").permitAll()
                .requestMatchers("/api/articles/delete/*").permitAll()
                .anyRequest().authenticated()
        ).oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    //This converter is needed to process Auth0 access tokens (which are JWTs)
    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        grantedAuthoritiesConverter.setAuthoritiesClaimName("permissions");

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
        return jwtAuthenticationConverter;
    }
}
