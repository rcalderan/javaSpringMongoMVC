package com.rcalderan.mvc_mongodb.controllers;

import com.rcalderan.mvc_mongodb.dto.AddressDTO;
import com.rcalderan.mvc_mongodb.model.Address;
import com.rcalderan.mvc_mongodb.services.AddressService;
import com.rcalderan.mvc_mongodb.services.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepController {
    @Autowired
    private CepService cepService;

    @Autowired
    private AddressService addressService;

    @GetMapping("/{cep}")
    public AddressDTO findCep(@PathVariable String cep){
        return cepService.searchByCep(cep);
    }

    @GetMapping("/{cep}/save")
    public Address findAndSaveCep(@PathVariable String cep){
        return addressService.findAndSave(cep);
    }
}
