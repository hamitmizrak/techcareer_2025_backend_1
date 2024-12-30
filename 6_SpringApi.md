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


---
## GET attributes
@GetMapping(
name = "/addres_list_name",
value = "/list",
//path = "/list2"
params = "active=true",
consumes = "application/json",
produces = "application/json",
headers = "X-API-VERSION=1"
)
@Override
public ResponseEntity<List<AddressDto>> addressApiList() {
return ResponseEntity.status(HttpStatus.OK).body(iAddressService.addressServiceList());
}

Bu komutta kullanılan `@GetMapping` anotasyonu, Spring Framework'deki RESTful API geliştirme işlemlerinde kullanılan bir anotasyondur. Bu anotasyon, bir HTTP GET isteğine yanıt veren bir metodun yapılandırılmasını sağlar. Kodda verilen her bir özelliği (attribute) detaylı bir şekilde inceleyip, nasıl çalıştığını ve ne anlama geldiğini açıklayacağım. Ayrıca, her bir özelliğin API'nin nasıl çalışmasını etkilediğini de ayrıntılı olarak açıklayacağım.

### Komut:
```java
@GetMapping(
    name = "/addres_list_name",
    value = "/list",
    path = "/list",
    params = "active=true",
    consumes = "application/json",
    produces = "application/xml",
    headers = "X-API-VERSION=1"
)
@Override
public ResponseEntity<List<AddressDto>> addressApiList() {
    return ResponseEntity.status(HttpStatus.OK).body(iAddressService.addressServiceList());
}
```

## Kısaca
    /*
    İşte `@GetMapping` anotasyonundaki parametrelerin kısa ve madde madde açıklamaları:

1. **`name`:**
    - Metoda bir isim verir (genellikle içsel kullanım içindir, dışarıdan görünmez).
    - Örnek: `name = "/address_list_name"`

2. **`value`:**
    - GET isteğinin URL yolunu belirtir (endpoint).
    - Örnek: `value = "/list"`

3. **`path`:**
    - `value` ile aynı işlevi görür, endpoint yolunu belirtir.
    - Örnek: `path = "/list2"`

4. **`params`:**
    - GET isteğinde belirli bir query parametresinin bulunmasını zorunlu kılar.
    - Örnek: `params = "active=true"`
    - EndPoint: http://lcaolhost:4444/list?active=true

5. **`consumes`:**
    - İstek veri formatını (Content-Type) belirtir, sadece bu formatta gelen verileri kabul eder.
    - Örnek: `consumes = "application/json"`

6. **`produces`:**
    - Yanıt veri formatını belirtir, API'nin döneceği formatı tanımlar.
    - Örnek: `produces = "application/json"`
    - - Örnek: `produces = "application/xml"`

7. **`headers`:**
    - İstek başlığında (header) belirli bir bilginin bulunmasını zorunlu kılar.
    - Örnek: `headers = "X-API-VERSION=1"`
      */
## name attribute örnek vermek
"Bu isim, Spring'in dahili mekanizmasında kullanılabilir" ifadesi, Spring'in kendi yapısında bu ismi referans olarak kullanabileceği anlamına gelir.
Ancak, bu isim dışarıya görünmez, yani API'yi çağıran istemciler bu ismi görmez veya bilmezler.
Bu isim, genellikle Spring'in içsel işlemlerinde, logging (kayıt tutma), izleme veya debugging (hata ayıklama) gibi durumlarda kullanılabilir.

### Örnek:
Spring uygulamanızda birden fazla endpoint olabilir ve her birine `name` özelliği ile benzersiz isimler verebilirsiniz. Bu isimler, özellikle monitoring (izleme) veya hata ayıklama araçları tarafından kullanılabilir.

#### Kullanım Senaryosu:
1. **İzleme ve Debugging:** Uygulamanız bir monitoring aracı ile izleniyorsa, belirli bir endpoint'in adı bu araçlarda kolayca görüntülenebilir ve loglarda daha anlaşılır bir bilgi sağlar.

2. **Logging:** Loglarınızda hangi metodun hangi isimle çağrıldığını belirtmek isteyebilirsiniz. Örneğin, hata aldığınızda bu endpoint'e verilen isim loglarda gözükebilir.

### Örnek:
```java
@GetMapping(
    name = "getAddressListEndpoint",
    value = "/list",
    produces = "application/json"
)
public ResponseEntity<List<AddressDto>> addressApiList() {
    log.info("Calling the endpoint: getAddressListEndpoint");
    return ResponseEntity.ok(iAddressService.addressServiceList());
}
```

Bu örnekte, `log.info("Calling the endpoint: getAddressListEndpoint");` satırı, bu endpoint'e yapılan çağrıların loglanmasını sağlar. Loglarda bu metodun adı `getAddressListEndpoint` olarak görünür. Bu, metodun ne işe yaradığını anlamayı kolaylaştırır.

### Spring Actuator ile Kullanım:
Eğer Spring Actuator kullanıyorsanız, uygulamanızın `name` ile tanımlanmış metodlarını izleme veya raporlama araçlarıyla daha anlamlı hale getirebilirsiniz.

```bash
curl http://localhost:8080/actuator/mappings
```

Bu komutla, Spring Actuator üzerinde tanımlı tüm endpoint'leri görebilirsiniz ve bu noktada `name` ile verilmiş isimler bu mapping bilgisi içinde görünür.

### `@GetMapping` Anotasyonunun Ayrıntılı Açıklaması:
Spring Framework'de `@GetMapping` anotasyonu, bir HTTP GET isteğini belirli bir metoda eşlemek için kullanılır.
Bu metoda gelen GET isteği, `value` ve diğer koşullara göre doğru URL'ye ve isteklere yönlendirilir.

#### 1. **`name`:**
```java
name = "/addres_list_name"
```
- **Açıklama:** `name` özelliği, Spring'in dahili kullanımında metodlara bir referans ismi vermek için kullanılır. Normalde bu isim dışarıya yansıtılmaz ve kullanıcının göremeyeceği bir özelliktir.
- **Anlamı:** Bu metot için bir isim tanımlanmıştır: "/addres_list_name". Bu, proje içinde Spring'in bu metodu izleyebilmesi ve gerektiğinde referans verebilmesi için kullanılabilir.
- **Kullanımı:** Özellikle büyük projelerde, belirli metodlara referans vermek ve metodların izlenebilirliğini artırmak için faydalıdır.
- Ancak genellikle küçük projelerde bu özelliğin kullanımı zorunlu değildir ve isteğe bağlıdır.

#### 2. **`value`:**
```java
value = "/list"
```
- **Açıklama:** `value` özelliği, GET isteğinin URL yolunu tanımlar.
- Bu, istemcinin hangi URL'ye istek yapacağını belirleyen temel yoldur.
- **Anlamı:** `/list` olarak belirlenen bu URL, istemcinin `http://localhost:4444/api/address/list` adresine GET isteği yaparak bu metoda ulaşmasını sağlar.
- Uygulamanın çalıştığı kök URL ve sınıf düzeyinde tanımlanan yol (muhtemelen `/api/address`) bu yolun tam halini belirler.
- **Kullanımı:** İstemci, bu API'ye erişmek istediğinde `http://localhost:4444/api/address/list` yoluna bir GET isteği yapar.
- Bu URL, servise dışarıdan erişim için kapı görevi görür.

#### 3. **`params`:**
```java
params = "active=true"
```
- **Açıklama:** `params` özelliği, HTTP isteğinin belirli bir query parametresini içermesi gerektiğini belirtir. Burada, URL'de belirli parametreler bulunması zorunlu kılınmıştır.
- **Anlamı:** API çağrısı yapılırken, URL'de `active=true` query parametresi olmalıdır. Örneğin: `http://localhost:4444/api/address/list?active=true` şeklinde bir GET isteği yapılması gerekir.
- Eğer bu parametre belirtilmezse veya değeri farklı olursa, istek bu metoda yönlendirilmez.
- **Kullanımı:** `params` özelliği ile aynı endpoint'e farklı parametreler göndererek farklı işlemler gerçekleştirebiliriz.
- Parametre kontrolü, isteğin doğru metodla eşleşmesini sağlar.

#### 4. **`consumes`:**
```java
consumes = "application/json"
```
- **Açıklama:** `consumes` özelliği, API'ye gönderilecek olan isteğin veri formatını belirtir.
- Yani bu metod, yalnızca belirli bir formatta (bu örnekte `application/json`) gönderilen istekleri kabul eder.
- **Anlamı:** Bu API, sadece JSON formatındaki verileri kabul eder.
- Bu, istemcinin isteği yaparken `Content-Type: application/json` başlığı ile veri göndermesi gerektiği anlamına gelir.
- Eğer istek başka bir formatta (örneğin XML) gönderilirse, API bunu işleyemez ve 415 (Unsupported Media Type) hatası döner.
- **Kullanımı:** `consumes` özelliği, API'nin yalnızca belirli formatta veri almasını sağlamak için kullanılır.
- Genellikle JSON (`application/json`), XML (`application/xml`), veya form verisi (`application/x-www-form-urlencoded`) formatlarıyla çalışır.

#### 5. **`produces`:**
```java
produces = "application/json"
```
- **Açıklama:** `produces` özelliği, bu metodun istemciye hangi formatta yanıt döndüreceğini belirtir.
- Bu durumda, API JSON formatında bir yanıt döndürecektir.
- **Anlamı:** Yanıt, `application/json` formatında dönecektir. İstemci bu endpoint'i çağırırken `Accept: application/json` başlığını ekleyebilir ve yanıtın JSON formatında olduğunu bilmelidir.
- Eğer istemci farklı bir format beklerse (örneğin XML), 406 (Not Acceptable) hatası dönebilir.
- **Kullanımı:** Bu özellik, API'nin belirli bir formatta yanıt döndürmesini zorunlu kılar.
- JSON, XML, HTML gibi farklı formatlar arasında seçim yapabilirsiniz.

#### 6. **`headers`:**
```java
headers = "X-API-VERSION=1"
```
- **Açıklama:** `headers` özelliği, HTTP isteğinde belirli bir başlığın (header) bulunmasını zorunlu kılar.
- Bu örnekte, `X-API-VERSION` başlığı kullanılmaktadır.
- **Anlamı:** Bu API'yi çağırırken HTTP isteğine `X-API-VERSION: 1` başlığı eklenmelidir.
- Bu genellikle API versiyonlaması için kullanılır.
- İstemci bu başlığı göndermezse ya da farklı bir değer gönderirse, bu metot çalışmaz ve genellikle 400 (Bad Request) veya 404 (Not Found) hatası dönebilir.
- **Kullanımı:** `headers` özelliği, API versiyonlama, güvenlik veya farklı ihtiyaçlar doğrultusunda isteklere eklenen başlıkları kontrol etmek için kullanılır.
- Versiyonlamada API'nin farklı sürümlerini desteklemek için başlıklar sıkça kullanılır.

### Metodun Gövdesi:
```java
@Override
public ResponseEntity<List<AddressDto>> addressApiList() {
    return ResponseEntity.status(HttpStatus.OK).body(iAddressService.addressServiceList());
}
```
#### 1. **`@Override`:**
- **Açıklama:** Bu anotasyon, bir metotun üst sınıfta veya bir interface'de tanımlandığını ve burada tekrar tanımlandığını belirtir. Bu, metodun bir interface olan `IAddressApi`'dan alındığını gösterir.
- **Anlamı:** Bu metot, `IAddressApi` interface’inde tanımlanmış olmalıdır. Bu, Spring'te Interface-Implementation ilişkisini sağlar.

#### 2. **`ResponseEntity`:**
- **Açıklama:** `ResponseEntity`, HTTP yanıtlarını döndürmek için kullanılan bir sınıftır.
- Yanıtın durum kodu ve gövdesi gibi HTTP yanıtı ile ilgili tüm bilgileri içerir.
- **Anlamı:** Bu metod, HTTP yanıtı olarak bir liste döndürür (`List<AddressDto>`).
- Bu liste, Spring'in HTTP yanıtı olarak işleyebileceği şekilde paketlenir.
- Ayrıca, yanıt durum kodu olarak `HttpStatus.OK` (200) belirlenmiştir.
- **Kullanımı:** `ResponseEntity`, API yanıtının durum kodunu (`HttpStatus`), başlıklarını ve gövdesini kontrol etmek için güçlü bir yapı sağlar.
- Yanıtın gövdesi burada `iAddressService.addressServiceList()` tarafından sağlanan veri olacaktır.

#### 3. **`iAddressService.addressServiceList()`:**
- **Açıklama:** Bu, `iAddressService` adında bir servis tarafından sağlanan bir metottur.
- `addressServiceList()` metodu, adresleri listeleyen bir servis çağrısıdır.
- **Anlamı:** Bu servis çağrısı, adresleri (`AddressDto`) içeren bir liste döndürür ve bu liste API'ye yanıt olarak istemciye iletilir.
- **Kullanımı:** Servis katmanında iş mantığı genellikle burada yapılır.
- Bu, veritabanı veya başka bir kaynaktan verilerin alınmasını ve işlenmesini sağlar. Burada işlenen veri, API yanıtı olarak döndürülecektir.

### API’nin Nasıl Çalışacağı:
Bu metod, `http://localhost:4444/api/address/list` URL'sine yapılan GET isteklerini karşılar. Ancak bu

isteğin çalışabilmesi için birkaç koşul vardır:

1. **URL Parametresi:** İstek, `active=true` query parametresini içermelidir. Örneğin: `http://localhost:4444/api/address/list?active=true`.
2. **Başlıklar (Headers):** HTTP isteği, `X-API-VERSION: 1` başlığını içermelidir. Bu, API'nin doğru versiyonuna eriştiğinizi garanti eder.
3. **İçerik Tipi (Content-Type):** İstek verisi JSON formatında olmalıdır, yani `Content-Type: application/json` başlığı ile gönderilmelidir.
4. **Yanıt Formatı (Produces):** Yanıt JSON formatında döndürülecektir. İstemci, bu yanıtı alacaksa `Accept: application/json` başlığı ile çağrı yapabilir.

### Özet:
Bu API'nin GET metoduna gelen istek, belirli bir URL, query parametre, başlık ve içerik türü ile sınırlandırılmıştır.
Sadece `active=true` parametresi ile, `X-API-VERSION=1` başlığı ile ve `application/json` formatında gelen istekler işlenir.
Yanıt olarak JSON formatında bir `AddressDto` listesi döndürülür.
Bu yapı, API'nin versiyonlama, veri formatı yönetimi ve parametre kontrolü gibi gelişmiş özelliklerini kullanarak RESTful bir mimari sunar.

