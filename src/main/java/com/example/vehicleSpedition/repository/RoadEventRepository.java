package com.example.vehicleSpedition.repository;

import com.example.vehicleSpedition.model.RoadEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoadEventRepository extends JpaRepository<RoadEvent, Long> {
}
