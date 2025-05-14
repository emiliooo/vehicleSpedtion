package com.example.vehicleSpedition.controller;
import com.example.vehicleSpedition.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.vehicleSpedition.model.Driver;

import java.util.List;

@RestController
@RequestMapping("/api/secure")
public class DriverController {

    private DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/drivers")
    public ResponseEntity<List<Driver>> getDrivers() {
        return ResponseEntity.ok(this.driverService.findAll());
    }

    @PostMapping("/driverID")
    public ResponseEntity<Driver> addDriver(@RequestBody Driver driver) {
        Driver saveddriver = driverService.addDriver(driver);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveddriver);
    }

    @PutMapping("/driverID/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Integer id, @RequestBody Driver driver) {
        Driver existingDriver = driverService.findDriverById(id);
        if (existingDriver == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        existingDriver.setFullName(driver.getFullName());
        existingDriver.setLicenseNumber(driver.getLicenseNumber());
        existingDriver.setContactPhone(driver.getContactPhone());
        existingDriver.setDriverId(driver.getDriverId());

        Driver updatedDriver = driverService.updateDriver(existingDriver);
        return new ResponseEntity<>(updatedDriver, HttpStatus.OK);
    }

    @DeleteMapping("/driverID{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }

}
