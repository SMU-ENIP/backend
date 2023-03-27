package com.smu.smuenip.Infrastructure.config.security;

import com.smu.smuenip.Infrastructure.config.filters.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final CorsConfigurationSource corsConfigurationSource;

    private final String[] swaggerURL = {
        "/v3/api-docs", "/configuration/ui",
        "/swagger-resources", "/configuration/security",
        "/swagger-ui.html", "/webjars/**", "/swagger/**"
    };

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .cors().configurationSource(corsConfigurationSource)
            .and()
            .headers().frameOptions().disable()
            .and()
            .httpBasic().disable()
            .formLogin().disable()
            .authorizeRequests()
            .antMatchers(swaggerURL).permitAll()
            .antMatchers("/user/loginTest").authenticated()
            .anyRequest().permitAll()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(
            jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class
        );

        return http.build();
    }

}
