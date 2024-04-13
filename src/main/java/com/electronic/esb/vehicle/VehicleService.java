package com.electronic.esb.vehicle;

import com.electronic.esb.customer.Customer;
import com.electronic.esb.exception.VehicleFoundException;
import com.electronic.esb.exception.VehicleNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    ModelMapper mapper;

    // Get vehicle by id
    public VehicleDTO getVehicleById(Integer id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException(id));

        return mapper.map(vehicle, VehicleDTO.class);
    }

    // Get all vehicles

    public List<VehicleDTO> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles
                .stream()
                .map(vehicle -> mapper.map(vehicle, VehicleDTO.class))
                .collect(Collectors.toList());
    }

    // Add new vehicle
    public void addVehicle(VehicleDTO vehicleDTO) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findByPlateNum(vehicleDTO.getPlateNum());
        if (optionalVehicle.isPresent()) {
            throw new VehicleFoundException(vehicleDTO.getPlateNum());
        } else {
            Vehicle vehicle = mapper.map(vehicleDTO, Vehicle.class);
            vehicleRepository.save(vehicle);
        }
    }

    // Update vehicle

    public void updateVehicle(Integer id,VehicleDTO vehicleDTO) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        if (optionalVehicle.isPresent()) {
            Vehicle existingVehicle = optionalVehicle.get();
            existingVehicle.setMaker(vehicleDTO.getMaker());
            existingVehicle.setModel(vehicleDTO.getModel());
            existingVehicle.setPlateNum(vehicleDTO.getPlateNum());
            vehicleRepository.save(existingVehicle);
        } else {
            throw new VehicleNotFoundException(vehicleDTO.getId());
        }
    }

    // Delete vehicle by plateNum

    public void deleteById(Integer id) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);
        if (optionalVehicle.isPresent()) {
            vehicleRepository.deleteById(id);
        }else {
            throw new VehicleNotFoundException(id);
        }
    }












}
