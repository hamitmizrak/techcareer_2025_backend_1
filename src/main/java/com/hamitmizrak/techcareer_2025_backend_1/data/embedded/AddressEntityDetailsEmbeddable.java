package com.hamitmizrak.techcareer_2025_backend_1.data.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

// LOMBOK
@Getter
@Setter

@Embeddable
public class AddressEntityDetailsEmbeddable {

    // NOT: eğer field'lar camelCase değilse @Column(name) yazmanıza gerek yoktur.

    // DESCRIPTION
    private String description;

    // DOOR NUMBER
    @Column(name = "door_number")
    private String doorNumber;

    // ZIP CODE
    @Column(name = "zip_code")
    private String zipCode;

    // STREET
    private String street;

    // AVENUE
    private String avenue;

    // CITY
    private String city;

    // STATE
    private String state;

    // COUNTRY
    private String country;

    // ADDRESS QR CODE
    @Column(name = "address_qr_code")
    private String addressQrCode;

} //end AddressEntityDetailsEmbeddable
