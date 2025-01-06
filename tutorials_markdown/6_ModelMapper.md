# Techcareer 2025 Backend-1 Spring Boot
[GitHub Address](https://github.com/hamitmizrak/techcareer_2025_backend_1.git)
---

## Git
 
git clone https://github.com/hamitmizrak/techcareer_2025_backend_1.git

git init
git add .
git commit -m "spring init"
git push -u master

git status
git log

git pull
git pull origin master

```
---

## Permalink

    http://localhost:4444
    http://localhost:4444/h2-console
    http://localhost:4444/swagger-ui/index.html
    http://localhost:4444/actuator/health
```
---

## Version
 
git -v
mvn -v
java --version
javac --version
docker version
docker-compose version
```
---

## Git Init
 
git init
git add .
git commit -m "spring boot init"
git remote add origin URL
git push -u origin master

git clone https://github.com/hamitmizrak/
```
---

## Git Codes

git status
git logs

```

### **ModelMapper Nedir?**

**ModelMapper**, Java uygulamalarında bir nesneden başka bir nesneye (özellikle DTO ve Entity nesneleri arasında) kolayca dönüşüm yapmayı sağlayan, açık kaynaklı bir nesne-nesne eşleme (object-to-object mapping) kütüphanesidir. ModelMapper, karmaşık nesne hiyerarşilerinde bile minimal konfigürasyon ile veri dönüşüm işlemlerini gerçekleştirebilir.

---

### **Neden ModelMapper Kullanılır?**

Birçok Java uygulamasında, veri transferi sırasında Entity sınıflarının doğrudan kullanılması önerilmez. Bunun yerine, Entity sınıflarını korumak ve gereksiz bağımlılıkları azaltmak için **DTO (Data Transfer Object)** sınıfları kullanılır. Entity-DTO dönüşümleri manuel olarak yapıldığında:

- **Kod karmaşası artar:** Her bir dönüşüm için manuel kod yazılması gerekir.
- **Bakımı zorlaşır:** Zamanla dönüşüm mantığındaki değişiklikler, kodun farklı yerlerinde güncellenmek zorunda kalır.
- **Zaman kaybı oluşur:** Özellikle çok sayıda alan içeren sınıflar için dönüşüm kodu yazmak zaman alıcıdır.

**ModelMapper**, bu dönüşüm işlemlerini kolaylaştırarak manuel eşleme ihtiyacını ortadan kaldırır.

---

### **ModelMapper'ın Özellikleri**

1. **Otomatik Eşleme:** 
   - Alan isimleri aynı olan nesneler arasında otomatik eşleme yapar.
   - Örneğin, bir `UserEntity` sınıfındaki `firstName` alanı, `UserDTO` sınıfındaki aynı isimdeki alana otomatik olarak eşlenir.

2. **Hiyerarşik Eşleme:** 
   - Karmaşık nesne hiyerarşileri arasında bile doğru eşleme yapabilir. 
   - Örneğin, bir `Order` nesnesi içindeki `Customer` nesnesini `OrderDTO` içindeki `CustomerDTO` ile eşleyebilir.

3. **Esneklik:** 
   - Özelleştirilmiş eşleme kuralları tanımlanabilir.
   - Örneğin, farklı isimlere sahip alanlar eşlenmek istenirse özelleştirme yapılabilir.

4. **Tip Güvenliği:** 
   - ModelMapper, eşleme sırasında tür uyumsuzluklarını kontrol eder ve güvenli bir dönüşüm sağlar.

5. **Performans:** 
   - Karmaşık nesne eşlemelerinde bile performanslıdır.
   - Manuel eşlemeye kıyasla daha hızlı geliştirme sağlar.

6. **Eşleme Kuralları:** 
   - Standart eşleme dışında, özel dönüşüm kuralları tanımlayarak belirli alanlar için özel dönüşüm mantıkları yazılabilir.

---

### **ModelMapper Nasıl Kullanılır?**

#### **1. Maven Bağımlılığı**

ModelMapper'ı bir Maven projesinde kullanmak için, `pom.xml` dosyasına şu bağımlılığı eklemeniz gerekir:

```xml
<dependency>
    <groupId>org.modelmapper</groupId>
    <artifactId>modelmapper</artifactId>
    <version>3.1.0</version>
</dependency>
```

Gradle kullananlar için:

```groovy
implementation 'org.modelmapper:modelmapper:3.1.0'
```

---

#### **2. Temel Kullanım**

Basit bir örnekle başlayalım. Aşağıdaki iki sınıfı düşünelim:

**Entity Sınıfı:**

```java
public class UserEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    // Getters ve Setters
}
```

**DTO Sınıfı:**

```java
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;

    // Getters ve Setters
}
```

**ModelMapper ile Eşleme:**

```java
import org.modelmapper.ModelMapper;

