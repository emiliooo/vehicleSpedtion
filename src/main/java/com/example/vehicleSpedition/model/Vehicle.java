package com.example.vehicleSpedition.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Vehicle_ID")
    private Integer vehicleId;

    @Column(name = "Brand", length = 50)
    private String brand;

    @Column(name = "Model", length = 50)
    private String model;

    @Column(name = "Registration_Number", length = 20)
    private String registrationNumber;

    @Column(name = "Production_Year")
    private Integer productionYear;

    @Column(name = "Vehicle_Type", length = 50)
    private String vehicleType;

    @Column(name = "Technical_Condition", length = 100)
    private String technicalCondition;

    @Column(name = "Last_Inspection_Date")
    private Date lastInspectionDate;

}
