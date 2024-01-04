package com.example.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.example.model.Person;

// Utilizado pelo spring para injetar dados em outras classes durante a aplicação
@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){
        logger.info("Finding one person");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Sérgio");
        person.setLastName("Peres");
        person.setGender("Masculino");
        person.setAdress("Lavras");

        return person;
    }
}
