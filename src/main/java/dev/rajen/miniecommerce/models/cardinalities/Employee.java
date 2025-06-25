package dev.rajen.productservice.models.cardinalities;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Employee {
    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String address;
}

