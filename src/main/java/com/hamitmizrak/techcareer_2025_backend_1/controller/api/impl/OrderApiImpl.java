package com.hamitmizrak.techcareer_2025_backend_1.controller.api.impl;


import com.hamitmizrak.techcareer_2025_backend_1.business.dto.OrderDto;
import com.hamitmizrak.techcareer_2025_backend_1.business.services.interfaces.IOrderService;
import com.hamitmizrak.techcareer_2025_backend_1.controller.api.interfaces.IOrderApi;
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
@RequestMapping("/api/order/v1.0.0")
// @CrossOrigin
// @CrossOrigin(origins = "http://localhost:4000")
@CrossOrigin(origins = {FrontEnd.REACT_URL, FrontEnd.ANGULAR_URL})
public class OrderApiImpl implements IOrderApi<OrderDto> {

    // Injection
    private final IOrderService iOrderService;
    private final MessageSource messageSource;

    // ApiResult Instance
    private ApiResult apiResult;

    /////////////////////////////////////////////////////////////////////////////////////////////////
    // CRUD

    // CREATE
    // http://localhost:4444/api/order/v1.0.0/create
    @PostMapping("/create")
    @Override
    public ResponseEntity<?> objectApiCreate(@Valid @RequestBody OrderDto orderDto) {
        OrderDto orderDtoCreate= (OrderDto) iOrderService.objectServiceCreate(orderDto);
        // return ResponseEntity.status(201).body(orderDtoCreate); //1.YOL
        // return ResponseEntity.status(HttpStatus.CREATED).body(orderDtoCreate); //2.YOL
        // return new ResponseEntity<>(orderDtoCreate,HttpStatus.CREATED); //3.YOL
        // return  ResponseEntity.ok().body(orderDtoCreate); //4.YOL
        return  ResponseEntity.ok(orderDtoCreate); //5.YOL
    }

    // LIST
    // http://localhost:4444/api/order/v1.0.0/list
    @GetMapping(value = "/list")
    @Override
    public ResponseEntity<List<OrderDto>> objectApiList() {
        List<OrderDto> orderDtoList = iOrderService.objectServiceList();
        // Stream Value
        return ResponseEntity.ok(orderDtoList);
    }

    // FIND BY ID
    // http://localhost:4444/api/order/v1.0.0/find
    // http://localhost:4444/api/order/v1.0.0/find/0
    // http://localhost:4444/api/order/v1.0.0/find/-1
    // http://localhost:4444/api/order/v1.0.0/find/%20%    boşluk:%20%
    // http://localhost:4444/api/order/v1.0.0/find/1
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
            apiResult.setPath("/api/order/v1.0.0/find");
            apiResult.setStatus(HttpStatus.UNAUTHORIZED.value());
            apiResult.setMessage(message);
            return ResponseEntity.ok(apiResult);
        }
        // order Find By Id
        OrderDto orderDtoFind= (OrderDto) iOrderService.objectServiceFindById(id);
        return ResponseEntity.ok(orderDtoFind);
    }

    // UPDATE
    // http://localhost:4444/api/order/v1.0.0/update/1
    @PutMapping({"/update/","/update/{id}"})
    @Override
    public ResponseEntity<?> objectApiUpdate(@PathVariable(name = "id",required = false)  Long id, @Valid @RequestBody OrderDto orderDto) {
        return ResponseEntity.ok(iOrderService.objectServiceUpdate(id, orderDto));
    }

    // DELETE
    // http://localhost:4444/api/order/v1.0.0/delete/1
    @DeleteMapping({"/delete/","/delete/{id}"})
    @Override
    public ResponseEntity<?> objectApiDelete(@PathVariable(name = "id",required = false) Long id) {
        return ResponseEntity.ok(iOrderService.objectServiceDelete(id));
    }

} //end OrderApiImpl
