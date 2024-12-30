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

## Redis Nedir ?
 
### Redis Nedir?

Redis (Remote Dictionary Server), **açık kaynaklı**, **hafızada çalışan** (in-memory) ve **anahtar-değer (key-value)** yapısında bir veri deposudur. 
Redis, performansı, esnekliği ve zengin veri yapılarıyla diğer veri depolama çözümlerinden ayrılır. 
2009 yılında Salvatore Sanfilippo tarafından geliştirilmiştir ve günümüzde birçok uygulamada 
**veritabanı**, **önbellek** (cache) ve **mesaj kuyruğu** (message broker) olarak kullanılır.

Redis'in temel özellikleri ve avantajlarını anlamak için detaylı bir inceleme yapalım.

---

### Redis’in Temel Özellikleri

#### 1. **Hafızada Çalışma (In-Memory)**
Redis, tüm veriyi RAM’de tutar ve işlemlerini buradan gerçekleştirir. 
Bu, **çok yüksek hızlarda okuma/yazma** işlemleri yapılmasını sağlar. 
Redis'in bu özelliği onu yüksek performans gerektiren uygulamalarda vazgeçilmez bir araç haline getirir.

#### 2. **Zengin Veri Yapıları**
Redis, basit anahtar-değer çiftleriyle çalışmanın ötesinde aşağıdaki veri yapılarını da destekler:
- **Strings**: Temel metin veya ikili veri depolama.
- **Hashes**: Hash tabanlı veri yapılarını depolama (örneğin: bir kullanıcının adı, soyadı, yaşı).
- **Lists**: Sıralı veri listeleri (FIFO/LIFO).
- **Sets**: Benzersiz öğelerden oluşan koleksiyonlar.
- **Sorted Sets**: Sıralı ve benzersiz öğeler.
- **Bitmaps**: Bit düzeyinde işlemler.
- **HyperLogLogs**: Benzersiz öğelerin yaklaşık sayımını yapmak için.
- **Geospatial**: Coğrafi veriler ve sorgular.

#### 3. **Kalıcılık (Persistence)**
Redis, verileri yalnızca RAM’de tutmakla kalmaz; aynı zamanda disk üzerine yazarak kalıcılığı da sağlar:
- **RDB (Redis Database Backup)**: Belirli aralıklarla veri anlık görüntüsü alır.
- **AOF (Append-Only File)**: Her yazma işlemini diske ekleyerek veri kaybını minimuma indirir.

#### 4. **Dağıtılmış Yapı (Cluster Support)**
Redis, **cluster** modunda çalışarak verileri birden fazla sunucuya yayabilir. 
Bu sayede **yüksek erişilebilirlik** ve **ölçeklenebilirlik** sağlar.

#### 5. **Mesaj Kuyruğu (Pub/Sub)**
Redis, **publish/subscribe (yayınlama/abonelik)** sistemiyle uygulamalar arasında gerçek zamanlı mesajlaşma sağlar.

#### 6. **Atomic İşlemler**
Redis'teki tüm işlemler atomik yapıdadır; yani işlemler ya tamamen gerçekleşir ya da hiç gerçekleşmez.

#### 7. **LUA Script Desteği**
Redis, özelleştirilmiş işlemleri gerçekleştirmek için **Lua** betikleri çalıştırabilir.

#### 8. **Replication (Replikasyon)**
Redis, birden fazla yedeği (slave) olan bir ana (master) yapı kurarak verilerin çoğaltılmasını sağlar. 
Bu, veri güvenliği ve yük dengeleme açısından önemlidir.

---

### Redis Nerelerde Kullanılır?

#### 1. **Önbellekleme (Caching)**
Redis, veritabanı sorgularını hızlandırmak için en sık kullanılan veri önbellekleme çözümlerinden biridir. Örneğin:
- Sık erişilen kullanıcı oturumları.
- Sık sorgulanan ürün verileri.

#### 2. **Mesajlaşma ve Kuyruk Sistemleri**
Redis'in Pub/Sub mekanizması, sistemler arasında gerçek zamanlı veri iletiminde kullanılır. 
Ayrıca **List** yapısı sayesinde kuyruk işlemleri gerçekleştirilir.

#### 3. **Gerçek Zamanlı Analitik**
Redis, hızlı okuma/yazma işlemleri sayesinde gerçek zamanlı analitik ve metriklerin tutulmasında kullanılır.

#### 4. **Coğrafi Veri İşleme**
Redis’in geospatial desteği, harita uygulamaları veya konum tabanlı hizmetlerde coğrafi verilerin saklanmasını ve sorgulanmasını kolaylaştırır.

