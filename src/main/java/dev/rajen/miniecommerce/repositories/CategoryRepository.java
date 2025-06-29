package dev.rajen.miniecommerce.repositories;

import dev.rajen.miniecommerce.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    @Override
    <S extends Category> S save(S entity);
}
