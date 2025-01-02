# Techcareer 2025 Backend-1 Spring Boot
[GitHub Address](https://github.com/hamitmizrak/techcareer_2025_backend_1.git)
---

Spring Boot'ta kullanılan **@NotEmpty**, **@NotBlank** ve **@NotNull** anotasyonları, **Bean Validation** API'sinin bir parçasıdır ve giriş verilerini doğrulamak için kullanılır. Bu anotasyonların her biri belirli bir doğrulama senaryosu için uygundur. Detaylı olarak bu anotasyonları ve aralarındaki farkları inceleyelim:

---

### 1. **@NotNull**
**Açıklama**:
- Bir alanın `null` olup olmadığını kontrol eder. Eğer bir değer `null` ise doğrulama başarısız olur.
- Boş (`""`) veya yalnızca boşluklardan (`"   "`) oluşan bir dizeyi kabul eder, çünkü boşluklar `null` değildir.

**Kullanım Alanı**:
- Temel olarak bir alanın mutlaka bir değer içermesi gerektiğinde kullanılır.
- Özellikle primitive olmayan türlerde (örneğin, `String`, `Integer`, `List`, vb.) kullanılır.

**Kod Örneği**:
```java
public class UserDto {
    @NotNull(message = "Ad alanı null olamaz")
    private String name;

    @NotNull(message = "Yaş bilgisi null olamaz")
    private Integer age;
}
```

**Davranış**:
- `name = null` veya `age = null` ise doğrulama hatası oluşur.
- `name = ""` veya `age = 0` gibi değerler geçerlidir.

---

### 2. **@NotEmpty**
**Açıklama**:
- Bir alanın **null olmamasını** ve **boş olmamasını** kontrol eder.
- Eğer bir dizi (örneğin `String`) veya koleksiyon (örneğin `List`, `Set`) kullanıyorsanız, alanın boş olmaması gerektiğini belirtir.

**Kullanım Alanı**:
- Dizelerin veya koleksiyonların **boş** olmaması gerektiği durumlarda tercih edilir.

**Kod Örneği**:
```java
public class UserDto {
    @NotEmpty(message = "Ad alanı boş olamaz")
    private String name;

    @NotEmpty(message = "Adres listesi boş olamaz")
    private List<String> addresses;
}
```

**Davranış**:
- `name = null` veya `name = ""` ise doğrulama hatası oluşur.
- `addresses = null` veya `addresses = []` (boş liste) olduğunda doğrulama başarısız olur.

---

### 3. **@NotBlank**
**Açıklama**:
- Bir alanın **null**, **boş** veya yalnızca **boşluklardan** oluşmasını engeller.
- Daha çok dizeler üzerinde kullanılır ve **@NotEmpty** anotasyonuna göre daha sıkı bir doğrulama sağlar.

**Kullanım Alanı**:
- Kullanıcının giriş yaptığı alanlarda (örneğin, ad veya şifre gibi), yalnızca boşluklardan oluşan bir değerin kabul edilmemesi gerektiği durumlarda kullanılır.

**Kod Örneği**:
```java
public class UserDto {
    @NotBlank(message = "Ad alanı boş veya sadece boşluk olamaz")
    private String name;

    @NotBlank(message = "Şifre boş veya sadece boşluk olamaz")
    private String password;
}
```

**Davranış**:
- `name = null`, `name = ""` veya `name = "   "` (sadece boşluk) gibi durumlarda doğrulama hatası oluşur.

---

### Farklılıkları Karşılaştırma Tablosu

| Özellik            | **@NotNull**                           | **@NotEmpty**                         | **@NotBlank**                          |
|---------------------|-----------------------------------------|----------------------------------------|-----------------------------------------|
| **null Kontrolü**   | `null` değerini kabul etmez.           | `null` değerini kabul etmez.          | `null` değerini kabul etmez.           |
| **Boş Değer**       | Boş dizeleri kabul eder (`""`).        | Boş dizeleri kabul etmez.             | Boş dizeleri kabul etmez.              |
| **Boşluklar**       | Boşluklardan oluşan dizeleri kabul eder.| Boşluklardan oluşan dizeleri kabul eder.| Boşluklardan oluşan dizeleri kabul etmez.|
| **Koleksiyonlar**   | Koleksiyonlar üzerinde etkisi yoktur.  | Boş koleksiyonları kabul etmez.       | Genelde dizeler üzerinde kullanılır.   |
| **Kullanım Alanı**  | Tüm veri türleri                      | Koleksiyonlar ve dizeler              | Sadece dizeler                         |

---

### Örnek: Tümünün Kullanıldığı Bir Senaryo
```java
public class UserDto {
    @NotNull(message = "Kullanıcı adı boş olamaz")
    private String username;

    @NotEmpty(message = "E-posta boş olamaz")
    private String email;

    @NotBlank(message = "Şifre sadece boşluklardan oluşamaz")
    private String password;
}
```

**Açıklama**:
- `username` alanı için `null` değerine izin verilmez, ancak `""` (boş dize) geçerli bir değer olarak kabul edilir.
- `email` alanı için hem `null` hem de `""` (boş dize) geçersizdir.
- `password` alanı için `null`, `""` (boş dize) ve `"   "` (sadece boşluklardan oluşan dize) geçersizdir.

---

### Doğrulama Nasıl Çalışır?
Spring Boot uygulamalarında bu anotasyonları kullanarak doğrulama yapmak için genellikle bir **@Valid** anotasyonu ile birlikte `Controller` veya `Service` katmanında çalıştırılır. Örneğin:

```java
@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok("Kullanıcı oluşturuldu.");
    }
}
```

**Açıklama**:
- `@Valid` anotasyonu, `UserDto` üzerindeki doğrulama kurallarını çalıştırır.
- Eğer herhangi bir alan doğrulama kurallarına uymazsa, Spring otomatik olarak bir hata döner.

---

### ValidationException ve Hata Mesajları
Doğrulama hatalarını özelleştirmek için bir **@ExceptionHandler** tanımlanabilir:

```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
```

Bu yapı, doğrulama hatalarını kullanıcı dostu bir şekilde geri döndürmek için kullanılır.

---

### Sonuç
- **@NotNull**: `null` değerini engeller, boş veya boşluklarla ilgili bir kontrol yapmaz.
- **@NotEmpty**: `null` ve boş (`""`) değerlerini engeller, boşluklarla ilgili kontrol yapmaz.
- **@NotBlank**: `null`, boş (`""`) ve sadece boşluklardan (`"   "`) oluşan değerleri engeller.

Bu anotasyonlar doğru bir şekilde kullanıldığında, verilerinizin doğruluğunu sağlamaya yardımcı olur ve uygulamanızın sağlamlığını artırır.