public class Main {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();

        // Entity oluştur
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setFirstName("Ahmet");
        userEntity.setLastName("Yılmaz");
        userEntity.setEmail("ahmet.yilmaz@example.com");

        // Entity'den DTO'ya dönüştür
        UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);

        System.out.println("DTO First Name: " + userDTO.getFirstName());
        System.out.println("DTO Last Name: " + userDTO.getLastName());
        System.out.println("DTO Email: " + userDTO.getEmail());
    }
}
```

Çıktı:
```plaintext
DTO First Name: Ahmet
DTO Last Name: Yılmaz
DTO Email: ahmet.yilmaz@example.com
```

---

#### **3. Özelleştirilmiş Eşleme**

Bazen, alan isimleri farklı olduğunda veya özel bir dönüşüm gerektiğinde özelleştirme yapılması gerekebilir.

**Örnek:**

Entity ve DTO sınıflarını düşünelim:

```java
public class EmployeeEntity {
    private String name;
    private String departmentName;
    private String email;
    // Getters ve Setters
}

public class EmployeeDTO {
    private String fullName;
    private String department;
    // Getters ve Setters
}
```

Bu durumda, `name` alanı `fullName` ile, `departmentName` ise `department` ile eşlenmelidir. ModelMapper'da özelleştirilmiş bir eşleme tanımlayabiliriz:

```java
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class Main {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();

        // Özelleştirilmiş eşleme
        modelMapper.addMappings(new PropertyMap<EmployeeEntity, EmployeeDTO>() {
            @Override
            protected void configure() {
                map().setFullName(source.getName());
                map().setDepartment(source.getDepartmentName());
            }
        });

        // Entity oluştur
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName("Mehmet");
        employeeEntity.setDepartmentName("IT");
        employeeEntity.setEmail("mehmet@example.com");

        // Entity'den DTO'ya dönüştür
        EmployeeDTO employeeDTO = modelMapper.map(employeeEntity, EmployeeDTO.class);

        System.out.println("DTO Full Name: " + employeeDTO.getFullName());
        System.out.println("DTO Department: " + employeeDTO.getDepartment());
    }
}
```

Çıktı:
```plaintext
DTO Full Name: Mehmet
DTO Department: IT
```

---

#### **4. Koleksiyon Eşleme**

ModelMapper, liste veya koleksiyon türlerini de dönüştürebilir.

**Örnek:**

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();

        // Entity listesi oluştur
        List<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity(1L, "Ali", "Veli", "ali@example.com"));
        userEntities.add(new UserEntity(2L, "Ayşe", "Fatma", "ayse@example.com"));

        // DTO listesine dönüştür
        List<UserDTO> userDTOs = userEntities.stream()
                .map(userEntity -> modelMapper.map(userEntity, UserDTO.class))
                .toList();

        userDTOs.forEach(dto -> System.out.println(dto.getFirstName() + " " + dto.getLastName()));
    }
}
```

---

### **ModelMapper Kullanım Alanları**

1. **Entity - DTO Dönüşümleri:**
   - Veritabanı nesneleri ve REST API için kullanılan DTO'lar arasında dönüşüm sağlar.

2. **Microservices:**
   - Bir servisin domain nesnelerini başka bir servisin nesnelerine dönüştürmek için kullanılabilir.

3. **Test Verisi Hazırlama:**
   - Mock veri oluştururken karmaşık nesneleri dönüştürmek için kullanılabilir.

4. **Hiyerarşik Nesne Yapıları:**
   - İç içe geçmiş nesnelerde dönüşüm işlemleri için uygundur.

---

### **ModelMapper’ın Avantajları**

1. **Kod Karmaşasını Azaltır:**
   - Manuel eşleme işlemlerinden kurtulursunuz.

2. **Bakımı Kolaylaştırır:**
   - Dönüşüm kuralları merkezi olarak tanımlandığı için değişiklikler kolayca yapılabilir.

3. **Performanslı ve Güvenilir:**
   - Hızlı dönüşüm yapar ve tür kontrolleri ile hata riskini azaltır.

---

### **ModelMapper’ın Dezavantajları**

1. **Karmaşık Özelleştirmeler:**
   - Çok karmaşık dönüşüm senaryolarında özelleştirme kodları manuel dönüşümden daha karmaşık hale gelebilir.

