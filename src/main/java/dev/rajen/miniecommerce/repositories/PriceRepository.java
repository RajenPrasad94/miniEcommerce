package dev.rajen.miniecommerce.repositories;

import dev.rajen.miniecommerce.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PriceRepository extends JpaRepository<Price, UUID> {
    @Override
    <S extends Price> S save(S entity);
}
