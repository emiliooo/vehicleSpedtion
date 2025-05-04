//package com.example.vehicleSpedition.service;
//import com.example.vehicleSpedition.dto.AuthResponse;
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
package com.example.vehicleSpedition.service;

import com.example.vehicleSpedition.dto.AuthResponse;
import com.example.vehicleSpedition.dto.RegisterRequest;
import com.example.vehicleSpedition.dto.User;
import com.example.vehicleSpedition.model.SystemUser;
import com.example.vehicleSpedition.repository.SystemUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final SystemUserRepository systemUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Value("${jwt.secret}")
    private String jwtSecret;

    public AuthResponse login(User request) {
        return systemUserRepository.findByUsername(request.getUsername())
                .filter(user -> passwordEncoder.matches(request.getPassword(), user.getPassword()))
                .map(user -> {
                    String token = jwtUtil.generateToken(user.getUsername());
                    return new AuthResponse("Zalogowano pomyślnie",token);
                })
                .orElseGet(() -> new AuthResponse("Nieprawidłowy login lub hasło","") );
    }

    public AuthResponse register(RegisterRequest registerRequest) {
          if(systemUserRepository.findByUsername(registerRequest.getUsername()).isPresent()) {
              return new AuthResponse("Użytkownik o podanym loginie już istnieje","");
          }

          SystemUser user = new SystemUser();
          user.setFullName(registerRequest.getFullName());
          user.setUserRole(registerRequest.getUserRole());
          user.setUsername(registerRequest.getUsername());
          user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

          systemUserRepository.save(user);

        return new AuthResponse("Użytkownik został zarejestrowany pomyślnie","");
    }

}
