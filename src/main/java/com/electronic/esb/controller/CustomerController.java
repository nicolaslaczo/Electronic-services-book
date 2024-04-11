package com.electronic.esb.controller;

import com.electronic.esb.DTO.CustomerDTO;
import com.electronic.esb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService service;


    @PostMapping("/admin/customer")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDTO customerDTO) {
        service.addCustomer(customerDTO);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/admin/customer/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Integer id) {
        CustomerDTO customerDTO = service.getCustomerById(id);
        return ResponseEntity.ok(customerDTO);
    }


    @GetMapping("/admin/customer")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customerDTOList = service.getAllCustomers();
        return ResponseEntity.ok(customerDTOList);
    }

    @PutMapping("/admin/customer/{id}")
    public ResponseEntity<HttpStatus> updateCustomerById(@PathVariable Integer id,
                                                         @RequestBody CustomerDTO customerDTO) {
        service.updateCustomerById(id,customerDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/admin/customer/{id}")
    public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable Integer id) {
        service.deleteCustomerById(id);
        return ResponseEntity.ok().build();
    }





























}
