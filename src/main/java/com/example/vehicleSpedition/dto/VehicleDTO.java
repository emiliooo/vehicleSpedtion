package com.example.vehicleSpedition.dto;

import lombok.Data;

import java.util.Date;

@Data
public class VehicleDTO {

    private Integer id;
    private Integer vehicleId;
    private String brand;
    private String model;
    private String registrationNumber;
}
