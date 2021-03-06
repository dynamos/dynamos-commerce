package io.dynamos.repositories;

import io.dynamos.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by adelmo on 22/04/17.
 */
public interface ProductRepositoy extends MongoRepository<Product, String> {
    Product findByName(String title);

    Integer countByManufacturer(String id);

    Product findByModel(String model);

    Page<Product> findAllByNameContainingIgnoreCase(Pageable pageable, String name);
}
