# Techcareer 2025 Backend-1 Spring Boot
[GitHub Address](https://github.com/hamitmizrak/techcareer_2025_backend_1.git)
---


Spring Boot ve Hibernate ile SQL sorguları ve veritabanı işlemlerini daha detaylı anlamak, performansı optimize etmek ve loglama işlemini geliştirmek için başka özellikler de eklenebilir. Aşağıda bu ayarların yanı sıra ekleyebileceğiniz önemli özellikler ve bunların işlevleri detaylı şekilde açıklanmıştır.

---

logging.level.org.springframework.jdbc.core=TRACE
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.generate_statistics=true
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql=TRACE
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.hikari.maximum-pool-size=10
spring.sql.init.mode=always
spring.jpa.defer-datasource-initialization=true
spring.jpa.hibernate.ddl-auto=update
spring.datasource.initialization-mode=always
logging.level.org.hibernate.cache=TRACE
spring.jpa.properties.hibernate.order_inserts=true
spring.jpa.properties.hibernate.order_updates=true
spring.jpa.properties.hibernate.batch_versioned_data=true


### **Eklenebilecek Özellikler**

#### 1. **`spring.jpa.properties.hibernate.use_sql_comments=true`**

- **Ne Yapar?**
    - Hibernate'in oluşturduğu SQL sorgularının başına açıklama (comment) ekler.
    - Bu açıklamalar, sorgunun hangi sınıf veya metot tarafından üretildiğini gösterir.

- **Kullanım Amacı**:
    - SQL sorgularını izlerken, sorgunun hangi Entity veya Repository'den geldiğini anlamayı kolaylaştırır.

- **Örnek Log Çıktısı**:
  ```sql
  /* select customer */ select c.id, c.name, c.email from customers c where c.status = ?
  ```

---

#### 2. **`spring.jpa.properties.hibernate.generate_statistics=true`**

- **Ne Yapar?**
    - Hibernate'in sorgu istatistiklerini ve performans ölçümlerini loglar.
    - Cache kullanımı, sorgu sayısı, yükleme süreleri gibi bilgiler içerir.

- **Kullanım Amacı**:
    - Performans sorunlarını tespit etmek.
    - Fazla sorgu yapılmasını (N+1 Problem) veya yavaş sorguları tespit etmek.

- **Örnek Log Çıktısı**:
  ```plaintext
  Hibernate: session metrics: 10 statements executed, 5 entities loaded, 2 collections fetched
  ```

---

#### 3. **`logging.level.org.hibernate.SQL=DEBUG`**

- **Ne Yapar?**
    - Hibernate tarafından üretilen SQL sorgularını DEBUG seviyesinde loglar.
    - Daha detaylı loglama sağlar.

- **Kullanım Amacı**:
    - `spring.jpa.show-sql=true` veya `spring.jpa.properties.hibernate.show_sql=true` ile birlikte kullanılarak daha kapsamlı bilgi elde edilir.

---

#### 4. **`logging.level.org.hibernate.type.descriptor.sql=TRACE`**

- **Ne Yapar?**
    - Hibernate sorgularında kullanılan SQL parametrelerini loglar.
    - Özellikle parametrelerin doğru şekilde bağlanıp bağlanmadığını anlamak için kullanılır.

- **Kullanım Amacı**:
    - Hatalı parametre bağlamalarını tespit etmek.
    - Performansı etkileyebilecek büyük parametre setlerini incelemek.

- **Örnek Log Çıktısı**:
  ```plaintext
  binding parameter [1] as [VARCHAR] - [John Doe]
  binding parameter [2] as [INTEGER] - [42]
  ```

---

#### 5. **`spring.datasource.driver-class-name=org.h2.Driver` (veya başka bir sürücü)**

- **Ne Yapar?**
    - JDBC sürücüsünü açıkça belirtir.
    - Loglama sırasında kullanılan sürücü bilgilerini görmek için faydalıdır.

- **Kullanım Amacı**:
    - Geliştirme ve test ortamlarında kullanılan veritabanı sürücüsünün doğruluğunu kontrol etmek.

---

#### 6. **`spring.datasource.hikari.maximum-pool-size=10`**

- **Ne Yapar?**
    - HikariCP bağlantı havuzunun maksimum bağlantı sayısını ayarlar.
    - Bağlantı havuzunun performansını optimize eder.

- **Kullanım Amacı**:
    - Yoğun sorgu yükü altında bağlantı sorunlarını önlemek.
    - Performans sorunlarını tespit etmek.

---

#### 7. **`spring.sql.init.mode=always`**

- **Ne Yapar?**
    - Uygulama başlatılırken SQL betiklerinin (schema.sql, data.sql) her zaman çalıştırılmasını sağlar.
    - Özellikle test ortamlarında veri hazırlamak için kullanılır.

- **Kullanım Amacı**:
    - Test sırasında başlangıç verilerini yüklemek.
    - Sorguların doğru çalıştığını doğrulamak.

---

#### 8. **`spring.jpa.defer-datasource-initialization=true`**

- **Ne Yapar?**
    - Veritabanı başlangıç işlemlerini (schema.sql veya data.sql gibi) Spring Boot'un tamamen başlatılmasından sonra gerçekleştirir.

- **Kullanım Amacı**:
    - Hibernate veya başka bir veri işleyicisi tarafından oluşturulan tabloların önce oluşturulmasını sağlamak.
    - Özellikle bağımlılık sırasının önemli olduğu durumlarda kullanılır.

---

#### 9. **`spring.jpa.hibernate.ddl-auto=update`**

- **Ne Yapar?**
    - Hibernate'in veritabanı tablolarını nasıl yöneteceğini belirler.
    - Değerler:
        - `none`: Tablolar üzerinde hiçbir işlem yapılmaz.
        - `validate`: Mevcut tablo şeması doğrulanır.
        - `update`: Mevcut şema güncellenir (veriler korunur).
        - `create`: Tüm tablolar sıfırdan oluşturulur (veriler kaybolur).
        - `create-drop`: Uygulama kapanınca tablolar silinir.

- **Kullanım Amacı**:
    - Geliştirme ortamında şemayı hızlıca güncellemek.
    - Test için geçici tablolar oluşturmak.

---

#### 10. **`spring.datasource.initialization-mode=always`**

- **Ne Yapar?**
    - Veritabanını başlatma (örneğin, `schema.sql` ve `data.sql` dosyaları ile) işlemini her zaman etkinleştirir.

- **Kullanım Amacı**:
    - Geliştirme ortamında başlangıç verilerinin her zaman yüklenmesini sağlamak.

---

#### 11. **`logging.level.org.hibernate.cache=TRACE`**

- **Ne Yapar?**
    - Hibernate’in önbellek yönetimiyle ilgili loglama sağlar.
    - Hangi sorguların önbellekten çalıştırıldığını veya yüklenmesi gerektiğini gösterir.

- **Kullanım Amacı**:
    - Hibernate’in önbellek performansını analiz etmek.
    - Verimsiz sorgu yüklerini tespit etmek.

---

#### 12. **`spring.jpa.properties.hibernate.order_inserts=true`**

- **Ne Yapar?**
    - Hibernate, birden fazla kayıt ekleme işlemini optimize etmek için bu kayıtları gruplayarak sıralar.

- **Kullanım Amacı**:
    - Performansı artırmak.
    - Büyük miktarda veri ekleme işlemleri sırasında sorgu verimliliğini artırmak.

---

#### 13. **`spring.jpa.properties.hibernate.order_updates=true`**

- **Ne Yapar?**
    - Güncellemeleri gruplayarak sıralar ve toplu olarak çalıştırır.

- **Kullanım Amacı**:
    - Güncelleme işlemlerinde performansı optimize eder.

---

### **Ek Örnek Ayarlar**

```properties
# Hibernate Cache Logları
logging.level.org.hibernate.cache=DEBUG

# Hibernate SQL Logları
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql=TRACE

# Hibernate Performans İstatistikleri
spring.jpa.properties.hibernate.generate_statistics=true

# Sorgu Optimizasyonu
spring.jpa.properties.hibernate.order_inserts=true
spring.jpa.properties.hibernate.order_updates=true
spring.jpa.properties.hibernate.batch_versioned_data=true

# Başlangıç Betikleri
spring.datasource.initialization-mode=always
spring.sql.init.mode=always
spring.jpa.defer-datasource-initialization=true
```

---

### **Hangi Ayarlar Birlikte Kullanılabilir?**

| **Amaç**               | **Ayarlar**                                                                                   |
|-------------------------|-----------------------------------------------------------------------------------------------|
| **SQL İzleme**          | `spring.jpa.show-sql=true`, `spring.jpa.properties.hibernate.show_sql=true`, `hibernate.SQL=DEBUG` |
| **Performans İzleme**   | `spring.jpa.properties.hibernate.generate_statistics=true`, `hibernate.cache=DEBUG`           |
| **Okunabilirlik**       | `spring.jpa.properties.hibernate.format_sql=true`, `spring.jpa.properties.hibernate.use_sql_comments=true` |
| **Veritabanı Yönetimi** | `spring.jpa.hibernate.ddl-auto=update`, `spring.datasource.initialization-mode=always`        |

---

### **Sonuç**

- SQL sorguları ve veritabanı işlemlerini daha iyi izlemek için yukarıdaki ayarlarla uygulamanızın loglama, performans analizi ve hata ayıklama yeteneklerini geliştirebilirsiniz.
- Özellikle geliştirme ve test ortamlarında, bu ayarların bir kombinasyonu kullanılarak detaylı izleme ve performans optimizasyonu sağlanabilir.
- Üretim ortamında ise gereksiz log yükünden kaçınmak için yalnızca kritik loglama ayarları etkinleştirilmelidir.