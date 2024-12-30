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
## PostContructor
`@PostConstruct` anotasyonu, Java'da bir sınıfın yapılandırılması tamamlandıktan hemen sonra çalıştırılması gereken bir metodu işaretlemek için kullanılır.
Bu anotasyon, Spring tarafından yönetilen bean'lerde özellikle faydalıdır. `@PostConstruct` anotasyonu, **bağımlılıkların injection** (yerleştirilmesi) işlemi tamamlandıktan sonra,
sınıfın başlatma aşamasında belirli bir işlemi gerçekleştirmek için kullanılır.

### Ne Zaman ve Nasıl Kullanılır?
`@PostConstruct` anotasyonu, bir sınıfın veya bileşenin bağımlılıkları (dependencies) Spring tarafından atandıktan sonra otomatik olarak çalışan bir metodu belirtir.
Örneğin, veri hazırlığı, bağlantı oluşturma, bir değişkenin başlatılması gibi işlemler burada yapılabilir.
Bu metod, sınıfın constructor'ından **sonra**, ancak herhangi bir metodun çağrılmasından **önce** çalışır.

### Örnek Kodu Açıklaması:
```java
private ApiResult apiResult;
@PostConstruct
public void springData() {
    apiResult = new ApiResult();
}
```

#### 1. **`@PostConstruct` Anotasyonu:**
- **Ne yapar?** Bu metodun, sınıfın tüm bağımlılıkları atandıktan sonra çalıştırılmasını sağlar.
- Yani, `springData()` metodu, sınıfın diğer bileşenleri veya bağımlılıkları (örneğin, `apiResult` gibi) Spring tarafından hazır hale getirildikten sonra çalıştırılır.
- **Neden kullanılır?** Eğer belirli bir nesne veya değişken (örneğin `apiResult`) sınıf başlatıldığında otomatik olarak başlatılmak isteniyorsa,
- bu anotasyon kullanılır. Böylece her seferinde constructor’da veya manuel olarak başlatmak zorunda kalmazsınız.

#### 2. **`apiResult = new ApiResult();`**
- **Ne yapar?** `springData()` metodu çalıştığında, `apiResult` nesnesi yeni bir `ApiResult` örneği olarak başlatılır.
- Bu sayede sınıfın diğer metotları bu `apiResult` örneğini kullanabilir.
- **Bağlam:** `apiResult` burada bir sınıf değişkeni (instance variable) olarak tanımlanmıştır.
- Eğer bu değişkenin başlatılması gerekiyorsa, `@PostConstruct` anotasyonu ile bağımlılıkların atandıktan hemen sonra bu işlemi gerçekleştirebilirsiniz.

### Özet:
- **`@PostConstruct`**, Spring tarafından yönetilen bir sınıfın yaşam döngüsünde constructor'dan sonra,
- ancak diğer metodların çağrılmasından önce çalıştırılacak bir metodu belirtir.
- Bu anotasyon ile sınıfın ilk kurulum aşamasında gerekli hazırlıkları yapmak için kullanılabilir,
- örneğin: veri başlatma, bağlantı kurma ya da değişkenlere ilk değer atama gibi işlemler.




### Interceptor Nedir?
Bir **Interceptor**, uygulamaya gelen veya giden HTTP isteklerinin öncesinde ya da sonrasında çalışır. Herhangi bir işlemi tamamlamadan önce belirli kontroller yapabilir veya isteğe ek bilgiler ekleyebilir.

### Metodun Detaylı Açıklaması

```java
@Override
public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new CustomInterceptor())  // CustomInterceptor sınıfı ile Interceptor eklenir
            .addPathPatterns("/api/**")  // Hangi URL deseninde geçerli olacağı
            .excludePathPatterns("/api/login", "/api/register");  // Hariç tutulacak URL desenleri
}
```

### Adım Adım Açıklama:

#### 1. **`addInterceptor(new CustomInterceptor())`**:
Bu kısım, `CustomInterceptor` adlı sınıfı kullanarak bir Interceptor ekler. `CustomInterceptor`, bizim tanımladığımız bir sınıf olup `HandlerInterceptor` arayüzünü ya da `HandlerInterceptorAdapter` sınıfını genişletir.

   ```java
   public class CustomInterceptor implements HandlerInterceptor {

       @Override
       public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
           // İstek işlenmeden önce çalışır
           return true;  // Eğer false dönerse istek devam etmez
       }

       @Override
       public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
           // İstek işlendikten sonra ama cevap istemciye gitmeden önce çalışır
       }

       @Override
       public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
           // İstek tamamlandıktan sonra çalışır, genellikle temizleme işlemleri için kullanılır
       }
   }
   ```

- **`preHandle`**: İstek sunucuya ulaşmadan önce çalışır. Burada, kimlik doğrulama, loglama, izin kontrolü gibi işlemler yapılabilir. Eğer `false` dönerse istek işlenmez ve burada durdurulur.
- **`postHandle`**: İstek başarıyla işlendiğinde ama yanıt henüz istemciye gitmeden önce çalışır. Bu aşamada, model veya view ile ek işlemler yapılabilir.
- **`afterCompletion`**: İstek tamamen tamamlandığında çalışır. Bu aşamada genellikle temizleme, loglama gibi işlemler yapılır.

#### 2. **`addPathPatterns("/api/**")`**:
Bu kısımda, Interceptor'ın hangi URL'lerde aktif olacağını belirleriz. Örneğin, `"/api/**"` deseni, `/api/` ile başlayan tüm URL'lere uygulanır. Bu, `/api/v1/products`, `/api/orders`, `/api/customers` gibi URL'ler olabilir.

Yani, `/api/**` ile eşleşen her istek Interceptor tarafından işlenecektir.

#### 3. **`excludePathPatterns("/api/login", "/api/register")`**:
Bu kısım, belirli URL'leri Interceptor'dan hariç tutmak için kullanılır. Yani, `/api/login` ve `/api/register` URL'leri Interceptor tarafından işlenmeyecektir.

Örneğin, kimlik doğrulama ve kayıt gibi işlemler genellikle tüm kullanıcılara açık olur, bu yüzden bu URL'ler Interceptor'ın denetiminden hariç tutulabilir. Bu, özellikle oturum açmamış kullanıcıların da bu işlemleri yapabilmesini sağlar.

### Özet:

Bu yapılandırma şunu sağlar:

1. **Interceptor eklenir**: `CustomInterceptor`, uygulamaya bir Interceptor olarak eklenmiştir. Bu Interceptor, gelen HTTP isteklerini işleyebilir veya kontrol edebilir.

2. **Path desenleri belirlenir**: Interceptor, sadece `/api/**` ile başlayan URL'lerde çalışacaktır. Bu da, API'ye yapılan isteklerin tamamında bu Interceptor'ın kullanılacağı anlamına gelir.

3. **Hariç tutulan URL'ler belirlenir**: `/api/login` ve `/api/register` URL'leri, Interceptor'ın dışında bırakılmıştır. Yani, bu iki URL'ye yapılan istekler Interceptor tarafından işlenmeyecek.

### Ne zaman kullanılır?
- **Kimlik doğrulama ve yetkilendirme**: Kullanıcıların yetkilerini denetlemek için her isteğin başında kimlik doğrulama kontrolü yapmak amacıyla kullanılabilir.
- **Loglama**: Tüm isteklerin ve yanıtların loglanması gerekiyorsa Interceptor ile bu işlemler gerçekleştirilir.
- **Performans takibi**: İsteklerin ne kadar sürede tamamlandığını takip etmek için kullanılabilir.
- **İstek değiştirme**: Giden ve gelen istek/yanıt başlıklarına eklemeler yapma gibi işlemler de Interceptor ile yapılabilir.

### Örnek Kullanım Senaryosu:

Diyelim ki bir e-ticaret uygulamanız var ve `/api/**` ile başlayan tüm isteklerde kullanıcı kimliği doğrulaması yapmak istiyorsunuz. Ancak `/api/login` ve `/api/register` yolları herkese açık olmalı. İşte bu durumda, `addInterceptors` metoduyla bir Interceptor ekleyip bu yollar hariç diğer tüm API isteklerine kimlik doğrulama kontrolü ekleyebilirsiniz.

