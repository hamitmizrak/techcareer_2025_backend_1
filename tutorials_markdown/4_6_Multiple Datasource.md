# Techcareer 2025 Backend-1 Spring Boot
[GitHub Address](https://github.com/hamitmizrak/techcareer_2025_backend_1.git)
---

Spring Boot ile bir uygulamada aynı anda birden fazla veritabanı (örneğin **H2DB** ve **MySQL**) kullanmak istiyorsanız, **çoklu veri kaynağı (multiple data sources)** yapılandırması yapmanız gerekir. Spring Boot, her veri kaynağını ayrı bir **DataSource**, **EntityManagerFactory** ve **TransactionManager** ile yönetir. İşte detaylı bir açıklama:

---

### **1. Temel Yapılandırma**

#### **Bağımlılıklar**
`pom.xml` dosyasına hem **H2** hem de **MySQL** için gerekli bağımlılıkları ekleyin:

```xml
<dependencies>
    <!-- H2 Database -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- MySQL Database -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
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

### **2. `application.properties` Yapılandırması**

Her bir veri kaynağı için ayrı bağlantı yapılandırması yapmanız gerekir. Örneğin:

```properties
# H2 Database Configuration
spring.datasource.h2.url=jdbc:h2:mem:testdb
spring.datasource.h2.driver-class-name=org.h2.Driver
spring.datasource.h2.username=sa
spring.datasource.h2.password=

# MySQL Database Configuration
spring.datasource.mysql.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.mysql.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.mysql.username=root
spring.datasource.mysql.password=root
```

---

### **3. Çoklu Veri Kaynağı Yapılandırması**

#### **H2 DataSource Yapılandırması**
H2 veri kaynağını tanımlayın:

```java
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class H2DataSourceConfig {

    @Bean(name = "h2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.h2")
    public DataSource dataSource() {
        return new DriverManagerDataSource();
    }
}
```

---

#### **MySQL DataSource Yapılandırması**
MySQL veri kaynağını tanımlayın:

```java
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class MySQLDataSourceConfig {

    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource dataSource() {
        return new DriverManagerDataSource();
    }
}
```

---

### **4. JPA Yapılandırması**

#### **H2 JPA Yapılandırması**
H2 için `EntityManagerFactory` ve `TransactionManager` yapılandırın:

```java
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.repository.h2",
        entityManagerFactoryRef = "h2EntityManagerFactory",
        transactionManagerRef = "h2TransactionManager"
)
public class H2JpaConfig {

    @Bean(name = "h2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("h2DataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.entity.h2") // H2 ile ilgili Entity sınıfları
                .persistenceUnit("h2")
                .build();
    }

    @Bean(name = "h2TransactionManager")
    public JpaTransactionManager transactionManager(
            @Qualifier("h2EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
```

---

#### **MySQL JPA Yapılandırması**
MySQL için `EntityManagerFactory` ve `TransactionManager` yapılandırın:

```java
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.repository.mysql",
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        transactionManagerRef = "mysqlTransactionManager"
)
public class MySQLJpaConfig {

    @Bean(name = "mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("mysqlDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.entity.mysql") // MySQL ile ilgili Entity sınıfları
                .persistenceUnit("mysql")
                .build();
    }

    @Bean(name = "mysqlTransactionManager")
    public JpaTransactionManager transactionManager(
            @Qualifier("mysqlEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
```

---

### **5. Entity ve Repository Yapılandırması**

#### **H2 Entity ve Repository**
- **Entity** sınıflarını `com.example.entity.h2` paketinde tanımlayın.
- **Repository** sınıflarını `com.example.repository.h2` paketinde tanımlayın.

```java
@Entity
@Table(name = "h2_entity")
public class H2Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    // Getters and Setters
}
```

```java
@Repository
public interface H2Repository extends JpaRepository<H2Entity, Long> {
}
```

---

#### **MySQL Entity ve Repository**
- **Entity** sınıflarını `com.example.entity.mysql` paketinde tanımlayın.
- **Repository** sınıflarını `com.example.repository.mysql` paketinde tanımlayın.

```java
@Entity
@Table(name = "mysql_entity")
public class MySQLEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    // Getters and Setters
}
```

```java
@Repository
public interface MySQLRepository extends JpaRepository<MySQLEntity, Long> {
}
```

---

### **6. Kullanım**

#### **H2 Veri Kaynağı ile Çalışma**
```java
@Autowired
private H2Repository h2Repository;

public void saveH2Data() {
    H2Entity entity = new H2Entity();
    entity.setName("H2 Data");
    h2Repository.save(entity);
}
```

#### **MySQL Veri Kaynağı ile Çalışma**
```java
@Autowired
private MySQLRepository mySQLRepository;

public void saveMySQLData() {
    MySQLEntity entity = new MySQLEntity();
    entity.setName("MySQL Data");
    mySQLRepository.save(entity);
}
```

---

### **Özet**

1. **DataSource Yapılandırması**:
  - H2 ve MySQL için ayrı `DataSource` nesneleri tanımlayın.
2. **JPA Yapılandırması**:
  - Her veritabanı için ayrı `EntityManagerFactory` ve `TransactionManager` oluşturun.
3. **Entity ve Repository**:
  - H2 ve MySQL için ayrı paketlerde Entity ve Repository sınıflarını yönetin.
4. **Ayrı Kapsamlar**:
  - `basePackages` özelliği ile hangi veri kaynağının hangi Entity/Repository sınıflarıyla çalışacağını belirtin.

Bu şekilde, Spring Boot uygulamanızda aynı anda birden fazla veri kaynağı ile çalışabilirsiniz.