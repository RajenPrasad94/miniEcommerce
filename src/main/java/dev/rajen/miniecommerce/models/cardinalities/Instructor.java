package dev.rajen.productservice.models.cardinalities;

import jakarta.persistence.Entity;

@Entity
public class Instructor extends ContractualEmployee {
    private String company;
}