## @EnableWebMvc
---
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    // CORS yapılandırması
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Tüm URL'ler için geçerli
                .allowedOrigins("http://localhost:3000")  // İzin verilen köken
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // İzin verilen HTTP metodları
                .allowedHeaders("*");  // İzin verilen başlıklar
    }

    // Statik kaynaklar için yapılandırma
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")  // Kaynakların URL deseni
                .addResourceLocations("/public/", "classpath:/static/")  // Kaynakların yerleri
                .setCachePeriod(3600);  // Cache süresi (saniye)
    }

    // Interceptor eklemek için yapılandırma
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomInterceptor())  // CustomInterceptor sınıfı ile Interceptor eklenir
                .addPathPatterns("/api/**")  // Hangi URL deseninde geçerli olacağı
                .excludePathPatterns("/api/login", "/api/register");  // Hariç tutulacak URL desenleri
    }
}


Spring Boot'ta `WebConfig` sınıfı genellikle özel yapılandırmalar yapmak için kullanılır. Özellikle CORS yapılandırması, statik kaynakların yönetimi, `Interceptor` ekleme gibi çeşitli web ayarlarını özelleştirmek amacıyla tercih edilir. Aşağıda bir `WebConfig` örneği ve açıklamaları yer almaktadır:

### WebConfig Örneği

```java
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    // CORS yapılandırması
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Tüm URL'ler için geçerli
                .allowedOrigins("http://localhost:3000")  // İzin verilen köken
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // İzin verilen HTTP metodları
                .allowedHeaders("*");  // İzin verilen başlıklar
    }

    // Statik kaynaklar için yapılandırma
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")  // Kaynakların URL deseni
                .addResourceLocations("/public/", "classpath:/static/")  // Kaynakların yerleri
                .setCachePeriod(3600);  // Cache süresi (saniye)
    }

    // Interceptor eklemek için yapılandırma
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomInterceptor())  // CustomInterceptor sınıfı ile Interceptor eklenir
                .addPathPatterns("/api/**")  // Hangi URL deseninde geçerli olacağı
                .excludePathPatterns("/api/login", "/api/register");  // Hariç tutulacak URL desenleri
    }
}
```

### Açıklamalar:

1. **@Configuration**: Spring Boot'ta yapılandırma sınıflarını işaretler. `WebConfig`, Spring'e bu sınıfın yapılandırma amaçlı olduğunu söyler.

2. **@EnableWebMvc**: Bu anotasyon, Spring MVC'nin tam kontrolünü elde etmek için kullanılır. Ancak, Spring Boot varsayılan olarak birçok MVC ayarını otomatik olarak yapar. Bu nedenle, genellikle bu anotasyona ihtiyaç duyulmaz. Eğer manuel kontrol gerekiyorsa eklenir.

3. **addCorsMappings(CorsRegistry registry)**: Bu metot, Cross-Origin Resource Sharing (CORS) yapılandırması sağlar. Bu yapılandırmada:
    - `addMapping("/**")`: Tüm URL'ler için CORS kısıtlamalarını uygular.
    - `allowedOrigins("http://localhost:3000")`: Sadece `localhost:3000` kökeninden gelen istekleri kabul eder.
    - `allowedMethods("GET", "POST", "PUT", "DELETE")`: İzin verilen HTTP metodlarını tanımlar.
    - `allowedHeaders("*")`: Tüm başlıklara izin verir.

4. **addResourceHandlers(ResourceHandlerRegistry registry)**: Bu metot, statik kaynakların (CSS, JS, resimler vb.) nerede bulunduğunu ve bu kaynaklara nasıl erişileceğini tanımlar.
    - `addResourceHandler("/resources/**")`: `/resources/` ile başlayan URL'ler bu statik kaynaklara erişir.
    - `addResourceLocations("/public/", "classpath:/static/")`: Kaynakların dosya sisteminde ve classpath içinde nerede olduğunu belirtir.

5. **addInterceptors(InterceptorRegistry registry)**: Bu metot, istekleri işleme aşamasında öncesinde veya sonrasında ek davranışlar ekleyen Interceptor'lar tanımlar.
    - `addInterceptor(new CustomInterceptor())`: `CustomInterceptor` sınıfı ile bir Interceptor eklenir.
    - `addPathPatterns("/api/**")`: Bu Interceptor sadece `/api/` ile başlayan URL'lerde çalışır.
    - `excludePathPatterns("/api/login", "/api/register")`: `/api/login` ve `/api/register` URL'leri Interceptor'dan hariç tutulur.

Bu şekilde, Spring Boot projelerinizde CORS, statik kaynak yönetimi ve Interceptor'ları yönetebilirsiniz. `WebMvcConfigurer` arayüzü, bu yapılandırmaları yapmanıza imkan tanır.


`.setCachePeriod(3600)` metodu, statik kaynaklar için cache (önbellekleme) süresini saniye cinsinden ayarlayan bir işlevdir. Buradaki 3600 değeri, cache süresinin 3600 saniye, yani 1 saat olduğunu belirtir. Bu süre boyunca tarayıcı veya istemci, statik kaynakları (örneğin CSS, JavaScript, resim dosyaları gibi) yeniden indirmek yerine önbellekten kullanır.

Önbellekleme, sunucu üzerindeki yükü azaltmak ve uygulamanın performansını artırmak için kullanılır. Statik kaynaklar sık sık değişmez, bu yüzden istemcilerin her seferinde sunucudan bu dosyaları indirmesine gerek yoktur. Önbellekleme süresi şu anlama gelir:

- **Cache süresi dolmadan**: İstemci (tarayıcı gibi), kaynağı tekrar sunucudan talep etmez, bunun yerine daha önce aldığı ve önbelleğe kaydettiği versiyonu kullanır.
- **Cache süresi dolduktan sonra**: İstemci, kaynağın güncellenmiş olup olmadığını kontrol etmek için sunucuya yeni bir talep gönderir.

Örneğin, `.setCachePeriod(3600)` kullanıldığında, istemci bir CSS dosyasını ilk defa aldığında, bu dosya 1 saat boyunca istemcinin cache belleğinde tutulur ve bu süre dolmadan sunucuya tekrar bu dosya için istek göndermez.

Bu yöntem özellikle büyük dosyalar ve sık güncellenmeyen statik içerikler için faydalıdır, çünkü istemciler sunucudan gereksiz yere veri indirmez ve böylece uygulamanızın performansı artar.


`public void addResourceHandlers(ResourceHandlerRegistry registry)` metodu, Spring Boot'ta statik kaynakların (CSS, JavaScript, resim dosyaları vb.) nasıl yönetileceğini ve nerede bulunacağını yapılandırmak için kullanılan bir metottur. Bu metot, Spring MVC'nin varsayılan olarak sağladığı statik kaynak yönetimini özelleştirmemizi sağlar.

### Kullanım Amacı
Bu metot ile uygulamanızın kaynaklarının nerede yer aldığını ve bu kaynaklara nasıl erişileceğini belirleyebilirsiniz. Statik kaynaklar genellikle `src/main/resources/static` dizininde tutulur. Ancak, bu dizini değiştirmek, farklı dizinler eklemek veya önbellekleme ayarları gibi ek yapılandırmalar yapmak istediğinizde `addResourceHandlers` metodunu kullanabilirsiniz.

### Parametre: `ResourceHandlerRegistry`
`ResourceHandlerRegistry`, statik kaynakların tanımlandığı bir yapılandırma aracıdır. Bu parametre ile Spring MVC'ye hangi URL desenlerine karşı hangi kaynakların sunulacağını belirleriz.

### Örnek

```java
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**")  // URL deseni
            .addResourceLocations("classpath:/static/", "/public/")  // Kaynakların konumları
            .setCachePeriod(3600);  // Önbellekleme süresi (saniye)
}
```

### Açıklamalar:

1. **`addResourceHandler("/resources/**")`**: Bu, URL desenini belirtir. Yani uygulamanızda `/resources/` ile başlayan herhangi bir URL, tanımladığınız kaynak dosyalarına yönlendirilecektir. Örneğin, `/resources/css/style.css` gibi bir URL bu yapılandırmaya uygun olacaktır.

2. **`addResourceLocations("classpath:/static/", "/public/")`**: Bu metot, kaynak dosyalarının yerini tanımlar. Burada iki farklı kaynak dizini belirtilmiş:
    - `classpath:/static/`: Bu, `src/main/resources/static/` dizinini ifade eder. Spring Boot projelerinde genellikle statik dosyalar burada tutulur.
    - `/public/`: Bu da proje klasörünüzdeki bir dizini ifade eder. Eğer dosyalarınız `public` klasöründe bulunuyorsa, buraya erişim de sağlar.

3. **`setCachePeriod(3600)`**: Bu, yukarıda açıkladığımız gibi, kaynakların istemci tarafında ne kadar süreyle önbellekte saklanacağını (saniye cinsinden) belirler. 3600 saniye, yani 1 saat önbellekleme süresi sağlar.

### Bu Yapılandırmanın Avantajları
- **Statik dosya erişimini özelleştirme**: Varsayılan dizinlerin dışında, farklı dizinlerden de statik kaynakları sunabilirsiniz.
- **Önbellekleme**: Performansı artırmak için istemcinin statik dosyaları önbelleğe almasını sağlayabilirsiniz.
- **Farklı yollar tanımlama**: Farklı URL desenleriyle farklı kaynakları yönetebilir, proje düzeninizi daha esnek hale getirebilirsiniz.

### Ne Zaman Kullanılır?
- Statik kaynakları varsayılan dizin dışına taşımak veya başka bir dizinden sunmak istiyorsanız.
- Önbellekleme ayarlarını kontrol etmek istiyorsanız.
- Birden fazla kaynak dizinini yapılandırmanız gerekiyorsa.
- Özel URL desenleri ile statik kaynaklara erişimi ayarlamak istiyorsanız.

Bu metodun Spring MVC'deki temel rolü, uygulamanızın statik dosyalarını daha esnek bir şekilde yönetmenize yardımcı olmaktır.


`addInterceptors(InterceptorRegistry registry)` metodu, Spring Boot'ta istekleri karşılamadan önce veya sonra ek işlemler gerçekleştirmek için **Interceptor**'ları yapılandırmak amacıyla kullanılır. Interceptor'lar, web uygulamalarındaki HTTP isteklerinin giriş ve çıkışında ek işlemler yapabilen sınıflardır. Özellikle kimlik doğrulama, yetkilendirme, loglama, performans izleme gibi işlemler için kullanılırlar.


## Spring Api CrossOrigin
```sh 

```
---

`@CrossOrigin` Spring Boot'ta bir anotasyon olup, **Cross-Origin Resource Sharing (CORS)** ile ilgili ayarları yönetmek için kullanılır. CORS, bir kaynağın (örneğin, bir API'nin) başka bir alan adı (domain) üzerindeki istemciler tarafından kullanılmasına izin verip vermeyeceğini belirleyen bir güvenlik mekanizmasıdır.

Tarayıcılar, bir web sayfasının başka bir alan adından veri istemesine normalde izin vermezler (aynı kaynaktan gelmeyen istekler kısıtlanır). Ancak bazı durumlarda bir web uygulamasının, başka bir alan adındaki bir API'den veri çekmesi gerekebilir. İşte burada **CORS** devreye girer ve bu isteklere izin verilip verilmeyeceğini belirler.

### `@CrossOrigin` Anotasyonu Nedir?
`@CrossOrigin`, Spring Boot'ta CORS ayarlarını yapılandırmak için kullanılan bir anotasyondur. Bu anotasyon, belirli bir API veya tüm uygulama genelinde başka bir alan adından gelen isteklere izin vermek için kullanılır.

### Kullanımı

1. **Bir Denetleyici Seviyesinde (Controller Level)**:
   Bir denetleyicinin (controller) tüm yöntemlerine başka bir alan adından gelen isteklere izin vermek için bu anotasyon kullanılabilir.

   ```java
   @RestController
   @CrossOrigin(origins = "http://example.com")
   public class MyController {

       @GetMapping("/data")
       public String getData() {
           return "Cross-origin data";
       }
   }
   ```

   Bu örnekte, `http://example.com` alan adından gelen istekler `getData()` yöntemine erişebilir. Eğer `origins` parametresi belirtilmezse, tüm alan adlarına izin verilir.

2. **Yöntem Seviyesinde (Method Level)**:
   Sadece belirli bir yöntem için CORS ayarlarını uygulamak isterseniz, bunu yöntem seviyesinde kullanabilirsiniz.

   ```java
   @RestController
   public class MyController {

       @CrossOrigin(origins = "http://example.com")
       @GetMapping("/restricted-data")
       public String getRestrictedData() {
           return "Restricted cross-origin data";
       }
   }
   ```

   Bu durumda, sadece `http://example.com` alan adından gelen istekler `getRestrictedData()` metoduna erişebilir.

### `@CrossOrigin` Anotasyonunun Parametreleri

1. **`origins`**:
   İsteklerin kabul edileceği alan adlarını belirtir. Bir veya birden fazla alan adı ekleyebilirsiniz. Varsayılan olarak, tüm alan adlarına (`*`) izin verilir.

   ```java
   @CrossOrigin(origins = {"http://example.com", "http://another-domain.com"})
   ```

2. **`methods`**:
   Hangi HTTP yöntemlerinin (GET, POST, PUT, DELETE vs.) izin verileceğini belirtir. Eğer belirtilmezse, varsayılan olarak tüm yöntemlere izin verilir.

   ```java
   @CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST})
   ```

3. **`allowedHeaders`**:
   İzin verilen başlıkları belirtir. Varsayılan olarak, tüm başlıklara izin verilir.

   ```java
   @CrossOrigin(allowedHeaders = {"Content-Type", "Authorization"})
   ```

4. **`exposedHeaders`**:
   Tarayıcıya açığa çıkarılacak başlıkları belirtir. Varsayılan olarak, CORS başlıkları tarayıcıya açılmaz.

   ```java
   @CrossOrigin(exposedHeaders = {"X-Custom-Header"})
   ```

5. **`allowCredentials`**:
   Kimlik doğrulama bilgileri (çerezler gibi) gönderilip gönderilmeyeceğini belirtir. Varsayılan olarak `false`'tur.

   ```java
   @CrossOrigin(allowCredentials = "true")
   ```

6. **`maxAge`**:
   Tarayıcının, bu ayarların geçerliliğini önbelleğe alacağı süreyi (saniye cinsinden) belirtir. Varsayılan olarak `1800` (30 dakika)'dır.

   ```java
   @CrossOrigin(maxAge = 3600)
   ```

### Global CORS Yapılandırması
Sadece belirli denetleyicilere değil, uygulamanın tamamına CORS yapılandırmasını eklemek için `WebMvcConfigurer` arabirimi kullanılır.

```java
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://example.com")
                .allowedMethods("GET", "POST")
                .allowedHeaders("Content-Type")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
```

Bu yapılandırma ile, uygulamanın tüm yollarına (`/**`) `http://example.com` alan adından gelen GET ve POST isteklerine izin verilir.

### Özetle:
- `@CrossOrigin` anotasyonu, Spring Boot uygulamanızda farklı alan adlarından gelen istekleri kabul etmek için kullanılır.
- Bu anotasyon ile belirli API'ler için CORS politikası belirlenebilir.
- `origins`, `methods`, `allowedHeaders`, `exposedHeaders`, `allowCredentials`, ve `maxAge` gibi parametrelerle daha ince ayarlar yapabilirsiniz.

