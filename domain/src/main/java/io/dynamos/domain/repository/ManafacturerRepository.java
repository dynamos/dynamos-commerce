package io.dynamos.domain.repository;

import io.dynamos.domain.entity.Manafacturer;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Spring Data JPA repository for the Manafacturer entity.
 */
public interface ManafacturerRepository extends JpaRepository<Manafacturer, Long> {

}
