package com.rcalderan.mvc_mongodb.services;

import com.rcalderan.mvc_mongodb.dto.UserCredentials;
import com.rcalderan.mvc_mongodb.exceptions.NotFoundException;
import com.rcalderan.mvc_mongodb.model.User;
import com.rcalderan.mvc_mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean checkCredentials(UserCredentials credentials){
        Optional<User> user = userRepository.findByUsername(credentials.getUsername());
        if(user.isPresent()){
            return user.get().getPassword().equals(credentials.getPassword());
        } else{
            throw new NotFoundException("Unauthorized!");
        }
    }
}
