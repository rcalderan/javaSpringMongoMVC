package com.rcalderan.mvc_mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

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

    // Construtores
    public Address() {
    }

    public Address(String cep, String state, String city, String neighborhood, String street, String service, GeoJsonPoint location) {
        this.cep = cep;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.service = service;
        this.location = location;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public GeoJsonPoint getLocation() {
        return location;
    }

    public void setLocation(GeoJsonPoint location) {
        this.location = location;
    }

    // Método toString para facilitar a visualização
    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", cep='" + cep + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", street='" + street + '\'' +
                ", service='" + service + '\'' +
                ", location=" + location +
                '}';
    }
}