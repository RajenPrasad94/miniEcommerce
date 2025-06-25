package dev.rajen.miniecommerce.controllers;

import dev.rajen.miniecommerce.dtos.ProductDto;
import dev.rajen.miniecommerce.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    public boolean createProduct(@RequestBody ProductDto dto){
        return productService.addProduct(dto);
    }
    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getAllProducts();
    }
}
