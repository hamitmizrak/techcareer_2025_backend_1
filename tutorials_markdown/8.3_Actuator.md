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



## Permalink
```sh 
    http://localhost:4444
    http://localhost:4444/h2-console
    http://localhost:4444/swagger-ui/index.html
    http://localhost:4444/actuator/health
```



#http://localhost:4444/actuator/health
#http://localhost:4444/actuator/info
#http://localhost:4444/actuator
#http://localhost:4444/actuator/loggers



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

### **Spring Boot Actuator Nedir?**

**Spring Boot Actuator**, Spring Boot uygulamalarını izlemek ve yönetmek için kullanılan bir modüldür. Uygulama hakkında bilgi toplamak, sağlık durumunu kontrol etmek, metrikleri görüntülemek ve uygulamayı çalışırken yönetmek için kullanılır. Actuator, üretim ortamında Spring Boot uygulamalarını güvenli bir şekilde izlemek ve yönetmek isteyen geliştiricilere ve sistem yöneticilerine kolaylık sağlar.
---

### **Spring Boot Actuator'ın Temel Özellikleri**
1. **Hazır Endpoint'ler (Endpoints)**:
    - Actuator, sistem durumu, metrikler, yapılandırma ve daha fazlası hakkında bilgi sağlayan bir dizi hazır endpoint ile birlikte gelir.
    - Bu endpoint'ler, uygulamanızın çalışma zamanındaki durumunu ve özelliklerini anlamanıza yardımcı olur.

2. **Metrik Toplama**:
    - Actuator, JVM bellek kullanımı, iş parçacığı bilgileri, HTTP istekleri, veritabanı bağlantıları ve uygulama özel metrikleri gibi birçok metrik sunar.
    - Özelleştirilebilir ve farklı metrik toplama sistemlerine entegre edilebilir.

3. **Sağlık Durumu Kontrolü (Health Checks)**:
    - Uygulamanızın ve bağımlılıklarınızın (veritabanı, mesajlaşma sistemi vb.) sağlıklı olup olmadığını kontrol eder.
    - Sağlık durumu bilgilerini kullanıcı tanımlı kriterlere göre özelleştirebilirsiniz.

4. **Uygulama Yapılandırma Görüntüleme**:
    - Çalışma zamanındaki yapılandırma değerlerini ve özellikleri kontrol etmek için kullanılır.

5. **Kolay Entegrasyon**:
    - Prometheus, Grafana, ELK (Elasticsearch, Logstash, Kibana) ve diğer izleme araçlarıyla kolayca entegre edilebilir.

---

### **Spring Boot Actuator Nasıl Çalışır?**

Spring Boot Actuator, HTTP endpoint'leri ve JMX (Java Management Extensions) aracılığıyla uygulamanın çalışma durumunu ve bilgilerini sağlar. Actuator modülü, Spring Boot'un otomatik yapılandırma özelliği sayesinde minimum çabayla aktif hale getirilebilir.

---

### **Spring Boot Actuator Kurulumu**

Spring Boot Actuator'ı kullanmak için `spring-boot-starter-actuator` bağımlılığını `pom.xml` dosyanıza ekleyin:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Ya da `build.gradle` dosyanızda:

```sh
implementation 'org.springframework.boot:spring-boot-starter-actuator'
```

---

### actuator  ########################################################################
## application.properties
http://localhost:4444/actuator <br/>
http://localhost:4444/actuator/health <br/>
http://localhost:4444/actuator/info <br/>
http://localhost:4444/actuator/loggers<br/>
http://localhost:4444/admin <br/>

```sh 
management.endpoints.web.base-path=/admin
springdoc.show-actuator=true
management.server.port=4444
management.endpoints.web.exposure.include=*
management.endpoints.web.exposure.include=metrics,info,health
management.endpoint.shutdown.enabled=true
management.endpoint.health.show-details=always
```

### Dikkat: /admin diğer metrik url çalışmasını engelliyor duruma göre ekleyelim.
```sh 
management.endpoints.web.base-path=/admin
```


# Spring Boot, /actuator rotasını statik bir kaynak olarak algılamaya çalışıyor olabilir.
# Bu durum, spring.web.resources.static-locations ayarının yanlış yapılandırılmasından kaynaklanabilir.
#spring.web.resources.static-locations=/actuator

# management.security.enabled=false
# management.metrics.export.prometheus.enabled=true

## http://localhost:4444/admin/info
info.app.name=Java Full Stack Developer
info.app.description= Java Spring Boot dersi
info.app.version=1.0.0

---
## Actuator'ı IntelliJ IDEA
Spring Boot Actuator'ı IntelliJ IDEA üzerinden çalıştırmak oldukça kolaydır. İşte adım adım yapmanız gerekenler:

