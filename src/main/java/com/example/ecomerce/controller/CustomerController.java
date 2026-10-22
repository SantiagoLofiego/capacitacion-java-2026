package com.example.ecomerce.controller;

import com.example.ecomerce.dto.CustomerRequestDto;
import com.example.ecomerce.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping()
    public ResponseEntity<String> createCustomer(@Valid @RequestBody CustomerRequestDto customer) {

        customerService.createCustomer(customer);

        return ResponseEntity.ok("Customer creado con exito");
    }
}