#### 5. **Sayımlar ve Sayaçlar**
Redis'in HyperLogLog veri yapısı, benzersiz ziyaretçi sayımı gibi işlemler için idealdir.

---

### Redis’in Avantajları

1. **Hız**: RAM üzerinde çalıştığı için mikro saniyelerle ifade edilen gecikme süreleri sunar.
2. **Esneklik**: Farklı veri yapıları sayesinde birçok kullanım senaryosuna uygundur.
3. **Kullanım Kolaylığı**: Basit ve anlaşılır komutlarla çalışır.
4. **Kapsamlı Desteği**: Python, Java, Node.js, PHP, Go gibi birçok dil için kütüphaneleri mevcuttur.
5. **Topluluk ve Destek**: Büyük bir topluluk ve iyi belgelenmiş dokümantasyonu vardır.

---

### Redis Komutları

#### Veri İşlemleri
- `SET key value`: Bir anahtar oluşturur ve değer atar.
- `GET key`: Anahtarın değerini getirir.
- `DEL key`: Anahtarı ve değerini siler.

#### Liste İşlemleri
- `LPUSH key value`: Listeye baştan öğe ekler.
- `RPUSH key value`: Listeye sondan öğe ekler.
- `LPOP key`: Listenin başından öğe çeker.

#### Hash İşlemleri
- `HSET key field value`: Bir hash içine alan ve değer ekler.
- `HGET key field`: Hash içindeki belirli bir alanın değerini getirir.

#### Set İşlemleri
- `SADD key value`: Bir sete öğe ekler.
- `SMEMBERS key`: Setin tüm öğelerini getirir.

---

### Redis’in Dezavantajları

1. **Bellek Tüketimi**: Veriler RAM’de saklandığı için büyük veri setlerinde yüksek bellek kullanımı gerektirir.
2. **Veri Kalıcılığı**: Tamamen kalıcı bir depolama çözümü değildir. (Ancak AOF ile veri kaybı minimize edilir.)
3. **Sınırlı Sorgulama**: Geleneksel SQL sorgularını desteklemez.

---

### Redis Kurulumu ve Kullanımı

#### Kurulum
Redis'i Linux tabanlı bir sistemde kurmak için:

```bash
sudo apt update
sudo apt install redis-server
```

## NOT:
java.net.ConnectException: Connection refused: no further information
Eğer bu hatı alıyorsanız Redis'i start yapmamışsınız demektir

#### Redis’i Başlatma ve Durum Kontrolü
Redis hizmetini başlatmak için:
```bash
sudo systemctl start redis
```

Durum kontrolü:
```bash
sudo systemctl status redis
```

#### Redis CLI Kullanımı
Redis ile etkileşime geçmek için komut satırı arayüzü (CLI) kullanılabilir:
```bash
redis-cli
```

---

### Redis ve Rakipleri

Redis, aşağıdaki rakipleriyle kıyaslandığında hız ve esneklik açısından öne çıkar:
- **Memcached**: Yalnızca anahtar-değer çiftlerini destekler, ancak Redis kadar zengin veri yapısına sahip değildir.
- **Cassandra**: Büyük veri depolama için daha uygundur, ancak Redis kadar hızlı değildir.

---

### Sonuç

Redis, yüksek hız, esneklik ve güçlü veri yapıları sunarak modern yazılım geliştirme süreçlerinde kritik bir rol oynar. 
Veritabanı olarak kullanılabilir, önbellek katmanı oluşturabilir ve mesaj kuyruğu olarak yapılandırılabilir. 
Hem küçük hem de büyük ölçekli uygulamalar için idealdir.

Redis, performans ve esneklik gerektiren projelerde güçlü bir araçtır ve 
doğru kullanıldığında yazılım mimarisine büyük katkılar sağlar.
```
---

## Redis Docker Compose
 
# Projemizin sağlıklı çalışması için öncelikler redis servera kurulu olması gerekiyor
docker container run --name spring_redis -p 6379:6379 -d redis
```
---

## Redis pom.xml
 
        <!-- #### REDIS #################################################  -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-cache</artifactId>
        </dependency>

        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
        </dependency>

       <dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-data-redis</artifactId>
           <exclusions>
               <exclusion>
                   <groupId>io.lettuce.core</groupId>
                   <artifactId>lettuce-core</artifactId>
               </exclusion>
           </exclusions>
       </dependency>

        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId>
        </dependency>
