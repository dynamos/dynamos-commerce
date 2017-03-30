package io.dynamos.domain.repository;

import io.dynamos.domain.entity.ItemPurchase;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Spring Data JPA repository for the ItemPurchase entity.
 */
public interface ItemPurchaseRepository extends JpaRepository<ItemPurchase, Long> {

}
