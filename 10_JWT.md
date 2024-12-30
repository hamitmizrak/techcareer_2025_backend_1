# Techcareer 2025 Backend-1 Spring Boot
[GitHub Address](https://github.com/hamitmizrak/techcareer_2025_backend_1.git)
---

## Git
```sh 
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
```sh
    http://localhost:4444
    http://localhost:4444/h2-console
    http://localhost:4444/swagger-ui/index.html
    http://localhost:4444/actuator/health
```
---

## Version
```sh 
git -v
mvn -v
java --version
javac --version
docker version
docker-compose version
```
---

## Git Init
```sh 
git init
git add .
git commit -m "spring boot init"
git remote add origin URL
git push -u origin master

git clone https://github.com/hamitmizrak/
```
---

## Git Codes
```sh
git status
git logs

```



Spring Security, Java tabanlı uygulamalarda kimlik doğrulama, yetkilendirme ve erişim kontrolü sağlamak için kullanılan güçlü ve esnek bir güvenlik çerçevesidir. Spring Framework’ün bir modülü olan Spring Security, web uygulamaları, RESTful API’ler ve mikroservis mimarilerinde güvenlik önlemleri almak için yaygın olarak kullanılır. Özellikle kurumsal projelerde güvenliğin kritik önemde olduğu durumlarda, Spring Security’nin sunduğu kapsamlı güvenlik özellikleri, uygulamaların yüksek güvenlik standartlarına uygun bir şekilde geliştirilmesine olanak tanır.

### Spring Security'nin Temel Özellikleri ve Faydaları

1. **Kimlik Doğrulama (Authentication)**: Kullanıcıların sisteme erişim sağlamak için doğrulanmasını sağlar. Kimlik doğrulama, kullanıcı adı ve şifre ile yapılabileceği gibi, OAuth2 ve JWT (JSON Web Token) gibi modern güvenlik protokolleri ile de desteklenir.

2. **Yetkilendirme (Authorization)**: Kimlik doğrulaması yapılan kullanıcıların hangi kaynaklara erişim iznine sahip olduğunu belirler. Kullanıcılar belirli roller ve yetkilere göre sınıflandırılır ve bu yetkiler doğrultusunda kaynaklara erişim izni verilir.

3. **HTTP Güvenliği**: Spring Security, HTTP tabanlı saldırılara karşı koruma sağlar. Özellikle CSRF (Cross-Site Request Forgery - Siteler Arası İstek Sahteciliği), XSS (Cross-Site Scripting - Siteler Arası Betik Çalıştırma) ve Clickjacking gibi saldırılara karşı güvenlik önlemleri sunar.

4. **Şifreleme ve Hashing Desteği**: Spring Security, kullanıcı şifrelerinin güvenli bir şekilde saklanması ve işlenmesi için hashing algoritmaları kullanır. Örneğin, BCrypt algoritması ile şifrelerin güvenli bir şekilde saklanmasını sağlar.

5. **Esnek Kimlik Doğrulama Mekanizmaları**: Temel kimlik doğrulamanın yanı sıra, LDAP (Lightweight Directory Access Protocol), OAuth2, OpenID Connect ve SSO (Single Sign-On) gibi çeşitli kimlik doğrulama protokolleri ile entegre çalışır.

6. **Kolay Konfigürasyon ve Esneklik**: Spring Security, hem XML tabanlı hem de Java tabanlı konfigürasyon destekler. Geliştiricilere, güvenlik ayarlarını özelleştirme ve uygulama gereksinimlerine göre yapılandırma imkanı tanır.

### Spring Security’nin Mimarisi

Spring Security’nin temel yapısı üç ana bileşenden oluşur:

1. **SecurityContext**: Uygulamada oturum açan kullanıcıya ait güvenlik bilgisini saklar. SecurityContext, kimlik doğrulama işlemi tamamlandığında kullanıcının kimliğini doğrulayan bilgileri içerir ve uygulama boyunca bu bilgilerden faydalanır.

2. **AuthenticationManager**: Kullanıcının kimliğini doğrulayan ana bileşendir. AuthenticationManager, kimlik doğrulama sağlayıcıları (authentication providers) aracılığıyla kimlik doğrulama işlemlerini gerçekleştirir. Bu sağlayıcılar, kullanıcı bilgilerini doğrulamak için veri tabanları, LDAP veya üçüncü parti kimlik doğrulama servisleri ile entegre çalışabilir.

3. **AccessDecisionManager**: Yetkilendirme kararlarını alır ve kullanıcının belirli bir kaynağa erişim hakkı olup olmadığını belirler. Kullanıcı, istenen kaynağa erişim iznine sahip değilse, erişim reddedilir.



## Basic Auth
### **Spring Security Basic Authentication Nedir?**

**Spring Security Basic Authentication**, HTTP protokolü üzerinden **Temel Kimlik Doğrulama (Basic Authentication)** sağlamanın Spring Security çerçevesiyle yapılmış bir uygulamasıdır. Basic Authentication, istemci ile sunucu arasındaki iletişimde, kullanıcı kimlik bilgilerinin (kullanıcı adı ve şifre) **Base64** formatında kodlanarak taşınmasını sağlar. Bu yöntem, güvenlik açısından temel bir kimlik doğrulama protokolüdür.

---

### **HTTP Basic Authentication Nasıl Çalışır?**

**1. Kimlik Bilgileri Gönderimi:**
- İstemci, sunucuya bir HTTP isteği gönderirken, kimlik bilgilerini (`username:password`) **Base64** ile kodlayarak `Authorization` başlığı (header) içerisinde gönderir.

**2. Sunucunun Doğrulama Süreci:**
- Sunucu, `Authorization` başlığındaki Base64 ile kodlanmış kullanıcı adı ve şifreyi çözerek doğrular.
- Kimlik doğrulama başarılı olursa, istemciye erişim izni verir.
- Başarısız olursa, **HTTP 401 Unauthorized** yanıtı döner.

**Örnek HTTP İstek:**

```http
GET /protected-resource HTTP/1.1
Host: example.com
Authorization: Basic dXNlcm5hbWU6cGFzc3dvcmQ=
```

- `Authorization: Basic dXNlcm5hbWU6cGFzc3dvcmQ=` kısmı, kullanıcı adı ve şifrenin (`username:password`) Base64 ile kodlanmış halidir.

---

### **Basic Authentication Güvenlik Zafiyetleri**

**1. Şifrelerin Kodlanması:**
- Kullanıcı adı ve şifre Base64 ile kodlanır, ancak bu **şifrelenmiş değildir**. Yani, Base64 kodlaması kolayca çözülebilir.

**2. HTTPS Kullanımı Zorunluluğu:**
- Basic Authentication, güvenli olmayan HTTP bağlantılarında saldırılara açıktır. Bu nedenle, **HTTPS** kullanılmadan bu yöntemin uygulanması önerilmez.

**3. Kimlik Bilgilerinin Her İstekle Gönderilmesi:**
- Kullanıcı adı ve şifre her HTTP isteğiyle birlikte gönderilir. Bu, kimlik bilgilerinin ele geçirilme riskini artırır.

---

### **Spring Security ile Basic Authentication Uygulaması**

Spring Security, Basic Authentication yöntemini kolayca uygulamak için yerleşik bir destek sağlar. Aşağıda, adım adım bir Basic Authentication uygulaması açıklanmıştır.

---

#### **1. Maven Bağımlılığı**
Spring Security kullanımı için aşağıdaki bağımlılığı `pom.xml` dosyanıza ekleyin:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

---

#### **2. Varsayılan Basic Authentication**

Spring Security, herhangi bir özel yapılandırma olmadan varsayılan olarak Basic Authentication sağlar.

**Varsayılan Kullanıcı Adı ve Şifre:**
- Kullanıcı adı: `user`
- Şifre: Uygulama başlatıldığında otomatik olarak loglarda üretilir (örneğin, `Using generated security password: <password>`).

**application.properties:**
```properties
spring.security.user.name=admin
spring.security.user.password=admin123
```

---

#### **3. Güvenlik Yapılandırması**

Spring Security yapılandırmasını özelleştirmek için bir `SecurityConfig` sınıfı oluşturabilirsiniz.

**SecurityConfig.java:**

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // CSRF korumasını devre dışı bırakabilirsiniz (örnek için).
            .authorizeHttpRequests(auth -> auth
                .antMatchers("/public/**").permitAll() // "/public" dizini herkese açık.
                .anyRequest().authenticated() // Diğer tüm istekler kimlik doğrulama gerektirir.
            )
            .httpBasic(); // Basic Authentication kullanılır.
        return http.build();
    }
}
```

**Açıklamalar:**
- **`http.csrf().disable()`:**
    - CSRF korumasını devre dışı bırakır (REST API'ler için genellikle kapatılır).
- **`antMatchers("/public/**").permitAll()`:**
    - `/public` dizinindeki kaynaklara kimlik doğrulama olmadan erişilebilir.
- **`anyRequest().authenticated()`:**
    - Diğer tüm kaynaklara erişim için kimlik doğrulama gereklidir.
- **`httpBasic()`:**
    - Basic Authentication'ı etkinleştirir.

---

#### **4. Kimlik Bilgilerinin Kontrolü**

Basic Authentication için kullanıcı adı ve şifre kontrolünü özelleştirmek isterseniz, bir `UserDetailsService` veya `AuthenticationProvider` kullanabilirsiniz.

**Custom UserDetailsService Örneği:**

```java
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            return User.withUsername(username)
                    .password("{noop}admin123") // {noop} şifreyi şifrelemeden kullanır.
                    .roles("ADMIN")
                    .build();
        } else {
            throw new UsernameNotFoundException("Kullanıcı bulunamadı: " + username);
        }
    }
}
```

---

#### **5. Kullanıcı Şifrelerini Şifrelemek**

Spring Security'de şifrelerin güvenli bir şekilde saklanması için `BCryptPasswordEncoder` kullanılır.

**Şifreleme Örneği:**

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

**Şifre Kullanımı:**

```java
return User.withUsername(username)
        .password(passwordEncoder.encode("admin123"))
        .roles("ADMIN")
        .build();
```

---

### **Spring Security Basic Authentication'ın Avantajları**

1. **Kolay Kurulum:**
    - Minimal konfigürasyonla hızlı bir şekilde kurulabilir.

2. **REST API'ler için Uygun:**
    - Özellikle küçük ölçekli veya geçici uygulamalarda hızlı bir çözüm sunar.

3. **Spring Security'nin Güçlü Özellikleri:**
    - Yetkilendirme, CSRF koruması gibi özelliklerle birleştirilebilir.

---

### **Spring Security Basic Authentication'ın Dezavantajları**

1. **Şifrelerin Açık Gönderilmesi:**
    - Kullanıcı adı ve şifre her istekle birlikte gönderilir, bu nedenle HTTPS kullanımı zorunludur.

2. **Oturum Yönetimi Yok:**
    - Kullanıcı oturumları yönetilmez. Her istekte kimlik bilgileri yeniden gönderilir.

3. **Sınırlı Güvenlik:**
    - Büyük ve karmaşık uygulamalarda daha güvenli yöntemler (JWT, OAuth2 gibi) tercih edilmelidir.

---

### **Sonuç**

Spring Security Basic Authentication, hızlı ve basit bir kimlik doğrulama çözümüdür. Ancak güvenlik risklerinden dolayı yalnızca HTTPS ile kullanılması ve şifrelerin güçlü algoritmalarla saklanması önerilir. Daha karmaşık ihtiyaçlar için, OAuth2 veya JWT gibi modern yöntemler tercih edilmelidir.

## JWT Nedir?
### **JWT Nedir? (JSON Web Token)**

JWT (JSON Web Token), dijital olarak imzalanmış bir güvenlik belirteci (token) formatıdır. JSON formatında bilgi içerir ve web uygulamaları arasında güvenli bir şekilde veri paylaşmak için kullanılır. JWT, özellikle kimlik doğrulama ve yetkilendirme işlemlerinde yaygın olarak kullanılmaktadır.

JWT'nin en önemli özelliklerinden biri, kendi kendine yeterli olmasıdır. Bu, token içinde tüm gerekli bilgilerin bulunduğu anlamına gelir. Sunucu, bu bilgileri doğrulamak için herhangi bir ek bilgiye ihtiyaç duymaz. JWT, genellikle **kimlik doğrulama**, **yetkilendirme**, **bilgi paylaşımı** ve **API güvenliği** gibi durumlarda kullanılır.

---

### **JWT'nin Yapısı**
Bir JWT üç ana bölümden oluşur:

1. **Header (Başlık)**  
   JWT'nin türü ve imzalama algoritmasını belirtir.
   ```json
   {
     "alg": "HS256",
     "typ": "JWT"
   }
   ```
   - **alg**: Kullanılan algoritmayı belirtir (ör. HS256, RS256).
   - **typ**: Token türünü belirtir (JWT).

   Header, Base64URL formatında kodlanır.

2. **Payload (Yük)**  
   Kullanıcının kimliği veya uygulama tarafından ihtiyaç duyulan diğer bilgiler gibi veriler içerir.
   ```json
   {
     "sub": "1234567890",
     "name": "John Doe",
     "admin": true
   }
   ```
   - **sub**: Kullanıcı kimliğini belirtir.
   - **name**: Kullanıcı adı.
   - **admin**: Kullanıcının yönetici olup olmadığını belirtir.

   Payload, Base64URL formatında kodlanır. Payload'daki veriler şifrelenmez; yalnızca kodlanır. Bu yüzden hassas bilgileri burada saklamamak önemlidir.

3. **Signature (İmza)**  
   Token'ın bütünlüğünü ve doğruluğunu garanti eder.
   ```
   HMACSHA256(
     base64UrlEncode(header) + "." + base64UrlEncode(payload),
     secret
   )
   ```
   İmza, Header ve Payload'ın birleştirilmesiyle oluşan verinin gizli bir anahtar kullanılarak hashlenmesiyle üretilir. Bu sayede token'ın üzerinde değişiklik yapıldığında, imza doğrulama işlemi başarısız olur.

---

### **JWT'nin Yapısı Örneği**
Bir JWT şu şekilde görünür:
```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
```
Bu token üç bölüme ayrılmıştır:
- **Header**: `eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9`
- **Payload**: `eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9`
- **Signature**: `SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c`

---

### **JWT'nin Çalışma Mantığı**
1. **Kimlik Doğrulama**:
   - Kullanıcı, kullanıcı adı ve şifresini sunucuya gönderir.
   - Sunucu, bilgileri doğrularsa bir JWT oluşturur ve kullanıcıya geri gönderir.
2. **Yetkilendirme**:
   - Kullanıcı, her API isteğinde JWT'yi Authorization başlığı ile gönderir.
   - Sunucu, gelen token'ı doğrular ve isteğin yetkisini kontrol eder.

---

### **JWT'nin Avantajları**
- **Stateless (Durumsuz) Doğrulama**:  
  JWT, sunucuda herhangi bir oturum bilgisi saklamaz. Bu, ölçeklenebilirlik açısından büyük bir avantajdır.
- **Kendi Kendine Yeterlilik**:  
  Token içinde tüm bilgiler bulunduğundan, her istekte sunucunun ek bir sorgu yapmasına gerek yoktur.
- **Esneklik**:  
  JWT, herhangi bir veri taşımak için kullanılabilir.
- **Platform Bağımsızlığı**:  
  JWT, tüm programlama dilleri ile uyumludur.

---

### **JWT'nin Dezavantajları**
- **Şifrelenmemiş Veri**:  
  Payload kısmındaki bilgiler Base64 kodlaması ile saklanır, ancak şifrelenmez. Hassas bilgiler için ek güvenlik önlemleri gereklidir.
- **Token İptali**:  
  JWT'nin geçerlilik süresi dolana kadar iptal edilemez. Bu, oturum kapatma işlemlerinde bir zorluk yaratabilir.

---

### **JWT Kullanım Alanları**
1. **Kimlik Doğrulama (Authentication)**:
   - Kullanıcı giriş işlemlerinde kullanılır.
2. **Yetkilendirme (Authorization)**:
   - Kullanıcının erişim haklarını belirlemek için kullanılır.
3. **API Güvenliği**:
   - Web servislerinde güvenli bir veri alışverişi sağlamak için kullanılır.

---

### **JWT ile Kimlik Doğrulama Örneği**
#### **Kullanıcı Girişi ve Token Oluşturma**
1. Kullanıcı giriş yapar.
2. Sunucu aşağıdaki bilgileri içeren bir JWT oluşturur:
   ```json
   {
     "sub": "1234567890",
     "name": "Jane Doe",
     "roles": ["admin", "user"],
     "iat": 1516239022,
     "exp": 1516242622
   }
   ```
3. Token kullanıcıya gönderilir.

#### **API İsteği**
Kullanıcı, bir API isteği yaparken token'ı şu şekilde gönderir:
```
Authorization: Bearer <JWT>
```

#### **Token Doğrulama**
1. Sunucu, gelen token'ı doğrular.
2. Eğer token geçerliyse, kullanıcının kimliğini ve izinlerini kontrol eder.

---

### **JWT'nin Güvenlik Önlemleri**
- **Gizli Anahtar**: İmzalama işlemi için kullanılan anahtar, güvenli bir şekilde saklanmalıdır.
- **HTTPS Kullanımı**: Token aktarımı sırasında güvenliği sağlamak için HTTPS kullanılmalıdır.
- **Kısa Geçerlilik Süresi**: Token'ların ömrü kısa tutulmalı ve sık sık yenilenmelidir.
- **Refresh Token**: Ana JWT'nin süresi dolduğunda, kullanıcıyı yeniden doğrulamak için bir yenileme token'ı kullanılabilir.

---

### **JWT ile İlgili Önemli Kavramlar**
- **Refresh Token**: Ana JWT'nin süresi dolduğunda, kullanıcıyı tekrar doğrulamak için kullanılır.
- **Stateless**: JWT, sunucunun durum bilgisi tutmasına gerek bırakmaz.
- **Bearer Token**: JWT, genellikle `Authorization` başlığı altında taşınır.

JWT, modern web uygulamalarında güvenli bir şekilde veri paylaşmak ve kullanıcı kimlik doğrulaması sağlamak için güçlü ve popüler bir araçtır.
---
### Spring Security ile Kimlik Doğrulama (Authentication)

Kimlik doğrulama, kullanıcının geçerli bir kullanıcı adı ve şifre ile sisteme giriş yapması işlemidir. Spring Security’de kimlik doğrulama işlemi `AuthenticationManager` aracılığıyla gerçekleştirilir. `UsernamePasswordAuthenticationToken` sınıfı, en yaygın kimlik doğrulama yöntemi olan kullanıcı adı ve şifreyle doğrulama yapar. `AuthenticationProvider` ise bu doğrulama sürecinin gerçek kaynağıdır; yani kullanıcı bilgilerini doğrulamak için veri tabanında arama yapar.


Aşağıda, Spring Boot ile JWT (JSON Web Token) kullanarak bir kimlik doğrulama sistemi örneği adım adım açıklanmıştır. Bu örnek, JWT ile bir kullanıcı giriş sistemi oluşturur ve kimlik doğrulama işlemlerini güvenli bir şekilde yapmayı sağlar.

---

### Proje Gereksinimleri
- **Java 11+**
- **Spring Boot 3.3.1**
- **Maven**
- **H2 Database (veya başka bir veritabanı)**

---

### Adım 1: Proje Yapılandırması
Spring Boot projesini oluşturun. Projede aşağıdaki bağımlılıkları `pom.xml` dosyasına ekleyin:

```xml
<dependencies>
    <!-- Spring Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Security -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

    <!-- JWT -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-api</artifactId>
        <version>0.11.5</version>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-impl</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-jackson</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>

    <!-- H2 Database -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Spring Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
</dependencies>
```

---

### Adım 2: `application.yml` Dosyası
Uygulama yapılandırmasını düzenleyin:

```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driver-class-name: org.h2.Driver
    username: sa
    password:
  h2:
    console:
      enabled: true
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

---

### Adım 3: Kullanıcı Modeli
Bir kullanıcı modeli ve repository oluşturun.

#### `UserEntity.java`
```java
package com.example.jwt.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; // "USER", "ADMIN" gibi roller
}
```

#### `UserRepository.java`
```java
package com.example.jwt.repository;

import com.example.jwt.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
```

---

### Adım 4: JWT Token Üretimi ve Doğrulama
JWT işlemleri için bir yardımcı sınıf oluşturun.

#### `JwtUtils.java`
```java
package com.example.jwt.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private final String jwtSecret = "secretKey123456789";
    private final long jwtExpirationMs = 86400000; // 1 gün

    public String generateJwtToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (JwtException e) {
            System.err.println("JWT Hatası: " + e.getMessage());
        }
        return false;
    }
}
```

---

### Adım 5: Kullanıcı Detayları ve Security Yapılandırması
Spring Security yapılandırmasını yapın.

#### `CustomUserDetailsService.java`
```java
package com.example.jwt.security;

