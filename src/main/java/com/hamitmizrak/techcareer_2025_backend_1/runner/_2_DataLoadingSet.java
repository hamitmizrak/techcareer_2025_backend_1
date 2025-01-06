package com.hamitmizrak.techcareer_2025_backend_1.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

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

@Configuration // Bu classın bir spring framework!un bir parçası olması ve Bean özelliği için kullanırız.
@Order(2)  // org.springframework.core.annotation.Order;
public class _2_DataLoadingSet {

    // Injection

    // run
    @Bean
    public CommandLineRunner myRunner() {
        return args -> {

            System.out.println("2- CommandLine Runner (Bean)");
            for (String temp : args) {
                System.out.println("Argümanlar: " + temp);
            }
        };
    }
}
