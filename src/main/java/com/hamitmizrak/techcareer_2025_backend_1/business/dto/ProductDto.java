package com.hamitmizrak.techcareer_2025_backend_1.business.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

// LOMBOK
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

//  Product(M)- Order(N)
public class ProductDto extends BaseDto {

    // NAME
    @NotEmpty(message = "{product.name.validation.constraints.NotNull.message}")
    private String name;

    // TRADE
    @NotEmpty(message = "{product.price.validation.constraints.NotNull.message}")
    private String trade;

    // NOTES
    @NotEmpty(message = "{product.notes.validation.constraints.NotNull.message}")
    private String notes;

    ////////////////////////////////////////////////////////////////////////////
    // RELATION
    // COMPOSITION

} // end CustomerDto

