package com.rcalderan.mvc_mongodb.services;

import com.rcalderan.mvc_mongodb.dto.CustomerMinDTO;
import com.rcalderan.mvc_mongodb.model.Customer;
import com.rcalderan.mvc_mongodb.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerMinDTO> allMin(){
        return customerRepository.findAll().stream().map(x -> new CustomerMinDTO(x.getId(), x.getName())).toList();
    }

    public Optional<CustomerMinDTO> findByEmail(String email){
        return  customerRepository.findByEmail(email);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
