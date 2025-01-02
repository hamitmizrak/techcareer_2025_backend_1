package com.hamitmizrak.techcareer_2025_backend_1.business.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

// LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


// Validation: jakarta.validation.constraints.NotEmpty;

// @NotNull, @NotBlank, @NotEmpty(Genellikle bunu kullanırız çünkü en geniş özellikli)
/*
Spring Boot'ta kullanılan kullanılan @NotEmpty, @NotBlank, @NotNull anatasyonları Bean validation bir koludur.
Giriş verilerini doğrulamak için Validation(Doğrulama) kullanırız.

UNUTMA: Boşluk bir karaktertir null ile karıştırmayınız.
UNUTMA: Primitive türlerde null kullanılmaz. (e.g) byte,short,int,long, boolean, char, float,double
UNUTMA: Wrapper türlerde null kullanabilirsiniz. (e.g) Byte,Short,Integer,Long, Boolean, Character, Float,Double


1-) @NotNull  : Sadece Null olup olmaması
Bir input'ta null olup olmadığını kontrol etmek için kullanılır.
Eğer null ise hata verir.
Sadece Wrapper type için kullanılır ve primitive türlerde kullanamayız.

@NotNull
private String name;
name =null ise çalışır.

2-) @NotBlank : Hem Null olup olmaması hemde boşluk için kontrol sağlar
Sadece String yapıların boş olup olmadığını doğrulamak için kullanıyoruz.
private String name;
name =null, name="", name ise çalışır.

3-) @NotEmpty : Hem Null olup olmaması hemde boşluk için kontrol sağlar
Diziler, Koleksiyonlar, String yapıların boş olup olmadığını doğrulamak için kullanıyoruz

private String name;
name =null, name="", name ise çalışır.

 */


// AddressDto(1) - CustomerDto(1)
public class AddressDto extends BaseDto{

    @NotEmpty(message = "{address.description.validation.constraints.NotNull.message}")
    @Size(min = 5, message = "{address.description.least.validation.constraints.NotNull.message}")
    private String description;

    // DOOR NUMBER
    @NotEmpty(message = "{address.door_number.validation.constraints.NotNull.message}")
    private String doorNumber;

    // ZIP CODE
    @NotEmpty(message = "{address.zip_code.validation.constraints.NotNull.message}")
    private String zipCode;

    // STREET
    @NotEmpty(message = "{address.street.validation.constraints.NotNull.message}")
    private String street;

    // AVENUE
    @NotEmpty(message = "{address.avenue.validation.constraints.NotNull.message}")
    private String avenue;

    // CITY
    @NotEmpty(message = "{address.city.validation.constraints.NotNull.message}")
    private String city;

    // STATE
    @NotEmpty(message = "{address.state.validation.constraints.NotNull.message}")
    private String state;

    // COUNTRY
    @NotEmpty(message = "{address.country.validation.constraints.NotNull.message}")
    private String country;

    // ADDRESS QR CODE
    @NotEmpty(message = "{address.qr_code.validation.constraints.NotNull.message}")
    private String addressQrCode;
}
