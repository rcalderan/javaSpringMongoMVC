package com.rcalderan.mvc_mongodb.dto;

public class CustomerMinDTO {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CustomerMinDTO() {
    }
    public CustomerMinDTO(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
