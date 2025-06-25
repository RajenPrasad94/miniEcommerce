package dev.rajen.miniecommerce.models.cardinalities;

import jakarta.persistence.Entity;

@Entity
public class ProgramManager extends PermanentEmployee{
    private Long featuresCompleted;
}
