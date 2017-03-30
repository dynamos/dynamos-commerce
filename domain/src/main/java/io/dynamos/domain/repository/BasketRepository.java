package io.dynamos.domain.repository;

import io.dynamos.domain.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Spring Data JPA repository for the Basket entity.
 */
public interface BasketRepository extends JpaRepository<Basket, Long> {

}
