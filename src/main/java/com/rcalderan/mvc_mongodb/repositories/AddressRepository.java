package com.rcalderan.mvc_mongodb.repositories;

import com.rcalderan.mvc_mongodb.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
}
