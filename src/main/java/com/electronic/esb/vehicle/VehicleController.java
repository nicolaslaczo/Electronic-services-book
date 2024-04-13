package com.electronic.esb.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class VehicleController {
    @Autowired
    private VehicleService service;


    @GetMapping("/admin/vehicles/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable Integer id) {
        VehicleDTO vehicleDTO = service.getVehicleById(id);
        return ResponseEntity.ok(vehicleDTO);
    }

    @GetMapping("/admin/vehicles")
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        List<VehicleDTO> vehicleDTOS = service.getAllVehicles();
        return ResponseEntity.ok(vehicleDTOS);
    }

    @PostMapping("/admin/vehicles")
    public ResponseEntity<HttpStatus> addVehicle(@RequestBody VehicleDTO vehicleDTO) {
        service.addVehicle(vehicleDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/admin/vehicles/{id}")
    public ResponseEntity<HttpStatus> updateVehicle(
            @PathVariable Integer id,
            @RequestBody VehicleDTO vehicleDTO
    ) {
        service.updateVehicle(id,vehicleDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/admin/vehicles/id")
    public ResponseEntity<HttpStatus> deleteVehicleById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }























}
