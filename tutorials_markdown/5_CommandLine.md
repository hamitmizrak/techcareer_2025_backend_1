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