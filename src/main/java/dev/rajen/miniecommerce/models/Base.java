package dev.rajen.miniecommerce.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class Base {
   @Id
   @GeneratedValue(generator = "naman")
   @GenericGenerator(name = "naman", strategy = "uuid2")
   @Column(name = "id", columnDefinition = "binary(16)", nullable = false, updatable = false)
   private UUID uuid;
}
