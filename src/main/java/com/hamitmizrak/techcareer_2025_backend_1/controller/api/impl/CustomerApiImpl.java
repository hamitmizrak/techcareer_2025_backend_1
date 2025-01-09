package com.hamitmizrak.techcareer_2025_backend_1.controller.api.impl;


import com.hamitmizrak.techcareer_2025_backend_1.business.dto.CustomerDto;
import com.hamitmizrak.techcareer_2025_backend_1.business.services.interfaces.ICustomerService;
import com.hamitmizrak.techcareer_2025_backend_1.controller.api.interfaces.ICustomerApi;
import com.hamitmizrak.techcareer_2025_backend_1.error.ApiResult;
import com.hamitmizrak.techcareer_2025_backend_1.exception._400_BadRequestException;
import com.hamitmizrak.techcareer_2025_backend_1.utils.FrontEnd;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// Api: Dış dünyaya açılan kapı
@RestController
@RequestMapping("/api/customer/v1.0.0")
// @CrossOrigin
// @CrossOrigin(origins = "http://localhost:4000")
@CrossOrigin(origins = {FrontEnd.REACT_URL, FrontEnd.ANGULAR_URL})
public class CustomerApiImpl implements ICustomerApi<CustomerDto> {

    // Injection
    private final ICustomerService iCustomerService;
    private final MessageSource messageSource;

    // ApiResult Instance
    private ApiResult apiResult;

    /////////////////////////////////////////////////////////////////////////////////////////////////
    // CRUD

    // CREATE
    // http://localhost:4444/api/customer/v1.0.0/create
    @PostMapping("/create")
    @Override
    public ResponseEntity<?> objectApiCreate(@Valid @RequestBody CustomerDto customerDto) {
        CustomerDto customerDtoCreate= (CustomerDto) iCustomerService.objectServiceCreate(customerDto);
        // return ResponseEntity.status(201).body(customerDtoCreate); //1.YOL
        // return ResponseEntity.status(HttpStatus.CREATED).body(customerDtoCreate); //2.YOL
        // return new ResponseEntity<>(customerDtoCreate,HttpStatus.CREATED); //3.YOL
        // return  ResponseEntity.ok().body(customerDtoCreate); //4.YOL
        return  ResponseEntity.ok(customerDtoCreate); //5.YOL
    }

    // LIST
    // http://localhost:4444/api/customer/v1.0.0/list
    @GetMapping(value = "/list")
    @Override
    public ResponseEntity<List<CustomerDto>> objectApiList() {
        List<CustomerDto> customerDtoList = iCustomerService.objectServiceList();
        // Stream Value
        return ResponseEntity.ok(customerDtoList);
    }

    // FIND BY ID
    // http://localhost:4444/api/customer/v1.0.0/find
    // http://localhost:4444/api/customer/v1.0.0/find/0
    // http://localhost:4444/api/customer/v1.0.0/find/-1
    // http://localhost:4444/api/customer/v1.0.0/find/%20%    boşluk:%20%
    // http://localhost:4444/api/customer/v1.0.0/find/1
    @GetMapping({"/find/","/find/{id}"})
    @Override
    public ResponseEntity<?> objectApiFindById(@PathVariable(name="id",required = false) Long id) { //NOT: @PathVariable sadece yazabiliriz
        String message="";
        if(id ==null){
            throw new NullPointerException("Null Pointer Exception: Null değer");
        }else if(id==0){
            throw new _400_BadRequestException("Bad Request Exception: Kötü istek");
        } else if(id<0){
            // Config ApiResultValidationMessage
            // resource/ValidationMessages/ValidationMessages.properties => error.unauthorized
            message= messageSource.getMessage("error.unauthorized",null, LocaleContextHolder.getLocale());
            apiResult= new ApiResult();
            apiResult.setError("unAuthorized: Yetkisiz Giriş");
            apiResult.setPath("/api/customer/v1.0.0/find");
            apiResult.setStatus(HttpStatus.UNAUTHORIZED.value());
            apiResult.setMessage(message);
            return ResponseEntity.ok(apiResult);
        }
        // customer Find By Id
        CustomerDto customerDtoFind= (CustomerDto) iCustomerService.objectServiceFindById(id);
        return ResponseEntity.ok(customerDtoFind);
    }

    // UPDATE
    // http://localhost:4444/api/customer/v1.0.0/update/1
    @PutMapping({"/update/","/update/{id}"})
    @Override
    public ResponseEntity<?> objectApiUpdate(@PathVariable(name = "id",required = false)  Long id, @Valid @RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(iCustomerService.objectServiceUpdate(id, customerDto));
    }

    // DELETE
    // http://localhost:4444/api/customer/v1.0.0/delete/1
    @DeleteMapping({"/delete/","/delete/{id}"})
    @Override
    public ResponseEntity<?> objectApiDelete(@PathVariable(name = "id",required = false) Long id) {
        return ResponseEntity.ok(iCustomerService.objectServiceDelete(id));
    }

} //end CustomerApiImpl
