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



## Spring Boot
```sh 

```
---
Spring Data, Spring Framework’ün bir parçası olup, veritabanı işlemlerini kolaylaştırmak ve veri erişim katmanında tutarlılığı sağlamak için tasarlanmış bir modüldür. Spring Data, farklı veri depoları ile (örneğin, ilişkisel veritabanları, NoSQL veritabanları, anahtar-değer depoları, grafik veritabanları) kolayca etkileşim kurulmasını sağlar ve bu veritabanları ile veri işlemlerini standartlaştırır.

Spring Data’nın temel amacı, veri erişim katmanında tekrarlayan kodları azaltmak ve veri işlemlerini daha kolay hale getirmektir. Spring Data, özellikle CRUD (Create, Read, Update, Delete) işlemlerini daha az kod yazarak gerçekleştirmeye olanak tanır ve veri erişim katmanının daha modüler ve yönetilebilir hale gelmesini sağlar.

### Spring Data’nın Faydaları ve Amacı

1. **Tekrarlayan Kodları Azaltır**: Veritabanı işlemleri için her defasında aynı CRUD kodlarını yazmak yerine, Spring Data bu işlemleri otomatik olarak oluşturur ve kod tekrarını en aza indirir.

2. **Çeşitli Veri Depolarıyla Uyumlu**: Spring Data, ilişkisel ve NoSQL veritabanları ile çalışabilen bir yapıya sahiptir. Bu, uygulamaların çok farklı veri depolarına kolayca entegre olmasını sağlar.

3. **Veritabanı İşlemlerini Basitleştirir**: Spring Data, depo (repository) arayüzleri aracılığıyla veri işlemlerini sadeleştirir. Veri işlemlerini daha okunabilir ve anlaşılır hale getiren metotlarla veri depolarına erişim sağlar.

4. **Dinamik Sorgular Oluşturur**: Spring Data, arayüz tanımlamaları aracılığıyla belirli kurallara dayalı olarak otomatik sorgular oluşturur. Örneğin, metot adlarına göre sorgular oluşturulabilir (Query Creation by Method Name).

5. **Transparan Veri Erişimi**: Spring Data, veri işlemleri sırasında hangi veritabanı teknolojisinin kullanıldığını kullanıcıdan gizler ve bu sayede, veri erişim işlemleri daha kolay ve standart hale gelir.

### Spring Data Modülleri

Spring Data, farklı veri türlerini ve veri yönetimi senaryolarını ele almak için çeşitli alt modüller içerir. Bu modüller, farklı veri depoları ile çalışmayı kolaylaştırır.

1. **Spring Data JPA**: Spring Data’nın en popüler modüllerinden biridir. Java Persistence API (JPA) üzerinde çalışan bir modüldür ve ilişkisel veritabanlarında ORM (Object-Relational Mapping) işlemlerini kolaylaştırır. Hibernate gibi JPA sağlayıcılarıyla entegre çalışır.

2. **Spring Data MongoDB**: NoSQL veritabanı olan MongoDB ile çalışmayı sağlar. MongoDB’nin özelliklerine özel olarak geliştirilmiş sınıflar ve işlemler içerir.

3. **Spring Data Redis**: Redis anahtar-değer veri deposuyla entegre çalışır. Redis, özellikle hızlı veri erişimi gereken durumlarda popülerdir ve Spring Data Redis, Redis ile hızlı ve kolay etkileşimi sağlar.

4. **Spring Data Cassandra**: Büyük veri uygulamaları için kullanılan Cassandra veritabanıyla entegre çalışır. Cassandra, yüksek ölçeklenebilirlik ve yüksek erişilebilirlik sunan bir NoSQL veritabanıdır.

5. **Spring Data Elasticsearch**: Elasticsearch arama ve analiz motoruyla çalışmak için geliştirilmiştir. Bu modül, hızlı arama ve analiz gereksinimleri olan uygulamalarda kullanılır.

6. **Spring Data JDBC**: JPA kullanmak istemeyen veya daha doğrudan SQL işlemleri yapmak isteyenler için basit bir JDBC tabanlı veri erişim modülüdür.

7. **Spring Data R2DBC**: Reactive Programming (tepkisel programlama) modelini destekleyen bir SQL veritabanı modülüdür. R2DBC, veri işlemlerinin asenkron olarak gerçekleştirilmesini sağlar.

### Spring Data Repository (Depo) Kavramı

Spring Data, veri erişim işlemlerini Repository adı verilen arayüzler üzerinden gerçekleştirir. Bu arayüzler, veri depolarıyla etkileşimi sağlar ve CRUD işlemlerini otomatik hale getirir. Spring Data, depo arayüzleri üzerinden veri erişim işlemlerini yapılandırmanızı sağlar ve karmaşık veri işlemleri için de ek işlevler sunar.

Spring Data Repository’leri üç ana kategoriye ayrılabilir:

1. **CrudRepository**: Temel CRUD işlemlerini destekleyen bir arayüzdür. `save`, `findById`, `findAll`, `deleteById` gibi metotlarla veri işlemlerini sağlar.

2. **JpaRepository**: CrudRepository’den türetilmiş ve ek JPA özellikleri sunan bir arayüzdür. Sayfalandırma (pagination) ve sıralama (sorting) gibi ek özellikler içerir.

3. **PagingAndSortingRepository**: Verilerin sayfalara bölünerek görüntülenmesi ve sıralanması gibi işlemleri destekleyen bir arayüzdür.

### Spring Data Repository Metotları

Spring Data, Repository arayüzlerine özel isimlendirme kuralları sayesinde sorguları dinamik olarak oluşturabilir. Örneğin, `findByFirstName(String firstName)` metodu, `firstName` alanına göre arama yapar. Metot adıyla sorgu oluşturma işlemi oldukça geniştir ve farklı işlemleri destekler:

- `findBy` ile başlayan metotlar: Veriyi koşula göre arama yapar.
- `countBy` ile başlayan metotlar: Verinin sayısını hesaplar.
- `deleteBy` ile başlayan metotlar: Belirli bir koşula göre veriyi siler.

Örneğin, bir müşteri deposu (CustomerRepository) için şu metotlar kullanılabilir:

```java
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
    Customer findByEmail(String email);
    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
}
```

Bu metotlar sayesinde SQL sorgusu yazmaya gerek kalmadan veri işlemleri yapılabilir.

## Spring Boot
```sh 

```
---

Bu dosyalardaki yapıyı kullanarak `deliveredQuery`, `named query`, `JPQL`, ve `native SQL` örnekleri oluşturabiliriz. İlgili örnekleri dosyalarınızdaki mevcut sınıflar üzerinden oluşturacağım.

### 1. Delivered Query
`Spring Data JPA` ile, metod isimlendirme kurallarına uyarak doğrudan yöntemler tanımlanabilir. Örneğin `IAddressRepository` arayüzünde bir adresin şehre göre aranmasını sağlayan bir `delivered query` tanımlayalım.

```java
public interface IAddressRepository extends JpaRepository<AddressEntity, Long> {
    
    // Şehre göre adresleri bulur
    List<AddressEntity> findByCity(String city);
}
```

Bu metod, otomatik olarak `city` alanına göre bir sorgu oluşturur.

### 2. Named Query
`@NamedQuery` ile tanımlanmış bir JPQL sorgusunu `AddressEntity` sınıfında tanımlayabiliriz. Örneğin, bir `named query` kullanarak `city` ve `postalCode` alanlarına göre arama yapalım.

`AddressEntity.java` dosyasına ekleyeceğimiz `@NamedQuery` örneği:

```java
@Entity
@NamedQuery(
    name = "AddressEntity.findByCityAndPostalCode",
    query = "SELECT a FROM AddressEntity a WHERE a.city = :city AND a.postalCode = :postalCode"
)
public class AddressEntity {
    // Mevcut alanlar ve diğer kodlar
}
```

Bu named query'i kullanmak için `IAddressRepository` arayüzüne bir metod ekleyebiliriz:

```java
public interface IAddressRepository extends JpaRepository<AddressEntity, Long> {

    @Query(name = "AddressEntity.findByCityAndPostalCode")
    List<AddressEntity> findByCityAndPostalCode(@Param("city") String city, @Param("postalCode") String postalCode);
}
```

### 3. JPQL Query
`JPQL` (Java Persistence Query Language) ile `@Query` anotasyonu kullanarak belirli kriterlere göre sorgular tanımlayabiliriz. Örneğin, tüm `city` alanı `null` olmayan adresleri getirecek bir JPQL sorgusu:

```java
public interface IAddressRepository extends JpaRepository<AddressEntity, Long> {

    @Query("SELECT a FROM AddressEntity a WHERE a.city IS NOT NULL")
    List<AddressEntity> findAllWithNonNullCity();
}
```

Bu yöntem, tüm `city` değeri dolu olan adresleri getirir.

### 4. Native SQL Query
`native SQL` kullanarak doğrudan SQL sorgusu çalıştırmak için `@Query` anotasyonunu `nativeQuery` özelliği ile kullanabiliriz. Örneğin, `city` alanına göre adresleri getiren bir native SQL sorgusu:

```java
public interface IAddressRepository extends JpaRepository<AddressEntity, Long> {

    @Query(value = "SELECT * FROM address_entity WHERE city = :city", nativeQuery = true)
    List<AddressEntity> findByCityNative(@Param("city") String city);
}
```

Bu sorgu doğrudan SQL kullanır ve `address_entity` tablosunda `city` değerine göre filtreleme yapar.

Bu örneklerde:
- `deliveredQuery` otomatik olarak `findBy` ile yapılır.
- `@NamedQuery` kullanarak sorguları doğrudan sınıfın üzerine tanımlayabiliriz.
- `JPQL` ile `@Query` anotasyonunda HQL benzeri sorgular yazabiliriz.
- `native SQL` ile direkt SQL komutları çalıştırabiliriz.

Her bir yöntem, sorgu ihtiyaçlarınıza göre kullanabileceğiniz esnek çözümler sağlar.


## Spring Boot
```sh 

```
---


### Delivered Query, Named Queries, JPQL ve Native SQL Nedir?

Bu kavramlar, Spring Data JPA ve JPA (Java Persistence API) çerçevesinde kullanılan çeşitli sorgulama yöntemleridir. Her birinin belirli özellikleri ve kullanım alanları vardır. Aşağıda, her birini ayrıntılı olarak açıklayarak, aralarındaki farkları ortaya koyacağız.

---

### 1. Delivered Query (Türetilmiş Sorgular)

**Delivered Query** veya **Türetilmiş Sorgular**, Spring Data JPA’nın sağladığı bir özelliktir. Spring Data, repository arayüzünde tanımlanan metod isimlerinden otomatik olarak sorgu oluşturur. Bu özellik, SQL veya JPQL sorgusu yazma ihtiyacını ortadan kaldırır ve metod isimlendirme kurallarına göre sorguları otomatik olarak türetir.

#### Delivered Query Nasıl Çalışır?

Spring Data JPA, repository metod adlarını analiz ederek, metod adındaki anahtar kelimeleri kullanarak bir sorgu oluşturur. Örneğin, metod adı `findByCity` ise, Spring Data, `city` alanına göre bir sorgu türetir.

#### Örnekler

```java
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
    List<AddressEntity> findByCity(String city);
}
```

Bu metod adı, Spring Data tarafından şu SQL sorgusuna dönüştürülür:

```sql
SELECT * FROM address_entity WHERE city = ?;
```

Spring Data ayrıca `And`, `Or`, `GreaterThan`, `LessThan` gibi çeşitli anahtar kelimelerle daha karmaşık sorgular türetebilir:

```java
List<AddressEntity> findByCityAndZipCode(String city, String zipCode);
```

Bu metod, `city` ve `zipCode` alanlarına göre bir sorgu oluşturur ve şu sorguya eşdeğerdir:

```sql
SELECT * FROM address_entity WHERE city = ? AND zip_code = ?;
```

#### Avantajları
- **Kolay Kullanım**: Metod isimlendirmesi ile sorgu oluşturmayı sağlar.
- **Bakımı Kolay**: Kodlar anlaşılır ve bakımı kolaydır.
- **Otomatik Optimizasyon**: Spring Data, türetilen sorguları optimize eder.

#### Dezavantajları
- **Karmaşık Sorgular İçin Kısıtlı**: Karmaşık sorgular türetmek zor olabilir.
- **Performans Kontrolü**: Otomatik olarak türetilen sorguların performansını kontrol etmek zor olabilir.

---

### 2. Named Queries

**Named Query (Adlandırılmış Sorgu)**, JPA'nın sağladığı, bir entity sınıfına bağlı olarak tanımlanan önceden tanımlı SQL veya JPQL sorgularıdır. Named Queries, `@NamedQuery` anotasyonu kullanılarak entity sınıfı üzerinde tanımlanır ve sorgu çalıştırılmak istendiğinde bu adı kullanarak çağrılır.

#### Named Query Tanımlama

`@NamedQuery` anotasyonu, entity sınıfı üzerinde sorguyu tanımlar. Örneğin:

```java
@Entity
@NamedQuery(
    name = "AddressEntity.findByCity",
    query = "SELECT a FROM AddressEntity a WHERE a.city = :city"
)
public class AddressEntity {
    // Alanlar ve metodlar...
}
```

Bu Named Query, `AddressEntity` sınıfına bağlıdır ve `city` parametresine göre sorgu yapar.

#### Named Query Kullanımı

Named Query'yi repository içinde `@Query` anotasyonunu kullanarak çağırabilirsiniz:

```java
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
    
    @Query(name = "AddressEntity.findByCity")
    List<AddressEntity> findAddressesByCity(@Param("city") String city);
}
```

#### Avantajları
- **Kod Tekrarını Azaltır**: Aynı sorguyu birden fazla yerde kullanma olanağı sağlar.
- **Daha Okunabilir Kodlar**: Karmaşık sorgular için daha anlaşılır kod sağlar.
- **Önceden Tanımlanmış Sorgular**: Sorgular önceden tanımlandığı için yönetimi kolaydır.

#### Dezavantajları
- **Performans Yönetimi**: Tüm Named Queries’in bellekte saklanması, performans etkisine neden olabilir.
- **Değiştirilebilirlik**: Sorguyu değiştirmek istediğinizde, entity sınıfında değişiklik yapmanız gerekebilir.

---

### 3. JPQL (Java Persistence Query Language)

**JPQL (Java Persistence Query Language)**, JPA'nın sağladığı, SQL'e benzeyen ama tamamen entity sınıflarına yönelik bir sorgulama dilidir. SQL’den farklı olarak JPQL, doğrudan veri tabanı tablolarına değil, Java sınıflarına ve alanlarına odaklanır.

#### JPQL Kullanımı

JPQL, repository metodları üzerinde `@Query` anotasyonu ile tanımlanabilir. JPQL'de entity sınıfı ve alan adları kullanılır:

```java
@Query("SELECT a FROM AddressEntity a WHERE a.city = :city")
List<AddressEntity> findByCity(@Param("city") String city);
```

Bu JPQL sorgusu, `city` alanına göre `AddressEntity` nesnelerini döndürür.

#### JPQL Operatörleri
JPQL, SQL gibi `SELECT`, `WHERE`, `JOIN`, `GROUP BY` ve `ORDER BY` gibi komutları destekler. JPQL ile ayrıca `IN`, `LIKE`, `BETWEEN`, `IS NULL` gibi operatörler de kullanılabilir.

#### Avantajları
- **Entity Odaklı**: JPQL, entity sınıflarına ve alanlara odaklandığından nesneye yönelik bir yaklaşım sunar.
- **Platform Bağımsız**: Veri tabanı bağımsız çalışır ve her veri tabanına uyum sağlar.

#### Dezavantajları
- **SQL’den Daha Az Esnek**: JPQL, SQL kadar esnek değildir ve bazı veri tabanı özel fonksiyonlarını desteklemeyebilir.
- **Performans Sorunları**: Karmaşık JPQL sorguları performans sorunlarına neden olabilir.

---

### 4. Native SQL

**Native SQL**, JPA'da doğrudan SQL sorguları yazma yöntemidir. Native SQL sorguları veri tabanına özgüdür ve SQL'in tüm özelliklerinden faydalanabilir. Native sorgular, `@Query` anotasyonu içinde `nativeQuery = true` parametresi ile kullanılır.

#### Native SQL Kullanımı

Aşağıda, doğrudan SQL sorgusu kullanan bir örnek verilmiştir:

```java
@Query(value = "SELECT * FROM address_entity WHERE city = ?1", nativeQuery = true)
List<AddressEntity> findByCityNative(String city);
```

Bu sorgu, doğrudan `address_entity` tablosundan `city` alanına göre veri çeker.

#### Avantajları
- **Tam SQL Desteği**: Veri tabanı özel fonksiyonları ve özellikleri kullanılabilir.
- **Performans**: Özelleştirilmiş ve optimize edilmiş sorgularla yüksek performans sağlar.
- **SQL’in Gücü**: SQL'in tüm özelliklerinden faydalanarak daha karmaşık işlemler yapılabilir.

#### Dezavantajları
- **Platform Bağımlılığı**: Native SQL sorguları, veri tabanına bağımlıdır ve taşınabilirlik sorunu oluşturabilir.
- **Kod Anlaşılır Olmayabilir**: SQL kodu, Java kodu ile iç içe geçtiğinde, kodun okunabilirliği azalabilir.

---

### Delivered Query, Named Query, JPQL ve Native SQL Arasındaki Farklar

| Özellik           | Delivered Query                       | Named Query                          | JPQL                                  | Native SQL                           |
|-------------------|--------------------------------------|--------------------------------------|---------------------------------------|--------------------------------------|
| **Tanım**         | Spring Data tarafından metod isimlerine göre türetilen sorgular | Entity sınıfında önceden tanımlanan sorgular | Entity sınıflarına yönelik SQL benzeri sorgu dili | Doğrudan veri tabanı SQL sorgusu |
| **Kullanım**      | Repository metod adı üzerinden       | `@NamedQuery` ile entity sınıfında   | `@Query` anotasyonu ile repository'de | `@Query` ile `nativeQuery=true`      |
| **Veri Tabanı Bağımlılığı** | Bağımsız                             | Bağımsız                             | Bağımsız                              | Veri tabanı bağımlı                  |
| **Esneklik**      | Düşük                                | Orta                                 | Yüksek                                | Çok yüksek                           |
| **Kod Anlaşılır mı?** | Evet                              | Evet                                 | Orta                                  | Hayır                                |
| **Performans**    | Orta                                 | Orta                                 | Orta                                  | Yüksek                               |
| **Uygulama Alanı**| Basit ve hızlı sorgular              | Tekrar eden karmaşık sorgular        | Orta seviye sorgular                  | Karmaşık ve özelleştirilmiş sorgular |

---

### Özet

