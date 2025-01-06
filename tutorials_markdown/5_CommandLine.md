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


### Spring Boot CommandLineRunner Nedir?

Spring Boot uygulamalarında, uygulama başlatılırken belirli kodların çalıştırılması gerekiyorsa **CommandLineRunner** arayüzü kullanılır. Bu arayüz, uygulama başlatıldıktan hemen sonra bir kez çalıştırılmak üzere tasarlanmıştır. Özellikle başlangıç işlemleri, veri yükleme, ayar kontrolleri veya test verilerinin oluşturulması gibi işlemleri yapmak için idealdir.

---

### CommandLineRunner'ın Özellikleri

1. **Bir Defalık Çalıştırma:**
   CommandLineRunner, uygulama başlatıldığında yalnızca bir kez çalıştırılır.

2. **@Component veya @Bean ile Kullanım:**
   CommandLineRunner, bir sınıfa uygulanabilir ve bu sınıfın bir Spring bileşeni olarak tanımlanması gerekir. Bunun için genellikle `@Component` veya `@Bean` kullanılır.

3. **Uygulamanın Lifecycle’ına Entegre:**
   Spring konteyneri tamamen yüklendikten sonra çalıştırılır, bu nedenle tüm bağımlılıklar ve bean'ler hazırdır.

---

### CommandLineRunner Kullanımı

**1. Basit Bir Örnek**

Aşağıdaki örnekte, uygulama başlatıldığında bir mesaj yazdıran basit bir CommandLineRunner tanımlanmıştır:

```java
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Uygulama başlatıldı!");
        System.out.println("Komut satırı argümanları:");
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
```

Bu örnekte:
- `run` metodu, uygulama başlatıldığında otomatik olarak çalışır.
- `args` parametresi, uygulama başlatılırken verilen komut satırı argümanlarını alır.

---

**2. @Bean ile Kullanımı**

CommandLineRunner'ı bir bean olarak tanımlayarak da kullanabilirsiniz:

```java
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandLineRunnerConfig {

    @Bean
    public CommandLineRunner myRunner() {
        return args -> {
            System.out.println("Bean ile tanımlanan CommandLineRunner çalıştı.");
            for (String arg : args) {
                System.out.println("Argüman: " + arg);
            }
        };
    }
}
```

---

**3. Veri Tabanına Test Verisi Yüklemek**

CommandLineRunner genellikle veri tabanı başlangıç verilerini yüklemek için kullanılır:

```java
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public DatabaseInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Veri tabanı başlangıç verileri yükleniyor...");
        userRepository.save(new User("Ali", "Veli", "ali.veli@example.com"));
        userRepository.save(new User("Ayşe", "Fatma", "ayse.fatma@example.com"));
        System.out.println("Başlangıç verileri yüklendi.");
    }
}
```

---

### Birden Fazla CommandLineRunner Kullanımı

Birden fazla CommandLineRunner sınıfınız varsa, bunlar Spring’in lifecycle sırasında çalıştırılır. Ancak bu durumda çalıştırılma sırasını kontrol etmek gerekebilir. Bunun için `@Order` anotasyonu kullanılabilir.

```java
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class FirstRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("FirstRunner çalıştı.");
    }
}

@Component
@Order(2)
public class SecondRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("SecondRunner çalıştı.");
    }
}
```

Bu örnekte `FirstRunner` önce, `SecondRunner` ise daha sonra çalıştırılır.

---

### CommandLineRunner ve ApplicationRunner Farkı

Spring Boot, CommandLineRunner’a benzer bir başka arayüz olan **ApplicationRunner** da sunar. Temel farkları şunlardır:

- **CommandLineRunner:** `run` metodu bir `String... args` alır.
- **ApplicationRunner:** `run` metodu bir `ApplicationArguments` alır. Bu, komut satırı argümanlarını daha yapılandırılmış bir şekilde sağlar.

**Örnek:**

```java
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner çalıştı.");
        System.out.println("Option argümanları: " + args.getOptionNames());
    }
}
```

---

### CommandLineRunner Kullanım Alanları

