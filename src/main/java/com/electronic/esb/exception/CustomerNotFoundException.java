package com.electronic.esb.exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(Integer customerId) {
        super("Customer with id " + customerId + " not found");
    }
}
