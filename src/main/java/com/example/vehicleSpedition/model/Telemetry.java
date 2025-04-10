package com.example.vehicleSpedition.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "telemetry", schema = "vehicle_fleet")
public class Telemetry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Telemetry_Data_ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Vehicle_ID")
    private Vehicle vehicle;

    @Column(name = "Average_Speed")
    private Float averageSpeed;

    @Column(name = "Max_Speed")
    private Float maxSpeed;

    @Column(name = "Engine_Working_Time")
    private LocalTime engineWorkingTime;

    @Column(name = "GPS_Location")
    private String gpsLocation;

}