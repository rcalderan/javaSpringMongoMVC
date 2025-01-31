package com.rcalderan.mvc_mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

@Data
@AllArgsConstructor
@Builder
@Document(collection = "addresses") // Define o nome da coleção no MongoDB
public class Address {

    @Id
    private String id; // O MongoDB usa um campo _id como chave primária

    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String service;

    @Field("location") // Mapeia o campo "location" do JSON
    private GeoJsonPoint location;

    @Builder
    public Address(String cep, String state, String city, String neighborhood, String street, String service, GeoJsonPoint location){
        this.cep = cep;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.service =service;
        this.location =location;
    }
}