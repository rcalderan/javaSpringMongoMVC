package com.rcalderan.mvc_mongodb.controllers;

import com.rcalderan.mvc_mongodb.dto.CustomerMinDTO;
import com.rcalderan.mvc_mongodb.model.Customer;
import com.rcalderan.mvc_mongodb.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping
    public List<CustomerMinDTO> listAllMinCustomer(){
        return service.allMin();
    }

    @PostMapping
    public Customer save(@RequestBody Customer customer){
        return service.save(customer);
    }

}
