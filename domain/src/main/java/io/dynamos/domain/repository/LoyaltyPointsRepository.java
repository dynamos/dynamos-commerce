package io.dynamos.domain.repository;

import io.dynamos.domain.entity.LoyaltyPoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Spring Data JPA repository for the LoyaltyPoints entity.
 */
public interface LoyaltyPointsRepository extends JpaRepository<LoyaltyPoints, Long> {

    @Query("select loyaltyPoints from LoyaltyPoints loyaltyPoints where loyaltyPoints.customer.login = ?#{principal.username}")
    List<LoyaltyPoints> findByUserIsCurrentUser();

}
