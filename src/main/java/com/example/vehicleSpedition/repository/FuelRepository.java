package com.example.vehicleSpedition.repository;

import com.example.vehicleSpedition.model.FuelConsumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelRepository extends JpaRepository<FuelConsumption,Long> {
}
