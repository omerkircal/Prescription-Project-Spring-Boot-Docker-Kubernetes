package com.work.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RawMaterialsNotFoundException extends RuntimeException {
    public RawMaterialsNotFoundException(String message) {
        super(message);
    }
}
