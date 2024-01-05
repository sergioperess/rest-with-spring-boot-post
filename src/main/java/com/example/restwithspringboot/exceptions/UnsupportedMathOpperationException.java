package com.example.restwithspringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Retorna um código de erro
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOpperationException extends RuntimeException{
     public UnsupportedMathOpperationException(String ex){
          super(ex);
     }
     
     private static final long serialVersionUID = 1L;    
}