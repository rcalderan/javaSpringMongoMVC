package com.rcalderan.mvc_mongodb.services;

import com.rcalderan.mvc_mongodb.dto.AddressDTO;
import com.rcalderan.mvc_mongodb.model.Address;
import com.rcalderan.mvc_mongodb.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private CepService cepService;

    @Autowired
    private AddressRepository addressRepository;

    public Address findAndSave(String cep){
        AddressDTO gotCep = cepService.searchByCep(cep);

        return  addressRepository.save(gotCep.toAddress());
    }
}
