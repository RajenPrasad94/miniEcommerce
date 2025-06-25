package dev.rajen.productservice.models.cardinalities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class PermanentEmployee extends Employee{
    @Id
    private String email;
    private Double costToCompany;
}
