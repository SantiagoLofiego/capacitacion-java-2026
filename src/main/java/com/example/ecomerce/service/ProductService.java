package com.example.ecomerce.service;

import com.example.ecomerce.dto.ProductDto;
import com.example.ecomerce.exception.ProductIdNullException;
import com.example.ecomerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> productos=new ArrayList<>();

    private Long id = 0L;

    public List<ProductDto> obtenerProductos() {
        List<ProductDto> lista = new ArrayList<>();
        productos.forEach(product -> {
            lista.add(getProductoDto(product));
        });

        return lista;
    }

    public ProductDto getById(Long id) {
        if(id==null){
            //throw new ProductIdNullException("el id no puede ser null");
        }
        System.out.println("Sigue el flujo de ejecucion");
        for (Product p : productos) {
            if (p.getId().equals(id)) {
                return getProductoDto(p);
            }
        }
        return null;
    }

    public ProductDto create(ProductDto dto) {
        Product product = new Product();
        product.setId(id);
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setStock(dto.stock());
        productos.add(product);
        id++;
        return getProductoDto(product);
    }

    private ProductDto getProductoDto(Product producto) {
        return new ProductDto(producto.getId(), producto.getName(), producto.getDescription(), producto.getPrice(), producto.getStock());
    }
}
