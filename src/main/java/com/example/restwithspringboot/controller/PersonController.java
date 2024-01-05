package com.example.restwithspringboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.restwithspringboot.model.Person;
import com.example.restwithspringboot.services.PersonServices;


@RestController
@RequestMapping("/person")
public class PersonController {

    // Com isso o spring cuida da instanciação da variavel em tempo de execução
    // Precisa da utilização da anotation @Service
    @Autowired
    private PersonServices service;

    // Entre chaves é necessário passar parâmetros obrigatórios
    @RequestMapping(value = "/{id}", 
                    method = RequestMethod.GET, 
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") String id){
            return service.findById(id);
    }

   
   
}
