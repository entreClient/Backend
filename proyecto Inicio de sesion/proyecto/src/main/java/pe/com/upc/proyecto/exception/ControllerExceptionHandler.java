package com.upc.trabajo_final.Trabajo.Final.Entreclient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                "Resource Not Found",
                LocalDateTime.now()
        );
        return message;
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage validationException(ValidationException ex){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                "Validation Error",
                LocalDateTime.now()
        );
        return message;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage globalExceptionHandler(Exception ex){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                "Internal Server Error",
                LocalDateTime.now()
        );
        return message;
    }
}
