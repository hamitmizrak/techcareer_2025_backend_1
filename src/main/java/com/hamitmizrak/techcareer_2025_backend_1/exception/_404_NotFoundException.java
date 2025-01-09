package com.hamitmizrak.techcareer_2025_backend_1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Status Code           : 404
// NOT_FOUND             : Bulunamadı
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class _404_NotFoundException extends RuntimeException {

    // Parametreli Constructor
    public _404_NotFoundException(String message) {
        super(message);
    } //end parametreli constructor

} //end class
