package io.dynamos.domain.repository;

import io.dynamos.domain.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the ProductCategory entity.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
