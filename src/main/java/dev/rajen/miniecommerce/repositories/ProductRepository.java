package dev.rajen.miniecommerce.repositories;

import dev.rajen.miniecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface  ProductRepository extends JpaRepository<Product, UUID> {
    @Override
    <S extends Product> S save(S entity);

    @Override
    List<Product> findAll();

    void deleteById(UUID uuid);
    List<Product> findByTitleContaining(String title);
}
