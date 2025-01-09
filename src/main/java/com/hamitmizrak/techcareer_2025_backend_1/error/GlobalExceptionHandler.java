package com.hamitmizrak.techcareer_2025_backend_1.error;

import com.hamitmizrak.techcareer_2025_backend_1.exception._400_BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
// @ControllerAdvice
public class GlobalExceptionHandler {

    // Eğer bir global hata işleyici kullanıyorsanız (@RestControllerAdvice veya @ControllerAdvice),
    // Actuator endpoint'lerini bu işleyiciden hariç tutun.
    /*
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        // Actuator endpoint'lerini hariç tutun
        if (e.getMessage().contains("actuator")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }*/

    // NullPointerException
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException nullPointerException) {
        return new ResponseEntity<>(nullPointerException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // badRequestException
    @ExceptionHandler(_400_BadRequestException.class)
    public ResponseEntity<String> handleNullPointerException(_400_BadRequestException badRequestException) {
        return new ResponseEntity<>(badRequestException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Genel Exception: Özel yazmadığımız(_400_BadRequestException) bütün Exceptionları yakar
    /*
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleCommonrException(Exception exception) {
        return new ResponseEntity<>("Beklenmeyen bir hata: "+exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    */
} //end GlobalExceptionHandler
