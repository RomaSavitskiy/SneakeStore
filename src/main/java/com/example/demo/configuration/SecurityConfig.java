package com.example.demo.configuration;

import com.example.demo.jwt.JwtFilter;
import com.example.demo.security.CustomAuthenticationSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtFilter jwtFilter;
    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/bag/**").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/css/**", "/img/**", "/script/**", "/api/image/**", "/main",
                                "/registration", "/user/**", "/sneakers/**")
                        .permitAll()
                        .anyRequest().authenticated())
        		.formLogin(formLogin-> formLogin.loginPage("/login")
                      /*  .defaultSuccessUrl("/main", true)*/
                        .successHandler(customAuthenticationSuccessHandler)
                        .permitAll());

        return http.build();
    }
}