CORS politikalarını doğru ayarlamak, güvenlik açısından kritik olabilir. Uygulamanızın dışarıya açık alan adlarından gelen istekleri ne zaman ve nasıl kabul edeceğini dikkatli bir şekilde belirlemelisiniz.

## CORS DEVAM
```java
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://example.com")
                .allowedMethods("GET", "POST")
                .allowedHeaders("Content-Type")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
```
Bu kod parçası, Spring Boot'ta **CORS (Cross-Origin Resource Sharing)** yapılandırmasını yönetmek için kullanılan bir sınıfı gösterir. Spring Boot uygulamalarında farklı alan adlarından gelen istekleri yönetmek için CORS yapılandırması yapmak gerekebilir ve bu yapılandırma `WebMvcConfigurer` arayüzü kullanılarak sağlanır. Kod parçasını detaylıca açıklayalım:


## Spring Api @PathVaraible ile @RequestParam
```sh 

```
---


## Spring Api @PathVaraible ile @RequestParam
```sh 
### **Spring API'de `@RequestParam` ve `@PathVariable` Arasındaki Farklar**

Spring Framework'te API geliştirme sırasında sıkça kullanılan `@RequestParam` ve `@PathVariable`, istemci tarafından gönderilen verileri işlemek için kullanılır. Her iki anotasyonun da benzer işlevleri vardır, ancak kullanıldıkları yerler ve veri alma yöntemleri farklıdır. Bu iki anotasyonu ayrıntılı olarak inceleyelim.

---

### **1. `@RequestParam`**

#### **Nedir?**
- `@RequestParam`, **HTTP request**'in **query parameters** kısmındaki verileri almak için kullanılır.
- İstemci tarafında, genellikle `?param=value` formatında gönderilen verilerle çalışır.
- URL'deki parametrelerin adıyla eşleşen bir Java değişkenine veriyi aktarır.

#### **Kullanım**
- Kullanıcıdan gelen sorgu parametrelerini yakalamak için kullanılır.
- Örneğin, aşağıdaki gibi bir URL’den parametreleri alır:
  ```
GET /api/products?category=electronics&page=2
  ```

**Örnek Kod:**
```java
@GetMapping("/api/products")
public List<Product> getProducts(@RequestParam String category, @RequestParam int page) {
    // 'category' ve 'page' parametreleri URL'den alınır.
    return productService.getProductsByCategory(category, page);
}
```

**Örnek Request:**
```
GET /api/products?category=electronics&page=2
```

**Sonuç:**
- `category = "electronics"`
- `page = 2`

---

#### **Özellikleri**
1. **Varsayılan Değer Atama (`defaultValue`):**
    - Parametre eksik gönderildiğinde bir varsayılan değer kullanılabilir.
   ```java
   @GetMapping("/api/products")
   public List<Product> getProducts(@RequestParam(defaultValue = "all") String category) {
       return productService.getProductsByCategory(category);
   }
   ```
   **Örnek:**
   ```
   GET /api/products
   ```
   Sonuç: `category = "all"`

2. **Zorunluluk Kontrolü (`required`):**
    - Parametrenin istekte yer alması zorunlu mu değil mi belirlenebilir.
    - Varsayılan: `required = true`.
   ```java
   @GetMapping("/api/products")
   public List<Product> getProducts(@RequestParam(required = false) String category) {
       return productService.getProductsByCategory(category);
   }
   ```

3. **Çoklu Parametre Alma:**
    - Birden fazla aynı isimli parametre varsa, `List` veya `Array` olarak alabilirsiniz.
   ```java
   @GetMapping("/api/products")
   public List<Product> getProducts(@RequestParam List<String> categories) {
       return productService.getProductsByCategories(categories);
   }
   ```
   **Örnek:**
   ```
   GET /api/products?categories=electronics&categories=furniture
   ```
   Sonuç: `categories = ["electronics", "furniture"]`

4. **Tür Dönüşümü:**
    - `@RequestParam`, temel veri türleri (String, int, boolean vb.) ve özelleştirilmiş türlere otomatik dönüşüm yapar.

---

### **2. `@PathVariable`**

#### **Nedir?**
- `@PathVariable`, **URL’nin path (yol)** kısmındaki değişkenleri almak için kullanılır.
- İstemci tarafından gönderilen değer, genellikle URL'nin bir parçası olarak gönderilir:
  ```
  GET /api/products/{id}
  ```

#### **Kullanım**
- Genellikle, bir kaynağa özgü işlemleri gerçekleştirmek için kullanılır.
- Örneğin, bir ürünün ID’sine göre detaylarını almak.

**Örnek Kod:**
```java
@GetMapping("/api/products/{id}")
public Product getProductById(@PathVariable Long id) {
    // 'id' değişkeni URL'den alınır.
    return productService.getProductById(id);
}
```

**Örnek Request:**
```
GET /api/products/42
```

**Sonuç:**
- `id = 42`

---

#### **Özellikleri**
1. **URL'deki Dinamik Değerleri Alma:**
    - Path değişkenlerini URL’nin belirli bir kısmından alır.
   ```java
   @GetMapping("/api/orders/{orderId}/items/{itemId}")
   public OrderItem getOrderItem(@PathVariable Long orderId, @PathVariable Long itemId) {
       return orderService.getOrderItem(orderId, itemId);
   }
   ```

2. **Çoklu Parametre Kullanımı:**
    - Aynı endpoint üzerinde birden fazla `@PathVariable` kullanılabilir.
      **Örnek:**
   ```
   GET /api/orders/123/items/456
   ```
   Sonuç: `orderId = 123`, `itemId = 456`

3. **Tür Dönüşümü:**
    - Path değişkeni, String olarak gelir ve otomatik olarak belirtilen veri türüne dönüştürülür.
   ```java
   @GetMapping("/api/products/{id}")
   public Product getProduct(@PathVariable("id") Integer productId) {
       return productService.getProductById(productId);
   }
   ```

4. **İsim Eşleşmesi:**
    - Değişken ismi, metodun parametresi ile eşleşmiyorsa `@PathVariable("name")` ile açıkça belirtilir.

---

### **@RequestParam ve @PathVariable Karşılaştırması**

| **Özellik**                | **@RequestParam**                                                                                                                                                              | **@PathVariable**                                                                                              |
|----------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|
| **Kullanıldığı Yer**        | Query parametrelerini almak için kullanılır (`?key=value`).                                                                                                                  | URL path değişkenlerini almak için kullanılır (`/path/{value}`).                                              |
| **Kullanım Türü**           | İsteğe bağlı parametreler için uygundur.                                                                                                                                      | Zorunlu (mandatory) parametreler için uygundur.                                                               |
| **Özellikler**              | Varsayılan değer atama, çoklu parametre alma, zorunluluk kontrolü yapılabilir.                                                                                               | Daha dinamik URL yapıları için uygundur.                                                                      |
| **Tür Dönüşümü**            | Temel veri türleri ve özelleştirilmiş türlere otomatik dönüşüm yapar.                                                                                                         | Benzer şekilde temel veri türleri ve özelleştirilmiş türlere otomatik dönüşüm yapar.                           |
| **Performans**              | Query string'e dayandığı için URL daha uzun olabilir, ancak daha esnek bir kullanım sunar.                                                                                   | URL path'e dayandığı için daha kısa ve okunabilir bir URL yapısı sağlar.                                       |
| **Örnek URL**               | `/api/products?category=electronics&page=2`                                                                                                                                 | `/api/products/42`                                                                                           |
| **Zorunluluk**              | Parametreler isteğe bağlı olabilir (`required = false`).                                                                                                                     | Path değişkenleri genellikle zorunludur.                                                                      |

---

### **Hangi Durumda Hangisi Kullanılır?**

- **`@RequestParam` Kullanımı:**
    - Birden fazla isteğe bağlı parametre gerektiğinde.
    - Filtreleme veya sıralama gibi sorgu işlemleri yapılacaksa.
    - Örneğin:
      ```
      GET /api/products?category=electronics&sort=asc
      ```

- **`@PathVariable` Kullanımı:**
    - Belirli bir kaynağa erişim gerekiyorsa.
    - Daha temiz ve RESTful bir URL yapısı oluşturulacaksa.
    - Örneğin:
      ```
      GET /api/products/42
      ```

---

### **Gerçek Hayat Senaryosu**

#### **Karma Kullanım Örneği:**
```java
@GetMapping("/api/orders/{orderId}")
public Order getOrderDetails(
    @PathVariable Long orderId,
    @RequestParam(required = false, defaultValue = "false") boolean includeItems) {
    if (includeItems) {
        return orderService.getOrderWithItems(orderId);
    } else {
        return orderService.getOrder(orderId);
    }
}
```

**Örnek İstekler:**
1. **Sipariş Detayları Alma:**
   ```
   GET /api/orders/123
   ```
   Sonuç: Sadece sipariş bilgisi.

2. **Sipariş Detayları ve Öğeler:**
   ```
   GET /api/orders/123?includeItems=true
   ```
   Sonuç: Sipariş bilgisi ve tüm öğeler.

---

### **Sonuç**
- **`@RequestParam`**, esnek sorgu parametreleri için kullanılır.
- **`@PathVariable`**, belirli bir kaynağa dinamik erişim sağlamak için uygundur.
- RESTful bir API geliştirme sırasında bu iki anotasyonu birlikte kullanarak hem okunabilir hem de esnek bir yapı oluşturabilirsiniz.
```
---



## Spring Boot
```sh 

```
---

ModelMapper, Java tabanlı uygulamalarda veri nesneleri (model sınıfları) arasındaki dönüşüm işlemlerini kolaylaştıran bir kütüphanedir. Özellikle DTO (Data Transfer Object) ve Entity sınıfları arasındaki veri aktarımını otomatikleştirerek, kod tekrarını azaltır ve uygulamaların daha temiz, sürdürülebilir hale gelmesini sağlar. DTO ve Entity nesneleri, genellikle veri tabanıyla iletişim kuran veya kullanıcı arayüzüne sunulan farklı veri yapılarında temsil edilir. Bu nesneler arasında veri aktarımı gerektiren durumlarda, ModelMapper otomatik olarak gerekli eşleştirmeleri yapar.

### ModelMapper’ın Kullanım Amacı ve Faydaları

1. **Kod Tekrarını Azaltır**: DTO ve Entity sınıfları arasında veri aktarımı yaparken her iki sınıfın alanlarını manuel olarak eşleştirmek gerekir. ModelMapper, bu eşleştirmeyi otomatik hale getirerek kod tekrarını azaltır.

2. **Daha Temiz ve Yönetilebilir Kod**: Otomatik eşleştirme sayesinde veri dönüştürme işlemleri daha temiz bir kod yapısı içinde yürütülür. Bu, özellikle büyük projelerde yönetilebilirliği artırır.

3. **Hızlı Geliştirme**: ModelMapper, eşleştirmeleri otomatik olarak gerçekleştirdiğinden, veri dönüşüm işlemleri daha hızlı yapılır ve geliştirme süreci kısalır.

4. **Esneklik ve Özelleştirilebilirlik**: ModelMapper, belirli alanlarda manuel eşleştirme ve özelleştirme yapmayı da destekler. Özel gereksinimlere göre eşleştirme kuralları tanımlanabilir.

### ModelMapper’ın Temel Özellikleri

ModelMapper, özellikle alan adları aynı olan sınıflar arasında otomatik eşleştirme yapması ile bilinir. Bu eşleştirme sürecinde, kaynak (source) nesne ile hedef (destination) nesne arasındaki alanların isimleri ve türleri eşleştirilir. ModelMapper, aynı zamanda karmaşık nesne yapıları ve özel dönüşümler için de geniş bir yapılandırma desteği sunar.

- **Otomatik Eşleştirme (Implicit Mapping)**: Alan adları aynı olan sınıflar arasındaki eşleştirmeleri otomatik olarak yapar.
- **Özelleştirilmiş Eşleştirme (Explicit Mapping)**: Belirli alanlar için özel dönüşüm kuralları belirlenebilir.
- **Derin Kopyalama (Deep Copy)**: Nesneler içindeki alt nesneleri de otomatik olarak eşleştirir ve derin kopyalama yapar.
- **Koleksiyon Eşleştirme**: Listeler ve diğer koleksiyon türleri arasındaki eşleştirmeleri destekler.
- **Koşullu Eşleştirme**: Belirli koşullara göre eşleştirme kuralları tanımlanabilir.

### ModelMapper Kullanımı

ModelMapper kullanmak için `ModelMapper` sınıfının bir örneğini oluşturmak ve `map` metodunu çağırarak kaynak nesneyi hedef nesneye dönüştürmek yeterlidir. Aşağıda basit bir örnek gösterilmektedir.

#### Basit Bir ModelMapper Örneği

Örneğin, `User` ve `UserDTO` adlı iki sınıfımız olduğunu düşünelim. `User` sınıfı veri tabanıyla ilişkili bir `Entity` iken, `UserDTO` sınıfı kullanıcı arayüzünde kullanılan bir veri taşıma nesnesidir.

```java
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    // Getter ve Setter metotları
}

public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    // Getter ve Setter metotları
}
```

Bu iki sınıf arasında veri dönüşümü yapmak için ModelMapper kullanabiliriz:

```java
ModelMapper modelMapper = new ModelMapper();
User user = new User(1L, "John", "Doe", "john.doe@example.com");
UserDTO userDTO = modelMapper.map(user, UserDTO.class);

System.out.println("DTO First Name: " + userDTO.getFirstName());
System.out.println("DTO Email: " + userDTO.getEmail());
```

Bu örnekte `user` nesnesinin tüm alanları otomatik olarak `userDTO` nesnesine aktarılır. ModelMapper, alan adları aynı olduğu sürece, nesneler arasındaki tüm veriyi sorunsuz bir şekilde eşleştirir.

### Özelleştirilmiş Eşleştirme

ModelMapper, özel dönüşüm kuralları tanımlamak için geniş bir yapılandırma desteği sunar. Özellikle alan adları farklı olan sınıflar veya karmaşık nesne yapıları arasında dönüşüm yapılması gerektiğinde, eşleştirme kuralları belirlemek gerekir.

#### Farklı Alan Adları İçin Eşleştirme

Örneğin, `User` sınıfındaki `firstName` alanını `UserDTO` sınıfında `name` olarak adlandırdığımızı düşünelim. Bu durumda, ModelMapper’a `firstName` alanını `name` alanına eşleştirmesini manuel olarak söylememiz gerekir.

```java
ModelMapper modelMapper = new ModelMapper();
modelMapper.typeMap(User.class, UserDTO.class).addMappings(mapper -> 
    mapper.map(User::getFirstName, UserDTO::setName));

User user = new User(1L, "John", "Doe", "john.doe@example.com");
UserDTO userDTO = modelMapper.map(user, UserDTO.class);

System.out.println("DTO Name: " + userDTO.getName());
```

