package com.hamitmizrak.techcareer_2025_backend_1.business.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

// LOMBOK
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

//  Order(N) - Customer(1)
//  Order(N) - Product(M)
public class OrderDto extends BaseDto {

    // NAME
    @NotEmpty(message = "{order.name.validation.constraints.NotNull.message}")
    private String name;

    // PRICE
    @NotEmpty(message = "{order.code.validation.constraints.NotNull.message}")
    private String price;

    // NOTES
    @NotEmpty(message = "{order.notes.validation.constraints.NotNull.message}")
    private String notes;

    ////////////////////////////////////////////////////////////////////////////
    // RELATION
    // COMPOSITION

    // Order(N) - Customer(1)
    private CustomerDto compositionCustomerDto;

    // Order(N) - Product(M)
    private List<ProductDto> compositionProductDtoList;

} // end CustomerDto




