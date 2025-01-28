package com.rcalderan.mvc_mongodb.repositories;

import com.rcalderan.mvc_mongodb.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
