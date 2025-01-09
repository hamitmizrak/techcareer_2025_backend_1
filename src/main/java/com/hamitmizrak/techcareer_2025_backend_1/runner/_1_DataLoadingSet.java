package com.hamitmizrak.techcareer_2025_backend_1.runner;

import com.hamitmizrak.techcareer_2025_backend_1.aspect._1_AuditLogEntity;
import com.hamitmizrak.techcareer_2025_backend_1.aspect._3_AuditingAspect;
import com.hamitmizrak.techcareer_2025_backend_1.business.dto.AddressDto;
import com.hamitmizrak.techcareer_2025_backend_1.business.dto.CustomerDto;
import com.hamitmizrak.techcareer_2025_backend_1.business.dto.OrderDto;
import com.hamitmizrak.techcareer_2025_backend_1.business.dto.ProductDto;
import com.hamitmizrak.techcareer_2025_backend_1.business.services.interfaces.IAddressService;
import com.hamitmizrak.techcareer_2025_backend_1.business.services.interfaces.ICustomerService;
import com.hamitmizrak.techcareer_2025_backend_1.business.services.interfaces.IOrderService;
import com.hamitmizrak.techcareer_2025_backend_1.business.services.interfaces.IProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.*;

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
    private final IProductService iProductService;
    private final IOrderService iOrderService;

    // AOP Injection
    private final _3_AuditingAspect  auditingAspect;
    // AOP
    List<_1_AuditLogEntity> auditLogs = new ArrayList<>();

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
        System.out.println(" Address Veriliyor ");
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
        //iAddressService.objectServiceCreate(addressDto);  //composition kullandığımnda dolayı kapattım

        // AOP Save
        auditLogs.add(new _1_AuditLogEntity("AddressEntity", "CREATE", "HamitM", new Date()));

        return addressDto;
    }

    // Customer
    private CustomerDto relationCustomerSave(){
        System.out.println(" Customer Veriliyor ");
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
        //iCustomerService.objectServiceCreate(customerDto); //composition kullandığımnda dolayı kapattım

        // AOP Save
        auditLogs.add(new _1_AuditLogEntity("CustomerEntity", "CREATE", "HamitM", new Date()));

        return customerDto;
    }

    // Product
    private ProductDto[] relationProductSave(){
        System.out.println(" Ürün Veriliyor ");
        ProductDto[] productDtoList= new ProductDto[2];

        // Ürün-1
        ProductDto productDto1= ProductDto.builder()
                .name("Laptop-1")
                .trade("marka-1")
                .notes("Laptop Notes Data")
                .build();

        // Ürün-1
        ProductDto productDto2= ProductDto.builder()
                .name("Masaüstü-2")
                .trade("marka-2")
                .notes("Masaüstü Notes Data")
                .build();
        return new ProductDto[]{productDto1,productDto2};
    }

    // Order
    private void relationOrderSave(){
        System.out.println(" Sipariş Veriliyor ");

        // Sipariş
        OrderDto orderDto1= OrderDto.builder()
                .name("sipariş name -1")
                .price("sipariş price-1")
                .notes("sipari note")
                .build();

        // Composition
        // Dikkat: Customer içinde Address vardı
        orderDto1.setCompositionCustomerDto(relationCustomerSave());

        // Dikkat: Order içine Sipariş Ekle
        orderDto1.setCompositionProductDtoList(Arrays.asList(relationProductSave()[0],relationProductSave()[1]));

        // Order Database Kaydet
        OrderDto orderDtoDatabaseSave= (OrderDto) iOrderService.objectServiceCreate(orderDto1);
        System.out.println(orderDtoDatabaseSave);

        // AOP Save
        auditLogs.add(new _1_AuditLogEntity("ProductEntity", "CREATE", "HamitM", new Date()));
        auditLogs.add(new _1_AuditLogEntity("OrderEntity", "CREATE", "HamitM", new Date()));
    }

    // AOP Save
    private void aopSave(){
        // Toplu olarak Audit Logs kaydet
        auditingAspect.logBatchAudit(auditLogs);
        System.out.println("Tüm kayıtlar ve audit log'lar tamamlandı.");
    }

    // run
    @Override
    public void run(String... args) throws Exception {
        // savedListAddress();
        // savedAddress();
        // relationCustomerSave();
        relationOrderSave();

        // Aop Save
        aopSave();
    } //end PSVM
} //end _1_DataLoadingSet
