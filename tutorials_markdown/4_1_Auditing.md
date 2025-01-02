# Techcareer 2025 Backend-1 Spring Boot
[GitHub Address](https://github.com/hamitmizrak/techcareer_2025_backend_1.git)
---

### Spring Auditing Nedir?

**Spring Auditing**, bir uygulamada veritabanı işlemlerini izlemek, belirli olayları kaydetmek ve kimlik doğrulama bağlamında, özellikle oluşturulan veya güncellenen kayıtların izlenebilirliğini sağlamak için kullanılan bir özelliktir. Spring Data JPA ile entegre bir şekilde çalışır ve genellikle bir veri tablosundaki kayıtların **oluşturulma tarihi**, **güncellenme tarihi**, **oluşturan kullanıcı**, **güncelleyen kullanıcı** gibi meta verilerini otomatik olarak takip etmek için kullanılır.

Auditing, uygulama geliştirme sürecinde:
1. **Kimin neyi yaptığını** anlamak,
2. **Hangi kaydın ne zaman oluşturulduğunu ya da güncellendiğini öğrenmek**,
3. **Veritabanı kayıtlarının izlenebilirliğini artırmak** için oldukça faydalıdır.

---

### Spring Auditing’in Temel Bileşenleri

Spring Auditing, aşağıdaki anahtar bileşenlere dayanır:

1. **@CreatedDate**:
    - Bir varlığın oluşturulma tarihini izlemek için kullanılır.
    - Spring, bu değeri otomatik olarak ayarlayabilir.

2. **@LastModifiedDate**:
    - Bir varlığın son güncellenme tarihini izler.
    - Güncelleme işlemi sırasında otomatik olarak güncellenir.

3. **@CreatedBy**:
    - Bir varlığı kimin oluşturduğunu izlemek için kullanılır.
    - Kullanıcının kimliği veya adı gibi bilgileri kaydeder.

4. **@LastModifiedBy**:
    - Bir varlığı kimin güncellediğini izler.
    - Kullanıcının kimliği veya adı gibi bilgileri kaydeder.

5. **AuditingEntityListener**:
    - Auditing işlevselliğini desteklemek için varlıklara bağlanan bir JPA dinleyicisidir.
    - Varlıklardaki **@CreatedDate** ve **@LastModifiedDate** gibi anotasyonlarla entegre çalışır.

6. **@EnableJpaAuditing**:
    - Auditing’i etkinleştirmek için Spring Boot uygulamasında kullanılan bir anotasyondur.

---

### Spring Auditing Özelliklerinin Avantajları

- **Otomasyon**: Auditing, manuel müdahale olmaksızın belirli alanları otomatik olarak doldurur.
- **Veri Tutarlılığı**: Hangi verinin kim tarafından ve ne zaman oluşturulduğu/güncellendiği bilgisine kolayca erişim sağlar.
- **Kullanıcı İzlenebilirliği**: Uygulamadaki kullanıcı aktivitelerini takip etmeye olanak tanır.
- **Uyumluluk**: Özellikle finans ve sağlık gibi yüksek denetim gerektiren sektörlerde veri izlenebilirliği için gereklidir.

---

### Spring Auditing Nasıl Çalışır?

Spring Auditing, aşağıdaki adımlar izlenerek etkinleştirilir ve kullanılır:

#### 1. **Spring Boot Projesini Ayarlayın**
Spring Boot uygulamanıza aşağıdaki bağımlılıkları ekleyerek başlayabilirsiniz:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

#### 2. **Auditing’i Etkinleştirin**

`@EnableJpaAuditing` anotasyonu ile auditing mekanizmasını etkinleştirin. Bu anotasyon genellikle **ana sınıf (Main Class)** üzerinde kullanılır:

```java
@SpringBootApplication
@EnableJpaAuditing
public class AuditingApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuditingApplication.class, args);
    }
}
```

#### 3. **Auditing İçin Varlıklarınızı Ayarlayın**

Bir JPA varlığı oluşturun ve auditing alanlarını ekleyin. Örneğin:

```java
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastModifiedDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;

    // Getter ve Setter metotları
}
```

#### 4. **AuditorAware Arayüzünü Uygulayın**

`@CreatedBy` ve `@LastModifiedBy` gibi alanların otomatik olarak doldurulması için bir **AuditorAware** implementasyonu oluşturun. Bu sınıf, aktif kullanıcıyı belirlemek için kullanılır:

```java
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Burada aktif kullanıcıyı dönebilirsiniz (örneğin, Spring Security ile kimlik doğrulama)
        return Optional.of("current_user"); // Sabit bir kullanıcı adı (örnek)
    }
}
```

---

### Örnek Uygulama

Bir `Product` varlığını kaydetmek ve auditing alanlarını test etmek için bir REST API ekleyelim.

**Controller Sınıfı:**

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
```

**Repository Sınıfı:**

```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
```

**Uygulama Testi:**
- `POST /products` isteği ile bir ürün oluşturduğunuzda:
    - `createdDate` alanı otomatik olarak ayarlanır.
    - `createdBy` alanı aktif kullanıcıyla doldurulur.
- `PUT` veya başka bir güncelleme işlemi yapıldığında:
    - `lastModifiedDate` ve `lastModifiedBy` alanları otomatik olarak güncellenir.

---

### Spring Auditing ile İlgili Önemli Notlar

1. **Spring Security ile Entegrasyon**:
    - Eğer uygulamanızda Spring Security kullanıyorsanız, aktif kullanıcıyı belirlemek için **SecurityContextHolder** kullanılabilir:
      ```java
      @Override
      public Optional<String> getCurrentAuditor() {
          return Optional.of(SecurityContextHolder.getContext().getAuthentication().getName());
      }
      ```

2. **Tarih Formatı**:
    - Tarih formatı için **@Temporal** anotasyonu kullanılır. Ancak modern projelerde **java.time.LocalDateTime** tercih edilir.

3. **Test Ortamında Kullanım**:
    - AuditorAware gibi bileşenler test ortamında kolayca taklit (mock) edilebilir.

---

### Özet

Spring Auditing, veritabanı işlemlerinin izlenebilirliğini artırmak için kullanışlı bir araçtır. Özellikle **oluşturma/güncelleme tarihi** ve **kimin oluşturduğu/güncellediği** gibi bilgileri otomatik olarak doldurması, hem kullanıcı aktivitelerini izlemek hem de denetim (audit) gereksinimlerini karşılamak için idealdir. Spring Boot ile kolayca entegre edilebilir ve Spring Security ile birlikte kullanıldığında kullanıcı bazlı denetim süreçlerini destekler.