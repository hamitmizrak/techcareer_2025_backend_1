package com.hamitmizrak.techcareer_2025_backend_1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Status Code           : 500
// INTERNAL_SERVER_ERROR : Server Hatası
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class _404_NotFoundException extends RuntimeException {

    // Parametreli Constructor
    public _404_NotFoundException(String message) {
        super(message);
    } //end parametreli constructor

} //end class
