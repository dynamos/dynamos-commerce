package io.dynamos.domain.repository;

import io.dynamos.domain.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
