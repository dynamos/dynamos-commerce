package io.dynamos.domain.repository;

import io.dynamos.domain.entity.PromotionalCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Spring Data JPA repository for the PromotionalCode entity.
 */
public interface PromotionalCodeRepository extends JpaRepository<PromotionalCode, Long> {

    @Query("select promotionalCode from PromotionalCode promotionalCode where promotionalCode.userCreated.login = ?#{principal.username}")
    List<PromotionalCode> findByUserCreatedIsCurrentUser();

    @Query("select distinct promotionalCode from PromotionalCode promotionalCode left join fetch promotionalCode.customerCanUse left join fetch promotionalCode.productCategory left join fetch promotionalCode.products")
    List<PromotionalCode> findAllWithEagerRelationships();

    @Query("select promotionalCode from PromotionalCode promotionalCode left join fetch promotionalCode.customerCanUse left join fetch promotionalCode.productCategory left join fetch promotionalCode.products where promotionalCode.id =:id")
    PromotionalCode findOneWithEagerRelationships(@Param("id") Long id);

}
