package com.rcalderan.mvc_mongodb.repositories;

import com.rcalderan.mvc_mongodb.dto.CustomerMinDTO;
import com.rcalderan.mvc_mongodb.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Optional<CustomerMinDTO> findByEmail(String email);
}
