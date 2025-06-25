package dev.rajen.miniecommerce.controllers;

import dev.rajen.miniecommerce.dtos.ProductDto;
import dev.rajen.miniecommerce.dtos.search.FilterDto;
import dev.rajen.miniecommerce.dtos.search.SearchReponseDto;
import dev.rajen.miniecommerce.dtos.search.SortingCriteria;
import dev.rajen.miniecommerce.models.Product;
import dev.rajen.miniecommerce.services.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/search")
public class SearchController {
    private SearchService searchService;
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }
    @GetMapping("/")
    public SearchReponseDto search(@RequestParam("query") String query,
                                   @RequestParam("filters") List<FilterDto> filters,
                                   @RequestParam("sortBy")SortingCriteria sortingCriteria,
                                   @RequestParam("page") int page,
                                   @RequestParam("size") int size) {
        SearchReponseDto response = new SearchReponseDto();
        Page<Product> productsPage = searchService.search(query, filters, sortingCriteria, page, size);
        List<ProductDto> productDtos = productsPage.getContent().stream()
                .map(ProductDto::from)
                .collect(Collectors.toList());

        Pageable pageable = PageRequest.of(productsPage.getNumber(), productsPage.getSize(), productsPage.getSort());
        Page<ProductDto> productDtoPage = new PageImpl<>(productDtos, pageable, productsPage.getTotalElements());

        response.setProductsPage(productDtoPage);

        return response;
    }

    @GetMapping("/byCategory")
    public SearchReponseDto simpleSearch(@RequestParam("query") String query,
                                          @RequestParam("category") Long categoryId,
                                          @RequestParam("pageNumber") int pageNumber,
                                          @RequestParam("pageSize") int pageSize,
                                          @RequestParam("sortingAttribute") String sortingAttribute
    ) {
        return null;
    }
}
