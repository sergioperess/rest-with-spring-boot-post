package com.example.restwithspringboot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.example.restwithspringboot.model.Person;

// Utilizado pelo spring para injetar dados em outras classes durante a aplicação
@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        logger.info("Finding All people");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person create(Person person){
        logger.info("Creating one people");
        return person;
    }

    public Person update(Person person){
        logger.info("Updating one people");
        return person;
    }

    public void delete(String id){
        logger.info("Deleting one people");
    }

    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person first name " + i);
        person.setLastName("Person last name " + i);
        person.setGender("person gender " + i);
        person.setAdress("Person adress " + i);

        return person;
    }

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