- **Delivered Query**: Spring Data metod adlarına göre otomatik türetilen sorgular, basit ve hızlı işlemler için idealdir.
- **Named Query**: Entity sınıflarında önceden tanımlanan, tekrarlanan sorgular için kullanılan yapılar.
- **JPQL**: Java sınıflarına yönelik SQL benzeri bir sorgu dilidir. SQL'den farkı, tablo isimleri yerine Java entity sınıflarının kullanılmasıdır. Platform bağımsız çalışır ve SQL gibi `SELECT`, `WHERE`, `JOIN` gibi ifadeleri destekler. Daha nesneye yönelik bir sorgulama sağladığından, JPA’nın sunduğu standart özellikler çerçevesinde kompleks işlemler yapılabilir.
- **Native SQL**: Doğrudan SQL sorgularını kullanmamıza olanak tanır. Bu sayede SQL’in tüm özelliklerinden faydalanabiliriz. Native SQL, veri tabanına özgü sorgular yazmayı mümkün kılar, ancak platform bağımlılığı oluşturabilir. Karmaşık ve optimize edilmesi gereken işlemler için tercih edilir.

---

### Hangi Durumda Hangisini Kullanmalı?

1. **Basit Sorgular İçin**: `Delivered Query` tercih edilmelidir. Metod isimlerine göre türetilen bu sorgular, hızlıca basit işlemler yapmak için idealdir.

2. **Tekrarlayan veya Statik Sorgular İçin**: `Named Query` en uygun seçenektir. Sorguyu bir kere tanımlayıp farklı yerlerde kullanmak için idealdir.

3. **Orta Derecede Karmaşık Sorgular İçin**: `JPQL` daha iyi bir seçimdir. Entity odaklı ve veri tabanı bağımsız çalıştığı için taşınabilirliği yüksektir.

4. **Karmaşık veya Optimize Edilmiş Sorgular İçin**: `Native SQL` en iyi seçenektir. Veri tabanı özelliklerinden tam anlamıyla faydalanmak gerektiğinde ve yüksek performans gereken durumlarda native SQL tercih edilmelidir.

---

### Örnek Senaryo Uygulamaları

Aşağıda, her bir sorgulama yöntemi için örnek bir senaryo yer almaktadır:

#### Delivered Query Örneği

Bir kullanıcı adıyla (username) kullanıcıları listelemek için basit bir sorguya ihtiyaç duyduğunuzu düşünün. Bu durumda, metod ismine göre delivered query kullanabilirsiniz:

```java
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
}
```

#### Named Query Örneği

Bir müşteri sınıfında (`CustomerEntity`) çok sık kullanılan bir sorgu olduğunu ve müşteri şehirlerine göre arama yapıldığını varsayalım. Bu sorguyu `CustomerEntity` içinde bir Named Query olarak tanımlayabiliriz:

```java
@Entity
@NamedQuery(
    name = "CustomerEntity.findByCity",
    query = "SELECT c FROM CustomerEntity c WHERE c.city = :city"
)
public class CustomerEntity {
    // Alanlar...
}
```

Daha sonra `CustomerRepository` içinde bu sorguyu şu şekilde kullanabiliriz:

```java
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    @Query(name = "CustomerEntity.findByCity")
    List<CustomerEntity> findByCity(@Param("city") String city);
}
```

#### JPQL Örneği

Bir `Product` entity’sinde fiyat aralığına göre ürünleri listelemek istediğinizi düşünelim. Bu durumda JPQL kullanarak sorguyu repository’de yazabilirsiniz:

```java
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<Product> findProductsInPriceRange(@Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice);
}
```

Bu sorgu, belirtilen fiyat aralığındaki ürünleri listeleyecektir.

#### Native SQL Örneği

Doğrudan SQL kullanarak optimize edilmiş bir sorgu yazmanız gerektiğinde Native SQL tercih edilir. Örneğin, bir `Employee` tablosunda en yüksek maaşı alan çalışanı listelemek için şu şekilde bir Native SQL sorgusu kullanılabilir:

```java
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT * FROM employee WHERE salary = (SELECT MAX(salary) FROM employee)", nativeQuery = true)
    List<Employee> findTopEarningEmployees();
}
```

---

### Sonuç ve Öneriler

Her bir sorgu türü farklı senaryolarda kullanıma uygundur. Uygulamanızın ihtiyaçlarına göre doğru sorgu türünü seçmek performans ve sürdürülebilirlik açısından büyük önem taşır:

- **Basit ve Hızlı Sorgular İçin**: `Delivered Query` tercih edin.
- **Tekrar Eden Sorgular İçin**: `Named Query` ile önceden tanımlanan sorguları kullanın.
- **Platform Bağımsız, Nesneye Yönelik Sorgular İçin**: `JPQL` kullanarak veri tabanı bağımsızlığını koruyun.
- **Optimize Edilmiş ve Karmaşık Sorgular İçin**: `Native SQL` kullanarak veri tabanının gücünden tam olarak faydalanın.

Bu dört sorgu türü sayesinde Spring Data JPA, her türlü veri tabanı sorgulama ihtiyacına esnek ve güçlü çözümler sunar.


## Spring Boot
```sh 

```
---



### Custom Queries (Özelleştirilmiş Sorgular)

Spring Data, bazı karmaşık sorgular için özel sorgular tanımlama imkanı da sunar. Bunun için iki ana yöntem vardır:

1. **@Query Anotasyonu**: Özel sorgular tanımlamak için kullanılan anotasyondur. Native SQL veya JPQL (Java Persistence Query Language) ile sorgular yazılabilir.

   ```java
   @Query("SELECT c FROM Customer c WHERE c.firstName = ?1 AND c.lastName = ?2")
   List<Customer> findByFirstAndLastName(String firstName, String lastName);
   ```

2. **Named Queries**: Entity sınıflarında tanımlanan, sabit isimli sorgulardır. Bu sorgular, genellikle Entity sınıfının başında tanımlanır ve isimlerine göre çağrılabilir.


Spring Boot ve JPA ile çalışırken veritabanına veri sorgulamak veya veri üzerinde işlemler gerçekleştirmek için iki ana sorgu türü kullanılır: **Native SQL** ve **JPQL (Java Persistence Query Language)**. Bu iki sorgu türü, JPA ile veri çekme veya güncelleme işlemlerinde esneklik sağlar, ancak kullanım alanları ve amaçları farklıdır. Aşağıda her iki yöntemin ayrıntılı bir açıklaması bulunmaktadır.

### 1. JPQL (Java Persistence Query Language)

JPQL, JPA ile birlikte kullanılan, nesne odaklı bir sorgulama dilidir. JPQL, doğrudan SQL sorgularına dayanmaz, bunun yerine **entity nesneleri üzerinden çalışır**. Bu, veri tabanındaki tablolarla değil, JPA entity sınıflarıyla etkileşim kurar. JPQL, entity nesneleri ve onların ilişkileri ile nesne yönelimli veri çekme işlemleri için tasarlanmıştır.

#### JPQL’in Özellikleri

- **Nesne Odaklıdır**: JPQL sorguları, veritabanı tabloları yerine Java sınıflarına göre yazılır. Bu nedenle SQL’den farklıdır; veri tabanındaki fiziksel tablo adları yerine Java sınıf adları ve alan adları kullanılır.
- **Veritabanı Bağımsızdır**: JPQL sorguları, JPA tarafından desteklenen herhangi bir veritabanında çalışacak şekilde soyutlanmıştır. JPQL, veritabanı bağımsız bir yapı sunduğundan, farklı veritabanları arasında geçiş yaparken kodda değişiklik yapma gereksinimi azaltır.
- **Kolay ve Güçlü**: JPQL, SQL’e benzer bir söz dizimine sahiptir, ancak nesneye yönelik olarak optimize edilmiştir. SQL sorgularına göre daha sade ve anlaşılırdır, özellikle karmaşık veri çekme işlemlerinde ilişki yönetimini daha kolay hale getirir.

#### JPQL Kullanımı

JPQL sorguları **@Query** anotasyonu ile yazılır veya bir `EntityManager` üzerinden çalıştırılabilir. JPQL'de temel olarak `SELECT`, `UPDATE`, `DELETE` ve `INSERT` komutları bulunur.

##### Örnek 1: JPQL ile Veri Çekme

Varsayalım bir **User** entity sınıfımız var ve bu entity üzerinden kullanıcıları yaşlarına göre çekmek istiyoruz.

```java
@Entity
public class User {
    @Id
    private Long id;
    private String name;
    private int age;
    // Getter ve Setter'lar
}
```

JPQL sorgusu ile kullanıcıları yaşlarına göre çekmek:

```java
@Query("SELECT u FROM User u WHERE u.age > :age")
List<User> findUsersOlderThan(@Param("age") int age);
```

Burada **User** entity’si ve **age** alanı doğrudan kullanılmıştır. JPQL sorgusunda tablo adı veya sütun adları yerine entity sınıfının adı ve özellikleri kullanılır.

##### Örnek 2: JPQL ile Güncelleme

JPQL aynı zamanda güncelleme işlemleri için de kullanılabilir.

```java
@Modifying
@Query("UPDATE User u SET u.age = :newAge WHERE u.id = :id")
int updateUserAge(@Param("id") Long id, @Param("newAge") int newAge);
```

Bu örnekte, belirli bir kullanıcı ID’sine sahip olan kaydın yaşını güncellemekteyiz.

#### JPQL’in Avantajları

- **Veritabanı bağımsızlığı**: JPQL sorguları, herhangi bir SQL varyantına bağlı kalmadan çalışabilir.
- **Nesne odaklılık**: Veritabanı tablolarına değil, entity nesnelerine dayanır.
- **Sade yapı**: JPQL, entity ilişkilerini daha sade ve anlaşılır bir şekilde yönetir, bu da daha temiz kod sağlar.

#### JPQL’in Dezavantajları

- **Karmaşık sorgularda sınırlamalar**: JPQL, bazı durumlarda çok karmaşık ve özel veritabanı işlemleri için yeterli olmayabilir.
- **Performans sınırlamaları**: Bazı özel performans gereksinimleri için JPQL yeterli olmayabilir, çünkü veritabanına özgü optimizasyonlardan yoksundur.

---

### 2. Native SQL

**Native SQL** sorguları, doğrudan SQL söz dizimini kullanarak yazılır. Bu sorgular, JPA'nın soyutlama katmanından geçmez, doğrudan veritabanına gönderilir. Native SQL, veritabanına özgü komutları veya optimizasyonları kullanmanıza olanak tanır, bu da karmaşık işlemlerde performans avantajı sağlar.

#### Native SQL’in Özellikleri

- **Veritabanı Odaklıdır**: SQL sorguları doğrudan veritabanı tabloları üzerinde çalışır, bu da karmaşık işlemler veya veritabanına özel komutlar gerektiğinde daha etkilidir.
- **Performans Avantajı Sağlar**: Özellikle büyük veri setleri üzerinde, veritabanına özgü optimizasyonlardan yararlanarak daha hızlı sonuçlar elde edilebilir.
- **SQL Söz Dizimi Kullanılır**: JPQL’in aksine, Native SQL sorguları doğrudan SQL komutları ile yazılır, bu da SQL bilen geliştiriciler için daha tanıdık olabilir.

#### Native SQL Kullanımı

**@Query** anotasyonunun içine **nativeQuery = true** parametresi eklenerek Native SQL sorgusu tanımlanabilir.

##### Örnek 1: Native SQL ile Veri Çekme

Yine **User** entity’sini ele alalım ve kullanıcıları yaşlarına göre çekmek için Native SQL sorgusu yazalım:

```java
@Query(value = "SELECT * FROM users WHERE age > :age", nativeQuery = true)
List<User> findUsersOlderThan(@Param("age") int age);
```

Burada doğrudan **users** tablosu üzerinden SQL komutu ile işlem yapılmaktadır. Veritabanı tablosu adı ve sütun adları doğrudan SQL söz dizimi ile belirtilmiştir.

##### Örnek 2: Native SQL ile Güncelleme

Native SQL ile bir güncelleme işlemi yapalım:

```java
@Modifying
@Query(value = "UPDATE users SET age = :newAge WHERE id = :id", nativeQuery = true)
int updateUserAge(@Param("id") Long id, @Param("newAge") int newAge);
```

Bu sorguda, doğrudan veritabanı tablosu ve sütun adları kullanılarak SQL sorgusu çalıştırılmaktadır.

#### Native SQL’in Avantajları

- **Veritabanına Özgü İşlemler**: Native SQL ile, JPQL’in sınırlarının ötesinde karmaşık sorgular veya veritabanına özel işlemler gerçekleştirebilirsiniz.
- **Performans Optimizasyonu**: Veritabanına özgü optimizasyonları kullanarak daha hızlı sorgular oluşturabilirsiniz.
- **Daha Fazla Esneklik**: Native SQL, JPQL'in sınırlamaları olan karmaşık sorguların üstesinden gelir ve daha esnek bir yapı sunar.

#### Native SQL’in Dezavantajları

- **Veritabanı Bağımlılığı**: Native SQL sorguları, belirli bir veritabanına özgü olduğunda, farklı bir veritabanına geçildiğinde çalışmayabilir.
- **Kod Karmaşıklığı**: SQL sorgularını doğrudan kullanmak, JPQL’e göre kodu daha karmaşık hale getirebilir.
- **Nesne Odaklı Değil**: Native SQL doğrudan tablo adları ve sütunlarla çalıştığı için nesne odaklı mimari ile tamamen uyumlu olmayabilir.

---

### JPQL ve Native SQL Arasındaki Farklar

| Özellik                  | JPQL                                  | Native SQL                             |
|--------------------------|---------------------------------------|----------------------------------------|
| Söz Dizimi               | Nesne odaklı, entity sınıflarına göre | Veritabanı odaklı, tablo ve sütun isimlerine göre |
| Veritabanı Bağımsızlığı  | Evet                                  | Hayır                                  |
| Performans               | Orta                                  | Yüksek (veritabanına özel optimizasyon)|
| Karmaşık Sorgu Desteği   | Sınırlı                               | Geniş                                  |
| Kullanım Kolaylığı       | Daha kolay ve anlaşılır               | SQL bilgisi gerektirir                 |

### Hangi Durumda Hangisini Kullanmalıyız?

- **Nesne Odaklı ve Basit Sorgular**: JPQL tercih edilmelidir. JPQL, nesne odaklı bir yapıya sahip olduğundan daha temiz ve anlaşılır kod sağlar.
- **Karmaşık veya Performans Gerektiren Sorgular**: Native SQL tercih edilebilir. Native SQL, doğrudan SQL sorgularını kullanmanıza izin verir, bu nedenle karmaşık işlemler için daha esnektir.

JPQL ve Native SQL, Spring Boot ve JPA ile çalışırken veritabanı işlemlerini optimize etmek için kullanabileceğiniz güçlü araçlardır. Tercih ettiğiniz yöntem, projenizin ihtiyaçlarına ve veritabanı yapınıza bağlı olarak değişiklik gösterebilir.

## Spring Boot
```sh 

```
---

Spring Boot ve JPA ile veri işlemleri gerçekleştirirken, sorguları yönetmek için **Named Queries**, **Native SQL**, ve **JPQL (Java Persistence Query Language)** gibi çeşitli seçenekler mevcuttur. Her biri farklı ihtiyaçlara göre kullanılır ve avantajlar ile dezavantajlar sunar. Bu üç yöntemin arasındaki farkları ve kullanım alanlarını ayrıntılı olarak açıklayacağım.

### Named Queries (Adlandırılmış Sorgular)

Named Queries, JPA ile birlikte tanımlanan ve belirli bir adı olan, tekrar kullanılabilir sorgulardır. Sorgular, genellikle entity sınıfları üzerinde **@NamedQuery** veya **@NamedNativeQuery** anotasyonları ile tanımlanır. Bu sayede, aynı sorgu birden fazla yerde kullanılması gerektiğinde kod tekrarı yapılmadan bu sorguya başvurulabilir.

#### Named Queries’in Özellikleri

- **Tekrar Kullanılabilirlik**: Named Queries, bir kere tanımlandıktan sonra uygulamanın her yerinde kullanılabilir.
- **Kodun Temizlenmesi**: Sorgu tanımları entity sınıfı içinde tanımlandığından, sorgu mantığı doğrudan kod içinde yazılmaz ve böylece daha temiz bir kod yapısı elde edilir.
- **Statik Tanımlama**: Named Queries uygulama başlatıldığında derlenir, bu nedenle çalışma sırasında herhangi bir hata oluşmaz. Sorgu hataları uygulama başlatıldığında fark edilir.
- **Performans**: JPA, Named Queries’i uygulama başlatıldığında derlediği için, çalışma sırasında daha hızlı çalışır.

#### Named Queries Kullanımı

##### JPQL ile Named Query Tanımlama:

```java
@Entity
@NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name")
public class User {
    @Id
    private Long id;
    private String name;
    // Getter ve Setter'lar
}
```

Bu örnekte, **User.findByName** adında bir Named Query tanımlanmıştır. Bu sorgu, `User` entity’sindeki **name** alanına göre veri çekmektedir.

Bu sorguyu bir repository'de kullanmak için:

```java
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(name = "User.findByName")
    List<User> findByName(@Param("name") String name);
}
```

##### Native SQL ile Named Query Tanımlama:

```java
@Entity
@NamedNativeQuery(name = "User.findByAgeNative", query = "SELECT * FROM users WHERE age = :age", resultClass = User.class)
public class User {
    @Id
    private Long id;
    private String name;
    private int age;
    // Getter ve Setter'lar
}
```

Bu sorgu ise **User.findByAgeNative** adında bir Native SQL sorgusudur ve doğrudan SQL ile yazılmıştır.

#### Named Queries Avantajları

- **Tekrar Kullanılabilirlik**: Birden fazla yerde aynı sorguyu tekrar tanımlamadan kullanabilirsiniz.
- **Performans Artışı**: Uygulama başlatıldığında derlendiği için sorgu hataları çalışma sırasında değil, başlangıçta fark edilir.
- **Statik Yapı**: Named Queries uygulama başlatılırken çalıştığından, sorguların geçerliliği önceden kontrol edilir ve çalışma zamanı hatalarının önüne geçilir.

#### Named Queries Dezavantajları

- **Esneklik Eksikliği**: Named Queries, sabit sorgular olarak tanımlanır, bu nedenle dinamik bir sorgu gereksiniminde yeterli esneklik sağlamayabilir.
- **Kod Karmaşası**: Çok fazla Named Query tanımlandığında entity sınıfları karmaşık hale gelebilir.

---

### JPQL (Java Persistence Query Language)

JPQL, JPA ile birlikte çalışan nesne odaklı bir sorgulama dilidir ve doğrudan SQL kullanmadan, Java sınıflarına göre sorgu yazmayı sağlar. JPQL, entity sınıfları üzerinden çalışır ve bu nedenle nesne tabanlıdır.

#### JPQL’in Özellikleri

- **Nesne Odaklı**: JPQL, doğrudan tablo ve sütun adları yerine Java sınıfları ve alanları üzerinde çalışır.
- **Veritabanı Bağımsızlığı**: JPQL sorguları, JPA tarafından desteklenen herhangi bir veritabanında çalışacak şekilde soyutlanmıştır. Bu sayede veritabanı bağımsızlığı sağlar.
- **İlişki Yönetimi**: JPQL, entity sınıfları arasındaki ilişkileri yönetmek için oldukça uygundur, bu da ilişkisel veritabanı işlemlerini daha kolay hale getirir.

