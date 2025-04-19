package com.example.vehicleSpedition.repository;

import com.example.vehicleSpedition.model.MaintenanceAndRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceAndRepairRepository extends JpaRepository<MaintenanceAndRepair, Long> {
}
