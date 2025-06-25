package dev.rajen.miniecommerce.dtos;


import dev.rajen.miniecommerce.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class ProductDto {
    private UUID id;
    private String title;
    private String description;
    private String image;
    private String categoryName;
    private double price;
    private String currency;

    public static ProductDto from(Product product) {
        ProductDto productResponseDto = new ProductDto();
        productResponseDto.setId(product.getUuid());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setImage(product.getImage());
        productResponseDto.setPrice(product.getPrice().getPrice());
        productResponseDto.setTitle(product.getTitle());

        return productResponseDto;
    }
}
