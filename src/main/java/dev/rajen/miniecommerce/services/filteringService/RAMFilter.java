package dev.rajen.miniecommerce.services.filteringService;

import dev.rajen.miniecommerce.models.Product;

import java.util.ArrayList;
import java.util.List;

public class RAMFilter implements Filter {

    @Override
    public List<Product> apply(List<Product> products, List<String> allowedValues) {

        List<Product> ans = new ArrayList<>();
        for(String allowedValue : allowedValues) {

           for (Product product: products) {
               if (product.getDescription().contains(allowedValue)) {
                   ans.add(product);
               }
           }
       }
        return ans;
    }
}
