package io.dynamos.domain.repository;

import io.dynamos.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Spring Data JPA repository for the product entity.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
