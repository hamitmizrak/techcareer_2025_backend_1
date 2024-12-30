İşte IntelliJ IDEA'da sıklıkla kullanılan kısayollar ve açıklamaları:

### 1. Kod Navigasyonu ve Arama
- **Class Bulma**:
   - **Windows/Linux**: `Ctrl + N`
   - **Mac**: `Command + O`
   - Açıklama: Projedeki herhangi bir sınıfı ada göre arar.

- **Dosya Bulma**:
   - **Windows/Linux**: `Ctrl + Shift + N`
   - **Mac**: `Command + Shift + O`
   - Açıklama: Projedeki herhangi bir dosyayı ada göre arar.

- **Semboller Arasında Arama**:
   - **Windows/Linux**: `Ctrl + Alt + Shift + N`
   - **Mac**: `Command + Option + O`
   - Açıklama: Projedeki herhangi bir sembolü (değişken, metod, sınıf vb.) arar.

- **Son Düzenlenen Dosyaları Göster**:
   - **Windows/Linux**: `Ctrl + E`
   - **Mac**: `Command + E`
   - Açıklama: En son açılan veya düzenlenen dosyaları listeler.

### 2. Kod Düzenleme
- **Kod Tamamlama**:
   - **Windows/Linux**: `Ctrl + Space`
   - **Mac**: `Control + Space`
   - Açıklama: Kod tamamlama için öneriler sunar.

- **Kod Formatlama**:
   - **Windows/Linux**: `Ctrl + Alt + L`
   - **Mac**: `Command + Option + L`
   - Açıklama: Seçili kodu veya dosyayı IntelliJ IDEA'nın düzenleme kurallarına göre otomatik olarak biçimlendirir.

- **Kullanılmayan Importları Temizleme**:
   - **Windows/Linux**: `Ctrl + Alt + O`
   - **Mac**: `Command + Option + O`
   - Açıklama: Kullanılmayan tüm importları siler.

- **İfadenin Tamamını veya Satırın Geri Kalanını Silme**:
   - **Windows/Linux**: `Ctrl + Y`
   - **Mac**: `Command + Delete`
   - Açıklama: Satırın geri kalanını veya seçili ifadeyi siler.

### 3. Refactoring
- **Refactor This**:
   - **Windows/Linux**: `Ctrl + Alt + Shift + T`
   - **Mac**: `Control + T`
   - Açıklama: Kodunuzu yeniden düzenlemenizi sağlayan refactoring seçenekleri sunar.

- **Değişken, Metod vb. Yeniden Adlandırma**:
   - **Windows/Linux**: `Shift + F6`
   - **Mac**: `Shift + F6`
   - Açıklama: Seçilen öğeyi yeniden adlandırır; tüm kullanımları günceller.

### 4. Kod İnceleme ve Çalıştırma
- **Hata Bulma (Debugging) Başlat**:
   - **Windows/Linux**: `Shift + F9`
   - **Mac**: `Control + D`
   - Açıklama: Uygulamayı hata ayıklama modunda başlatır.

- **Çalıştırma (Run)**:
   - **Windows/Linux**: `Shift + F10`
   - **Mac**: `Control + R`
   - Açıklama: Uygulamayı çalıştırır.

- **Hata Çıkarma (Step Into)**:
   - **Windows/Linux**: `F7`
   - **Mac**: `F7`
   - Açıklama: Kodda adım adım hata ayıklamaya girer.

- **Sonraki Adıma Geçme (Step Over)**:
   - **Windows/Linux**: `F8`
   - **Mac**: `F8`
   - Açıklama: Mevcut adımdan bir sonraki adıma geçer.

### 5. Genel Kısayollar
- **Arama (Search Everywhere)**:
   - **Windows/Linux**: `Shift` tuşuna iki kere basın
   - **Mac**: `Shift` tuşuna iki kere basın
   - Açıklama: Dosya, sınıf, sembol veya herhangi bir şeyi genel olarak arar.

- **Proje Gezginini Açma/Kapatma (Project View)**:
   - **Windows/Linux**: `Alt + 1`
   - **Mac**: `Command + 1`
   - Açıklama: Proje dosya gezgini penceresini açar veya kapatır.

- **Terminal Açma**:
   - **Windows/Linux**: `Alt + F12`
   - **Mac**: `Option + F12`
   - Açıklama: IntelliJ IDEA içindeki terminali açar.

Bu kısayollar, IntelliJ IDEA'da hızlı bir şekilde çalışmanızı sağlar ve projelerdeki üretkenliğinizi artırır.


## Spring Boot
```sh 

```
---


JBoss'ın yeni ismi WildFly olarak değiştirildi. Red Hat tarafından geliştirilen JBoss Application Server, 2013 yılında yapılan bir değişiklikle WildFly olarak yeniden adlandırıldı. Bu değişiklikle, JBoss topluluğunun ücretsiz ve açık kaynaklı uygulama sunucusu sürümünü ifade etmek için "WildFly" ismi kullanılırken, ticari sürüm için Red Hat JBoss Enterprise Application Platform (EAP) ismi kullanılmaktadır.

