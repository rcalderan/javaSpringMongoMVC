package com.rcalderan.mvc_mongodb.services;

import com.rcalderan.mvc_mongodb.dto.AddressDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {
    private static final String BRASIL_API_URL = "https://brasilapi.com.br/api/cep/v2/{cep}";

    private final RestTemplate restTemplate;

    public CepService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public AddressDTO searchByCep(String cep) {
        // Faz a requisição à API
        AddressDTO response = restTemplate.getForObject(
                BRASIL_API_URL,
                AddressDTO.class,
                cep
        );

        if (response == null) {
            throw new RuntimeException("CEP não encontrado ou erro na API.");
        }

        return response;
    }

}
