package com.rcalderan.mvc_mongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class UserCredentials {
    private final String username;
    private final String password;

}
