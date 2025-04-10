package com.example.vehicleSpedition.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Driver_ID")
    private Integer driverId;

    @Column(name = "Full_Name", length = 100)
    private String fullName;

    @Column(name = "License_Number", length = 50)
    private String licenseNumber;

    @Column(name = "License_Category", length = 20)
    private String licenseCategory;

    @Column(name = "Contact_Phone", length = 15)
    private String contactPhone;

    @Column(name = "Incident_History", columnDefinition = "TEXT")
    private String incidentHistory;

}

