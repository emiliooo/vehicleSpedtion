package com.example.vehicleSpedition.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "system_users", schema = "vehicle_fleet")
public class SystemUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_ID", nullable = false)
    private Integer id;

    @Column(name = "Full_Name", length = 100)
    private String fullName;

    @Column(name = "User_Role", length = 50)
    private String userRole;

    @Column(name = "Username", length = 50)
    private String username;

    @Column(name = "Password")
    private String password;

}