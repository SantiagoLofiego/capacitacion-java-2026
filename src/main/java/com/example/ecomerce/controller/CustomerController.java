package com.example.ecomerce.controller;

import com.example.ecomerce.dto.CustomerRequestDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {


    @PostMapping()
    public ResponseEntity<String> getById(@Valid @RequestBody CustomerRequestDto customer) {

        //ProductDto resultado = productService.getById(id);

        return ResponseEntity.ok("Customer creado con exito");
    }
}
