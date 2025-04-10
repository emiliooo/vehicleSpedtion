package com.example.vehicleSpedition.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "maintenance_and_repairs", schema = "vehicle_fleet")
public class MaintenanceAndRepair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Repair_ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Vehicle_ID")
    private Vehicle vehicle;

    @Column(name = "Repair_Type", length = 100)
    private String repairType;

    @Column(name = "repair_date")
    private Integer repairDate;

    @Column(name = "repair_cost")
    private Integer repairCost;

    @Lob
    @Column(name = "Problem_Description")
    private String problemDescription;

}