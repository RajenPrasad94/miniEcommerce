package dev.rajen.miniecommerce.models.cardinalities;

import jakarta.persistence.Entity;

@Entity
public class SoftwareDeveloper extends PermanentEmployee{
    private Long leavesTaken;
}