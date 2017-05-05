package io.dynamos.repositories;

import io.dynamos.entities.ProductCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by adelmo.pereira on 05/05/2017.
 */
public interface ProductCategoryRepository extends MongoRepository<ProductCategory, String> {
}
