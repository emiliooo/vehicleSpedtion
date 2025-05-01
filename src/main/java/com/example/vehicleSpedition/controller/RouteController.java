package com.example.vehicleSpedition.controller;

import com.example.vehicleSpedition.dto.RouteDTO;
import com.example.vehicleSpedition.model.Route;
import com.example.vehicleSpedition.repository.RouteRepository;
import com.example.vehicleSpedition.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RouteController {

    @Autowired
    private RouteService  routeService;
    private RouteRepository routeRepository;

    public RouteController(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @GetMapping("/routes")
    public List<RouteDTO> getAllRoutes() {

        List<Route> routes = routeRepository.findAll();
       return routes.stream()
                .map(route -> this.routeService.convertToDTO(route))
                .collect(Collectors.toList());
    }

}
