package com.electronic.esb.exception;

public class VehicleFoundException extends RuntimeException {

    public VehicleFoundException(String plateNum) {
        super("Vehicle with plate num " + plateNum + " exist");
    }
}
