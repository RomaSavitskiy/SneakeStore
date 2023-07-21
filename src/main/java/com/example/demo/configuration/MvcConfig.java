package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/main").setViewName("index");
        registry.addViewController("/order").setViewName("order");
        registry.addViewController("/addProduct").setViewName("addProduct");
        registry.addViewController("/delete").setViewName("index");
        registry.addViewController("/error").setViewName("error");
        registry.addViewController("/registration").setViewName("registration");
        registry.addViewController("/login").setViewName("login");
    }
}
