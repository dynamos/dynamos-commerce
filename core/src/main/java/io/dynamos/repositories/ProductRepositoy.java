package io.dynamos.repositories;

import io.dynamos.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by adelmo on 22/04/17.
 */
public interface ProductRepositoy extends MongoRepository<Product, String> {
}
