package dev.rajen.miniecommerce.dtos.search;

import dev.rajen.miniecommerce.dtos.ProductDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class SearchReponseDto {
    private Page<ProductDto> productsPage;
}
