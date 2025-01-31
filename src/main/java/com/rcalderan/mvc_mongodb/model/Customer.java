package com.rcalderan.mvc_mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "customer")
public class Customer {
    @Id
    private String id;

    private String name;
    private String email;
}