#### JPQL Kullanımı

JPQL sorguları **@Query** anotasyonu ile yazılabilir.

```java
@Query("SELECT u FROM User u WHERE u.name = :name")
List<User> findByName(@Param("name") String name);
```

Bu örnekte JPQL, doğrudan User sınıfı üzerinden sorgulama yaparak veritabanında **name** alanına göre veri çeker.

#### JPQL Avantajları

- **Nesne Odaklı ve Veritabanı Bağımsız**: JPQL, nesne yönelimli bir yapı sunar ve veritabanı bağımsızlığı sağlar.
- **Kolay İlişki Yönetimi**: JPQL, entity ilişkilerini yönetmek için kolay bir yol sunar, bu da daha sade ve okunabilir kod sağlar.
- **Temiz Kod**: JPQL, entity sınıfı özelliklerini doğrudan kullanır, bu nedenle SQL komutlarına göre daha temiz ve anlaşılır bir yapı sağlar.

#### JPQL Dezavantajları

- **Veritabanı Özgü Optimizasyonlardan Yoksun**: JPQL, veritabanı bağımsız bir yapıya sahip olduğundan, veritabanına özgü optimizasyonları kullanmaz.
- **Karmaşık Sorgu Desteği Sınırlı**: JPQL, özellikle karmaşık ve veritabanına özgü işlemlerde sınırlıdır.

---

### Native SQL

Native SQL, doğrudan SQL komutları kullanılarak yazılan sorgulardır. Bu tür sorgular, veritabanı bağımsız değildir ve doğrudan veritabanı tabloları ve sütun adları kullanılarak çalıştırılır. Native SQL ile veritabanına özgü özellikleri ve optimizasyonları kullanmak mümkündür.

#### Native SQL’in Özellikleri

- **Veritabanı Bağımlılığı**: Native SQL, belirli bir veritabanına özgü SQL söz dizimini kullanır ve bu nedenle veritabanı bağımlıdır.
- **Karmaşık ve Özel Sorgular İçin Uygundur**: Native SQL, karmaşık ve veritabanına özgü sorgular için idealdir.
- **Performans Avantajı**: Native SQL, veritabanına özgü optimizasyonları kullanarak yüksek performans sağlar.

#### Native SQL Kullanımı

Native SQL sorguları, **@Query** anotasyonunun içinde `nativeQuery = true` parametresi ile belirtilir.

```java
@Query(value = "SELECT * FROM users WHERE age > :age", nativeQuery = true)
List<User> findUsersOlderThan(@Param("age") int age);
```

Bu örnekte doğrudan SQL ile yazılmış bir sorgu kullanılmıştır.

#### Native SQL Avantajları

- **Karmaşık Sorgular için Uygun**: Native SQL, özellikle karmaşık ve veritabanına özgü işlemler için idealdir.
- **Performans Artışı**: Veritabanına özgü optimizasyonları kullanarak daha hızlı sorgular sağlar.
- **Esneklik**: Veritabanı özelliklerinden tam anlamıyla yararlanır, böylece JPQL’in sınırlamalarını aşabilirsiniz.

#### Native SQL Dezavantajları

- **Veritabanı Bağımlılığı**: Native SQL, belirli bir veritabanına özgü olduğundan, başka bir veritabanına geçişte sorunlar oluşturabilir.
- **Kod Karmaşıklığı**: SQL sorgularını doğrudan kullanmak kodu daha karmaşık hale getirebilir.
- **Veritabanı Bağımsızlığı Eksikliği**: Native SQL, belirli bir veritabanına bağımlıdır ve başka bir veritabanına geçildiğinde kodda değişiklik yapılması gerekir.

---

### Named Queries, JPQL ve Native SQL Arasındaki Farklar

| Özellik                  | Named Queries                          | JPQL                                  | Native SQL                              |
|--------------------------|----------------------------------------|---------------------------------------|-----------------------------------------|
| Sorgu Yapısı             | Statik, entity sınıfı üzerinde tanımlanır | Nesne odaklı, entity sınıfları üzerinden | Doğrudan SQL komutları ile yazılır      |
| Tekrar Kullanılabilirlik | Yüksek, birden fazla yerde kullanılabilir | Tekrar kullanılabilir ancak entity sınıfına bağlıdır | Düşük, genelde özel durumlar için      |
| Veritabanı Bağımsızlığı  | Evet (JPQL ile tanımlıysa)             | Evet                                  | Hayır                                   |
| Performans               | Uygulama başlatıldığında derlenir, hızlıdır | Orta, veritabanı bağımsızlığı sağlar | Yüksek, veritabanına

özgü optimizasyonlar kullanır |
| Karmaşık Sorgu Desteği   | Orta, genelde basit sorgular için      | Orta                                  | Yüksek, veritabanına özgü sorgular yapılabilir |
| Kolaylık                 | Kolay, kodda dağılmamış yapı sunar     | Kolay, nesne odaklı yapıya sahip      | SQL bilgisi gerektirir                  |

### Özet ve Hangi Durumda Hangi Yöntem Kullanılmalı?

- **Named Queries**: Tekrar kullanılabilir, statik sorgular gerektiğinde ve aynı sorguyu birden fazla yerde kullanmak gerektiğinde tercih edilmelidir.
- **JPQL**: Nesne odaklı, veritabanı bağımsız sorgular için idealdir. JPA entity ilişkilerini yönetirken ve temel CRUD işlemlerinde daha çok tercih edilmelidir.
- **Native SQL**: Veritabanına özgü sorgular gerektiğinde, karmaşık işlemler ve özel performans ihtiyaçlarında kullanılır.

Her üç yöntemin de kendine özgü avantajları ve kullanım alanları vardır. Projenizin ihtiyaçlarına göre en uygun sorgu yöntemi belirlenmelidir.



## Spring Data Genel
```sh 

```
---

Spring Data Entity, Java Persistence API (JPA) ile çalışan ve veritabanındaki tabloları Java nesneleri ile eşleştiren sınıflardır. Entity sınıfları, bir tabloyu temsil eder ve veritabanı işlemlerinde kullanılır. Bu sınıflar, JPA tarafından sağlanan çeşitli özellikler ve anotasyonlarla zenginleştirilebilir. İşte Spring Data Entity'nin temel özellikleri ve detaylı açıklamaları:

---

### 1. **@Entity**
- Bir sınıfın bir veritabanı tablosunu temsil ettiğini belirtir.
- Bu anotasyon olmadan sınıf bir Entity olarak kabul edilmez.

**Örnek:**
```java
@Entity
public class Customer {
    @Id
    private Long id;
    private String name;
}
```

---

### 2. **@Table**
- Tablo ismini özelleştirmek için kullanılır. Eğer belirtilmezse, sınıf ismi tablo ismi olarak kullanılır.
- `schema` ve `catalog` gibi özelliklerle şema veya katalog adı belirtebilirsiniz.

**Örnek:**
```java
@Entity
@Table(name = "customers", schema = "public")
public class Customer {
    @Id
    private Long id;
    private String name;
}
```

---

### 3. **@Id**
- Birincil anahtar (Primary Key) sütununu belirtir.
- Entity sınıfında bir tane `@Id` alanı olmak zorundadır.

**Örnek:**
```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

---

### 4. **@GeneratedValue**
- Birincil anahtarın nasıl oluşturulacağını belirtir.
- Stratejiler:
    - `AUTO`: Varsayılan stratejiyi kullanır.
    - `IDENTITY`: Veritabanının otomatik artan özelliğini kullanır.
    - `SEQUENCE`: Bir sıra kullanır.
    - `TABLE`: Bir tablo kullanır.

**Örnek:**
```java
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
@SequenceGenerator(name = "customer_seq", sequenceName = "customer_sequence", allocationSize = 1)
private Long id;
```

---

### 5. **@Column**
- Sütun özelliklerini tanımlamak için kullanılır.
- Özellikler:
    - `name`: Sütun adını belirler.
    - `nullable`: NULL değer alıp almayacağını belirtir.
    - `unique`: Benzersiz olup olmadığını belirtir.
    - `length`: String türü için maksimum uzunluğu belirtir.
    - `columnDefinition`: Özel bir SQL tanımı sağlar.

**Örnek:**
```java
@Column(name = "full_name", nullable = false, length = 50)
private String name;
```

---

### 6. **@Transient**
- Bir alanın veritabanında bir sütun olarak saklanmasını engeller.
- Bu alan sadece uygulama içinde kullanılabilir.

**Örnek:**
```java
@Transient
private String temporaryData;
```

---

### 7. **@Enumerated**
- Enum türündeki bir alanın nasıl saklanacağını belirtir.
- Türler:
    - `EnumType.STRING`: Enum ismini saklar.
    - `EnumType.ORDINAL`: Enum sırasını saklar.

**Örnek:**
```java
@Enumerated(EnumType.STRING)
private Status status;
```

---

### 8. **@Temporal**
- Tarih ve saat türündeki alanlar için kullanılır.
- Türler:
    - `TemporalType.DATE`: Sadece tarihi saklar.
    - `TemporalType.TIME`: Sadece saati saklar.
    - `TemporalType.TIMESTAMP`: Hem tarihi hem de saati saklar.

**Örnek:**
```java
@Temporal(TemporalType.TIMESTAMP)
private Date createdAt;
```

---

### 9. **@Lob**
- Büyük verileri (BLOB veya CLOB) saklamak için kullanılır.
- Metin veya büyük dosyalar gibi veri türlerini saklayabilirsiniz.

**Örnek:**
```java
@Lob
private String description;
```

---

### 10. **@Embedded ve @Embeddable**
- Bir sınıfın diğer bir sınıfı gömülü olarak kullanmasını sağlar.
- `@Embeddable`: Gömülü sınıfı belirtir.
- `@Embedded`: Gömülü sınıfı kullanan alanı belirtir.

**Örnek:**
```java
@Embeddable
public class Address {
    private String city;
    private String state;
}

@Entity
public class Customer {
    @Id
    private Long id;

    @Embedded
    private Address address;
}
```

---

### 11. **@OneToOne**
- Birebir ilişkiyi temsil eder.
- Özellikler:
    - `mappedBy`: İlişkinin sahibi olan alanı belirtir.
    - `cascade`: İlişkili nesnelerde işlem kaskadını sağlar.

**Örnek:**
```java
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "address_id", referencedColumnName = "id")
private Address address;
```

---

### 12. **@OneToMany**
- Bire-çok ilişkiyi temsil eder.
- Genellikle `mappedBy` özelliği ile ters ilişkiyi tanımlar.

**Örnek:**
```java
@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
private List<Order> orders;
```

---

### 13. **@ManyToOne**
- Çoktan-bire ilişkiyi temsil eder.
- `fetch`: Lazy veya Eager yükleme modunu belirtir.

**Örnek:**
```java
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "customer_id", nullable = false)
private Customer customer;
```

---

### 14. **@ManyToMany**
- Çoktan-çoka ilişkiyi temsil eder.
- Genellikle bir ara tablo kullanır.

**Örnek:**
```java
@ManyToMany
@JoinTable(
    name = "student_course",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id")
)
private List<Course> courses;
```

---

### 15. **@MappedSuperclass**
- Ortak özelliklerin diğer Entity sınıflarına miras bırakılması için kullanılır.
- Kendisi bir tablo oluşturmaz.

**Örnek:**
```java
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
```

---

### 16. **@Inheritance**
- Kalıtım kullanılan Entity sınıflarını belirler.
- Stratejiler:
    - `SINGLE_TABLE`: Tek bir tablo kullanır.
    - `TABLE_PER_CLASS`: Her alt sınıf için ayrı bir tablo oluşturur.
    - `JOINED`: Alt sınıflar arasında birleştirilmiş bir tablo oluşturur.

**Örnek:**
```java
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    private Long id;
    private String name;
}
```

---

### 17. **@Version**
- Bir alanın Entity'nin versiyonunu saklamasını sağlar.
- Genellikle optimistik kilitleme (Optimistic Locking) için kullanılır.

**Örnek:**
```java
@Version
private int version;
```

---

Bu özellikler ve anotasyonlar, Spring Data Entity'lerde en çok kullanılan ve önemli detaylardır. Spring Data JPA ile çalışırken doğru bir modelleme yapmak için bu özelliklerin nasıl kullanıldığını anlamak kritiktir. Daha fazla özelleştirme gerektiğinde, JPA spesifikasyonu veya Hibernate özellikleri kullanılabilir.



## Spring Boot
```sh 

```
---
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
@SequenceGenerator(name = "customer_seq", sequenceName = "customer_sequence", allocationSize = 1)
private Long id;
Bu kod parçası, bir Entity sınıfındaki birincil anahtarın (Primary Key) nasıl oluşturulacağını detaylı bir şekilde açıklayan bir yapı sunar. Bu yapı, JPA (Java Persistence API) tarafından desteklenen **@Id**, **@GeneratedValue**, ve **@SequenceGenerator** anotasyonlarını içerir. Bu açıklamalarda her bir bileşeni detaylı bir şekilde ele alacağım.

---

### **1. @Id**
- **Tanım:**
  `@Id`, bir alanın birincil anahtar olduğunu belirtir. Her Entity sınıfında bir ve yalnızca bir `@Id` alanı olmak zorundadır.
- **Kullanımı:**
    - Bu alan, veritabanındaki her kaydın benzersiz olarak tanımlanmasını sağlar.
    - Diğer JPA anotasyonlarıyla birlikte (ör. `@GeneratedValue`) kullanılır.

**Örnek:**
```java
@Id
private Long id;
```

---

### **2. @GeneratedValue**
- **Tanım:**
  `@GeneratedValue`, birincil anahtarın nasıl üretileceğini belirlemek için kullanılır. Birincil anahtarın manuel olarak belirlenmesi yerine otomatik olarak üretilmesini sağlar.

- **Özellikleri:**
    - **strategy:**
      Birincil anahtarın üretim stratejisini belirler. JPA'da desteklenen stratejiler şunlardır:
        1. **GenerationType.AUTO:** Varsayılan stratejiyi kullanır. ORM sağlayıcı, veritabanına uygun en iyi stratejiyi seçer.
        2. **GenerationType.IDENTITY:** Veritabanının otomatik artan birincil anahtar özelliğini kullanır.
        3. **GenerationType.SEQUENCE:** Bir veritabanı dizisi (sequence) kullanarak anahtar üretir.
        4. **GenerationType.TABLE:** Anahtarlar için bir tablo kullanır.

    - **generator:**
      `@SequenceGenerator` gibi bir jeneratör tanımına başvuru yapar. Bu özellik, `GenerationType.SEQUENCE` ile birlikte kullanılır.

**Örnek:**
```java
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
```

---

### **3. @SequenceGenerator**
- **Tanım:**
  `@SequenceGenerator`, birincil anahtar üretimi için kullanılan bir diziyi tanımlar. Bu anotasyon, bir veritabanı dizisiyle (sequence) birlikte çalışır ve JPA'nın birincil anahtar değerlerini bu diziden almasını sağlar.

- **Özellikleri:**
    1. **name:**
        - Bu jeneratör için bir ad tanımlar.
        - `@GeneratedValue(generator = "customer_seq")` içinde kullanılan isimle eşleşmelidir.
        - Aynı projede birden fazla jeneratör tanımlayabilirsiniz, bu nedenle adların benzersiz olması gerekir.
        - **Örnek:** `"customer_seq"`

    2. **sequenceName:**
        - Veritabanında bulunan veya JPA tarafından oluşturulacak olan dizi (sequence) adını belirtir.
        - Bu, veritabanındaki gerçek dizinin adıdır.
        - **Örnek:** `"customer_sequence"`

    3. **allocationSize:**
        - Her bir dizi çağrısında kaç anahtarın önceden ayrılacağını belirler.
        - Varsayılan değer `50`'dir. Ancak, `allocationSize = 1` olarak ayarlandığında her seferinde yalnızca bir değer üretilir.
        - Daha büyük bir değer, performansı artırabilir ancak numaralandırma boşluklarına neden olabilir.

    4. **initialValue:**
        - Dizinin başlangıç değerini belirtir. Varsayılan değer `1`'dir.
        - Eğer burada tanımlanmazsa, dizinin veritabanındaki varsayılan değeri kullanılır.

**Örnek:**
```java
@SequenceGenerator(name = "customer_seq", sequenceName = "customer_sequence", allocationSize = 1)
```

---

### **Kodun Detaylı Çalışma Mantığı**

#### **Açıklama Satır Satır**
```java
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
@SequenceGenerator(name = "customer_seq", sequenceName = "customer_sequence", allocationSize = 1)
private Long id;
```

1. **@Id:**
    - `id` alanının bu Entity için birincil anahtar olduğunu belirtir.

2. **@GeneratedValue:**
    - Birincil anahtarın otomatik olarak üretilmesini sağlar.
    - Strateji olarak `GenerationType.SEQUENCE` belirtilmiştir, yani veritabanı dizisi (sequence) kullanılacaktır.
    - Kullanılacak jeneratör `generator = "customer_seq"` ile tanımlanmıştır.

3. **@SequenceGenerator:**
    - `"customer_seq"` adında bir jeneratör tanımlanmıştır.
    - Bu jeneratör, `"customer_sequence"` adlı bir veritabanı dizisini kullanacaktır.
    - `allocationSize = 1`, her çağrıda diziden yalnızca bir değer alınacağını belirtir.

---

### **Sequence Mantığı (Veritabanı Tarafı)**

#### **Dizi (Sequence) Nedir?**
- Bir dizi, otomatik artan sayılar üreten bir veritabanı nesnesidir.
- JPA, bu diziyi birincil anahtar değerlerini üretmek için kullanır.

#### **Veritabanında Sequence Oluşturma**
Eğer diziyi manuel olarak oluşturmanız gerekiyorsa, aşağıdaki SQL komutunu kullanabilirsiniz:

**SQL Örneği:**
```sql
CREATE SEQUENCE customer_sequence
START WITH 1
INCREMENT BY 1;
```

Bu, `customer_sequence` adlı bir dizi oluşturur. İlk değer `1` olacak ve her çağrıda `1` artırılacaktır.

---

### **Neden Sequence Kullanılır?**
1. **Performans:**
    - Diziler, diğer yöntemlere göre daha performanslıdır.
    - `allocationSize` ile optimizasyon yapılabilir.

2. **Taşınabilirlik:**
    - `GenerationType.SEQUENCE`, JPA'nın çoğu veritabanı ile uyumludur.

3. **Kontrol:**
    - Dizinin adını, başlangıç değerini ve artış miktarını kontrol edebilirsiniz.

---

### **Tam Çalışan Örnek**
```java
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_sequence", allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;
}
```

---

### **Çalışma Süreci**
1. İlk kayıt oluşturulduğunda, JPA veritabanına `customer_sequence` dizisinden bir değer ister.
2. Dizi, başlangıçta `1` değeri döner ve `id` alanına atanır.
3. Her yeni kayıt oluşturulduğunda, dizi bir sonraki değeri (ör. `2`, `3`, `4`) döner.
4. Eğer `allocationSize` farklı ayarlanmışsa, JPA bir seferde birden fazla değer alabilir.

---

Bu açıklamalar, `@Id`, `@GeneratedValue` ve `@SequenceGenerator` anotasyonlarının detaylarını ve nasıl kullanıldıklarını açık bir şekilde ortaya koymaktadır. Bu yapı, JPA ile çalışan bir uygulamada birincil anahtar yönetiminin temel taşlarından biridir.



## Lombok Error
```sh 
```
---
`ApiResult` sınıfında, `validationErrors` adında bir alan tanımlanmış, ancak bu alan için bir `setValidationErrors` metodu bulunmuyor. Bu durum, Lombok kütüphanesinin `@Data` anotasyonu tarafından otomatik olarak oluşturulması beklenen setter metodunun neden çağrılamadığını açıklıyor olabilir.

---

### Çözüm Yöntemleri:

1. **Lombok Doğrulaması**:
    - `@Data` anotasyonu genellikle tüm getter ve setter metodlarını otomatik oluşturur. Ancak, Lombok doğru çalışmazsa, `setValidationErrors` metodu eksik olabilir. Bu durumda, aşağıdaki komutla Lombok'un doğru kurulu olup olmadığını kontrol edin:

        - **Maven Projesi Kullanıyorsanız**: `mvn clean install`
        - **IDE'de Lombok Eklentisi**:
            - IntelliJ IDEA kullanıyorsanız:
                - *File > Settings > Plugins > Marketplace* kısmından "Lombok" eklentisinin kurulu olduğundan emin olun.
                - Ayrıca, *Annotation Processing* ayarını etkinleştirin (*File > Settings > Build, Execution, Deployment > Compiler > Annotation Processors > Enable annotation processing*).

2. **Setter Metodunu Elle Ekleyin**:
   Lombok düzgün çalışmıyorsa, `setValidationErrors` metodunu `ApiResult` sınıfına manuel olarak ekleyin:

   ```java
   public void setValidationErrors(Map<String, String> validationErrors) {
       this.validationErrors = validationErrors;
   }
   ```

3. **Yeniden Derleme**:
   Lombok sorunlarını çözmek veya manuel olarak eklenen setter metodunu görmek için projeyi yeniden derleyin:

   ```bash
   mvn clean compile
   ```

4. **Doğru Kullanım**:
   Eğer metodu manuel olarak eklediyseniz, `CustomErrorHandleWebRequest` sınıfında şu kodu doğrulayabilirsiniz:

   ```java
   apiResult.setValidationErrors(validationErrors);
   ```

---

### Nihai Kontrol:
- Eğer hata devam ediyorsa, projenin tüm bağımlılıklarını ve Lombok konfigürasyonunu gözden geçirin.
- Alternatif olarak, `@Setter` veya `@Getter` gibi Lombok anotasyonlarını doğrudan `validationErrors` alanına eklemeyi deneyebilirsiniz:

   ```java
   @Setter
   private Map<String, String> validationErrors;
   ```

## Spring Jpa Terimler
```sh 

