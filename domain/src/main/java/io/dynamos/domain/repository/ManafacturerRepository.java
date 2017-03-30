package com.dynamos.domain.repository;

import com.dynamos.domain.entity.Manafacturer;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Spring Data JPA repository for the Manafacturer entity.
 */
public interface ManafacturerRepository extends JpaRepository<Manafacturer, Long> {

}
