package com.dynamos.domain.repository;

import com.dynamos.domain.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Spring Data JPA repository for the Wishlist entity.
 */
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    @Query("select wishlist from Wishlist wishlist where wishlist.customer.login = ?#{principal.username}")
    List<Wishlist> findByUserIsCurrentUser();

    @Query("select distinct wishlist from Wishlist wishlist left join fetch wishlist.products")
    List<Wishlist> findAllWithEagerRelationships();

    @Query("select wishlist from Wishlist wishlist left join fetch wishlist.products where wishlist.id =:id")
    Wishlist findOneWithEagerRelationships(@Param("id") Long id);

}
