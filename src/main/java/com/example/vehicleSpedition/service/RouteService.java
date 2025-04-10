package com.example.vehicleSpedition.service;

import com.example.vehicleSpedition.dto.DriverDTO;
import com.example.vehicleSpedition.dto.RouteDTO;
import com.example.vehicleSpedition.dto.VehicleDTO;
import com.example.vehicleSpedition.model.Route;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    public RouteDTO convertToDTO(Route route) {
        RouteDTO routeDTO = new RouteDTO();

        routeDTO.setId(route.getId());
        routeDTO.setStartPoint(route.getStartPoint());
        routeDTO.setEndPoint(route.getEndPoint());
        routeDTO.setDistanceTraveled(route.getDistanceTraveled());

        if (route.getVehicle() != null) {
            VehicleDTO vehicleDTO = new VehicleDTO();
            vehicleDTO.setId(route.getVehicle().getVehicleId());
            vehicleDTO.setVehicleId(route.getVehicle().getVehicleId());
            vehicleDTO.setBrand(route.getVehicle().getBrand());
            vehicleDTO.setModel(route.getVehicle().getModel());
            vehicleDTO.setRegistrationNumber(route.getVehicle().getRegistrationNumber());
            routeDTO.setVehicle(vehicleDTO);
        }

        if (route.getDriver() != null) {
            DriverDTO driverDTO = new DriverDTO();
            driverDTO.setFullName(route.getDriver().getFullName());
            routeDTO.setDriver(driverDTO);
        }
        return routeDTO;
    }
}