---

### 1. **Yeni Bir Spring Boot Projesi Oluşturun**
1. **IntelliJ IDEA'yı açın.**
2. **File > New > Project** seçeneğini seçin.
3. **Spring Initializr**'ı seçin ve `Next` düğmesine tıklayın.
4. Proje bilgilerini doldurun:
    - **Group**: `com.example`
    - **Artifact**: `actuator-demo`
    - **Name**: `actuator-demo`
5. **Dependencies** kısmında şunları ekleyin:
    - **Spring Boot Actuator**
    - **Spring Web**
6. `Finish` butonuna tıklayarak projeyi oluşturun.

---

### 2. **`pom.xml` veya `build.gradle` Dosyasını Kontrol Edin**

Projeniz Maven kullanıyorsa, `pom.xml` dosyanızda `spring-boot-starter-actuator` bağımlılığının yer aldığından emin olun:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Gradle kullanıyorsanız, `build.gradle` dosyanızda şu satırı kontrol edin:

```groovy
implementation 'org.springframework.boot:spring-boot-starter-actuator'
```

Bağımlılıklarda eksiklik varsa ekleyin ve projenizi yeniden yükleyin.

---

### 3. **Actuator Endpoint'lerini Yapılandırın**

Spring Boot Actuator endpoint'lerini varsayılan ayarlarıyla çalıştırmak için `application.properties` dosyasına aşağıdaki satırları ekleyin:

```properties
management.endpoints.web.exposure.include=*
```

Bu ayar, tüm Actuator endpoint'lerini etkinleştirir. Daha az endpoint kullanmak istiyorsanız, yalnızca belirli olanları etkinleştirebilirsiniz:

```properties
management.endpoints.web.exposure.include=health,info
```

Varsayılan olarak `health` ve `info` endpoint'leri etkin olacaktır.

---

### 4. **Sağlık Kontrolü ve Bilgi Endpoint'lerini Özelleştirin**

`application.properties` dosyasına aşağıdaki gibi bilgiler ekleyerek `info` endpoint'ini özelleştirebilirsiniz:

```properties
info.app.name=Actuator Demo Application
info.app.description=This is a demo for Spring Boot Actuator
info.app.version=1.0.0
```

---

### 5. **Uygulama Ana Sınıfını Çalıştırın**

`ActuatorDemoApplication` sınıfınız şu şekilde olmalıdır:

```java
package com.example.actuatordemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActuatorDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActuatorDemoApplication.class, args);
    }
}
```

---

### 6. **Uygulamayı Çalıştırın**
1. IntelliJ IDEA içinde `ActuatorDemoApplication` sınıfını sağ tıklayın.
2. **Run 'ActuatorDemoApplication.main()'** seçeneğine tıklayın.
3. Uygulama çalıştıktan sonra, terminalde `Tomcat started on port(s): 8080` gibi bir mesaj görmelisiniz.

---

### 7. **Actuator Endpoint'lerini Test Edin**
Actuator endpoint'lerini test etmek için bir tarayıcı veya Postman kullanabilirsiniz. Tarayıcıda şu URL'leri ziyaret edin:

- Sağlık durumu:
  ```
  http://localhost:8080/actuator/health
  ```

- Uygulama bilgisi:
  ```
  http://localhost:8080/actuator/info
  ```

Tüm endpoint'leri görmek için:
```
http://localhost:8080/actuator
```

---

### 8. **Log Seviyelerini Dinamik Olarak Değiştirme (Opsiyonel)**

Actuator üzerinden log seviyelerini değiştirmek için `loggers` endpoint'ini kullanabilirsiniz. Örneğin, log seviyesini `DEBUG` yapmak için şu adımları takip edebilirsiniz:

#### GET İsteği: Log Seviyelerini Görüntüleme
```
http://localhost:8080/actuator/loggers
```

#### POST İsteği: Log Seviyesini Değiştirme
Body kısmında şu veriyi gönderin:
```json
{
  "configuredLevel": "DEBUG"
}
```
URL:
```
http://localhost:8080/actuator/loggers/com.example
```

---

### 9. **Prometheus ve Grafana ile Entegrasyon (Opsiyonel)**

Actuator metriklerini Prometheus ve Grafana gibi izleme araçlarına bağlamak için Actuator metrik endpoint'ini kullanabilirsiniz. Bunun için Prometheus desteği eklemek gerekebilir:

```properties
management.metrics.export.prometheus.enabled=true
management.endpoints.web.exposure.include=prometheus
```

---

### 10. **Potansiyel Hatalar ve Çözümleri**
1. **Endpoint'lere Erişim Sağlanamıyor:**
    - `management.endpoints.web.exposure.include` ayarını kontrol edin.
    - Güvenlik ayarlarını yapılandırın (Spring Security varsa).

