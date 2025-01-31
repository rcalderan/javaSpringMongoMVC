package com.rcalderan.mvc_mongodb.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rcalderan.mvc_mongodb.config.JwtConfig;
import com.rcalderan.mvc_mongodb.dto.UserCredentials;
import com.rcalderan.mvc_mongodb.dto.UserJWTDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class JwtService {

    private static final Logger logger = LogManager.getLogger(JwtService.class);

    @Autowired
    private JwtConfig jwtConf;

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Generates a JSON Web Token (JWT).
     *
     * @param credentials User credentials containing the username.
     * @return The generated JWT as a string, or an error message if generation fails.
     */
    public String generate(UserCredentials credentials){
        try{
            UserJWTDTO dto = new UserJWTDTO(credentials.getUsername());
            String json = objectMapper.writeValueAsString(dto);
            Algorithm algorithm = Algorithm.HMAC256(jwtConf.getSecret());

            Instant now = Instant.now();
            Instant exp = now.plus(1, ChronoUnit.HOURS); // Token expires in 1 hour. Adjust as needed.

            return JWT.create()//
                    .withClaim("user", json)
                    .withSubject(credentials.getUsername())
                    .withIssuer("auth0")
                    .withIssuedAt(Date.from(now))
                    .withExpiresAt(Date.from(exp))
                    .sign(algorithm);

        }catch (JsonProcessingException e){
            logger.error("Error serializing user data to JSON", e);
            return "JWT generation failed";
        } catch (Exception e) {
            logger.error("An error occurred during JWT generation", e);
            return "JWT generation failed";
        }
    }
}
