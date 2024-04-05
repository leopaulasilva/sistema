package com.app.sistema.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200", "http://appfrontsistema.s3-website.us-east-2.amazonaws.com") // Permitir solicitações de http://localhost:4200
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permitir métodos HTTP especificados
                .allowCredentials(true); // Permitir credenciais (por exemplo, cookies)
    }
}