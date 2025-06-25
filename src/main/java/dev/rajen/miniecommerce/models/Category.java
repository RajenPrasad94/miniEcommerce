package dev.rajen.miniecommerce.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends Base{
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
