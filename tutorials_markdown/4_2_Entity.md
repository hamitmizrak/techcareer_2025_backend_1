# Techcareer 2025 Backend-1 Spring Boot
[GitHub Address](https://github.com/hamitmizrak/techcareer_2025_backend_1.git)
---


### Spring Boot ve Spring Data ile Entity Nedir?

**Entity**, bir Spring Boot uygulamasında **JPA** (Java Persistence API) kullanılarak tanımlanan ve doğrudan bir veritabanı tablosuna karşılık gelen Java sınıfıdır. Bir Entity sınıfı, veritabanındaki tabloların yapısını modellemek için kullanılır ve verilerle ilgili işlemleri kolaylaştırır. Spring Data JPA, Entity'leri kolayca yönetmek için birçok araç ve anotasyon sağlar.

---

### Entity Tanımlama Temelleri

Bir Entity sınıfı oluşturmak için aşağıdaki bileşenler gereklidir:

1. **@Entity**:
    - Bu anotasyon, bir sınıfın JPA tarafından yönetilen bir Entity olduğunu belirtir.
    - Bu sınıf bir veritabanı tablosuna eşlenir.

2. **@Table** (Opsiyonel):
    - Entity'nin hangi tabloya eşleneceğini belirtmek için kullanılır.
    - Kullanılmadığı durumda, sınıfın adı tablo adı olarak varsayılır.

3. **@Id**:
    - Bir tablonun birincil anahtarını belirtir.

4. **@GeneratedValue**:
    - Birincil anahtarın nasıl üretileceğini belirtir. Stratejileri:
        - `GenerationType.AUTO`: Varsayılan strateji.
        - `GenerationType.IDENTITY`: Veritabanı tarafından otomatik olarak üretilir.
        - `GenerationType.SEQUENCE`: Sekans tabanlı strateji.
        - `GenerationType.TABLE`: Tablo tabanlı strateji.

5. **@Column** (Opsiyonel):
    - Bir sınıf alanını belirli bir tablo sütununa eşlemek için kullanılır.
    - Kullanılmadığında, alan adı sütun adı olarak varsayılır.

---

### Entity Örneği: Basit Bir Kullanıcı Sınıfı

Aşağıdaki örnekte bir `User` varlığı, bir kullanıcıyı temsil etmek için tanımlanmıştır:

```java
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users") // Veritabanındaki tablo adı "users"
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Birincil anahtar

    @Column(nullable = false) // Boş olamaz
    private String name;

    @Column(unique = true, nullable = false) // Eşsiz ve boş olamaz
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "created_at", updatable = false) // Güncellenemez
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Varsayılan yapıcı metot
    public User() {}

    // Getter ve Setter metotları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
```

---

### İlişkiler (Relationships) ve Entity Anotasyonları

Spring Data JPA ile Entity'ler arasındaki ilişkiler (örneğin, bir müşteri ve sipariş arasındaki ilişki) kolayca yönetilebilir. İlişkiler için kullanılan anotasyonlar şunlardır:

1. **@OneToOne**:
    - Bir varlık diğer bir varlıkla birebir ilişkilidir.

2. **@OneToMany**:
    - Bir varlık diğer bir varlıkla bire çok ilişkilidir.

3. **@ManyToOne**:
    - Bir varlık diğer bir varlıkla çoktan bire ilişkilidir.

4. **@ManyToMany**:
    - İki varlık birbiriyle çoktan çoka ilişkilidir.

---

### Örnek: Müşteri ve Sipariş İlişkisi (One-to-Many)

**Customer** ve **Order** arasında bir **One-to-Many** ilişkisini modelleyelim.

#### Customer Entity:
```java
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    // Getter ve Setter metotları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
```

#### Order Entity:
```java
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // Getter ve Setter metotları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
```

---

### Auditing ve Entity

Eğer bir Entity'de oluşturulma ve güncellenme zamanlarını takip etmek istiyorsanız, **Spring Auditing** kullanılabilir.

#### AuditableEntity:
```java
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AuditableEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    // Getter ve Setter metotları
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
```

#### Kullanım:
Tüm Entity'ler, bu sınıfı miras alabilir:

```java
@Entity
public class Product extends AuditableEntity {
    // Ek alanlar ve ilişkiler burada tanımlanabilir
}
```

---

### Repository ve CRUD İşlemleri

Entity'leri yönetmek için Spring Data JPA Repository sınıfları kullanılır. Örnek:

```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
```

Spring Data JPA sayesinde CRUD işlemleri otomatik olarak desteklenir:
- `save()`
- `findById()`
- `findAll()`
- `deleteById()`

---

### Özet

Spring Boot ve Spring Data ile Entity’ler:
- Veritabanı tablolarını modellemek için temel yapılardır.
- İlişkiler, denetleme ve sürüm yönetimi gibi birçok gelişmiş özellik desteklenir.
- Spring’in güçlü altyapısı, Entity sınıflarını oluşturmayı ve yönetmeyi kolaylaştırır.

Bu yapı, büyük ölçekli projelerde hem esnek hem de güvenilir bir veri yönetimi sağlar.