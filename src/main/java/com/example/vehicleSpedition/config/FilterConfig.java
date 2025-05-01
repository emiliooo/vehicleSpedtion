package com.example.vehicleSpedition.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;


@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilterBean(JwtFilter filter) {
        FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/api/*"); // Filtruje wszystkie endpointy zaczynające się od /api
        registrationBean.setInitParameters(Map.of("excludePatterns", "/api/auth/login"));
        return registrationBean;
    }
}
