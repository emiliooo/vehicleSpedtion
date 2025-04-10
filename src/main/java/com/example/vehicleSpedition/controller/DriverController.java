package com.example.vehicleSpedition.controller;
import com.example.vehicleSpedition.repository.DriverRepository;
import com.example.vehicleSpedition.service.DriverService;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.vehicleSpedition.model.Driver;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverController {

    private DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/drivers")
    public List<Driver> getDrivers() {
        return this.driverService.findAll();
    }
}
