package com.example.demo.configuration;

import com.example.demo.service.SneakersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/main").setViewName("index");
        registry.addViewController("/order").setViewName("order");
        registry.addViewController("/addProduct").setViewName("addProduct");
        registry.addViewController("/delete").setViewName("index");
        registry.addViewController("/registration").setViewName("registration");
        registry.addViewController("/delete").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/error").setViewName("error");
    }
}
