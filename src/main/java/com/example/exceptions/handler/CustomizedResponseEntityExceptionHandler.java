package com.example.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.exceptions.ExceptionResponse;
import com.example.exceptions.UnsupportedMathOpperationException;

// Utilizado para concentrar um tratamento que será espalhado em todos os controllers
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // Utilizado para tratar as exceções mais genericas 
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(
            Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(), 
                ex.getMessage(), 
                request.getDescription(false));
        
        // Utilizado para as exceções mais genericas         
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Utilizada para tratar o nosso caso e uma operção matemática
    @ExceptionHandler(UnsupportedMathOpperationException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(
            Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(), 
                ex.getMessage(), 
                request.getDescription(false));
        
        // Utilizado para um erro feito pela pessoa, ou seja, 
        // utilizado para uma letra nesse caso         
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
