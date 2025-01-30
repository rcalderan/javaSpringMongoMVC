package com.rcalderan.mvc_mongodb.dto;

public class UserCredentials {

    private final String username;
    private final String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