```
---

## Spring Boot Jpa Terimler
Spring Data JPA ile kullanılan bu terimler, bir veritabanı üzerinde otomatik olarak veri tablolarının yönetilmesine olanak tanıyan JPA (Java Persistence API) sağlayıcısının yapılandırma seçenekleridir. Her bir yapılandırma seçeneği, JPA'nın veritabanı şeması üzerinde nasıl bir işlem yapacağını belirler. Bu işlemler uygulamanızın başlatılması sırasında veritabanı ile nasıl etkileşimde bulunulacağını kontrol eder. Detaylı olarak açıklarsak:

### 1. `none`
- **Açıklama:**
  `none` ayarı, JPA'nın uygulama başlatılırken veritabanı üzerinde herhangi bir şema yönetimi işlemi yapmamasını sağlar. Yani JPA, tabloları yaratmaz, güncellemez veya doğrulamaz.

- **Kullanım Durumu:**
  Eğer veritabanı şema yönetimini tamamen dış bir araçla veya manuel olarak yapmak istiyorsanız ve JPA'nın şema üzerinde hiçbir etkisi olmaması gerekiyorsa `none` kullanılır.

- **Özellikleri:**
  Veritabanı üzerinde hiç değişiklik yapmaz. Tabloların ve diğer yapıların zaten hazır olduğu varsayılır.

### 2. `update`
- **Açıklama:**
  `update` ayarı, mevcut şemanın korunmasını ve yalnızca gerekli değişikliklerin (örneğin yeni sütunlar veya tablolar ekleme) uygulanmasını sağlar. Ancak, bu işlem sırasında var olan veriler korunur. `update` modunda JPA, mevcut tabloya yeni alanlar veya ilişkiler ekler ancak var olan alanları değiştirmez veya silmez.

- **Kullanım Durumu:**
  Geliştirme sırasında, veritabanındaki tabloları yeniden oluşturmadan sadece yeni eklemeler yapmak istediğinizde `update` ayarı kullanılabilir.

- **Özellikleri:**
    - Veritabanındaki tabloların varlığını kontrol eder.
    - Yeni alanlar ekler ancak mevcut verileri silmez veya değiştirmez.

### 3. `create`
- **Açıklama:**
  `create` ayarı, uygulama başlatıldığında veritabanındaki tüm mevcut tabloları silip yeniden oluşturur. Bu, veritabanında yeni tablolar oluştururken sıfırdan başlamak anlamına gelir. Var olan tablolar ve veriler tamamen silinir ve ardından şemaya uygun yeni tablolar yaratılır.

- **Kullanım Durumu:**
  Genellikle test veya geliştirme ortamlarında, veritabanı şemasının sürekli olarak sıfırdan oluşturulması gerektiğinde kullanılır. Canlı ortamda kullanılması önerilmez çünkü mevcut tüm veriler kaybolur.

- **Özellikleri:**
    - Var olan tabloları siler.
    - Tabloları yeniden oluşturur ve boş bir şema ile başlar.

### 4. `create-drop`
- **Açıklama:**
  `create-drop` ayarı, `create` moduna benzer bir şekilde başlar; uygulama başlatıldığında veritabanındaki tüm tabloları silip yeniden oluşturur. Ancak, `create-drop`'un farkı uygulama kapatıldığında, JPA'nın oluşturduğu tabloların tekrar silinmesidir. Yani, tabloyu oluşturur, uygulama kapanınca ise siler.

- **Kullanım Durumu:**
  Test senaryolarında veya geçici veritabanı kullanımında yararlıdır. Örneğin, uygulama kapandığında tüm test verilerinin silinmesi isteniyorsa `create-drop` kullanılabilir.

- **Özellikleri:**
    - Uygulama başlatıldığında tabloları oluşturur.
    - Uygulama kapatıldığında oluşturulan tabloları siler.

### 5. `validate`
- **Açıklama:**
  `validate` ayarı, veritabanındaki mevcut tabloların uygulamadaki JPA varlıklarına (entities) uygun olup olmadığını kontrol eder. Ancak, bu işlem sırasında herhangi bir tablo oluşturulmaz, değiştirilmez veya silinmez. Sadece var olan şemanın doğruluğu kontrol edilir. Eğer tablo yapısı JPA varlıklarına uygun değilse hata verir ve uygulama başlamaz.

- **Kullanım Durumu:**
  Canlı sistemlerde, şemanın doğru yapılandırıldığından emin olmak için kullanılabilir. Veritabanında herhangi bir değişiklik yapmadığı için, mevcut yapıyı korur ve sadece doğrulama yapar.

- **Özellikleri:**
    - Tablo yapısının JPA varlıklarıyla uyumlu olup olmadığını kontro
```sh 

```
---

## Spring Data Save And SaveFlush
```sh 

```
---

Spring Data JPA'da, `iAddressRepository.save` ve `iAddressRepository.saveAndFlush` metotları, bir varlığı veritabanına kaydetmek için kullanılır, ancak aralarında önemli farklar vardır:

### 1. **`save` Metodu**:
- **Amaç**: Varlığı (entity) kalıcı hale getirir, yani varlığı veritabanına kaydeder veya günceller.
- **Çalışma Şekli**:
    - Varlık `EntityManager` üzerinden yönetilir ve **Persistence Context**'e (kalıcılık bağlamına) eklenir.
    - Ancak, bu işlem doğrudan veritabanına yazılmaz; Persistence Context'te bekletilir ve **transaction commit edildiğinde** ya da `flush` çağrıldığında veritabanına yazılır.
- **Performans**:
    - Daha iyidir çünkü birden fazla değişiklik, tek bir `flush` ile toplu olarak işlenebilir.

   ```java
   AddressEntity address = new AddressEntity();
   address.setStreet("Main Street");
   iAddressRepository.save(address);
   // Değişiklik Persistence Context'e eklenir ama hemen veritabanına yazılmaz.
   ```

### 2. **`saveAndFlush` Metodu**:
- **Amaç**: Varlığı kaydeder ve hemen veritabanına yazılmasını zorlar.
- **Çalışma Şekli**:
    - Varlık hem Persistence Context'e eklenir hem de `EntityManager.flush()` çağrılarak veritabanına **hemen yazılır**.
- **Kullanım Durumu**:
    - Veritabanındaki güncel duruma hemen ihtiyaç duyuluyorsa (örneğin, başka işlemler bu kaydı hemen kullanacaksa) tercih edilir.
- **Performans**:
    - Her çağrıda veritabanına yazma işlemi yapıldığından, çok sık kullanılırsa performansı olumsuz etkileyebilir.

   ```java
   AddressEntity address = new AddressEntity();
   address.setStreet("Main Street");
   iAddressRepository.saveAndFlush(address);
   // Değişiklik hemen veritabanına yazılır.
   ```

### 3. **Önemli Farklar**:
| Özellik                | `save`                                         | `saveAndFlush`                                |
|------------------------|-----------------------------------------------|-----------------------------------------------|
| **Persistence Context**| Sadece Persistence Context'te saklanır.      | Persistence Context'e eklenir ve `flush` yapılır. |
| **Veritabanına Yazım** | Commit veya manuel `flush` ile yapılır.       | Hemen veritabanına yazılır.                   |
| **Performans**         | Daha iyi (toplu işlemler için uygundur).      | Daha düşük (her işlemde yazım yapılır).       |
| **Kullanım Durumu**    | Genel kullanım için uygundur.                 | Veritabanına anında yazılmasını gerektiren durumlarda. |

### 4. **Hangi Durumda Hangisi Kullanılmalı?**
- **`save`**: Veritabanına yazma işlemlerinin toplu olarak yapılmasını tercih ediyorsanız kullanın.
- **`saveAndFlush`**: Veritabanına hemen yazma ihtiyacı olan durumlarda (örneğin, başka bir işlem kaydedilen veriyi hemen kullanacaksa) kullanın.

### Örnek Kullanım Senaryosu:
- Eğer bir sipariş sistemi yazıyorsanız ve sipariş adresini kaydedip ardından bu adresi kullanarak bir başka işlem yapıyorsanız, `saveAndFlush` tercih edilebilir:
   ```java
   AddressEntity address = new AddressEntity();
   address.setStreet("Main Street");
   iAddressRepository.saveAndFlush(address);
   
   // Adresi hemen kullanmayı gerektiren bir işlem:
   Optional<AddressEntity> savedAddress = iAddressRepository.findById(address.getId());
   ```

Sonuç olarak, doğru seçimi yapmak için uygulamanızın gereksinimlerini göz önünde bulundurmanız önemlidir.

## Spring Transaction
```sh 

```
---

### Spring Data Transaction Nedir?

Spring Data'daki **transaction** (işlem) mekanizması, bir veya birden fazla veri tabanı işleminin **tek bir mantıksal birim** olarak yürütülmesini sağlar. Bu, işlemler arasında **tutarlılığı** sağlamak ve işlemler sırasında oluşabilecek hatalardan sonra sistemi önceki güvenli durumuna geri döndürmek için kullanılır.

**ACID** (Atomicity, Consistency, Isolation, Durability) prensiplerini sağlayarak bir işlem sırasında tüm adımların ya tamamen gerçekleştirilmesini ya da hiçbirinin gerçekleştirilmemesini garanti eder. Spring Data, bu işlemleri kolaylaştırmak için Spring Framework'ün **transaction management** yeteneklerinden yararlanır.

---

### Transaction Kavramının Önemi

Bir uygulama veri tabanı işlemleri gerçekleştirirken, aşağıdaki durumlarla karşılaşabilir:

1. **Atomicity (Bütünlük)**: Bir işlem ya tamamen gerçekleştirilir ya da hiç gerçekleştirilmez. Örneğin, bir kullanıcı hesabından para transferi yapılırken, hem para çekme hem de yatırma işlemleri başarılı olmalıdır.

2. **Consistency (Tutarlılık)**: İşlem öncesi ve sonrası veri tabanı tutarlı bir durumda olmalıdır. Eğer bir hata oluşursa, sistem eski tutarlı durumuna döndürülmelidir.

3. **Isolation (Yalıtım)**: Bir işlem diğer işlemlerden bağımsız olarak çalışmalıdır. Paralel çalışan işlemler birbirini etkilememelidir.

4. **Durability (Kalıcılık)**: Bir işlem tamamlandıktan sonra, sonuçları kalıcı olarak saklanmalıdır ve sistem çökse bile veriler kaybolmamalıdır.

Bu prensiplerin uygulanması, **Spring Data**'nın sağladığı transaction yönetimiyle sağlanır.

---

### Spring Transaction Yönetimi Türleri

Spring Framework, **programmatic** (programlama ile) ve **declarative** (bildirimsel) olmak üzere iki tür transaction yönetimi sağlar.

#### 1. **Programmatic Transaction Management**
Transaction yönetimi kod içinde manuel olarak yapılır. Bu yaklaşım genellikle daha az tercih edilir çünkü kodun karmaşıklığını artırabilir. Örnek:

```java
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public void manualTransaction() {
    TransactionDefinition def = new DefaultTransactionDefinition();
    TransactionStatus status = transactionManager.getTransaction(def);
    try {
        // Veri tabanı işlemleri
        transactionManager.commit(status);
    } catch (Exception e) {
        transactionManager.rollback(status);
    }
}
```

#### 2. **Declarative Transaction Management**
Transaction yönetimi, **@Transactional** gibi anotasyonlar kullanılarak yapılır. Bu yaklaşım, kodu sade ve anlaşılır kıldığı için daha yaygındır.

```java
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExampleService {

    @Transactional
    public void performTransaction() {
        // Veri tabanı işlemleri
    }
}
```

---

### Spring Data ve @Transactional

Spring Data, transaction yönetimini kolaylaştırmak için **@Transactional** anotasyonunu kullanır. Bu anotasyon, bir methodun veya sınıfın transaction içinde çalışacağını belirtir.

#### **@Transactional Özellikleri**

**1. Scope (Kapsam):**
- **Method seviyesinde:** Bir metoda transaction uygulanır.
- **Class seviyesinde:** Tüm class'a uygulanır.

**2. Propagation (Yayılma):**
Transaction'un mevcut bir transaction ile nasıl bir ilişki kuracağını belirtir. Örnekler:
- **REQUIRED (Varsayılan):** Mevcut bir transaction varsa onu kullanır; yoksa yeni bir tane oluşturur.
- **REQUIRES_NEW:** Her zaman yeni bir transaction oluşturur.
- **MANDATORY:** Mevcut bir transaction olması zorunludur; aksi halde hata fırlatır.
- **NESTED:** Mevcut transaction içinde bir alt transaction oluşturur.

**3. Isolation (Yalıtım):**
Transaction'un diğer işlemlerden nasıl yalıtılacağını belirtir. Değerleri:
- **READ_UNCOMMITTED:** Diğer işlemler tarafından henüz tamamlanmamış (uncommitted) değişiklikler görülebilir.
- **READ_COMMITTED:** Yalnızca tamamlanmış (committed) değişiklikler görülebilir.
- **REPEATABLE_READ:** Aynı veri iki kez okunduğunda aynı sonucu döndürür.
- **SERIALIZABLE:** Tam yalıtım sağlar ve işlemler sırayla yürütülür.

**4. Rollback Rules (Geri Alma Kuralları):**
Hangi durumlarda işlemin geri alınacağını belirtir:
- Varsayılan olarak, `RuntimeException` ve türevlerinde rollback yapılır.
- `CheckedException`'lar rollback tetiklemez.

#### Örnek Kullanım:
```java
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
public void updateAccountBalance(Long accountId, Double amount) {
    // Birden fazla veri tabanı işlemi
    accountRepository.debit(accountId, amount);
    accountRepository.credit(accountId, amount);
}
```

---

### Spring Data ile Transaction Yönetimi

Spring Data, aşağıdaki özellikler sayesinde transaction yönetimini entegre bir şekilde sağlar:

#### 1. **Repository Seviyesinde Transaction**
Spring Data Repository'leri, çoğunlukla transaction desteğiyle gelir. Varsayılan olarak, tüm CRUD işlemleri (save, delete, update) transaction içinde çalışır.

```java
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Account a SET a.balance = a.balance + :amount WHERE a.id = :id")
    void updateBalance(@Param("id") Long id, @Param("amount") Double amount);
}
```

#### 2. **Custom Repository Transaction**
Kendi özel sorgularınızı yazarken transaction'ı explicit olarak belirtmek gerekebilir.

```java
@Service
public class CustomService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void transferFunds(Long fromAccountId, Long toAccountId, Double amount) {
        accountRepository.debit(fromAccountId, amount);
        accountRepository.credit(toAccountId, amount);
    }
}
```

---

### Transaction Rollback ve Hata Yönetimi

#### Rollback Durumları
- Spring Data, bir **RuntimeException** veya **Error** fırlatıldığında otomatik olarak rollback yapar.
- Eğer **CheckedException** için rollback yapmak istenirse, `rollbackFor` özelliği kullanılmalıdır.

```java
@Transactional(rollbackFor = CustomCheckedException.class)
public void performTransaction() throws CustomCheckedException {
    // İşlemler
}
```

#### Rollback Yapmadan Devam Etmek
Bazı durumlarda bir hata olsa bile transaction’un devam etmesi istenebilir. Bunun için `noRollbackFor` özelliği kullanılır.

```java
@Transactional(noRollbackFor = CustomException.class)
public void performTransactionWithNoRollback() {
    // İşlemler
}
```

---

### Transaction ile En Sık Karşılaşılan Hatalar

1. **LazyInitializationException:**
   Transaction dışında bir Lazy yüklenen ilişkiye erişilmeye çalışıldığında ortaya çıkar. Çözüm olarak, ilişkili nesneleri transaction içinde yüklemek gerekir.

2. **Deadlock (Kilitlenme):**
   Birden fazla işlem aynı kaynağa erişmeye çalıştığında oluşabilir. **Isolation Level**'lar doğru yapılandırılmalıdır.

3. **Transaction yönetiminin devre dışı kalması:**
   `@Transactional` doğru bir şekilde tanımlanmadığında, transaction çalışmaz. Örneğin, self-invocation (bir metodun kendi içinde başka bir transaction'lı metodu çağırması) durumunda transaction etkisiz hale gelebilir.

---

### Spring Transaction ile İlgili En İyi Uygulamalar

1. **Transactional sınırlarını doğru belirlemek:**
   Transaction kapsamını mümkün olduğunca dar tutarak performansı artırabilirsiniz.

2. **Transaction propagation'ı dikkatli seçmek:**
   Mevcut bir transaction'a bağımlı olup olmadığınıza bağlı olarak doğru `Propagation` değerini seçin.

3. **Logging ve Monitoring:**
   Transaction yönetimini izlemek için uygun loglama ve izleme araçları kullanın (örneğin, Spring Actuator).

4. **İzolasyon seviyelerini dikkatli ayarlamak:**
   Yüksek izolasyon seviyeleri performansı etkileyebilir. Minimum seviyede ihtiyacı karşılayacak bir yapı tercih edilmelidir.

---

### Sonuç

Spring Data Transaction, veri tabanı işlemlerini güvenli, tutarlı ve performanslı bir şekilde gerçekleştirmek için güçlü bir mekanizma sunar. **@Transactional** anotasyonu ve Spring Framework'ün zengin transaction yönetim yetenekleri sayesinde, uygulamalarınızda veri bütünlüğünü korurken karmaşık işlemleri kolayca yönetebilirsiniz. Bu mekanizma, mikroservislerden monolitik yapılara kadar geniş bir yelpazede kullanılabilir.

## Spring Transaction Devam
```sh 

