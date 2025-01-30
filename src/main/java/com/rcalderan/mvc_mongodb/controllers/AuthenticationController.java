package com.rcalderan.mvc_mongodb.controllers;

import com.rcalderan.mvc_mongodb.dto.UserCredentials;
import com.rcalderan.mvc_mongodb.services.JwtService;
import com.rcalderan.mvc_mongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private JwtService jwt;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/generate")
    public String getToken(@RequestBody UserCredentials credentials){
        if(userService.checkCredentials(credentials)){
        //if ("user".equals(credentials.getUsername()) && "password".equals(credentials.getPassword())) {
            return jwt.generate(credentials);
        } else {
            throw new RuntimeException("Invalid User!");
        }
    }
}