```java
public class CustomInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null || !isValidToken(token)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;  // İstek işlenmez ve hata döner
        }
        return true;  // İstek işlenmeye devam eder
    }

    private boolean isValidToken(String token) {
        // Token doğrulama işlemi
        return token.equals("geçerli-token");
    }
}
```

Bu yapılandırma ile, `/api/**` yollarına gelen istekler için `Authorization` başlığı ile gelen token'lar doğrulanacak, ancak `/api/login` ve `/api/register` gibi yollara gelen istekler bu kontrolün dışında tutulacaktır.


## Configuration
```sh 

```
---

### @Configuration Anotasyonu
`@Configuration` anotasyonu, bu sınıfın bir **Spring yapılandırma sınıfı** olduğunu belirtir. Spring, bu anotasyonla işaretlenmiş sınıfları, başlatma sırasında konfigürasyon bilgilerini içeren sınıflar olarak tanır. Bu sınıfın içinde tanımladığınız metodlar ve yapılandırmalar Spring IOC Container (Bağımlılık Enjeksiyon Yöneticisi) tarafından yönetilir ve uygulamanın başlatılması sırasında yüklenir.

Örneğin, bu sınıf bir CORS yapılandırmasını içeren bir sınıf olduğu için, Spring Boot bu sınıfı otomatik olarak tanıyacak ve CORS ayarlarını uygulamanın tümüne yayacaktır.

### WebMvcConfigurer Arayüzü
`WebMvcConfigurer`, Spring MVC için yapılandırmaları özelleştirmenize olanak tanıyan bir arayüzdür. Bu arayüz, Spring MVC'nin varsayılan yapılandırmasını değiştirmek istediğinizde kullanılır. `WebMvcConfigurer` kullanarak aşağıdaki gibi yapılandırmaları özelleştirebilirsiniz:
- CORS (Cross-Origin Resource Sharing) ayarları
- View Resolver (görünüm çözümleyici) ayarları
- Kaynak (resource) ayarları
- Yol eşlemesi (path mapping) ayarları

Bu arayüzdeki metodları override ederek, Spring MVC'nin işleyişini uygulamaya özgü hale getirebilirsiniz.

