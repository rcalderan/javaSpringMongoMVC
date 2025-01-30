package com.rcalderan.mvc_mongodb.controllers;

import com.rcalderan.mvc_mongodb.dto.AddressDTO;
import com.rcalderan.mvc_mongodb.dto.CustomerMinDTO;
import com.rcalderan.mvc_mongodb.exceptions.NotFoundException;
import com.rcalderan.mvc_mongodb.model.Customer;
import com.rcalderan.mvc_mongodb.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{email}")
    public CustomerMinDTO findEmail(@PathVariable String email){
        return service.findByEmail(email)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
    }

}
