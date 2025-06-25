package dev.rajen.miniecommerce.services.filteringService;

import dev.rajen.miniecommerce.models.Product;

import java.util.List;

public interface Filter {
    List<Product> apply(List<Product> products, List<String> allowedValues);
}
