package com.example.negozio2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class AlreadyRegisteredException extends RuntimeException {
    private String message;

    public AlreadyRegisteredException(String message) {
        super(message);
    }
}
