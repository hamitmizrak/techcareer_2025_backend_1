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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
    private ApiResult apiResult=new ApiResult();


    ////////////////////////////////////////////////////////////////////////////////////////
    // CRUD

    // CREATE (Address)
    // http://localhost:4444/api/address/v1.0.0/create
    @PostMapping("/create")
    @Override
    public ResponseEntity<?> objectApiCreate(@Valid @RequestBody AddressDto addressDto) {
        try{
            AddressDto addressDtoApiCreate = (AddressDto) iAddressService.objectServiceCreate(addressDto);

            // Başarılıysa ApiResult Nesnesini oluştur
            apiResult= ApiResult.builder()
                    .status(201)
                    .message("Address created successfully")
                    .path("/api/address/v1.0.0/create")
                    .createdDate(new Date(System.currentTimeMillis()))
                    .build();

            // ApiResult içine AddressDto eklemek ve Hataları ApiResultta set etmek
            apiResult.setValidationErrors(Map.of("data", addressDtoApiCreate));
            // return new ResponseEntity<>(addressDtoApiCreate,HttpStatus.CREATED);
            // return ResponseEntity.status(201).body(addressDtoApiCreate);
            // return ResponseEntity.status(HttpStatus.CREATED).body(addressDtoApiCreate);
            //return ResponseEntity.ok(iAddressService.).body(addressDtoApiCreate);
            return ResponseEntity.ok(addressDtoApiCreate);
        }catch (Exception e){
            // Başarısızsa ApiResult Nesnesini oluştur
            apiResult= ApiResult.builder()
                    .status(201)
                    .message("Address created isnot failed")
                    .path("/api/address/v1.0.0/create")
                    .createdDate(new Date(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.status(500).body(apiResult);
        }
    }


    // LIST (Address)
    // http://localhost:4444/api/address/v1.0.0/list
    @GetMapping("/list")
    @Override
    public ResponseEntity<List<AddressDto>> objectApiList() {
        try{

        }catch (Exception e){

        }

        return ResponseEntity.ok(iAddressService.objectServiceList());
    }


    // FIND BY ID (Address)
    // http://localhost:4444/api/address/v1.0.0/find/1
    @GetMapping("/find/{id}")
    @Override
    public ResponseEntity<?> objectApiFindById(@PathVariable(name = "id", required = false) Long id) {
        try{

        }catch (Exception e){

        }
        return ResponseEntity.ok(iAddressService.objectServiceFindById(id));
    }


    // UPDATE (Address)
    // http://localhost:4444/api/address/v1.0.0/update/1
    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<?> objectApiUpdate(@PathVariable(name = "id", required = false) Long id, @Valid @RequestBody AddressDto addressDto) {
        try{

        }catch (Exception e){

        }
        return ResponseEntity.ok(iAddressService.objectServiceUpdate(id, addressDto));
    }


    // DELETE BY ID (Address)
    // http://localhost:4444/api/address/v1.0.0/delete/1
    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<?> objectApiDelete(@PathVariable(name = "id", required = false) Long id) {
        try{

        }catch (Exception e){

        }
        return ResponseEntity.ok(iAddressService.objectServiceDelete(id));
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    // PAGINATION/SORTING
    /*
     PathVariable ve RequestParam Arasındaki Farklar

    | Özellik            | @PathVariable                                     | @RequestParam                                   |
    |-------------------------|------------------------------------------------------|----------------------------------------------------|
    | Amaç               | URL yolundaki bir parametreyi alır.                   | Sorgu parametrelerini (query parameters) alır.     |
    | Kullanım Yeri       | URL'nin bir parçası olarak tanımlanır.                | URL'deki `?` işaretinden sonra gelen parametrelerle çalışır. |
    | URL Örneği          | `/api/users/{id}`                                    | `/api/users?name=Hamit`                             |
    | Tanımlama Şekli     | `@PathVariable("id") Long id`                        | `@RequestParam("name") String name`               |
    | Zorunluluk          | Varsayılan olarak zorunludur (opsiyonel yapılabilir).| Varsayılan olarak zorunludur (opsiyonel yapılabilir).|
    | Çoklu Değerler      | Sadece tek bir değer alır.                            | Birden fazla parametreyi kolayca alabilir.         |


     Örnekler
     @PathVariable Kullanımı
    URL: `/api/users/123`


    @GetMapping("/api/users/{id}")
    public ResponseEntity<String> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok("User ID: " + id);
    }

    @RequestParam Kullanımı
    URL: `/api/users?name=Hamit`


    @GetMapping("/api/users")
    public ResponseEntity<String> getUserByName(@RequestParam("name") String name) {
        return ResponseEntity.ok("User Name: " + name);
    }
    ---

     Temel Fark
    - @PathVariable, dinamik bir URL'nin bir parçasını temsil eder.
    - @RequestParam, sorgu parametrelerini alır ve genelde isteğe bağlı parametreler için kullanılır.

    Hangi Durumda Kullanılır?
    - @PathVariable: Kaynak kimliğini veya bir URL'nin parçasını almak için.
    - @RequestParam: Filtreleme, sıralama veya arama gibi isteğe bağlı parametrelerle çalışmak için.
  */

    // PAGINATION
    @GetMapping("/pagination")
    @Override
    public ResponseEntity<Page<?>> objectServicePagination(int currentPage, int pageSize) {
        try{

        }catch (Exception e){

        }
        return ResponseEntity.ok(iAddressService.);
    }

    // SORTING (Belli Sutuna göre)
    @Override
    public ResponseEntity<List<AddressDto>> objectServiceListSortedBy(String sortedBy) {
        try{

        }catch (Exception e){

        }
        return ResponseEntity.ok(iAddressService.);
    }

    // SORTING (Küçükten büyüğe doğru)
    @Override
    public ResponseEntity<List<AddressDto>> objectServiceListSortedByAsc() {
        try{

        }catch (Exception e){

        }
        return ResponseEntity.ok(iAddressService.);
    }

    // SORTING (Büyükten küçüğe doğru)
    @Override
    public ResponseEntity<List<AddressDto>> objectServiceListSortedByDesc() {
        try{

        }catch (Exception e){

        }
        return ResponseEntity.ok(iAddressService.);
    }

} // end AddressApiImpl
