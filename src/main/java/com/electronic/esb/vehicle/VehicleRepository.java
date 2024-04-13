package com.electronic.esb.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {

    Optional<Vehicle> findByPlateNum(String plateNum);

    void deleteByPlateNum(String plateNum);
}
