package dev.rajen.miniecommerce.services.sortingService;

import dev.rajen.miniecommerce.models.Product;

import java.util.List;

public interface Sorter {
    public List<Product> sort(List<Product> products);
}
