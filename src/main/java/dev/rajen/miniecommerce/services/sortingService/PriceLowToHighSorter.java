package dev.rajen.miniecommerce.services.sortingService;

import dev.rajen.miniecommerce.models.Product;

import java.util.List;

public class PriceLowToHighSorter implements Sorter {

    @Override
    public List<Product> sort(List<Product> products) {
        products.sort((p1, p2) -> {
            if (p1.getPrice() == null || p2.getPrice() == null) {
                return 0; // Handle null prices gracefully
            }
            else if(p1.getPrice().getPrice() > p2.getPrice().getPrice()) {
                return 1;
            }
            else{
                return -1;
            }
        });
        return products;
    }
}
