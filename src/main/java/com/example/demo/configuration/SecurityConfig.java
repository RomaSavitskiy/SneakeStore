package com.example.demo.configuration;

import com.example.demo.jwt.JwtFilter;
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

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                "/main", "/css/**", "/img/**", "/script/**", "/api/image/**",
                                "/registration", "/user/save", "/bag/**", "/sneakers/**")
                        .permitAll()
                       /* .requestMatchers("/admin/**").hasRole("ADMIN")*/
                        .anyRequest().authenticated())
        		.formLogin(formLogin-> formLogin.loginPage("/login")
                        .defaultSuccessUrl("/main", true).permitAll());

        return http.build();
    }
}
