package com.hamitmizrak.techcareer_2025_backend_1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Status Code: 201
// CREATED    : Oluşturuldu
@ResponseStatus(value = HttpStatus.CREATED)
public class _201_CreatedException extends RuntimeException {

    // Parametreli Constructor
    public _201_CreatedException(String message) {
        super(message);
    } //end Parametreli Constructor
} //end class _201_CreatedException
