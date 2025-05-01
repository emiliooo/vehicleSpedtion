package com.example.vehicleSpedition.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    private Key key;

    @PostConstruct
    public void init() {
        // Tworzymy klucz raz na starcie aplikacji
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String username) {
        long currentTime = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", "user")
                .setIssuedAt(new Date(currentTime))
                .setExpiration(new Date(currentTime + 200_00000)) // np. 200 sekund
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }
}
