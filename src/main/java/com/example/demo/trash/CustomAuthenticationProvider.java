/*package com.example.demo.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;

    public CustomAuthenticationProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // Ваша логика проверки аутентификации, например, сравнение с базой данных или внешней системой аутентификации
        // Если аутентификация успешна, верните новый объект UsernamePasswordAuthenticationToken с правильными данными
        // Если аутентификация неуспешна, бросьте исключение BadCredentialsException

        // Пример:
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (passwordMatches(password, userDetails.getPassword())) {
            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        } else {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    // Вспомогательный метод для проверки совпадения пароля
    private boolean passwordMatches(String rawPassword, String encodedPassword) {
        // Ваша логика проверки совпадения пароля, например, с использованием BCryptPasswordEncoder или другого кодировщика паролей
        // Верните true, если пароль совпадает, и false в противном случае
        return true;
    }
}*/

