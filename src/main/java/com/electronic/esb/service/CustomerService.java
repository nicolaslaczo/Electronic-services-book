package com.electronic.esb.service;

import com.electronic.esb.DTO.CustomerDTO;
import com.electronic.esb.config.ModelMapperConfig;
import com.electronic.esb.exception.CustomerFoundException;
import com.electronic.esb.exception.CustomerNotFoundException;
import com.electronic.esb.model.Customer;
import com.electronic.esb.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper mapper;




    // Add new customer
    public void addCustomer(CustomerDTO customerDTO) {
        Optional<Customer> customerOptional = customerRepository.findByFirstNameAndLastName(customerDTO.getFirstName(),customerDTO.getLastName());
        if (customerOptional.isPresent()) {
            throw new CustomerFoundException(customerDTO.getFirstName(),customerDTO.getLastName());
        } else {
            Customer customer = mapper.map(customerDTO,Customer.class);
            customerRepository.save(customer);
        }

    }


    // Get all customers
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList
                .stream()
                .map(customer -> mapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    // Get customer by id
    public CustomerDTO getCustomerById(Integer customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));

        return mapper.map(customer,CustomerDTO.class);
    }

    // Update customer by id
    public void updateCustomerById(Integer customerId,CustomerDTO customerDTO) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer existingCustomer = customerOptional.get();
            existingCustomer.setFirstName(customerDTO.getFirstName());
            existingCustomer.setLastName(customerDTO.getLastName());
            existingCustomer.setEmail(customerDTO.getEmail());
            existingCustomer.setPhoneNum(customerDTO.getPhoneNum());
            existingCustomer.setCity(customerDTO.getCity());
            existingCustomer.setStreet(customerDTO.getStreet());
            existingCustomer.setHouseNum(customerDTO.getHouseNum());
            customerRepository.save(existingCustomer);
        }else {
            throw new CustomerNotFoundException(customerDTO.getId());
        }
    }

    // Delete customer by id

    public void deleteCustomerById(Integer customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            customerRepository.deleteById(customerId);
        }else {
            throw new CustomerNotFoundException(customerId);
        }
    }



















}
