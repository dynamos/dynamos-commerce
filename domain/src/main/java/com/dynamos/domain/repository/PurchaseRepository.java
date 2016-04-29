package com.dynamos.domain.repository;

import com.dynamos.domain.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Spring Data JPA repository for the Purchase entity.
 */
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query("select purchase from Purchase purchase where purchase.buyer.login = ?#{principal.username}")
    List<Purchase> findByBuyerIsCurrentUser();

}
