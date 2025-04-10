package com.example.vehicleSpedition.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "fuel_consumption", schema = "vehicle_fleet")
public class FuelConsumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Fuel_Consumption_ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Vehicle_ID")
    private Vehicle vehicle;

    @Column(name = "Refuel_Date")
    private LocalDate refuelDate;

    @Column(name = "Fuel_Amount")
    private Float fuelAmount;

    @Column(name = "Fuel_Cost")
    private Float fuelCost;

    @Column(name = "Average_Consumption")
    private Float averageConsumption;

}