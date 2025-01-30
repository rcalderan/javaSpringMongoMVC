package com.rcalderan.mvc_mongodb;

import com.rcalderan.mvc_mongodb.model.Customer;
import com.rcalderan.mvc_mongodb.model.User;
import com.rcalderan.mvc_mongodb.repositories.CustomerRepository;
import com.rcalderan.mvc_mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DataInicializer implements CommandLineRunner {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        this.insertUser();
        this.populateCutomers();
    }

    @Transactional
    private void insertUser(){
        userRepository.deleteAll();
        userRepository.save(new User("teste", "senha"));
    }

    @Transactional
    private void populateCutomers(){
        customerRepository.deleteAll();
        List<Customer> initialCustomers = List.of(
                new Customer(null, "Cliente 1", "cliente1@email.com"),
                new Customer(null, "Cliente 2", "cliente2@email.com"),
                new Customer(null, "Cliente 3", "cliente3@email.com"),
                new Customer(null, "Cliente 4", "cliente4@email.com"),
                new Customer(null, "Cliente 5", "cliente5@email.com"),
                new Customer(null, "Cliente 6", "cliente6@email.com"),
                new Customer(null, "Cliente 7", "cliente7@email.com"),
                new Customer(null, "Cliente 8", "cliente8@email.com"),
                new Customer(null, "Cliente 9", "cliente9@email.com"),
                new Customer(null, "Cliente 10", "cliente10@email.com")
        );
        customerRepository.saveAll(initialCustomers);
        System.out.println("Clientes iniciais inseridos no MongoDB!");
    }

}
