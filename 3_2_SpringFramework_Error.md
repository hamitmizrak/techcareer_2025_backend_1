# Techcareer 2025 Backend-1 Spring Boot
[GitHub Address](https://github.com/hamitmizrak/techcareer_2025_backend_1.git)
---


### Spring Framework’te `ErrorController` ve `ErrorAttributes`

Spring Framework ve Spring Boot, uygulama genelinde hata yönetimini standart bir şekilde ele almak için bir hata yönetim altyapısı sunar. Bu altyapıda **`ErrorController`** ve **`ErrorAttributes`**, hata işleme ve özelleştirilmiş hata yanıtları sağlamak için kullanılan iki önemli bileşendir.

---

### 1. **ErrorController Nedir?**

`ErrorController`, Spring Boot’un hata durumlarında bir yol (endpoint) tanımlayarak, hataların nasıl yönetileceğini kontrol eden bir arayüzdür. Varsayılan olarak, Spring Boot hata durumlarında bir JSON yanıt veya HTML hata sayfası döner.

- **Varsayılan Hata Yönetimi**:
  Varsayılan olarak Spring Boot, `/error` adında bir endpoint sağlar ve bu endpoint, meydana gelen hata ile ilgili bilgileri döner.

- **Özelleştirme**:
  Uygulamanın özel ihtiyaçlarına uygun hata yanıtları döndürmek için `ErrorController`’ı implemente edebilir ve özelleştirebilirsiniz.

---

### 2. **ErrorAttributes Nedir?**

`ErrorAttributes`, Spring Boot’un hata sırasında döndürülecek bilgileri belirlemek için kullanılan bir arayüzdür. Varsayılan olarak, aşağıdaki bilgileri sağlar:

- **timestamp**: Hata zamanı.
- **status**: HTTP durum kodu.
- **error**: Hata mesajı.
- **message**: Hata ayrıntısı.
- **path**: Hatanın meydana geldiği URL.

**ErrorAttributes** sınıfını özelleştirerek döndürülen hata detaylarını değiştirebilir veya genişletebilirsiniz.

---

### Özelleştirilmiş `ErrorController` ve `ErrorAttributes` Örneği

Aşağıda, bir hata durumunda özel yanıt döndüren bir `ErrorController` ve özelleştirilmiş `ErrorAttributes` örneği bulunmaktadır.

#### 2.1 `ErrorAttributes` Uygulaması
```java
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomErrorAttributes implements ErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        // Varsayılan hata bilgilerini al
        Map<String, Object> defaultAttributes = new HashMap<>();
        defaultAttributes.put("timestamp", System.currentTimeMillis());
        defaultAttributes.put("status", webRequest.getAttribute("javax.servlet.error.status_code", WebRequest.SCOPE_REQUEST));
        defaultAttributes.put("error", "Özel hata mesajı: Bir hata oluştu!");
        defaultAttributes.put("path", webRequest.getDescription(false).replace("uri=", ""));
        defaultAttributes.put("customMessage", "Bu bir özelleştirilmiş hata yanıtıdır!");

        return defaultAttributes;
    }

    @Override
    public Throwable getError(WebRequest webRequest) {
        // Hata detaylarını döner
        return (Throwable) webRequest.getAttribute("javax.servlet.error.exception", WebRequest.SCOPE_REQUEST);
    }
}
```

#### 2.2 `ErrorController` Uygulaması
```java
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class CustomErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    // Constructor Injection
    public CustomErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    // Hataları yakalayacak endpoint
    @GetMapping("/error")
    public ResponseEntity<Map<String, Object>> handleError(HttpServletRequest request) {
        WebRequest webRequest = new ServletWebRequest(request);

        // ErrorAttributes ile hata bilgilerini al
        Map<String, Object> errorDetails = errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.defaults());

        // Özel bir JSON yanıt döndür
        return ResponseEntity.status((int) errorDetails.get("status"))
                             .body(errorDetails);
    }

    @Override
    public String getErrorPath() {
        // Spring Boot 2.3 ve üzeri sürümlerde artık kullanılmıyor
        return "/error";
    }
}
```

---

### 3. **Uygulama Yapılandırması**

#### application.properties
```properties
server.error.whitelabel.enabled=false
```
- Bu ayar, Spring Boot’un varsayılan hata sayfasını devre dışı bırakır ve özelleştirilmiş hata kontrolüne izin verir.

---

### 4. **Test İçin Örnek Bir Controller**

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        // Bilinçli olarak bir hata fırlat
        throw new RuntimeException("Test Hatası!");
    }
}
```

---

### Çıktı

**Hata Durumunda Dönen JSON Yanıt:**
```json
{
  "timestamp": 1700000000000,
  "status": 500,
  "error": "Özel hata mesajı: Bir hata oluştu!",
  "path": "/test",
  "customMessage": "Bu bir özelleştirilmiş hata yanıtıdır!"
}
```

---

### Önemli Noktalar

1. **ErrorAttributes ile Hata Bilgilerini Genişletme**:
    - Özel alanlar ekleyerek hata yanıtını zenginleştirebilirsiniz (ör. `customMessage`).

2. **ErrorController ile Özelleştirilmiş Yanıtlar**:
    - Standart `/error` endpointini ele alarak özelleştirilmiş hata yanıtları dönebilirsiniz.

3. **Spring Security Entegrasyonu**:
    - Eğer uygulamanızda Spring Security varsa, hata durumlarını kontrol etmek için özelleştirilmiş bir hata filtresi veya kontrol mekanizması kullanabilirsiniz.

4. **Hata Yönetimini Merkezi Hale Getirme**:
    - Uygulamanızdaki tüm hata durumlarını tek bir yerden kontrol etmek ve yönetmek için bu altyapı oldukça güçlüdür.

---

Bu şekilde, Spring Boot uygulamalarınızda hata yönetimini hem özelleştirilmiş hem de kullanıcı dostu bir şekilde yapılandırabilirsiniz.