package dev.rajen.miniecommerce.services;

import dev.rajen.miniecommerce.dtos.ProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    boolean addProduct(ProductDto product);
    List<ProductDto> getAllProducts();
}
