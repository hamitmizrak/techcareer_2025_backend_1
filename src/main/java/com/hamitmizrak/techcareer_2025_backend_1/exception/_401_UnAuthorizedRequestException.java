package com.hamitmizrak.techcareer_2025_backend_1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Status Code : 401
// UNAUTHORIZED : Login Oldun mu ?
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class _401_UnAuthorizedRequestException extends RuntimeException {

    // Parametreli Constructor
    public _401_UnAuthorizedRequestException(String message) {
        super(message);
    } //end parametreli constructor

} //end class
