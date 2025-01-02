# Techcareer 2025 Backend-1 Spring Boot
[GitHub Address](https://github.com/hamitmizrak/techcareer_2025_backend_1.git)
---

### Spring Boot'ta Optimiztik Kilitlenme Nedir?

**Optimistik Kilitlenme (Optimistic Locking)**, birden fazla işlem aynı veriyi eşzamanlı olarak güncellemeye çalıştığında veri tutarlılığını sağlamak için kullanılan bir kilitleme mekanizmasıdır. Bu yöntem, özellikle Spring Data JPA gibi ORM araçlarında, veritabanındaki yarış durumlarını (race condition) önlemek amacıyla uygulanır.

---

### Optimistik Kilitlenmenin Mantığı

Optimistik kilitlenme, veri üzerinde **kilit** koymak yerine, güncelleme sırasında verinin **en son haliyle** işlem gördüğünden emin olmayı amaçlar. Bunun için:
1. Verinin mevcut sürüm numarası (`version`) ya da bir zaman damgası kullanılır.
2. Güncelleme işlemi sırasında veritabanındaki sürüm ile istemcideki sürüm karşılaştırılır:
    - Eğer sürümler eşleşiyorsa, işlem başarılı olur ve sürüm numarası artırılır.
    - Eğer sürümler eşleşmiyorsa, bir **OptimisticLockException** fırlatılır ve işlem başarısız olur.

Bu mekanizma sayesinde:
- Aynı veriye yapılan eşzamanlı güncellemelerde veri tutarsızlığı önlenir.
- Performans artışı sağlanır, çünkü fiziksel kilitler (ör. `SELECT ... FOR UPDATE`) kullanılmaz.

---

### Optimistik Kilitlenmenin Avantajları

1. **Yüksek Performans**:
    - Fiziksel kilitler kullanılmadığından, veritabanı üzerindeki yük azalır.
    - Veriler yalnızca işlem sırasında kontrol edilir, bu da hızlı sorgu işlemlerine olanak tanır.

2. **Tutarlılık**:
    - Eşzamanlı işlemler nedeniyle verilerin yanlışlıkla üzerine yazılmasını engeller.
    - Verinin en güncel haliyle çalışıldığını garanti eder.

3. **Esneklik**:
    - Dağıtık sistemlerde ve mikroservis mimarisinde veri tutarlılığını sağlamak için uygundur.

---

### Optimistik Kilitlenme Nasıl Çalışır?

Optimistik kilitlenme, JPA veya Hibernate'in sağladığı **@Version** anotasyonu kullanılarak uygulanır. Veritabanındaki her kayda bir `version` sütunu eklenir ve bu sütun her güncelleme sırasında otomatik olarak artırılır.

---

### Spring Boot ile Optimistik Kilitlenme Uygulaması

#### 1. **Proje Ayarları**

Spring Boot uygulamanızda aşağıdaki bağımlılıkları ekleyin:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

---

#### 2. **Veri Modeli**

Bir `@Version` alanı eklenmiş bir JPA varlığı tanımlayın:

```java
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;

    @Version
    private Integer version;

    // Getters and Setters
}
```

**Açıklamalar**:
- `@Version` anotasyonu, Hibernate tarafından otomatik olarak sürüm numarasını izlemek için kullanılır.
- Güncelleme işlemi sırasında bu alanın değeri kontrol edilir ve eşleştiği durumda işlem başarılı olur.

---

#### 3. **Repository Tanımı**

Bir Spring Data JPA repository tanımlayın:

```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
```

---

#### 4. **Service ve İşlem Mantığı**

Optimistik kilitlenmenin çalışma mantığını görmek için bir `Service` sınıfı ekleyin:

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Product updateProductPrice(Long productId, Double newPrice) {
        // Ürünü veritabanından yükle
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Product not found!");
        }

        Product product = productOptional.get();
        product.setPrice(newPrice);

        // Güncelleme işlemi
        return productRepository.save(product);
    }
}
```

---

#### 5. **Controller Katmanı**

Bir REST API tanımlayın:

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PutMapping("/{id}/price")
    public Product updatePrice(@PathVariable Long id, @RequestParam Double price) {
        return productService.updateProductPrice(id, price);
    }
}
```

---

### Örnek Senaryo

1. **Veri Hazırlığı**:
    - İlk olarak bir ürün ekleyin: `Product(id=1, name="Laptop", price=1000.0, version=0)`

2. **Eşzamanlı İşlem**:
    - **İstemci A** ürünü yükler (`version=0`) ve fiyatını `1200.0` olarak günceller.
    - **İstemci B** aynı ürünü yükler (`version=0`) ve fiyatını `1100.0` olarak günceller.

3. **İşlemlerin Sırası**:
    - **İstemci A** başarılı bir şekilde günceller ve `version=1` olur.
    - **İstemci B** işlem yapmaya çalıştığında, veritabanındaki `version=1` ile kendi `version=0` değeri eşleşmediği için **OptimisticLockException** fırlatılır.

---

### OptimisticLockException ile Hata Yönetimi

Optimistik kilitlenme durumunda, Spring bir **OptimisticLockException** fırlatır. Bu hatayı özel bir `@ExceptionHandler` ile ele alabilirsiniz:

```java
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OptimisticLockingFailureException.class)
    public ResponseEntity<String> handleOptimisticLockException(OptimisticLockingFailureException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Veri başka bir işlem tarafından güncellenmiştir. Lütfen tekrar deneyin.");
    }
}
```

---

### Optimistik Kilitlenmenin Alternatifleri ve Dikkat Edilmesi Gerekenler

1. **Pessimistik Kilitlenme (Pessimistic Locking)**:
    - Veritabanında fiziksel bir kilit kullanır.
    - Daha güvenli, ancak performans açısından optimistik kilitlenmeye göre daha yavaştır.

2. **Dağıtık Sistemlerde Kullanım**:
    - Optimistik kilitlenme, dağıtık sistemlerde veri tutarlılığını sağlamak için ideal bir yöntemdir.
    - Ancak, veri yoğunluğu fazla olan sistemlerde dikkatli kullanılmalıdır.

3. **Versiyon Numarasının Yönetimi**:
    - `@Version` sütununun düzenli olarak artırılması ve veri tutarlılığı için doğru kullanılması önemlidir.

---

### Sonuç

**Optimistik kilitlenme**, performansı düşürmeden veri tutarlılığını sağlamanın etkili bir yoludur. Spring Boot ve JPA’nın güçlü özellikleriyle kolayca uygulanabilir. Özellikle eşzamanlı veri güncellemelerinin sık yaşandığı uygulamalarda, optimistik kilitlenme ile veri güvenliği sağlanabilir ve sistem performansı artırılabilir.
