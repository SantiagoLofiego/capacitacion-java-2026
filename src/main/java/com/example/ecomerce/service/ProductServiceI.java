package com.example.ecomerce.service;

import com.example.ecomerce.dto.ProductDto;

import java.util.List;

public interface ProductServiceI {
    public ProductDto getById(Long id);

    public ProductDto create(ProductDto dto);

    public List<ProductDto> obtenerProductos();

}