Bu yapılandırmada, `User` sınıfındaki `firstName` alanı `UserDTO` sınıfındaki `name` alanına eşleştirilir. `addMappings` metodu ile özel eşleştirme kuralları belirleyebiliriz.

### Koleksiyon Eşleştirme

ModelMapper, koleksiyon türlerini de dönüştürebilir. Özellikle listeler arasındaki dönüşüm işlemleri, büyük veri setlerinde sıklıkla ihtiyaç duyulan bir özelliktir.

```java
List<User> userList = Arrays.asList(new User(1L, "John", "Doe", "john@example.com"),
                                    new User(2L, "Jane", "Doe", "jane@example.com"));

Type listType = new TypeToken<List<UserDTO>>() {}.getType();
List<UserDTO> userDTOList = modelMapper.map(userList, listType);

userDTOList.forEach(userDTO -> System.out.println("DTO Name: " + userDTO.getFirstName()));
```

Bu örnekte, `User` nesnelerinden oluşan bir liste `UserDTO` nesnelerinden oluşan bir listeye dönüştürülmüştür.

### Derin Kopyalama (Deep Copy)

ModelMapper, nesneler arasındaki alt nesneleri de eşleştirerek derin kopyalama yapabilir. Örneğin, `Address` sınıfına sahip bir `User` nesnesinin `UserDTO` nesnesine dönüştürülmesi durumunda, `Address` nesnesi de otomatik olarak eşleştirilir.

```java
public class User {
    private Long id;
    private String firstName;
    private Address address;
    // Getter ve Setter metotları
}

public class UserDTO {
    private Long id;
    private String firstName;
    private AddressDTO address;
    // Getter ve Setter metotları
}

public class Address {
    private String street;
    private String city;
    // Getter ve Setter metotları
}

public class AddressDTO {
    private String street;
    private String city;
    // Getter ve Setter metotları
}

ModelMapper modelMapper = new ModelMapper();
User user = new User(1L, "John", new Address("Main St", "New York"));
UserDTO userDTO = modelMapper.map(user, UserDTO.class);

System.out.println("DTO City: " + userDTO.getAddress().getCity());
```

Bu örnekte, `User` nesnesindeki `Address` nesnesi otomatik olarak `UserDTO` nesnesindeki `AddressDTO` nesnesine dönüştürülür.

### Koşullu Eşleştirme

ModelMapper, belirli bir koşula göre eşleştirme yapılmasına da olanak tanır. Örneğin, belirli bir alanın boş olmaması durumunda eşleştirme yapılmasını isteyebiliriz.

```java
modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
```

Bu ayar ile, sadece `null` olmayan alanlar eşleştirilir. Bu sayede kaynak nesnedeki boş alanların hedef nesneye aktarılması engellenir.

### ModelMapper ile DTO ve Entity Arasındaki Dönüşümün Avantajları ve Dezavantajları

**Avantajları**:

- **Kod Basitleştirir**: Dönüşüm işlemleri için yazılması gereken kod miktarını azaltır.
- **Esnek ve Güçlü Yapılandırma**: Farklı durumlara göre özelleştirme yapılabilir.
- **Koleksiyon Eşleştirme**: Listeler ve diğer koleksiyon türleri için dönüşüm işlemlerini kolaylaştırır.
- **Test Edilebilirlik**: DTO ve Entity arasında dönüşüm işlemleri standart hale geldi
  ği için daha test edilebilir bir yapı sunar. Örneğin, tüm dönüşümler ModelMapper aracılığıyla yapıldığından, dönüşüm sürecinin doğru çalışıp çalışmadığı tek bir noktada test edilebilir.

**Dezavantajları**:

- **Performans Maliyeti**: Özellikle büyük veri setlerinde otomatik dönüşüm işlemleri performans açısından maliyetli olabilir. Bu durumda, ModelMapper yerine manuel dönüşüm yöntemleri tercih edilebilir.
- **Öğrenme Eğrisi**: ModelMapper’ın tüm özelliklerini verimli kullanabilmek için bir miktar öğrenme süreci gerekebilir. Özellikle karmaşık nesne yapıları ve özelleştirilmiş dönüşümler için ayrıntılı bilgiye ihtiyaç duyulabilir.
- **Gereksiz Eşleştirmeler**: ModelMapper, tüm alanları eşleştirmeye çalıştığı için bazı durumlarda gereksiz eşleştirmeler yapılabilir. Bu durumda belirli alanları hariç tutmak gerekebilir.

### ModelMapper’ın Alternatifleri ve Karşılaştırma

ModelMapper, Java dünyasında popüler bir kütüphane olmakla birlikte, aynı işlevi gören bazı alternatifleri de vardır. Bu alternatifler arasında Dozer, MapStruct ve Orika gibi kütüphaneler öne çıkar.

- **MapStruct**: ModelMapper’dan farklı olarak derleme zamanında (compile-time) dönüşüm işlemlerini gerçekleştirir. Bu sayede daha hızlı çalışır, çünkü dönüşüm işlemleri çalışma zamanında yapılmaz. Özellikle büyük projelerde performans avantajı sağlar.
- **Dozer**: Dozer de otomatik eşleştirme yapabilen bir kütüphanedir ancak ModelMapper kadar esnek yapılandırma sunmaz.
- **Orika**: Orika, büyük veri setleri için optimize edilmiştir ve hızlı dönüşüm işlemleri yapabilir.

ModelMapper, özellikle kullanım kolaylığı ve esnek yapılandırma seçenekleri sayesinde küçük ve orta ölçekli projelerde daha sık tercih edilirken, MapStruct performans avantajı sayesinde büyük projelerde daha yaygın olarak kullanılır.

### ModelMapper Yapılandırma Özellikleri

ModelMapper’ın sunduğu bazı yapılandırma özellikleri şunlardır:

1. **Eşleştirme Stratejileri**: Eşleştirme stratejileri, ModelMapper’ın nasıl çalışacağını belirler. Örneğin, standart eşleştirme stratejisi `STANDARD` iken, daha esnek bir eşleştirme için `LOOSE` stratejisi kullanılabilir. `LOOSE` stratejisi, küçük farklılıkları göz ardı ederek eşleştirme yapmaya çalışır.

    ```java
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    ```

2. **Boş Alanları Hariç Tutma**: Boş (null) değerleri eşleştirme işleminden hariç tutmak için `setPropertyCondition` yapılandırması kullanılabilir.

    ```java
    modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
    ```

3. **Karmaşık Eşleştirme**: Karmaşık nesne yapıları için `TypeMap` kullanılarak daha ayrıntılı dönüşüm kuralları oluşturulabilir.

    ```java
    TypeMap<User, UserDTO> typeMap = modelMapper.createTypeMap(User.class, UserDTO.class);
    typeMap.addMappings(mapper -> mapper.map(src -> src.getAddress().getCity(), UserDTO::setCity));
    ```

Bu örnekte, `User` nesnesindeki `address.city` alanı `UserDTO` nesnesindeki `city` alanına eşleştirilmektedir.

### Spring Boot ile ModelMapper Entegrasyonu

Spring Boot projelerinde ModelMapper kullanımı oldukça yaygındır. ModelMapper, Spring konteynerına bir `@Bean` olarak eklenir ve proje genelinde kullanılabilir hale getirilir.

```java
@Configuration
public class ModelMapperConfig {
    
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
```

Bu yapılandırma ile `ModelMapper` nesnesi `@Autowired` anotasyonu ile diğer sınıflara enjekte edilebilir. Bu sayede, uygulamanın farklı katmanlarında dönüşüm işlemleri için ModelMapper kolayca kullanılabilir.

```java
@Service
public class UserService {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO convertToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User convertToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
```

Bu yapılandırma sayesinde, `UserService` sınıfı içinde `convertToDto` ve `convertToEntity` metotları ile `User` ve `UserDTO` arasında dönüşüm işlemleri kolayca yapılabilir.

### Sonuç

ModelMapper, Java tabanlı uygulamalarda veri transfer nesneleri (DTO) ve veri tabanı nesneleri (Entity) arasındaki dönüşüm işlemlerini kolaylaştırmak için güçlü ve esnek bir araçtır. Otomatik eşleştirme, derin kopyalama, koşullu eşleştirme gibi özellikleriyle veri dönüşümlerini hızlı, kolay ve sürdürülebilir hale getirir. Kod tekrarını azaltarak daha temiz ve yönetilebilir bir kod yapısı sağlar.

ModelMapper, özellikle veri modelleme ve DTO katmanının yoğun olarak kullanıldığı projelerde tercih edilir. Ancak büyük projelerde performans kaygıları olan durumlarda alternatif kütüphaneler de değerlendirilmelidir. Spring Boot ile entegre edilmesi kolaydır ve Spring konteynerında bir `@Bean` olarak tanımlanarak proje genelinde kullanılabilir.

Detaylı veya özel dönüşüm senaryolarında ModelMapper’ın sunduğu yapılandırma özelliklerinden faydalanarak karmaşık veri modelleri arasında hızlı dönüşümler gerçekleştirilebilir. ModelMapper’ın sağladığı esneklik, özelleştirilebilirlik ve basit kullanımı, onu Java ekosistemindeki popüler araçlardan biri yapmaktadır.



## Spring Boot
```sh 

```
---


ModelMapper kullanırken dikkat etmeniz gereken bazı kurallar ve en iyi uygulamalar vardır. Bu kurallar, ModelMapper’ın performansını optimize etmek, dönüşüm sürecini hatasız ve daha anlaşılır hale getirmek için önemlidir. İşte dikkat edilmesi gereken bazı temel kurallar:

### 1. **Matching Strategy (Eşleştirme Stratejisi) Seçimine Dikkat Edin**
- ModelMapper, varsayılan olarak `STANDARD` eşleştirme stratejisini kullanır. Bu strateji, alan adlarının tamamen eşleşmesini bekler ve küçük harf-farklılıklarını veya alt sınıf yapıları göz ardı etmez.
- Eğer alan adlarında küçük farklılıklar varsa veya daha esnek bir eşleştirme gerekiyorsa `LOOSE` stratejisini kullanabilirsiniz. Ancak `LOOSE` stratejisi daha esnektir ve yanlış eşleştirme yapma ihtimali daha yüksektir.
- Öneri: Mümkünse `STRICT` veya `STANDARD` stratejisini kullanarak eşleştirme doğruluğunu artırın.

   ```java
   modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
   ```

### 2. **Boş (null) Alanları Hariç Tutma**
- Varsayılan olarak, ModelMapper tüm alanları eşleştirmeye çalışır. Ancak bazı durumlarda, `null` olan alanları hedef nesneye taşımak istemeyebilirsiniz. Örneğin, güncelleme işlemlerinde boş alanların eski değerleri değiştirmemesi gerekebilir.
- `isNotNull` koşulunu kullanarak `null` değerleri hariç tutabilirsiniz.

   ```java
   modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
   ```

### 3. **Eşleştirilecek Alanların Adlarının Tutarlı Olmasına Özen Gösterin**
- ModelMapper, alan adlarını temel alarak otomatik eşleştirme yapar. Bu yüzden kaynak (source) ve hedef (destination) nesneler arasındaki alan adlarının tutarlı olması önemlidir.
- Farklı adlandırılmış alanlar arasında eşleştirme yapmanız gerektiğinde, `TypeMap` veya `addMappings` kullanarak özelleştirme yapabilirsiniz.

   ```java
   modelMapper.typeMap(User.class, UserDTO.class).addMappings(mapper -> 
       mapper.map(User::getFirstName, UserDTO::setName));
   ```

### 4. **Karmaşık ve Büyük Nesneler İçin Eşleştirmeyi Basitleştirin**
- Büyük nesneler ve çok katmanlı yapılar ModelMapper ile eşleştirildiğinde performans sorunları yaşanabilir. Bu durumda yalnızca ihtiyacınız olan alanları eşleştirmeye özen gösterin.
- Özellikle karmaşık nesne yapılarında, alt nesneler arasında yapılan derin kopyalama işlemleri (deep copy) performans kaybına yol açabilir. Gereksiz eşleştirmelerden kaçının.

### 5. **Koleksiyonlar İçin Tür Belirlemesi Yapın**
- ModelMapper, koleksiyon türleri arasında dönüşüm yaparken tür bilgisine ihtiyaç duyar. Koleksiyonlar için dönüşüm yaparken tür bilgilerini `TypeToken` ile belirtin.
- Örneğin, `List<User>` nesnesini `List<UserDTO>` nesnesine dönüştürmek için `TypeToken` kullanmak önemlidir.

   ```java
   Type listType = new TypeToken<List<UserDTO>>() {}.getType();
   List<UserDTO> userDTOList = modelMapper.map(userList, listType);
   ```

### 6. **DTO ve Entity Sınıflarında Fazla Alan Kullanmayın**
- DTO (Data Transfer Object) ve Entity sınıflarında yalnızca ihtiyacınız olan alanları kullanın. Fazla ve gereksiz alanlar, dönüşüm işlemlerini karmaşıklaştırabilir ve hatalara yol açabilir.
- Ayrıca, her iki sınıfta aynı işlevi gören alanların adlarının uyumlu olmasına dikkat edin.

### 7. **Mapping Yapısını Test Edin**
- Özellikle karmaşık dönüşüm işlemlerinde, ModelMapper’ın doğru çalıştığından emin olmak için birim testler yazın.
- Testler, eşleştirmenin beklendiği gibi yapıldığını doğrulamanıza yardımcı olur. Örneğin, `assertEquals` kullanarak kaynak ve hedef nesnelerdeki alanların doğru şekilde eşleştirildiğini kontrol edebilirsiniz.

   ```java
   @Test
   public void testUserToUserDtoMapping() {
       ModelMapper modelMapper = new ModelMapper();
       User user = new User(1L, "John", "Doe", "john@example.com");
       UserDTO userDTO = modelMapper.map(user, UserDTO.class);

       assertEquals(user.getFirstName(), userDTO.getFirstName());
       assertEquals(user.getEmail(), userDTO.getEmail());
   }
   ```

### 8. **Performansı İzleyin**
- ModelMapper, çalışma zamanında eşleştirme yaptığı için özellikle büyük veri setleri üzerinde çalışırken performans sorunları yaşanabilir.
- Performans kritik uygulamalarda alternatif dönüşüm kütüphanelerini (örneğin, MapStruct) değerlendirebilirsiniz.

### 9. **Özelleştirilmiş Eşleştirmeler İçin TypeMap Kullanımı**
- Karmaşık dönüşümler veya farklı adlandırma durumlarında `TypeMap` kullanarak özel eşleştirmeler tanımlayabilirsiniz.
- `TypeMap`, belirli dönüşümler için yapılandırmaları saklar ve performans açısından daha avantajlıdır.

   ```java
   TypeMap<User, UserDTO> typeMap = modelMapper.createTypeMap(User.class, UserDTO.class);
   typeMap.addMappings(mapper -> mapper.map(User::getAddress, UserDTO::setUserAddress));
   ```

