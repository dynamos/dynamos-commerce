package com.dynamos.domain.repository;

import com.dynamos.domain.entity.ItemPurchase;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Spring Data JPA repository for the ItemPurchase entity.
 */
public interface ItemPurchaseRepository extends JpaRepository<ItemPurchase, Long> {

}
