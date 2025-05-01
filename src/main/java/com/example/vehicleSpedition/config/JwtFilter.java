package com.example.vehicleSpedition.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class JwtFilter implements Filter {

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Możesz zainicjalizować coś, jeśli potrzebujesz
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String authHeader = request.getHeader("Authorization");
        String requestUri = request.getRequestURI();

        if (requestUri.equals("/api/auth/login")) {
            filterChain.doFilter(servletRequest, servletResponse); // Przechodzimy dalej
            return;
        }

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new ServletException("Missing or invalid Authorization header");
        }

        try {
            String token = authHeader.substring(7); // usuń "Bearer "
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(secret.getBytes(StandardCharsets.UTF_8))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            servletRequest.setAttribute("claims", claims);
        } catch (Exception e) {
            throw new ServletException("Invalid JWT token: " + e.getMessage());
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        // Możesz zwolnić zasoby, jeśli trzeba
    }
}