2. **Performans Maliyetleri:**
   - Büyük veri setlerinde, manuel eşlemeye göre biraz daha yavaş çalışabilir.

---

### **Sonuç**

**ModelMapper**, Java projelerinde Entity ve DTO nesneleri arasındaki dönüşüm işlemlerini kolaylaştırarak zamandan tasarruf sağlar ve kodun okunabilirliğini artırır. Otomatik eşleme özelliği ile geliştirici iş yükünü hafifletirken, özelleştirme imkânları sayesinde karmaşık dönüşüm senaryolarında bile kullanılabilir. Ancak performans ve karmaşıklık ihtiyaçlarınıza göre manuel eşleme ile ModelMapper arasında bir seçim yapmanız gerekebilir.

# 
### DTO ile Entity Dönüşümlerinde ModelMapper Kullanırken Dikkat Edilmesi Gereken Kurallar

**ModelMapper** kullanarak DTO (Data Transfer Object) ile Entity dönüşümü yaparken, kodun sürdürülebilir, güvenli ve performanslı olması için bazı kurallara dikkat edilmelidir. Bu kurallar, hem yazılım geliştirme süreçlerini hem de veri tutarlılığını iyileştirir.

---

### **1. DTO ve Entity Tasarımı**

#### **a. DTO ve Entity Ayrımı**
- DTO'lar (Data Transfer Object), yalnızca veri taşıma amaçlıdır ve genellikle API seviyesinde kullanılır.
- Entity'ler (varlıklar), veritabanı ile ilişkili yapılardır ve genellikle iş kuralları veya ORM araçlarıyla ilişkilendirilir.
- **Kural:** DTO ile Entity'yi asla aynı sınıfta birleştirmeyin. Ayrı sınıflar olarak tasarlayın.

#### **b. Gereksiz Alanlardan Kaçınma**
- DTO'lar yalnızca taşınması gereken alanları içermelidir. Gereksiz alanların DTO'ya dahil edilmesi veri yükünü artırır ve performansı olumsuz etkiler.
- **Örnek:**
   - Entity: Tüm veritabanı alanlarını içerir.
   - DTO: API'ye döndürülecek yalnızca gerekli alanları içerir.

#### **c. Nesne Hiyerarşisinin Basitleştirilmesi**
- DTO'lar, karmaşık nesne ilişkilerini sadeleştirerek daha okunabilir ve taşınabilir hale getirilmelidir.
- Örneğin, bir `OrderEntity` nesnesi içinde `CustomerEntity` olabilir, ancak `OrderDTO` içinde sadece `customerId` tutulabilir.

---

### **2. ModelMapper Konfigürasyonu**

#### **a. Alan İsimlerinin Tutarlılığı**
- ModelMapper, varsayılan olarak alan isimlerini eşleştirir. DTO ve Entity arasındaki alan isimleri aynı olmalıdır. Farklı isimler varsa özelleştirme yapılmalıdır.
- **Örnek:**
   - Entity: `firstName`
   - DTO: `firstName`
   - Farklı isimler (ör. DTO’da `first_name`) kullanılması durumunda, manuel eşleme gereklidir.

```java
modelMapper.addMappings(new PropertyMap<UserEntity, UserDTO>() {
    @Override
    protected void configure() {
        map().setFirstName(source.getName());
    }
});
```

---

#### **b. Hiyerarşik Eşleme**
- ModelMapper, iç içe geçmiş nesnelerdeki alanları otomatik olarak eşleyebilir. Ancak bu durum, yalnızca gerekli alanların dahil edilmesini sağlamak için dikkatli yönetilmelidir.
- Örnek:
   - Entity:
     ```java
     public class OrderEntity {
         private CustomerEntity customer;
         private ProductEntity product;
     }
     ```
   - DTO:
     ```java
     public class OrderDTO {
         private Long customerId;
         private Long productId;
     }
     ```

Eşleme:
```java
modelMapper.addMappings(new PropertyMap<OrderEntity, OrderDTO>() {
    @Override
    protected void configure() {
        map().setCustomerId(source.getCustomer().getId());
        map().setProductId(source.getProduct().getId());
    }
});
```

---

### **3. Performans Optimizasyonu**

#### **a. Büyük Veri Setlerinde Eşleme**
- ModelMapper, küçük veri setleri için hızlı çalışır. Ancak büyük veri setlerinde, performans manuel eşlemeye göre düşebilir. Bu nedenle, dönüşüm işlemi sırasında yalnızca gerekli alanlar eşlenmelidir.

