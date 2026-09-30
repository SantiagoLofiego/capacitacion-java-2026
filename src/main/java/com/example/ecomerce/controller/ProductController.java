package com.example.ecomerce.controller;

import com.example.ecomerce.dto.ProductDto;
import com.example.ecomerce.exception.ProductIdNullException;
import com.example.ecomerce.service.DtoValidator;
import com.example.ecomerce.service.ProductService;
import com.example.ecomerce.service.ProductServiceI;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductServiceI productService;

    @Autowired
    public ProductController(ProductServiceI productService) {
        this.productService = productService;

    }


    // http://localhost:8080/api/products/5
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        ProductDto resultado= null;
        try {
            resultado = productService.getById(id);
        }catch(NullPointerException e){
            return new ResponseEntity<>("Capture NullPointerException",HttpStatus.OK);
        }catch(ProductIdNullException e){
            return new ResponseEntity<>("Capture Service exception",HttpStatus.OK);
         //System.out.println("Sigue el flujo de ejecucion");
        }catch (Exception e){
            return new ResponseEntity<>("Capture Exception",HttpStatus.OK);
        }finally {
            System.out.println("ESTA LINEA SE EJECUTA SIEMPRE");
        }
        if (resultado == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(resultado);
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(
            @Valid
            @RequestBody
            ProductDto dto
    ) {
        ProductDto body = productService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> responseBody = productService.obtenerProductos();
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }


}
