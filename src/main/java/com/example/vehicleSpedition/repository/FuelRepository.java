package com.example.vehicleSpedition.repository;

import com.example.vehicleSpedition.model.FuelConsumption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelRepository extends JpaRepository<FuelConsumption,Long> {
}
