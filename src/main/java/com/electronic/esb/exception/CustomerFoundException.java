package com.electronic.esb.exception;

public class CustomerFoundException extends RuntimeException{
    public CustomerFoundException(String firstName,String lastName) {
        super("Customer " + firstName + " " + lastName + " exists in database");
    }
}
