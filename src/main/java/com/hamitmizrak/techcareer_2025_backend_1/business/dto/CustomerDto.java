package com.hamitmizrak.techcareer_2025_backend_1.business.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;


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

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

// LOMBOK
// LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

// Customer(1)- Address(1)
// Customer(1) - Order(N)
public class CustomerDto extends BaseDto {

    // FIRSTNAME
    @NotEmpty(message = "{customer.firstname.validation.constraints.NotNull.message}")
    private String fistname;

    // LASTNAME
    @NotEmpty(message = "{customer.lastname.validation.constraints.NotNull.message}")
    private String lastname;

    // NOTES
    @NotEmpty(message = "{customer.notes.validation.constraints.NotNull.message}")
    private String notes;

    ////////////////////////////////////////////////////////////////////////////
    // RELATION
    // COMPOSITION
    // Customer(1) - Adress(1) NOT: Adres bilgilerine Customer üzerinden erişim sağlayacağım.
    private AddressDto compositionAddressDto;

    // Customer(1) - Order(N)
} //end AddressDto
