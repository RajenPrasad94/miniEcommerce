package dev.rajen.miniecommerce.services;

import dev.rajen.miniecommerce.dtos.ProductDto;
import dev.rajen.miniecommerce.models.Category;
import dev.rajen.miniecommerce.models.Price;
import dev.rajen.miniecommerce.models.Product;
import dev.rajen.miniecommerce.repositories.CategoryRepository;
import dev.rajen.miniecommerce.repositories.PriceRepository;
import dev.rajen.miniecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImp implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private PriceRepository priceRepository;
    public ProductServiceImp(ProductRepository productRepository, CategoryRepository categoryRepository, PriceRepository priceRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
    }
    @Override
    public boolean addProduct(ProductDto productDto) {
        Product product = new Product();
        Category category = new Category();
        category.setName(productDto.getCategoryName());
        //categoryRepository.save(category);
        Price price = new Price();
        price.setCurrency(productDto.getCurrency());
        price.setPrice(productDto.getPrice());
        //priceRepository.save(price);
        product.setCategory(category);
        product.setPrice(price);
        product.setDescription(productDto.getDescription());
        product.setTitle(productDto.getTitle());
        product.setImage(productDto.getImage());
        productRepository.save(product);
        productRepository.deleteById(UUID.fromString("bc6e0c07-c257-43c1-8639-eb753e7ffef6"));
        return true;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductDto> list = new ArrayList<>();
        productRepository.findAll().forEach(prod ->{
            ProductDto productDto = new ProductDto();
            productDto.setCategoryName(prod.getCategory().getName());
            productDto.setDescription(prod.getDescription());
            productDto.setTitle(prod.getTitle());
            productDto.setPrice(prod.getPrice().getPrice());
            productDto.setImage(prod.getImage());
            productDto.setCurrency(prod.getPrice().getCurrency());
            list.add(productDto);
        });
        return list;
    }
}
