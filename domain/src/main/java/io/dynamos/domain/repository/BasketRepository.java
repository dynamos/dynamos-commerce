package com.dynamos.domain.repository;

import com.dynamos.domain.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Spring Data JPA repository for the Basket entity.
 */
public interface BasketRepository extends JpaRepository<Basket, Long> {

}