```
---
### **Spring Boot `@Transactional` Anotasyonu**
#### **Nedir?**
`@Transactional`, Spring Framework'te bir metot veya sınıf üzerinde işlem (transaction) yönetimini etkinleştiren bir anotasyondur. Veritabanı işlemleri sırasında tutarlılığı sağlamak ve otomatik olarak **commit** veya **rollback** işlemlerini gerçekleştirmek için kullanılır.

---

### **@Transactional Kullanım Alanları**
- **Veritabanı işlemlerinin atomik olmasını sağlamak:** Bir işlem ya tamamen başarılı olmalı ya da tamamen başarısız olmalıdır.
- **Hata durumunda rollback:** İşlem sırasında bir hata meydana geldiğinde, tüm yapılan değişiklikler geri alınır.
- **Büyük ölçekli uygulamalarda işlem yönetimini kolaylaştırmak.**

---

### **@Transactional Temel Özellikleri**

1. **Sınıf veya Metot Seviyesi Kullanım**
    - **Sınıf Seviyesi:** Tüm metotlara işlem yönetimi uygular.
    - **Metot Seviyesi:** Sadece ilgili metoda işlem yönetimi uygular.

   **Örnek:**
   ```java
   @Transactional
   public void updateCustomer(Customer customer) {
       customerRepository.save(customer);
   }
   ```

2. **İşlem Propagasyonu (Propagation)**
    - Mevcut bir işlem içinde mi çalışacak, yoksa yeni bir işlem mi başlatacak belirler.
    - Varsayılan: `Propagation.REQUIRED`.

   **Örnek:**
   ```java
   @Transactional(propagation = Propagation.REQUIRES_NEW)
   public void saveLog(Log log) {
       logRepository.save(log);
   }
   ```

3. **İşlem İzolasyonu (Isolation)**
    - Bir işlemin diğer işlemlerle nasıl etkileşim kuracağını belirler.
    - Örnek seviyeler: `READ_COMMITTED`, `READ_UNCOMMITTED`, `REPEATABLE_READ`, `SERIALIZABLE`.

   **Örnek:**
   ```java
   @Transactional(isolation = Isolation.REPEATABLE_READ)
   public void processOrder(Order order) {
       orderRepository.save(order);
   }
   ```

4. **Rollback Stratejisi**
    - Hangi istisnaların rollback’e neden olacağını belirler.
    - Varsayılan: Tüm `RuntimeException` rollback, `CheckedException` rollback değil.

   **Örnek:**
   ```java
   @Transactional(rollbackFor = Exception.class)
   public void performOperation() throws Exception {
       // İşlem sırasında bir hata oluşursa rollback yapılır.
   }
   ```

5. **Read-Only İşlemler**
    - Okuma işlemleri için kullanılır. Performansı artırır.
    - Varsayılan: `readOnly = false`.

   **Örnek:**
   ```java
   @Transactional(readOnly = true)
   public Customer getCustomerById(Long id) {
       return customerRepository.findById(id).orElse(null);
   }
   ```

---

### **@Transactional Parametreleri**

| **Parametre**       | **Açıklama**                                                                                                                                         | **Varsayılan**      |
|---------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|---------------------|
| **propagation**     | İşlem yayılımı türünü belirtir. (Örneğin, `REQUIRED`, `REQUIRES_NEW`, `NESTED`)                                                                       | `REQUIRED`          |
| **isolation**       | İşlem izolasyon seviyesini belirtir. (Örneğin, `READ_COMMITTED`, `SERIALIZABLE`)                                                                     | Veritabanı varsayılanı |
| **timeout**         | İşlemin zaman aşımını saniye cinsinden belirtir. (Eğer süre aşılırsa işlem geri alınır.)                                                              | `-1` (sonsuz)       |
| **readOnly**        | İşlemin salt okunur olup olmadığını belirtir.                                                                                                        | `false`             |
| **rollbackFor**     | Hangi istisnaların rollback yapılacağını belirtir.                                                                                                   | `RuntimeException`  |
| **noRollbackFor**   | Hangi istisnaların rollback yapılmayacağını belirtir.                                                                                               | Yok                 |

---

### **Örnek Kullanım**

#### **1. Basit Kullanım**
```java
@Transactional
public void saveCustomer(Customer customer) {
    customerRepository.save(customer);
}
```
- Bu metot içinde bir hata oluşursa, yapılan işlemler geri alınır.

---

#### **2. Propagation ve Isolation ile Kullanım**
```java
@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
public void updateOrder(Order order) {
    orderRepository.save(order);
}
```
- Yeni bir işlem başlatır.
- En yüksek izolasyon seviyesi olan `SERIALIZABLE` kullanılır.

---

#### **3. Rollback İçin Özelleştirme**
```java
@Transactional(rollbackFor = Exception.class, noRollbackFor = IllegalArgumentException.class)
public void performTransaction() throws Exception {
    // Exception olduğunda rollback yapılır.
    // IllegalArgumentException durumunda rollback yapılmaz.
}
```

---

#### **4. Read-Only İşlemler**
```java
@Transactional(readOnly = true)
public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
}
```
- Salt okunur modda çalışır, veri değiştirilmez.

---

### **Transaction Yönetiminde Dikkat Edilmesi Gerekenler**

1. **Proxy Mekanizması**
    - Spring, `@Transactional` için bir proxy oluşturur. Bu nedenle, anotasyon yalnızca **public** yöntemlerde çalışır.
    - `private` veya `protected` metotlarda anotasyon etkisizdir.

2. **Transaction İçi Transaction Çağrısı**
    - Aynı sınıf içinde bir metottan başka bir `@Transactional` anotasyonlu metot çağırılırsa, Spring proxy bu çağrıyı algılayamaz. Bunun çözümü, `self-injection` veya farklı bir bean aracılığıyla çağrıdır.

3. **Transaction Sınırlarını Doğru Belirleme**
    - İşlemleri gereksiz yere uzun tutmak performans sorunlarına yol açabilir.
    - Transaction süresince dış kaynak erişimlerini sınırlayın (ör. HTTP çağrıları).

4. **Timeout Ayarları**
    - Uzun süren işlemler için `timeout` belirlemek gereklidir.

---

### **Örnek Senaryo**

Bir e-ticaret uygulamasında sipariş işleme:

**Kod:**
```java
@Service
public class OrderService {

    @Transactional
    public void processOrder(Order order) {
        // Sipariş kaydet
        orderRepository.save(order);

        // Ödeme işlemini gerçekleştir
        paymentService.processPayment(order.getPaymentDetails());

        // Stok güncelle
        stockService.updateStock(order.getItems());
    }
}
```

- Sipariş kaydetme, ödeme işleme ve stok güncelleme işlemleri aynı transaction içinde gerçekleştirilir.
- Bir hata oluşursa, tüm işlemler geri alınır.

---

### **Sonuç**
Spring Boot'ta `@Transactional`, işlem yönetimini kolaylaştıran ve veri tutarlılığını garanti eden güçlü bir araçtır. Doğru yayılım ve izolasyon stratejileri seçilerek, işlem sırasında oluşabilecek çakışmalar ve tutarsızlıklar önlenebilir. Ancak işlem yönetimi sırasında performans ve kapsam konularına dikkat edilmelidir.




## Spring Boot
```sh 

```
---
### Sayfalandırma ve Sıralama (Pagination and Sorting)

Spring Data, büyük veri setlerinde çalışırken verilerin sayfalara bölünerek görüntülenmesini ve sıralanmasını sağlar. `Pageable` ve `Sort` nesneleri sayesinde veriler sayfalara bölünerek belirli bir sırada listelenebilir.

Örneğin:

```java
Pageable pageable = PageRequest.of(0, 10, Sort.by("lastName").descending());
Page<Customer> customers = customerRepository.findAll(pageable);
```

Bu örnekte `Customer` verileri, `lastName` alanına göre azalan bir şekilde ilk 10 kayıt için sayfalama yapılarak getirilir.

### Spring Data ile Transaksiyon Yönetimi

Spring Data, işlem yönetimi (transaction management) desteği de sunar. Birden fazla veri tabanı işleminin tek bir işlem olarak ele alınması durumunda verilerin tutarlılığını sağlamak için `@Transactional` anotasyonu kullanılabilir. Bu sayede bir işlem başarısız olduğunda tüm işlemler geri alınır (rollback yapılır).

```java
@Transactional
public void saveCustomerData(Customer customer, Address address) {
    customerRepository.save(customer);
    addressRepository.save(address);
}
```

### Spring Data Auditing (Denetim)

Spring Data Auditing, veri tabanındaki kayıtlarda oluşturulma ve güncellenme tarihleri gibi verileri otomatik olarak tutar. `@CreatedDate` ve `@LastModifiedDate` anotasyonları ile bu işlemler kolayca yapılabilir.

Örneğin:

```java
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    // diğer alanlar ve getter/setter metodları
}
```

Bu örnek sayesinde, `Customer` kaydı oluşturulduğunda `createdDate`, güncellendiğinde `lastModifiedDate` otomatik olarak güncellenir.

### Spring Data’nın Avantajları ve Dezavantajları

**Avantajları**:

- **Hızlı ve Kolay CRUD İşlemleri**: Repository yapısı sayesinde CRUD işlemleri hızlıca yapılır.
-

**Kod Tekrarını Azaltır**: Sorguların çoğu dinamik olarak oluşturulduğu için kod tekrarı azalır.
- **Veritabanı Bağımsızlığı**: Aynı veri erişim katmanı, farklı veri depolarında kullanılabilir.
- **Sayfalandırma ve Sıralama Desteği**: Verilerin kolayca sayfalanması ve sıralanması mümkündür.

**Dezavantajları**:

- **Öğrenme Eğrisi**: Özellikle yeni başlayanlar için Repository ve Spring Data yapısının öğrenilmesi biraz zaman alabilir.
- **Performans Problemleri**: Karmaşık sorgularda performans sorunları yaşanabilir. Bu durumda özelleştirilmiş sorgular yazılması gerekebilir.

### Sonuç

Spring Data, veri tabanıyla çalışan uygulamalar için büyük kolaylıklar sağlayan, geniş özellik yelpazesine sahip bir modüldür. Farklı veri depolarıyla entegre çalışabilmesi ve standart bir veri erişim katmanı sunması, uygulamaların daha hızlı geliştirilmesini ve daha yönetilebilir hale getirilmesini sağlar. Spring Data, veri işlemlerini modüler ve esnek hale getirirken, yazılımın sürdürülebilirliğini de artırır.

Daha fazla detay isterseniz veya herhangi bir özel konu hakkında örnekler görmek isterseniz, size yardımcı olmaktan memnuniyet duyarım.

## Spring Boot
```sh 

```
---


Delivered Query , Named Queries,  JPQL ve Native SQL Arasındaki Farklar
## Spring Boot
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



## Spring Boot Jpa Terimler
Spring Data JPA ile kullanılan bu terimler, bir veritabanı üzerinde otomatik olarak veri tablolarının yönetilmesine olanak tanıyan JPA (Java Persistence API) sağlayıcısının yapılandırma seçenekleridir. Her bir yapılandırma seçeneği, JPA'nın veritabanı şeması üzerinde nasıl bir işlem yapacağını belirler. Bu işlemler uygulamanızın başlatılması sırasında veritabanı ile nasıl etkileşimde bulunulacağını kontrol eder. Detaylı olarak açıklarsak:

### 1. `none`
- **Açıklama:**
  `none` ayarı, JPA'nın uygulama başlatılırken veritabanı üzerinde herhangi bir şema yönetimi işlemi yapmamasını sağlar. Yani JPA, tabloları oluşturmaz, güncellemez veya doğrulamaz.

- **Kullanım Durumu:**
  Eğer veritabanı şema yönetimini tamamen dış bir araçla veya manuel olarak yapmak istiyorsanız ve JPA'nın şema üzerinde hiçbir etkisi olmaması gerekiyorsa `none` kullanılır.

- **Özellikleri:**
  Veritabanı üzerinde hiç değişiklik yapmaz. Tabloların ve diğer yapıların zaten hazır olduğu varsayılır.

### 2. `update`
- **Açıklama:**
  `update` ayarı, mevcut şemanın korunmasını ve yalnızca gerekli değişikliklerin (örneğin yeni sütunlar veya tablolar ekleme) uygulanmasını sağlar. Ancak, bu işlem sırasında var olan veriler korunur. `update` modunda JPA, mevcut tabloya yeni alanlar veya ilişkiler ekler ancak var olan alanları değiştirmez veya silmez.

- **Kullanım Durumu:**
  Geliştirme sırasında, veritabanındaki tabloları yeniden oluşturmadan sadece yeni eklemeler yapmak istediğinizde `update` ayarı kullanılabilir.

- **Özellikleri:**
    - Veritabanındaki tabloların varlığını kontrol eder.
    - Yeni alanlar ekler ancak mevcut verileri silmez veya değiştirmez.

### 3. `create`
- **Açıklama:**
  `create` ayarı, uygulama başlatıldığında veritabanındaki tüm mevcut tabloları silip yeniden oluşturur. Bu, veritabanında yeni tablolar oluştururken sıfırdan başlamak anlamına gelir. Var olan tablolar ve veriler tamamen silinir ve ardından şemaya uygun yeni tablolar oluşturılır.

- **Kullanım Durumu:**
  Genellikle test veya geliştirme ortamlarında, veritabanı şemasının sürekli olarak sıfırdan oluşturulması gerektiğinde kullanılır. Canlı ortamda kullanılması önerilmez çünkü mevcut tüm veriler kaybolur.

- **Özellikleri:**
    - Var olan tabloları siler.
    - Tabloları yeniden oluşturur ve boş bir şema ile başlar.

### 4. `create-drop`
- **Açıklama:**
  `create-drop` ayarı, `create` moduna benzer bir şekilde başlar; uygulama başlatıldığında veritabanındaki tüm tabloları silip yeniden oluşturur. Ancak, `create-drop`'un farkı uygulama kapatıldığında, JPA'nın oluşturduğu tabloların tekrar silinmesidir. Yani, tabloyu oluşturur, uygulama kapanınca ise siler.

- **Kullanım Durumu:**
  Test senaryolarında veya geçici veritabanı kullanımında yararlıdır. Örneğin, uygulama kapandığında tüm test verilerinin silinmesi isteniyorsa `create-drop` kullanılabilir.

- **Özellikleri:**
    - Uygulama başlatıldığında tabloları oluşturur.
    - Uygulama kapatıldığında oluşturulan tabloları siler.

### 5. `validate`
- **Açıklama:**
  `validate` ayarı, veritabanındaki mevcut tabloların uygulamadaki JPA varlıklarına (entities) uygun olup olmadığını kontrol eder. Ancak, bu işlem sırasında herhangi bir tablo oluşturulmaz, değiştirilmez veya silinmez. Sadece var olan şemanın doğruluğu kontrol edilir. Eğer tablo yapısı JPA varlıklarına uygun değilse hata verir ve uygulama başlamaz.

- **Kullanım Durumu:**
  Canlı sistemlerde, şemanın doğru yapılandırıldığından emin olmak için kullanılabilir. Veritabanında herhangi bir değişiklik yapmadığı için, mevcut yapıyı korur ve sadece doğrulama yapar.

- **Özellikleri:**
    - Tablo yapısının JPA varlıklarıyla uyumlu olup olmadığını kontro
```sh 

```
---



## Spring Boot
```sh 

