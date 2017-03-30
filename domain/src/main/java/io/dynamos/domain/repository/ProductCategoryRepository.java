package com.dynamos.domain.repository;

import com.dynamos.domain.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the ProductCategory entity.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