WildFly, Java EE ve Jakarta EE uyumlu, yüksek performanslı bir uygulama sunucusu olarak geliştirilmiş olup, bulut tabanlı mikroservis mimarileriyle uyumludur.

İhtiyacınıza göre en uygun WildFly dağıtımını seçerken dikkate almanız gereken bazı ayrıntılar şunlardır:

1. **WildFly Dağıtımı**:
   - **Kullanım Amacı**: Bu, üretim ve geliştirme ortamlarında kullanılabilen standart WildFly uygulama sunucusudur. Eğer doğrudan WildFly'ın kararlı sürümünü kullanarak bir uygulama dağıtmak ya da geliştirme yapmak istiyorsanız, bu seçenek idealdir.
   - **İndirme Formatları**:
      - **zip**: Windows gibi dosya sıkıştırma araçlarının yaygın olarak desteklediği bir formattır. Özellikle Windows işletim sisteminde WildFly kurulumunu kolaylaştırır.
      - **tgz**: Linux/Unix tabanlı sistemlerde tercih edilen bir sıkıştırma formatıdır. Eğer Linux tabanlı bir sunucuda çalışıyorsanız `tgz` formatını tercih edebilirsiniz.
   - **SHA-1 Karma Değeri**: Dosyanın bütünlüğünü doğrulamak için kullanılabilir. İndirilen dosyanın bozulmamış olduğundan emin olmak için SHA-1 değerini kontrol edebilirsiniz.

2. **WildFly Önizleme Dağıtımı**:
   - **Kullanım Amacı**: Bu, henüz tam kararlı hale getirilmemiş özellikleri içerir. Yeni özellikleri test etmek ya da geliştirme sırasında en son yenilikleri denemek istiyorsanız bu seçeneği indirebilirsiniz. Ancak üretim ortamlarında kullanılması önerilmez, çünkü tam olarak kararlı değildir.
   - **İndirme Formatları**: Yine `zip` ve `tgz` formatlarında sunulmaktadır. Çalıştığınız işletim sistemine göre uygun formatı seçebilirsiniz.
   - **SHA-1 Karma Değeri**: Dosya doğrulaması için sağlanmıştır.

3. **Uygulama Sunucusu Kaynak Kodu**:
   - **Kullanım Amacı**: Eğer WildFly'ın kaynak kodunu incelemek, modifiye etmek ya da WildFly üzerinde özelleştirilmiş geliştirmeler yapmak istiyorsanız bu seçeneği tercih edebilirsiniz. Kaynak kodu, projeye daha derinlemesine bir inceleme yapma imkanı sunar.
   - **İndirme Formatları**: `zip` ve `tgz` olarak sunulur, yukarıda bahsedildiği gibi işletim sistemine göre seçebilirsiniz.
   - **SHA-1 Karma Değeri**: İndirilen dosyanın orijinal olduğundan emin olmak için SHA-1 doğrulaması yapabilirsiniz.

4. **Hızlı Başlangıç Kaynak Kodu**:
   - **Kullanım Amacı**: WildFly üzerinde örnek projeler ya da eğitim materyalleri ile hızlı bir başlangıç yapmak istiyorsanız bu kaynak kodunu indirmeniz faydalı olabilir. Örnek uygulamalar ve kullanım senaryolarını içerir.
   - **Git Tag**: Git üzerinden doğrudan erişim imkanı sunar. Git kullanarak kaynak kodunu daha kolay yönetebilir ve sürüm kontrolü yapabilirsiniz.
   - **zip ve SHA-1**: Zip formatında indirmek ve doğrulamak için seçenekler mevcut.

5. **Sürüm Notları**:
   - **Kullanım Amacı**: WildFly'ın bu sürümünde yapılan değişiklikler, yeni özellikler, düzeltmeler ve bilinen sorunlar hakkında bilgi almak için sürüm notlarını inceleyebilirsiniz. Bu notlar, hangi özelliklerin eklendiği veya değiştiği hakkında detaylı bilgi sağlar.

**Özetle**:
- **Geliştirme veya Üretim İçin**: Standart **WildFly Dağıtımı** önerilir.
- **Yeni Özellikleri Test Etmek İçin**: **WildFly Önizleme Dağıtımı** uygun olabilir.
- **Kaynak Kod İncelemesi veya Özelleştirme İçin**: **Uygulama Sunucusu Kaynak Kodu** tercih edilebilir.
- **Örnek Uygulama ve Hızlı Başlangıç İçin**: **Hızlı Başlangıç Kaynak Kodu** yararlı olabilir.

Sizin gereksinimlerinize göre en uygun seçeneği yukarıdaki açıklamalara göre seçebilirsiniz.


## Spring Boot
```sh 

```
---