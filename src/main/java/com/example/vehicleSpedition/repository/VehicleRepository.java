package com.example.vehicleSpedition.repository;

import com.example.vehicleSpedition.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
