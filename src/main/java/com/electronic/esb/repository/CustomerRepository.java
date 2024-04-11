package com.electronic.esb.repository;

import com.electronic.esb.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Optional<Customer> findByFirstNameAndLastName(String firstName, String lastName);
}
