package com.hamitmizrak.techcareer_2025_backend_1.data.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

// LOMBOK
@Getter
@Setter
@AllArgsConstructor
@Builder

@Embeddable
public class AddressEntityDetailsEmbeddable {

    // NOT: eğer field'lar camelCase değilse @Column(name) yazmanıza gerek yoktur.

    // DOOR NUMBER
    @Column(name = "door_number")
    private String doorNumber;

    // ZIP CODE
    @Column(name = "zip_code")
    private String zipCode;

    // STREET
    // columnDefinition => Varsayılan özelliktir.
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'cadde yazılmadı'")
    private String street;

    // AVENUE
    private String avenue="Bulvar girilmedi";

    // DESCRIPTION
    // Lombok kütüphanesinden default değer kullanmak
    @Builder.Default
    private String description="tanımlama girilmedi";

    // @PrePersist : Dinamik varsayılan değerler için kullanılır.
    // Amaç: Verinin null olup olmadığını kontrol etmek içindir.
    // CITY
    private String city;

    // STATE
    // Eğer Spring Framework kullanıyorsak varsayılan olarak @Value kullanabiliriz.
    @Value("${default.state:Default state}")
    private String state;

    // COUNTRY
    private String country;

    // ADDRESS QR CODE
    @Column(name = "address_qr_code")
    private String addressQrCode;

    // Constructor
    public AddressEntityDetailsEmbeddable() {
        this.city="şehir girilmedi";
    }

} //end AddressEntityDetailsEmbeddable
