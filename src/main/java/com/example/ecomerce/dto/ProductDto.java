package com.example.ecomerce.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductDto(
        Long id,
        @NotBlank(message = "el nombre no puede estar vacio")
        String name,
        @NotBlank
        @Size(min=3, max= 10000000)
        String description,
        BigDecimal price,
        Integer stock) {
}
