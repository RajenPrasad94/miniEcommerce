package dev.rajen.miniecommerce.models.cardinalities;

import jakarta.persistence.Entity;

@Entity
public class Ta extends ContractualEmployee{
    private Long numberOfHelpRequests;
}
