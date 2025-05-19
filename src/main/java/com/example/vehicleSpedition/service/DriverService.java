package com.example.vehicleSpedition.service;
import com.example.vehicleSpedition.model.Driver;
import com.example.vehicleSpedition.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

   private final DriverRepository DriverRepository;

   @Autowired
   DriverService(DriverRepository driverRepository) {
       this.DriverRepository = driverRepository;
   }

   public List<Driver> findAll() {
       return DriverRepository.findAll();
   }

   public Driver addDriver(Driver driver) {
       return DriverRepository.save(driver);
   }

   public Driver updateDriver(Driver driver) {
       return DriverRepository.save(driver);
   }

   public Driver findDriverById(Integer IDdriver) {
       return DriverRepository.findDriverByDriverId(IDdriver);
   }

   public void deleteDriver(Long IDdriver) {
       DriverRepository.deleteById(IDdriver);
   }

}
