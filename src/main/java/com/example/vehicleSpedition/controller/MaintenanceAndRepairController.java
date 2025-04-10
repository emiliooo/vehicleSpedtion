package com.example.vehicleSpedition.controller;
import com.example.vehicleSpedition.model.MaintenanceAndRepair;
import com.example.vehicleSpedition.repository.MaintenanceAndRepairRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MaintenanceAndRepairController {

    MaintenanceAndRepairRepository maintenanceAndRepairRepository;

    MaintenanceAndRepairController( MaintenanceAndRepairRepository maintenanceAndRepairRepository) {
        this.maintenanceAndRepairRepository = maintenanceAndRepairRepository;
    }

    @GetMapping("/maintenanceAndRepair")
    public List<MaintenanceAndRepair> getMaintenanceAndRepair() {
        List<MaintenanceAndRepair> maintenanceAndRepairs = maintenanceAndRepairRepository.findAll();
        return maintenanceAndRepairs;
    }

}
