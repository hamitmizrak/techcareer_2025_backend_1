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

### Spring Security ile Kimlik Doğrulama (Authentication)

Kimlik doğrulama, kullanıcının geçerli bir kullanıcı adı ve şifre ile sisteme giriş yapması işlemidir. Spring Security’de kimlik doğrulama işlemi `AuthenticationManager` aracılığıyla gerçekleştirilir. `UsernamePasswordAuthenticationToken` sınıfı, en yaygın kimlik doğrulama yöntemi olan kullanıcı adı ve şifreyle doğrulama yapar. `AuthenticationProvider` ise bu doğrulama sürecinin gerçek kaynağıdır; yani kullanıcı bilgilerini doğrulamak için veri tabanında arama yapar.

#### Örnek Kimlik Doğrulama Yapılandırması

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user")
            .password(passwordEncoder().encode("password"))
            .roles("USER")
            .and()
            .withUser("admin")
            .password(passwordEncoder().encode("admin"))
            .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
            .and()
            .formLogin();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

Bu yapılandırmada, `inMemoryAuthentication` ile kullanıcı bilgileri bellekte saklanır. `/admin/**` yoluna sadece "ADMIN" rolüne sahip kullanıcılar erişebilirken, `/user/**` yoluna "USER" veya "ADMIN" rolüne sahip kullanıcılar erişebilir.

### Yetkilendirme (Authorization)

Spring Security, kullanıcıların belirli kaynaklara erişimini kısıtlayarak yetkilendirme işlemlerini yönetir. Kullanıcılar roller (roles) ve yetkiler (authorities) aracılığıyla sınıflandırılır. Bu roller ve yetkiler, belirli URL’lere veya metodlara erişim kontrolü sağlamak için kullanılır.

#### Rol Tabanlı Yetkilendirme

Rol tabanlı yetkilendirme, kullanıcının rolüne göre kaynaklara erişim hakkı vermeyi sağlar. `@Secured` ve `@PreAuthorize` anotasyonları, rol tabanlı erişim kontrolünü gerçekleştirmede kullanılır.

```java
@Secured("ROLE_ADMIN")
public void adminOnlyMethod() {
    // Yalnızca ROLE_ADMIN rolüne sahip kullanıcılar bu metodu çağırabilir
}

@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
public void userOrAdminMethod() {
    // ROLE_USER veya ROLE_ADMIN rolüne sahip kullanıcılar bu metodu çağırabilir
}
```

### Spring Security ile HTTP Güvenliği

Spring Security, HTTP tabanlı güvenlik tehditlerine karşı koruma sağlar. Aşağıda, Spring Security’nin HTTP güvenliği kapsamında sağladığı başlıca koruma mekanizmaları yer almaktadır:

1. **CSRF (Cross-Site Request Forgery)**: CSRF saldırılarına karşı koruma sağlar. CSRF, saldırganın kullanıcının oturumunu ele geçirerek kullanıcı adına istek yapmasını sağlayan bir saldırı türüdür. Spring Security, CSRF korumasını varsayılan olarak aktifleştirir.

2. **Clickjacking Koruması**: Spring Security, uygulamanın başka siteler tarafından çerçevelenmesini önlemek için X-Frame-Options başlığını kullanarak clickjacking saldırılarına karşı koruma sağlar.

3. **XSS Koruması**: XSS (Cross-Site Scripting) saldırılarına karşı korunmak için içerik güvenlik politikaları (Content Security Policies) uygulanabilir.

4. **HTTP Strict Transport Security (HSTS)**: HSTS, yalnızca HTTPS bağlantılarını zorunlu kılarak veri aktarım güvenliğini artırır.

### JWT ile Kimlik Doğrulama ve Yetkilendirme

JWT, kullanıcı kimliğini doğrulamak ve API güvenliğini sağlamak için popüler bir yöntemdir. JWT kullanıldığında, kullanıcı giriş yaptığında bir token üretilir ve bu token, sonraki isteklerde kimlik doğrulaması için kullanılır. Spring Security, JWT token ile kimlik doğrulama işlemlerini kolayca yapılandırma imkanı sunar.

#### JWT Kimlik Doğrulama Örneği

JWT kullanarak kimlik doğrulama yapılacak bir örnek yapılandırma şu şekildedir:

1. **JWT Oluşturma**: Kullanıcı giriş yaptığında, JWT token oluşturulur ve istemciye döndürülür.
2. **JWT Doğrulama**: İstemciden gelen her istekte, JWT doğrulanarak kullanıcının kimliği belirlenir.

```java
// JWT oluşturma ve doğrulama işlemleri için kullanılan sınıf
public class JwtUtil {

    private String secretKey = "mySecretKey";

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
```

### OAuth2 ve Spring Security

Spring Security, OAuth2 protokolünü destekleyerek üçüncü taraf kimlik doğrulama servisleriyle (Google, Facebook gibi) entegre çalışabilir. OAuth

2, özellikle kullanıcıların aynı hesapla farklı uygulamalarda oturum açmasını sağlar ve API güvenliği için de yaygın olarak kullanılır.

