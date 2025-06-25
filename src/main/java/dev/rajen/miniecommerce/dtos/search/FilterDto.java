package dev.rajen.miniecommerce.dtos.search;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonSerialize
public class FilterDto {
    private String key;
    private List<String> values;
}
