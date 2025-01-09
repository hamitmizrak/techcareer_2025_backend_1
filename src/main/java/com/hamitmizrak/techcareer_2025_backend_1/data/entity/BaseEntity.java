package com.hamitmizrak.techcareer_2025_backend_1.data.entity;

import com.hamitmizrak.techcareer_2025_backend_1.audit.AuditingAwareBaseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

// LOMBOK
@Getter
@Setter

// Üst atadan gelen verilerdir.
@MappedSuperclass

// abstract: BaseEntity instance(örnek) yapılmasını istemiyorum.
abstract public class BaseEntity extends AuditingAwareBaseDto implements Serializable {

    // SERILESTIRME
    public static final Long serialVersionUID = 1L;

    // FIELD
    // IDENTITY: Mysql, H2DB
    // AUTO: Postgresql
    // SEQUENCE: OracleDB
    // ID  => 1.YOL
    /*
    GeneratedValue => Birincil Anahtar(PK) nasıl üretileceğini belirtmek için kullanırız.
    GeneratedValue:
    AUTO: Varsayılan Stratejidir. Örnek: Postgresql
    IDENTITY: Veritabanlarında otomatik artırım (AI) içindir.  Örnek: Mysql, H2DB
    SEQUNCE: Sıra kullanmak. Örnek: Oracle, Mysql, Postgresql
    TABLE: Tablo kullanmak içindir
     */

    // 1.YOL
    // Neden Sequence kullanıyoruz ?
    /*
    Performans: Diziler diğer yöntemler olan IDENTITY, AUTO vb yapılara göre daha performansı
    Taşınabilirlik: JPA'in birden fazla Mysql, Postgresql, Oracle, MariaDB, H2DB vb
    Kontrol: allocationSize başlangıç değer artışını kontrol edebilmek

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customize_seq") // SEQUENCE: Oracle Db
    @SequenceGenerator(name="customize_seq", sequenceName = "customize_sequence", allocationSize = 1) // SEQUENCE: Oracle Db
    protected Long id;*/

    // 2.YOL
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY: Mysql, H2DB
    // @GeneratedValue(strategy = GenerationType.AUTO)  // AUTO: Postgresql
    @Column(name = "id", insertable = true, updatable = false, unique = true)
    protected Long id;


    // SYSTEM DATE
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            name = "system_created_date",
            insertable = true,
            updatable = false,
            nullable = false,
            //unique = true,
            length = 255,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected Date systemCreatedDate;

    // @PrePersist: Entity içinde veritabanında ilk kez kaydedilemden daha öncesinden çağrılan JPA yaşam döngüsüsü olayını temsil edecektir.
    // Amaç: Varsayılan değerler vermek
    // Kullanımı: void türünden olmalıdır.
    // Access Modifier: private, protected, public. kullanabilirsiniz.
    @PrePersist
    private void prePersist() {
        // Varsayılan değerler atanması
        if (this.systemCreatedDate == null) {
            this.systemCreatedDate = new Date(System.currentTimeMillis());
            //this.systemCreatedDate= LocalDateTime.now();
        }
    }

} //end BaseDto
