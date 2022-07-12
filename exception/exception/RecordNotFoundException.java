package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not available")
public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
    public RecordNotFoundException(){};
}
