package com.example.vehicleSpedition.controller;
import com.example.vehicleSpedition.model.MaintenanceAndRepair;
import com.example.vehicleSpedition.service.MaintencanceAndRepairService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/secure")
public class MaintenanceAndRepairController {

    private final MaintencanceAndRepairService MaintencanceAndRepairService;

    MaintenanceAndRepairController(MaintencanceAndRepairService MaintencanceAndRepairService) {
        this.MaintencanceAndRepairService = MaintencanceAndRepairService;
    }

    @GetMapping("/maintenanceAndRepair")
    public List<MaintenanceAndRepair> getMaintenanceAndRepair() {
        List<MaintenanceAndRepair> maintenanceAndRepairs = MaintencanceAndRepairService.getMaintenanceAndRepair();
        return maintenanceAndRepairs;
    }

    @PostMapping("/maintenanceAndRepair")
    public ResponseEntity<MaintenanceAndRepair> addMaintenanceAndRepair(@RequestBody MaintenanceAndRepair repair) {
        MaintenanceAndRepair saved = MaintencanceAndRepairService.addMaintenanceAndRepair(repair);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/maintenanceAndRepair/{id}")
    public ResponseEntity<MaintenanceAndRepair> updateMaintenanceAndRepair(
            @PathVariable Long id,
            @RequestBody MaintenanceAndRepair repair) {

        MaintenanceAndRepair existing = MaintencanceAndRepairService.getMaintenanceAndRepairById(id);
        if (existing == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        existing.setProblemDescription(repair.getProblemDescription());
        existing.setRepairDate(repair.getRepairDate());
        existing.setRepairCost(repair.getRepairCost());

        MaintenanceAndRepair updated = MaintencanceAndRepairService.updateMaintenanceAndRepair(existing);
        return ResponseEntity.ok(updated);
    }


}