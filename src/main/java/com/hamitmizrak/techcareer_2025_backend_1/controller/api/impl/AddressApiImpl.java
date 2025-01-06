package com.hamitmizrak.techcareer_2025_backend_1.controller.api.impl;

import com.hamitmizrak.techcareer_2025_backend_1.business.dto.AddressDto;
import com.hamitmizrak.techcareer_2025_backend_1.business.services.interfaces.IAddressService;
import com.hamitmizrak.techcareer_2025_backend_1.controller.api.interfaces.IAddressApi;
import com.hamitmizrak.techcareer_2025_backend_1.error.ApiResult;
import com.hamitmizrak.techcareer_2025_backend_1.utils.FrontEnd;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// API: Dış dünyaya bağlantı kuran yer
@RestController
@RequestMapping("/api/address/v1.0.0")
//@CrossOrigin
//@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = FrontEnd.REACT_URL)
@CrossOrigin(origins = {FrontEnd.REACT_URL, FrontEnd.ANGULAR_URL})
public class AddressApiImpl implements IAddressApi<AddressDto> {

    // Injection
    private final IAddressService iAddressService;
    private final MessageSource messageSource;

    // Api Result
    private ApiResult apiResult;

    ////////////////////////////////////////////////////////////////////////////////////////
    // CRUD

    // CREATE (Address)
    // http://localhost:4444/api/address/v1.0.0/create
    @PostMapping("/create")
    @Override
    public ResponseEntity<?> objectApiCreate(@Valid @RequestBody AddressDto addressDto) {
        AddressDto addressDtoApiCreate = (AddressDto) iAddressService.objectServiceCreate(addressDto);
        // return new ResponseEntity<>(addressDtoApiCreate,HttpStatus.CREATED);
        // return ResponseEntity.status(201).body(addressDtoApiCreate);
        // return ResponseEntity.status(HttpStatus.CREATED).body(addressDtoApiCreate);
        //return ResponseEntity.ok(iAddressService.).body(addressDtoApiCreate);
        return ResponseEntity.ok(addressDtoApiCreate);
    }


    // LIST (Address)
    // http://localhost:4444/api/address/v1.0.0/list
    @GetMapping("/list")
    @Override
    public ResponseEntity<List<AddressDto>> objectApiList() {
        return ResponseEntity.ok(iAddressService.objectServiceList());
    }


    // FIND BY ID (Address)
    // http://localhost:4444/api/address/v1.0.0/find/1
    @GetMapping("/find/{id}")
    @Override
    public ResponseEntity<?> objectApiFindById(@PathVariable(name = "id", required = false) Long id) {
        return ResponseEntity.ok(iAddressService.objectServiceFindById(id));
    }


    // UPDATE (Address)
    // http://localhost:4444/api/address/v1.0.0/update/1
    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<?> objectApiUpdate(@PathVariable(name = "id", required = false) Long id, @Valid @RequestBody AddressDto addressDto) {
        return ResponseEntity.ok(iAddressService.objectServiceUpdate(id, addressDto));
    }


    // DELETE BY ID (Address)
    // http://localhost:4444/api/address/v1.0.0/delete/1
    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<?> objectApiDelete(@PathVariable(name = "id", required = false) Long id) {
        return ResponseEntity.ok(iAddressService.objectServiceDelete(id));
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    // PAGINATION/SORTING

    // PAGINATION
    @GetMapping("/pagination")
    @Override
    public ResponseEntity<Page<?>> objectServicePagination(int currentPage, int pageSize) {
        return ResponseEntity.ok(iAddressService.);
    }

    // SORTING (Belli Sutuna göre)
    @Override
    public ResponseEntity<List<AddressDto>> objectServiceListSortedBy(String sortedBy) {
        return ResponseEntity.ok(iAddressService.);
    }

    // SORTING (Küçükten büyüğe doğru)
    @Override
    public ResponseEntity<List<AddressDto>> objectServiceListSortedByAsc() {
        return ResponseEntity.ok(iAddressService.);
    }

    // SORTING (Büyükten küçüğe doğru)
    @Override
    public ResponseEntity<List<AddressDto>> objectServiceListSortedByDesc() {
        return ResponseEntity.ok(iAddressService.);
    }
}
