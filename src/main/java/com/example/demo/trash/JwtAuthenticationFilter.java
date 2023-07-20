//package com.example.demo.jwt;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//
//
//import java.io.IOException;
//
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//    private final AuthenticationManager authenticationManager;
//
//    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        String token = extractTokenFromCookie(request); // Метод для извлечения токена из Cookie
//
//        if (token != null) {
//            try {
//                // Проверяем и аутентифицируем пользователя на основе токена
//                Authentication authentication = new JwtTokenAuthentication(token);
//                authentication = authenticationManager.authenticate(authentication);
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            } catch (AuthenticationException e) {
//                // Обработка ошибки аутентификации
//                SecurityContextHolder.clearContext();
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//    private String extractTokenFromCookie(HttpServletRequest request) {
//        // Извлечение токена из Cookie
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("jwtToken")) {
//                    return cookie.getValue();
//                }
//            }
//        }
//        return null;
//    }
//}