### 10. **Gerekmedikçe Derin Eşleştirmelerden Kaçının**
- ModelMapper varsayılan olarak derin eşleştirme yapar, yani alt nesneleri de eşleştirir. Ancak, tüm alt nesnelerin dönüştürülmesi her zaman gerekmeyebilir.
- Derin eşleştirmenin kapatılması gereken durumlarda `modelMapper.getConfiguration().setDeepCopyEnabled(false);` ayarını kullanabilirsiniz.

### 11. **Eşleştirme Çakışmalarını Önleyin**
- Aynı kaynak sınıfı farklı hedef sınıflara dönüştürmek istediğinizde, `TypeMap` kullanarak her dönüşüm için ayrı bir yapılandırma tanımlayın. Bu, ModelMapper’ın çakışan dönüşüm yapılandırmalarını önlemesini sağlar.
- Aynı türde iki farklı hedef nesneye dönüşüm yapılması gerektiğinde, her dönüşüm için özel `TypeMap` tanımları kullanarak dönüşümleri yönetebilirsiniz.

### 12. **@Configuration Sınıfı ile Merkezi Konfigürasyon Sağlayın**
- Özellikle Spring Boot projelerinde ModelMapper’ı merkezi bir yapılandırma sınıfında `@Bean` olarak tanımlayın ve tüm uygulama genelinde aynı `ModelMapper` nesnesini kullanın.
- Merkezi bir konfigürasyon, kodun yönetilebilirliğini artırır ve tek bir noktadan tüm ModelMapper yapılandırmalarını değiştirme imkanı sunar.

   ```java
   @Configuration
   public class ModelMapperConfig {
       
       @Bean
       public ModelMapper modelMapper() {
           ModelMapper modelMapper = new ModelMapper();
           modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
           return modelMapper;
       }
   }
   ```

### Sonuç

ModelMapper, veri dönüşümlerini hızlı ve kolay hale getiren güçlü bir kütüphanedir. Ancak, özellikle büyük projelerde veya karmaşık veri modellerinde bazı performans ve yapılandırma sorunları yaşanabilir. Bu yüzden yukarıdaki kurallara dikkat etmek, ModelMapper’ın daha verimli kullanılmasını sağlar. Özellikle `MatchingStrategy` seçimi, `TypeMap` ile özelleştirme, koleksiyon türlerinin belirlenmesi ve gereksiz derin eşleştirmelerden kaçınma gibi kurallar, ModelMapper’ın işlevselliğini artırır ve dönüşüm işlemlerinin daha güvenli ve hızlı olmasını sağlar.

Dikkat etmeniz gereken bu kurallar sayesinde ModelMapper’ı daha verimli kullanabilir ve veri dönüştürme işlemlerini yönetilebilir bir yapıya kavuşturabilirsiniz.

## Spring Boot
```sh 

```
---



Lombok, Java geliştiricilerinin daha az kod yazarak daha okunabilir ve bakım yapılabilir kodlar geliştirmesini sağlamak amacıyla kullanılan bir kütüphanedir. Java dilinde, getter ve setter metodları, `toString()`, `equals()`, `hashCode()`, constructor (yapıcı metodlar) gibi birçok tekrarlayan kod yazmak gerekmektedir. Lombok, bu tarz kodları otomatik olarak oluşturarak, geliştiricinin kod tekrarını azaltmasını sağlar ve kodu daha temiz hale getirir.

### Lombok’un Amacı ve Faydaları

1. **Kod Tekrarını Azaltır**: Lombok, Java dilinde sıkça yazılan getter/setter, constructor gibi metotları otomatik oluşturur. Bu, özellikle büyük projelerde kod tekrarını azaltır ve kodun daha okunabilir hale gelmesini sağlar.

2. **Daha Temiz ve Okunabilir Kod**: Lombok, sınıfların sadece iş mantığını içermesini sağlar. Gereksiz metotlar ve alanlar yerine, sadece anotasyonlarla bu işlemler yapılabilir, bu da kodu daha sade hale getirir.

3. **Daha Hızlı Geliştirme**: Tekrarlayan kod yazmak yerine, Lombok anotasyonları kullanılarak hızlı bir şekilde sınıflar tanımlanabilir. Lombok, boilerplate kod olarak bilinen ve defalarca yazılması gereken yapıları ortadan kaldırarak zamandan tasarruf sağlar.

### Lombok Kurulumu

Lombok, Java projelerine Maven veya Gradle bağımlılığı eklenerek kolayca entegre edilebilir.

Maven ile kurulum:

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.20</version>
    <scope>provided</scope>
</dependency>
```

Gradle ile kurulum:

```gradle
implementation 'org.projectlombok:lombok:1.18.20'
```

Eklendikten sonra, Lombok kullanılabilir hale gelir ve projeye dahil edilen anotasyonlar, kod derlendiğinde otomatik olarak ilgili metotları oluşturur.

### Lombok’un Başlıca Anotasyonları ve Kullanımı

Lombok, farklı işlemleri gerçekleştiren birçok anotasyona sahiptir. Her anotasyonun kendine özgü işlevi vardır ve uygun yerlerde kullanıldığında kodu oldukça sadeleştirir.

#### 1. `@Getter` ve `@Setter`

`@Getter` ve `@Setter` anotasyonları, sınıf içindeki alanlar için getter ve setter metodlarını otomatik olarak oluşturur. Bu anotasyonlar, özellikle POJO (Plain Old Java Object) sınıflarında yaygın olarak kullanılır.

```java
import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String name;
}
```

Bu örnekte, `id` ve `name` alanları için getter ve setter metotları otomatik olarak oluşturulur. Lombok sayesinde, bu metotları manuel olarak yazmak zorunda kalmazsınız.

#### 2. `@ToString`

`@ToString` anotasyonu, `toString()` metodunu otomatik olarak oluşturur. Bu metot, nesnenin tüm alanlarını veya belirtilen alanlarını içeren bir `String` temsilini döndürür.

```java
import lombok.ToString;

@ToString
public class User {
    private Long id;
    private String name;
}
```

Bu anotasyon, `User` nesnesi için `toString()` metodunu oluşturur ve id ve name alanlarının değerlerini döndürür. Ayrıca `exclude` parametresi ile `toString()` metodunda yer almasını istemediğiniz alanları belirleyebilirsiniz:

```java
@ToString(exclude = "id")
public class User {
    private Long id;
    private String name;
}
```

Bu durumda, `toString()` metodu `id` alanını hariç tutarak sadece `name` alanını döndürür.

#### 3. `@EqualsAndHashCode`

`@EqualsAndHashCode` anotasyonu, `equals()` ve `hashCode()` metodlarını otomatik olarak oluşturur. Bu metotlar, nesnelerin eşitliğini kontrol etmek ve nesneleri bir hash tablosunda saklamak için kullanılır.

```java
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class User {
    private Long id;
    private String name;
}
```

Bu anotasyon, `User` sınıfı için `equals()` ve `hashCode()` metodlarını oluşturur. `onlyExplicitlyIncluded` parametresi ile belirli alanların eşitlik kontrolüne dahil edilmesi sağlanabilir.

#### 4. `@NoArgsConstructor`, `@AllArgsConstructor`, ve `@RequiredArgsConstructor`

- **@NoArgsConstructor**: Parametresiz bir yapıcı metod (constructor) oluşturur.
- **@AllArgsConstructor**: Sınıftaki tüm alanlar için bir yapıcı metod oluşturur.
- **@RequiredArgsConstructor**: Sadece `final` ve `@NonNull` olarak işaretlenmiş alanlar için bir yapıcı metod oluşturur.

```java
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    private Long id;
    private final String name;
}
```

Bu örnekte, `User` sınıfı için parametresiz, tüm alanları içeren ve sadece `name` alanını zorunlu kılan yapıcı metodlar oluşturulacaktır.

#### 5. `@Data`

`@Data` anotasyonu, `@Getter`, `@Setter`, `@ToString`, `@EqualsAndHashCode` ve `@RequiredArgsConstructor` anotasyonlarını tek bir yerde toplar. Genellikle veri taşıma nesnelerinde (DTO) kullanılır.

```java
import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
}
```

Bu anotasyon, `User` sınıfı için tüm getter/setter, `toString()`, `equals()`, `hashCode()` ve final alanlar için bir yapıcı metod oluşturur.

#### 6. `@Builder`

`@Builder` anotasyonu, sınıfın bir builder deseni ile oluşturulmasını sağlar. Bu, özellikle çok sayıda parametreye sahip nesnelerin daha okunabilir bir şekilde oluşturulmasına olanak tanır.

```java
import lombok.Builder;

@Builder
public class User {
    private Long id;
    private String name;
}
```

Bu anotasyon, `User` sınıfı için bir builder oluşturur. `User` nesnesi aşağıdaki gibi oluşturulabilir:

```java
User user = User.builder()
                .id(1L)
                .name("John Doe")
                .build();
```

#### 7. `@Value`

`@Value` anotasyonu, immutable (değişmez) sınıflar oluşturmak için kullanılır. Tüm alanlar `final` olur ve sınıfın getter metotları ile `toString()`, `equals()`, `hashCode()` metotları otomatik olarak oluşturulur.

```java
import lombok.Value;

@Value
public class User {
    Long id;
    String name;
}
```

Bu sınıfın `id` ve `name` alanları değiştirilemez hale gelir, sadece okuma yapılabilir.

#### 8. `@NonNull`

`@NonNull` anotasyonu, bir alanın null olamayacağını belirtir. Bu anotasyon ile işaretlenen alan null olarak verilirse, `NullPointerException` fırlatılır.

```java
import lombok.NonNull;

public class User {
    private Long id;
    
    @NonNull
    private String name;
}
```

Bu örnekte, `name` alanına null değer atanırsa, çalışma zamanında bir `NullPointerException` meydana gelir.

### Lombok Kullanırken Dikkat Edilmesi Gerekenler

1. **Kodun Anlaşılabilirliği**: Lombok kodu otomatik oluşturduğu için, kodu inceleyen birinin hangi metotların mevcut olduğunu anlaması zorlaşabilir. Özellikle `@Data`, `@Builder` gibi anotasyonlar kullanılan sınıflarda, IDE yardımıyla kodu incelemek faydalı olur.

2. **Eşitlik ve Hash Kodu**: `@EqualsAndHashCode` anotasyonunu kullanırken dikkatli olun. Eşitlik ve hash kodu, nesnelerin karşılaştırılmasında ve hash tablosunda saklanmasında önemli rol oynar. Eşitlik kontrollerini belirli alanlarla sınırlandırmanız gerekiyorsa `@EqualsAndHashCode` ile bu alanları tanımlayın.

3. **Performans Kaygıları**: Lombok’un tüm alanlar için getter/setter oluşturması her durumda gerekli olmayabilir. Gereksiz metotlar performans kaygılarına neden olabilir. Sadece ihtiyaç duyulan anotasyonları kullanmaya özen gösterin.

4. **IDE Desteği**: Lombok, IDEA veya Eclipse gibi IDE'lerde desteklenir, ancak IDE üzerinde ek bir eklenti yüklemek gerekebilir. Lombok'un tam olarak çalışabilmesi için IDE'ye Lombok eklentisi kurmalısınız.

5. **Immutable Sınıflar İçin @Value Kullanabilirsiniz. `@Value` anotasyonu, immutable (değiştirilemez) sınıflar oluşturmak için Lombok’un sağladığı bir kolaylıktır. `@Value` anotasyonu kullanıldığında sınıfın tüm alanları otomatik olarak `final` ve private olur; ayrıca sınıfa getter metotları, `toString()`, `equals()` ve `hashCode()` metotları eklenir. Bu, sınıfın değişmezliğini sağlar ve veri taşıma nesneleri (DTO) veya sabit veri yapıları için oldukça uygun hale getirir.

```java
import lombok.Value;

@Value
public class User {
    Long id;
    String name;
}
```

Bu örnekte `User` sınıfı, `@Value` anotasyonu ile işaretlendiğinden, oluşturulduktan sonra değiştirilemez hale gelir. `id` ve `name` alanlarına ilk değer atandıktan sonra bu alanların değeri değiştirilemez. Böylece `User` sınıfı immutable bir sınıf haline gelir ve daha güvenli bir yapı sunar.

### Lombok ile İlgili Diğer Önemli Anotasyonlar

#### 1. `@SneakyThrows`
`@SneakyThrows` anotasyonu, checked exception (kontrollü istisnalar) kullanımını basitleştirir. Java’da genellikle checked exception’lar (IOException, SQLException gibi) `try-catch` blokları içinde yakalanmak zorundadır. Ancak `@SneakyThrows` ile bu zorunluluk ortadan kaldırılabilir.

```java
import lombok.SneakyThrows;

public class FileReaderExample {

    @SneakyThrows
    public void readFile(String fileName) {
        FileReader fileReader = new FileReader(fileName);
        // Dosya okuma işlemleri
    }
}
```

Bu örnekte, `FileReader` normalde `FileNotFoundException` fırlatır ve `try-catch` bloğu gerektirir. Ancak `@SneakyThrows`, bu istisnayı method imzasında belirtmeden kullanmamıza olanak tanır. **Dikkat edilmesi gereken nokta:** `@SneakyThrows` kullanımı, checked exception’ların gözden kaçmasına yol açabilir; bu yüzden dikkatli kullanılmalıdır.

#### 2. `@Accessors`
`@Accessors` anotasyonu, getter ve setter metodlarının isimlendirme yapısını değiştirmemize olanak tanır. Normalde getter/setter metotları `getField()` ve `setField()` şeklinde isimlendirilir. Ancak `@Accessors(fluent = true)` kullanarak, alan adını doğrudan getter/setter metodu olarak kullanabilirsiniz.

```java
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
public class User {
    private Long id;
    private String name;
}
```

Bu durumda `user.getName()` yerine `user.name()` ve `user.setName("John")` yerine `user.name("John")` yazabilirsiniz. `@Accessors(chain = true)` ise, setter metotlarının zincirleme (chaining) kullanımına izin verir. Bu sayede daha akıcı bir yapı sağlanır.

```java
user.id(1L).name("John");
```

#### 3. `@NonNull`
`@NonNull` anotasyonu, null değerlerin kabul edilmediği alanları belirtir. Bu anotasyon `null` bir değer atanmaya çalışıldığında otomatik olarak `NullPointerException` fırlatır. Özellikle güvenli veri işlemlerinde faydalıdır.

```java
import lombok.NonNull;

public class User {

    private Long id;
    
