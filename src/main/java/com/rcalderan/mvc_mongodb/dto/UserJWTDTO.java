package com.rcalderan.mvc_mongodb.dto;

public class UserJWTDTO {
    private final String username;
    private final Long timeout;

    public Long getTimeout() {
        return timeout;
    }

    public String getUsername() {
        return username;
    }

    public UserJWTDTO(String username) {
        this.username = username;
        this.timeout = System.currentTimeMillis()+60*60*1000;
    }
}
