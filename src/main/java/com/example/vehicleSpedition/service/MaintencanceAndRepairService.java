package com.example.vehicleSpedition.service;

import com.example.vehicleSpedition.model.MaintenanceAndRepair;
import com.example.vehicleSpedition.repository.MaintenanceAndRepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintencanceAndRepairService {
     MaintenanceAndRepairRepository maintenanceAndRepairRepository;

     @Autowired
     MaintencanceAndRepairService(MaintenanceAndRepairRepository maintenanceAndRepairRepository) {
        this.maintenanceAndRepairRepository = maintenanceAndRepairRepository;
    }

    public List<MaintenanceAndRepair> getMaintenanceAndRepair() {
        List<MaintenanceAndRepair> maintenanceAndRepairs = maintenanceAndRepairRepository.findAll();
        return maintenanceAndRepairs;
    }

    public MaintenanceAndRepair addMaintenanceAndRepair(MaintenanceAndRepair maintenanceAndRepair) {
         return maintenanceAndRepairRepository.save(maintenanceAndRepair);
    }

    public MaintenanceAndRepair getMaintenanceAndRepairById(Long id) {
         return maintenanceAndRepairRepository.findById(id).orElse(null);
    }

    public MaintenanceAndRepair AddMaintenanceAndRepair(MaintenanceAndRepair maintenanceAndRepair) {
         return maintenanceAndRepairRepository.save(maintenanceAndRepair);
    }

    public MaintenanceAndRepair updateMaintenanceAndRepair(MaintenanceAndRepair maintenanceAndRepair) {
         return maintenanceAndRepairRepository.save(maintenanceAndRepair);
    }
}