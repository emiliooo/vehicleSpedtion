package com.example.vehicleSpedition.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collection;
import java.util.Collections;

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

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(userRole));
    }

}