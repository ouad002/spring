package com.emse.spring.automacorp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    public static final String ROLE_USER = "USER";
    public static final String ROLE_ADMIN = "ADMIN";

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        // Create a regular user
        manager.createUser(
                User.withUsername("user")
                        .password(encoder.encode("password"))
                        .roles(ROLE_USER)
                        .build()
        );

        // Create an admin user
        manager.createUser(
                User.withUsername("admin")
                        .password(encoder.encode("adminPassword"))
                        .roles(ROLE_ADMIN)
                        .build()
        );

        return manager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").hasAnyRole(ROLE_USER, ROLE_ADMIN) // Secure all /api/** routes
                        .requestMatchers("/h2-console/**").hasRole(ROLE_ADMIN) // Restrict H2 console access to admins
                        .requestMatchers("/admin/**").hasRole(ROLE_ADMIN) // Custom endpoint for admin-only access
                        .anyRequest().authenticated() // All other requests need authentication
                )
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll // Allow everyone to access the login page
                )
                .logout(LogoutConfigurer::permitAll // Allow everyone to access the logout page
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**") // Disable CSRF only for H2 console access
                )
                .headers(headers -> headers
                        .defaultsDisabled() // Disable default security headers
                        .cacheControl(HeadersConfigurer.CacheControlConfig::disable) // Disable caching headers
                        .contentTypeOptions(HeadersConfigurer.ContentTypeOptionsConfig::disable) // Disable content type options
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin) // Allow frames from the same origin for H2 console
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
