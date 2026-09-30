package com.example.ecomerce.service;

import com.example.ecomerce.dto.ProductDto;
import org.springframework.stereotype.Service;

@Service
public class DtoValidator {

    public boolean validateProductDto(ProductDto productDto){
        if(productDto.name() == null){
            return false;
        }
        return true;
    }
}
