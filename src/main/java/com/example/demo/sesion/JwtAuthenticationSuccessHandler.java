package com.example.demo.sesion;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class JwtAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // Получите JWT токен и сохраните его в сесси
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("jwtToken");

        // Другие действия после успешной аутентификации
        // Например, перенаправление на нужную страницу
        response.sendRedirect("/home");
    }
}
