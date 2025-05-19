package com.example.vehicleSpedition.controller;
import com.example.vehicleSpedition.model.Vehicle;
import com.example.vehicleSpedition.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/secure")
public class VehicleController {
     private final VehicleService vehicleService;
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PostMapping("/vehicleID")
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
        Vehicle saved = vehicleService.saveVehicle(vehicle);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/vehicle/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        Vehicle existing = vehicleService.findVehicleById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        existing.setBrand(vehicle.getBrand());
        existing.setModel(vehicle.getModel());
        existing.setProductionYear(vehicle.getProductionYear());

        Vehicle updated = vehicleService.saveVehicle(existing);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/vehicle/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        Vehicle existing = vehicleService.findVehicleById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        vehicleService.deleteVehicleById(id);
        return ResponseEntity.noContent().build();
    }

}