    @NonNull
    private String name;
}
```

Bu örnekte, `name` alanı `null` olarak atanırsa `NullPointerException` oluşur. `@NonNull`, özellikle zorunlu alanların belirlenmesi ve güvenli hale getirilmesinde yardımcı olur.

### Lombok Kullanırken Dikkat Edilmesi Gereken Önemli Noktalar

1. **Kod Bakımı ve Okunabilirlik**: Lombok, kodu oldukça sadeleştirir, ancak aynı zamanda metotları görünmez hale getirdiği için kodun anlaşılmasını zorlaştırabilir. Takım çalışması yapılan projelerde, özellikle projeye yeni katılan geliştiricilerin kodu anlaması daha uzun sürebilir.

2. **Kodun Derleme Aşamasında Üretilmesi**: Lombok anotasyonları, derleme zamanında (compile-time) metotları ekler, bu nedenle IDE tarafından her zaman doğru bir şekilde tanınmayabilir. IDE desteğinin sağlanabilmesi için Lombok eklentisinin yüklenmiş olması gerekir.

3. **Performans ve Gereksizlikten Kaçınma**: Lombok tüm alanlar için getter/setter metodları veya tüm alanları içeren `toString()` metodunu otomatik olarak oluşturur. Bu nedenle, yalnızca gerçekten ihtiyaç duyulan metotları ve anotasyonları kullanmak daha performanslı bir yapı sunar.

4. **Immutable Sınıflar için @Value Kullanımı**: Immutable (değişmez) sınıflar, veri güvenliği açısından tercih edilir. `@Value` anotasyonu ile oluşturulan immutable sınıflar, eşzamanlı (concurrent) işlemlerde veri tutarlılığını sağlar. Ancak mutable (değişebilir) olması gereken sınıflarda `@Value` kullanmaktan kaçınılmalıdır.

5. **Test ve Hata Ayıklama**: Lombok’un oluşturduğu metotlar çalışma zamanında hataya yol açarsa, bu hataları bulmak zor olabilir. Bu yüzden Lombok kullanırken yazdığınız sınıfları iyi test etmek, beklenmedik hataların önüne geçmek açısından önemlidir.

6. **Özel Durumlara Dikkat**: Lombok bazı özel durumlarda (örneğin, karmaşık yapılı sınıflar veya büyük veri yapıları gibi) beklenmedik performans sorunlarına yol açabilir. Özellikle çok sayıda alan içeren veya derin yapıdaki nesneler için performans optimizasyonuna dikkat edilmelidir.

### Lombok’un Sağladığı Genel Avantaj ve Dezavantajlar

#### Avantajlar

- **Kod Tekrarını Azaltır**: Lombok’un anotasyonları sayesinde sınıflarda sıkça yazılması gereken kodlar otomatik olarak oluşturulur. Bu sayede kod tekrarından kaçınılır.
- **Daha Az Kod, Daha Fazla Okunabilirlik**: Lombok, sınıfları daha anlaşılır hale getirir. Özellikle `@Data` gibi anotasyonlar ile tüm temel metotlar tek bir satırda oluşturulabilir.
- **Kolay Entegrasyon**: Lombok, Maven veya Gradle projelerine kolayca eklenebilir ve IDE’ler ile uyumludur.

#### Dezavantajlar

- **IDE Bağımlılığı**: Lombok, IDE tarafından otomatik olarak tanınmayabilir, bu yüzden ek bir eklentiye ihtiyaç duyar.
- **Bakım Zorluğu**: Lombok’un otomatik olarak ürettiği kodlar sınıfın içinde görünmez olduğu için, sınıfın davranışını anlamak zor olabilir.
- **Performans Maliyetleri**: Lombok, özellikle `toString()`, `equals()`, `hashCode()` gibi metodları karmaşık yapılar için otomatik olarak oluştururken performans kaybına yol açabilir.
- **Standartlara Bağımlılık**: Lombok, Java'nın standart bir kütüphanesi değildir. Proje bağımlılığının artması bazı kurumsal projelerde kabul edilmeyebilir.

### Sonuç

Lombok, Java projelerinde boilerplate kod olarak bilinen, sıkça tekrar eden yapıları otomatik olarak oluşturarak kodu sadeleştirir, geliştirme hızını artırır ve kodun daha okunabilir olmasını sağlar. `@Data`, `@Builder`, `@Value`, `@Getter` ve `@Setter` gibi anotasyonları sayesinde Java projelerinde büyük kolaylık sağlar.

Ancak Lombok’un kullanımı, bazı durumlarda karmaşıklaşabilir ve takım çalışması yapılan projelerde dikkatli kullanılmalıdır. Kodun anlaşılabilirliği, performans ve bakım açısından Lombok’un sağladığı avantajları ve potansiyel dezavantajları değerlendirerek kullanmak en doğru yaklaşım olacaktır.

Lombok’un özelliklerinden en iyi şekilde faydalanmak için ihtiyaca göre doğru anotasyonları kullanmaya özen gösterin ve her anotasyonun kullanım amacını iyi anlayın. Kodunuzun sürdürülebilirliğini sağlamak için Lombok ile yazılan sınıfları iyi test etmeyi unutmayın.


## Spring Boot
```sh 

```
---

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



---
## GET attributes
@GetMapping(
name = "/addres_list_name",
value = "/list",
//path = "/list2"
params = "active=true",
consumes = "application/json",
produces = "application/json",
headers = "X-API-VERSION=1"
)
@Override
public ResponseEntity<List<AddressDto>> addressApiList() {
return ResponseEntity.status(HttpStatus.OK).body(iAddressService.addressServiceList());
}

Bu komutta kullanılan `@GetMapping` anotasyonu, Spring Framework'deki RESTful API geliştirme işlemlerinde kullanılan bir anotasyondur. Bu anotasyon, bir HTTP GET isteğine yanıt veren bir metodun yapılandırılmasını sağlar. Kodda verilen her bir özelliği (attribute) detaylı bir şekilde inceleyip, nasıl çalıştığını ve ne anlama geldiğini açıklayacağım. Ayrıca, her bir özelliğin API'nin nasıl çalışmasını etkilediğini de ayrıntılı olarak açıklayacağım.

### Komut:
```java
@GetMapping(
    name = "/addres_list_name",
    value = "/list",
    path = "/list",
    params = "active=true",
    consumes = "application/json",
    produces = "application/xml",
    headers = "X-API-VERSION=1"
)
@Override
public ResponseEntity<List<AddressDto>> addressApiList() {
    return ResponseEntity.status(HttpStatus.OK).body(iAddressService.addressServiceList());
}
```

## Kısaca
    /*
    İşte `@GetMapping` anotasyonundaki parametrelerin kısa ve madde madde açıklamaları:

1. **`name`:**
    - Metoda bir isim verir (genellikle içsel kullanım içindir, dışarıdan görünmez).
    - Örnek: `name = "/address_list_name"`

2. **`value`:**
    - GET isteğinin URL yolunu belirtir (endpoint).
    - Örnek: `value = "/list"`

3. **`path`:**
    - `value` ile aynı işlevi görür, endpoint yolunu belirtir.
    - Örnek: `path = "/list2"`

4. **`params`:**
    - GET isteğinde belirli bir query parametresinin bulunmasını zorunlu kılar.
    - Örnek: `params = "active=true"`
    - EndPoint: http://lcaolhost:4444/list?active=true

5. **`consumes`:**
    - İstek veri formatını (Content-Type) belirtir, sadece bu formatta gelen verileri kabul eder.
    - Örnek: `consumes = "application/json"`

6. **`produces`:**
    - Yanıt veri formatını belirtir, API'nin döneceği formatı tanımlar.
    - Örnek: `produces = "application/json"`
    - - Örnek: `produces = "application/xml"`

7. **`headers`:**
    - İstek başlığında (header) belirli bir bilginin bulunmasını zorunlu kılar.
    - Örnek: `headers = "X-API-VERSION=1"`
      */
## name attribute örnek vermek
"Bu isim, Spring'in dahili mekanizmasında kullanılabilir" ifadesi, Spring'in kendi yapısında bu ismi referans olarak kullanabileceği anlamına gelir.
Ancak, bu isim dışarıya görünmez, yani API'yi çağıran istemciler bu ismi görmez veya bilmezler.
Bu isim, genellikle Spring'in içsel işlemlerinde, logging (kayıt tutma), izleme veya debugging (hata ayıklama) gibi durumlarda kullanılabilir.

### Örnek:
Spring uygulamanızda birden fazla endpoint olabilir ve her birine `name` özelliği ile benzersiz isimler verebilirsiniz. Bu isimler, özellikle monitoring (izleme) veya hata ayıklama araçları tarafından kullanılabilir.

#### Kullanım Senaryosu:
1. **İzleme ve Debugging:** Uygulamanız bir monitoring aracı ile izleniyorsa, belirli bir endpoint'in adı bu araçlarda kolayca görüntülenebilir ve loglarda daha anlaşılır bir bilgi sağlar.

2. **Logging:** Loglarınızda hangi metodun hangi isimle çağrıldığını belirtmek isteyebilirsiniz. Örneğin, hata aldığınızda bu endpoint'e verilen isim loglarda gözükebilir.

### Örnek:
```java
@GetMapping(
    name = "getAddressListEndpoint",
    value = "/list",
    produces = "application/json"
)
public ResponseEntity<List<AddressDto>> addressApiList() {
    log.info("Calling the endpoint: getAddressListEndpoint");
    return ResponseEntity.ok(iAddressService.addressServiceList());
}
```

Bu örnekte, `log.info("Calling the endpoint: getAddressListEndpoint");` satırı, bu endpoint'e yapılan çağrıların loglanmasını sağlar. Loglarda bu metodun adı `getAddressListEndpoint` olarak görünür. Bu, metodun ne işe yaradığını anlamayı kolaylaştırır.

### Spring Actuator ile Kullanım:
Eğer Spring Actuator kullanıyorsanız, uygulamanızın `name` ile tanımlanmış metodlarını izleme veya raporlama araçlarıyla daha anlamlı hale getirebilirsiniz.

```bash
curl http://localhost:8080/actuator/mappings
```

Bu komutla, Spring Actuator üzerinde tanımlı tüm endpoint'leri görebilirsiniz ve bu noktada `name` ile verilmiş isimler bu mapping bilgisi içinde görünür.

### `@GetMapping` Anotasyonunun Ayrıntılı Açıklaması:
Spring Framework'de `@GetMapping` anotasyonu, bir HTTP GET isteğini belirli bir metoda eşlemek için kullanılır.
Bu metoda gelen GET isteği, `value` ve diğer koşullara göre doğru URL'ye ve isteklere yönlendirilir.

#### 1. **`name`:**
```java
name = "/addres_list_name"
```
- **Açıklama:** `name` özelliği, Spring'in dahili kullanımında metodlara bir referans ismi vermek için kullanılır. Normalde bu isim dışarıya yansıtılmaz ve kullanıcının göremeyeceği bir özelliktir.
- **Anlamı:** Bu metot için bir isim tanımlanmıştır: "/addres_list_name". Bu, proje içinde Spring'in bu metodu izleyebilmesi ve gerektiğinde referans verebilmesi için kullanılabilir.
- **Kullanımı:** Özellikle büyük projelerde, belirli metodlara referans vermek ve metodların izlenebilirliğini artırmak için faydalıdır.
- Ancak genellikle küçük projelerde bu özelliğin kullanımı zorunlu değildir ve isteğe bağlıdır.

#### 2. **`value`:**
```java
value = "/list"
```
- **Açıklama:** `value` özelliği, GET isteğinin URL yolunu tanımlar.
- Bu, istemcinin hangi URL'ye istek yapacağını belirleyen temel yoldur.
- **Anlamı:** `/list` olarak belirlenen bu URL, istemcinin `http://localhost:4444/api/address/list` adresine GET isteği yaparak bu metoda ulaşmasını sağlar.
- Uygulamanın çalıştığı kök URL ve sınıf düzeyinde tanımlanan yol (muhtemelen `/api/address`) bu yolun tam halini belirler.
- **Kullanımı:** İstemci, bu API'ye erişmek istediğinde `http://localhost:4444/api/address/list` yoluna bir GET isteği yapar.
- Bu URL, servise dışarıdan erişim için kapı görevi görür.

#### 3. **`params`:**
```java
params = "active=true"
```
- **Açıklama:** `params` özelliği, HTTP isteğinin belirli bir query parametresini içermesi gerektiğini belirtir. Burada, URL'de belirli parametreler bulunması zorunlu kılınmıştır.
- **Anlamı:** API çağrısı yapılırken, URL'de `active=true` query parametresi olmalıdır. Örneğin: `http://localhost:4444/api/address/list?active=true` şeklinde bir GET isteği yapılması gerekir.
- Eğer bu parametre belirtilmezse veya değeri farklı olursa, istek bu metoda yönlendirilmez.
- **Kullanımı:** `params` özelliği ile aynı endpoint'e farklı parametreler göndererek farklı işlemler gerçekleştirebiliriz.
- Parametre kontrolü, isteğin doğru metodla eşleşmesini sağlar.

#### 4. **`consumes`:**
```java
consumes = "application/json"
```
- **Açıklama:** `consumes` özelliği, API'ye gönderilecek olan isteğin veri formatını belirtir.
- Yani bu metod, yalnızca belirli bir formatta (bu örnekte `application/json`) gönderilen istekleri kabul eder.
- **Anlamı:** Bu API, sadece JSON formatındaki verileri kabul eder.
- Bu, istemcinin isteği yaparken `Content-Type: application/json` başlığı ile veri göndermesi gerektiği anlamına gelir.
- Eğer istek başka bir formatta (örneğin XML) gönderilirse, API bunu işleyemez ve 415 (Unsupported Media Type) hatası döner.
- **Kullanımı:** `consumes` özelliği, API'nin yalnızca belirli formatta veri almasını sağlamak için kullanılır.
- Genellikle JSON (`application/json`), XML (`application/xml`), veya form verisi (`application/x-www-form-urlencoded`) formatlarıyla çalışır.

#### 5. **`produces`:**
```java
produces = "application/json"
```
- **Açıklama:** `produces` özelliği, bu metodun istemciye hangi formatta yanıt döndüreceğini belirtir.
- Bu durumda, API JSON formatında bir yanıt döndürecektir.
- **Anlamı:** Yanıt, `application/json` formatında dönecektir. İstemci bu endpoint'i çağırırken `Accept: application/json` başlığını ekleyebilir ve yanıtın JSON formatında olduğunu bilmelidir.
- Eğer istemci farklı bir format beklerse (örneğin XML), 406 (Not Acceptable) hatası dönebilir.
- **Kullanımı:** Bu özellik, API'nin belirli bir formatta yanıt döndürmesini zorunlu kılar.
- JSON, XML, HTML gibi farklı formatlar arasında seçim yapabilirsiniz.

