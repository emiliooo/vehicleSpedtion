package com.example.vehicleSpedition.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "road_events", schema = "vehicle_fleet")
public class RoadEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Event_ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Vehicle_ID")
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Driver_ID")
    private Driver driver;

    @Column(name = "Event_Date")
    private LocalDate eventDate;

    @Lob
    @Column(name = "Event_Description")
    private String eventDescription;

    @Column(name = "Event_Costs")
    private Float eventCosts;

}