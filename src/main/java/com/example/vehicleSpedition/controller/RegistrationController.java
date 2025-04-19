package com.example.vehicleSpedition.controller;
import com.example.vehicleSpedition.dto.AuthResponse;
import com.example.vehicleSpedition.dto.LoginRequest;
import com.example.vehicleSpedition.dto.RegisterRequest;
import com.example.vehicleSpedition.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class RegistrationController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }

}
