package com.example.ecomerce.controller;

import com.example.ecomerce.dto.ProductDto;
import com.example.ecomerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/Product")
public class ProductControllerV2 {

    private ProductService productService;

    @Autowired
    public ProductControllerV2(ProductService productService) {
        this.productService = productService;

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Long id, String tipo) {
        ProductDto resultado = productService.getById(id);
        if (resultado == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(resultado);
    }
}
