package io.dynamos.repositories;

import io.dynamos.entities.Manufacturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by adelmo on 22/04/17.
 */
public interface ManufacturerRepository extends MongoRepository<Manufacturer, String> {

    Page<Manufacturer> findAllByNameContainingIgnoreCase(Pageable pageable, String name);
}