### Spring Security ile Test ve Hata Yönetimi

Spring Security, güvenlik testlerini kolaylaştırmak için `@WithMockUser`, `@WithUserDetails` gibi test anotasyonları sağlar. Bu anotasyonlar ile belirli roller ve yetkiler atanarak güvenlik testleri yapılabilir.

```java
@Test
@WithMockUser(username = "admin", roles = {"ADMIN"})
public void testAdminAccess() {
    // ADMIN rolüyle test işlemleri yapılır
}
```

### Spring Security’nin Avantajları ve Dezavantajları

**Avantajları**:

- **Yüksek Güvenlik Desteği**: Kimlik doğrulama, yetkilendirme ve HTTP güvenliği sağlar.
- **Esneklik**: LDAP, OAuth2, JWT gibi çeşitli kimlik doğrulama protokolleri ile entegre çalışabilir.
- **Kolay Konfigürasyon**: XML veya Java tabanlı konfigürasyon seçenekleri sunar.
- **Modüler Yapı**: Farklı güvenlik bileşenlerinin ihtiyaca göre eklenmesini sağlar.

**Dezavantajları**:

- **Öğrenme Eğrisi**: İlk kez kullananlar için oldukça karmaşık olabilir.
- **Performans Maliyeti**: Güvenlik işlemleri ek yük getirebilir, özellikle büyük ölçekli uygulamalarda optimize edilmesi gerekebilir.

### Sonuç

Spring Security, uygulamalarda güçlü bir güvenlik altyapısı sunarak veri gizliliğini ve güvenliğini sağlar. Kimlik doğrulama, yetkilendirme ve HTTP güvenliği özellikleriyle geniş kapsamlı güvenlik ihtiyaçlarını karşılar. Modern güvenlik standartlarını destekleyen Spring Security, web uygulamaları ve API’lerde güvenlik sağlamak isteyen geliştiriciler için ideal bir çözümdür.

Daha ayrıntılı örnekler veya belirli bir konuyla ilgili daha fazla bilgiye ihtiyacınız varsa, size yardımcı olmaktan memnuniyet duyarım.

---
## CSRF Project
### CSRF (Cross-Site Request Forgery) Nedir?

**CSRF (Cross-Site Request Forgery)**, bir saldırganın, bir kullanıcının kimliğine bürünerek onun adına yetkili işlemler gerçekleştirmesini sağlayan bir web güvenlik zafiyetidir. Bu saldırı türünde, saldırgan, kullanıcının tarayıcısı üzerinden kötü niyetli istekler gönderir ve hedef sistem bu isteğin kullanıcının isteği olduğunu düşünür. Kullanıcı oturum açmış durumdaysa ve yetkilendirilmiş bir işlem yapılabiliyorsa, saldırgan bu yetkileri kötüye kullanabilir.

---

### CSRF Nasıl Çalışır?

1. **Hedef Kullanıcı Oturum Açmış Durumda Olur:** Kullanıcı, bir web sitesine (örneğin bankasının web uygulamasına) oturum açar ve kimliği doğrulanmış bir oturum başlatır.

2. **Kötü Amaçlı Bir Bağlantı veya Sayfa:** Saldırgan, kullanıcının ziyaret etmesini sağladığı kötü amaçlı bir web sayfası veya bağlantı hazırlar. Bu sayfada, hedef web sitesine istek gönderen bir form veya betik bulunur.

3. **Kötü Niyetli İstek Gönderilir:** Kullanıcı kötü amaçlı bağlantıya tıklayınca ya da sayfayı ziyaret edince, tarayıcıdaki mevcut oturum bilgisi (örneğin çerezler) kullanılarak hedef siteye bir istek gönderilir.

4. **Hedef Web Uygulaması İsteği Kabul Eder:** Hedef web uygulaması, bu isteği doğrulamazsa, kullanıcının yetkisi dahilinde işlemi gerçekleştirir.

---

### CSRF Örnek Senaryo

- Kullanıcı bankasının web sitesinde oturum açmıştır.
- Saldırgan, kötü amaçlı bir e-posta veya web sitesi aracılığıyla kullanıcının bir bağlantıya tıklamasını sağlar.
- Bağlantı, kullanıcının adına para transferi yapan bir POST isteği içerir:

```html
<form action="https://bankasitesi.com/paraTransferi" method="POST">
    <input type="hidden" name="hesapNo" value="123456789">
    <input type="hidden" name="miktar" value="1000">
    <button type="submit">Hemen Tıklayın</button>
</form>
```

Kullanıcı bu formu farkında olmadan çalıştırırsa, tarayıcı oturum çerezlerini kullanarak işlemi onaylar ve saldırgan istediğini gerçekleştirir.

---

### CSRF Saldırılarından Korunma Yöntemleri

#### 1. **CSRF Token Kullanımı**
- Sunucu, her form isteğiyle birlikte bir **CSRF token** gönderir. Bu token, oturum başına benzersizdir ve sadece geçerli oturum için kullanılır.
- Sunucu, gelen istekte token'ı kontrol ederek isteğin doğruluğunu onaylar.

