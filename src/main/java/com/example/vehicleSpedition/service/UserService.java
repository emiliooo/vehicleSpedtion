package com.example.vehicleSpedition.service;
import com.example.vehicleSpedition.dto.AuthResponse;
import com.example.vehicleSpedition.dto.LoginRequest;
import com.example.vehicleSpedition.dto.RegisterRequest;
import com.example.vehicleSpedition.model.SystemUser;
import com.example.vehicleSpedition.repository.SystemUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

        @Autowired
        SystemUserRepository systemUserRepository;
        private final PasswordEncoder passwordEncoder;

        public AuthResponse register(RegisterRequest request) {
                if (systemUserRepository.findByUsername(request.getUsername()).isPresent()) {
                        return new AuthResponse("Użytkownik już istnieje");
                }

                SystemUser user = new SystemUser();
                user.setFullName(request.getFullName());
                user.setUserRole(request.getUserRole());
                user.setUsername(request.getUsername());
                user.setPassword(passwordEncoder.encode(request.getPassword()));
                systemUserRepository.save(user);
                return new AuthResponse("Rejestracja zakończona sukcesem");
        }

        public AuthResponse login(LoginRequest request) {
                return systemUserRepository.findByUsername(request.getUsername())
                        .filter(user -> passwordEncoder.matches(request.getPassword(), user.getPassword()))
                        .map(user -> new AuthResponse("Zalogowano pomyślnie"))
                        .orElseGet(() -> new AuthResponse("Nieprawidłowy login lub hasło"));
        }

}