```
---


Spring Boot’ta **ilişkiler** (relationships), veri modelleme açısından önemli bir role sahiptir ve `@OneToOne`, `@OneToMany`, `@ManyToOne`, ve `@ManyToMany` gibi anotasyonlarla tanımlanır. Bu ilişkiler, veritabanındaki tablo yapıları arasındaki bağları temsil eder ve bir nesneyle diğer nesneler arasındaki bağı kurmamıza olanak tanır. Her bir ilişkinin kendine özgü bazı önemli **attributeları** vardır. Aşağıda bu ilişki türlerinin ve bu anotasyonlarla birlikte kullanılan en önemli attribute’ların detaylı bir açıklamasını bulabilirsiniz.

### 1. `@OneToOne` İlişkisi

`@OneToOne`, iki varlık arasında birebir ilişki kurmak için kullanılır. Örneğin, bir **kullanıcı** ile onun **profil** bilgisi arasında birebir bir ilişki olabilir.

#### Örnek Kullanım
```java
@Entity
public class User {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;
}
```

#### Önemli Attribute’lar

- **`mappedBy`**: Bir ilişkinin ters tarafında (`inverse side`) kullanılır. `mappedBy`, ilişkiyi ters tarafla eşleştirmek için ilişki sahibini (`owning side`) belirtir. Örneğin, `Profile` sınıfında `User`’ın ters tarafı olarak `mappedBy` kullanılabilir.

    ```java
    @OneToOne(mappedBy = "profile")
    private User user;
    ```

- **`cascade`**: İlişkili varlık üzerinde yapılacak işlemleri (örneğin, kayıt, güncelleme veya silme) belirler. Örneğin `CascadeType.ALL`, `User` kaydedildiğinde otomatik olarak `Profile` kaydını da günceller.

- **`fetch`**: Varsayılan olarak `EAGER`’dır. `@OneToOne` ilişkilerde ilişki veri her zaman yüklenir. `LAZY` olarak ayarlandığında, ilişki veri sadece gerektiğinde yüklenir.

- **`optional`**: `true` ise, ilişki nullable olarak tanımlanır. Bu, ilişkili varlığın `null` olabileceği anlamına gelir. `false` yapıldığında, ilişkili varlık `null` olamaz.

- **`@JoinColumn`**: Veritabanında ilişkiyi kuran anahtar sütunu belirtir. `name` attribute’u, ilişki kurulacak sütunun ismini tanımlar.

### 2. `@OneToMany` İlişkisi

`@OneToMany`, bir varlığın diğer bir varlıkla bire-çok ilişkisini temsil eder. Örneğin, bir **yazar** ve onun **kitapları** arasında bire-çok ilişkisi olabilir. Bu tür bir ilişkide, bir yazarın birden fazla kitabı vardır.

#### Örnek Kullanım
```java
@Entity
public class Author {
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;
}
```

#### Önemli Attribute’lar

- **`mappedBy`**: `@OneToMany` ilişkilerinde sıkça kullanılır. İlişki sahibini belirleyerek, ilişkiyi ters tarafla bağlar. Burada `Book` sınıfında `author` ilişki sahibidir.

- **`cascade`**: Bu attribute, ilişki güncellemelerinde ne yapılması gerektiğini belirtir. Örneğin, `CascadeType.ALL` kullanıldığında, `Author` güncellenirken ilişkili tüm `Book` kayıtları da güncellenir.

- **`fetch`**: `@OneToMany` ilişkilerde varsayılan olarak `LAZY`’dir. Veri gerektiğinde yüklenir. `EAGER` olarak değiştirilirse ilişki veri her zaman yüklenir.

- **`orphanRemoval`**: `true` olarak ayarlanırsa, ilişki koparıldığında `orphan` (yetim) olan `Book` kayıtları otomatik olarak silinir.

- **`@JoinColumn` veya `@JoinTable`**: İlişkiyi bağlayacak anahtar sütunu veya bağlantı tablosunu belirler. `@JoinColumn`, tek bir anahtar sütunuyla ilişki kurarken, `@JoinTable` iki tablo arasındaki bağlantıyı kurar.

### 3. `@ManyToOne` İlişkisi

`@ManyToOne`, birden fazla varlığın tek bir varlığa bağlı olduğu ilişki türüdür. Örneğin, bir **kitap** ve onun **yazarı** arasındaki ilişki gibi. Birçok kitap tek bir yazara ait olabilir.

#### Örnek Kullanım
```java
@Entity
public class Book {
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
```

#### Önemli Attribute’lar

- **`fetch`**: `@ManyToOne` ilişkilerde varsayılan olarak `EAGER`’dır. İlişki veri her zaman yüklenir. `LAZY` olarak ayarlanabilir.

- **`optional`**: Eğer `true` olarak ayarlanmışsa, ilişkili varlık `null` olabilir. Örneğin, `optional = false` yapıldığında `Book` kaydının mutlaka bir `Author` ile ilişkili olması gerekir.

- **`cascade`**: Aynı diğer ilişki türlerinde olduğu gibi, `cascade` tipi belirlenebilir. Örneğin, `CascadeType.PERSIST` sadece ana varlık kaydedildiğinde ilişkili varlık da kaydedilir.

- **`@JoinColumn`**: Bu ilişkiyi kuran anahtar sütunu tanımlar. `name` attribute’u, ilişkili sütunun veritabanında hangi isimle yer alacağını belirler.

### 4. `@ManyToMany` İlişkisi

`@ManyToMany`, iki varlık arasında çoktan çoğa ilişkiyi tanımlar. Örneğin, bir **öğrenci** ve onun **dersleri** arasında çoktan çoğa ilişki vardır; bir öğrenci birden fazla ders alabilir ve bir ders birden fazla öğrenciye sahip olabilir.

#### Örnek Kullanım
```java
@Entity
public class Student {
    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;
}
```

#### Önemli Attribute’lar

- **`mappedBy`**: İlişkiyi ters tarafla bağlar. Bir sınıfta `@ManyToMany` ilişki tanımlandıysa, diğer sınıfta `mappedBy` ile ilişki sahibi belirtilmelidir.

- **`cascade`**: İlişki için uygulanacak işlemleri belirtir. Örneğin, `CascadeType.MERGE` ile ana varlık güncellendiğinde ilişkili varlıklar da güncellenir.

- **`fetch`**: `@ManyToMany` ilişkilerde varsayılan olarak `LAZY`’dir. Veri gerektiğinde yüklenir, ancak `EAGER` olarak ayarlanabilir.

- **`@JoinTable`**: Çoktan çoğa ilişkilerde bağlantıyı sağlayan üçüncü bir tabloyu belirtir. `name` attribute’u ile bağlantı tablosunun ismi verilir. `joinColumns` ana varlığın anahtar sütununu, `inverseJoinColumns` ise ilişkili varlığın anahtar sütununu belirtir.

- **`@JoinColumn`**: Birçok `@JoinColumn` ile ilişkili varlıklar arasında köprü kuran bir tablo tanımlanabilir. Bu, ilişki için bağlantı sütunlarını belirler.

### Cascade Tipleri (CascadeType)

Tüm ilişki türlerinde kullanılabilen `cascade` tipi, ilişki işlemlerinin ilişkili varlığa nasıl yansıyacağını belirler:

- **`CascadeType.ALL`**: Tüm işlemler ilişki üzerinde yapılır (persist, merge, remove, refresh, detach).
- **`CascadeType.PERSIST`**: Ana varlık kaydedildiğinde, ilişkili varlıklar da kaydedilir.
- **`CascadeType.MERGE`**: Ana varlık güncellendiğinde, ilişkili varlıklar da güncellenir.
- **`CascadeType.REMOVE`**: Ana varlık silindiğinde, ilişkili varlıklar da silinir.
- **`CascadeType.REFRESH`**: Ana varlık yenilendiğinde, ilişkili varlıklar da yenilenir.
- **`CascadeType.DETACH`**: Ana varlık oturumdan ayrıldığında, ilişkili varlıklar da ayrılır.

### Fetch Tipleri (FetchType)

**FetchType** iki seçenek sunar:

- **`FetchType.EAGER`**: İlişki veri her zaman yüklenir. Bu, veri her durumda belleğe alınır.
- **`FetchType.LAZY`**: İlişki veri yalnızca gerektiğinde yüklenir. Bu, bellek yönetimi açısından daha verimlidir.

### Özet

Spring Boot ilişkileri tanımlamak için kullanılan `@anotasyonlar`, veritabanı modellemelerinde veri ilişkilerini açık bir şekilde ifade etmemizi sağlar. Bu ilişkiler, `@OneToOne`, `@OneToMany`, `@ManyToOne`, ve `@ManyToMany` anotasyonları ile belirtilir. Her bir ilişki türü, veritabanı yapısında anlamlı bağlantılar kurmayı sağlar ve verilerin yönetilmesi, güncellenmesi, veya silinmesi gibi işlemler sırasında entegre bir yapı sunar.

### İlişkilerde Kullanılan Başlıca Attribute ve Anotasyonların Özeti

1. **`@OneToOne`**:
    - Birebir ilişkilerde kullanılır.
    - `mappedBy`, ilişkiyi ters tarafla eşleştirir.
    - `@JoinColumn`, ilişkiyi kuran sütunu belirtir.
    - `cascade`, işlemleri tüm varlıklar arasında paylaşır.
    - `fetch`, veri yükleme türünü belirler (`EAGER` varsayılan).

2. **`@OneToMany`**:
    - Bire-çok ilişkilerde kullanılır.
    - `mappedBy`, ilişki sahibini belirtir.
    - `cascade`, işlemleri yönetir (örneğin `CascadeType.ALL` ile tüm işlemler).
    - `orphanRemoval`, ilişki sona erdiğinde ilişkisiz (orphan) öğeleri siler.
    - `fetch`, veri yükleme türünü belirler (`LAZY` varsayılan).

3. **`@ManyToOne`**:
    - Çoktan-bire ilişkiyi ifade eder.
    - `cascade`, işlemleri ilişkili varlık üzerinde uygular.
    - `optional`, ilişkili varlığın zorunlu olup olmadığını belirtir.
    - `fetch`, veri yükleme türünü belirler (`EAGER` varsayılan).
    - `@JoinColumn`, ilişkiyi sağlayan sütunu belirtir.

4. **`@ManyToMany`**:
    - Çoktan-çoğa ilişkilerde kullanılır.
    - `mappedBy`, ilişkiyi ters tarafla bağlar.
    - `@JoinTable`, üçüncü tablo ile iki varlık arasındaki bağlantıyı sağlar.
    - `cascade`, işlemleri her iki taraf üzerinde de yürütür.
    - `fetch`, veri yükleme türünü belirler (`LAZY` varsayılan).

5. **`CascadeType`** Seçenekleri:
    - `ALL`, `PERSIST`, `MERGE`, `REMOVE`, `REFRESH`, `DETACH` işlemlerini belirtir.
    - `CascadeType.ALL` tüm işlemleri ilişki varlığına uygular.

6. **`FetchType`** Seçenekleri:
    - `EAGER`: Veri her zaman yüklenir.
    - `LAZY`: Veri sadece gerektiğinde yüklenir, performans avantajı sağlar.

### İlişki Yönetiminde Dikkat Edilmesi Gerekenler

- **Bellek Yönetimi**: `LAZY` yükleme, bellek yönetimi açısından avantaj sağlar. Özellikle büyük veri setleriyle çalışıyorsanız `LAZY` olarak ayarlamak belleği daha verimli kullanmanıza yardımcı olur.
- **Orphan Removal**: `orphanRemoval = true` olarak ayarlanırsa, bir koleksiyondan silinen öğeler otomatik olarak veritabanından da silinir.
- **Veritabanı İşlemleri**: `cascade` ile, bir varlık üzerinde yapılan işlemlerin bağlı varlıkları nasıl etkilediğini kontrol edebilirsiniz.
- **Veri Tutarlılığı**: `optional = false` gibi özelliklerle, ilişkilerin bütünlüğünü koruyabilir ve `null` ilişki oluşmasını engelleyebilirsiniz.

Spring Boot’ta veri modelleri arasında anlamlı bağlantılar kurmak ve bu ilişkileri doğru bir şekilde yönetmek, uygulamanın sağlam bir yapıya sahip olmasını sağlar. Bu ilişkileri ve `attribute`ları doğru kullanmak, veritabanı işlemlerinin daha etkili ve sürdürülebilir olmasını sağlar.


Spring Boot ile çalışırken bir entity içinde birden fazla ID’ye sahip olmak istediğimizde, genellikle **@EmbeddedId** veya **@IdClass** yaklaşımlarını kullanarak bunu yönetiriz. Bu, özellikle **birleştirilmiş anahtar** (composite key) veya **işlemsel olarak birden fazla kimlik alanı** gerektiğinde kullanılır. Aşağıda bu yöntemlerin her birini detaylı olarak ele alacağım.

### 1. @EmbeddedId Kullanarak Birden Fazla ID Yönetimi

**@EmbeddedId** anotasyonu, bir entity içinde birleştirilmiş bir anahtar oluşturmak için kullanılır. Burada, anahtar olarak kullanılacak tüm alanları kapsayan bir sınıf tanımlarız ve entity sınıfında bu sınıfı **@EmbeddedId** ile işaretleriz.

#### Örnek:
Varsayalım ki bir **OrderItem** entity sınıfımız var ve bu sınıf **orderId** ve **productId** alanları ile birleştirilmiş bir anahtara sahip olacak.

1. **Anahtar sınıfını tanımla:**

   ```java
   @Embeddable
   public class OrderItemKey implements Serializable {
       private Long orderId;
       private Long productId;

       // Getter ve Setter'lar, hashCode() ve equals() metotları ekleyin
   }
   ```

    - **@Embeddable**: Anahtar sınıfını tanımlamak için bu anotasyonu kullanıyoruz.
    - **Serializable**: Birleştirilmiş anahtar sınıfı mutlaka `Serializable` olmalıdır.
    - **equals() ve hashCode()**: Bu metotlar, birleştirilmiş anahtar sınıfının benzersizliğini sağlamak için gereklidir.

2. **Entity içinde @EmbeddedId kullanımı:**

   ```java
   @Entity
   public class OrderItem {
       @EmbeddedId
       private OrderItemKey id;

       private int quantity;
       private BigDecimal price;

       // Diğer alanlar ve getter/setter metotları
   }
   ```

   Burada **OrderItemKey** sınıfı, **OrderItem** entity sınıfı içinde **@EmbeddedId** ile tanımlanmıştır. Bu sayede birleştirilmiş anahtar, **orderId** ve **productId** alanlarını içerir.

#### Avantajları:
- Anahtar sınıfını bir **@Embeddable** nesne olarak ayrı bir sınıf halinde tanımladığımız için kod düzeni sağlanır.
- Birleştirilmiş anahtar kolayca entity’e gömülebilir.

#### Dezavantajları:
- **@EmbeddedId** yöntemi daha çok birleştirilmiş anahtarların yönetimi için uygundur, ve bu yöntemde ID değerlerinin entity içinde tek bir nesne olarak yönetilmesi gerekmektedir.

### 2. @IdClass Kullanarak Birden Fazla ID Yönetimi

**@IdClass** anotasyonu, entity içinde birden fazla ID alanı tanımlamak için kullanılır. Bu yöntemde birleştirilmiş anahtar alanları entity’nin içinde bağımsız değişkenler olarak tanımlanır. **@IdClass** kullanırken, bir **primary key** sınıfı oluşturur ve bu sınıfı entity’nin üstüne **@IdClass** ile işaretleriz.

#### Örnek:
Yine bir **OrderItem** entity sınıfı olduğunu varsayalım, fakat burada **@IdClass** kullanacağız.

1. **Primary key sınıfını tanımla:**

   ```java
   public class OrderItemId implements Serializable {
       private Long orderId;
       private Long productId;

       // Getter ve Setter'lar, hashCode() ve equals() metotları ekleyin
   }
   ```

2. **Entity içinde @IdClass kullanımı:**

   ```java
   @Entity
   @IdClass(OrderItemId.class)
   public class OrderItem {
       @Id
       private Long orderId;

       @Id
       private Long productId;

       private int quantity;
       private BigDecimal price;

       // Diğer alanlar ve getter/setter metotları
   }
   ```

   Bu örnekte, **OrderItem** entity’si, **orderId** ve **productId** alanlarını **@Id** ile bağımsız olarak tanımlar. **OrderItemId** sınıfı ise **@IdClass** ile belirtilir.

#### Avantajları:
- Birleştirilmiş anahtarın tüm alanları entity içinde bağımsız olarak tanımlanabilir.
- Karmaşık birleştirilmiş anahtar yapılarını yönetmek için uygundur.

#### Dezavantajları:
- **@IdClass** kullanımı daha fazla kod gerektirir ve **@EmbeddedId** kadar pratik değildir.
- **equals() ve hashCode()** metotlarının düzgün bir şekilde tanımlanması gerekir.

### Hangi Yöntem Ne Zaman Kullanılmalı?

| Durum                             | Tercih Edilecek Anotasyon |
|-----------------------------------|---------------------------|
| Basit birleştirilmiş anahtar      | **@EmbeddedId**          |
| Birden fazla bağımsız ID alanı    | **@IdClass**             |
| Legacy veritabanı yapısı          | **@IdClass**             |

### Özet

Spring Boot ve JPA içinde bir entity’de birden fazla ID’yi yönetmek için **@EmbeddedId** ve **@IdClass** kullanabiliriz. **@EmbeddedId** daha düzenli ve basit bir yaklaşımdır ve anahtar olarak kullanılan alanları tek bir nesnede toplar. **@IdClass** ise daha karmaşık veya legacy veritabanı yapıları için uygundur, her bir ID alanını bağımsız olarak tanımlama esnekliği sağlar.

Her iki yöntemde de ID yönetiminde doğru bir şekilde `equals()` ve `hashCode()` metotlarını tanımlamayı unutmamak önemlidir, aksi halde JPA entity ilişkilerinde beklenmeyen sorunlarla karşılaşabilirsiniz.




## Spring Boot
```sh 

```
---
oluşturım (Creational) tasarım desenleri, nesne oluşturma süreçlerini yönetmek ve optimize etmek amacıyla kullanılır. Bu desenler, nesne oluşturmanın doğrudan yapılmasından ziyade bir yapı üzerinden yapılmasını sağlar ve böylece sistemin esnekliğini artırır.

İşte başlıca oluşturım desenleri:

1. **Singleton**
    - Sınıfın yalnızca bir örneğinin olmasını sağlar ve global bir erişim noktası sunar.

2. **Factory Method (Fabrika Metodu)**
    - Alt sınıfların hangi sınıfın örneğinin oluşturulacağına karar vermesini sağlayan bir arayüz tanımlar.

3. **Abstract Factory (Soyut Fabrika)**
    - Birbiriyle ilişkili veya bağımlı nesne ailesi oluşturan arayüz sağlar ve hangi sınıfın örneğinin oluşturulacağına alt sınıflar karar verir.

4. **Builder (Kurucu)**
    - Kompleks nesneleri adım adım oluşturmak için kullanılır ve nesnelerin farklı gösterimlerinden bağımsız olarak oluşturulmasını sağlar.

5. **Prototype (Prototip)**
    - Bir nesnenin örneğini klonlayarak kopyalar. Yeni nesneler oluşturmak yerine var olan nesnelerden kopyalama yapılır.

Bu desenler, nesne oluşturma süreçlerini daha esnek hale getirir ve kodun bakımını kolaylaştırır.


## Spring Boot
```sh 

```
---

Java'da Singleton tasarım deseni, bir sınıfın yalnızca bir örneğinin oluşturulmasını sağlar ve bu örneğe küresel bir erişim noktası sunar. Bu desen, sistem genelinde belirli işlemleri koordine etmek için yalnızca bir nesneye ihtiyaç duyulduğunda faydalıdır.

### Singleton Tasarım Deseninin Özellikleri
1. **Tek Örnek**: Bir sınıfın yalnızca bir "tek" örneğinin oluşturulmasını kısıtlar.
2. **Küresel Erişim Noktası**: Örneğe küresel bir erişim noktası sağlar.
3. **Thread-Safe (İş Parçacığı Güvenliği)**: Bu desen gerektiğinde iş parçacığı güvenli olacak şekilde tasarlanabilir.
4. **Lazy Initialization (Tembel Başlatma)**: Örnek yalnızca gerektiğinde oluşturulabilir.

### Java'da Singleton Deseninin Uygulama Yöntemleri

#### 1. Eager Initialization (Hızlı Başlatma)
Bu yöntemde, örnek sınıf yüklendiğinde oluşturulur.

```java
public class Singleton {
    private static final Singleton instance = new Singleton();

