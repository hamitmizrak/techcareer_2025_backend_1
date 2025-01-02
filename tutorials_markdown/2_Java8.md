# Techcareer 2025 Backend-1 Spring Boot
**Spring Boot**
---

[GitHub](https://github.com/hamitmizrak/ )

## Project GitHub clone 
```sh
git clone 
```
---

## Version
```sh
git -v
java --version
javac --version
mvn -v
docker version
docker -v
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

git clone https://github.com/hamitmizrak/techcareer_2025_backend_1.git
```
---

## Git Codes
```sh
git status
git logs

```


### Örnek Kodu Açıklaması:
```java
private ApiResult apiResult;
@PostConstruct
public void springData() {
    apiResult = new ApiResult();
}
```
## Spring Boot
```sh 

```
---



Java 8 ile gelen **Stream API**, veri işlemlerini daha etkili, temiz ve okunabilir bir şekilde yapmayı sağlayan bir araçtır. 
`Stream`ler, bir veri kaynağı (koleksiyonlar, diziler veya dosyalar gibi) üzerinde işlem yapmamıza olanak tanıyan bir dizi metottan oluşur. 
Stream API, özellikle koleksiyonlar üzerindeki sıralama, filtreleme, dönüştürme ve toplama işlemlerini çok daha kolay hale getirir. 
Java 8 ile gelen fonksiyonel programlama özellikleri sayesinde `Stream`ler, geleneksel `for` döngüleri ve `iterator` işlemlerine daha modern bir alternatif sunar.

### Stream API’nin Temel Özellikleri

1. **Fonksiyonel Programlama Mantığı ile Çalışır**: Java 8 ile gelen lambda ifadeleri ile Stream işlemleri kolaylaşır. 
Lambda ile ifade edilen kısa ve etkili işlemler sayesinde daha az kodla daha çok iş yapılabilir.
2. **İşlem Zinciri (Pipeline) Mantığı**: Stream’ler, bir veri kaynağından veri alır ve bu veri üzerinde çeşitli işlemler uygular. 
Bu işlemler birbirine bağlıdır ve bir zincir (pipeline) olarak ifade edilir.
3. **Tek Kullanımlık Yapı**: Bir `Stream`, yalnızca bir kez tüketilebilir; yeniden kullanılamaz. 
Bu nedenle bir `Stream` ile bir kez işlem yapıldığında, başka bir işlem için yeni bir `Stream` oluşturmak gerekir.
4. **Dönüştürülebilirlik**: `Stream`ler, veri kaynağını değiştirmez, verileri işleyerek yeni `Stream` veya sonuçlar üretir. 
`Stream` nesnesini koleksiyonlara veya diğer veri yapılarına dönüştürebiliriz.
5. **Paralel İşlem Desteği**: `Stream` API, paralel işlemler için güçlü bir destek sağlar. 
Bu, büyük veri kümeleri üzerinde işlemleri hızlandırmak için önemlidir.

### Stream Türleri

1. **Sıralı (Sequential) Stream**: Veriler sırayla işlenir. `Collection.stream()` metodu ile elde edilir. 
Bu türde işlemler, veri sırasına sadık kalarak tek bir iş parçacığı (thread) üzerinde çalışır.
2. **Paralel (Parallel) Stream**: Veriler paralel olarak işlenir ve performansı artırmak için çok çekirdekli işlemcilerin gücünden yararlanır. 
`Collection.parallelStream()` metodu ile elde edilir.

### Stream’in Çalışma Mantığı: Ara ve Terminal İşlemler

Stream işlemleri ikiye ayrılır: **ara (intermediate)** ve **terminal işlemler**.

#### 1. Ara İşlemler (Intermediate Operations)
Ara işlemler, bir `Stream` üzerinde dönüşüm veya filtreleme gibi işlemler yapar ve yeni bir `Stream` döner. 
Bu işlemler "lazy" (tembel) olarak değerlendirilir; yani, ara işlemler tek başlarına çalıştırıldığında işlem yapılmaz, 
ancak bir terminal işlem çağrıldığında zincirdeki tüm ara işlemler gerçekleştirilir.

Başlıca ara işlemler:
- **filter(Predicate)**: Veriyi belirli bir koşula göre filtreler.
- **map(Function)**: Her öğe üzerinde dönüşüm yapar ve her bir öğeyi bir diğerine dönüştürür.
- **sorted() veya sorted(Comparator)**: Veriyi doğal sıralama veya özel bir `Comparator` ile sıralar.
- **distinct()**: Aynı olan öğeleri kaldırır (tekrarlı öğeleri kaldırır).
- **limit(long)**: İlk belirtilen sayıda elemanı alır.
- **skip(long)**: İlk belirtilen sayıda elemanı atlar.

Örnek:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
List<Integer> evenNumbers = numbers.stream()
                                   .filter(n -> n % 2 == 0)
                                   .collect(Collectors.toList());
System.out.println(evenNumbers); // Çıktı: [2, 4, 6, 8, 10]
```

Yukarıdaki örnekte, `filter` ara işlemi ile yalnızca çift sayılar seçilmiş ve yeni bir `Stream` olarak işlenmiştir.

#### 2. Terminal İşlemler (Terminal Operations)
Terminal işlemler, bir `Stream` üzerindeki işlemleri sonlandırır ve `Stream` iş akışının sonuçlarını döner. 
Terminal işlemler çağrıldığında, `Stream` üzerindeki ara işlemler gerçekleştirilir ve terminal işlemle birlikte sonlandırılır.

Başlıca terminal işlemler:
- **forEach(Consumer)**: Her bir öğeyi belirtilen işlem ile işler.
- **collect(Collector)**: `Stream` sonuçlarını bir koleksiyona veya diğer veri yapılarına toplar.
- **reduce(BinaryOperator)**: `Stream` öğelerini indirger ve tek bir sonuç döner.
- **count()**: `Stream` üzerindeki öğe sayısını döner.
- **anyMatch(Predicate), allMatch(Predicate), noneMatch(Predicate)**: Belirli koşullara göre `boolean` sonuç döner.

Örnek:
```java
List<String> names = Arrays.asList("Ali", "Ahmet", "Ayşe", "Mehmet");
String concatenatedNames = names.stream()
                                .filter(name -> name.startsWith("A"))
                                .collect(Collectors.joining(", "));
System.out.println(concatenatedNames); // Çıktı: Ali, Ahmet, Ayşe
```

### Stream İşlemlerinin Özellikleri ve Kullanım Durumları

1. **Filtreleme**: `filter` ile belirli koşullara göre eleme yapılır.
2. **Dönüştürme**: `map` ile bir veri kaynağındaki veriler başka bir veri tipine veya şekle dönüştürülür. Örneğin, `String` listesindeki her bir öğeyi büyük harfe çevirmek için `map` kullanılabilir.
3. **Toplama İşlemleri**: `collect` ile bir `Stream`, liste, küme, harita gibi veri yapılarına dönüştürülebilir.
4. **Birleştirme ve İndirgeme (Reduction)**: `reduce` ile `Stream` öğeleri tek bir değere indirgenebilir. Örneğin, bir sayı listesindeki sayıların toplamını bulmak.
5. **Sıralama ve Sınırlama**: `sorted` ile sıralama, `limit` ile eleman sayısını sınırlandırma yapılır.

Örnek:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.stream()
                 .reduce(0, Integer::sum);
System.out.println(sum); // Çıktı: 15
```

### Parallel Stream ile Paralel İşlemler

`Stream API`, çok çekirdekli sistemlerde işlemleri paralel hale getirmeyi destekler. `parallelStream()` kullanarak işlemleri paralel hale getirip performansı artırabilirsiniz. Ancak, paralel işlemler her durumda verim sağlamayabilir; bu yüzden dikkatli kullanılmalıdır.

Örnek:
```java
List<Integer> largeList = Arrays.asList(…); // Büyük bir liste
long count = largeList.parallelStream()
                      .filter(n -> n % 2 == 0)
                      .count();
System.out.println("Çift sayı adedi: " + count);
```

### Stream API’nin Sağladığı Avantajlar

- **Kodun Okunabilirliği**: `Stream` ile yazılan kod daha kısa ve daha okunaklıdır.
- **Performans Artışı**: Paralel `Stream` ile büyük veri setlerinde performans artışı sağlanabilir.
- **Fonksiyonel Programlama**: Lambda ifadeleri ile veri işleme daha basit hale gelir.
- **İmmutability**: `Stream` işlemleri veriyi değiştirmez, yalnızca yeni bir `Stream` veya sonuç üretir.

### Stream API İle Koleksiyon İşlemleri

Koleksiyonlar üzerinde `Stream API` kullanımı, verileri işlemek için döngü veya `iterator` kullanmaya göre daha işlevseldir. 
Geleneksel yöntemde bir liste üzerinde filtreleme yapmak için `for` döngüsü ile `if` kontrolleri yazmanız gerekirdi. 
`Stream` ile bu işlemler daha sade hale gelir.

Örnek:
```java
List<Person> people = Arrays.asList(
    new Person("John", 25),
    new Person("Jane", 22),
    new Person("Jack", 30)
);

List<Person> filteredPeople = people.stream()
                                    .filter(person -> person.getAge() > 23)
                                    .collect(Collectors.toList());
System.out.println(filteredPeople);
```

Bu örnekte, `Stream API`, bir `for` döngüsüne kıyasla daha sade ve anlaşılırdır.

### Sonuç

Java 8 `Stream API`, veri işlemeyi daha kolay ve etkili hale getiren güçlü bir araçtır. 
Fonksiyonel programlama yetenekleri, paralel işlem desteği ve veri kaynağını değiştirmeden işleme olanaklarıyla modern Java geliştirmede vazgeçilmez hale gelmiştir. 
`Stream`ler, özellikle büyük ve karmaşık veri işleme görevlerinde daha az kod yazarak daha



## Spring Boot
```sh 

```
---

Java 8 Stream API'nin sağladığı metotlar, veri işleme akışını daha okunabilir ve etkili hale getiren birçok farklı işlem sunar. 
Bu metotlar, genellikle iki ana kategoriye ayrılır: 
**Ara İşlemler (Intermediate Operations)** ve **Terminal İşlemler (Terminal Operations)**. 
İşte en yaygın kullanılan Stream API metotları ve açıklamaları:

### Ara İşlemler (Intermediate Operations)

Ara işlemler, bir `Stream` üzerinde dönüşüm veya filtreleme gibi işlemler yapar ve yeni bir `Stream` döner. 
Bu işlemler, tembel (lazy) olarak değerlendirilir, yani yalnızca bir terminal işlem çağrıldığında etkin hale gelirler.

1. **`filter(Predicate<? super T> predicate)`**: Stream’deki öğeleri belirtilen koşula göre filtreler. 
Predicate (koşul) sağlanır ve bu koşulu sağlayan öğeler yeni bir `Stream` olarak döner.

   ```java
   stream.filter(n -> n > 10);
   ```

2. **`map(Function<? super T, ? extends R> mapper)`**: Her bir öğe üzerinde dönüşüm işlemi yapar ve yeni bir `Stream` döner. 
Öğeleri bir veri tipinden başka bir veri tipine dönüştürmek için kullanılır.

   ```java
   stream.map(String::toUpperCase);
   ```

3. **`flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)`**: Her bir öğeyi bir `Stream`'e dönüştürür ve 
bu `Stream`leri tek bir `Stream` olarak birleştirir. 
4. Bir koleksiyonun içindeki koleksiyonları düzleştirmek için kullanılır.

   ```java
   stream.flatMap(list -> list.stream());
   ```

4. **`distinct()`**: Stream'deki tekrarlı (aynı) öğeleri kaldırır ve benzersiz öğelerden oluşan bir `Stream` döner.

   ```java
   stream.distinct();
   ```

5. **`sorted()`**: Stream'deki öğeleri doğal sıraya göre sıralar. Eğer öğeler `Comparable` değilse, `Comparator` parametresiyle sıralama yapılabilir.

   ```java
   stream.sorted();
   ```

6. **`sorted(Comparator<? super T> comparator)`**: Verilen `Comparator`'a göre öğeleri sıralar. Özel sıralama işlemleri için kullanılır.

   ```java
   stream.sorted(Comparator.reverseOrder());
   ```

7. **`limit(long maxSize)`**: Stream’in ilk belirtilen sayıda (`maxSize`) öğesini alır ve yeni bir `Stream` döner.

   ```java
   stream.limit(5);
   ```

8. **`skip(long n)`**: Stream’in ilk `n` öğesini atlar ve geriye kalan öğelerle yeni bir `Stream` döner.

   ```java
   stream.skip(3);
   ```

9. **`peek(Consumer<? super T> action)`**: Stream üzerinde işlem yaparken, her bir öğeyi gözlemlemek için kullanılır. 
Veriyi değiştirmez; debug amaçlı veya yan etkiler eklemek için kullanılabilir.

   ```java
   stream.peek(System.out::println);
   ```

### Terminal İşlemler (Terminal Operations)

Terminal işlemler, bir `Stream` üzerindeki işlemleri sonlandırır ve bir sonuç döner. 
Terminal işlem çağrıldığında, ara işlemler de işlenmiş olur.

1. **`forEach(Consumer<? super T> action)`**: Stream’deki her bir öğe üzerinde belirtilen işlemi uygular. Dönen bir sonuç yoktur.

   ```java
   stream.forEach(System.out::println);
   ```

2. **`collect(Collector<? super T, A, R> collector)`**: Stream öğelerini toplayarak bir koleksiyona veya başka bir sonuç tipine dönüştürür.
Genellikle `Collectors` yardımcı sınıfı ile kullanılır.

   ```java
   List<Integer> list = stream.collect(Collectors.toList());
   ```

3. **`reduce(BinaryOperator<T> accumulator)`**: Stream’deki öğeleri indirger ve tek bir sonuç döner. 
Bu, örneğin tüm sayıların toplamını veya çarpımını bulmak için kullanılabilir.

   ```java
   int sum = stream.reduce(0, Integer::sum);
   ```

4. **`reduce(T identity, BinaryOperator<T> accumulator)`**: Belirli bir başlangıç değeri (`identity`) ile indirgeme işlemi yapar. 
Başlangıç değeri, işlemin ilk girdisi olarak kullanılır.

   ```java
   int sum = stream.reduce(0, (a, b) -> a + b);
   ```

5. **`count()`**: Stream’deki öğelerin sayısını döner. Özellikle filtreleme gibi işlemler sonrası kaç öğe olduğunu bulmak için kullanışlıdır.

   ```java
   long count = stream.count();
   ```

6. **`anyMatch(Predicate<? super T> predicate)`**: Stream’de en az bir öğenin belirtilen koşulu sağladığını kontrol eder. 
`boolean` döner.

   ```java
   boolean hasEven = stream.anyMatch(n -> n % 2 == 0);
   ```

7. **`allMatch(Predicate<? super T> predicate)`**: Stream’deki tüm öğelerin belirtilen koşulu sağladığını kontrol eder. `boolean` döner.

   ```java
   boolean allPositive = stream.allMatch(n -> n > 0);
   ```

8. **`noneMatch(Predicate<? super T> predicate)`**: Stream’deki hiçbir öğenin belirtilen koşulu sağlamadığını kontrol eder. `boolean` döner.

   ```java
   boolean noneNegative = stream.noneMatch(n -> n < 0);
   ```

9. **`findFirst()`**: Stream’deki ilk öğeyi döner. Optional olarak sonuç döner; eğer boş bir `Stream` varsa sonuç `Optional.empty()` olur.

   ```java
   Optional<Integer> first = stream.findFirst();
   ```

10. **`findAny()`**: Stream’deki herhangi bir öğeyi döner. Paralel `Stream`lerde performans optimizasyonu sağlar. Sonuç `Optional` olarak döner.

    ```java
    Optional<Integer> any = stream.findAny();
    ```

### Stream API Kullanımına Dair Özet

Java 8 Stream API’nin sağladığı bu metotlar, veri üzerinde filtreleme, dönüştürme, sıralama, toplama ve daha fazlasını gerçekleştirmek için idealdir. 
Stream işlemleri, veri üzerinde işlem yapmayı çok daha basit ve etkili hale getirir, bu da kodun okunabilirliğini ve bakımını kolaylaştırır. 
Bu metotların işlevlerini doğru bir şekilde anlayarak, veri işleme ihtiyaçlarınıza göre uygun `Stream` işlemlerini seçebilirsiniz.

## Spring Boot
```sh 

```
---


