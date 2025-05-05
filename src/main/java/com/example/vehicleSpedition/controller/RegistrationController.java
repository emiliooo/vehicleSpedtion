package com.example.vehicleSpedition.controller;
import com.example.vehicleSpedition.dto.AuthResponse;
import com.example.vehicleSpedition.dto.RegisterRequest;
import com.example.vehicleSpedition.dto.User;
import com.example.vehicleSpedition.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class RegistrationController {

    @Autowired
    private final UserService userService;


    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login( @RequestBody User user) {
        return userService.login(user);
    }

}
