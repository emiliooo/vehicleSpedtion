package com.example.vehicleSpedition.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Route_ID", nullable = false)
    private Integer id;

    @Column(name = "Start_Point", length = 100)
    private String startPoint;

    @Column(name = "End_Point", length = 100)
    private String endPoint;

    @Column(name = "Start_Date")
    private LocalDate startDate;

    @Column(name = "End_Date")
    private LocalDate endDate;

    @Column(name = "Distance_Traveled")
    private Float distanceTraveled;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Vehicle_ID")
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Driver_ID")
    private Driver driver;

}