Örnek CSRF token:
```html
<input type="hidden" name="_csrf" value="a1b2c3d4e5f6">
```

#### 2. **Referer Başlığını Kontrol Etmek**
- İsteklerin geldiği referer (kaynak URL) başlığı kontrol edilerek isteklerin geçerli bir kaynaktan gelip gelmediği doğrulanabilir.
- Ancak bu yöntem, bazı tarayıcılar veya güvenlik duvarları nedeniyle güvenilir olmayabilir.

#### 3. **Cookie SameSite Özelliği**
- **SameSite** özelliği, çerezlerin sadece aynı site üzerinden yapılan isteklere gönderilmesini sağlar.
- Örneğin:
  ```http
  Set-Cookie: sessionId=abc123; SameSite=Strict;
  ```

#### 4. **Kullanıcı Doğrulama Gerekliliği**
- Hassas işlemler için ekstra kullanıcı doğrulama adımları (örneğin 2FA veya parola doğrulama) eklenebilir.

#### 5. **HTTP Yöntemleri ve CORS Kontrolü**
- Hassas işlemler sadece **POST**, **PUT**, **DELETE** gibi güvenli HTTP yöntemleri ile sınırlandırılmalıdır.
- **CORS (Cross-Origin Resource Sharing)** ile sadece izin verilen kaynaklardan gelen isteklere izin verilebilir.

---

### Spring Framework ile CSRF Koruması

Spring Security, CSRF saldırılarına karşı varsayılan olarak bir koruma mekanizması sağlar. CSRF korumasını etkinleştirmek veya yapılandırmak için aşağıdaki adımlar uygulanabilir.

#### Spring Security'de CSRF Korumasını Etkinleştirme
Spring Security, CSRF korumasını otomatik olarak etkinleştirir. Ancak yapılandırmasını özelleştirebilirsiniz.

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            .and()
            .authorizeRequests()
            .antMatchers("/public/**").permitAll()
            .anyRequest().authenticated();
    }
}
```

#### CSRF Token Kullanımı
Spring Security, otomatik olarak her form veya AJAX isteğinde kullanmanız için bir CSRF token sağlar. Token'ı bir form içinde kullanmak için:
```html
<input type="hidden" name="_csrf" value="${_csrf.token}">
```

---

### Avantajları ve Dezavantajları

| **Avantaj**                               | **Dezavantaj**                             |
|-------------------------------------------|-------------------------------------------|
| Güvenlik seviyesi artırılır.               | Ekstra yapılandırma ve kod gerektirir.    |
| Web uygulamasında kötü niyetli işlemler engellenir. | Bazı uygulamalarda token yönetimi karmaşık olabilir. |

---

### Sonuç

CSRF, modern web uygulamalarında dikkat edilmesi gereken kritik bir güvenlik açığıdır. Uygulamanın CSRF saldırılarına karşı güvenli hale getirilmesi, kullanıcıların yetkilerini kötüye kullanarak yapılan işlemleri engeller. Güçlü bir CSRF koruma stratejisi, hem kullanıcı verilerini hem de uygulama bütünlüğünü korumak için gereklidir.

---
## spring security en son sürümü nedir ?
Spring Security'nin en son sürümü 6.4.2'dir. Bu sürüm, 20 Aralık 2024 tarihinde yayımlanmıştır.

Spring Security, Java tabanlı uygulamalarda kimlik doğrulama, yetkilendirme ve yaygın saldırılara karşı koruma sağlayan bir çerçevedir. Hem geleneksel hem de reaktif uygulamaları güvence altına almak için birinci sınıf destek sunar ve Spring tabanlı uygulamalar için fiili standart olarak kabul edilir.

Spring Security'nin 6.4 sürümü, One-Time Token Login ve Passkeys desteği gibi yeni özellikler sunmaktadır. Ayrıca, Method Security ve OAuth 2.0 alanlarında da iyileştirmeler yapılmıştır.

Spring Security'nin sürüm numaraları MAJOR.MINOR.PATCH formatındadır:

- **MAJOR** sürümler, önemli değişiklikler içerebilir ve genellikle modern güvenlik uygulamalarına uyum sağlamak için yapılır.

- **MINOR** sürümler, iyileştirmeler içerir ancak geriye dönük uyumluluğu korur.

- **PATCH** sürümleri, hata düzeltmeleri ve küçük iyileştirmeler içerir.

Spring Security'nin sürümleri Maven Central üzerinden erişilebilir. Spring Boot kullanıyorsanız, `spring-boot-starter-security` başlangıç bağımlılığını ekleyerek Spring Security'yi projenize dahil edebilirsiniz. Spring Boot, bağımlılık sürümlerini yönetmek için bir Maven BOM (Bill of Materials) sağladığından, sürüm belirtmenize gerek yoktur. Ancak, belirli bir Spring Security sürümünü kullanmak isterseniz, Maven özellikleri aracılığıyla bunu belirtebilirsiniz.

Spring Security'nin en son sürümüne geçiş yaparak, uygulamalarınızın güvenliğini artırabilir ve yeni özelliklerden faydalanabilirsiniz. 