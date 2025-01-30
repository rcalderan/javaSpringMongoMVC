package com.rcalderan.mvc_mongodb.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rcalderan.mvc_mongodb.config.JwtConfig;
import com.rcalderan.mvc_mongodb.dto.UserCredentials;
import com.rcalderan.mvc_mongodb.dto.UserJWTDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Autowired
    private JwtConfig jwtConf;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String generate(UserCredentials credentials){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            UserJWTDTO dto = new UserJWTDTO(credentials.getUsername());
            String json = objectMapper.writeValueAsString(dto);
            Algorithm algorithm = Algorithm.HMAC256(jwtConf.getSecret());
            return JWT.create()//
                    .withClaim("user", json)
                    .withSubject(credentials.getUsername())
                    .withIssuer("auth0")
                    .sign(algorithm);

        }catch (JsonProcessingException e){
            return "JSON serialize error";

        } catch (Exception e) {
            return "An error occurred!";
        }
    }
}
