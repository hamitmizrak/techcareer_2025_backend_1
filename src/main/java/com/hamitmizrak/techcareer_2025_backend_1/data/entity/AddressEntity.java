package com.hamitmizrak.techcareer_2025_backend_1.data.entity;

import com.hamitmizrak.techcareer_2025_backend_1.data.embedded.AddressEntityDetailsEmbeddable;
import jakarta.persistence.*;
import lombok.*;

// LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Data
//@ToString
//@EqualsAndHashCode


// ENTITY
@Entity(name = "Addresses") // name="Addresses" => Relation için name yazdım
@Table(
        name = "addresses" // name="addresses" => Database tablo adı için ekledim
        /*
        ,
        schema = "public", // Postgresql vb yapılarında şema yapısını destekleten veri tablarında tabloya erişim için kullanılır.
        catalog = "blog", //  Mysql vb gibi veritabanlarında kullanırız.
        indexes = {  // Sık sorgulanan sutunlarda indeksleme yaparak veritabanı sorgu performansını artırır.
                @Index(name = "idx_address_city", columnList = "city", unique = false),
                @Index(name = "idx_address_state", columnList = "state", unique = false), //default:false ancak true yaparsak: Indeksin benzersiz olmasını sağlar
        },
        uniqueConstraints = { //
                @UniqueConstraint(columnNames = {"address_qr_code"}) //=> benzersiz sutun verisi için
        }
        */
)

// AddressEntity(1) - CustomerEntity(1)
public class AddressEntity extends BaseEntity {

    // FIELD

    // Dikkat: IRepository Delivered Query için `detailsEmbeddable.address` şeklinde yazalır.
    @Embedded
    private AddressEntityDetailsEmbeddable detailsEmbeddable;

    // Soft Delete (Yumuşak Silme)
    // Verileri silmek database çok doğru bir davranış değildir.
    // Bunun yerine kullanıcıya silindiği gösterip database
    @Builder.Default
    private Boolean isDeleted = false;

    // Database tablosundaki sutunlarda olmasın ancak Java Class'larında olsun
    @Transient
    private String temporaryData;

    // Optimitistik Kilitlenme (Optimistic Locking)
    // Entity'timizin versiyonlararak saklanması
    /*
     Transaction çok uzun süre zarfında açık kalmışsa bu noktada, Version ile çözmeyere çalışırız.
     Optimistic Locking: Veri tabanında kaydın güncellenmesi sırasında veri tutarlılığını sağlamak istiyorsak
     buradan @Version kullanırız. Eğer bu kayıdın işlem başlandı ve eşlenme devam etmiyorsa güncelleme reddecek ve bir hata
     fırlatacak: OptimistikcLockException

     Çözüm olarak: Optimistic Locking kullanarak temel mekanizmamızda Entity üzerinde yazdığımız @Version alanında tanımlananan,
     güncelleme işlemlerinde her zaman değeri otomatik artırım sağlarak çözümlenir.

     Select * From Addresses Where id=1;
     update Addresses SET city="Malatya", version=version+1 where id=1 AND version =1;
    */
    @Version
    private int version;
}
