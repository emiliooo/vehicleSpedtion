package com.example.vehicleSpedition.repository;

import com.example.vehicleSpedition.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
    Driver findDriverByDriverId(Integer driverId);
}
