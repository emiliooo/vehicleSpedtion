package com.example.vehicleSpedition.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RouteDTO {

    private Integer id;
    private String startPoint;
    private String endPoint;
    private Float distanceTraveled;
    private VehicleDTO vehicle;
    private DriverDTO driver;

}
