package dev.rajen.productservice.models.cardinalities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ContractualEmployee extends Employee{
    @Id
    private String alias;

    private  Double hourlyRenumeration;
}