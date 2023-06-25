package com.upc.trabajo_final.Trabajo.Final.Entreclient.exception;

public class ValidationException extends RuntimeException{
    public ValidationException(String message) {
        super(message);
    }
    public ValidationException() {
        super();
    }
}
