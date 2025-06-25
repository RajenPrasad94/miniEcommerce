package dev.rajen.miniecommerce.services;

import dev.rajen.miniecommerce.dtos.search.FilterDto;
import dev.rajen.miniecommerce.dtos.search.SortingCriteria;
import dev.rajen.miniecommerce.models.Product;
import dev.rajen.miniecommerce.repositories.ProductRepository;
import dev.rajen.miniecommerce.services.filteringService.FilterFactory;
import dev.rajen.miniecommerce.services.sortingService.SorterFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private final ProductRepository productRepository;
    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> search(String query, List<FilterDto> filters, SortingCriteria sortingCriteria, int page, int size) {
       List<Product> products = productRepository.findByTitleContaining(query);
        if (filters != null && !filters.isEmpty()) {
            for (FilterDto filter : filters) {
                products = FilterFactory.getFilterFromKey(filter.getKey())
                        .apply(products, filter.getValues());
            }
        }
        products = SorterFactory.getSorterByCriteria(sortingCriteria).sort(products);
        List<Product> productOnPage = new ArrayList<>();
        for(int i = size * (page-1); i <= (page*size)-1; i++) {
            productOnPage.add(products.get(i));
        }
        Pageable pageable = PageRequest.of(page, size);
        return new PageImpl<>(productOnPage, pageable, products.size());
    }
}
