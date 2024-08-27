package com.pjsoft.fms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Map the CORS configuration to specific paths, adjust as needed
                .allowedOrigins("http://localhost:3000") // Allow requests from this origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH") // Allowed HTTP methods
                .allowedHeaders("Authorization", "Content-Type", "Accept") // Allow Authorization header
                .allowCredentials(true); // Allow sending cookies from this origin
    }
}