    // Özel bir yapıcı (constructor) ile dışardan nesne oluşturulması engellenir
    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }
}
```

- **Avantajlar**: Basit ve thread-safe.
- **Dezavantajlar**: Sınıf yüklendiğinde hemen örnek oluşturulur. Bu, örneğe her zaman ihtiyaç duyulmayacaksa kaynak israfına neden olabilir.

#### 2. Lazy Initialization (Tembel Başlatma)
Bu yöntemde, örnek yalnızca `getInstance()` çağrıldığında oluşturulur.

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

- **Avantajlar**: Örnek yalnızca gerektiğinde oluşturulur, bu da kaynak kullanımını optimize eder.
- **Dezavantajlar**: Bu yöntem thread-safe değildir; çoklu iş parçacığında sorun çıkarabilir.

#### 3. Thread-Safe Singleton
Thread-safe hale getirmek için `synchronized` anahtar kelimesi kullanılabilir.

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

- **Avantajlar**: Thread-safe olduğu için çoklu iş parçacığı ortamında güvenlidir.
- **Dezavantajlar**: `synchronized` anahtar kelimesi performansı etkileyebilir.

#### 4. Double-Checked Locking (Çift Kontrol Kilitleme)
Hem tembel başlatmayı hem de thread-safe yapıyı birleştirmek için çift kontrol kilitleme uygulanabilir.

```java
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

- **Avantajlar**: Hem thread-safe hem de tembel başlatma özelliklerini sağlar.
- **Dezavantajlar**: Kod biraz karmaşıktır.

#### 5. Bill Pugh Singleton Yöntemi
Bu yöntemde, iç sınıf kullanarak tembel başlatma ve thread-safe özelliklerini basit bir şekilde sağlar.

```java
public class Singleton {
    private Singleton() {}

    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
```

- **Avantajlar**: Hem thread-safe hem de tembel başlatma özelliklerine sahip, ayrıca diğer yöntemlere göre daha verimli.
- **Dezavantajlar**: Kodun anlaşılması biraz daha zor olabilir.

### Singleton Deseninin Kullanım Alanları
- **Bağlantı Havuzu (Connection Pool)**
- **Yapılandırma Yöneticileri (Configuration Managers)**
- **Cache (Önbellek)**
- **Loglama (Logging)**

Her bir yöntem, farklı kullanım senaryoları için uygundur ve uygulamanın ihtiyaçlarına göre seçilmelidir.


## Spring Boot
```sh 

```
---



## Spring Boot
```sh 

```
---

`JdbcTemplate`, Spring Framework'ün bir parçası olarak veri tabanıyla etkileşimde bulunmak için geliştirilmiş bir sınıftır ve özellikle Spring Boot uygulamalarında yaygın olarak kullanılır. `JdbcTemplate`, SQL sorgularını çalıştırmak, veri tabanından veri çekmek, güncelleme işlemleri yapmak ve veritabanı bağlantılarını yönetmek için güçlü ve basit bir yol sağlar. Spring Boot, `JdbcTemplate` sınıfının kullanılmasını daha da kolaylaştırarak, veri tabanı işlemleri için hem esneklik hem de güvenilirlik sunar.

### JdbcTemplate'in Amacı
`JdbcTemplate`, JDBC (Java Database Connectivity) API'sini basitleştirmeyi amaçlar. Geleneksel JDBC kodu yazarken, kaynakları açma ve kapatma, hata işleme, veritabanı bağlantılarının yönetimi gibi çeşitli işlemler manuel olarak yapılır ve bu da hata riskini artırır. `JdbcTemplate`, bu tür görevleri otomatikleştirerek, JDBC işlemlerini basitleştirir. Bu sayede, geliştiriciler odaklarını SQL sorgularına ve iş mantığına verebilirler.

### JdbcTemplate'in Sağladığı Faydalar
- **Kaynak Yönetimi**: `JdbcTemplate`, veritabanı bağlantılarını otomatik olarak yönetir ve kapatır, böylece bağlantı sızıntılarını önler.
- **Hata İşleme**: `SQLException` gibi veritabanı hatalarını otomatik olarak işler ve bunları daha anlamlı `DataAccessException` sınıflarına dönüştürür.
- **Basit Kullanım**: CRUD (Create, Read, Update, Delete) işlemlerini gerçekleştirmek için kullanımı kolay metodlar sunar.
- **Güvenli Parametre Kullanımı**: SQL enjeksiyonu gibi güvenlik açıklarını önlemek için parametreli sorguları destekler.
- **Esneklik**: Veritabanına özel SQL sorguları yazma esnekliği sağlar ve ORM kullanımı zorunluluğu yoktur.

### JdbcTemplate Kullanım Adımları
Spring Boot uygulamasında `JdbcTemplate` kullanmak için temel adımlar şunlardır:

#### 1. Bağımlılıkları Ekleme
Spring Boot projesinde `JdbcTemplate` kullanmak için `spring-boot-starter-jdbc` bağımlılığına ihtiyacınız vardır. `pom.xml` dosyasına aşağıdaki bağımlılığı ekleyin:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
```

#### 2. Veri Tabanı Yapılandırması
Uygulamanızın `application.properties` veya `application.yml` dosyasına veri tabanı yapılandırmalarını ekleyin:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

#### 3. JdbcTemplate Bean Tanımlama
Spring Boot, otomatik yapılandırma sayesinde `JdbcTemplate` bean'ini otomatik olarak yaratır. Bu yüzden `JdbcTemplate` nesnesini doğrudan kullanabiliriz:

```java
@Autowired
private JdbcTemplate jdbcTemplate;
```

### JdbcTemplate ile CRUD İşlemleri

#### Veri Ekleme (Insert)
`JdbcTemplate` ile veri eklemek için `update` metodu kullanılır:

```java
String sql = "INSERT INTO customers (name, age, city) VALUES (?, ?, ?)";
jdbcTemplate.update(sql, "Ali", 30, "Ankara");
```

#### Veri Okuma (Select)
Veri tabanından veri çekmek için `queryForObject` veya `query` metotları kullanılır.

- **Tek Bir Değer Döndürme**:

```java
String sql = "SELECT COUNT(*) FROM customers";
Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
```

- **Liste Döndürme**:

```java
String sql = "SELECT * FROM customers";
List<Customer> customers = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class));
```

#### Veri Güncelleme (Update)
Var olan veriyi güncellemek için `update` metodu kullanılır:

```java
String sql = "UPDATE customers SET city = ? WHERE name = ?";
jdbcTemplate.update(sql, "Istanbul", "Ali");
```

#### Veri Silme (Delete)
Veriyi silmek için yine `update` metodunu kullanabiliriz:

```java
String sql = "DELETE FROM customers WHERE name = ?";
jdbcTemplate.update(sql, "Ali");
```

### JdbcTemplate RowMapper Kullanımı
`RowMapper`, veritabanı kayıtlarını Java nesnelerine dönüştürmek için kullanılan bir arayüzdür. `BeanPropertyRowMapper` sınıfı, SQL sorgusundan dönen verileri otomatik olarak belirttiğimiz nesneye dönüştürür:

```java
String sql = "SELECT * FROM customers WHERE id = ?";
Customer customer = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Customer.class), 1);
```

#### Özel RowMapper Kullanımı
Kendi `RowMapper` sınıfınızı oluşturmak isterseniz, `RowMapper` arayüzünü uygulayabilirsiniz:

```java
public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setName(rs.getString("name"));
        customer.setCity(rs.getString("city"));
        return customer;
    }
}

// Kullanım
String sql = "SELECT * FROM customers WHERE id = ?";
Customer customer = jdbcTemplate.queryForObject(sql, new CustomerRowMapper(), 1);
```

### JdbcTemplate BatchUpdate
`BatchUpdate` metodu, çok sayıda veri işlemi yapmanız gerektiğinde birden fazla SQL sorgusunu tek seferde çalıştırarak performansı artırır:

```java
String sql = "INSERT INTO customers (name, age, city) VALUES (?, ?, ?)";
List<Object[]> batchArgs = Arrays.asList(
    new Object[]{"Ali", 30, "Ankara"},
    new Object[]{"Ayşe", 25, "İstanbul"},
    new Object[]{"Mehmet", 35, "İzmir"}
);

jdbcTemplate.batchUpdate(sql, batchArgs);
```

### JdbcTemplate ile Transaction Yönetimi
`JdbcTemplate`, `@Transactional` anotasyonu ile işlemleri bir bütün olarak ele alır. Eğer bir işlem sırasında hata oluşursa, yapılan değişiklikler geri alınır:

```java
@Service
public class CustomerService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void transferFunds(int senderId, int receiverId, double amount) {
        jdbcTemplate.update("UPDATE accounts SET balance = balance - ? WHERE id = ?", amount, senderId);
        jdbcTemplate.update("UPDATE accounts SET balance = balance + ? WHERE id = ?", amount, receiverId);
    }
}
```

### JdbcTemplate ve Spring Boot'ta Exception Management
`JdbcTemplate`, `SQLException` gibi veritabanı hatalarını `DataAccessException` isimli bir üst sınıf ile kapsar. Bu sayede istisnaları kolayca yönetebilirsiniz:

```java
try {
    jdbcTemplate.update("UPDATE customers SET city = ? WHERE id = ?", "Izmir", 1);
} catch (DataAccessException e) {
    // Hata yönetimi
    System.out.println("Veri tabanı hatası: " + e.getMessage());
}
```

### JdbcTemplate'in Alternatifleri
Spring Boot ve Spring Framework, veritabanı işlemleri için `JdbcTemplate` dışında başka araçlar da sunar:
- **Spring Data JPA**: ORM (Object Relational Mapping) kullanmak isteyenler için idealdir.
- **NamedParameterJdbcTemplate**: Parametreli SQL sorguları için daha esnek bir yapı sunar.
- **Spring Data JDBC**: `JdbcTemplate`'in daha modern bir alternatifi olarak basit veri tabanı işlemleri için kullanılır.

### Sonuç
`JdbcTemplate`, SQL sorgularını manuel yazmak isteyen veya ORM kullanmadan doğrudan veritabanıyla etkileşim kurmak isteyen Spring Boot geliştiricileri için güçlü ve kullanışlı bir araçtır. JDBC işlemlerini kolaylaştırarak, kaynak yönetimi, hata işleme ve parametre güvenliği gibi konularda standart çözümler sunar.


## Spring Boot
```sh 

```
---

Spring Framework’ün bir bileşeni olan `JdbcTemplate`, veri tabanıyla etkileşimi kolaylaştırmak için geliştirilmiş bir araçtır. JDBC (Java Database Connectivity) API'sini basitleştirir ve veri tabanı bağlantıları, hata yönetimi, veri çekme ve güncelleme işlemleri gibi temel işlevleri daha rahat ve güvenli hale getirir. `JdbcTemplate` kullanmanın avantajları kadar bazı dezavantajları da bulunmaktadır. İşte detaylı bir şekilde avantaj ve dezavantajları:

---

### JdbcTemplate’in Avantajları

1. **Kaynak Yönetiminin Kolaylığı**:
    - JDBC ile çalışırken bağlantı, `Statement` ve `ResultSet` gibi kaynakları manuel olarak açmak ve kapatmak gerekir. `JdbcTemplate`, bu kaynakları otomatik olarak yönetir ve bağlantı sızıntılarını önler.
    - Özellikle uzun süreli uygulamalarda kaynak yönetiminin doğru yapılması performansı artırır.

2. **Daha Basit Hata Yönetimi**:
    - `JdbcTemplate`, JDBC'nin `SQLException` sınıfı yerine `DataAccessException` adlı daha genel ve Spring’e özgü bir istisna yönetimi sağlar.
    - Bu sayede, SQL hatalarını uygulama düzeyinde daha iyi yakalamak ve yönetmek mümkündür.

3. **Güvenli Parametreli Sorgu Desteği**:
    - `JdbcTemplate`, SQL enjeksiyonuna karşı koruma sağlayan parametreli sorguları destekler. Parametreli sorgular ile değişkenler güvenli bir şekilde SQL cümlelerine yerleştirilir.
    - SQL enjeksiyonu gibi güvenlik açıklarına karşı önlem alınması güvenilir bir veri tabanı erişimi sağlar.

4. **CRUD İşlemlerini Kolaylaştırma**:
    - Veri ekleme, güncelleme, silme ve okuma gibi işlemler `JdbcTemplate` ile çok daha basit hale gelir. `update()`, `query()`, `queryForObject()` gibi metodlar sayesinde temel SQL işlemleri hızlıca yapılabilir.
    - Bu da veri tabanı ile sık etkileşimde bulunan uygulamalarda geliştirme sürecini hızlandırır.

5. **Esnek SQL Yazma İmkanı**:
    - ORM (Object-Relational Mapping) araçlarına kıyasla `JdbcTemplate` ile tamamen SQL tabanlı çalışılabilir. Karmaşık SQL sorgularını `JdbcTemplate` üzerinden doğrudan yazabilirsiniz.
    - Bu esneklik, özellikle karmaşık sorgu ihtiyaçları olan projelerde önemli bir avantajdır.

6. **Transaction Yönetimi**:
    - Spring Framework ile uyumlu olan `JdbcTemplate`, `@Transactional` anotasyonu ile işlemleri yönetir. Bu sayede veri tabanındaki işlemler bir bütün olarak ele alınır ve bir hata durumunda tüm değişiklikler geri alınır.
    - Transaction yönetiminin sağladığı bu bütünlük, veri güvenliğini artırır.

7. **Performans**:
    - ORM araçlarına kıyasla daha hızlı bir veri tabanı etkileşimi sağlar çünkü `JdbcTemplate`, doğrudan SQL sorguları ile çalışır ve veri tabanı işlemlerinde bir katman daha azdır.

---

### JdbcTemplate’in Dezavantajları

1. **SQL Bağımlılığı**:
    - `JdbcTemplate`, SQL sorgularının elle yazılmasını gerektirir. Bu, uygulamanın veritabanı bağımlılığını artırır. Örneğin, veritabanı türü değiştiğinde (MySQL'den PostgreSQL'e geçiş gibi) SQL ifadelerinde değişiklik yapmak gerekebilir.
    - ORM çözümlerinde olduğu gibi soyutlama seviyesi düşük olduğu için veritabanı değiştirme süreçlerinde fazladan iş yükü getirir.

2. **Kod Tekrarı**:
    - SQL sorgularını elle yazmak, kod tekrarına yol açabilir. Özellikle büyük projelerde benzer SQL ifadelerinin tekrar tekrar yazılması gerekebilir.
    - ORM çözümleri ile genellikle bu tekrarlar model katmanında tek bir tanımla yönetilebilirken, `JdbcTemplate` ile her SQL ifadesi için ayrı bir sorgu yazmak gerekebilir.

3. **Nesne-İlişkisel Eşleme (ORM) Eksikliği**:
    - `JdbcTemplate`, veri tabanı kayıtlarını doğrudan Java nesnelerine otomatik olarak eşleştirmez. Elde edilen sonuçları nesnelere manuel olarak dönüştürmek için `RowMapper` kullanmak gerekebilir.
    - ORM araçları (Hibernate, JPA gibi) otomatik nesne eşleme desteği sunarken, `JdbcTemplate` ile bu işlemi kendiniz yapmanız gerekir.

4. **Bakım Zorluğu**:
    - Çok sayıda SQL sorgusu içeren projelerde bakım zorluğu artabilir. SQL sorgularındaki değişiklikler doğrudan kod içerisine yazıldığı için bu sorgular üzerinde yapılacak değişiklikler uygulamanın her yerinde güncellenmelidir.
    - Özellikle büyük projelerde bu durum, bakım sürecinde fazladan iş yükü oluşturur.

5. **Sınırlı Çoklu Veri Kaynağı Desteği**:
    - `JdbcTemplate` varsayılan olarak tek bir veri kaynağı ile çalışır. Birden fazla veri kaynağı ile çalışmak istediğinizde ekstra yapılandırmalar gerekebilir.
    - ORM araçları çoklu veri kaynaklarını daha kolay yönetme imkanına sahipken, `JdbcTemplate`'de bu işlemler daha karmaşık hale gelebilir.

6. **Yüksek Seviye Veri Yönetimi Özelliklerinin Eksikliği**:
    - ORM araçları, nesneler arası ilişkiler (birlikte yükleme, geç yükleme) gibi gelişmiş özellikleri desteklerken `JdbcTemplate` bu özelliklere sahip değildir.
    - Örneğin, ilişkili nesnelerin otomatik olarak yüklenmesi gibi özellikler `JdbcTemplate`'de bulunmaz, dolayısıyla bu ilişkileri yönetmek için daha fazla manuel kod yazmak gerekebilir.

---

### JdbcTemplate’in Avantaj ve Dezavantajlarının Özet Tablosu

| Avantajlar                               | Dezavantajlar                                    |
|------------------------------------------|--------------------------------------------------|
| Kaynak Yönetimi Kolaylığı                | SQL Bağımlılığı                                  |
| Hata Yönetimi                            | Kod Tekrarı                                      |
| Güvenli Parametreli Sorgu                | ORM Eşleme Eksikliği                             |
| CRUD İşlemlerinde Kolaylık               | Bakım Zorluğu                                    |
| Esnek SQL Yazma İmkanı                   | Çoklu Veri Kaynağı Desteği Zorluğu               |
| Transaction Yönetimi                      | Yüksek Seviye Veri Yönetim Özelliklerinin Eksikliği|
| Performans                               | -                                                |

---

### Sonuç
Spring `JdbcTemplate`, veri tabanı işlemlerini daha hızlı ve basit hale getirirken, SQL bağımlılığı ve bakım zorluğu gibi dezavantajlara da sahiptir. Küçük ve orta ölçekli projeler için hızlı bir çözüm sunar ancak büyük projelerde veya karmaşık nesne ilişkilerinin bulunduğu durumlarda ORM çözümleri (Spring Data JPA, Hibernate vb.) ile birlikte kullanılması daha mantıklı olabilir. `JdbcTemplate`, SQL tabanlı veri erişimi gerektiren ve ORM’nin fazla soyutlama sağladığı projelerde ideal bir seçimdir.


## Spring Boot Delivered Query, Named Query, JPQL, Native Query Örnekleri
```sh 