1. **Başlangıç Verilerinin Yüklenmesi:**
   Veri tabanına test verileri veya önceden tanımlanmış veriler yüklemek için kullanılabilir.

2. **Konfigürasyon Kontrolleri:**
   Uygulama başlatıldığında belirli konfigürasyonların kontrol edilmesi veya doğrulanması.

3. **Servislerin Başlatılması:**
   Dış sistemlerle entegrasyon veya özel işlemler için başlangıçta çalıştırılması gereken kodlar.

4. **Loglama ve İzleme:**
   Uygulama başlatma sırasında loglama veya metrik toplama işlemleri.

---

### CommandLineRunner İle Hata Yönetimi

CommandLineRunner’da hata oluşursa uygulama başlatma işlemi başarısız olabilir. Bu yüzden hata yönetimi önemlidir.

```java
@Component
public class ErrorHandlingRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        try {
            System.out.println("Runner çalıştırılıyor...");
            // Örnek bir işlem
            int result = 10 / 0; // Hata oluştur
        } catch (Exception e) {
            System.err.println("Hata oluştu: " + e.getMessage());
        }
    }
}
```

---

### Komut Satırı Argümanlarının Kullanımı

Spring Boot uygulamaları, komut satırı argümanlarını alabilir ve bu argümanlar CommandLineRunner içinde kullanılabilir.

**Uygulama Çalıştırma:**

```bash
java -jar myapp.jar --name=SpringBoot --version=1.0
```

**CommandLineRunner Kullanımı:**

```java
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineArgsRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        for (String arg : args) {
            System.out.println("Argüman: " + arg);
        }
    }
}
```

---

### Sonuç

**CommandLineRunner**, Spring Boot uygulamalarında başlangıç işlemleri için kullanışlı bir araçtır. Uygulamanın lifecycle'ına entegre olduğu için herhangi bir bağımlılığı kolayca kullanabilirsiniz. Özellikle veri yükleme, başlangıç konfigürasyonları ve test işlemleri için idealdir. Ayrıca, `@Order` ile birden fazla runner'ın sırasını kontrol edebilir, hata yönetimi ile daha güvenilir bir başlangıç mekanizması oluşturabilirsiniz.

# 
İncelediğiniz bu iki CommandLineRunner sınıfına (yani `_1_DataLoadingSet` ve `_2_DataLoadingSet`) dayanarak, başka CommandLineRunner sınıfları yazarken farklı senaryolar için aşağıdaki fikirler ve önerilerden faydalanabilirsiniz:

---

### **1. Veritabanı Başlangıç Verilerini Yükleme**
Uygulama başlatıldığında test veya varsayılan başlangıç verilerini yüklemek için bir CommandLineRunner yazabilirsiniz. Örneğin, kullanıcı, rol veya ürün verilerini bir tabloya eklemek için:

```java
@Component
@Order(3)
public class UserDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    public UserDataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("3- Kullanıcı verileri yükleniyor...");

        UserEntity user = new UserEntity();
        user.setFirstName("Hamit");
        user.setLastName("Mızrak");
        user.setEmail("hamit@example.com");

        userRepository.save(user);
        System.out.println("Kullanıcı başarıyla yüklendi.");
    }
}
```

---

### **2. Dış Sistemlerle Bağlantı Kontrolü**
Dış bir sistem veya API ile entegrasyon sağlıyorsanız, uygulama başlatıldığında bu bağlantının kontrol edilmesini sağlayabilirsiniz.

```java
@Component
@Order(4)
public class ApiHealthCheckRunner implements CommandLineRunner {

    private final ApiService apiService;

    public ApiHealthCheckRunner(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("4- API bağlantısı kontrol ediliyor...");
        boolean isHealthy = apiService.checkHealth();
        if (isHealthy) {
            System.out.println("API bağlantısı başarılı.");
        } else {
            System.err.println("API bağlantısı başarısız!");
        }
    }
}
```

---

