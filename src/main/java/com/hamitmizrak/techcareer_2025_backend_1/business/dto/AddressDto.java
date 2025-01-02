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
// @NotEmpty : Diziler, Koleksiyonlar, String yapıların boş olup olmadığını doğrulamak için kullanıyoruz
// @NotBlank : Sadece String yapıların boş olup olmadığını doğrulamak için kullanıyoruz

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
