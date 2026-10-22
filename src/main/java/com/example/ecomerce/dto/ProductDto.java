package com.example.ecomerce.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductDto(
        @JsonIgnore()
        @NotBlank
        Long id,
        @NotBlank(message = "el nombre no puede estar vacio")
        String name,
        @NotBlank
        @Size(min=3, max= 10000000)
        String description,
        BigDecimal price,
        Integer stock) {
}
