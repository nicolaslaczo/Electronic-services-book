package com.electronic.esb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomerNotFoundException (CustomerNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(CustomerFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomerFoundException (CustomerFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.FOUND).body(errorResponse);
    }
}
