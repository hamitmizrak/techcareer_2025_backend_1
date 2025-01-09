package com.hamitmizrak.techcareer_2025_backend_1.runner;

import com.hamitmizrak.techcareer_2025_backend_1.business.dto.AddressDto;
import com.hamitmizrak.techcareer_2025_backend_1.business.dto.CustomerDto;
import com.hamitmizrak.techcareer_2025_backend_1.business.services.interfaces.IAddressService;
import com.hamitmizrak.techcareer_2025_backend_1.business.services.interfaces.ICustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Runner: Proje ayağa kalkarken eklememiz gereken proje kodlarını database vs eklememize yardımcı oluyor.
// Bazı veriler başlamadan öncesinde hazır verilerle çalışmak isteyebilir.

/*
 CommandLineRunner'ın Özellikleri
1. **Bir Defalık Çalıştırma:**
   CommandLineRunner, uygulama başlatıldığında yalnızca bir kez çalıştırılır.
2. **@Component veya @Bean ile Kullanım:**
   CommandLineRunner, bir sınıfa uygulanabilir ve bu sınıfın bir Spring bileşeni olarak tanımlanması gerekir.
   Bunun için genellikle `@Component` veya `@Bean` kullanılır.
3. **Uygulamanın Lifecycle’ına Entegre:**
   Spring konteyneri tamamen yüklendikten sonra çalıştırılır, bu nedenle tüm bağımlılıklar ve bean'ler hazırdır.
*/

// LOMBOK
@Log4j2
@RequiredArgsConstructor // for injection

@Component // Bu classın bir spring framework!un bir parçası olması
@Order(1)  // org.springframework.core.annotation.Order;
public class _1_DataLoadingSet implements CommandLineRunner {

    // Injection
    private final IAddressService iAddressService;
    private final ICustomerService iCustomerService;

    // Çoklu Address Ekle
    private List<AddressDto> savedListAddress(){
        //System.out.println("1- Address hazırlanıyor...");
        List<AddressDto> addressDtoList= new ArrayList<>();
        for (int i = 1; i <=10 ; i++) {
            AddressDto addressDto = AddressDto.builder()
                    .addressQrCode(UUID.randomUUID().toString())
                    .city("city"+i)
                    .state("state"+i)
                    .country("country"+i)
                    .description("description"+i)
                    .avenue("avenue"+i)
                    .street("street"+i)
                    .zipCode("zip code"+i)
                    .doorNumber("door number"+i)
                    .isDeleted(false)
                    .build();
            iAddressService.objectServiceCreate(addressDto);
            addressDtoList.add(addressDto);
        }
        return addressDtoList;
    }

    // Address
    private AddressDto savedAddress(){
        AddressDto addressDto = AddressDto.builder()
                .addressQrCode("qr code")
                .city("city")
                .state("state")
                .country("country")
                .description("description")
                .avenue("avenue")
                .street("street")
                .zipCode("zip code")
                .doorNumber("door number")
                .isDeleted(false)
                .build();
        //iAddressService.objectServiceCreate(addressDto);
        return addressDto;
    }

    // Address
    private CustomerDto relationCustomerSave(){
        // AddressDto
        AddressDto addressDto= savedAddress();

        // CustomerDto
        CustomerDto customerDto= new CustomerDto();
        customerDto.setFistname("Hamit");
        customerDto.setLastname("Mızrak");
        customerDto.setNotes("Notes Data");

        // Composition
        customerDto.setCompositionAddressDto(addressDto);

        // Customer Save
        iCustomerService.objectServiceCreate(customerDto);
        return customerDto;
    }

    // run
    @Override
    public void run(String... args) throws Exception {
        // savedListAddress();
        // savedAddress();
        relationCustomerSave();
    } //end PSVM
} //end _1_DataLoadingSet
