package com.example.demo.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {
        String username = authentication.getName();
        List<String> roles = authentication.getAuthorities()
                .stream()
                .map(Object::toString)
                .toList();

        log.info("User is {}", username);

        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("user_role", roles.get(0));

        response.sendRedirect("/main");
    }
}