### addCorsMappings(CorsRegistry registry) Metodu
Bu metod, CORS yapılandırmasını tanımladığınız yer. Bu metod Spring tarafından çağrılır ve **CORS politikalarını** özelleştirmenize olanak tanır. İçinde **CorsRegistry** nesnesini kullanarak, hangi yolların (URL endpoint'lerinin) hangi alan adlarından gelen isteklere izin vereceğini belirleyebilirsiniz.

#### Detaylı Parametreler:
- **registry.addMapping("/**")**:
  Bu kısım, hangi yolların CORS yapılandırmasına tabi olduğunu tanımlar. Burada `"/**"` kullanarak uygulamanızdaki tüm yolları belirtmiş oluyorsunuz. Yani bu yapılandırma, uygulamanın tüm API endpoint'leri için geçerlidir.

  Eğer sadece belirli bir yol için CORS ayarı yapmak isterseniz, o yolu belirtebilirsiniz. Örneğin, sadece `/api/**` yolları için izin vermek istiyorsanız:

  ```java
  registry.addMapping("/api/**")
  ```

- **allowedOrigins("http://example.com")**:
  Bu kısım, hangi alan adlarından gelen isteklere izin verileceğini tanımlar. Örnekte sadece `http://example.com` alan adından gelen isteklere izin veriyorsunuz. Eğer bu kısmı `*` olarak ayarlarsanız, tüm alan adlarından gelen isteklere izin verilmiş olur:

  ```java
  allowedOrigins("*")
  ```

  Ancak, güvenlik açısından genelde belirli bir alan adı tanımlamak daha güvenlidir.

- **allowedMethods("GET", "POST")**:
  Bu kısım, hangi HTTP yöntemlerine izin verileceğini belirler. Örnekte sadece **GET** ve **POST** yöntemlerine izin verilmektedir. Eğer diğer yöntemlere de (PUT, DELETE vb.) izin vermek isterseniz bunları ekleyebilirsiniz:

  ```java
  allowedMethods("GET", "POST", "PUT", "DELETE")
  ```

  Varsayılan olarak tüm yöntemler (GET, POST, PUT, DELETE vb.) desteklenir, ancak bu metod ile belirli yöntemleri sınırlayabilirsiniz.

- **allowedHeaders("Content-Type")**:
  Bu kısım, hangi başlıkların (headers) CORS istekleri sırasında kabul edileceğini belirler. Örneğin, sadece **Content-Type** başlığına izin vermek için kullanılır. Eğer tüm başlıklara izin vermek isterseniz `*` kullanabilirsiniz:

  ```java
  allowedHeaders("*")
  ```

  İstek sırasında hangi başlıkların geçerli olacağını belirlemek, uygulamanızın güvenliğini arttırmaya yardımcı olabilir.

- **allowCredentials(true)**:
  Bu kısım, **kimlik doğrulama bilgileri** (örneğin, çerezler veya kimlik doğrulama başlıkları gibi) ile yapılacak isteklere izin verilip verilmeyeceğini belirler. Eğer `true` olarak ayarlanmışsa, kimlik doğrulama bilgileri ile gelen istekler kabul edilir. Bu ayarı dikkatli kullanmak gerekir çünkü uygulamanızın güvenlik risklerini artırabilir.

- **maxAge(3600)**:
  Bu kısım, tarayıcının CORS önbellekleme süresini (saniye cinsinden) tanımlar. Burada `3600` olarak ayarlanmış ve bu, CORS ayarlarının tarayıcıda **1 saat** boyunca geçerli olacağı anlamına gelir. Tarayıcı bu süre boyunca aynı kaynak için CORS doğrulamasını tekrar etmez ve bu da performans açısından fayda sağlar.

### Örnek Senaryo:
Bu CORS yapılandırması ile, uygulamanızın tüm yollarına (`/**`) `http://example.com` alan adından gelen GET ve POST isteklerine izin veriyorsunuz. Bu istekler sırasında kimlik doğrulama bilgileri (çerezler vb.) kabul ediliyor ve tarayıcı bu yapılandırmayı 1 saat boyunca önbelleğe alıyor.

### Spring Boot'ta Global CORS Yapılandırması
Bu yapılandırma, Spring Boot uygulamanızın global CORS ayarlarını yapılandırmanızı sağlar. Yani bu sınıf ve metod, tüm denetleyicilere (controller) ve API endpoint'lerine uygulanır. Eğer sadece belirli endpoint'ler için CORS ayarı yapmak isterseniz, `@CrossOrigin` anotasyonunu ilgili denetleyici veya metodun üstüne ekleyebilirsiniz.

### Genel Özeti:
Bu kod parçası, Spring Boot'ta **CORS** yapılandırmasını yönetmek için kullanılan bir sınıf örneğidir. Spring'in `WebMvcConfigurer` arayüzünü uygulayarak, uygulamanızın tüm yollarında CORS politikalarını belirlemenize olanak tanır. Bu sayede, uygulamanızın başka bir alan adından gelen isteklere nasıl yanıt vereceğini kontrol edebilirsiniz.




### Interceptor Nedir?
Bir **Interceptor**, uygulamaya gelen veya giden HTTP isteklerinin öncesinde ya da sonrasında çalışır. Herhangi bir işlemi tamamlamadan önce belirli kontroller yapabilir veya isteğe ek bilgiler ekleyebilir.

### Metodun Detaylı Açıklaması

```java
@Override
public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new CustomInterceptor())  // CustomInterceptor sınıfı ile Interceptor eklenir
            .addPathPatterns("/api/**")  // Hangi URL deseninde geçerli olacağı
            .excludePathPatterns("/api/login", "/api/register");  // Hariç tutulacak URL desenleri
}
```

### Adım Adım Açıklama:

#### 1. **`addInterceptor(new CustomInterceptor())`**:
Bu kısım, `CustomInterceptor` adlı sınıfı kullanarak bir Interceptor ekler. `CustomInterceptor`, bizim tanımladığımız bir sınıf olup `HandlerInterceptor` arayüzünü ya da `HandlerInterceptorAdapter` sınıfını genişletir.

   ```java
   public class CustomInterceptor implements HandlerInterceptor {

       @Override
       public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
           // İstek işlenmeden önce çalışır
           return true;  // Eğer false dönerse istek devam etmez
       }

       @Override
       public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
           // İstek işlendikten sonra ama cevap istemciye gitmeden önce çalışır
       }

       @Override
       public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
           // İstek tamamlandıktan sonra çalışır, genellikle temizleme işlemleri için kullanılır
       }
   }
   ```

- **`preHandle`**: İstek sunucuya ulaşmadan önce çalışır. Burada, kimlik doğrulama, loglama, izin kontrolü gibi işlemler yapılabilir. Eğer `false` dönerse istek işlenmez ve burada durdurulur.
- **`postHandle`**: İstek başarıyla işlendiğinde ama yanıt henüz istemciye gitmeden önce çalışır. Bu aşamada, model veya view ile ek işlemler yapılabilir.
- **`afterCompletion`**: İstek tamamen tamamlandığında çalışır. Bu aşamada genellikle temizleme, loglama gibi işlemler yapılır.

#### 2. **`addPathPatterns("/api/**")`**:
Bu kısımda, Interceptor'ın hangi URL'lerde aktif olacağını belirleriz. Örneğin, `"/api/**"` deseni, `/api/` ile başlayan tüm URL'lere uygulanır. Bu, `/api/v1/products`, `/api/orders`, `/api/customers` gibi URL'ler olabilir.

Yani, `/api/**` ile eşleşen her istek Interceptor tarafından işlenecektir.

#### 3. **`excludePathPatterns("/api/login", "/api/register")`**:
Bu kısım, belirli URL'leri Interceptor'dan hariç tutmak için kullanılır. Yani, `/api/login` ve `/api/register` URL'leri Interceptor tarafından işlenmeyecektir.

Örneğin, kimlik doğrulama ve kayıt gibi işlemler genellikle tüm kullanıcılara açık olur, bu yüzden bu URL'ler Interceptor'ın denetiminden hariç tutulabilir. Bu, özellikle oturum açmamış kullanıcıların da bu işlemleri yapabilmesini sağlar.

### Özet:

Bu yapılandırma şunu sağlar:

1. **Interceptor eklenir**: `CustomInterceptor`, uygulamaya bir Interceptor olarak eklenmiştir. Bu Interceptor, gelen HTTP isteklerini işleyebilir veya kontrol edebilir.

2. **Path desenleri belirlenir**: Interceptor, sadece `/api/**` ile başlayan URL'lerde çalışacaktır. Bu da, API'ye yapılan isteklerin tamamında bu Interceptor'ın kullanılacağı anlamına gelir.

3. **Hariç tutulan URL'ler belirlenir**: `/api/login` ve `/api/register` URL'leri, Interceptor'ın dışında bırakılmıştır. Yani, bu iki URL'ye yapılan istekler Interceptor tarafından işlenmeyecek.

### Ne zaman kullanılır?
- **Kimlik doğrulama ve yetkilendirme**: Kullanıcıların yetkilerini denetlemek için her isteğin başında kimlik doğrulama kontrolü yapmak amacıyla kullanılabilir.
- **Loglama**: Tüm isteklerin ve yanıtların loglanması gerekiyorsa Interceptor ile bu işlemler gerçekleştirilir.
- **Performans takibi**: İsteklerin ne kadar sürede tamamlandığını takip etmek için kullanılabilir.
- **İstek değiştirme**: Giden ve gelen istek/yanıt başlıklarına eklemeler yapma gibi işlemler de Interceptor ile yapılabilir.

### Örnek Kullanım Senaryosu:

Diyelim ki bir e-ticaret uygulamanız var ve `/api/**` ile başlayan tüm isteklerde kullanıcı kimliği doğrulaması yapmak istiyorsunuz. Ancak `/api/login` ve `/api/register` yolları herkese açık olmalı. İşte bu durumda, `addInterceptors` metoduyla bir Interceptor ekleyip bu yollar hariç diğer tüm API isteklerine kimlik doğrulama kontrolü ekleyebilirsiniz.

```java
public class CustomInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null || !isValidToken(token)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;  // İstek işlenmez ve hata döner
        }
        return true;  // İstek işlenmeye devam eder
    }

    private boolean isValidToken(String token) {
        // Token doğrulama işlemi
        return token.equals("geçerli-token");
    }
}
```

Bu yapılandırma ile, `/api/**` yollarına gelen istekler için `Authorization` başlığı ile gelen token'lar doğrulanacak, ancak `/api/login` ve `/api/register` gibi yollara gelen istekler bu kontrolün dışında tutulacaktır.


Spring'de `@PostConstruct` ile constructor (yapıcı metod) arasında temel farklar, uygulama başlatılırken bileşenlerin ne zaman ve nasıl hazırlandığıyla ilgilidir. İşte bu iki yöntem arasındaki farklar:

### 1. @PostConstruct Annotation
- `@PostConstruct`, bir sınıfta `@Bean` olarak tanımlanan bileşenin tüm bağımlılıkları enjekte edildikten hemen sonra çalıştırılan bir metodu belirtir.
- Bu metot, Spring Bean Lifecycle (Spring Bean Yaşam Döngüsü) içerisinde yer alır ve Spring Container, bileşen hazır olduktan sonra `@PostConstruct` ile işaretlenmiş metodu çağırır.
- `@PostConstruct`, genellikle bir bileşenin bağımlılıkları sağlandıktan sonra yapılan başlatma işlemlerini tanımlamak için kullanılır.
- Örneğin, bir bileşen yüklenirken bazı veritabanı kontrolleri veya ön yüklemeler yapılması gerekiyorsa, bu işlemler `@PostConstruct` ile yapılabilir.

### 2. Constructor
- Constructor, bir sınıfın örneği oluşturulduğunda ilk çağrılan yapıdır.
- `new` anahtar kelimesi ile çağrıldığında veya Spring Container tarafından oluşturulduğunda, sınıfın bağımlılıkları enjekte edilmeden önce çağrılır.
- Constructor içinde bileşenler henüz tamamen hazır olmadığından, bağımlılıklara erişmek mümkün olmayabilir.
- Constructor, genellikle nesnenin ilk durumunu ayarlamak veya zorunlu bağımlılıkları inject etmeden önce bazı başlatma işlemleri yapmak için kullanılır.

### Farkları Özetlersek:
| Özellik                 | Constructor                                  | @PostConstruct                               |
|-------------------------|----------------------------------------------|----------------------------------------------|
| Çalışma Zamanı          | Nesne oluşturulduğunda                       | Bağımlılıklar enjekte edildikten sonra       |
| Bağımlılıklara Erişim   | Bağımlılıklar henüz enjekte edilmemiştir     | Tüm bağımlılıklar enjekte edilmiştir         |
| Kullanım Alanı          | Nesneyi başlatmak ve gerekli bağımlılıkları inject etmek | Hazır hale gelen nesne ile başlatma yapmak |
| Kullanım Yeri           | Tüm Java sınıfları                           | Spring Bean’leri                            |

### Örnek:
```java
@Component
public class ExampleService {

    private final DependencyService dependencyService;

    // Constructor injection
    public ExampleService(DependencyService dependencyService) {
        this.dependencyService = dependencyService;
        System.out.println("Constructor çağrıldı.");
    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct çağrıldı. Bağımlılıklar enjekte edilmiş durumda.");
        // dependencyService burada kullanılabilir
    }
}
```

Bu örnekte:
- **Constructor** çağrıldığında bağımlılık enjekte edilmiş olsa da, `@PostConstruct` çağrıldığında tüm bileşenler eksiksiz olarak yüklenmiş durumdadır.

## Spring Boot
```sh 

```
---

Spring'de **instance** oluşturmak ve **injection** (bağımlılık enjeksiyonu) farklı iki yöntemdir ve uygulamanın bağımlılıklarını yönetme şekli açısından önemli farklara sahiptir. Bu farkları inceleyelim:

### 1. Instance Oluşturmak
- Java’da **instance** (örnek) oluşturmak, `new` anahtar kelimesi kullanılarak doğrudan bir nesne oluşturmak anlamına gelir. Örneğin, `MyService myService = new MyService();` ifadesi ile `MyService` sınıfının bir örneği oluşturulur.
- Bu yöntemle oluşturulan nesne **manuel** olarak oluşturulur ve Spring Container tarafından yönetilmez.
- Eğer bir nesne manuel olarak oluşturulursa, Spring'in bağımlılık yönetimi, yaşam döngüsü kontrolleri veya diğer özelliklerinden yararlanılamaz.
- Bu yöntem daha basit projelerde kullanılabilir, ancak bağımlılıkların manuel olarak yönetilmesi gerekir ve kod karmaşık hale gelebilir.

### 2. Injection (Bağımlılık Enjeksiyonu)
- **Injection** (Bağımlılık Enjeksiyonu), Spring’in bağımlılık yönetimini sağlayan bir özelliktir. Spring, nesneleri **otomatik olarak enjekte ederek** bağımlılıkları sağlar.
- Injection işlemi Spring’in kendi yönetiminde olup, Spring Container tarafından otomatik olarak yapılır.
- Spring Container, uygulama çalıştırıldığında belirli kurallara göre bağımlılıkları enjekte eder. Bu, sınıf yapıcıları (constructor injection) veya alanlar (field injection) kullanılarak yapılabilir.
- **Constructor Injection** veya **@Autowired** gibi anotasyonlarla bağımlılıklar enjekte edilir.
- Injection sayesinde bağımlılıkların yönetimi Spring Container tarafından yapılır, bu da uygulamayı daha modüler ve test edilebilir hale getirir.

### Farkları Özetlersek:

| Özellik                    | Instance Oluşturmak (new)                        | Injection (Bağımlılık Enjeksiyonu)                |
|----------------------------|-------------------------------------------------|---------------------------------------------------|
| Nesne Oluşturma Yöntemi    | `new` anahtar kelimesi ile manuel               | Spring tarafından otomatik                        |
| Spring Container Yönetimi  | Yönetilmez                                      | Spring Container tarafından yönetilir             |
| Bağımlılık Yönetimi        | Manuel olarak yönetilmesi gerekir               | Otomatik olarak Spring tarafından sağlanır        |
| Kod Bakımı ve Modülerlik   | Daha zor ve daha fazla kodlama gerektirir       | Daha düzenli, modüler ve test edilebilir          |
| Yaşam Döngüsü Kontrolleri  | Spring yaşam döngüsünden bağımsızdır            | Spring Bean yaşam döngüsü kurallarına tabidir     |
| Kullanım Alanı             | Basit bağımlılıklar için veya bağımsız nesneler | Karmaşık bağımlılıkların yönetimi için idealdir   |

### Örnek Kod ile Açıklama:

```java
// Manuel Instance Oluşturma
public class Application {

    public static void main(String[] args) {
        // MyService bağımlılığı manuel olarak oluşturulur
        MyService myService = new MyService();
        myService.doSomething();
    }
}
```

Yukarıdaki kodda, `MyService` nesnesi manuel olarak oluşturulmuştur ve bağımlılıklar yönetilmez.

```java
// Spring Injection ile
@Component
public class MyService {
    
    public void doSomething() {
        System.out.println("Hizmet çalışıyor.");
    }
}

@Component
public class Application {

    private final MyService myService;

    // Constructor Injection
    public Application(MyService myService) {
        this.myService = myService;
    }

    public void run() {
        myService.doSomething();
    }
}
```

Bu örnekte:
- Spring Container, `Application` sınıfını başlattığında `MyService` bağımlılığını otomatik olarak enjekte eder.
- `@Component` anotasyonu sayesinde `MyService`, Spring tarafından yönetilen bir bean haline gelir.
- **Injection**, kodun daha temiz ve modüler olmasını sağlar, çünkü bağımlılıklar `new` ile manuel olarak oluşturulmamış, Spring tarafından sağlanmıştır.

### Sonuç:
Injection, Spring'in bağımlılık yönetimini sağladığı bir mekanizmadır ve projelerde daha düzenli, modüler ve test edilebilir bir yapı sağlar. Diğer yandan, instance oluşturma yöntemi manuel bir yöntem olup daha basit projelerde kullanılabilir, ancak bağımlılıkların yönetimi kullanıcıya bırakıldığından kod karmaşık hale gelebilir.

## Spring Boot
```sh 

```
---

**Bağımlılıkların manuel olarak yönetilmesi**, bir sınıfın bağımlılıklarını elle oluşturarak veya elle enjekte ederek, yani Spring gibi bir bağımlılık enjeksiyonu çerçevesine başvurmadan yönetilmesi anlamına gelir. Bu yöntem, bağımlılık yönetimini tamamen geliştiricinin sorumluluğuna bırakır.

### Manuel Bağımlılık Yönetimi Nedir?
Bağımlılıkların manuel olarak yönetilmesi, bağımlı sınıfların ihtiyaç duyduğu nesnelerin `new` anahtar kelimesi ile oluşturulması ve bu bağımlılıkların ilgili sınıfa doğrudan verilmesidir. Geliştirici, hangi nesnelerin nerede ve nasıl kullanılacağını kodda açıkça belirler. Bu yaklaşım, bağımlılık enjeksiyonuna alternatif bir yöntemdir ancak bazı dezavantajlara sahiptir.

### Manuel Bağımlılık Yönetiminin Dezavantajları
1. **Kod Tekrarı ve Dağınıklığı**: Bağımlılıkları manuel olarak yönetmek, kodda `new` anahtar kelimesi ile çok sayıda nesne oluşturulmasına ve aynı nesnenin birçok yerde tekrar tekrar tanımlanmasına neden olabilir. Bu da kodun okunabilirliğini azaltır ve bakımını zorlaştırır.

2. **Gevşek Bağlılık Eksikliği**: Bağımlılık enjeksiyonu ile bağımlılıkları otomatik olarak yöneten çerçeveler, sınıfların birbirine daha az bağımlı (gevşek bağlı) olmasını sağlar. Manuel yöntemle nesneler sıkı sıkıya birbirine bağlı olur, bu da bir sınıfta yapılan bir değişikliğin diğer sınıfları etkilemesine yol açabilir.

3. **Test Edilebilirlik**: Manuel bağımlılık yönetimi, birim testlerini zorlaştırır. Bir sınıfın bağımlılıklarını test sırasında mock (sahte) nesneler ile değiştirmek zor olabilir çünkü bağımlılıklar sınıf içinde doğrudan `new` anahtar kelimesi ile oluşturulmuştur. Bu da test sırasında sınıfları izole etmeyi zorlaştırır.

4. **Yaşam Döngüsü Yönetimi**: Spring gibi bağımlılık enjeksiyonu çerçeveleri, nesnelerin yaşam döngüsünü yönetir ve nesneler yalnızca ihtiyaç duyulduğunda oluşturulur. Manuel bağımlılık yönetiminde, geliştirici bu yaşam döngüsünü yönetmek zorundadır, ki bu da gereksiz bellek kullanımı veya performans sorunlarına yol açabilir.

### Manuel Bağımlılık Yönetimine Örnek

Örneğin, bir `DatabaseService` sınıfının bir `UserService` sınıfında manuel olarak yönetildiğini düşünelim:

```java
public class DatabaseService {
    public void connect() {
        System.out.println("Veritabanına bağlanıldı.");
    }
}

public class UserService {
    private DatabaseService databaseService;

    public UserService() {
        // DatabaseService bağımlılığı manuel olarak oluşturuluyor
        this.databaseService = new DatabaseService();
    }

    public void performDatabaseOperation() {
        databaseService.connect();
    }
}
```

Yukarıdaki kodda:
- `UserService` sınıfı, `DatabaseService` bağımlılığını kendisi yönetmektedir. Bu bağımlılık `UserService` sınıfı içinde manuel olarak oluşturulmuş, yani Spring gibi bir enjeksiyon çerçevesi kullanılmamıştır.
- `UserService` içinde `DatabaseService` nesnesi manuel olarak `new` anahtar kelimesi ile başlatılmıştır. Bu durum sınıflar arasında sıkı bir bağ oluşturur ve bağımlılık enjeksiyonu yapılmadığı için kod daha az esnek hale gelir.

### Manuel Bağımlılık Yönetimine Alternatif: Bağımlılık Enjeksiyonu
Spring ile aynı örnek bağımlılık enjeksiyonu ile yönetildiğinde kod daha temiz ve modüler hale gelir:

```java
@Component
public class DatabaseService {
    public void connect() {
        System.out.println("Veritabanına bağlanıldı.");
    }
}

@Component
public class UserService {
    private final DatabaseService databaseService;

    // Constructor Injection
    @Autowired
    public UserService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public void performDatabaseOperation() {
        databaseService.connect();
    }
}
```

Yukarıdaki örnekte:
- Spring Container, `DatabaseService` nesnesini `UserService` içine otomatik olarak enjekte eder.
- `@Autowired` anotasyonu kullanılarak `UserService` sınıfı bağımlılığını doğrudan `new` ile yönetmek yerine Spring Container’a bırakır.
- Bu yaklaşım, kodun daha modüler, esnek ve test edilebilir olmasını sağlar.

### Sonuç
Manuel bağımlılık yönetimi, bağımlılıkların doğrudan kod içinde `new` ile oluşturulması ve yönetilmesi anlamına gelir. Ancak bu yöntem, kodun karmaşık hale gelmesine ve bakımının zorlaşmasına neden olabilir. Spring gibi bağımlılık enjeksiyon araçları, bağımlılıkları yöneterek kodu daha esnek, test edilebilir ve modüler hale getirir.

## Spring Boot
```sh 

```
---



Spring Framework, Java platformu üzerinde kurulu, açık kaynaklı ve popüler bir uygulama geliştirme çerçevesidir. Spring, özellikle kurumsal uygulamaların geliştirilmesini basitleştirmeyi hedefler. Bu çerçeve, uygulamalarda bağımlılık yönetimini ve uygulama mantığının modüler bir şekilde geliştirilmesini sağlar. Spring Framework, IoC (Inversion of Control - Denetim Ters Çevirme) ve DI (Dependency Injection - Bağımlılık Enjeksiyonu) gibi çekirdek özellikler üzerine kuruludur. Bu özellikler, geliştiricilerin yazılım bileşenlerini daha rahat bir şekilde yönetmelerine ve bağımlılıkları daha esnek bir şekilde tanımlamalarına olanak tanır.

### Spring Framework'ün Özellikleri

Spring Framework birçok modülden oluşur ve her modül, belirli bir işlevselliği sağlamaya yönelik tasarlanmıştır. Bu modüller, geliştiricilere uygulamanın çeşitli katmanlarını ele almada yardımcı olur. Başlıca özellikleri ve modülleri şunlardır:

1. **IoC (Inversion of Control) ve DI (Dependency Injection)**: Spring’in en temel özelliklerinden biri IoC prensibidir. IoC, nesnelerin bağımlılıklarının kendilerinin oluşturulması yerine dışarıdan yönetilmesi anlamına gelir. DI, bağımlılıkların nesneye dışarıdan verilmesi sürecidir. Bu sayede bağımlılıklar kolayca yönetilir ve test edilebilirlik artar.

2. **Aspect-Oriented Programming (AOP)**: AOP, çapraz kesen endişeleri ele almak için kullanılır. Örneğin, loglama, güvenlik gibi işlevler, AOP ile modüler hale getirilebilir. AOP, belirli görevleri (örneğin güvenlik veya loglama) uygulama mantığından ayırarak, bu görevlerin uygulamaya enjekte edilmesine olanak tanır. Spring’in AOP desteği, kullanıcıların özelleştirilebilir yöntemleri kullanarak uygulamaları daha yönetilebilir hale getirmelerini sağlar.

3. **Transaction Management (İşlem Yönetimi)**: Spring, veri tutarlılığını sağlamak için işlem yönetimi sağlar. Bu, özellikle veri tabanları ve diğer kaynaklarla yapılan işlemlerde oldukça önemlidir. Spring’in işlem yönetimi, programcıların işlem yönetimini kodlara fazla müdahale etmeden ele almalarına imkan tanır.

4. **Spring MVC (Model-View-Controller)**: Web tabanlı uygulamaların geliştirilmesi için kullanılan bir modüldür. MVC mimarisi üzerine kuruludur ve geliştiricilere hem basit hem de karmaşık web uygulamaları geliştirme imkanı tanır. Spring MVC, isteklere yanıt veren denetleyiciler, model-veri yönetimi ve görünüm şablonlarıyla güçlü bir yapı sunar.

5. **Spring Data**: Veritabanı işlemlerini basitleştiren bir modüldür. ORM (Object-Relational Mapping) araçlarıyla entegrasyonu sağlar (örneğin Hibernate ile). Spring Data, veritabanı işlemlerinde temel CRUD (Create, Read, Update, Delete) işlemlerini kolaylaştırır ve veri erişim katmanında tekrarlayan kodları minimize eder.

6. **Spring Boot**: Spring Framework’ün daha hızlı ve kolay kullanımını sağlamak için geliştirilmiş bir modüldür. Spring Boot, sıfırdan bir uygulama başlatmayı ve ayarlamayı çok kolay hale getirir. Otomatik yapılandırma özelliği sayesinde, birçok ayar dosyasını manuel olarak oluşturmanıza gerek kalmaz. Spring Boot aynı zamanda bağımsız çalışabilen bir jar dosyası oluşturma yeteneği sunar ve bu sayede uygulama dağıtımı oldukça kolaylaşır.

7. **Spring Security**: Uygulamalarda güvenliği sağlamak için kullanılan bir modüldür. Kimlik doğrulama ve yetkilendirme işlemlerini kolayca yönetmeyi sağlar. Spring Security, web tabanlı uygulamalarda oturum yönetimi, kimlik doğrulama, kullanıcı rolleri, erişim kontrolü gibi güvenlik özelliklerini sağlar.

8. **Spring Cloud**: Mikroservis mimarisi için özel olarak tasarlanmış bir modüldür. Mikroservisler arasındaki iletişim, yapılandırma yönetimi, yük dengeleme, hata toleransı gibi konularda çözüm sunar. Spring Cloud, mikroservis tabanlı uygulamalar için konfigürasyon yönetimi, servis keşfi, devre kesici (circuit breaker) gibi özellikler sunar.

9. **Spring Batch**: Batch (toplu) işlemleri yönetmek için kullanılan bir modüldür. Özellikle büyük veri işleme görevlerinde ve arka planda çalışan toplu işlerin yönetiminde kullanılır. Spring Batch, toplu işlemleri zamanlayarak ve iş akışlarını düzenleyerek veri işleme süreçlerini daha verimli hale getirir.

10. **Spring Integration**: Kurumsal entegrasyon desenlerini (EIP) destekleyen bir modüldür. Sistemler arası mesajlaşma, veri senkronizasyonu gibi işlemleri kolaylaştırır. Spring Integration, uygulamaların başka sistemlerle entegre çalışmasını sağlamak için güçlü bir yapı sunar.

### Spring Framework’ün Faydaları

- **Test Edilebilirlik**: Spring, DI ve IoC kullanarak nesneler arasındaki bağımlılıkları yönetir. Bu sayede nesneler bağımsız olarak test edilebilir hale gelir.
- **Modülerlik ve Esneklik**: Spring’in modüler yapısı, sadece ihtiyaç duyulan modüllerin kullanılmasına imkan tanır.
- **Açık Kaynak ve Topluluk Desteği**: Spring, açık kaynak kodlu bir çerçeve olduğundan sürekli güncellenir ve geniş bir topluluğa sahiptir.
- **Performans ve Verimlilik**: Spring Framework, işlem yönetimi ve veri erişim katmanı gibi birçok alanı optimize eder, bu da daha yüksek performans sağlar.
- **Kurumsal Düzeyde Uygulama Desteği**: Spring, büyük ölçekli kurumsal uygulamaların geliştirilmesinde yaygın olarak kullanılır. Özellikle Spring Cloud ve Spring Batch gibi modüller, büyük veri işlemlerinde ve mikroservis mimarilerinde iş yükünü azaltır.

### Örnek Kullanım Senaryosu

Bir e-ticaret uygulaması geliştirdiğinizi düşünelim. Bu uygulamada Spring Framework’ün sunduğu özellikler şu şekillerde kullanılabilir:

1. **Dependency Injection**: Uygulamadaki bileşenler arasındaki bağımlılıklar, DI sayesinde daha kolay yönetilir. Örneğin, bir ürün servisi (ProductService) ve bir veri erişim katmanı (ProductRepository) arasındaki bağımlılık DI ile sağlanabilir.

2. **Spring MVC**: Web tabanlı bir yapı olduğu için, Spring MVC kullanarak kullanıcıların ürünleri listeleyebileceği, sepete ekleyebileceği ve satın alabileceği bir arayüz oluşturulabilir.

3. **Spring Data**: Ürün, müşteri ve sipariş verileri bir veritabanında saklanabilir. Spring Data, bu veriler üzerinde CRUD işlemlerini basitleştirir.

4. **Spring Security**: Kullanıcı kimlik doğrulama ve yetkilendirme işlemleri için kullanılabilir. Örneğin, yalnızca yetkili kullanıcıların sipariş verebilmesini sağlamak için Spring Security ile güvenlik katmanı eklenebilir.

5. **Spring Cloud**: Mikroservis mimarisi tercih ediliyorsa, her hizmeti bağımsız servisler olarak geliştirmek için Spring Cloud modülleri kullanılabilir. Örneğin, ürün ve sipariş servisi ayrı ayrı mikroservisler olarak geliştirilebilir.

6. **Spring Batch**: Belirli zamanlarda çalıştırılması gereken veri işleme görevleri varsa (örneğin, günlük satış raporu oluşturmak gibi), Spring Batch ile bu işlemler otomatik olarak zamanlanabilir.

### Spring Framework’ün Mimari Bileşenleri

Spring Framework’ün çekirdeğinde IoC kapsayıcısı (container) bulunur. Bu kapsayıcı, uygulamadaki nesnelerin yaşam döngüsünü yönetir. IoC kapsayıcısı, XML tabanlı konfigürasyonlar, anotasyonlar veya Java tabanlı konfigürasyonlar ile yapılandırılabilir. Spring’in IoC kapsayıcısı, uygulama içinde kullanılan nesneleri otomatik olarak enjekte eder ve bu nesneler arasındaki bağımlılıkları yönetir.

### Sonuç

Spring Framework, Java tabanlı uygulamalar geliştirmek için güçlü ve esnek bir çerçevedir. Çekirdek modülleri ve kapsamlı modüler yapısıyla, hem küçük ölçekli hem de büyük ölçekli kurumsal uygulamalarda kullanılabilir. IoC ve DI gibi modern yazılım geliştirme ilkelerini benimsemesi, uygulamaların daha kolay yönetilebilir, genişletilebilir ve test edilebilir olmasını sağlar. Spring, geniş topluluk desteği ve güçlü ekosistemi ile, yazılım geliştirme sürecini hızlandırır ve geliştiricilere esnek bir yapı sunar.

Daha fazla bilgiye ihtiyacınız varsa veya herhangi bir modül hakkında ayrıntılı bir açıklama isterseniz, yardımcı olmaktan memnuniyet duyarım.



Spring API, Spring Framework’ün sunduğu programlama arayüzlerini ve araçlarını kapsayan bir yapıdır. Bu API'ler, özellikle RESTful web servisleri oluşturmak, çeşitli uygulama bileşenlerini birbirine bağlamak ve yazılım geliştirme sürecini kolaylaştırmak için kullanılır. Spring API, web tabanlı uygulamaların geliştirilmesi ve yönetilmesi için geniş bir araç seti sunar. Bu araç seti sayesinde geliştiriciler, yüksek performanslı, güvenli ve ölçeklenebilir web servisleri ve API'ler oluşturabilir.

Spring API, özellikle REST API geliştirmede popülerdir ve birçok kurumsal projede kullanılır. RESTful servisler, istemci-sunucu mimarisi temelinde HTTP protokolü üzerinden veri alışverişi yapar ve Spring API bu servislerin hızlı ve etkili bir şekilde oluşturulmasına olanak tanır.

### Spring API'nin Temel Bileşenleri

Spring API, birçok farklı bileşeni içerir. Bu bileşenler, web uygulamaları geliştirme, veri işleme, güvenlik sağlama gibi farklı görevleri yerine getirmek üzere tasarlanmıştır. Başlıca bileşenleri şunlardır:

1. **Spring MVC**: Model-View-Controller mimarisi üzerine kuruludur ve web tabanlı uygulama geliştirmeyi sağlar. Spring MVC, web isteklerini işleyerek yanıtlar, yönlendirme işlemlerini yönetir ve uygulama mantığını model katmanında kapsar. Spring MVC, REST API geliştirmede de büyük rol oynar ve HTTP protokolünü etkin bir şekilde kullanarak veri alışverişi yapılmasını sağlar.

2. **Spring Web**: Bu bileşen, web uygulamaları ve REST API’ler geliştirmek için kullanılan temel bir modüldür. Web üzerinden veri gönderme, alma ve yönlendirme işlemlerini içerir. Özellikle Spring Boot ile birlikte kullanıldığında, Spring Web’in sağladığı basitleştirilmiş yapı, hızlı API geliştirmeyi sağlar.

3. **Spring REST**: REST (Representational State Transfer) standartları üzerine kurulu servisler geliştirmek için kullanılan bir bileşendir. RESTful servisler, HTTP metotları (GET, POST, PUT, DELETE) ile çalışır ve JSON, XML gibi veri formatlarını kullanarak veri alışverişi yapar. Spring REST, Spring MVC ile entegre çalışarak RESTful API geliştirmeyi kolaylaştırır.

4. **Spring Data REST**: Spring Data REST, veri tabanı işlemlerini REST API üzerinden kullanıma sunmayı sağlar. Bu modül, veri tabanı işlemlerini RESTful servisler aracılığıyla otomatikleştirir ve CRUD işlemleri için gerekli API'leri oluşturur. Bu sayede Spring Data ile oluşturulan veri modelleri, Spring Data REST kullanılarak hızlıca API'ler haline getirilebilir.

5. **Spring HATEOAS (Hypermedia as the Engine of Application State)**: Spring HATEOAS, REST API'lerde daha zengin ve anlamlı yanıtlar oluşturmayı amaçlar. Hypermedia, API'nin istemcinin kendi kendine yol bulmasını sağlayan linkleri yanıtlarla birlikte döndürmesini sağlar. Örneğin, bir kullanıcı bilgisi döndürülürken, o kullanıcıya ait ilişkili diğer kaynakların (siparişler, adresler) bağlantıları da yanıt içinde sunulabilir.

6. **Spring Security**: API'lerin güvenliğini sağlamak için kullanılan modüldür. Kimlik doğrulama, yetkilendirme ve erişim kontrolü gibi güvenlik işlemlerini yönetir. API'lerin güvenliğini sağlamak, özellikle kullanıcı verilerini korumak için son derece önemlidir. Spring Security, REST API'ler için OAuth2, JWT (JSON Web Tokens) gibi modern güvenlik protokollerini de destekler.

7. **Spring Cloud**: Mikroservis mimarisine uygun API'ler geliştirmek için kullanılan Spring modülüdür. Spring Cloud, dağıtık sistemlerde kullanılan servis keşfi, yük dengeleme, yapılandırma yönetimi gibi özellikleri sağlar. Özellikle mikroservis tabanlı uygulamalarda, Spring Cloud ile API'lerin yönetimi kolaylaşır.

---

### Spring Boot AOP (Aspect-Oriented Programming) Nedir?

Spring Boot AOP (Aspect-Oriented Programming - Yönlendirilmiş Programlama), bir uygulamanın çekirdek iş mantığından bağımsız olan genel özelliklerini (cross-cutting concerns) ele almak için kullanılan güçlü bir programlama paradigmasıdır. Genel özellikler, loglama, hata ayıklama, güvenlik, performans izleme ve transaction yönetimi gibi uygulamanın birden fazla yerinde kullanılan tekrarlayan kod parçalarıdır.

Spring Framework, AOP desteğini sağlam bir şekilde entegre eder ve bunu Spring Boot projelerinde de kolayca kullanabilirsiniz. AOP'nin temel amacı, bu çapraz kesen kaygıları (cross-cutting concerns) uygulamanın iş mantığından ayırmaktır.

---

### AOP Temel Kavramları

#### 1. **Aspect (Kesit)**
- Bir uygulamanın çapraz kesen kaygılarını temsil eder. Örneğin, loglama veya güvenlik birer "aspect"tir. Aspect, belirli bir davranışı kapsar ve bu davranış uygulamanın diğer bölümlerinde kesintisiz bir şekilde uygulanabilir.

#### 2. **Advice (Tavsiye)**
- Bir Aspect'in ne yapacağını tanımlayan kod parçacığıdır. **Advice**, belirli bir nokta veya olayda çalışan bir mantıktır.
- Spring AOP'de beş tür **Advice** vardır:
  1. **Before Advice**: Bir metod çağrılmadan önce çalışır.
  2. **After Advice**: Bir metod tamamlandıktan sonra çalışır (başarı ya da hata durumunda).
  3. **After Returning Advice**: Bir metod başarıyla tamamlandıktan sonra çalışır.
  4. **After Throwing Advice**: Bir metod bir hata fırlattığında çalışır.
  5. **Around Advice**: Bir metod çağrılmadan önce ve çağrıldıktan sonra çalışır.

#### 3. **Join Point**
- Uygulamada bir metod çağrısı, bir istisna atılması ya da bir property'ye erişim gibi bir işlem sırasında yürütülebilecek bir noktadır. Spring AOP, yalnızca metod yürütmeleri üzerinde çalışır, dolayısıyla bir metodun başlatılması bir **Join Point**tir.

#### 4. **Pointcut**
- Bir veya daha fazla **Join Point**'i eşleştiren bir ifade veya modeldir. Örneğin, belirli bir sınıftaki tüm metodlar üzerinde işlem yapmak istiyorsanız, o sınıfın tüm metodlarını kapsayan bir **Pointcut** tanımlarsınız.

#### 5. **Target Object**
- Aspect'in uygulandığı nesnedir. Bu nesneye genellikle "proxied object" (proxy nesnesi) denir.

#### 6. **Weaving (Dokuma)**
- Aspect'lerin uygulamanın belirli noktalarına entegre edilmesi işlemidir. Spring AOP, dokumayı çalışma zamanında (runtime weaving) gerçekleştirir.

---

### Spring Boot'ta AOP'nin Kullanım Alanları

- **Loglama**: Uygulamanın belirli bölümlerinde yapılan işlemleri izlemek.
- **Performans İzleme**: Belirli metodların ne kadar süre çalıştığını ölçmek.
- **Güvenlik**: Hassas metotlara erişim için kullanıcıların yetkilendirilmesi.
- **Transaction Yönetimi**: Belirli metodların bir işlem (transaction) içinde çalışmasını sağlamak.
- **Hata Ayıklama**: Hataları veya istisnaları yakalamak ve bunları daha iyi yönetmek.

---

### Spring Boot'ta AOP Uygulaması

#### 1. **Spring Boot'ta AOP Bağımlılığı Eklemek**
Maven kullanıyorsanız `spring-boot-starter-aop` bağımlılığını ekleyin:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

Gradle kullanıyorsanız:
```gradle
implementation 'org.springframework.boot:spring-boot-starter-aop'
```

---

#### 2. **Aspect Sınıfı Tanımlamak**
Bir Aspect oluşturmak için sınıfınızı `@Aspect` ile işaretleyin ve Spring Bean olarak tanımlayın (`@Component`).

Örnek bir Aspect sınıfı:
```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.service.*.*(..))")
    public void logBeforeMethodExecution() {
        System.out.println("Metod çalıştırılmadan önce loglama yapılıyor.");
    }
}
```

**Açıklama:**
- `@Before`: Bir metod çağrılmadan önce çalışacak bir `Advice` tanımlar.
- `execution(* com.example.service.*.*(..))`: Belirli bir `Pointcut` ifade eder. Bu ifade, `com.example.service` paketindeki tüm sınıfların tüm metodlarını hedefler.

---

#### 3. **Pointcut İfadeleri**
Pointcut ifadeleri, AOP'nin güçlü ve esnek bir şekilde kullanılmasını sağlar. Bazı örnekler:

- **Belirli bir sınıftaki tüm metodlar:**
  ```java
  @Before("execution(* com.example.service.MyService.*(..))")
  ```

- **Belirli bir adla başlayan metodlar:**
  ```java
  @Before("execution(* com.example.service.*.get*(..))")
  ```

- **Birden fazla paket veya sınıf:**
  ```java
  @Before("execution(* com.example.service..*(..)) || execution(* com.example.repository..*(..))")
  ```

---

#### 4. **Around Advice Kullanımı**
`@Around` ile hem metod çağrısından önce hem de sonra bir işlem yapabilirsiniz.

Örnek:
```java
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    @Around("execution(* com.example.service.*.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // Metodu çalıştırır
        long executionTime = System.currentTimeMillis() - start;
        System.out.println(joinPoint.getSignature() + " çalıştırma süresi: " + executionTime + "ms");
        return result;
    }
}
```

---

#### 5. **After Returning Advice Kullanımı**
Bir metod başarıyla çalıştıktan sonra sonuçları yakalamak için `@AfterReturning` kullanabilirsiniz.

Örnek:
```java
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ResultLoggingAspect {

    @AfterReturning(pointcut = "execution(* com.example.service.*.*(..))", returning = "result")
    public void logMethodResult(Object result) {
        System.out.println("Metodun dönüş değeri: " + result);
    }
}
```

---

### Spring AOP'nin Avantajları

1. **Kod Tekrarını Azaltır:** Loglama, güvenlik, ve hata yönetimi gibi çapraz kesen kaygıları bir yerde toplar.
2. **Daha Temiz Kod:** Çekirdek iş mantığını sadeleştirir.
3. **Kolay Yönetim:** Çapraz kesen kaygılar tek bir yerde yönetilir.
4. **Modülerlik:** Aspect'ler modülerdir ve uygulamanın diğer kısımlarından bağımsızdır.

---

### Spring Boot AOP ve Proxy Mekanizması

Spring AOP, Java'nın proxy mekanizmasını kullanır:
- **JDK Dynamic Proxy:** Eğer bir sınıf bir arayüzü implemente ediyorsa, JDK proxy'si kullanılır.
- **CGLIB Proxy:** Eğer bir sınıf bir arayüz implemente etmiyorsa, Spring AOP bu sınıf için CGLIB (Code Generation Library) kullanır.

---

### Spring Boot AOP ile İlgili Kısıtlamalar
1. **Sadece Metot Bazlı Çalışır:** Spring AOP sadece metod seviyesinde çalışır. Alan (field) erişimi gibi işlemleri desteklemez.
2. **Compile-Time Weaving Yoktur:** Spring AOP, çalışma zamanında dokuma (runtime weaving) yapar.
3. **Performans:** AOP proxy mekanizması performans üzerinde küçük bir yük oluşturabilir.

---
---
---

# Spring ALL
Spring Framework, Java platformu üzerinde geniş bir uygulama geliştirme ortamı sağlayan, açık kaynaklı, modüler bir framework'tür. İlk olarak Rod Johnson tarafından 2002 yılında tanıtılmıştır ve Java dünyasında popülerliği artarak modern uygulama geliştirme süreçlerinin vazgeçilmez bir parçası haline gelmiştir.

### **Spring Framework'ün Temel Amacı**
Spring Framework, geliştiricilere kurumsal düzeyde uygulamalar geliştirme konusunda rehberlik eden ve çeşitli yazılım geliştirme ihtiyaçlarını karşılayan kapsamlı bir araç seti sunar. Esnek bir altyapı sağlayarak uygulama geliştiricilerin kodlarını daha modüler, test edilebilir ve yönetilebilir hale getirmelerine olanak tanır. Temel olarak, yazılım geliştirmenin karmaşıklığını azaltmak için tasarlanmıştır.

---

### **Spring Framework'ün Temel Özellikleri**

#### 1. **Inversion of Control (IoC) ve Dependency Injection (DI):**
- **IoC (Kontrolün Tersine Çevrilmesi):** Uygulamanın kontrolünün, geliştiriciden framework’e devredilmesini ifade eder. Bu, nesne yönetimini ve bağımlılıkların oluşturulmasını framework'ün üstlenmesi anlamına gelir.
- **Dependency Injection:** Nesneler arasındaki bağımlılıkların, dış bir konfigürasyon dosyası veya anotasyonlar aracılığıyla enjekte edilmesini sağlar. Bu, kodun gevşek bağlı (loosely coupled) olmasını sağlar ve test edilebilirliği artırır.

#### 2. **Modüler ve Esnek Mimari:**
Spring Framework, geliştiricilere yalnızca ihtiyaç duydukları modülleri kullanma esnekliği sağlar. Örneğin, sadece veri erişim katmanını geliştirmek için Spring Data kullanılabilir veya web uygulamaları için Spring MVC'den faydalanılabilir.

#### 3. **Aspect-Oriented Programming (AOP):**
- AOP, çapraz kesen endişeleri (cross-cutting concerns) uygulamanın iş mantığından ayrı bir katmanda ele almak için kullanılır.
- Örnek: Loglama, güvenlik, performans izleme gibi işlemler.

#### 4. **Spring Container:**
Spring Container, uygulamadaki nesneleri (bean) yönetir ve yaşam döngülerini kontrol eder. IoC ve DI, bu container aracılığıyla sağlanır.

#### 5. **Data Access (Veri Erişimi):**
Spring, JDBC, Hibernate ve JPA gibi veri erişim teknolojilerini destekler. ORM (Object Relational Mapping) araçları ile entegre çalışarak veri tabanı işlemlerini kolaylaştırır.

#### 6. **Spring MVC (Model-View-Controller):**
Spring MVC, web uygulamaları geliştirmek için kullanılır. Model-View-Controller tasarım deseni ile kullanıcı arayüzü ve iş mantığını birbirinden ayırarak daha temiz ve sürdürülebilir bir kod yapısı sağlar.

#### 7. **Spring Security:**
Kurumsal uygulamalarda güvenlik kritik bir konudur. Spring Security, kimlik doğrulama ve yetkilendirme gibi güvenlik gereksinimlerini karşılamak için güçlü bir altyapı sunar.

#### 8. **Spring Boot ile Entegrasyon:**
Spring Framework'ün karmaşıklığını azaltmak için Spring Boot geliştirilmiştir. Spring Boot, Spring Framework'ün konfigürasyon yükünü minimuma indirir ve hızlı uygulama geliştirme sağlar.

#### 9. **Spring Cloud:**
Mikroservis mimarilerinde kullanılan Spring Cloud, servis keşfi (service discovery), yük dengeleme (load balancing), dağıtılmış konfigürasyon yönetimi ve devre kesici (circuit breaker) gibi özellikler sunar.

#### 10. **Spring Test:**
Spring, test süreçlerini kolaylaştırmak için entegre bir test desteği sunar. JUnit ve TestNG ile uyumlu çalışır ve mock nesneleri destekler.

---

### **Spring Framework'ün Avantajları**

1. **Modülerlik ve Esneklik:**
  - İhtiyaç duyulan modülleri kullanarak hafif bir uygulama geliştirme olanağı sağlar.
2. **Test Edilebilirlik:**
  - IoC ve DI sayesinde bağımlılıklar kolayca test edilebilir.
3. **Geniş Ekosistem:**
  - Spring Boot, Spring Cloud, Spring Data gibi geniş bir ekosisteme sahiptir.
4. **Topluluk Desteği:**
  - Dünya çapında geniş bir kullanıcı ve geliştirici topluluğuna sahiptir.
5. **Performans ve Ölçeklenebilirlik:**
  - Kurumsal düzeyde yüksek performanslı ve ölçeklenebilir uygulamalar geliştirmek için uygundur.

---

### **Spring Framework Nasıl Çalışır?**

Spring Framework, temel olarak IoC container üzerinde çalışır. IoC container, uygulama bileşenlerini (bean) oluşturur, konfigüre eder ve yaşam döngüsünü yönetir. Bean'ler, Spring konfigürasyon dosyasında veya anotasyonlar aracılığıyla tanımlanır.

#### **IoC Container Çalışma Süreci:**
1. Bean tanımları okunur (XML, Java-based config veya anotasyon).
2. Spring Container, bu tanımlara göre nesneleri oluşturur.
3. Gerekli bağımlılıklar injection yoluyla sağlanır.
4. Bean nesneleri, uygulama tarafından kullanılır.

---

### **Spring Framework Kullanım Alanları**

1. **Web Uygulamaları:** Spring MVC ve Spring Boot, modern web uygulamaları geliştirmek için kullanılır.
2. **Kurumsal Uygulamalar:** Büyük ölçekli, güvenilir ve modüler kurumsal uygulamalar geliştirmek için uygundur.
3. **Mikroservisler:** Spring Boot ve Spring Cloud, mikroservis mimarisinde yaygın olarak kullanılır.
4. **Veri İşleme:** Spring Batch ile büyük veri işleme uygulamaları oluşturulabilir.
5. **Dağıtılmış Sistemler:** Spring Framework, dağıtılmış sistemlerin geliştirilmesi için güçlü bir altyapı sunar.

---

### **Spring Framework Modülleri**

Spring Framework, farklı ihtiyaçlara yönelik çeşitli modüller içerir:

1. **Spring Core:**
  - IoC ve DI gibi temel özellikleri sağlar.
2. **Spring AOP:**
  - Aspect-Oriented Programming desteği sunar.
3. **Spring Data:**
  - Veri erişimi ve yönetimi kolaylaştırır.
4. **Spring Security:**
  - Kimlik doğrulama ve yetkilendirme mekanizmaları sağlar.
5. **Spring Batch:**
  - Batch (toplu) işlemleri destekler.
6. **Spring Integration:**
  - Uygulama entegrasyonu için araçlar sunar.
7. **Spring Web:**
  - RESTful API'ler ve web uygulamaları için altyapı sağlar.

---

### **Sonuç**
Spring Framework, modern yazılım geliştirme süreçlerinde esneklik, performans ve sürdürülebilirlik arayan geliştiriciler için ideal bir araçtır. Spring'in sunduğu geniş özellik seti ve modüler yapısı, her ölçekte uygulama geliştirmek için uygun bir altyapı sağlar. Kurumsal Java uygulamaları için standart haline gelen bu framework, günümüzde popülaritesini korumakta ve sürekli olarak güncellenmektedir.