#### 6. **`headers`:**
```java
headers = "X-API-VERSION=1"
```
- **Açıklama:** `headers` özelliği, HTTP isteğinde belirli bir başlığın (header) bulunmasını zorunlu kılar.
- Bu örnekte, `X-API-VERSION` başlığı kullanılmaktadır.
- **Anlamı:** Bu API'yi çağırırken HTTP isteğine `X-API-VERSION: 1` başlığı eklenmelidir.
- Bu genellikle API versiyonlaması için kullanılır.
- İstemci bu başlığı göndermezse ya da farklı bir değer gönderirse, bu metot çalışmaz ve genellikle 400 (Bad Request) veya 404 (Not Found) hatası dönebilir.
- **Kullanımı:** `headers` özelliği, API versiyonlama, güvenlik veya farklı ihtiyaçlar doğrultusunda isteklere eklenen başlıkları kontrol etmek için kullanılır.
- Versiyonlamada API'nin farklı sürümlerini desteklemek için başlıklar sıkça kullanılır.

### Metodun Gövdesi:
```java
@Override
public ResponseEntity<List<AddressDto>> addressApiList() {
    return ResponseEntity.status(HttpStatus.OK).body(iAddressService.addressServiceList());
}
```
#### 1. **`@Override`:**
- **Açıklama:** Bu anotasyon, bir metotun üst sınıfta veya bir interface'de tanımlandığını ve burada tekrar tanımlandığını belirtir. Bu, metodun bir interface olan `IAddressApi`'dan alındığını gösterir.
- **Anlamı:** Bu metot, `IAddressApi` interface’inde tanımlanmış olmalıdır. Bu, Spring'te Interface-Implementation ilişkisini sağlar.

#### 2. **`ResponseEntity`:**
- **Açıklama:** `ResponseEntity`, HTTP yanıtlarını döndürmek için kullanılan bir sınıftır.
- Yanıtın durum kodu ve gövdesi gibi HTTP yanıtı ile ilgili tüm bilgileri içerir.
- **Anlamı:** Bu metod, HTTP yanıtı olarak bir liste döndürür (`List<AddressDto>`).
- Bu liste, Spring'in HTTP yanıtı olarak işleyebileceği şekilde paketlenir.
- Ayrıca, yanıt durum kodu olarak `HttpStatus.OK` (200) belirlenmiştir.
- **Kullanımı:** `ResponseEntity`, API yanıtının durum kodunu (`HttpStatus`), başlıklarını ve gövdesini kontrol etmek için güçlü bir yapı sağlar.
- Yanıtın gövdesi burada `iAddressService.addressServiceList()` tarafından sağlanan veri olacaktır.

#### 3. **`iAddressService.addressServiceList()`:**
- **Açıklama:** Bu, `iAddressService` adında bir servis tarafından sağlanan bir metottur.
- `addressServiceList()` metodu, adresleri listeleyen bir servis çağrısıdır.
- **Anlamı:** Bu servis çağrısı, adresleri (`AddressDto`) içeren bir liste döndürür ve bu liste API'ye yanıt olarak istemciye iletilir.
- **Kullanımı:** Servis katmanında iş mantığı genellikle burada yapılır.
- Bu, veritabanı veya başka bir kaynaktan verilerin alınmasını ve işlenmesini sağlar. Burada işlenen veri, API yanıtı olarak döndürülecektir.

### API’nin Nasıl Çalışacağı:
Bu metod, `http://localhost:4444/api/address/list` URL'sine yapılan GET isteklerini karşılar. Ancak bu

isteğin çalışabilmesi için birkaç koşul vardır:

1. **URL Parametresi:** İstek, `active=true` query parametresini içermelidir. Örneğin: `http://localhost:4444/api/address/list?active=true`.
2. **Başlıklar (Headers):** HTTP isteği, `X-API-VERSION: 1` başlığını içermelidir. Bu, API'nin doğru versiyonuna eriştiğinizi garanti eder.
3. **İçerik Tipi (Content-Type):** İstek verisi JSON formatında olmalıdır, yani `Content-Type: application/json` başlığı ile gönderilmelidir.
4. **Yanıt Formatı (Produces):** Yanıt JSON formatında döndürülecektir. İstemci, bu yanıtı alacaksa `Accept: application/json` başlığı ile çağrı yapabilir.

### Özet:
Bu API'nin GET metoduna gelen istek, belirli bir URL, query parametre, başlık ve içerik türü ile sınırlandırılmıştır.
Sadece `active=true` parametresi ile, `X-API-VERSION=1` başlığı ile ve `application/json` formatında gelen istekler işlenir.
Yanıt olarak JSON formatında bir `AddressDto` listesi döndürülür.
Bu yapı, API'nin versiyonlama, veri formatı yönetimi ve parametre kontrolü gibi gelişmiş özelliklerini kullanarak RESTful bir mimari sunar.

## @EnableWebMvc
---
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    // CORS yapılandırması
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Tüm URL'ler için geçerli
                .allowedOrigins("http://localhost:3000")  // İzin verilen köken
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // İzin verilen HTTP metodları
                .allowedHeaders("*");  // İzin verilen başlıklar
    }

    // Statik kaynaklar için yapılandırma
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")  // Kaynakların URL deseni
                .addResourceLocations("/public/", "classpath:/static/")  // Kaynakların yerleri
                .setCachePeriod(3600);  // Cache süresi (saniye)
    }

    // Interceptor eklemek için yapılandırma
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomInterceptor())  // CustomInterceptor sınıfı ile Interceptor eklenir
                .addPathPatterns("/api/**")  // Hangi URL deseninde geçerli olacağı
                .excludePathPatterns("/api/login", "/api/register");  // Hariç tutulacak URL desenleri
    }
}


Spring Boot'ta `WebConfig` sınıfı genellikle özel yapılandırmalar yapmak için kullanılır. Özellikle CORS yapılandırması, statik kaynakların yönetimi, `Interceptor` ekleme gibi çeşitli web ayarlarını özelleştirmek amacıyla tercih edilir. Aşağıda bir `WebConfig` örneği ve açıklamaları yer almaktadır:

### WebConfig Örneği

```java
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    // CORS yapılandırması
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Tüm URL'ler için geçerli
                .allowedOrigins("http://localhost:3000")  // İzin verilen köken
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // İzin verilen HTTP metodları
                .allowedHeaders("*");  // İzin verilen başlıklar
    }

    // Statik kaynaklar için yapılandırma
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")  // Kaynakların URL deseni
                .addResourceLocations("/public/", "classpath:/static/")  // Kaynakların yerleri
                .setCachePeriod(3600);  // Cache süresi (saniye)
    }

    // Interceptor eklemek için yapılandırma
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomInterceptor())  // CustomInterceptor sınıfı ile Interceptor eklenir
                .addPathPatterns("/api/**")  // Hangi URL deseninde geçerli olacağı
                .excludePathPatterns("/api/login", "/api/register");  // Hariç tutulacak URL desenleri
    }
}
```

### Açıklamalar:

1. **@Configuration**: Spring Boot'ta yapılandırma sınıflarını işaretler. `WebConfig`, Spring'e bu sınıfın yapılandırma amaçlı olduğunu söyler.

2. **@EnableWebMvc**: Bu anotasyon, Spring MVC'nin tam kontrolünü elde etmek için kullanılır. Ancak, Spring Boot varsayılan olarak birçok MVC ayarını otomatik olarak yapar. Bu nedenle, genellikle bu anotasyona ihtiyaç duyulmaz. Eğer manuel kontrol gerekiyorsa eklenir.

3. **addCorsMappings(CorsRegistry registry)**: Bu metot, Cross-Origin Resource Sharing (CORS) yapılandırması sağlar. Bu yapılandırmada:
    - `addMapping("/**")`: Tüm URL'ler için CORS kısıtlamalarını uygular.
    - `allowedOrigins("http://localhost:3000")`: Sadece `localhost:3000` kökeninden gelen istekleri kabul eder.
    - `allowedMethods("GET", "POST", "PUT", "DELETE")`: İzin verilen HTTP metodlarını tanımlar.
    - `allowedHeaders("*")`: Tüm başlıklara izin verir.

4. **addResourceHandlers(ResourceHandlerRegistry registry)**: Bu metot, statik kaynakların (CSS, JS, resimler vb.) nerede bulunduğunu ve bu kaynaklara nasıl erişileceğini tanımlar.
    - `addResourceHandler("/resources/**")`: `/resources/` ile başlayan URL'ler bu statik kaynaklara erişir.
    - `addResourceLocations("/public/", "classpath:/static/")`: Kaynakların dosya sisteminde ve classpath içinde nerede olduğunu belirtir.

5. **addInterceptors(InterceptorRegistry registry)**: Bu metot, istekleri işleme aşamasında öncesinde veya sonrasında ek davranışlar ekleyen Interceptor'lar tanımlar.
    - `addInterceptor(new CustomInterceptor())`: `CustomInterceptor` sınıfı ile bir Interceptor eklenir.
    - `addPathPatterns("/api/**")`: Bu Interceptor sadece `/api/` ile başlayan URL'lerde çalışır.
    - `excludePathPatterns("/api/login", "/api/register")`: `/api/login` ve `/api/register` URL'leri Interceptor'dan hariç tutulur.

Bu şekilde, Spring Boot projelerinizde CORS, statik kaynak yönetimi ve Interceptor'ları yönetebilirsiniz. `WebMvcConfigurer` arayüzü, bu yapılandırmaları yapmanıza imkan tanır.


`.setCachePeriod(3600)` metodu, statik kaynaklar için cache (önbellekleme) süresini saniye cinsinden ayarlayan bir işlevdir. Buradaki 3600 değeri, cache süresinin 3600 saniye, yani 1 saat olduğunu belirtir. Bu süre boyunca tarayıcı veya istemci, statik kaynakları (örneğin CSS, JavaScript, resim dosyaları gibi) yeniden indirmek yerine önbellekten kullanır.

Önbellekleme, sunucu üzerindeki yükü azaltmak ve uygulamanın performansını artırmak için kullanılır. Statik kaynaklar sık sık değişmez, bu yüzden istemcilerin her seferinde sunucudan bu dosyaları indirmesine gerek yoktur. Önbellekleme süresi şu anlama gelir:

- **Cache süresi dolmadan**: İstemci (tarayıcı gibi), kaynağı tekrar sunucudan talep etmez, bunun yerine daha önce aldığı ve önbelleğe kaydettiği versiyonu kullanır.
- **Cache süresi dolduktan sonra**: İstemci, kaynağın güncellenmiş olup olmadığını kontrol etmek için sunucuya yeni bir talep gönderir.

Örneğin, `.setCachePeriod(3600)` kullanıldığında, istemci bir CSS dosyasını ilk defa aldığında, bu dosya 1 saat boyunca istemcinin cache belleğinde tutulur ve bu süre dolmadan sunucuya tekrar bu dosya için istek göndermez.

Bu yöntem özellikle büyük dosyalar ve sık güncellenmeyen statik içerikler için faydalıdır, çünkü istemciler sunucudan gereksiz yere veri indirmez ve böylece uygulamanızın performansı artar.


`public void addResourceHandlers(ResourceHandlerRegistry registry)` metodu, Spring Boot'ta statik kaynakların (CSS, JavaScript, resim dosyaları vb.) nasıl yönetileceğini ve nerede bulunacağını yapılandırmak için kullanılan bir metottur. Bu metot, Spring MVC'nin varsayılan olarak sağladığı statik kaynak yönetimini özelleştirmemizi sağlar.

### Kullanım Amacı
Bu metot ile uygulamanızın kaynaklarının nerede yer aldığını ve bu kaynaklara nasıl erişileceğini belirleyebilirsiniz. Statik kaynaklar genellikle `src/main/resources/static` dizininde tutulur. Ancak, bu dizini değiştirmek, farklı dizinler eklemek veya önbellekleme ayarları gibi ek yapılandırmalar yapmak istediğinizde `addResourceHandlers` metodunu kullanabilirsiniz.

### Parametre: `ResourceHandlerRegistry`
`ResourceHandlerRegistry`, statik kaynakların tanımlandığı bir yapılandırma aracıdır. Bu parametre ile Spring MVC'ye hangi URL desenlerine karşı hangi kaynakların sunulacağını belirleriz.

### Örnek

```java
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**")  // URL deseni
            .addResourceLocations("classpath:/static/", "/public/")  // Kaynakların konumları
            .setCachePeriod(3600);  // Önbellekleme süresi (saniye)
}
```

### Açıklamalar:

1. **`addResourceHandler("/resources/**")`**: Bu, URL desenini belirtir. Yani uygulamanızda `/resources/` ile başlayan herhangi bir URL, tanımladığınız kaynak dosyalarına yönlendirilecektir. Örneğin, `/resources/css/style.css` gibi bir URL bu yapılandırmaya uygun olacaktır.

2. **`addResourceLocations("classpath:/static/", "/public/")`**: Bu metot, kaynak dosyalarının yerini tanımlar. Burada iki farklı kaynak dizini belirtilmiş:
    - `classpath:/static/`: Bu, `src/main/resources/static/` dizinini ifade eder. Spring Boot projelerinde genellikle statik dosyalar burada tutulur.
    - `/public/`: Bu da proje klasörünüzdeki bir dizini ifade eder. Eğer dosyalarınız `public` klasöründe bulunuyorsa, buraya erişim de sağlar.

3. **`setCachePeriod(3600)`**: Bu, yukarıda açıkladığımız gibi, kaynakların istemci tarafında ne kadar süreyle önbellekte saklanacağını (saniye cinsinden) belirler. 3600 saniye, yani 1 saat önbellekleme süresi sağlar.

### Bu Yapılandırmanın Avantajları
- **Statik dosya erişimini özelleştirme**: Varsayılan dizinlerin dışında, farklı dizinlerden de statik kaynakları sunabilirsiniz.
- **Önbellekleme**: Performansı artırmak için istemcinin statik dosyaları önbelleğe almasını sağlayabilirsiniz.
- **Farklı yollar tanımlama**: Farklı URL desenleriyle farklı kaynakları yönetebilir, proje düzeninizi daha esnek hale getirebilirsiniz.

### Ne Zaman Kullanılır?
- Statik kaynakları varsayılan dizin dışına taşımak veya başka bir dizinden sunmak istiyorsanız.
- Önbellekleme ayarlarını kontrol etmek istiyorsanız.
- Birden fazla kaynak dizinini yapılandırmanız gerekiyorsa.
- Özel URL desenleri ile statik kaynaklara erişimi ayarlamak istiyorsanız.

Bu metodun Spring MVC'deki temel rolü, uygulamanızın statik dosyalarını daha esnek bir şekilde yönetmenize yardımcı olmaktır.


`addInterceptors(InterceptorRegistry registry)` metodu, Spring Boot'ta istekleri karşılamadan önce veya sonra ek işlemler gerçekleştirmek için **Interceptor**'ları yapılandırmak amacıyla kullanılır. Interceptor'lar, web uygulamalarındaki HTTP isteklerinin giriş ve çıkışında ek işlemler yapabilen sınıflardır. Özellikle kimlik doğrulama, yetkilendirme, loglama, performans izleme gibi işlemler için kullanılırlar.





## Spring Boot
```sh 

```
---


