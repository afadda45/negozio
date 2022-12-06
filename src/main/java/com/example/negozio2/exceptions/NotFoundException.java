package com.example.negozio2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class NotFoundException extends RuntimeException {
    private String message;

    public NotFoundException(String message) {
        super(message);
    }
}
