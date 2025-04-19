package com.example.vehicleSpedition.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String fullName;
    private String userRole;
    private String username;
    private String password;
}
