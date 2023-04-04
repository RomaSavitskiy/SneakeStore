package com.example.demo.sesion;

import com.example.demo.entity.Sneakers;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        List<Sneakers> bagSneakers = new ArrayList<>();
        session.setAttribute("bagSneakersList", bagSneakers);
        log.info("Session is created with attribute {} ", session.getAttribute("myAttribute"));
    }
}
