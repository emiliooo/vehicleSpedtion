//package com.example.vehicleSpedition.service;
//import com.example.vehicleSpedition.repository.SystemUserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class UserService {
//
//        @Autowired
//        SystemUserRepository systemUserRepository;
//        private final PasswordEncoder passwordEncoder;
//
//        public AuthResponse register(RegisterRequest request) {
//                if (systemUserRepository.findByUsername(request.getUsername()).isPresent()) {
//                        return new AuthResponse("Użytkownik już istnieje");
//                }
//
//                SystemUser user = new SystemUser();
//                user.setFullName(request.getFullName());
//                user.setUserRole(request.getUserRole());
//                user.setUsername(request.getUsername());
//                user.setPassword(passwordEncoder.encode(request.getPassword()));
//                systemUserRepository.save(user);
//                return new AuthResponse("Rejestracja zakończona sukcesem");
//        }
//
//        public AuthResponse login(LoginRequest request) {
//                return systemUserRepository.findByUsername(request.getUsername())
//                        .filter(user -> passwordEncoder.matches(request.getPassword(), user.getPassword()))
//                        .map(user -> new AuthResponse("Zalogowano pomyślnie"))
//                        .orElseGet(() -> new AuthResponse("Nieprawidłowy login lub hasło"));
//        }
//
//}
//
//
//package com.example.vehicleSpedition.service;
//
//import com.example.vehicleSpedition.dto.AuthResponse;
//import com.example.vehicleSpedition.dto.RegisterRequest;
//import com.example.vehicleSpedition.model.SystemUser;
//import com.example.vehicleSpedition.repository.SystemUserRepository;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.SecretKey;
//import java.util.Base64;
//import java.util.Date;
//
//@Service
//@RequiredArgsConstructor
//public class UserService {
//
//    private final SystemUserRepository systemUserRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @Value("${jwt.secret}")
//    private String jwtSecret;
//
//    // 10 godzin ważności tokena (przykładowo)
//    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10;
//
//    public AuthResponse register(RegisterRequest request) {
//        if (systemUserRepository.findByUsername(request.getUsername()).isPresent()) {
//            return new AuthResponse("Użytkownik już istnieje");
//        }
//
//        SystemUser user = new SystemUser();
//        user.setFullName(request.getFullName());
//        user.setUserRole(request.getUserRole());
//        user.setUsername(request.getUsername());
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//        systemUserRepository.save(user);
//
//        return new AuthResponse("Rejestracja zakończona sukcesem");
//    }
//
//    public AuthResponse login(LoginRequest request) {
//        return systemUserRepository.findByUsername(request.getUsername())
//                .filter(user -> passwordEncoder.matches(request.getPassword(), user.getPassword()))
//                .map(user -> {
//                    String token = generateToken(user.getUsername());
//                    return new AuthResponse("Zalogowano pomyślnie", token);
//                })
//                .orElseGet(() -> new AuthResponse("Nieprawidłowy login lub hasło"));
//    }
//
//    private String generateToken(String username) {
//        byte[] decodedKey = Base64.getDecoder().decode(jwtSecret);
//        SecretKey key = Keys.hmacShaKeyFor(decodedKey);
//
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(key, SignatureAlgorithm.HS512)
//                .compact();
//    }
//}