### **3. Cache Temizleme veya Hazırlama**
Eğer uygulama önbellek (cache) mekanizması kullanıyorsa, uygulama başlatıldığında cache’i temizlemek veya başlangıç verilerini yüklemek için bir CommandLineRunner kullanabilirsiniz.

```java
@Component
@Order(5)
public class CacheInitializer implements CommandLineRunner {

    private final CacheService cacheService;

    public CacheInitializer(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("5- Cache temizleniyor...");
        cacheService.clearAll();
        System.out.println("Cache başarıyla temizlendi ve başlatıldı.");
    }
}
```

---

### **4. Loglama Mekanizmasının Test Edilmesi**
Loglama altyapısını kontrol etmek ve sistemdeki belirli log seviyelerini test etmek için bir CommandLineRunner yazabilirsiniz.

```java
@Component
@Order(6)
public class LoggingTestRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("6- Loglama sistemi test ediliyor...");
        log.debug("DEBUG: Debug mesajı");
        log.info("INFO: Bilgilendirme mesajı");
        log.warn("WARN: Uyarı mesajı");
        log.error("ERROR: Hata mesajı");
    }
}
```

---

### **5. Konfigürasyon Doğrulama**
Uygulama başlatıldığında belirli bir konfigürasyonun doğru olup olmadığını kontrol edebilirsiniz.

```java
@Component
@Order(7)
public class ConfigurationValidator implements CommandLineRunner {

    private final AppProperties appProperties;

    public ConfigurationValidator(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("7- Konfigürasyon doğrulaması yapılıyor...");
        if (appProperties.getApiKey() == null || appProperties.getApiKey().isEmpty()) {
            throw new IllegalStateException("API anahtarı eksik!");
        }
        System.out.println("Konfigürasyon geçerli.");
    }
}
```

---

### **6. Komut Satırı Argümanlarını İşleme**
CommandLineRunner, komut satırından alınan argümanlarla uygulamanın davranışını özelleştirmek için kullanılabilir.

```java
@Component
@Order(8)
public class CommandLineArgProcessor implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("8- Komut satırı argümanları işleniyor...");
        for (String arg : args) {
            System.out.println("Argüman: " + arg);
            if (arg.equalsIgnoreCase("--loadTestData")) {
                System.out.println("Test verileri yükleniyor...");
                // Test verilerini yükle
            }
        }
    }
}
```

---

### **7. Zamanlanmış Görevlerin Hazırlanması**
Eğer uygulamanızda zamanlanmış görevler çalıştırıyorsanız, bu görevlerin düzgün çalıştığından emin olmak için bir başlangıç kontrolü yapabilirsiniz.

```java
@Component
@Order(9)
public class ScheduledTaskInitializer implements CommandLineRunner {

    private final TaskSchedulerService taskSchedulerService;

    public ScheduledTaskInitializer(TaskSchedulerService taskSchedulerService) {
        this.taskSchedulerService = taskSchedulerService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("9- Zamanlanmış görevler kontrol ediliyor...");
        taskSchedulerService.verifyTasks();
        System.out.println("Tüm zamanlanmış görevler başarıyla kontrol edildi.");
    }
}
```

---

### **8. Kullanıcı Rolleri ve Yetkilendirme Verileri**
Uygulama başlatıldığında kullanıcı rolleri ve yetkilendirme verilerinin yüklenmesi:

```java
@Component
@Order(10)
public class RoleInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public RoleInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("10- Kullanıcı rolleri yükleniyor...");

        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setName("USER");
        roleRepository.save(userRole);

        System.out.println("Roller başarıyla yüklendi.");
    }
}
```

---

### **Sonuç**

Yukarıdaki önerilerden biri veya birkaçı, sisteminizin gereksinimlerine göre uygulanabilir. Uygulamanızın farklı başlangıç işlemleri (veritabanı, cache, API kontrolü, kullanıcı rolleri vb.) için bu örneklerden ilham alabilirsiniz. Hangi işlemi yapıyorsanız, `CommandLineRunner`’ı sadece o göreve özel hale getirerek düzenli ve sürdürülebilir bir kod yapısı oluşturabilirsiniz.