2. **Port Çakışması:**
    - Varsayılan olarak uygulama `8080` portunu kullanır. Başka bir uygulama bu portu kullanıyorsa, portu değiştirin:
      ```properties
      server.port=9090
      ```

---

Artık IntelliJ IDEA üzerinde Spring Boot Actuator'ı başarıyla çalıştırabilir ve endpoint'leri kullanarak uygulamanızın durumunu izleyebilirsiniz!



### **Actuator Endpoint'leri**

Actuator, birçok hazır endpoint sunar. Bazı önemli endpoint'ler şunlardır:

| **Endpoint**       | **Açıklama**                                                                                     |
|---------------------|-------------------------------------------------------------------------------------------------|
| `/actuator/health` | Uygulamanın sağlık durumunu kontrol eder.                                                        |
| `/actuator/info`   | Uygulama hakkında bilgi verir (örneğin sürüm bilgisi, geliştirici bilgileri).                     |
| `/actuator/metrics`| Uygulamanın performans ve kullanım metriklerini listeler.                                        |
| `/actuator/env`    | Uygulama yapılandırma ortamını ve değişkenlerini görüntüler.                                      |
| `/actuator/loggers`| Log seviyelerini dinamik olarak değiştirme ve görüntüleme imkanı sağlar.                         |
| `/actuator/threaddump` | JVM iş parçacığı dökümünü gösterir (yalnızca devreye alındığında).                           |
| `/actuator/httptrace` | HTTP isteklerini ve yanıtlarını izler (yalnızca gerekli bağımlılıkla birlikte çalışır).        |

> **Not**: Varsayılan olarak yalnızca `health` ve `info` endpoint'leri açık gelir. Diğer endpoint'ler `application.properties` veya `application.yml` dosyasından etkinleştirilmelidir.

---

### **Endpoint'leri Etkinleştirme**

`application.properties` veya `application.yml` dosyasında Actuator endpoint'leri yapılandırabilirsiniz:

#### **Örnek (application.properties):**
```properties
management.endpoints.web.exposure.include=*
```
Bu ayar, tüm endpoint'leri etkinleştirir.

#### **Örnek (application.yml):**
```yaml
management:
  endpoints:
    web:
      exposure:
        include: "*"
```

---

### **Sağlık Kontrolleri (Health Checks)**

Sağlık kontrolleri, uygulamanın bağımlılıklarının durumunu kontrol etmek için kullanılır. Örneğin:

- **Veritabanı Bağlantısı**
- **Mesajlaşma Sistemi**
- **Disk Alanı**
- **Özel Sağlık Kontrolleri**

#### Varsayılan Sağlık Kontrolü
Varsayılan `/actuator/health` çıktısı genellikle şöyle görünür:

```json
{
  "status": "UP"
}
```

#### Veritabanı Sağlık Kontrolü
Eğer bir veritabanı bağlantısı yapılandırılmışsa, Actuator otomatik olarak bağlantıyı kontrol eder:

```json
{
  "status": "UP",
  "components": {
    "db": {
      "status": "UP",
      "details": {
        "database": "PostgreSQL",
        "validationQuery": "isValid()"
      }
    },
    "diskSpace": {
      "status": "UP",
      "details": {
        "total": 500105216000,
        "free": 435817476096,
        "threshold": 10485760
      }
    }
  }
}
```

---

### **Metrikler**

Actuator, aşağıdaki gibi metrikler sağlar:

- JVM metrikleri (bellek kullanımı, iş parçacığı durumu)
- HTTP istekleri ve yanıt süreleri
- Veritabanı sorgu süreleri
- Özelleştirilmiş uygulama metrikleri

#### Örnek: `/actuator/metrics` Endpoint
```json
{
  "names": [
    "jvm.memory.used",
    "jvm.memory.max",
    "http.server.requests",
    "process.uptime",
    "system.cpu.usage"
  ]
}
```

Belirli bir metriği görüntülemek için `/actuator/metrics/{metric-name}` kullanabilirsiniz:
```bash
GET /actuator/metrics/jvm.memory.used
```

---

### **Özelleştirilmiş Sağlık Kontrolleri**

Kendi sağlık kontrolünüzü oluşturmak için bir sınıf tanımlayabilirsiniz:

```java
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        // Özelleştirilmiş sağlık kontrolü mantığı
        boolean isHealthy = checkCustomHealth();
        if (isHealthy) {
            return Health.up().withDetail("CustomService", "Service is running").build();
        }
        return Health.down().withDetail("CustomService", "Service is not running").build();
    }

    private boolean checkCustomHealth() {
        // Sağlık kontrolü için özel mantık
        return true;
    }
}
```

