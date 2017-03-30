package io.dynamos.domain.repository;

import io.dynamos.domain.entity.ItemBasket;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Spring Data JPA repository for the ItemBasket entity.
 */
public interface ItemBasketRepository extends JpaRepository<ItemBasket, Long> {

}
