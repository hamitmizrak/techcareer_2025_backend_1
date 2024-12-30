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

---
## .httpBasic(Customizer.withDefaults())  ile .httpBasic() bu iki kod arasındaki farklar nelerdir ?
`.httpBasic(Customizer.withDefaults())` ile `.httpBasic()` arasındaki fark, kodun yazım tarzı ve kullanılan Spring Security sürümüne göre ortaya çıkar. Ancak işlevsellik açısından, ikisi de HTTP Basic Authentication özelliğini etkinleştirir. Detaylı açıklama aşağıdaki gibidir:

---

### 1. `.httpBasic(Customizer.withDefaults())`
- **Kullanımı**:
  ```java
  httpBasic(Customizer.withDefaults())
  ```
- **Anlamı**: Bu kod, HTTP Basic Authentication özelliğini etkinleştirir ve varsayılan yapılandırmaları kullanır.
- **Ne Zaman Kullanılır?**:
    - Spring Security 5.2 veya daha sonraki sürümlerinde önerilen bir yöntemdir.
    - Daha okunabilir ve modern bir yazım tarzı sağlar.
    - `Customizer` arabirimi, bir yapılandırma nesnesinin özelleştirilmesini sağlar, ancak burada `withDefaults()` çağrılarak varsayılan yapılandırma kullanılır.
- **Avantajı**:
    - Kodun modern bir şekilde yazılmasını sağlar.
    - Diğer Customizer arabirimleriyle uyumlu hale getirir.

---

### 2. `.httpBasic()`
- **Kullanımı**:
  ```java
  httpBasic()
  ```
- **Anlamı**: Bu kod da HTTP Basic Authentication özelliğini etkinleştirir ve varsayılan yapılandırmaları kullanır.
- **Ne Zaman Kullanılır?**:
    - Spring Security'nin eski sürümlerinde (Spring Security 5.2'den önce) kullanılır.
    - Basit ve kısa bir yazım tarzıdır.
- **Avantajı**:
    - Daha eski projelerde yaygın olarak bulunur ve geriye dönük uyumluluğu korur.

---

### Farklılıklar
| **Özellik**                          | **.httpBasic(Customizer.withDefaults())**             | **.httpBasic()**                  |
|--------------------------------------|------------------------------------------------------|-----------------------------------|
| **Yazım Tarzı**                      | Modern, Customizer API'sini kullanır.               | Daha basit ve eski yazım tarzı.  |
| **Spring Security Versiyonu**         | Spring Security 5.2+ önerir.                        | Eski Spring Security sürümleriyle uyumlu. |
| **Esneklik (Gelecek Uyumluluğu)**    | Customizer ile genişletilebilir.                    | Genişletilebilirlik sınırlı.     |
| **Varsayılan Davranış**               | Varsayılan HTTP Basic yapılandırmasını sağlar.       | Aynı varsayılan yapılandırmayı sağlar. |

---

### Hangi Durumda Hangisi Tercih Edilmeli?
- **Yeni Projelerde**:
    - `.httpBasic(Customizer.withDefaults())` tercih edilmelidir çünkü daha modern ve genişletilebilir bir yazım tarzıdır.
- **Mevcut Projelerde**:
    - Eğer eski bir Spring Security sürümü kullanılıyorsa `.httpBasic()` kullanmaya devam edilebilir.
- **Gelecekteki Değişikliklere Hazırlık**:
    - `.httpBasic(Customizer.withDefaults())` daha fazla özelleştirme olanağı sunduğu için önerilir.

---

Özetle, iki yöntem işlevsel olarak aynı HTTP Basic Authentication özelliğini etkinleştirir, ancak `.httpBasic(Customizer.withDefaults())` daha modern ve genişletilebilir bir yazım tarzıdır. Yeni projelerde bu yaklaşımı tercih etmek gelecekteki bakım ve genişletilebilirlik açısından avantaj sağlar.