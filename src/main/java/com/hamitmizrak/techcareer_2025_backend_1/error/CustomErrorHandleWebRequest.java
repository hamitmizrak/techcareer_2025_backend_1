package com.hamitmizrak.techcareer_2025_backend_1.error;

import com.hamitmizrak.techcareer_2025_backend_1.exception.HamitMizrakException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LOMBOK
@Log4j2
@RequiredArgsConstructor

/*
Hata Yönetimini Merkezi Hale Getirme:
Uygulamanızdaki tüm hata durumlarını tek bir yerden kontrol etmek ve yönetmek için bu altyapı oldukça güçlüdür.
*/

// ErrorController (1)
// ErrorAttributes (2)
// WebRequest      (3)

@RestController //api
@CrossOrigin
public class CustomErrorHandleWebRequest implements ErrorController {

    // 1.YOL (Field Injection)
    //@Autowired
    //private ErrorAttributes errorAttributes;

    // 2.YOL (Constructor Injection)
    //private ErrorAttributes errorAttributes;
    //private final ErrorAttributes errorAttributes;
    /*
    @Autowired
    public CustomErrorHandleWebRequest(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }
    */

    // 3.YOL (Lombok Injection)
    private final ErrorAttributes errorAttributes;

    // Api Result Field
    // sm pv
    private int status;
    private String message;
    private String path;
    private Map<String, Object> validationErrors;

    // ApiResult
    private ApiResult apiResult;


    // http://localhost:4444/error
    @RequestMapping("/error")
    public ApiResult handleErrorMethod(WebRequest webRequest) {
        // Spring>=2.3 sonrasında aşağıdaki gibi yazılıyor.
        Map<String, Object> attributes = errorAttributes.getErrorAttributes(
                webRequest,
                ErrorAttributeOptions.of(
                        ErrorAttributeOptions.Include.MESSAGE,
                        ErrorAttributeOptions.Include.BINDING_ERRORS
                )); //end attributes

        // Spring'ten gelen hata verilerini almak
        status = attributes.get("status") == null ? 0 : Integer.parseInt(attributes.get("status").toString());
        message = (String) attributes.get("message"); //attributes.get("message").toString();
        path = (String) attributes.get("path"); //attributes.get("path").toString();

        //  public ApiResult(String path, String message, int status)
        apiResult = new ApiResult(path, message, status);

        // attributes içinde hataları yani errorsları alacağım
        if (attributes.containsKey("errors")) {
            List<FieldError> fieldErrors = (List<FieldError>) attributes.get("errors");

            // ValidationError Instance
            validationErrors = new HashMap<>();
            for (FieldError fieldError : fieldErrors) {
                validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }

            // apiResult Validation Set Yap
            apiResult.setValidationErrors(validationErrors);
        }

        return apiResult;
    } // handleErrorMethod

    // TEST
    // http://localhost:4444/test/apiresult
    @GetMapping("/test/apiresult")
    public String errorTest() {
        //throw new HamitMizrakException("İsteyerek Hata Gönder");
        throw new RuntimeException("İsteyerek Hata Gönder");
    }

} //end CustomErrorHandleWebRequest