import com.example.jwt.model.UserEntity;
import com.example.jwt.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Kullanıcı bulunamadı: " + username));

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}
```

#### `SecurityConfig.java`
```java
package com.example.jwt.config;

import com.example.jwt.security.CustomUserDetailsService;
import com.example.jwt.security.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final JwtUtils jwtUtils;

    public SecurityConfig(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
```

---

### Adım 6: Kimlik Doğrulama ve Token Endpoint'leri
Kimlik doğrulama işlemleri için bir controller oluşturun.

#### `AuthController.java`
```java
package com.example.jwt.controller;

import com.example.jwt.model.UserEntity;
import com.example.jwt.repository.UserRepository;
import com.example.jwt.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        return jwtUtils.generateJwtToken(authentication.getName());
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest registerRequest) {
        UserEntity user = new UserEntity();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole("USER");
        userRepository.save(user);

        return "Kayıt başarılı!";
    }
}

class LoginRequest {
    private String username;
    private String password;

    // Getter ve Setter
}

class RegisterRequest {
    private String username;
    private String password;

    // Getter ve Setter
}
```

---

### Adım 7: Test
1. Uygulamayı çalıştırın.
2. `/api/auth/register` ile yeni bir kullanıcı kaydedin.
3. `/api/auth/login` ile giriş yapın ve JWT token alın.
4. Token'ı korumalı endpoint'lere erişimde kullanın.

---

Bu örnek hem güvenli hem de genişletilebilir bir JWT altyapısı sağlar.
---

## Spring Security Basic Auth İle JWT Token 
### **Spring Security Basic Auth ve JWT Token: Avantajlar ve Dezavantajlar**

Spring Security, kullanıcı doğrulama ve yetkilendirme işlemlerini yönetmek için farklı yöntemler sunar. **Basic Authentication** ve **JWT (JSON Web Token)**, bu yöntemlerden ikisidir. Her ikisinin de kendine özgü avantajları ve dezavantajları vardır. Bu karşılaştırma, bu iki yöntemin özelliklerini anlamanıza ve projeniz için doğru seçimi yapmanıza yardımcı olacaktır.

---

### **1. Spring Security Basic Authentication**

**Basic Authentication**, istemci ile sunucu arasındaki her HTTP isteğinde kullanıcı adı ve şifrenin gönderildiği basit bir kimlik doğrulama yöntemidir. Spring Security ile kolayca entegre edilebilir.

#### **Avantajları**

1. **Kolay Uygulama:**
    - Spring Security ile **minimal yapılandırma** gerektirir.
    - REST API'ler için hızlı bir şekilde entegre edilebilir.

2. **Standart Bir Protokol:**
    - HTTP'nin yerleşik bir özelliği olduğu için tarayıcılar ve araçlarla uyumludur (ör. Postman, cURL).

3. **Sunucu Tarafında Yönetim:**
    - Kullanıcı kimlik bilgileri sunucu tarafında doğrulanır. Bu, sunucu kontrolünü artırır.

4. **Kimlik Bilgilerinin Doğrudan Kullanımı:**
    - Ekstra bir oturum veya token mekanizmasına ihtiyaç duymaz.

---

#### **Dezavantajları**

1. **Her İstekle Kimlik Bilgilerinin Gönderilmesi:**
    - Kullanıcı adı ve şifre her HTTP isteğiyle birlikte gönderilir. Bu, güvenlik açısından büyük bir risktir.
    - HTTPS kullanılmazsa, bu bilgiler kolayca ele geçirilebilir.

2. **Zayıf Güvenlik:**
    - Kimlik bilgileri yalnızca Base64 ile kodlanır. Bu bir **şifreleme** değil, yalnızca bir kodlama yöntemidir.
    - Orta düzeyli güvenlik tehditlerine karşı savunmasızdır (ör. man-in-the-middle saldırıları).

3. **Kimlik Bilgilerinin Saklanması:**
    - İstemcinin her istekte aynı kimlik bilgilerini göndermesi gerektiği için kullanıcı adı ve şifre genellikle istemci tarafında saklanır. Bu durum, istemcinin güvenliği ile ilgili riskleri artırır.

4. **Oturum Yönetimi Yok:**
    - Oturum tabanlı bir mekanizma olmadığı için kullanıcı durumunu yönetmek zordur.

5. **Kapsamlı Yetkilendirme Zor:**
    - Kullanıcı rollerini ve izinlerini taşımak zor olduğundan karmaşık yetkilendirme ihtiyaçları için uygun değildir.

---

### **2. JWT (JSON Web Token)**

**JWT**, kullanıcı kimlik bilgilerini ve yetkilendirme verilerini JSON formatında taşıyan, imzalanmış ve güvenli bir şekilde iletilen bir token yapısıdır. Modern uygulamalarda yaygın olarak kullanılır.

#### **Avantajları**

1. **Stateless Yapı:**
    - JWT tamamen **stateless** (durumsuz) bir yapıya sahiptir. Sunucu, istemcinin durumunu saklamak zorunda kalmaz.
    - Ölçeklenebilirlik açısından büyük bir avantaj sağlar.

2. **Taşınabilirlik:**
    - JWT, kullanıcı bilgilerini ve yetkilendirme verilerini içerir. Bu bilgiler, oturum durumundan bağımsız olarak farklı mikroservisler arasında kolayca taşınabilir.

3. **Sunucu Yükünü Azaltır:**
    - Sunucu tarafında oturum bilgisi saklanmadığı için yük azalmış olur. Bu, büyük ölçekli uygulamalarda performansı artırır.

4. **Modern Güvenlik Prensipleriyle Uyumlu:**
    - JWT, HMAC veya RSA gibi güçlü algoritmalarla imzalanır.
    - İmzalanmış bir token olduğundan, istemci tarafında değiştirilse bile sunucu bu değişikliği tespit edebilir.

5. **Yetkilendirme Verilerinin Taşınması:**
    - JWT içinde kullanıcı rolleri, izinler gibi yetkilendirme bilgileri taşınabilir.
    - Mikroservis tabanlı yapılarda her servis, token içindeki bilgileri doğrulama yeteneğine sahiptir.

6. **Birden Fazla Platformla Uyumlu:**
    - Mobil uygulamalar, SPA (Single Page Applications) ve web uygulamaları için uygundur.

---

#### **Dezavantajları**

1. **Token Yönetimi:**
    - JWT'nin süre dolumu (`expiration`) olduğunda, istemci tarafında token yenileme mekanizması oluşturulmalıdır.
    - Bu işlem ek kod ve altyapı gerektirir (ör. Refresh Token kullanımı).

2. **Token Boyutu:**
    - JWT'nin içeriği daha fazla veri içerdiği için HTTP başlık boyutunu artırabilir. Bu, bant genişliği üzerinde etkili olabilir.

3. **Geri Çağırma Zorluğu:**
    - JWT, durumsuz bir yapıda olduğu için sunucu bir token'ı iptal edemez. Bir token süresi dolana kadar geçerli kalır.
    - Bunun üstesinden gelmek için bir kara liste (blacklist) mekanizması oluşturulmalıdır.

4. **Token Çalınması Durumu:**
    - Bir JWT çalındığında, süresi dolana kadar yetkisiz erişim sağlanabilir.
    - Bunun önüne geçmek için HTTPS ve `aud`/`iss` kontrolleri gibi güvenlik önlemleri alınmalıdır.

5. **Yetkilendirme Karmaşıklığı:**
    - Eğer JWT içeriği fazla veri taşırsa (örneğin, büyük miktarda izin bilgisi), bu durum performansı etkileyebilir.

---

### **Basic Authentication ve JWT Token Karşılaştırması**

| **Özellik**                 | **Basic Authentication**                                          | **JWT Token**                                                  |
|-----------------------------|------------------------------------------------------------------|----------------------------------------------------------------|
| **Stateless/Durumsuz**       | Stateless, ancak her istekte kullanıcı adı ve şifre gönderilir. | Tamamen Stateless; kullanıcı durumu taşınmaz.                 |
| **Uygulama Kolaylığı**       | Basit ve hızlı bir şekilde uygulanabilir.                       | Biraz daha fazla yapılandırma ve kodlama gerektirir.          |
| **Güvenlik Seviyesi**        | Düşük; HTTPS olmadan kolayca kırılabilir.                      | Yüksek; token imzalanır ve şifrelenebilir.                    |
| **Performans**               | Her istekte kimlik bilgileri kontrol edilir, bu yük getirir.    | Tek bir doğrulama ile token doğrulanır, daha hızlıdır.        |
| **Ölçeklenebilirlik**        | Sınırlı; sunucu durumunu tutabilir.                            | Yüksek; tamamen durumsuz yapı.                                |
| **Veri Taşınabilirliği**      | Kimlik bilgileri taşır, ancak başka veri taşımaz.               | Rolleri, izinleri ve ek bilgileri taşıyabilir.                |
| **Token Sürekliliği**         | Yok; her istekte yeniden doğrulama yapılır.                   | Süresi dolana kadar geçerlidir; yenileme mekanizması gerekebilir. |
| **Geri Çağırma**             | Her zaman iptal edilebilir (şifre değişikliğiyle).             | Token iptal mekanizması eklenmelidir (ör. kara liste).        |
| **HTTPS Zorunluluğu**        | Kesinlikle gerekli.                                             | HTTPS önerilir, ancak token imzalama güvenliği artırır.       |

---

### **Kullanım Alanları**

1. **Basic Authentication:**
    - Küçük ölçekli uygulamalar veya dahili sistemler.
    - Hızlı prototipleme süreçleri.
    - Kullanıcı oturumu yönetimi gerektirmeyen senaryolar.

2. **JWT Token:**
    - Mikroservis tabanlı sistemler.
    - Mobil ve web uygulamalarında durum bilgisi taşımadan kimlik doğrulama.
    - Dağıtık sistemlerde kimlik doğrulama ve yetkilendirme.

---

### **Sonuç**

- **Basic Authentication**, basitliği nedeniyle küçük projelerde veya hızlı çözümler için uygundur. Ancak, güvenlik açıkları nedeniyle yalnızca HTTPS ile kullanılması önerilir.
- **JWT**, modern, güvenli ve ölçeklenebilir bir çözüm sunar. Mikroservis mimarileri ve büyük ölçekli projeler için tercih edilmelidir.

JWT, daha karmaşık bir yapı sunmasına rağmen uzun vadede modern uygulama ihtiyaçlarını karşılamak için daha uygundur. Basic Authentication ise kısa vadeli ve basit gereksinimler için yeterlidir. Doğru seçimi yapmak, projenizin gereksinimlerine bağlıdır.