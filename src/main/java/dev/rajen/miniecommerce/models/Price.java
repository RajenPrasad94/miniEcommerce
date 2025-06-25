package dev.rajen.miniecommerce.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Price extends Base{
   private double price;
   private String currency;
}
