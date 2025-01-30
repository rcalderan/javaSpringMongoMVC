package com.rcalderan.mvc_mongodb.services;

import com.rcalderan.mvc_mongodb.dto.UserCredentials;
import com.rcalderan.mvc_mongodb.dto.UserJWTDTO;
import com.rcalderan.mvc_mongodb.model.User;
import com.rcalderan.mvc_mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean checkCredentials(UserCredentials credentials){
        try{
            Optional<User> user = userRepository.findByUsername(credentials.getUsername());
            boolean val = user.get().getPassword().equals(credentials.getPassword());
            return val;
        } catch (NoSuchElementException e){
            return false;
        }
    }
}
