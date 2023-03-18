package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Configuration
@ConfigurationProperties(prefix = "org.hibernate")
public class HibernateConfig {
    private String driver;
    private String url;
    private String user;
    private String password;
    private String dialect;
}

