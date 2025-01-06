package com.hamitmizrak.techcareer_2025_backend_1.runner;

import com.hamitmizrak.techcareer_2025_backend_1.business.dto.AddressDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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

    // Address
    private AddressDto savedAddress(){
        System.out.println("1- Address hazırlanıyor...");
        return null;
    }

    // run
    @Override
    public void run(String... args) throws Exception {
        savedAddress();
    }
}