#### **b. Lazy Loading Problemleri**
- Hibernate gibi ORM araçları ile kullanılan Entity'lerde lazy loading problemi oluşabilir. DTO oluşturulurken lazy yüklenen ilişkiler tetiklenebilir ve performans sorunlarına yol açabilir.
- **Kural:** Lazy yüklenen ilişkileri DTO’ya taşımadan önce kontrol edin ve gerekli olmayan ilişkileri dahil etmeyin.

---

### **4. Özel Dönüşümler**

#### **a. Alan Tipi Farklılıkları**
- Entity ile DTO arasında veri tipleri farklıysa özel dönüşüm yapılmalıdır. Örneğin:
   - Entity: `LocalDate`
   - DTO: `String` (Tarih formatında)

```java
modelMapper.addConverter((MappingContext<LocalDate, String> context) -> 
    context.getSource() == null ? null : context.getSource().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
);
```

#### **b. Enum ve String Dönüşümleri**
- Entity bir `Enum` tutarken, DTO’da bu alan bir `String` olarak ifade edilebilir.

```java
modelMapper.addConverter((MappingContext<Status, String> context) -> 
    context.getSource() == null ? null : context.getSource().name()
);
```

---

### **5. İki Yönlü Eşleme (Bidirectional Mapping)**

Bazen DTO’dan Entity’e ve Entity’den DTO’ya dönüşüm yapmak gerekebilir. Bu durumda her iki yönde de eşleme kuralları tanımlanmalıdır.

```java
modelMapper.addMappings(new PropertyMap<UserEntity, UserDTO>() {
    @Override
    protected void configure() {
        map().setFirstName(source.getFirstName());
    }
});

modelMapper.addMappings(new PropertyMap<UserDTO, UserEntity>() {
    @Override
    protected void configure() {
        map().setFirstName(source.getFirstName());
    }
});
```

---

### **6. Validation (Doğrulama)**

- DTO, genellikle kullanıcıdan alınan verilerle çalıştığı için `@NotNull`, `@Size`, `@Pattern` gibi doğrulama anotasyonları kullanılmalıdır.
- Entity sınıfı ise iş kurallarını ve veri tabanı yapısını temsil ettiği için bu doğrulamaları içermez.

**Örnek:**

DTO:
```java
public class UserDTO {
    @NotNull
    @Size(min = 2, max = 50)
    private String firstName;

    @NotNull
    @Email
    private String email;
}
```

Entity:
```java
public class UserEntity {
    private String firstName;
    private String email;
}
```

---

### **7. Güvenlik ve Veri Gizliliği**

- DTO’ya yalnızca kullanıcı ile paylaşılması gereken alanları ekleyin. Örneğin, hassas bilgiler (şifre gibi) DTO’ya taşınmamalıdır.

**Örnek:**
Entity:
```java
public class UserEntity {
    private String username;
    private String password; // Şifre Entity'de tutulur
}
```

DTO:
```java
public class UserDTO {
    private String username;
    // Şifre DTO'da yer almaz
}
```

---

### **8. Test ve Hata Yönetimi**

#### **a. Unit Test**
- Eşleme kurallarının doğruluğunu kontrol etmek için unit test yazın.

```java
@Test
public void testEntityToDtoMapping() {
    UserEntity userEntity = new UserEntity();
    userEntity.setFirstName("Ahmet");
    userEntity.setEmail("ahmet@example.com");

    UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);

    assertEquals("Ahmet", userDTO.getFirstName());
    assertEquals("ahmet@example.com", userDTO.getEmail());
}
```

#### **b. Null ve Boş Değer Kontrolü**
- ModelMapper, varsayılan olarak null değerlerle çalışabilir. Ancak, null veya boş değerler eşlenmemesi gerekiyorsa kontrol eklenmelidir.

---

### **Sonuç**

ModelMapper kullanırken DTO ve Entity dönüşümlerinde şu kurallara dikkat edilmelidir:
1. **DTO ve Entity’yi ayrı tutun.**
2. **Gerekli alanları eşleyin, gereksiz olanları dahil etmeyin.**
3. **Hiyerarşik ve karmaşık nesnelerde özelleştirilmiş eşleme yapın.**
4. **Performansı göz önünde bulundurun ve lazy loading sorunlarını kontrol edin.**
5. **Doğrulama ve veri gizliliğine dikkat edin.**
6. **Test yazmayı unutmayın.**

Bu kurallara uyarak, dönüşüm işlemlerini daha verimli, güvenli ve sürdürülebilir bir hale getirebilirsiniz.