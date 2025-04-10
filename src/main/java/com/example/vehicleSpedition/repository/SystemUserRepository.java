package com.example.vehicleSpedition.repository;

import com.example.vehicleSpedition.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemUserRepository extends JpaRepository<SystemUser, Long> {
}