---

### **Güvenlik**

Actuator endpoint'leri hassas bilgiler içerebilir. Bu yüzden endpoint'lere erişimi sınırlandırmak önemlidir. Spring Security ile endpoint'leri güvenli hale getirebilirsiniz:

#### Örnek:
`application.properties` dosyasında:
```properties
management.endpoints.web.exposure.include=health,metrics
management.endpoint.health.probes.enabled=true
management.endpoints.web.base-path=/manage
```

Spring Security yapılandırması:
```java
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/manage/**").authenticated()
            .and()
            .httpBasic();
    }
}
```

---

### **Spring Boot Actuator Avantajları**
1. **Kolay İzleme**: Uygulamanın durumunu ve performansını hızlı bir şekilde anlamanızı sağlar.
2. **Esneklik**: Özelleştirilebilir metrikler ve sağlık kontrolleri ekleyebilirsiniz.
3. **Üretim Kullanımı**: Prometheus, Grafana ve diğer izleme araçlarıyla entegre edilebilir.
4. **Hızlı Teşhis**: Problemleri daha hızlı tespit etmek için kullanılabilir.

---

### **Sonuç**

Spring Boot Actuator, Spring Boot uygulamalarını izlemek ve yönetmek için güçlü bir araçtır. Uygulamanızın çalışma durumu, performansı ve bağımlılıklarının sağlık durumu hakkında bilgi sağlar. Ayrıca, hem geliştirme hem de üretim ortamlarında uygulamanızı daha verimli bir şekilde yönetmenizi sağlar.

### Actuator Intellij Açılmazsa
`-Djava.rmi.server.hostname=localhost` JVM argümanı olarak eklenmesi gerekiyor. IntelliJ IDEA'da bu ayarı projenizin çalıştırma yapılandırmasına (Run/Debug Configuration) ekleyebilirsiniz. Aşağıdaki adımları takip edin:

---

### 1. **Run/Debug Configuration'ı Açın**
1. IntelliJ IDEA'da üst menüden **Run > Edit Configurations** seçeneğine tıklayın.
2. Açılan pencerede, çalıştırmak istediğiniz uygulamanın yapılandırmasını seçin veya yeni bir yapılandırma oluşturun.

---

### 2. **VM Options'a Argüman Ekleyin**
1. Seçilen yapılandırmanın sağ tarafında **Configuration** kısmını bulun.
2. **VM Options** alanını bulun. Eğer bu alan görünmüyorsa, aşağıdaki gibi genişletin:
    - **Modify options** düğmesine tıklayın.
    - Açılan menüden **Add VM options** seçeneğini seçin.
3. **VM Options** kısmına aşağıdaki JVM argümanını ekleyin:
   ```
   -Djava.rmi.server.hostname=localhost
   ```

---

### 3. **Ayarları Kaydedin ve Çalıştırın**
1. **OK** butonuna tıklayarak yapılandırmayı kaydedin.
2. Projenizi yeniden başlatın.

---

### 4. **Doğru Ayarlandığını Kontrol Etmek**
Projenizi başlattıktan sonra loglarda bu JVM argümanının kullanıldığını doğrulayabilirsiniz. Loglar arasında `-Djava.rmi.server.hostname=localhost` parametresinin geçtiğinden emin olun.
---

**Son**

# Eğer intellij Idea Actuator gelmiyorsa Çözümler
```shell 


Eğer Intellij Idea Üzerinden Actuator çalışmıyorsa VM ayarlamalarını yapmak için çözümler
1. Çözüm: Dikkat: JDK 11 ve üstünde kullanın.
2. Çözüm: Setting => Build,Execution,Deployment => Java Compiler => JDK seçili olması gerekiyor.
3. Çözüm: Project Structured => SDK => JDK seçili olması gerekiyor.
4. Çözüm: Actuator eğer JVM görmüyorsa Debug modunda çalıştırın. (Shift+F9)
5. Çözüm: Settings => Apperance Behavior =>System Settings => Http Proxy => No Proxy (olsun)
6. Çözüm: Run => Edit Configuration => Modify Option => Add Vm Option (Aktif Et) => aşağıdaki komutları VM Ekle
 -Dcom.sun.management.jmxremote.port=55555 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false

Dikkat: 55555 portuna dikkat etmeliyiz bu port kullanımda olmaması gerekiyor.
Windows => PowerShell açarak portu kontrol etmeliyiz.
1.YOL
netstat -ano | find "55555"
netstat -tuln | grep "55555"

 2.YOL
 netstat -aon | findstr :4444  => Buradan Gelen [EN SAĞDAKI PID]
 taskkill /PID [EN SAĞDAKI PID] /F
 taskkill /PID 30396 /F
```