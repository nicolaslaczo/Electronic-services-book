package com.electronic.esb.exception;

public class VehicleNotFoundException extends RuntimeException{

    public VehicleNotFoundException(Integer vehicleId) {
        super("Vehicle with id " + vehicleId + " not found");
    }

    public VehicleNotFoundException(String plateNum) {
        super("Vehicle with plate num " + plateNum + " don't exists" );
    }
}