```
---

Spring Data JPA, Java uygulamalarında veri tabanı işlemlerini kolaylaştırmak için çeşitli sorgulama yöntemleri sunar. Bu yöntemler arasında Delivered Query, Named Query, JPQL ve Native Query bulunur. Her birinin kendi kullanım amacı ve avantajları vardır. Aşağıda her birinin detaylı açıklamaları yer almaktadır:

---

### 1. Delivered Query (Derived Query)
Delivered Query, metod isimlerinden otomatik olarak SQL sorguları üreten bir özelliktir. Bu özellik sayesinde, belirli kurallara uygun metod isimleri yazarak Spring Data JPA’nın bu metodlar için otomatik olarak SQL sorgusu oluşturmasını sağlarız. Delivered Query kullanımı özellikle basit CRUD işlemlerinde yaygın olarak tercih edilir.

#### Özellikler
- **Kolay Kullanım**: Metod ismine göre Spring Data JPA, SQL sorgusunu otomatik olarak oluşturur.
- **Yaygın Kapsam**: Tek bir kolon üzerinde eşleştirme, aralıklar, sıralama ve benzeri birçok koşul desteklenir.
- **Parametre Uyarlama**: Delivered Query metotları, metod isminde belirtilen parametreleri alır ve uygun SQL sorgusunu oluşturur.

#### Kullanım Örnekleri
Örneğin, bir `CustomerEntity` sınıfı üzerinde `firstName` ve `age` gibi alanlara göre sorgu yapıyorsak, aşağıdaki gibi `ICustomerRepository` üzerinde Delivered Query tanımlayabiliriz:

```java
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {

    // Belirli bir isme sahip müşterileri bulma
    List<CustomerEntity> findByFirstName(String firstName);

    // Yaşı belirli bir değerden büyük olan müşterileri bulma
    List<CustomerEntity> findByAgeGreaterThan(int age);

    // İsim sıralamasına göre müşterileri bulma
    List<CustomerEntity> findAllByOrderByFirstNameAsc();
}
```

Bu örneklerde Spring Data JPA, `findByFirstName`, `findByAgeGreaterThan` ve `findAllByOrderByFirstNameAsc` metodları için SQL sorgularını otomatik olarak oluşturur.

#### Avantajları
- Hızlı ve pratik bir şekilde basit sorguları yazma imkanı sunar.
- Kolay anlaşılır, bakımı kolaydır ve çoğu CRUD işlemi için yeterlidir.

#### Dezavantajları
- Karmaşık sorgular veya birden fazla tabloya erişim gerektiren durumlarda sınırlıdır.
- Metod isimleri büyüdükçe okunabilirlik azalabilir.

---

### 2. Named Query
Named Query, `@NamedQuery` anotasyonu ile `Entity` sınıfı üzerinde tanımlanır ve bu sorgular uygulama çalıştığında önceden derlenir. Named Query kullanarak sık kullanılan veya karmaşık sorguları bir defa tanımlar ve bunları repository içerisinde tekrar tekrar çağırabiliriz.

#### Özellikler
- **Önceden Tanımlı ve Derlenmiş**: Uygulama başlatıldığında, tanımlanan sorgular derlenir ve kullanılmaya hazır hale gelir.
- **Tekrarlı Kullanım**: Aynı sorguyu tekrar kullanmanız gereken durumlarda uygun bir yöntemdir.
- **Kolay Bakım**: Tüm Named Query'ler `Entity` sınıfında toplandığından, sorgularda yapılacak değişiklikler merkezi olarak yönetilebilir.

#### Kullanım Örnekleri
Örneğin, `CustomerEntity` üzerinde bir `Named Query` tanımlayalım:

```java
@Entity
@NamedQueries({
    @NamedQuery(name = "Customer.findByLastName", query = "SELECT c FROM CustomerEntity c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "Customer.findByCity", query = "SELECT c FROM CustomerEntity c WHERE c.city = :city"),
    @NamedQuery(name = "Customer.findByAgeGreaterThan", query = "SELECT c FROM CustomerEntity c WHERE c.age > :age")
})
public class CustomerEntity {
    // Sınıf tanımı burada
}

// ICustomerRepository sınıfında kullanımı
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {
    
    @Query(name = "Customer.findByLastName")
    List<CustomerEntity> findByLastName(@Param("lastName") String lastName);
}
```

#### Avantajları
- Sık kullanılan sorguları merkezi bir yerde tanımlamak mümkündür.
- Derlenmiş sorgular performansı artırır ve bakım açısından kolaylık sağlar.
- Karmaşık sorgularda hata ayıklama ve düzenleme kolaylığı sunar.

#### Dezavantajları
- Sorgular `Entity` sınıfında toplandığından, `Entity` sınıfı karmaşık hale gelebilir.
- Genellikle statik sorgular içindir, dinamik sorgular için sınırlıdır.

---

### 3. JPQL (Java Persistence Query Language)
JPQL, Java EE uygulamalarında veri tabanı sorguları yazmak için kullanılan bir dildir ve SQL'e benzer bir yapıya sahiptir. Ancak, SQL'in aksine JPQL, doğrudan veri tabanı tablolarını değil, Java sınıflarını ve alanlarını kullanır. JPQL sorguları, veri tabanı bağımsızlığı sağlar ve ORM tabanlı uygulamalarda tercih edilir.

#### Özellikler
- **Nesne Tabanlı**: SQL’den farklı olarak, doğrudan tablolar yerine Java nesneleri (Entity) üzerinden çalışır.
- **Veri Tabanı Bağımsızlığı**: JPQL sorguları genellikle veri tabanı bağımsızdır ve farklı veri tabanları üzerinde sorunsuz çalışır.
- **Esnek**: Karmaşık ve dinamik sorgular yazmak için uygundur.

#### Kullanım Örnekleri
JPQL kullanarak örnek bir sorgu yazalım:

```java
// ICustomerRepository sınıfında JPQL sorgu örnekleri
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {

    // Ad ve Soyada göre müşteri bulma
    @Query("SELECT c FROM CustomerEntity c WHERE c.firstName = :firstName AND c.lastName = :lastName")
    List<CustomerEntity> findByFullName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    // Yaş kriterine göre müşteri listeleme
    @Query("SELECT c FROM CustomerEntity c WHERE c.age > :age")
    List<CustomerEntity> findCustomersOlderThan(@Param("age") int age);
}
```

#### Avantajları
- ORM yapısına uyumludur ve veri tabanı bağımsız çalışır.
- Karmaşık sorgular yazmayı kolaylaştırır.
- Java nesneleri ile doğrudan çalıştığı için daha anlaşılırdır.

#### Dezavantajları
- Bazı özel veri tabanı işlevlerini desteklemez.
- Karmaşık ve çok performans gerektiren sorgularda daha düşük performans gösterebilir.

---

### 4. Native Query
Native Query, doğrudan SQL sorguları kullanarak veri tabanıyla etkileşime girmenizi sağlar. JPQL ve diğer ORM tabanlı sorguların aksine, Native Query veri tabanı bağımlı SQL sorgularını destekler. Bu nedenle, belirli bir veri tabanına özel SQL komutları kullanılabilir.

#### Özellikler
- **Doğrudan SQL Kullanımı**: SQL dilinin tüm özelliklerini kullanabilirsiniz (JOIN'ler, `GROUP BY` işlemleri, alt sorgular vb.)
- **Veri Tabanına Özel İşlemler**: Veri tabanı bağımlı sorgular yazmak mümkündür.
- **Performans**: Karmaşık sorgular için daha performanslıdır çünkü SQL'in tüm gücünden yararlanılır.

#### Kullanım Örnekleri
Örneğin, `ICustomerRepository` içinde Native Query ile yazılmış SQL sorgularını görelim:

```java
// ICustomerRepository sınıfında Native Query örnekleri
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {

    // Şehir ve yaş kriterine göre müşteri bulma
    @Query(value = "SELECT * FROM customers WHERE city = :city AND age > :age", nativeQuery = true)
    List<CustomerEntity> findCustomersInCityOlderThan(@Param("city") String city, @Param("age") int age);

    // Belirli bir soyada sahip müşterileri listeleme
    @Query(value = "SELECT * FROM customers WHERE last_name = :lastName", nativeQuery = true)
    List<CustomerEntity> findByLastNameNative(@Param("lastName") String lastName);
}
```

#### Avantajları
- SQL’in sunduğu tüm özellikleri kullanarak veri tabanına doğrudan erişim sağlar.
- Karmaşık ve optimize edilmesi gereken sorgular için yüksek performans sunar.
- Belirli veri tabanı işlevlerini kullanarak daha detaylı işlemler yapma imkanı sağlar.

#### Dezavantajları
- Veri tabanı bağımlıdır, bu da taşınabilirliği zorlaştırır.
- SQL enjeksiyonuna karşı dikkatli olunması gerekir.
- ORM soyutlama katmanından yararlanmaz, dolayısıyla nesneler arası ilişkilerde manuel işlemler gerekebilir.

---

### Sonuç
Delivered Query, Named Query, JPQL ve Native Query her biri farklı ihtiyaçlara cevap veren güçlü sorgulama yöntemleridir.
- **Delivered Query** basit işlemler için hızlı

çözümler sunarken,
- **Named Query** tekrarlı ve önceden tanımlanmış sorgular için idealdir.
- **JPQL**, veri tabanı bağımsızlığı gerektiren, nesne odaklı sorgular için tercih edilirken,
- **Native Query**, doğrudan SQL sorgularıyla en yüksek performansı gerektiren işlemler için uygundur.

Her yöntemi, uygulamanın ihtiyaçlarına ve veri tabanı erişim gereksinimlerine göre seçerek etkili bir veri erişim stratejisi oluşturabilirsiniz.

## Spring Boot
```sh 

```
---



## Spring Boot Delivered Query, Named Query, JPQL, Native Query Örnekleri
```sh 

```
---

Dosyalarınıza ve istediğiniz konu başlıklarına uygun olarak, `Delivered Query`, `Named Query`, `JPQL`, ve `Native Query` için üçer örnek hazırlıyorum. Bu örnekleri, veritabanı işlemleri üzerinde nasıl çalışacaklarına dair açıklamalarla birlikte paylaşacağım.

### 1. Delivered Query
Delivered Query, Spring Data JPA'nın metod adlarına göre otomatik olarak SQL sorgularını oluşturmasına dayalıdır.

```java
// CustomerEntity.java dosyasında tanımlı CustomerEntity ile ICustomerRepository kullanılarak Delivered Query örnekleri
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {

    // 1. Ad ile müşteri bulma
    List<CustomerEntity> findByFirstName(String firstName);

    // 2. Şehir ile müşteri listeleme
    List<CustomerEntity> findByCity(String city);

    // 3. Yaş aralığındaki müşterileri bulma
    List<CustomerEntity> findByAgeBetween(int minAge, int maxAge);
}
```

### 2. Named Query
Named Query, genellikle `@NamedQuery` anotasyonu ile belirtilir ve sorgular `Entity` sınıfında tanımlanır. Daha sonra bu sorgular repository içinde çağrılır.

```java
// CustomerEntity.java dosyasında Named Query tanımları
@Entity
@NamedQueries({
    @NamedQuery(name = "Customer.findByLastName", query = "SELECT c FROM CustomerEntity c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "Customer.findByCity", query = "SELECT c FROM CustomerEntity c WHERE c.city = :city"),
    @NamedQuery(name = "Customer.findByAgeGreaterThan", query = "SELECT c FROM CustomerEntity c WHERE c.age > :age")
})
public class CustomerEntity {
    // CustomerEntity sınıfının diğer alanları ve metodları
}

// ICustomerRepository.java dosyasında Named Query çağrıları
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {

    // 1. Soyad ile müşteri bulma
    @Query(name = "Customer.findByLastName")
    List<CustomerEntity> findByLastName(@Param("lastName") String lastName);

    // 2. Şehir ile müşteri bulma
    @Query(name = "Customer.findByCity")
    List<CustomerEntity> findByCity(@Param("city") String city);

    // 3. Belirli bir yaşın üstündeki müşterileri bulma
    @Query(name = "Customer.findByAgeGreaterThan")
    List<CustomerEntity> findByAgeGreaterThan(@Param("age") int age);
}
```

### 3. JPQL (Java Persistence Query Language)
JPQL, Java varlıklarına dayalı olarak SQL benzeri sorgular yazmamızı sağlar. JPQL, `@Query` anotasyonu ile kullanılır.

```java
// ICustomerRepository.java dosyasında JPQL örnekleri
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {

    // 1. Ad ve Soyada göre müşteri bulma
    @Query("SELECT c FROM CustomerEntity c WHERE c.firstName = :firstName AND c.lastName = :lastName")
    List<CustomerEntity> findByFullName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    // 2. Yaş kriterine göre müşteri listeleme
    @Query("SELECT c FROM CustomerEntity c WHERE c.age > :age")
    List<CustomerEntity> findCustomersOlderThan(@Param("age") int age);

    // 3. Şehirde bulunan müşterileri listeleme
    @Query("SELECT c FROM CustomerEntity c WHERE c.city = :city")
    List<CustomerEntity> findByCity(@Param("city") String city);
}
```

### 4. Native Query
Native Query, doğrudan SQL komutlarını kullanmamıza olanak tanır ve `@Query` anotasyonu ile belirtilir. JPQL’in aksine, SQL sorguları veri tabanı bağımlı hale gelir.

```java
// ICustomerRepository.java dosyasında Native Query örnekleri
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {

    // 1. Şehir ve yaş kriterine göre müşteri bulma
    @Query(value = "SELECT * FROM customers WHERE city = :city AND age > :age", nativeQuery = true)
    List<CustomerEntity> findCustomersInCityOlderThan(@Param("city") String city, @Param("age") int age);

    // 2. Belirli bir soyada sahip müşterileri listeleme
    @Query(value = "SELECT * FROM customers WHERE last_name = :lastName", nativeQuery = true)
    List<CustomerEntity> findByLastNameNative(@Param("lastName") String lastName);

    // 3. Tüm müşterileri alfabetik sırayla listeleme
    @Query(value = "SELECT * FROM customers ORDER BY first_name ASC", nativeQuery = true)
    List<CustomerEntity> findAllOrderedByFirstName();
}
```

Bu örnekler, veri tabanı sorgularını çeşitli şekillerde kullanmanıza olanak sağlar:
- Delivered Query, otomatik sorgu oluşturma ile daha kısa kodlama sağlarken
- Named Query, Entity sınıfında önceden tanımlanmış sorguları kullanır,
- JPQL, Java varlıklarına dayalı SQL benzeri sorgular oluşturur,
- Native Query ise doğrudan SQL kullanılarak daha karmaşık veya veri tabanına özel sorguların gerçekleştirilmesine olanak tanır.

## Customer Örneği
Aşağıda `Delivered Query`, `Named Query`, `JPQL`, ve `Native Query` hakkında açıklamalar ve her biri için en az üç örnek verilmiştir. Verilen kodlar, `CustomerEntity` ve `ICustomerRepository` sınıflarınıza uygun şekilde düzenlenmiştir.

---

### 1. **Delivered Query**
Spring Data JPA'nın sağladığı otomatik sorgulardır. Yöntem adlarına göre sorgular otomatik olarak üretilir.

**Özellikler:**
- Sorgular otomatik olarak oluşturulur.
- Kod yazımı hızlıdır.

**Örnekler:**

```java
@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {

    // 1. İlk adı verilen bir müşteriyi bul
    CustomerEntity findByFistname(String firstname);

    // 2. Soyadı belirli bir kelimeyle başlayan müşterileri listele
    List<CustomerEntity> findByLastnameStartingWith(String prefix);

    // 3. Notları belirli bir kelime içeren müşterileri listele
    List<CustomerEntity> findByNotesContaining(String keyword);
}
```

**Açıklama:**
- `findByFistname`: `fistname` alanında eşleşen müşteri döner.
- `findByLastnameStartingWith`: Belirli bir harf dizisiyle başlayan `lastname` değerleri aranır.
- `findByNotesContaining`: `notes` alanında belirli bir kelime içeren müşteriler bulunur.

---

### 2. **Named Query**
`@NamedQuery` anotasyonu ile tanımlanan statik sorgulardır.

**Özellikler:**
- Sorgular doğrudan entitelerde tanımlanır.
- Tekrarlanabilir ve sabittir.

**Örnekler:**

`CustomerEntity.java` dosyasına ekleyin:
```java
@NamedQueries({
    @NamedQuery(name = "CustomerEntity.findAllCustomers", query = "SELECT c FROM Customers c"),
    @NamedQuery(name = "CustomerEntity.findByLastname", query = "SELECT c FROM Customers c WHERE c.lastname = :lastname"),
    @NamedQuery(name = "CustomerEntity.findWithNotes", query = "SELECT c FROM Customers c WHERE c.notes LIKE :notes")
})
@Entity
@Table(name = "customers")
public class CustomerEntity extends BaseEntity {
    // ...
}
```

`ICustomerRepository.java` dosyasına ekleyin:
```java
@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {
    // 1. Tüm müşterileri getir
    List<CustomerEntity> findAllCustomers();

    // 2. Belirli soyadı olan müşteriyi getir
    List<CustomerEntity> findByLastname(String lastname);

    // 3. Notlarda belirli bir ifadeyi içeren müşterileri getir
    List<CustomerEntity> findWithNotes(String notes);
}
```

---

### 3. **JPQL**
Java Persistence Query Language (JPQL) kullanılarak yazılan dinamik sorgulardır.

**Özellikler:**
- Entite üzerine çalışır, SQL'den soyutlanmıştır.
- Daha okunaklı ve güvenlidir.

**Örnekler:**

```java
@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {

    // 1. Belirli bir soyadı ile müşterileri listele
    @Query("SELECT c FROM Customers c WHERE c.lastname = :lastname")
    List<CustomerEntity> findCustomersByLastname(@Param("lastname") String lastname);

    // 2. Notlara göre arama yap
    @Query("SELECT c FROM Customers c WHERE c.notes LIKE %:keyword%")
    List<CustomerEntity> searchCustomersByNotes(@Param("keyword") String keyword);

    // 3. Adres bilgisine göre müşterileri getir
    @Query("SELECT c FROM Customers c JOIN c.addressCustomerEntity a WHERE a.city = :city")
    List<CustomerEntity> findCustomersByCity(@Param("city") String city);
}
```

---

### 4. **Native Query**
Doğrudan SQL kullanılarak yazılan sorgulardır.

**Özellikler:**
- Veritabanına özel sorgular yazılabilir.
- Performans kritik yerlerde tercih edilir.

**Örnekler:**

```java
@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {

    // 1. Tüm müşterileri getir
    @Query(value = "SELECT * FROM customers", nativeQuery = true)
    List<CustomerEntity> findAllCustomersNative();

    // 2. Belirli bir soyadı ile müşterileri getir
    @Query(value = "SELECT * FROM customers WHERE lastname = :lastname", nativeQuery = true)
    List<CustomerEntity> findCustomersByLastnameNative(@Param("lastname") String lastname);

    // 3. Notlara göre arama yap
    @Query(value = "SELECT * FROM customers WHERE notes LIKE %:keyword%", nativeQuery = true)
    List<CustomerEntity> searchCustomersByNotesNative(@Param("keyword") String keyword);
}
```

---

### Özet Karşılaştırma
| **Tip**            | **Kullanım Durumu**                         | **Özellikler**                                        |
|---------------------|---------------------------------------------|------------------------------------------------------|
| Delivered Query     | Basit sorgular için hızlı ve kolay çözüm.   | Metot adlarına göre otomatik sorgu oluşturulur.      |
| Named Query         | Sabit ve sık kullanılan sorgular.           | Sorgular entite üzerinde tanımlanır.                |
| JPQL                | Dinamik sorgular ve entite tabanlı işlemler.| SQL'den bağımsız, entite odaklı sorgular.           |
| Native Query        | Performans kritik veya özel sorgular.       | Doğrudan SQL sorguları kullanılır.                  |

Bu dört yöntemin farklı durumlarda nasıl uygulanacağını ve her birinin avantajlarını açıkladık. Daha fazla örnek isterseniz belirtin!