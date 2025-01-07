package com.hamitmizrak.techcareer_2025_backend_1.controller;

/*
Supplier Nedir?
Supplier<T> arayüzü, Java 8 ile birlikte gelen java.util.function paketinin bir parçasıdır ve parametre almadan bir sonuç üreten fonksiyonel bir arayüzdür. Bu, genellikle bir işlem sonucunda bir nesne veya veri üretilmesi gereken durumlarda kullanılır.

Supplier Temel Özellikleri
Parametresizdir:
Supplier<T> herhangi bir girdi almaz.
Sadece bir çıktı üretir.

Ürettiği Tür:
T tipiyle belirtilen bir nesne veya veri türü döner.

Fonksiyonel Arayüzdür:
Lambda ifadeleri veya metot referanslarıyla kolayca kullanılabilir.

Tek Yöntemi Vardır:
get(): Bir sonuç üretir ve döndürür.


Supplier Kullanımı
Örnek 1: Sabit Bir Değer Döndürmek
Supplier<String> supplier = () -> "Hello, World!";
System.out.println(supplier.get()); // Çıktı: Hello, World!

Örnek 2: Dinamik Bir Değer Döndürmek
Supplier<Double> randomSupplier = () -> Math.random();
System.out.println(randomSupplier.get()); // Çıktı: (0 ile 1 arasında bir rastgele sayı)

Örnek 3: Nesne Döndürmek
Supplier<User> userSupplier = () -> new User("Hamit", "Mızrak");
User user = userSupplier.get();
System.out.println(user.getFirstName()); // Çıktı: Hamit

Sonuç
Supplier<T> arayüzü, işlemlerin soyutlanması ve esnek hale getirilmesi için mükemmel bir araçtır. Örneğinizdeki gibi, bir servisten veri döndüren veya işlem yapan kodları lambda ifadeleri veya metot referansları aracılığıyla Supplier<T> ile yönetebilirsiniz. Bu, kodun daha modüler, test edilebilir ve okunabilir olmasını sağlar.

HTTP Status Code'lar, RESTful API'lerde her bir işlem için standart geri dönüş mesajlarını ifade eder. ResponseEntity kullanırken bu kodları döndürmek, API'nin kullanıcılar ve istemciler için anlaşılır ve standart bir yapıda olmasını sağlar.
*/


import com.hamitmizrak.techcareer_2025_backend_1.error.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import java.util.Date;
import java.util.Map;
import java.util.function.Supplier;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

public class GHandleApiresult {

    // Injection
    private static final MessageSource messageSource = null;
    private  ApiResult apiResult;
    private static String message; // Message

    // Generic ResponseEntity ApiResult
    //public static final  <T> ResponseEntity<?> genericsHandleApiResult(){
    public static final  <T> ResponseEntity<ApiResult> genericsHandleApiResult(
            String path,
            int tryStatusCode,
            int catchStatusCode,
            Supplier<T>  supplier // Lambda Expression'ı kullanmak için
    ){
        // İşlem gerçekleştirecek lamba ifades
        T data= supplier.get();

        try{
            // MESSAGE
            //message= messageSource.getMessage("generics.api.try.status.code",null, LocaleContextHolder.getLocale());



            // Başarılıysa ApiResult Nesnesini oluştur
            ApiResult apiResult =  ApiResult.builder()
                    .status(tryStatusCode)
                    .message("message")
                    .path(path)
                    .validationErrors(Map.of("data",data))
                    .createdDate(new Date(System.currentTimeMillis()))
                    .build();
            // return new ResponseEntity<>(addressDtoApiCreate,HttpStatus.CREATED);
            // return ResponseEntity.status(201).body(addressDtoApiCreate);
            // return ResponseEntity.status(HttpStatus.CREATED).body(addressDtoApiCreate);
            // return ResponseEntity.ok(iAddressService.).body(addressDtoApiCreate);
            // return ResponseEntity.ok(addressDtoApiCreate);
            return ResponseEntity.status(tryStatusCode).body(apiResult);
        }catch (Exception e){
            // MESSAGE
            //message= messageSource.getMessage("generics.api.catch.status.code",null, LocaleContextHolder.getLocale());

            // Başarısızsa ApiResult Nesnesini oluştur
           ApiResult apiResult= ApiResult.builder()
                    .status(catchStatusCode)
                    .message("message")
                    .path(path)
                   .validationErrors(Map.of("data",data))
                    .createdDate(new Date(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.status(catchStatusCode).body(apiResult);
        } //end catch
    } // end method(genericsHandleApiResult)
} //end class


/*
Status Code
CREATE	201 Created	Yeni kaynak başarıyla oluşturuldu.

LIST	200 OK	Kaynaklar başarıyla listelendi.

UPDATE	200 OK	Güncellenen kaynak döndürüldü.
        204 No Content	Güncelleme başarılı, ancak yanıt yok.

DELETE	204 No Content	Başarıyla silindi, ancak yanıt yok.
        200 OK	Silme işlemi başarılı, bilgi döndürüldü.
 */
// Status coded
enum EMyspecialStatusCode{
    OK(200,"Ok"),CREATED(201,"Created"),NOCONTENT(204,"No Content");

    // Field
    private final int key;
    private final String value;

    // Constuctor
   private EMyspecialStatusCode(int key, String value) {
        this.key = key;
        this.value = value;
    }

    // Getter And Setter
    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}