`@RequestParam` ve `@PathVariable`, Spring Framework'de HTTP isteğinden parametreleri almak için kullanılan iki farklı anotasyondur. Bu iki anotasyonun nasıl çalıştığını, aralarındaki farkları ve hangi durumlarda hangisini kullanmanız gerektiğini ayrıntılı olarak açıklayalım.

### `@RequestParam` Nedir?

`@RequestParam`, genellikle **sorgu parametrelerini** almak için kullanılır. Sorgu parametreleri, URL’nin `?` işaretinden sonra gelen anahtar-değer çiftleridir. `@RequestParam` ile bir URL’nin sorgu kısmından parametreleri alabiliriz.

**Örnek Kullanım**:
URL: `http://example.com/api/products?category=electronics&price=100`

```java
@GetMapping("/products")
public String getProducts(@RequestParam String category, @RequestParam int price) {
    // category = "electronics"
    // price = 100
    return "Category: " + category + ", Price: " + price;
}
```

Yukarıdaki örnekte:
- `@RequestParam` ile `category` ve `price` sorgu parametreleri URL'den alınır.
- `category` değeri `"electronics"` ve `price` değeri `100` olarak atanır.

**Özellikleri**:
- **İsteğe Bağlı Yapılandırma**: `@RequestParam` isteğe bağlı olarak yapılandırılabilir. Parametre zorunlu değilse `required = false` olarak ayarlanabilir ve varsayılan bir değer belirtilebilir.
- **Sorgu Parametreleri İçin Kullanılır**: `@RequestParam`, URL'nin sorgu kısmından parametre almak için idealdir.

### `@PathVariable` Nedir?

`@PathVariable`, **URL yolunun (path) bir parçasını** parametre olarak almak için kullanılır. Bu yöntem, özellikle RESTful API’lerde, belirli bir kaynağı benzersiz bir kimlik veya özellik ile almak için tercih edilir.

**Örnek Kullanım**:
URL: `http://example.com/api/products/5`

```java
@GetMapping("/products/{id}")
public String getProduct(@PathVariable int id) {
    // id = 5
    return "Product ID: " + id;
}
```

Yukarıdaki örnekte:
- `@PathVariable` ile `id` parametresi URL'den alınır.
- `id` değeri `5` olarak atanır.

**Özellikleri**:
- **Dinamik Yol Parametreleri İçin Kullanılır**: `@PathVariable`, URL’nin bir parçası olan ve kaynakları temsil eden parametreler için kullanılır.
- **Daha Okunaklı URL Yapısı**: `@PathVariable` ile dinamik yollar oluşturulabilir; bu da RESTful API tasarımında daha okunabilir ve anlamlı URL yapıları sağlar.

### `@RequestParam` ile `@PathVariable` Arasındaki Farklar

| Özellik            | @RequestParam                                  | @PathVariable                               |
|--------------------|-----------------------------------------------|--------------------------------------------|
| **Kullanım Yeri**  | Sorgu parametreleri (`?`)                     | URL yolundaki dinamik parametreler (`/{}`) |
| **Amaç**           | Parametre değerleri sorgu parametrelerinden almak için | URL yolunun bir parçasını almak için       |
| **Zorunluluk**     | `required` ile isteğe bağlı yapılabilir        | Zorunludur (yolun bir parçası olarak)      |
| **Örnek URL**      | `/products?category=electronics`              | `/products/electronics`                    |

### Hangi Durumda Hangisini Kullanmalıyım?

1. **Kimlik (ID) veya Kaynak Belirteçleri İçin**: Belirli bir kaynağı benzersiz bir kimlik ile alıyorsanız (örneğin, `productId` veya `userId` gibi), `@PathVariable` kullanmak daha iyi bir yaklaşımdır. Bu, daha temiz ve okunabilir bir URL sağlar. Örneğin:
   ```java
   @GetMapping("/users/{id}")
   public User getUserById(@PathVariable Long id) {
       return userService.findUserById(id);
   }
   ```

2. **Filtreleme veya Arama İçin**: Eğer bir liste üzerinde filtreleme veya arama işlemi yapıyorsanız, `@RequestParam` kullanmanız daha uygundur. Örneğin:
   ```java
   @GetMapping("/products")
   public List<Product> getProducts(@RequestParam(required = false) String category,
                                    @RequestParam(required = false, defaultValue = "0") int minPrice) {
       return productService.findProducts(category, minPrice);
   }
   ```

3. **URL Yapısı ve Okunabilirlik**: RESTful API tasarımı için `@PathVariable`, kaynak belirleme anlamında daha okunabilir URL yapısı sağlar. Örneğin:
    - `@GetMapping("/orders/{orderId}")` – Belirli bir siparişin ayrıntılarına ulaşmak için.

4. **Parametrelerin Zorunluluğu**: `@RequestParam`, isteğe bağlı (`required=false`) olarak yapılandırılabilir ve varsayılan değer atanabilir. `@PathVariable` ise URL yolunun bir parçası olduğundan zorunludur.

### Özet

- **Kaynakları belirlemek için** `@PathVariable` kullanılır.
- **Sorgu veya filtre parametreleri için** `@RequestParam` kullanılır.
- RESTful API’lerde kimlikleri `@PathVariable` ile, opsiyonel sorgu parametrelerini ise `@RequestParam` ile almak iyi bir pratiktir.

## Spring Boot
```sh 

```
---



### Spring API ile RESTful Servis Geliştirme

RESTful servisler, Spring API'nin en sık kullanıldığı alanlardan biridir. Spring API, REST standartlarına uygun servislerin hızlı ve kolay bir şekilde geliştirilmesini sağlar. Spring API ile RESTful servis geliştirmek için izlenen adımlar şunlardır:

1. **Controller Sınıfları**: Spring API'de RESTful servislerin ana bileşeni olan denetleyiciler (controllers) kullanılır. Bu sınıflar, gelen HTTP isteklerini işleyerek uygun yanıtları döndürür. Her bir HTTP isteği, belirli bir denetleyici metoduna yönlendirilir ve burada işlenir.

   Örneğin, `@RestController` anotasyonu ile bir denetleyici sınıfı tanımlanabilir ve `@RequestMapping` ile belirli bir URL ile eşleştirilebilir:

   ```java
   @RestController
   @RequestMapping("/api/customers")
   public class CustomerController {

       @GetMapping("/{id}")
       public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
           Customer customer = customerService.findById(id);
           return ResponseEntity.ok(customer);
       }

       @PostMapping
       public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
           Customer createdCustomer = customerService.save(customer);
           return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
       }
   }
   ```

   Bu örnekte, `CustomerController` sınıfı, `/api/customers` yoluyla HTTP GET ve POST isteklerini işler. `@GetMapping` ve `@PostMapping` anotasyonları ile bu isteklerin belirli metodlara yönlendirilmesi sağlanır.

2. **DTO (Data Transfer Object) Kullanımı**: API’ler aracılığıyla veri alışverişinde kullanılan nesneler, genellikle DTO adı verilen veri transfer nesneleri ile yönetilir. DTO’lar, veri modelini doğrudan istemciye göndermek yerine daha güvenli ve optimize edilmiş veri yapıları sunar.

3. **Exception Handling**: Spring API, hata durumlarında daha anlamlı ve kullanıcı dostu yanıtlar döndürmek için istisna yönetimi sağlar. `@ExceptionHandler` anotasyonu ile belirli hata türlerine özel yanıtlar oluşturulabilir. Bu, istemcinin hata durumlarında daha ayrıntılı bilgi almasını sağlar.

   Örneğin:

   ```java
   @ControllerAdvice
   public class GlobalExceptionHandler {

       @ExceptionHandler(ResourceNotFoundException.class)
       public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
           ErrorResponse error = new ErrorResponse("Resource not found", ex.getMessage());
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
       }
   }
   ```

4. **ResponseEntity Kullanımı**: Spring API, yanıtları daha esnek bir şekilde döndürmek için `ResponseEntity` sınıfını sağlar. Bu sınıf ile HTTP durum kodları, başlık bilgileri ve yanıt gövdesi özelleştirilebilir. `ResponseEntity`, yanıtın daha anlamlı ve detaylı olmasını sağlar.

5. **Parametre Kullanımı**: Spring API, API isteklerinde parametrelerin kolayca kullanılmasını sağlar. `@RequestParam`, `@PathVariable` gibi anotasyonlar ile URL parametreleri, yol parametreleri ve sorgu parametreleri yönetilebilir.

   ```java
   @GetMapping
   public List<Customer> getCustomersByStatus(@RequestParam String status) {
       return customerService.findByStatus(status);
   }
   ```

### Spring Data REST ile Otomatik API Geliştirme

Spring Data REST, Spring Data ile oluşturulmuş veri modellerini otomatik olarak REST API olarak sunmak için kullanılır. Bu sayede veri tabanı işlemleri için manuel olarak denetleyici sınıfları yazmaya gerek kalmaz. Spring Data REST, Spring Data repository arayüzlerini kullanarak otomatik olarak CRUD API’leri oluşturur.

Örneğin, `CustomerRepository` aşağıdaki gibi tanımlanmışsa:

```java
@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
```

Spring Data REST, bu repository’ye otomatik olarak CRUD işlemlerini sağlayan URL’ler ekler:

- `GET /customers`: Tüm müşterileri getirir.
- `POST /customers`: Yeni bir müşteri ekler.
- `GET /customers/{id}`: Belirli bir müşteri detayını getirir.
- `PUT /customers/{id}`: Belirli bir müşteriyi günceller.
- `DELETE /customers/{id}`: Belirli bir müşteriyi siler.

Bu özellik, veri tabanı işlemlerini hızlı bir şekilde API olarak sunmak isteyen geliştiriciler için büyük bir avantaj sağlar.

### Spring HATEOAS ile Hypermedia Destekli API’ler

Spring HATEOAS, REST API yanıtlarını zenginleştirmek için kullanılan bir modüldür. HATEOAS, istemcinin API yapısını daha iyi anlamasını ve navigasyonu kolaylaştırmasını sağlar. Yanıt içerisine linkler ekleyerek, istemcinin ek bir dokümana ihtiyaç duymadan ilgili kaynaklara erişebilmesi sağlanır.

Örneğin, müşteri detaylarını döndürürken, o müşteriye ait siparişlerin linkini de yanıtabilirsiniz. Bu, istemcinin müşteri verisini aldıktan sonra ilgili sipariş bilgilerine kolayca ulaşmasını sağlar.

```java
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public EntityModel<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.findById(id);

        EntityModel<Customer> resource = EntityModel.of(customer);
        resource.add(linkTo(methodOn(CustomerController.class).getCustomerById(id)).withSelfRel());
        resource.add(linkTo(methodOn(OrderController.class).getOrdersByCustomerId(id)).withRel("orders"));

        return resource;
    }
}
```

Bu örnekte `EntityModel` kullanılarak `Customer` nesnesine "self" linki ve ilişkili "orders" linki eklenmiştir. İstemci, yanıtı aldığında müşteriye ait siparişlere de kolayca erişebilir.

### Spring Security ile API Güvenliği

API’lerin güvenliği, özellikle hassas veri alışverişi yapılan uygulamalarda büyük önem taşır. Spring Security, kimlik doğrulama ve yetkilendirme süreçlerini yöneterek API'leri güvenli hale getirir. Spring API’de güvenlik sağlamak için JWT (JSON Web Token) veya OAuth2 gibi modern güvenlik protokolleri kullanılabilir.

**JWT ile Kimlik Doğrulama**: JWT, kullanıcının kimliğini doğrulamak için kullanılan, imzalı bir token yapısıdır. Kullanıcı giriş yaptığında, JWT token oluşturulur ve kullanıcıya gönderilir. İstemci, API isteklerinde bu token'ı taşıyarak kimliğini doğrular.

```java
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/auth/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .addFilter(new JWTAuthenticationFilter(authenticationManager()));
    }
}
```

Bu yapılandırmada `/api/auth/**` altındaki URL'lere kimlik doğrulama olmadan erişim izni verilmiştir. Diğer tüm URL'ler için JWT kimlik doğrulaması gereklidir.

### Spring API'de Swagger ile API Dokümantasyonu

Spring API'leri geliştirirken, istemcilerin API'leri nasıl kullanacağını anlamalarını sağlamak için dokümantasyon önemlidir. Swagger, Spring API’leri için kapsamlı ve otomatik bir dokümantasyon çözümü sunar. Spring Boot projelerine kolayca entegre edilebilir ve API uç noktalarını görselleştirir.

Swagger’ın kullanımı için, `springdoc-openapi-ui` gibi bir bağımlılık projeye eklenebilir. Bu, API uç noktalarının interaktif bir dokümantasyon sayfasında gösterilmesini sağlar.

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.5.9</version>
</dependency>
```

Swagger UI ile, geliştiriciler API isteklerini test edebilir ve dönen yanıtları görebilir, bu da hata ayıklama ve test sürecini kolaylaştırır.

### Spring API'nin Avantajları ve Dezavantajları

**Avantajları**:

- **Hızlı Geliştirme**: Spring API modülleri, geliştiricilere standart yapılar ve anotasyonlar sunarak hızlı bir şekilde API geliştirme imkanı tanır.
- **Esneklik ve Özelleştirilebilirlik**: Spring’in modüler yapısı, projeye uygun bileşenlerin kullanılmasını ve özelleştirilmesini kolaylaştırır.
- **Geniş Güvenlik Desteği**: Spring Security ile güçlü kimlik doğrulama ve yetkilendirme süreçleri oluşturulabilir.
- **Kapsamlı Ekosistem**: Spring Data, Spring MVC, Spring Security gibi modüller, API geliştirme sürecinde her türlü ihtiyaca yanıt verir.

**Dezavantajları**:

- **Öğrenme Eğrisi**: Spring API, yeni başlayanlar için karmaşık olabilir, özellikle HATEOAS, güvenlik yapılandırmaları gibi özellikler öğrenme sürecini uzatabilir.
- **Performans Sorunları**: Büyük ölçekli uygulamalarda performans optimizasyonları gerekebilir.
- **Özelleştirme Gereksinimi**: Özellikle API güvenliği veya özelleştirilmiş sorgular gibi özel gereksinimler için yapılandırmalar karmaşık hale gelebilir.

### Sonuç

Spring API, güçlü ve kapsamlı bir araç seti sunarak kurumsal düzeyde API’lerin hızlı ve güvenli bir şekilde geliştirilmesini sağlar. RESTful servisler, güvenlik önlemleri, veri yönetimi ve dokümantasyon gibi konularda sağladığı çözümler, geliştiricilere modüler, esnek ve test edilebilir API’ler oluşturma imkanı tanır. Spring API’ler, kurumsal projelerde tercih edilen bir yapı olarak, geniş topluluk desteği ve sürekli güncellenen ekosistemi sayesinde modern yazılım geliştirme süreçlerinin vazgeçilmez bir parçası olmuştur.

Daha detaylı bir konu veya örnek ile ilgili sorularınız varsa, daha ayrıntılı bilgi sağlamaktan memnuniyet duyarım.



## Spring Boot
```sh 

```
---