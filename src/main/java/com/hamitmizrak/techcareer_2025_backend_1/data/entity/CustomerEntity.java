package com.hamitmizrak.techcareer_2025_backend_1.data.entity;


import jakarta.persistence.*;
import lombok.*;

// LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

// @NamedQuery anotasyonu ile tanımlanan statik sorgulardır.
@NamedQueries({
        @NamedQuery(name = "CustomerEntity.findAllCustomers", query = "SELECT c FROM Customers c"),
        @NamedQuery(name = "CustomerEntity.findByLastname", query = "SELECT c FROM Customers c WHERE c.lastname = :lastname"),
        @NamedQuery(name = "CustomerEntity.findWithNotes", query = "SELECT c FROM Customers c WHERE c.notes LIKE :notes")
})

// ENTITY
@Entity(name = "Customers") // name="Customers" => Relation için name yazdım
@Table(
        name = "customers" // name="customers" => Database tablo adı için ekledim
        /*
        ,
        schema = "public", // Postgresql vb yapılarında şema yapısını destekleten veri tablarında tabloya erişim için kullanılır.
        catalog = "blog", //  Mysql vb gibi veritabanlarında kullanırız.
        indexes = {  // Sık sorgulanan sutunlarda indeksleme yaparak veritabanı sorgu performansını artırır.
                @Index(name = "idx_lastname", columnList = "city", unique = false),
                @Index(name = "idx_lastname", columnList = "state", unique = false), //default:false ancak true yaparsak: Indeksin benzersiz olmasını sağlar
        },
        uniqueConstraints = { //
                @UniqueConstraint(columnNames = {"lastname"}) //=> benzersiz sutun verisi için
        }
        */
)

// CustomerEntity(1) - AddressEntity(1) -
public class CustomerEntity extends BaseEntity {

    // FIELD
    // FIELD
    // FIRSTNAME
    private String fistname;

    // LASTNAME
    private String lastname;

    // NOTES
    private String notes;

    // Optimitistik Kilitlenme (Optimistic Locking)
    // Entity'timizin versiyonlararak saklanması
    /*
     Transaction çok uzun süre zarfında açık kalmışsa bu noktada, Version ile çözmeyere çalışırız.
     Optimistic Locking: Veri tabanında kaydın güncellenmesi sırasında veri tutarlılığını sağlamak istiyorsak
     buradan @Version kullanırız. Eğer bu kayıdın işlem başlandı ve eşlenme devam etmiyorsa güncelleme reddecek ve bir hata
     fırlatacak: OptimistikcLockException

     Çözüm olarak: Optimistic Locking kullanarak temel mekanizmamızda Entity üzerinde yazdığımız @Version alanında tanımlananan,
     güncelleme işlemlerinde her zaman değeri otomatik artırım sağlarak çözümlenir.

     Select * From Customers Where id=1;
     update Customers SET lastname="Mızrak", version=version+1 where id=1 AND version =1;
    */
    @Version
    private int version;

    ////////////////////////////////////////////////////////////////////////////
    // RELATION
    // COMPOSITION

    // Customer(1) - Address(1)
    // NOT: Adres bilgilerini Customer üzerinden sağlayacağım.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id", referencedColumnName = "id",unique = true) // Burası FK
    private AddressEntity addressCustomerEntity;

    // Customer(1) - Order(1)
} // end CustomerEntity