```
---

## Redis Config
 
package com.hamitmizrak.innova_springboot.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import java.time.Duration;

/*
Eklenmiş Özellikler:
redisTemplate:
Key ve Value için StringRedisSerializer ve GenericJackson2JsonRedisSerializer kullanır.
Genellikle standart CRUD işlemleri için kullanılır.

customCacheConfiguration:
Cache isimleri için bir customPrefix ekler.
1 saatlik bir geçerlilik süresi tanımlar.
Null değerlerin cache yapılmasını engeller.

loggingRedisTemplate:
Redis işlemleri için loglama desteği eklenmiştir.
Transaction desteği aktif hale getirilmiştir.

transactionalRedisTemplate:
RedisTemplate üzerinde transaction desteği sağlanmıştır.
Bu, aynı işlem içindeki birçok Redis komutunun atomik olarak çalıştırılmasını sağlar.

cacheConfiguration:
Daha kısa süreli cache işlemleri için 1 dakikalık TTL belirler.
Null değerlerin cache yapılmasını önler.
Bu yapılandırma, Redis'i hem cache hem de transaction bazlı işlemler için esnek bir şekilde kullanmanıza olanak sağlar. 
Ayrıca, farklı kullanım senaryoları için ayrı RedisTemplate tanımları sağlanmıştır.
*/


@Configuration
@EnableCaching
public class RedisConfig {

    /**
     * Standart bir RedisTemplate yapılandırması.
     * Key ve Value için sırasıyla StringRedisSerializer ve GenericJackson2JsonRedisSerializer kullanılır.
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }

    /**
     * Cache Configuration - Cache prefix ekleme ve TTL (Time To Live) belirleme.
     */
    @Bean
    public RedisCacheConfiguration customCacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .prefixCacheNameWith("customPrefix::") // Cache isimlerine özel bir prefix ekler
                .entryTtl(Duration.ofHours(1)) // Cache geçerlilik süresini 1 saat olarak belirler
                .disableCachingNullValues() // Null değerleri cache’lemez
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }

    /**
     * RedisTemplate ile özel loglama ve transaction desteği.
     */
    @Bean
    public RedisTemplate<String, Object> loggingRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setEnableTransactionSupport(true); // Transaction desteği
        return template;
    }

    /**
     * Transaction destekli RedisTemplate yapılandırması.
     */
    @Bean
    public RedisTemplate<String, Object> transactionalRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setEnableTransactionSupport(true); // Transaction desteği
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }

    /**
     * Default Cache Configuration - Özellikle kısa süreli cache kullanımları için.
     */
    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(1)) // 1 dakikalık geçerlilik süresi
                .disableCachingNullValues() // Null değerlerini cache’lemez
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }
} //end RedisConfig


```
---


## Redis application.properties
 
######################################################################################
### REDIS CONFIG   ########################################################################
######################################################################################
# Redis server adresi ve portu
spring.data.redis.host=localhost
spring.data.redis.port=6379
spring.data.redis.timeout=60000

# Cache yapılandırması
spring.cache.type=redis

```
---


## Redis @Cacheable
 
      // FIND BY ID (Address)
    // REDIS : için aşağıdaki linktten çalışıp çalışmadığını bu linkten anlayabiliriz
    // http://localhost:4444/api/address/v1.0.0/find/1
    @Cacheable(value = "addressFindByIdCache", key = "#id")
    @Override
    public AddressDto objectServiceFindById(Long id) {
        //REDIS
        System.err.println("Redis başlamadan önce ilk burası çalışacak ancak redis çalışıyorsa bunu cache dakikası bitene kadar veya flush yapana kadar görmeyeceksiniz "+id);
        return iAddressRepository.findById(id)
                .map(AddressMapper::AddressEntityToAddressDto)
                .orElseThrow(()-> new _404_NotFoundException(id+" nolu veri yoktur"));
    }
```
---




## Redis Test Bean

package com.hamitmizrak.innova_springboot.bean;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

// LOMBOK
@Log4j2

@Component
public class RedisTest {

    @Order(3)
    @Bean
    public CommandLineRunner testRedis(StringRedisTemplate redisTemplate) {
        return args -> {
            try {
                redisTemplate.opsForValue().set("test-key", "test-value");
                String value = redisTemplate.opsForValue().get("test-key");
                System.out.println("Redis is working. Retrieved value: " + value);
                log.warn("Redis is working. Retrieved value: " + value);
            } catch (Exception e) {
                System.err.println("Redis is not working: " + e.getMessage());
                log.error("Redis is not working: " + e.getMessage());
            }
        };
    }
}
