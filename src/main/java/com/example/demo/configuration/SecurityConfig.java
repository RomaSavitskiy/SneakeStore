package com.example.demo.configuration;

import com.example.demo.jwt.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtFilter jwtFilter;
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .cors().disable()
//                .authorizeRequests()
//                    .requestMatchers("/adminMenu/**").hasRole("ADMIN")
//                    .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/main", "/sneakers/**",
//                            "/api/image/**", "/css/**", "/img/**", "/bag/**", "/registration",
//                            "/user/**")
//                    .permitAll()
//                    .anyRequest().authenticated()
//                    .and()
//               .formLogin()
//                    /*.loginPage("/login")*/ // Указываем страницу входа
//                    .permitAll()
//                    .and()
//                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user1 = User.withUsername("user1")
//                .password("user1")
//                .roles("USER")
//                .build();
//        UserDetails user2 = User.withUsername("user2")
//                .password("user2")
//                .roles("USER")
//                .build();
//        UserDetails admin = User.withUsername("admin")
//                .password("admin")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user1, user2, admin);
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(Customizer.withDefaults())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/main", "/sneakers/**"
                                , "/api/image/**", "/css/**", "/img/**", "/bag/**", "/registration"
                                , "/user/**","/loginPage").permitAll()
                        .anyRequest().authenticated()
                )
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.sendRedirect("http://localhost:8083/loginPage");
                        }))
                .build();
    }
}
